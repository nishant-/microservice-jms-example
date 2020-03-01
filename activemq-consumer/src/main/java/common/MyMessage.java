package common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyMessage implements Serializable {

    private String from;
    private String to;
    private String text;
    private LocalDateTime dateTime;

}