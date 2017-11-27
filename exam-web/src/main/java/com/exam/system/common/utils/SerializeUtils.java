package com.exam.system.common.utils;

import com.exam.system.common.log.impl.CommonLogger;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @packageName：com.exam.system.common.utils
 * @desrciption: 序列化工具
 * @author: gaowei
 * @date： 2017-11-27 15:31
 * @history: (version) author date desc
 */
public class SerializeUtils {

    /**
     * logger
     */
    private static final CommonLogger log = new CommonLogger(SerializeUtils.class);

    /**
     * 执行对象序列化
     * @param value
     * @return
     */
    public static byte[] serialize(Object value) {
        if (value == null) {
            throw new IllegalArgumentException("Can't serialize null");
        }
        byte[] bytes = null;
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        try {
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(value);
            bytes = bos.toByteArray();
        } catch (Exception e) {
            log.error("序列化对象异常 {}", value);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
                if (bos != null) {
                    bos.close();
                }
            } catch (Exception e1) {
                log.error("序列化对象流关闭异常");
            }
        }
        return bytes;
    }

    /**
     * 反序列化
     * @param param
     * @return
     */
    public static Object deserialize(byte[] param) {
       return deserialize(param, Object.class);
    }

    /**
     *  反序列化
     * @param param
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T deserialize(byte[] param, Class<T> clazz) {
        Object result = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        try {
            if (param != null) {
                bis = new ByteArrayInputStream(param);
                ois = new ObjectInputStream(bis);
                result = ois.readObject();
            }
        }  catch (Exception e) {
            log.error("反序列化对象异常 {}", clazz);
        } finally {
            try {
                if (bis != null) {
                    bis.close();
                }
                if (ois != null) {
                    ois.close();
                }
            } catch (Exception e1) {
                log.error("反序列化对象流关闭异常");
            }
        }
        return (T)result;
    }
}
