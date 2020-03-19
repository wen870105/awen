package com.tcshare.generic.demo;

/**
 * 
 * 
 * @author wsy48420
 * @version $Id: IResolver.java, v 0.1 2018年8月30日 下午8:08:27 wsy48420 Exp $
 */
public interface IResolver {
    public void resolve(INBKeyValueVO vo);
    
    public String getKey();
}
