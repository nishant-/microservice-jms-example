package active.mq.producer.controller.v1;

import active.mq.producer.api.response.v1.MyMessageResponseDto;
import active.mq.producer.api.request.v1.MyMessageRequestDto;
import active.mq.producer.service.MessageProducerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
public class MessageProducerController {

    private MessageProducerService messageProducerService;

    public MessageProducerController(MessageProducerService messageProducerService) {
        this.messageProducerService = messageProducerService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MyMessageResponseDto> sendMessage(@Valid @RequestBody MyMessageRequestDto myMessageRequestDto) {

            MyMessageResponseDto myMessageResponseDto = messageProducerService.sendMessage(myMessageRequestDto);
            return new ResponseEntity<>(myMessageResponseDto, HttpStatus.OK);
    }
}
