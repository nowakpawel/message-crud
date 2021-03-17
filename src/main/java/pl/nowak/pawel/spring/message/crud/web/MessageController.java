package pl.nowak.pawel.spring.message.crud.web;


import org.springframework.web.bind.annotation.*;
import pl.nowak.pawel.spring.message.crud.exception.MessageNotFoundException;
import pl.nowak.pawel.spring.message.crud.service.MessageService;
import pl.nowak.pawel.spring.message.crud.web.model.MessageModel;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/messages")
public class MessageController {
    private static final Logger logger = Logger.getLogger(MessageController.class.getName());

    private MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping
    public MessageModel create() {
        logger.info("(MessageController::create)    ====>   Create message with id and content");

        MessageModel messageModel = new MessageModel("d819302f-4b86-4815-8d39-9966d441f76f", "Wartosc");
        if (!messageModel.getContent().equals(null)) {
            messageService.create(messageModel);
        }

        logger.info("(MessageController::create)    ====>   Returned message = " + messageModel);
        return messageModel;
    }

    @GetMapping
    public List<MessageModel> readAllMessages() {
        logger.info("(MessageController::readAllMessages)   ====>   Reading all messages");

        List<MessageModel> list = messageService.list();

        logger.info("(MessageController::readAllMessages)   ====>   list = "+ list);
        return list;
    }

    @PutMapping("/{id}")
    //public MessageModel update(@PathVariable String id) throws MessageNotFoundException {
    public MessageModel update(@PathVariable String id, @RequestBody MessageModel messageModel) throws MessageNotFoundException {
        logger.info("(MessageController::update)   ====>    updating message with id " + id);

        //MessageModel newMessage = new MessageModel(id, "Wartosc 2");
        MessageModel updatedMessage = messageService.update(id, messageModel);

        logger.info("(MessageController::update)   ====>    new content of message with id " + id + " = " +
                messageModel);

        return updatedMessage;
    }

    @GetMapping("/random/{count}")
    public List<MessageModel> readRandomMessages(@PathVariable Integer count) {
        List<MessageModel> list = messageService.readRandomMessages(count);
        return list;
        //TODO: loggers
    }


    //For tests
    @GetMapping("/{id}")
    public MessageModel readMessageById(@PathVariable String id) throws MessageNotFoundException {
        logger.info("MessageController::readMessageById)    ====>   Read message with id " + id);

        MessageModel messageModel = messageService.read(id);

        logger.info("MessageController::readMessageById)    ====>   Returned message: " + messageModel);
        return messageModel;
    }
}
