package pl.nowak.pawel.spring.message.crud.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.nowak.pawel.spring.message.crud.repository.entity.MessageEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MessageRepositoryTest {

    @Autowired
    private MessageRepository messageRepository;

    @Test
    void test() {
        //Given
        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setContent("Wartosc");

        //When
        messageRepository.save(messageEntity);

        //Then

    }

}