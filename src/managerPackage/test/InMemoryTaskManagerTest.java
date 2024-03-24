package managerPackage.test;

import managerPackage.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import taskPackage.Epic;
import taskPackage.Subtask;
import taskPackage.Task;

import java.util.List;

import static managerPackage.TaskStatus.NEW;
import static org.junit.jupiter.api.Assertions.*;

class InMemoryTaskManagerTest {

    //проверьте, что InMemoryTaskManager действительно добавляет задачи разного типа и может найти их по id;
    static private TaskManager taskManager;
    static private Task task;
    static private Subtask subtask;
    static private Epic epic;
    // проверьте, что InMemoryTaskManager действительно добавляет задачи разного типа и может найти их по id;

    @BeforeAll
    static void createManager() {

        taskManager = Managers.getDefault();
        task = new Task("Test addNewTask", "Test addNewTask description", NEW);
        epic = new Epic("Test addNewTask", "Test addNewTask description", NEW);
        subtask = new Subtask("Подзадача №1","Описание ПОДЗАДАЧИ №1", TaskStatus.NEW,epic);
        taskManager.addNewTask(task);
        taskManager.addNewEpic(epic);
        taskManager.addNewSubtask(subtask);


    }

    @Test
    void addNewTask() {

        Assertions.assertFalse(taskManager.getTasks().isEmpty(),"InMemoryTaskManager не добавляет задачи.");

    }

    @Test
    void addNewEpic() {
         Assertions.assertFalse(taskManager.getAllEpics().isEmpty(),"InMemoryTaskManager не добавляет epic.");
    }

    @Test
    void addNewSubtask() {
         Assertions.assertFalse(taskManager.getAllSubtasks().isEmpty(),"InMemoryTaskManager не добавляет подзадачи.");
    }

    @Test
    void getAnyTask() {

        Task task1 = taskManager.getAnyTask(task.getId());
        Task task2 = taskManager.getAnyTask(epic.getId());
        Task task3 = taskManager.getAnyTask(subtask.getId());
        Assertions.assertNotNull(task1, "Добавленная задача не найдена по ID");
        Assertions.assertNotNull(task2, "Добавленная epic не найдена по ID");
        Assertions.assertNotNull(task3, "Добавленная subtask не найдена по ID");

    }

    // 7. проверьте, что задачи с заданным id и сгенерированным id не конфликтуют внутри менеджера;
    @Test
    void taskWithGivenIdAndGeneratedIdNotConflict(){
        Task task1 = new Task("Test addNewTask", "Test addNewTask description", NEW);
        task1.setId(task.getId());
        taskManager.addNewTask(task1);

        assertEquals(2, taskManager.getTasks().size(), "Задачи с одинаковым id внутри менеджера не добавляются");
    }
    // 8. создайте тест, в котором проверяется неизменность задачи (по всем полям) при добавлении задачи в менеджер
    @Test
    void constancyTask(){
        Task task1 = new Task("Test addNewTask", "Test addNewTask description", NEW);
        taskManager.addNewTask(task1);
        Task task2 = taskManager.getTask(task1.getId());

        assertEquals(task2.getName(), "Test addNewTask", "Задача после добавления в менеджер изменила тему");
        assertEquals(task2.getDescription(), "Test addNewTask description", "Задача после добавления в менеджер изменила описание");
        assertEquals(task2.getStatus(), NEW, "Задача после добавления в менеджер изменила статус");
    }


}