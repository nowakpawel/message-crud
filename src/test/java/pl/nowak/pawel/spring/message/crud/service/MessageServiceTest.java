package pl.nowak.pawel.spring.message.crud.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.nowak.pawel.spring.message.crud.exception.MessageNotFoundException;
import pl.nowak.pawel.spring.message.crud.web.model.MessageModel;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MessageServiceTest {

    private static final String UPDATED_CONTENT = "Updated content";
    private static final int COUNT = 4;

    @Autowired
    private MessageService messageService;

    @Test
    void givenQuantity_whenRandom_thenReturnRandomMessages() {
        //Given

        //When
        List<MessageModel> messageModels = messageService.readRandomMessages(COUNT);

        //Then
        assertAll(
                () -> assertNotNull(messageModels, "messageModels are null"),
                () -> assertEquals(COUNT, messageModels.size(), "messageModels size is not 4")
        );
    }

    @Test
    void givenNewMessage_whenUpdate_thenMessageUpdated() throws MessageNotFoundException {
        //Given

        //When
        MessageModel createdMessageModel = messageService.create(MessageModel.builder().content("Content").build());
        MessageModel updatedMessageModel = messageService.update(createdMessageModel.getId(), MessageModel.builder().content(UPDATED_CONTENT).build());

        //Then
        assertAll(
                () -> assertNotNull(updatedMessageModel, "updatedMessageModel is null"),
                () -> assertEquals(updatedMessageModel.getContent(), UPDATED_CONTENT, "updatedMesageContent is not equal " + UPDATED_CONTENT)
        );
    }

}