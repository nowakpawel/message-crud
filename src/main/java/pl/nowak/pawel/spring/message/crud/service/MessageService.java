package pl.nowak.pawel.spring.message.crud.service;

import org.aspectj.bridge.Message;
import org.dom4j.rule.Mode;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.nowak.pawel.spring.message.crud.exception.MessageException;
import pl.nowak.pawel.spring.message.crud.exception.MessageNotFoundException;
import pl.nowak.pawel.spring.message.crud.repository.MessageRepository;
import pl.nowak.pawel.spring.message.crud.repository.entity.MessageEntity;
import pl.nowak.pawel.spring.message.crud.service.mapper.MessageMapper;
import pl.nowak.pawel.spring.message.crud.web.model.MessageModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

    public List<MessageModel> list() {
        logger.info("(MessageService::list)    ====>    Geting all messages from repository");

        List<MessageEntity> entityList = messageRepository.findAll();
        List<MessageModel> modelList = new ArrayList<>();

        for (MessageEntity entity : entityList) {
            MessageModel model = messageMapper.from(entity);
            modelList.add(model);
        }

        logger.info("(MessageService::list)    ====>    Returned Messages list = " + modelList);
        return modelList;
    }

    //cerate
    public MessageModel create(MessageModel messageModel) {
        logger.info("(MessageService::create)   ====>   Create MessageEntity object");

        MessageEntity messageEntity = messageMapper.from(messageModel);
        MessageEntity savedMessageEntity = messageRepository.save(messageEntity);

        logger.info("(MessageService::create)   ====>   Returned MessageModel object = " + messageEntity);
        return messageMapper.from(messageEntity);
    }

    //read
    public MessageModel read(String id) throws MessageNotFoundException {
        logger.info("(MessageService::read)    ====>    Read MessageModel object");

        MessageEntity messageEntity = messageRepository.findAll().stream()
                .filter(message -> message.getId().equals(id))
                .findAny()
                .orElseThrow(() -> new MessageNotFoundException("Message with id " + id + " not exist!"));

        MessageModel messageModel = messageMapper.from(messageEntity);


        logger.info("(MessageService::read)   ====>     Returned MessageModel object = " + messageModel);
        return messageModel;
    }

    //update
    public MessageModel update(String id, MessageModel messageModel) throws MessageNotFoundException {
        logger.info("(MessageService::update)    ====>    Updating Message with id " + id);

        MessageEntity messageEntity = messageRepository.findAll().stream()
                .filter(message -> message.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new MessageNotFoundException("Message with id " + id + " not exist!"));
        messageEntity.setContent(messageModel.getContent());

        MessageModel model = messageMapper.from(messageEntity);
        logger.info("(MessageService::update)    ====>    Updated message = " + model);

        return model;
    }

    //delete
    public void delete(String id) {
        logger.info("(MessageService::delete)    ====>    Deleting message with id " + id);

        messageRepository.delete(messageRepository.getOne(id));

        logger.info("(MessageService::delete)    ====>    Repository after delete " + messageRepository.findAll());

    }

}
