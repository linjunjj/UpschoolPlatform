package com.linjun.oss;

import com.baidubce.auth.DefaultBceCredentials;
import com.baidubce.services.bos.BosClient;
import com.baidubce.services.bos.BosClientConfiguration;
import com.linjun.utils.RRException;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * @author 林俊
 * @create 2018/3/10.
 * @desc
 **/
public class BaiduCloudStorageService  extends  CloudStorageService  {
  private BosClient bosClient;

    public BaiduCloudStorageService(CloudStorageConfig config) {
        this.cloudStorageConfig=config;
        init();
    }

    private void init() {
        BosClientConfiguration baiduconfig = new BosClientConfiguration();
        baiduconfig.setCredentials(new DefaultBceCredentials(cloudStorageConfig.getBaiduAccessKey(),cloudStorageConfig.getBaiduSecretKey()));
       bosClient=new BosClient(baiduconfig);
    }

    @Override
    public String upload(MultipartFile file) throws Exception {
        String fileName = file.getOriginalFilename();
        String prefix = fileName.substring(fileName.lastIndexOf(".") + 1);
        return upload(file.getBytes(), getPath(cloudStorageConfig.getAliyunPrefix()) + "." + prefix);
    }

    @Override
    public String upload(byte[] data, String path) {
        return upload(new ByteArrayInputStream(data), path);
    }

    @Override
    public String upload(InputStream inputStream, String path) {
        try {
            bosClient.putObject(cloudStorageConfig.getAliyunBucketName(), path, inputStream);
        } catch (Exception e) {
            throw new RRException("上传文件失败，请检查配置信息", e);
        }

        return cloudStorageConfig.getAliyunDomain() + "/" + path;
    }
}
