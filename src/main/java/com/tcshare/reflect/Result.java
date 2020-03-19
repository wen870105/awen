package com.tcshare.reflect;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

public class Result<T> {
    private boolean success;
    private T       data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static void main(String[] args) {
        String s = "{\"data\":{\"name\":\"data1\"},\"success\":true}";
        
        
        
        
        
        InnerData1 i1 = new InnerData1();
        i1.setName("data1");
        Result<InnerData1> r1 = new Result<>();
        r1.setSuccess(true);
        r1.setData(i1);
        
        TypeReference<Result<InnerData1>> typeReference = new TypeReference<Result<InnerData1>>(){};
        
        Type type = ((ParameterizedType) typeReference.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        System.out.println("type=" +type);
        System.out.println(JSON.toJSONString(r1));

        

        Result<InnerData1> ret = JSON.parseObject(s,new TypeReference<Result<InnerData1>>(){} );
        InnerData1 retInner1 = ret.getData();
        System.out.println(retInner1);
        
        String s2 = "{\"data\":{\"address\":\"address1\"},\"success\":true}";
        Result<InnerData2> ret2 = JSON.parseObject(s2,new TypeReference<Result<InnerData2>>(){} );
        System.out.println(ret2.getData());
        
    }

}
