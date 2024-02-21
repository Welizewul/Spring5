package com.example.tasker.repository;

import com.example.tasker.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * TaskRepository расширяет интерфейс JpaRepository, предоставляя готовые методы для основных операций CRUD
 * (Create, Read, Update, Delete) над сущностями.
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    /**
     * getTasksByStatus - метод позволяет получить список задач с определенным статусом.
     * Он принимает в качестве аргумента объект enum Task.Status и возвращает список задач,
     * у которых статус совпадает с заданным.
     *
     * @param status - статус задачи.
     * @return список задач, имеющих запрошенный статус.
     */
    List<Task> getTasksByStatus(Task.Status status);
}