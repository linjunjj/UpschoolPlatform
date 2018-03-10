package com.linjun.oss;

import com.linjun.utils.RRException;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.apache.commons.io.IOUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author 林俊
 * @create 2018/3/10.
 * @desc
 **/
public class QiniuCloudStorageService extends  CloudStorageService {
    private UploadManager uploadManager;
    private  String token;

    public QiniuCloudStorageService(CloudStorageConfig config) {
        this.cloudStorageConfig=config;
        init();
    }
    private  void init(){
        uploadManager=new UploadManager(new Configuration(Zone.autoZone()));
        token= Auth.create(cloudStorageConfig.getQiniuAccessKey(),cloudStorageConfig.getQcloudSecretKey()).uploadToken(cloudStorageConfig.getQiniuBucketName());
    }


    @Override
    public String upload(MultipartFile file) throws Exception {
        String fileName=file.getOriginalFilename();
        String prefix=fileName.substring(fileName.lastIndexOf(".")+1);
        return upload(file.getBytes(),getPath(cloudStorageConfig.getAliyunPrefix()+"."+prefix));
    }

    @Override
    public String upload(byte[] data, String path) {
        Response res= null;
        try {
            res = uploadManager.put(data,path,token);
            if (!res.isOK()){
                throw new RuntimeException("七牛云上传出错"+res.toString());

            }

        } catch (QiniuException e) {
            e.printStackTrace();
            throw new RRException("上传文件失败，请检查七牛云的配置",e);
        }
        return  cloudStorageConfig.getQiniuDomain()+"/"+path;
    }

    @Override
    public String upload(InputStream inputStream, String path)  {
        try {
            byte[] data=IOUtils.toByteArray(inputStream);
            return this.upload(data,path);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RRException("上传文件失败",e);
        }

    }
}
