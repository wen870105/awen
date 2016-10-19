package com.wen.util;

import java.lang.reflect.Field;
import java.util.Properties;

import net.sf.cglib.core.DebuggingClassWriter;
/**
 * 
 * @author Wen
 *
 * @CreateDate 2016年9月12日
 */
public class ProxyFileUtils {

	/**
	 * Java动态代理。让下面代码在代理类执行前执行，然后刷新项目，在其根目录下可以看到形如"$Proxy0.class" 文件，再使用反编译工具解析即可。
	 * 
	 * @throws Exception
	 */
	public static void saveGeneratedJdkProxyFiles() throws Exception {

		Field field = System.class.getDeclaredField("props");

		field.setAccessible(true);

		Properties props = (Properties) field.get(null);

		props.put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

	}

	/**
	 * Cglib代理。让下面代码在代理类执行前执行，然后刷新项目，在指定目录dir下可以看到形如 "类名$$EnhancerByCGLIB$$数字.class" 文件，再使用反编译工具解析即可。
	 * 
	 * @throws Exception
	 */
	public static void saveGeneratedCGlibProxyFiles() throws Exception {

		Field field = System.class.getDeclaredField("props");

		field.setAccessible(true);

		Properties props = (Properties) field.get(null);

		System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "d:\\temp");// dir为保存文件路径

		props.put("net.sf.cglib.core.DebuggingClassWriter.traceEnabled", "true");

	}
}
