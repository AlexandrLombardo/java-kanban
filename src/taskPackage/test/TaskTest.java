package taskPackage.test;

import managerPackage.Managers;
import managerPackage.TaskManager;
import org.junit.jupiter.api.Test;
import taskPackage.Task;

import java.util.List;

import static managerPackage.TaskStatus.NEW;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskTest
{
    private TaskManager taskManager = Managers.getDefault();

    @Test
    void addNewTask() {
        Task task = new Task("Test addNewTask", "Test addNewTask description", NEW);
        final int taskId = taskManager.addNewTask(task);

        final Task savedTask = taskManager.getTask(taskId);

        assertNotNull(savedTask, "Задача не найдена.");
        assertEquals(task, savedTask, "Задачи не совпадают.");

        final List<Task> tasks = taskManager.getTasks();

        assertNotNull(tasks, "Задачи не возвращаются.");
        assertEquals(1, tasks.size(), "Неверное количество задач.");
        assertEquals(task, tasks.get(0), "Задачи не совпадают.");
    }

    //1. проверьте, что экземпляры класса Task равны друг другу, если равен их id;
    @Test
    void tasksAreEqualIfTheirIDsAreEqual(){
        Task task1 = new Task("Test addNewTask", "Test addNewTask description", NEW);
        Task task2 = new Task("Test addNewTask", "Test addNewTask description", NEW);
        taskManager.addNewTask(task1);
        taskManager.addNewTask(task2);
        task1.setId(1);
        task2.setId(1);

        assertEquals(task1,task2,"Задачи c одинаковым ID не равны.");

    }

    //2. проверьте, что наследники класса Task равны друг другу, если равен их id;
    @Test
    void SubtaskAreEqualIfTheirIDsAreEqual(){
        Task task1 = new Task("Test addNewTask", "Test addNewTask description", NEW);
        Task task2 = new Task("Test addNewTask", "Test addNewTask description", NEW);
        taskManager.addNewTask(task1);
        taskManager.addNewTask(task2);
        task1.setId(1);
        task2.setId(1);

        assertEquals(task1,task2,"Задачи c одинаковым ID не равны.");

    }

}