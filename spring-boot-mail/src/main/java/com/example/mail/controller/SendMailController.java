package com.example.mail.controller;

import com.example.mail.utils.BaseUtils;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.mail.service.SendMailService;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.thymeleaf.util.DateUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/mail/")
public class SendMailController {
	@Autowired
	private SendMailService sendMailService;


	@GetMapping("/send")
	public String sendMail() {
		List<String> mailList = new ArrayList<>();
		mailList.add("787004717@qq.com");
		mailList.add("531243175@qq.com");
		String text = "这是一封由Spring Boot应用程序自动发送的测试邮件，无可用信息，请直接删除。";
		int i=0;
		for (String email : mailList) {
			String subject = String.format("你好，%s",email);
			sendMailService.sendMail(email, subject, text);
			i++;
		}

		return String.format("成功给%s个邮箱发送短信",i);
	}

	@PostMapping("/sendAttachMail")
	public String sendAttachMail(@RequestParam("file") MultipartFile multipartFile, @RequestParam("content") String content, HttpServletRequest httpServletRequest) {
		List<String> mailList = new ArrayList<>();
		mailList.add("787004717@qq.com");
		mailList.add("531243175@qq.com");

		try {
			String fileName = DateUtils.format(new Date(),"yyyyMMddHHmmss", Locale.CHINESE) +multipartFile.getOriginalFilename();
			String path = "/files/test/"+fileName;
			File f = BaseUtils.saveAndgetFile(path,multipartFile.getInputStream());
			int i=0;

			for (String email : mailList) {
				String subject = String.format("你好，%s",email);
				sendMailService.sendAttachMentMail(email, subject, content, f);
				i++;
			}

			return String.format("成功给%s个邮箱发送HTML带附件邮件",i);
		} catch (IOException e) {
			e.printStackTrace();
		}


		return null;
		
	}

}
