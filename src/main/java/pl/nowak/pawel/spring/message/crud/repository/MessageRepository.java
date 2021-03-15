package pl.nowak.pawel.spring.message.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.nowak.pawel.spring.message.crud.repository.entity.MessageEntity;

public interface MessageRepository extends JpaRepository<MessageEntity, String> {

}
