package pl.nowak.pawel.spring.message.crud.service;

import org.springframework.stereotype.Service;
import pl.nowak.pawel.spring.message.crud.repository.MessageRepository;
import pl.nowak.pawel.spring.message.crud.repository.entity.MessageEntity;
import pl.nowak.pawel.spring.message.crud.service.mapper.MessageMapper;
import pl.nowak.pawel.spring.message.crud.web.model.MessageModel;

import java.util.logging.Logger;

@Service
public class MessageService {
    private final static Logger logger = Logger.getLogger(MessageService.class.getName());

    private MessageMapper messageMapper;
    private MessageRepository messageRepository;

    public MessageService(MessageMapper messageMapper, MessageRepository messageRepository) {
        logger.info("(MessageService::constructor)   ====>   this.messageMapper = " + this.messageMapper);
        logger.info("(MessageService::constructor)   ====>   this.messageRepository = " + this.messageRepository);

        this.messageMapper = messageMapper;
        this.messageRepository = messageRepository;

        logger.info("(MessageService::constructor)   ====>   this.messageMapper = " + this.messageMapper);
        logger.info("(MessageService::constructor)   ====>   this.messageRepository = " + this.messageRepository);
    }

    public MessageModel create(MessageModel messageModel) {
        logger.info("(MessageService::create)   ====>   Create MessageEntity object");
        MessageEntity messageEntity = messageMapper.from(messageModel);
        MessageEntity savedMessageEntity = messageRepository.save(messageEntity);
        logger.info("(MessageService::create)   ====>   Returned MessageEntity object: " + messageEntity);
        return null;
    }

}
//TODO; dodać loggery dla wszystkich metod publicznych na wejściu i wyjściu