package com.mallonline.taotao.manager.controller;

import com.mallonline.taotao.manager.common.utils.JsonUtils;
import com.mallonline.taotao.manager.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
public class PictureController {
	@Autowired
	private PictureService pictureService;
	
	@RequestMapping(value="/pic/upload")
	public String pictureUpload(MultipartFile uploadFile){
		try {
			Map result;
			result= pictureService.uploadFile(uploadFile);
			//java Object转JSON 格式字符串
			String json=JsonUtils.objectToJson(result);
			return json;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
}
