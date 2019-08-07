package me.vinodh.java_ses_sample;

import me.vinodh.java_ses_sample.domain.EmailEntity;

public class App {
  
  public void sendEmail(){
    EmailEntity entity = new EmailEntity();
    entity.setFromEmail("test@vinodh.me");
    entity.setToEmail("hello@vinodh.me");
    entity.setMessage("Test Email");
    entity.setSubject("Test Subject");
    entity.setFromName("Test");
    entity.setReplyTo("hi@vinodh.me");
    SESEmailSender sender = new SESEmailSender("YOUR_SES_API_KEY", "YOUR_SES_SECRET_KEY");
    boolean sent = sender.sendEmail(entity);
    if(sent){
      System.out.println("You Email Is Sent to "+entity.getToEmail());
    } else {
      System.out.println("Email Sending Failed");
    }
  }
  
  public static void main(String[] args) {
    App app = new App();
    app.sendEmail();
    System.exit(0);
  }

}
