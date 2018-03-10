package com.linjun.oss;

import com.aliyun.oss.OSSClient;
import com.linjun.utils.RRException;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * @author 林俊
 * @create 2018/3/10.
 * @desc
 **/
public class AliyunCloudStorageService extends  CloudStorageService {
    private OSSClient client;

    public AliyunCloudStorageService(CloudStorageConfig config) {
        this.cloudStorageConfig=config;
        init();
    }

    private void init() {
        client=new OSSClient(cloudStorageConfig.getAliyunEndPoint(),cloudStorageConfig.getAliyunAccessKeyId(),cloudStorageConfig.getAliyunAccessKeySecret());
    }

    @Override
    public String upload(MultipartFile file) throws Exception {
        String fileName=file.getOriginalFilename();
        String prefix=fileName.substring(fileName.lastIndexOf(".")+1);
        return upload(file.getBytes(),getPath(cloudStorageConfig.getAliyunPrefix()+"."+prefix));
    }

    @Override
    public String upload(byte[] data, String path) {
        return upload(new ByteArrayInputStream(data),path);
    }

    @Override
    public String upload(InputStream inputStream, String path) {
        try {
            client.putObject(cloudStorageConfig.getAliyunBucketName(), path, inputStream);
        } catch (Exception e) {
            throw new RRException("上传文件失败，请检查配置信息", e);
        }

        return cloudStorageConfig.getAliyunDomain() + "/" + path;
    }
}
