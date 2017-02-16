package com.test.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;

public class T {
	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();
		String[] arr = { "http://ccp02.oss.aliyuncs.com/ivr_record/4001231174/20161229/R00042ed5_20161229172202.wav",
				"http://ccp02.oss.aliyuncs.com/ivr_record/4001231174/20161229/R00042ecb_20161229172143.wav",
				"http://ccp02.oss.aliyuncs.com/ivr_record/4001231174/20161229/R00042ec9_20161229172147.wav",
				"http://ccp02.oss.aliyuncs.com/ivr_record/4001231174/20161229/R00042eaf_20161229172119.wav",
				"http://ccp02.oss.aliyuncs.com/ivr_record/4001231174/20161229/R00042ea5_20161229172117.wav",
				"http://ccp02.oss.aliyuncs.com/ivr_record/4001231174/20161229/R00042e78_20161229172026.wav",
				"http://ccp02.oss.aliyuncs.com/ivr_record/4001231174/20161229/R00042e52_20161229171951.wav",
				"http://ccp02.oss.aliyuncs.com/ivr_record/4001231174/20161229/R00042e10_20161229171931.wav",
				"http://ccp02.oss.aliyuncs.com/ivr_record/4001231174/20161229/R00042e05_20161229171852.wav",
				"http://ccp02.oss.aliyuncs.com/ivr_record/4001231174/20161229/R00042deb_20161229171825.wav",
				"http://ccp02.oss.aliyuncs.com/ivr_record/4001231174/20161229/R00042ddd_20161229171814.wav" };
		File dir = new File("c:\\test\\");
		URL url;
		File f = null;
		List<File> files = new ArrayList<File>();
		for (int i = 0; i < arr.length; i++) {
			url = new URL(arr[i]);
			f = new File(dir, i + ".wav");
			FileUtils.copyURLToFile(url, f);
		}

		if (f != null) {
			zip("c:\\test\\test.zip", f.getParentFile());

		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	private static void zip(String zipFileName, File dir) {
		System.out.println("压缩中...");
		ZipOutputStream out = null;
		BufferedOutputStream bo = null;
		try {
			out = new ZipOutputStream(new FileOutputStream(zipFileName));
			bo = new BufferedOutputStream(out);
			zip(out, dir);
		} catch (FileNotFoundException e) {
			
		}finally{
			if(bo != null){
				try {
					bo.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(out !=null){
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
		
		System.out.println("压缩完成");
	}

	private static void zip(ZipOutputStream out, File dir) { 
		File[] fl = dir.listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				return pathname.getName().indexOf(".wav") > -1;
			}
		});
		for (int i = 0; i < fl.length; i++) {
			File f = fl[i];
			BufferedInputStream in = null;
			try{
				out.putNextEntry(new ZipEntry(f.getName()));
				in = new BufferedInputStream(new FileInputStream(f));
				int c;
				while ((c = in.read()) != -1) {
					out.write(c);
				}
			}catch(Exception e){
				
			}finally{
				if(in!=null){
					try {
						in.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

}
