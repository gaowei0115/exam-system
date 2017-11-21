package com.exam.system.common.utils;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.ser.CustomSerializerFactory;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @packageName：com.exam.system.common.utils
 * @desrciption: 解决Date类型返回json格式为自定义格式
 * @author: gaowei
 * @date： 2017-11-21 16:24
 * @history: (version) author date desc
 */
public class CustomObjectMapper extends ObjectMapper{

    private static final String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public CustomObjectMapper() {
        CustomSerializerFactory factory = new CustomSerializerFactory();
        factory.addGenericMapping(Date.class, new JsonSerializer<Date>() {
            @Override
            public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
                SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_FORMAT);
                jsonGenerator.writeString(sdf.format(date));
            }
        });
        this.setSerializerFactory(factory);
    }
}
