package com.linjun.oss;

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


}
