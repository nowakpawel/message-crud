package pl.nowak.pawel.spring.message.crud.service;

import org.springframework.stereotype.Service;
import pl.nowak.pawel.spring.message.crud.repository.MessageRepository;
import pl.nowak.pawel.spring.message.crud.repository.entity.MessageEntity;
import pl.nowak.pawel.spring.message.crud.service.mapper.MessageMapper;
import pl.nowak.pawel.spring.message.crud.web.model.MessageModel;

@Service
public class MessageService {

    private MessageMapper messageMapper;
    private MessageRepository messageRepository;

    public MessageService(MessageMapper messageMapper, MessageRepository messageRepository) {
        this.messageMapper = messageMapper;
        this.messageRepository = messageRepository;
    }

    public MessageModel create(MessageModel messageModel) {
        MessageEntity messageEntity = messageMapper.from(messageModel);
        MessageEntity savedMessageEntity = messageRepository.save(messageEntity);
        return null;
    }

}
//TODO; dodać loggery dla wszystkich metod publicznych na wejściu i wyjściu