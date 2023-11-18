package info.cafeit.notificationserivce.service;

import info.cafeit.notificationserivce.model.Message;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class NotificationService {

    private final EmailService emailService;

    public NotificationService(EmailService emailService) {
        this.emailService = emailService;
    }

    @KafkaListener(id = "notificationGroup", topics = "notification")
    public void listener(Message message) {
        log.info("Receive message...");
        emailService.sendMail(message);
    }

}
