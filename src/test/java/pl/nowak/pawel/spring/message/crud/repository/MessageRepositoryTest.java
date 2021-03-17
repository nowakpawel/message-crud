package pl.nowak.pawel.spring.message.crud.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.nowak.pawel.spring.message.crud.repository.entity.MessageEntity;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
class MessageRepositoryTest {

    @Autowired
    private MessageRepository messageRepository;

    @Test
    void givenMessageEntity_whenRepositorySaved_thenSavedMessageEntityNotNull() {
        //Given
        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setContent("Wartosc");

        //When
        MessageEntity savedMessageEntity = messageRepository.save(messageEntity);

        //Then
        assertAll(
                () -> assertNotNull(savedMessageEntity, "savedMessageEntity is null"),
                () -> assertNotNull(savedMessageEntity.getId(), "savedMessageEntity id is null")

        );

    }

}