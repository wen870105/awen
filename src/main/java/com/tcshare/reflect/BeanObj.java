package com.tcshare.reflect;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;

public class BeanObj {
    private String  name;
    private boolean success;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSuccess() {
        System.out.println("success=" + success);
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean getSuccess() {
        return success;
    }

    @Override
    public String toString() {
        return "name=" + name;
    }

    public static void main(String[] args) throws Exception {
        BeanObj obj = new BeanObj();
        obj.setName("test");
        obj.setSuccess(false);
        Field[] fs = BeanObj.class.getDeclaredFields();
        for (Field f : fs) {
            System.out.println("name=" + f.getName() + "_type=" + f.getType());
            PropertyDescriptor pd = new PropertyDescriptor(f.getName(), BeanObj.class);
            System.out.println(pd.getReadMethod());
            //            pd.getReadMethod().invoke(obj, null);
            System.out.println(pd.getWriteMethod());
            System.out.println("");

        }
    }
}
