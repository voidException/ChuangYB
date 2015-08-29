package com.startup.controller;


import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.qiniu.util.Auth;
import com.startup.service.StudentClassService;
import com.startup.service.TeacherClassService;
import com.startup.util.GetPrivateAuth;
import com.startup.vo.BaseVo;
import com.startup.vo.PhotoUploadVo;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

@Controller
@RequestMapping("/photo")
public class PhotoUploadController {
	@RequestMapping(value = "/upload/getToken", method = RequestMethod.GET)
	public @ResponseBody BaseVo photoUpload(String bucket) {
		GetPrivateAuth getPrivateAuth = new GetPrivateAuth();
		String uploadToken = getPrivateAuth.uploadToken(bucket);
		BaseVo baseVo = new BaseVo();
		baseVo.setError(0);
		baseVo.setErrorMessage(uploadToken);
		return baseVo;
	}
	/*@Resource
	StudentClassService studentClassService;
	
	@Resource
	TeacherClassService teacherClassService;
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public @ResponseBody BaseVo photoUpload(@RequestBody PhotoUploadVo photoUploadVo) throws IOException {
		
		int isStudentOrTeacher = photoUploadVo.getIsStudentOrTeacher();
		int id = photoUploadVo.getId();
		String form = photoUploadVo.getForm();
		File fileData = photoUploadVo.getFileData();
		BaseVo baseVo = new BaseVo();
		
		if(isStudentOrTeacher == 0 && studentClassService.IfStuIdExist(id) == 1) {
			if(fileData == null) {
				baseVo.setError(1);
				baseVo.setErrorMessage("学生存在但是上传出错");
			}else {
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
				String dateString = simpleDateFormat.format(new Date());
				
				WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();    
		        ServletContext servletContext = webApplicationContext.getServletContext(); 
		        
				File uploadImageDir = new File(servletContext.getRealPath("/startup/resources/studentPhoto/" + dateString));
				if (!uploadImageDir.exists())
					uploadImageDir.mkdirs();
				
				String uploadImagePath = "/startup/resources/studentPhoto/" + dateString + "/" + id + form;
				File file = new File(servletContext.getRealPath(uploadImagePath));
				FileUtils.copyFile(fileData, file);
				
				baseVo.setError(3);
				baseVo.setErrorMessage(uploadImagePath);
				
				studentClassService.UpdateStudentPhoto(uploadImagePath, id);
			}
		}else if(isStudentOrTeacher == 1 && teacherClassService.IfTeacherIdExist(id) == 1) {
			if(fileData == null) {
				baseVo.setError(2);
				baseVo.setErrorMessage("老师存在但是上传出错");
			}else {
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
				String dateString = simpleDateFormat.format(new Date());
				
				WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();    
		        ServletContext servletContext = webApplicationContext.getServletContext(); 
		        
				File uploadImageDir = new File(servletContext.getRealPath("/startup/resources/teacherPhoto/"+ dateString));
				if (!uploadImageDir.exists())
					uploadImageDir.mkdirs();
				
				String uploadImagePath = "/startup/resources/teacherPhoto/" + dateString + "/" + id + form;
				File file = new File(servletContext.getRealPath(uploadImagePath));
				FileUtils.copyFile(fileData, file);
				
				baseVo.setError(3);
				baseVo.setErrorMessage(uploadImagePath);
				
				teacherClassService.UpdateTeacherPhoto(uploadImagePath, id);
			}
		}else {
			baseVo.setError(0);
			baseVo.setErrorMessage("老师或者学生不存在");
		}
		return baseVo;
	}*/
}
