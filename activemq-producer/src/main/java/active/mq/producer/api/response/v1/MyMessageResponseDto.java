package active.mq.producer.api.response.v1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor @NoArgsConstructor
@Builder
public class MyMessageResponseDto implements Serializable {

    private String from;
    private String to;
    private String text;
    private LocalDateTime dateTime;
}
