package com.mallonline.taotao.portal.service;

import com.mallonline.taotao.portal.entity.TbUser;

public interface UserService {
	TbUser getUserByToken(String token);
}
