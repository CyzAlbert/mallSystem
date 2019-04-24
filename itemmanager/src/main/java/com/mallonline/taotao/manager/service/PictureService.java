package com.mallonline.taotao.manager.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface PictureService {
	Map uploadFile(MultipartFile uploadFile) throws Exception;
}
