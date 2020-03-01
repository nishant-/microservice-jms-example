package activemq.consumer.api.request.v1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor @NoArgsConstructor
public class MyMessageRequestDto {

    private String from;
    private String to;
    private String text;
    private LocalDateTime dateTime;

}
