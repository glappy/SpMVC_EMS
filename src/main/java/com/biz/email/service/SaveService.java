package com.biz.email.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.biz.email.mapper.MailDao;
import com.biz.email.model.MailVO;

@Service
public class SaveService {

	@Autowired
	ServletContext context;
	
	@Autowired
	SendMailService sMail;
	
	@Autowired
	MailDao mDao;
	
	public void save(MailVO mailVO, MultipartHttpServletRequest files) {
		
		List<MultipartFile> fileList = files.getFiles("files");
		
		try {
			String fileName1 = fileUp(fileList.get(0));
			mailVO.setS_file1(fileName1);
			
			String fileName2 = fileUp(fileList.get(1));
			mailVO.setS_file2(fileName2);

		} catch (Exception e) {
		}
		long id = mailVO.getId();
		if(id > 0) { 
			mDao.update(mailVO);
		} else {
			mDao.insert(mailVO);
			sMail.sendMail(mailVO);
		}
	}
	
	public String fileUp(MultipartFile file) {
		
		String realFile = file.getOriginalFilename();
		String realPath = context.getRealPath("/files/");
		
		File dir = new File(realPath);
		if(dir.exists() != true) { 
			dir.mkdir(); 
		}
		
		if(file.isEmpty()) { 
			return null;
		}
		
		String saveFile = UUID.randomUUID().toString();
		saveFile += realFile;
		
		File upFile = new File(realPath, saveFile);
		
		try {
			file.transferTo(upFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return saveFile ; 
	}
}