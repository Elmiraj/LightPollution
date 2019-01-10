package com.zj.lightpollution.utils;

import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.regex.Pattern;

public class ReflectHelper {
    private Class cls;
    private Object obj;
    private Hashtable<String, Method> getMethods = null;
    private Hashtable<String, Method> setMethods = null;

    public ReflectHelper(Object o) {
        this.obj = o;
        this.initMethods();
    }

    public void initMethods() {
        this.getMethods = new Hashtable();
        this.setMethods = new Hashtable();
        this.cls = this.obj.getClass();
        Method[] methods = this.cls.getMethods();
        String gs = "get(\\w+)";
        Pattern getM = Pattern.compile(gs);
        String ss = "set(\\w+)";
        Pattern setM = Pattern.compile(ss);
        String rapl = "$1";

        for(int i = 0; i < methods.length; ++i) {
            Method m = methods[i];
            String methodName = m.getName();
            String param;
            if (Pattern.matches(gs, methodName)) {
                param = getM.matcher(methodName).replaceAll(rapl).toLowerCase();
                this.getMethods.put(param, m);
            } else if (Pattern.matches(ss, methodName)) {
                param = setM.matcher(methodName).replaceAll(rapl).toLowerCase();
                this.setMethods.put(param, m);
            }
        }

    }

    public boolean setMethodValue(String property, Object object) {
        Method m = (Method)this.setMethods.get(property.toLowerCase());
        if (m != null) {
            try {
                m.invoke(this.obj, object);
                return true;
            } catch (Exception var5) {
                return false;
            }
        } else {
            return false;
        }
    }

    public Object getMethodValue(String property) {
        Object value = null;
        Method m = (Method)this.getMethods.get(property.toLowerCase());
        if (m != null) {
            try {
                value = m.invoke(this.obj);
            } catch (Exception var5) {
            }
        }

        return value;
    }

    public Method returnGetMethod(String property) {
        return (Method)this.getMethods.get(property.toLowerCase());
    }

    public Method returnSetMethod(String property) {
        return (Method)this.setMethods.get(property.toLowerCase());
    }
}
