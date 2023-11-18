package info.cafeit.notificationserivce.service;

import info.cafeit.notificationserivce.model.Message;

public interface EmailService {
    void sendMail(Message message);
}
