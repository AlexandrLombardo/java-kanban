package managerPackage.test;

import managerPackage.HistoryManager;
import managerPackage.Managers;
import org.junit.jupiter.api.Test;
import taskPackage.Task;

import java.util.List;

import static managerPackage.TaskStatus.IN_PROGRESS;
import static managerPackage.TaskStatus.NEW;
import static org.junit.jupiter.api.Assertions.*;

class InMemoryHistoryManagerTest {

    @Test
    void add() {

        HistoryManager historyManager = Managers.getDefaultHistory();
        Task task = new Task("Test addNewTask", "Test addNewTask description", NEW);

        historyManager.add(task);
        final List<Task> history = historyManager.getHistory();
        assertNotNull(history, "История не пустая.");
        assertEquals(1, history.size(), "История не пустая.");
    }

    @Test
    void remove() {

        HistoryManager historyManager = Managers.getDefaultHistory();
        Task task = new Task("Test addNewTask", "Test addNewTask description", NEW);

        historyManager.add(task);
        historyManager.remove(task.getId());
        List<Task> history = historyManager.getHistory();
        //assertNull(history, "История пустая.");
        assertEquals(0, history.size(), "История должна быть пустая.");

        Task task2 = new Task("Test addNewTask", "Test addNewTask description", NEW);
        Task task3 = new Task("Test addNewTask", "Test addNewTask description", NEW);

        historyManager.add(task);
        task2.setId(2);
        historyManager.add(task2);
        task3.setId(3);
        historyManager.add(task3);

        historyManager.remove(task.getId());
        history = historyManager.getHistory();
        //assertNull(history, "История пустая.");
        assertEquals(2, history.size(), "В Истории должно быть две задачи");

        historyManager.remove(task3.getId());
        history = historyManager.getHistory();
        //assertNull(history, "История пустая.");
        assertEquals(1, history.size(), "В Истории должна быть одна задача");
    }

    //убедитесь, что задачи, добавляемые в HistoryManager, сохраняют предыдущую версию задачи и её данных.
    @Test
    void historyManagerSavePreviousVersionTask() {
        HistoryManager historyManager = Managers.getDefaultHistory();
        Task task = new Task("Test addNewTask", "Test addNewTask description", NEW);
        historyManager.add(task);
        task.setId(3);
        task.setStatus(IN_PROGRESS);
        task.setDescription("Поменяли");
        task.setName("Тоже поменяли");
        historyManager.add(task);
        final List<Task> history = historyManager.getHistory();
        assertEquals(2, history.size(), "измененая задача заменила предыдущую версию");

        assertEquals(0, history.get(0).getId(), "предыдущая версия изменила ID");
        assertEquals("Test addNewTask", history.get(0).getName(), "предыдущая версия изменила name");
        assertEquals("Test addNewTask description", history.get(0).getDescription(), "предыдущая версия изменила Description");
        assertEquals(NEW, history.get(0).getStatus(), "предыдущая версия изменила Status");


    }

}