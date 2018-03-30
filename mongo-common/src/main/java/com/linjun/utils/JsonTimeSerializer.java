package com.linjun.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class JsonTimeSerializer extends JsonSerializer<Long> {
	   private SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	   @Override  
	   public void serialize(Long datel, JsonGenerator gen, SerializerProvider provider)  throws IOException, JsonProcessingException {
		   if(datel.toString().length()<13){
		       datel= datel*1000L;
		   }
	       Date date= new Date(datel);
	       String value = dateFormat.format(date);  
	       gen.writeString(value);  
	   }  
	}  
