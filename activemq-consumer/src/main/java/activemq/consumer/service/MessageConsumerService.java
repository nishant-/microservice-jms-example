package activemq.consumer.service;

import activemq.consumer.api.request.v1.MyMessageRequestDto;
import common.MyMessage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MessageConsumerService {

     void receiveMessage(MyMessage message) ;
     List<MyMessageRequestDto> getAllMessages();

}
