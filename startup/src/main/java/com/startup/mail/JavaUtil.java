package com.startup.mail;

import com.startup.mail.MailSender; 
import com.startup.mail.MailSenderDto; 

public class JavaUtil {
         /**
          * 发送邮件
          */ 
         public void sendEmail(String email, String password) { 
                   try{ 
                              String mailTitle="【生涯通】账号激活邮件"; 
                              String mailContent="<br><br>亲爱的【生涯通】用户:<br><br>"+ 
                                                 "    您好！感谢您使用【生涯通】，"+ 
                                                 "    您的Email："+email+"<br><br>"+ 
                                                 "    您的密码："+password+"<br><br>"+
                                                 "    Email可以作为您的帐号来登录【生涯通】。<br><br>"+ 
                                                 "    本邮件是系统自动发送的，请勿直接回复！感谢您的访问，祝您使用愉快！<br><br>"+ 
                                                 "    【生涯通】服务中心"; 
                              MailSenderDto mailInfo = new MailSenderDto();    
                             mailInfo.setMailServerHost("smtp.126.com");    
                             mailInfo.setMailServerPort("25");    
                              mailInfo.setValidate(true);    
                             mailInfo.setUserName("liu_feng0717@126.com");    
                              mailInfo.setPassword("mingyuehengxin");//您的邮箱密码    
                              mailInfo.setFromAddress("liu_feng0717@126.com");    //发件人邮箱地址 
                              mailInfo.setToAddress(email);      //收件人邮箱地址 
                              mailInfo.setSubject(mailTitle);    
                              mailInfo.setContent(mailContent);    
                              //这个类主要来发送邮件   
                              MailSender ms = new MailSender();   
                              ms.sendHtmlMail(mailInfo);//发送html格式   
                   }catch(Exception e){ 
                            
                            System.out.println("失败了！"); 
                   } 
    } 
} 

/*String mailTitle="【我的网盘】账号激活邮件"; 
String mailContent="<br><br>亲爱的【我的网盘】用户:<br><br>"+ 
                                             "    您好！感谢您注册【我的网盘】帐号，点击下面的链接即可完成注册：<br><br>"+ 
                                             "    <ahref=\"http://localhost:9080/mydisk/swf/activateEmail.html#email="+email+"\">http://localhost:9080/mydisk/swf/activateEmail.html#email="+email+"</a><br><br>"+ 
                                             "    (如果链接无法点击，请将它复制并粘贴到浏览器的地址栏中访问)<br><br>"+ 
                                             "    您的Email："+email+"<br><br>"+ 
                                            "    Email可以作为您的帐号来登录【我的网盘】。<br><br>"+ 
                                             "    本邮件是系统自动发送的，请勿直接回复！感谢您的访问，祝您使用愉快！<br><br>"+ 
                                             "    【我的网盘】服务中心"; */