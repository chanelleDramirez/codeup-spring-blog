//package com.codeup.codeupspringblog.models;
//
//
//import org.springframework.stereotype.Service;
//
//@Service("EmailService")
//public class EmailService {
//
//    @Autowired
//    public JavaMailSender emailSender;
//
//    @Value("${spring.mail.from}")
//    private String from;
//
//    public void prepareAndSend(Ad ad, String subject, String body) {
//        SimpleMailMessage msg = new SimpleMailMessage();
//        msg.setFrom(from);
//        msg.setTo(ad.getOwner().getEmail()); // outgoing mail to person sending to
//        msg.setSubject(subject);  // AD created
//        msg.setText(body);
//
//        try{
//            this.emailSender.send(msg);
//        }
//        catch (MailException ex) {
//            // simply log it and go on...
//            System.err.println(ex.getMessage());
//        }
//    }
//
//
//
//
//}
