package activemq.consumer.controller;

import activemq.consumer.api.request.v1.MyMessageRequestDto;
import activemq.consumer.service.MessageConsumerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageConsumerController {


    private MessageConsumerService messageConsumerService;

    public MessageConsumerController(MessageConsumerService messageConsumerService) {
        this.messageConsumerService = messageConsumerService;
    }

    @GetMapping("/all/")
    public ResponseEntity<List<MyMessageRequestDto>> getMessages() {
        List<MyMessageRequestDto> myMessageRequestDtoList = messageConsumerService.getAllMessages();
        return new ResponseEntity<>(myMessageRequestDtoList, HttpStatus.OK);
    }
}
