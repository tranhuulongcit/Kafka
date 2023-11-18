package info.cafeit.notificationserivce.service;

import info.cafeit.notificationserivce.model.Message;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;

@Service
@Log4j2
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender javaMailSender;

    private final SpringTemplateEngine templateEngine;

    @Value("${spring.mail.username}")
    private String from;

    public EmailServiceImpl(JavaMailSender javaMailSender, SpringTemplateEngine templateEngine) {
        this.javaMailSender = javaMailSender;
        this.templateEngine = templateEngine;
    }


    @Override
    public void sendMail(Message message) {
        try {
            log.info("Start send mail to: {}", message.getSendTo());
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, StandardCharsets.UTF_8.name());

            Context context = new Context();
            context.setVariable("content", message.getContent());
            String html = templateEngine.process("notify-mail-template", context);

            helper.setTo(message.getSendTo());
            helper.setText(html, true);
            helper.setSubject(message.getSubject());
            helper.setFrom(from);

            javaMailSender.send(mimeMessage);
            log.info("Send mail success!");
        } catch (Exception ex) {
            log.error(ex);
        }

    }
}
