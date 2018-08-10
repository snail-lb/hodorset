package com.snail2lb.web.common.beans;

import java.io.Serializable;

import org.apache.commons.lang3.SerializationUtils;
import org.springframework.beans.BeanUtils;


/**
 * Created by lvbiao on 2017/10/9.
 * 此工具类主要用于bean属性拷贝
 * TODO 缓存暂时没加
 */
public class BeanCopyUtil {

    /**
     * 属性的深拷贝, 这个的性能你懂得.
     * 注意!!!调用这个方法的所有属性 都必须实现 Serializable接口
     * @param from
     * @param to
     * @param <T>
     * @return
     */
    public static <T> T deepCopyTo(Serializable from, Serializable to){
        from = SerializationUtils.clone(from);
        return copyTo(from, (T) to);
    }

    /**
     * 
     * 属性拷贝
     * @param from
     * @param to
     * @param <T>
     * @return
     */
    public static <T> T copyTo(Object from,T to){
        if(null == from || null == to){
            return null;
        }
        BeanUtils.copyProperties( from, to);
        return to;
    }
}
