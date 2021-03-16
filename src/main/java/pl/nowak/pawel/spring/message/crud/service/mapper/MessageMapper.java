package pl.nowak.pawel.spring.message.crud.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.nowak.pawel.spring.message.crud.repository.entity.MessageEntity;
import pl.nowak.pawel.spring.message.crud.web.model.MessageModel;

import java.util.logging.Logger;

@Component
public class MessageMapper {
    private final static Logger logger = Logger.getLogger(MessageMapper.class.getName());

    public MessageEntity from(MessageModel messageModel) {
        logger.info("(MessageMapper::from(MessageModel)    ====>    create MessageEntity from MessageModel)");

        ModelMapper modelMapper = new ModelMapper();
        MessageEntity messageEntity = modelMapper.map(messageModel, MessageEntity.class);

        logger.info("(MessageMapper::from(MessageModel)    ====>    returned messageEntity = " + messageEntity + "");
        return messageEntity;
    }

    public MessageModel from(MessageEntity messageEntity) {
        logger.info("(MessageMapper::from(MessageEntity)    ====>    create MessageModel from MessageEntity)");

        ModelMapper modelMapper = new ModelMapper();
        MessageModel messageModel = modelMapper.map(messageEntity, MessageModel.class);

        logger.info("(MessageMapper::from(MessageEntity)    ====>    returned messageModel = " + messageModel + "");
        return messageModel;
    }

}
