package com.snail2lb.web.common.beans;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.SerializationUtils;

import net.sf.cglib.beans.BeanCopier;
import net.sf.cglib.core.Converter;


/**
 * Created by lvbiao on 2017/10/9.
 * 此工具类主要用于bean属性拷贝
 * TODO 缓存暂时没加
 */
public class BeanCopyUtil {

    /*缓存*/
    private static Map<Class,Map<Class, net.sf.cglib.beans.BeanCopier>> beanCopierCache = new HashMap();

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
        //BeanUtils.copyProperties( from, to);
        copyTo(from, to,null);

        return to;
    }

    public static <T> T copyTo(Object from, T to, Converter converter){
        if (from==null||to==null){
            return null;
        }

        Class fromClass = from.getClass();
        Class<T> toClass = (Class<T>) to.getClass();

        BeanCopier beanCopier = getBeanCopier(fromClass,toClass);

        beanCopier.copy(from,to,converter);

        return to;
    }

    private static BeanCopier getBeanCopier(Class fromClass, Class toClass) {
        Map<Class,BeanCopier> beanCopierMap = beanCopierCache.get(fromClass);

        if (beanCopierMap==null){
            synchronized (BeanCopyUtil.class) {
                beanCopierMap = beanCopierCache.get(fromClass);
                if (beanCopierMap==null){
                    beanCopierMap = new HashMap();
                    beanCopierCache.put(fromClass,beanCopierMap);
                }
            }
        }

        BeanCopier beanCopier = beanCopierMap.get(toClass);

        if (beanCopier==null){
            synchronized (BeanCopyUtil.class) {
                beanCopier = beanCopierMap.get(toClass);
                if (beanCopier == null){
                    beanCopier = BeanCopier.create(fromClass,toClass,false);
                    beanCopierMap.put(toClass,beanCopier);
                }
            }
        }

        return beanCopier;
    }
}
