package com.zj.lightpollution.utils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import jodd.bean.BeanTool;
import jodd.bean.BeanUtil;
import jodd.util.StringUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.DynaProperty;
import org.apache.commons.beanutils.PropertyUtils;

/**
 * MyBeanUtils class
 * @author junzhang
 * @date 2019-01-05
 */

public class MyBeanUtils extends BeanUtils {
    private static void convert(Object dest, Object orig) throws IllegalAccessException, InvocationTargetException {
        if (dest == null) {
            throw new IllegalArgumentException("No destination bean specified");
        } else if (orig == null) {
            throw new IllegalArgumentException("No origin bean specified");
        } else {
            int i;
            String name;
            Object value;
            if (orig instanceof DynaBean) {
                DynaProperty[] origDescriptors = ((DynaBean)orig).getDynaClass().getDynaProperties();

                for(i = 0; i < origDescriptors.length; ++i) {
                    name = origDescriptors[i].getName();
                    if (PropertyUtils.isWriteable(dest, name)) {
                        value = ((DynaBean)orig).get(name);

                        try {
                            copyProperty(dest, name, value);
                        } catch (Exception var10) {
                            var10.printStackTrace();
                        }
                    }
                }
            } else if (orig instanceof Map) {

                for (Object o : ((Map) orig).keySet()) {
                    name = (String) o;
                    if (PropertyUtils.isWriteable(dest, name)) {
                        value = ((Map) orig).get(name);

                        try {
                            copyProperty(dest, name, value);
                        } catch (Exception var9) {
                            var9.printStackTrace();
                        }
                    }
                }
            } else {
                PropertyDescriptor[] origDescriptors = PropertyUtils.getPropertyDescriptors(orig);

                for(i = 0; i < origDescriptors.length; ++i) {
                    name = origDescriptors[i].getName();
                    if (!"class".equals(name) && PropertyUtils.isReadable(orig, name) && PropertyUtils.isWriteable(dest, name)) {
                        try {
                            value = PropertyUtils.getSimpleProperty(orig, name);
                            copyProperty(dest, name, value);
                        } catch (Exception var7) {
                            var7.printStackTrace();
                        }
                    }
                }
            }

        }
    }

    public static void copyBeanNotNull2Bean(Object databean, Object tobean) throws Exception {
        PropertyDescriptor[] origDescriptors = PropertyUtils.getPropertyDescriptors(databean);

        for (PropertyDescriptor origDescriptor : origDescriptors) {
            String name = origDescriptor.getName();
            if (!"class".equals(name) && PropertyUtils.isReadable(databean, name) && PropertyUtils.isWriteable(tobean, name)) {
                try {
                    Object value = PropertyUtils.getSimpleProperty(databean, name);
                    if (StringUtil.isNotEmpty(String.valueOf(value))) {
                        copyProperty(tobean, name, value);
                    }
                } catch (Exception var6) {
                    var6.printStackTrace();
                }
            }
        }

    }

    public static void copyBean2Bean(Object dest, Object orig) throws Exception {
        convert(dest, orig);
    }

    public static void copyBean2Map(Map map, Object bean) {
        PropertyDescriptor[] pds = PropertyUtils.getPropertyDescriptors(bean);

        for (PropertyDescriptor pd : pds) {
            String propname = pd.getName();

            try {
                Object propvalue = PropertyUtils.getSimpleProperty(bean, propname);
                map.put(propname, propvalue);
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException var7) {
                var7.printStackTrace();
            }
        }

    }

    public static void copyMap2Bean(Object bean, Map properties) throws IllegalAccessException, InvocationTargetException {
        if (bean != null && properties != null) {
            Iterator names = properties.keySet().iterator();

            while(true) {
                String name;
                do {
                    if (!names.hasNext()) {
                        return;
                    }

                    name = (String)names.next();
                } while(name == null);

                Object value = properties.get(name);

                try {
                    Class clazz = PropertyUtils.getPropertyType(bean, name);
                    if (null != clazz) {
                        String className = clazz.getName();
                        if ((!className.equalsIgnoreCase("java.sql.Timestamp") || value != null && !value.equals("")) && (!className.equalsIgnoreCase("java.math.BigDecimal") || value != null && !value.equals(""))) {
                            setProperty(bean, name, value);
                        }
                    }
                } catch (NoSuchMethodException var7) {
                    var7.printStackTrace();
                }
            }
        }
    }

    public static void copyMap2BeanReflect(Object bean, Map properties) throws Exception {
        if (bean != null && properties != null) {

            for (Object o : properties.keySet()) {
                ReflectHelper reflectHelper = new ReflectHelper(bean);
                String name = (String) o;
                if (name != null) {
                    try {
                        Object value = properties.get(name);
                        reflectHelper.setMethodValue(name, value);
                    } catch (Exception var6) {
                        var6.printStackTrace();
                    }
                }
            }

        }
    }

    public static void copyMap2Bean_Nobig(Object bean, Map properties) throws IllegalAccessException, InvocationTargetException {
        if (bean != null && properties != null) {

            for (Object o : properties.keySet()) {
                String name = (String) o;
                if (name != null) {
                    Object value = properties.get(name);

                    try {
                        if (value != null) {
                            Class clazz = PropertyUtils.getPropertyType(bean, name);
                            if (null != clazz) {
                                String className = clazz.getName();
                                if (className.equalsIgnoreCase("java.util.Date")) {
                                    value = new Date(((Timestamp) value).getTime());
                                }

                                setProperty(bean, name, value);
                            }
                        }
                    } catch (NoSuchMethodException var7) {
                        var7.printStackTrace();
                    }
                }
            }

        }
    }

    public static void copyMap2Bean(Object bean, Map properties, String defaultValue) throws IllegalAccessException, InvocationTargetException {
        if (bean != null && properties != null) {
            Iterator names = properties.keySet().iterator();

            while(true) {
                String name;
                do {
                    if (!names.hasNext()) {
                        return;
                    }

                    name = (String)names.next();
                } while(name == null);

                Object value = properties.get(name);

                try {
                    Class clazz = PropertyUtils.getPropertyType(bean, name);
                    if (null != clazz) {
                        String className = clazz.getName();
                        if (!className.equalsIgnoreCase("java.sql.Timestamp") || value != null && !value.equals("")) {
                            if (className.equalsIgnoreCase("java.lang.String") && value == null) {
                                value = defaultValue;
                            }

                            setProperty(bean, name, value);
                        }
                    }
                } catch (NoSuchMethodException var8) {
                    var8.printStackTrace();
                }
            }
        }
    }

    public MyBeanUtils() {
    }

    public static void apply(Object srcBean, Object dstBean) {
        copy(srcBean, dstBean, (Map)null, (Collection)null, (Collection)null, false);
    }

    public static void sepecialCopy(Object srcBean, Object dstBean, Collection<String> ignoredProps) {
        copy(srcBean, dstBean, (Map)null, ignoredProps, (Collection)null, true);
    }

    private static void copy(Object srcBean, Object dstBean, Map<String, String> revertMap, Collection<String> ignoredProps, Collection<String> props, boolean copyNull) {
        String[] properties = BeanTool.resolveProperties(dstBean, true);
        String[] arr$ = properties;
        int len$ = properties.length;

        for(int i$ = 0; i$ < len$; ++i$) {
            String property = arr$[i$];
            if ((props == null || props.contains(property)) && (ignoredProps == null || !ignoredProps.contains(property))) {
                String srcPropName;
                if (revertMap != null) {
                    srcPropName = (String)revertMap.get(property);
                    if (srcPropName == null) {
                        srcPropName = property;
                    }
                } else {
                    srcPropName = property;
                }

                Object value = BeanUtil.getPropertySilently(srcBean, srcPropName);
                if (value != null || copyNull) {
                    BeanUtil.setPropertySilent(dstBean, property, value);
                }
            }
        }

    }
}
