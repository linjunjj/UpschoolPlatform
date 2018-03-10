package com.linjun.oss;

import com.linjun.utils.DateUtils;

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
          String path= DateUtils.format(new Date(),"yyyyMMdd")+"/"+DateUtils.format()

      }


}
