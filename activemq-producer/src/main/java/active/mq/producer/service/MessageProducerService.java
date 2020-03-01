package active.mq.producer.service;

import active.mq.producer.api.request.v1.MyMessageRequestDto;
import active.mq.producer.api.response.v1.MyMessageResponseDto;


public interface MessageProducerService {

    MyMessageResponseDto sendMessage(MyMessageRequestDto myMessageRequestDto);

}
