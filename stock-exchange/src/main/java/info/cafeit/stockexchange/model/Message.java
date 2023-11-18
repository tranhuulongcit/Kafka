package info.cafeit.stockexchange.model;

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
