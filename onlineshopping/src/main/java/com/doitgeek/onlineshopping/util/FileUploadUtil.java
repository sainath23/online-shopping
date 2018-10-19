package com.doitgeek.onlineshopping.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtil {

	private final static String ABS_PATH = "E:\\workspace-sts\\online-shopping\\onlineshopping\\src\\main\\webapp\\assets\\images\\";
	private static String REAL_PATH = "";
	private final static Logger LOGGER = LoggerFactory.getLogger(FileUploadUtil.class);
	
	public static void uploadFile(HttpServletRequest request, MultipartFile file, String code) {
		// Get real path
		REAL_PATH = request.getSession().getServletContext().getRealPath("/assets/images/");
		LOGGER.info("Real path: " + REAL_PATH);
		
		// to make sure all the directories exists
		if(!new File(ABS_PATH).exists()) {
			// Create the directories
			new File(ABS_PATH).mkdir();
		}
		if(!new File(REAL_PATH).exists()) {
			// Create the directories
			new File(REAL_PATH).mkdir();
		}
		
		try {
			// Server upload
			file.transferTo(new File(REAL_PATH + code + ".jpg"));
			// Project dir upload
			file.transferTo(new File(ABS_PATH + code + ".jpg"));
		}
		catch(IOException e) {
			LOGGER.error(e.getMessage(), e);
		}
	}
}
