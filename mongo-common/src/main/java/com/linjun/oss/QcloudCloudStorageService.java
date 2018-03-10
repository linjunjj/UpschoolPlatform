package com.linjun.oss;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.linjun.utils.RRException;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.request.UploadFileRequest;
import com.qcloud.cos.sign.Credentials;
import org.apache.commons.io.IOUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author 林俊
 * @create 2018/3/10.
 * @desc
 **/
public class QcloudCloudStorageService extends  CloudStorageService {
    private COSClient client;

    public QcloudCloudStorageService(CloudStorageConfig config) {
        this.cloudStorageConfig=config;
        init();
    }

    private void init() {
        Credentials credentials=new Credentials(cloudStorageConfig.getQcloudAppId(),cloudStorageConfig.getQcloudSecretId(),cloudStorageConfig.getQcloudSecretKey());
        ClientConfig clientConfig=new ClientConfig();
        clientConfig.setRegion(cloudStorageConfig.getQcloudRegion());
        client = new COSClient(clientConfig, credentials);
    }

    @Override
    public String upload(MultipartFile file) throws Exception {
        String fileName=file.getOriginalFilename();
        String prefix=fileName.substring(fileName.lastIndexOf("."+1));
        return upload(file.getBytes(),getPath(cloudStorageConfig.getAliyunPrefix()+"."+prefix));
    }

    @Override
    public String upload(byte[] data, String path) {
        if (!path.startsWith("/")) {
            path = "/" + path;
        }

        //上传到腾讯云
        UploadFileRequest request = new UploadFileRequest(cloudStorageConfig.getQcloudBucketName(), path, data);
        String response = client.uploadFile(request);

        JSONObject jsonObject = JSON.parseObject(response);
        if (jsonObject.getIntValue("code") != 0) {
            throw new RRException("文件上传失败，" + jsonObject.getString("message"));
        }

        return cloudStorageConfig.getQcloudDomain() + path;
    }

    @Override
    public String upload(InputStream inputStream, String path) {
        try {
            byte[] data= IOUtils.toByteArray(inputStream);
            return  this.upload(data,path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
