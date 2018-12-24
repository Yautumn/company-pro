package com.yautumn.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ImageUtil {
	
	public final static Logger LOGGER  = LoggerFactory.getLogger(ImageUtil.class);
	
	/**
	 * 	读取本地图片获取输入流
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public static FileInputStream readImage(String path) throws IOException{
		return new FileInputStream(new File(path));
	}
	/**
	 * 	读取表中图片
	 * @param inputStream
	 * @param targetPath
	 */
	public static void readBin2Image(InputStream inputStream,String targetPath) {
		File file = new File(targetPath);
		String path = targetPath.substring(0, targetPath.lastIndexOf("/"));
		if (!file.exists()) {
			new File(path).mkdirs();
		}
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(file);
			int len = 0;
			byte[] buf = new byte[1024];
			while((len = inputStream.read(buf)) != -1) {
				fileOutputStream.write(buf, 0, len);
			}
			fileOutputStream.flush();
		} catch (Exception e) {
			LOGGER.info("图片读取失败{ }",e);
			e.printStackTrace();
		} finally {
			if(null != fileOutputStream) {
				try {
					fileOutputStream.close();
				} catch (Exception e2) {
					LOGGER.info("释放文件输出流异常{}",e2);
					e2.printStackTrace();
				}
			}
		}
	}
	
}
