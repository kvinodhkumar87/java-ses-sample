package me.vinodh.java_ses_sample;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClient;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;

import me.vinodh.java_ses_sample.domain.EmailEntity;

public class SESEmailSender {

  AmazonSimpleEmailServiceClient client = null;

  public SESEmailSender(String accessKey, String secretKey) {
    this.client = new AmazonSimpleEmailServiceClient(new BasicAWSCredentials(accessKey, secretKey));
  }

  public boolean sendEmail(EmailEntity emailEntity) {
    String from = emailEntity.getFromName() + " <" + emailEntity.getFromEmail() + ">";
    SendEmailRequest request = new SendEmailRequest().withSource(from);
    List<String> toAddresses = new ArrayList<String>();
    if (emailEntity.getToEmail() != null) {
      StringTokenizer st = new StringTokenizer(emailEntity.getToEmail(), ",;|");
      if (st.countTokens() >= 1) {
        while (st.hasMoreTokens()) {
          String nextToken = st.nextToken();
          toAddresses.add(nextToken);
        }
      }
    }
    if (emailEntity.getReplyTo() != null) {
      List<String> replyTo = new ArrayList<String>();
      replyTo.add(emailEntity.getReplyTo());
      request.setReplyToAddresses(replyTo);
    }

    Destination dest = new Destination().withToAddresses(toAddresses);
    request.setDestination(dest);
    Content subjContent = new Content().withData(emailEntity.getSubject());
    Message msg = new Message().withSubject(subjContent);
    Content htmlContent = new Content().withData(emailEntity.getMessage());
    Body body = new Body().withHtml(htmlContent).withText(htmlContent);
    msg.setBody(body);

    request.setMessage(msg);
    try {
      client.sendEmail(request);
      return true;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return false;
  }
}
