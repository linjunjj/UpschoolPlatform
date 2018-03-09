package com.linjun.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 林俊
 * @create 2018/3/9.
 * @desc
 **/
public class JsonDateSerializer extends JsonSerializer<Long> {
    private SimpleDateFormat dataFormat=new SimpleDateFormat("yyyy-MM-dd");
    @Override
    public void serialize(Long aLong, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (aLong.toString().length()<13) {
         aLong=aLong*1000L;
        }
        Date date=new Date(aLong);
        String value=dataFormat.format(date);
         jsonGenerator.writeString(value);
    }
}
