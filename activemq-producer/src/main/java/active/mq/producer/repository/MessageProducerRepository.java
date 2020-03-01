package active.mq.producer.repository;

import active.mq.producer.api.request.v1.MyMessageRequestDto;
import active.mq.producer.api.response.v1.MyMessageResponseDto;
import common.MyMessage;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Repository;

import javax.jms.*;
import java.time.LocalDateTime;

@Repository
public class MessageProducerRepository {

    private JmsTemplate jmsTemplate;

    @Qualifier("myQueue")
    private Queue myQueue;

    public MessageProducerRepository(JmsTemplate jmsTemplate,  Queue myQueue) {
        this.jmsTemplate = jmsTemplate;
        this.myQueue = myQueue;
    }

    public MyMessageResponseDto sendMessage(MyMessageRequestDto myMessageRequestDto) {

        ModelMapper modelMapper = new ModelMapper();
        MyMessage myMessage = modelMapper.map(myMessageRequestDto, MyMessage.class);
        myMessage.setDateTime(LocalDateTime.now());


        jmsTemplate.send(myQueue, session -> {
            ObjectMessage objectMessage = session.createObjectMessage();
            objectMessage.setObject(myMessage);
            return objectMessage;
        });

        return modelMapper.map(myMessage, MyMessageResponseDto.class);

    }
}
