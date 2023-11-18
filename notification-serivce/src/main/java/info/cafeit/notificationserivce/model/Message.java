package info.cafeit.notificationserivce.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Message {
    private String sendTo;
    private String subject;
    private String content;

}
