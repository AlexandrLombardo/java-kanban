package taskPackage.test;

import managerPackage.Managers;
import managerPackage.TaskManager;
import managerPackage.TaskStatus;
import org.junit.jupiter.api.Test;
import taskPackage.Epic;
import taskPackage.Subtask;
import taskPackage.Task;


import static managerPackage.TaskStatus.NEW;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SubtaskTest {

        private TaskManager taskManager = Managers.getDefault();

        //2. проверьте, что наследники класса Task равны друг другу, если равен их id;
        @Test
        void subtaskAreEqualIfTheirIDsAreEqual(){
            Epic epic1 = new Epic("Эпик №1","Описание ЭПИКА №1", TaskStatus.NEW);
            Epic epic2 = new Epic("Эпик №2","Описание ЭПИКА №2",TaskStatus.NEW);
            Subtask subtask1 = new Subtask("Подзадача №1","Описание ПОДЗАДАЧИ №1",TaskStatus.NEW,epic1);
            Subtask subtask2 = new Subtask("Подзадача №2","Описание ПОДЗАДАЧИ №2",TaskStatus.NEW,epic1);
            taskManager.addNewTask(subtask1);
            taskManager.addNewTask(subtask2);
            subtask1.setId(1);
            subtask2.setId(1);

            assertEquals(subtask1,subtask2,"ПодЗадачи c одинаковым ID не равны.");

        }

    //4. проверьте, что объект Subtask нельзя сделать своим же эпиком;
    @Test
    void subtaskCannotBeMadeIntoItsOwnEpic(){
        // ??? не понимаю как проверить если типы разные и в любом случае не получится создать под задачу с эпиком у которого тип подзадача.
        //Subtask subtask1 = new Subtask("Подзадача №1","Описание ПОДЗАДАЧИ №1",TaskStatus.NEW,subtask1);

        // assertEquals(subtask1,subtask2,"ПодЗадачи c одинаковым ID не равны.");

    }

}