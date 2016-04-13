package com.market.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


public class FileTools {
	private static final String UPLOADDIR = "uploadDir/";
public static void upload(MultipartHttpServletRequest request) throws Exception{
	
		Map<String, MultipartFile> fileMap = request.getFileMap();

		String uploadDir = request.getSession().getServletContext()
				.getRealPath("/")+UPLOADDIR;
		File file = new File(uploadDir);

		if (!file.exists()) {
			file.mkdir();
		}
		String fileName = null;
		int i = 0; 
		for (Iterator<Map.Entry<String, MultipartFile>> it = fileMap.entrySet()
				.iterator(); it.hasNext(); i++) {

			Map.Entry<String, MultipartFile> entry = it.next();
			MultipartFile mFile = entry.getValue();

			fileName = mFile.getOriginalFilename();

			String storeName = rename(fileName);
			 //创建文件
			  File uploadFile = new File(uploadDir+storeName);

			FileCopyUtils.copy(mFile.getBytes(), uploadFile);

		}
	}


/**
 * 将上传的文件进行重命名
 * 
 * @param name
 * @return
 */
public static String rename(String name) {

	Long now = Long.parseLong(new SimpleDateFormat("yyyyMMddHHmmss")
			.format(new Date()));
	Long random = (long) (Math.random() * now);
	String fileName = now + "" + random;

	if (name.indexOf(".") != -1) {
		fileName += name.substring(name.lastIndexOf("."));
	}

	return fileName;
}

/**
 * 删除本地文件
 * @param path
 */
public static  void deleteAll(File path) {

	if (!path.exists())   //路径不存在
	return;
	if (path.isFile()) {  //是文件
	path.delete();
	return;
	}
	File[] files = path.listFiles();
	for (int i = 0; i < files.length; i++) {
	deleteAll(files[i]);
	}
	path.delete(); 
	}

}
