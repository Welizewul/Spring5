package com.example.tasker.controller;

import com.example.tasker.model.Task;
import com.example.tasker.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * TaskController - класс, реализующий методы обработки запросов и управления потоком данных между клиентом и БД.
 */

@RestController            // Аннотация необходима для создания веб-сервисов RESTful API.
@RequestMapping("/tasks")  // Используется для отображения URL-адреса в методе обработчика.
@AllArgsConstructor        // Используется для автоматической генерации конструктора,
// который принимает на вход все атрибуты класса в качестве аргументов
public class TaskController {
    private final TaskService taskService;

    /**
     * getAllTasks - метод запроса всех задач в ежедневнике.
     *
     * @return - список задач.
     */
    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    /**
     * addTask - метод добавления новых задач.
     *
     * @param task - задача.
     * @return - обновленный список.
     */
    @PostMapping
    public Task addTask(@RequestBody Task task) {
        return taskService.addTask(task);
    }

    /**
     * updateTaskStatus - метод обновления задачи в БД, позволяющий менять статус или описание.
     *
     * @param id     - номер задачи.
     * @param status - статус.
     * @return - обновленные данные.
     */
    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task.Status status) {
        return taskService.updateStatusTask(id, status);
    }

    /**
     * getTaskById - метод получения данных о задаче по ее номеру.
     *
     * @param id - номер задачи.
     * @return - данные по задаче.
     */
    @GetMapping("/{id}")
    public Optional<Task> getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    /**
     * getTasksByStatus - метод поиска задачи по ее статусу.
     *
     * @param status - статус задачи.
     * @return - характеристики задач, имеющих запрошенный статус.
     */
    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable Task.Status status) {
        return taskService.getTasksByStatus(status);
    }

    /**
     * deleteTask - метод удаления задач по номеру.
     *
     * @param id - номер задачи.
     */
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}