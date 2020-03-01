package activemq.consumer.service;

import activemq.consumer.api.request.v1.MyMessageRequestDto;
import activemq.consumer.config.ActiveMQConfig;
import common.MyMessage;
import activemq.consumer.model.MyPersistentMessage;
import activemq.consumer.repository.MongoDBRepository;
import org.modelmapper.ModelMapper;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static activemq.consumer.config.ConfigConstants.QUEUE_NAME;

@Service
public class MessageConsumerServiceImpl implements MessageConsumerService {

    private ActiveMQConfig activeMQConfig;
    private MongoDBRepository mongoDBRepository;

    public MessageConsumerServiceImpl(ActiveMQConfig activeMQConfig, MongoDBRepository mongoDBRepository) {
        this.activeMQConfig = activeMQConfig;
        this.mongoDBRepository = mongoDBRepository;
    }

    @Override
    @JmsListener(destination = QUEUE_NAME)
    public void receiveMessage(MyMessage message) {

        ModelMapper modelMapper = new ModelMapper();
        mongoDBRepository.save(modelMapper.map(message, MyPersistentMessage.class));

    }

    public List<MyMessageRequestDto> getAllMessages() {

        List<MyMessageRequestDto> myMessageRequestDtoList = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();

        List<MyPersistentMessage> myPersistentMessages = mongoDBRepository.findAll();

        myPersistentMessages.forEach(x -> myMessageRequestDtoList.add(modelMapper.map(x, MyMessageRequestDto.class)));

        return myMessageRequestDtoList;



    }
}
