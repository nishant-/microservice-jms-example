package active.mq.producer.service;

import active.mq.producer.api.request.v1.MyMessageRequestDto;
import active.mq.producer.api.response.v1.MyMessageResponseDto;
import active.mq.producer.repository.MessageProducerRepository;
import org.springframework.stereotype.Service;

@Service
public class MessageProducerServiceImpl implements MessageProducerService {

    private MessageProducerRepository messageProducerRepository;

    public MessageProducerServiceImpl(MessageProducerRepository messageProducerRepository) {
        this.messageProducerRepository = messageProducerRepository;
    }

    @Override
    public MyMessageResponseDto sendMessage(MyMessageRequestDto myMessageRequestDto) {

        return messageProducerRepository.sendMessage(myMessageRequestDto);

    }
}
