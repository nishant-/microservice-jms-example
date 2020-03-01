package active.mq.producer.api.request.v1;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MyMessageRequestDto implements Serializable {

    private String from;
    private String to;
    private String text;
}
