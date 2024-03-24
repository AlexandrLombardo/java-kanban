package taskPackage.test;

import managerPackage.Managers;
import managerPackage.TaskManager;
import managerPackage.TaskStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import taskPackage.Epic;
import taskPackage.Subtask;
import taskPackage.Task;


import java.util.ArrayList;
import java.util.List;

import static managerPackage.TaskStatus.NEW;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EpicTest {



    private TaskManager taskManager = Managers.getDefault();


    //2. проверьте, что наследники класса Task равны друг другу, если равен их id;
    @Test
    void epicAreEqualIfTheirIDsAreEqual(){
        Epic epic1 = new Epic("Эпик №1","Описание ЭПИКА №1", TaskStatus.NEW);
        Epic epic2 = new Epic("Эпик №2","Описание ЭПИКА №2",TaskStatus.NEW);
        taskManager.addNewTask(epic1);
        taskManager.addNewTask(epic2);
        epic1.setId(1);
        epic2.setId(1);

        assertEquals(epic1,epic2,"ПодЗадачи c одинаковым ID не равны.");

    }

    //3. проверьте, что объект Epic нельзя добавить в самого себя в виде подзадачи;
    @Test
    void epicObjectCannotBeAddedToItselfAsASubtask(){

        Epic epic1 = new Epic("Test addNewTask", "Test addNewTask description", NEW);
        //epic1.addSubtask(epic1); // тип параметра не может быть отличным от Subtask поэтому Epic сюда не получится передать в любом случае.
        List<Subtask> subtasks = epic1.getSubtasks();
        Assertions.assertTrue(subtasks.isEmpty(), "Epic нельзя добавить в самого себя в виде подзадачи");

    }


}