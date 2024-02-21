package com.example.tasker.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * Task - класс, определяющий характеристики сущности, используемой для управления задачами и сохранения
 * соответствующих сведений в базе данных.
 */
@Data     // Lombok: позволяет автоматически генерировать методы toString(), equals(), hashCode(), геттеры и сеттеры.
@Entity   // Использована для обозначения класса как сущности, которая будет сохранена в базе данных.
@Table(name = "tasks") // Задано наименование создаваемой таблицы.
public class Task {
    public enum Status {TEMP, NOT_STARTED, IN_PROGRESS, COMPLETED} // Статус решения задачи.

    @Id                                                            // Обозначение поля id, как первичного ключа.
    @GeneratedValue(strategy = GenerationType.IDENTITY)            // Стратегия изменения id.
    private Long id;                                               // Номер задачи.
    @Column(nullable = false)                                      // Поле не может иметь значение null.
    private String description;                                    // Описание задачи.
    @Column(nullable = false)                                      // Поле не может иметь значение null.
    private Status status;                                         // Статус выполнения задачи.
    @Column
    private LocalDateTime local_date_time = LocalDateTime.now();   // Текущее время.
}