package pl.nowak.pawel.spring.message.crud.service.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pl.nowak.pawel.spring.message.crud.repository.entity.MessageEntity;
import pl.nowak.pawel.spring.message.crud.web.model.MessageModel;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MessageMapperTest {
    @Test
    void model_to_entity() { //TODO: Refactor test method name
        //Given
        MessageMapper messageMapper = new MessageMapper();
        MessageModel messageModel = new MessageModel();

        //TODO: Refactor - Autowired

        messageModel.setId("1");
        messageModel.setContent("Message Entity");

        //When
        MessageEntity messageEntity = messageMapper.from(messageModel);

        //Then
        assertAll(
                () -> assertNotNull(messageEntity, "messageEntity is null!"),
                () -> assertEquals(messageEntity.getId(), "1", "messageEntity.Id is not 1!"),
                () -> assertEquals(messageEntity.getContent(), "Message Entity", "messageEntity.Content is not 'Message Entity'!")
        );
    }

    @Test
    void entity_to_model() { //TODO: Refactor test method name
        //Given
        MessageMapper messageMapper = new MessageMapper();
        MessageEntity messageEntity = new MessageEntity();

        //TODO: Refactor - Autowired

        messageEntity.setId("1");
        messageEntity.setContent("Message Model");

        //When
        MessageModel messageModel = messageMapper.from(messageEntity);

        //Then
        assertAll(
                () -> assertNotNull(messageModel, "messageModel is null!"),
                () -> assertEquals(messageModel.getId(), "1", "MessageModel.Id is not !!"),
                () -> assertEquals(messageModel.getContent(), "Message Model", "MessageModel.Content is not 'Message Model'!")
        );
    }
}