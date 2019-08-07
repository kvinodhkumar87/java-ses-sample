package me.vinodh.java_ses_sample.domain;

public class EmailEntity {
  
  private String id;
  private String fromEmail;
  private String toEmail;
  private String subject;
  private String message;
  private String fromName;
  private String replyTo;
  
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getFromEmail() {
    return fromEmail;
  }
  public void setFromEmail(String fromEmail) {
    this.fromEmail = fromEmail;
  }
  public String getToEmail() {
    return toEmail;
  }
  public void setToEmail(String toEmail) {
    this.toEmail = toEmail;
  }
  public String getSubject() {
    return subject;
  }
  public void setSubject(String subject) {
    this.subject = subject;
  }
  public String getMessage() {
    return message;
  }
  public void setMessage(String message) {
    this.message = message;
  }
  public String getFromName() {
    return fromName;
  }
  public void setFromName(String fromName) {
    this.fromName = fromName;
  }
  public String getReplyTo() {
    return replyTo;
  }
  public void setReplyTo(String replyTo) {
    this.replyTo = replyTo;
  }

}
