package activemq.consumer.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class MyPersistentMessage implements Serializable {

    @Id
    private String id;
    private String from;
    private String to;
    private String text;
    private LocalDateTime dateTime;

}