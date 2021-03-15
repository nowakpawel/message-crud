package pl.nowak.pawel.spring.message.crud.service.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import pl.nowak.pawel.spring.message.crud.repository.entity.MessageEntity;
import pl.nowak.pawel.spring.message.crud.web.model.MessageModel;

@Component
public class MessageMapper {
    public MessageEntity from(MessageModel messageModel) {
        ModelMapper modelMapper = new ModelMapper();
        MessageEntity messageEntity = modelMapper.map(messageModel, MessageEntity.class);
        return messageEntity;
    }

    public MessageModel from(MessageEntity messageEntity) {
        ModelMapper modelMapper = new ModelMapper();
        MessageModel messageModel = modelMapper.map(messageEntity, MessageModel.class);
        return messageModel;
    }

}
