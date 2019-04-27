package com.biz.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.biz.email.model.MailVO;
import com.biz.email.service.SaveService;

@Controller
public class SaveController {
	
	@Autowired
	SaveService sService;

	@RequestMapping(value="save",method=RequestMethod.POST)
	public String save(@ModelAttribute MailVO mailVO,
					MultipartHttpServletRequest files) {
		
		
		sService.save(mailVO, files);
		
		return "redirect:/" ;
	}

}
