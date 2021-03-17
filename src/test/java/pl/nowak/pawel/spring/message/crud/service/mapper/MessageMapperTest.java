package pl.nowak.pawel.spring.message.crud.service.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pl.nowak.pawel.spring.message.crud.repository.entity.MessageEntity;
import pl.nowak.pawel.spring.message.crud.web.model.MessageModel;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MessageMapperTest {

    private static final String ID = "1";
    private static final String MESSAGE_ENTITY = "Message Entity";
    private static final String MESSAGE_MODEL = "Message Model";

    @Test
    void givenModel_whenMapToEntity_thenCreateEntity() {
        //Given
        MessageMapper messageMapper = new MessageMapper();
        MessageModel messageModel = new MessageModel();



        messageModel.setId(ID);
        messageModel.setContent(MESSAGE_ENTITY);

        //When
        MessageEntity messageEntity = messageMapper.from(messageModel);

        //Then
        assertAll(
                () -> assertNotNull(messageEntity, "messageEntity is null!"),
                () -> assertEquals(messageEntity.getId(), ID, "messageEntity.Id is not 1!"),
                () -> assertEquals(messageEntity.getContent(), MESSAGE_ENTITY, "messageEntity.Content is not 'Message Entity'!")
        );
    }

    @Test
    public void givenEntity_whenMapToModel_thenCreateModel() {
        //Given
        MessageMapper messageMapper = new MessageMapper();
        MessageEntity messageEntity = new MessageEntity();

        messageEntity.setId(ID);
        messageEntity.setContent(MESSAGE_MODEL);

        //When
        MessageModel messageModel = messageMapper.from(messageEntity);

        //Then
        assertAll(
                () -> assertNotNull(messageModel, "messageModel is null!"),
                () -> assertEquals(messageModel.getId(), ID, "MessageModel.Id is not !!"),
                () -> assertEquals(messageModel.getContent(), MESSAGE_MODEL, "MessageModel.Content is not 'Message Model'!")
        );
    }
}