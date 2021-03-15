package pl.nowak.pawel.spring.message.crud.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.nowak.pawel.spring.message.crud.service.MessageService;
import pl.nowak.pawel.spring.message.crud.web.model.MessageModel;

@RestController
@RequestMapping(value = "/messages")
public class MessageController {

    private MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping
    public MessageModel create(MessageModel messageModel) {
//        messageService.;
        return null;
    }

}
