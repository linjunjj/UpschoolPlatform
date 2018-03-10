package com.linjun.oss;

import com.linjun.utils.DateUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.UUID;

/**
 * @author 林俊
 * @create 09 08:35
 * @desc
 **/
public abstract class CloudStorageService {
    CloudStorageConfig cloudStorageConfig;
      public  String getPath(String prefix){
          String uuid= UUID.randomUUID().toString().replaceAll("-","");
          String path= DateUtils.format(new Date(),"yyyyMMdd")+"/"+DateUtils.format(new Date(),"HHmmssS")+uuid.substring(0,5);
       if (StringUtils.isNotBlank(prefix)){
           path=prefix+"/"+path;
       }
        return  path;
      }
     public  abstract  String upload(MultipartFile file) throws  Exception;
      public  abstract  String upload(byte[] data,String path) ;
      public  abstract  String upload(InputStream inputStream,String path);

}
