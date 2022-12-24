package pro.sky.java.course3.telegrambot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.sky.java.course3.telegrambot.entity.NotificationTask;

import java.time.LocalDateTime;

@Repository
public interface NotificationTaskRepository extends JpaRepository<NotificationTask, Long> {
    Iterable findAllByDateTime(LocalDateTime currentDateTime);

    @Override
    NotificationTask getById(Long id);
}
