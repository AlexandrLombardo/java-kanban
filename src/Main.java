import managerPackage.Manager;
import taskPackage.*;

public class Main {
    public static void main(String[] args) {

        //Тестовые данные
        Task task1 = new Task("Задача №1","Описание ЗАДАЧИ №1","NEW");
        Task task2 = new Task("Задача №2","Описание ЗАДАЧИ №2","NEW");
        Epic epic1 = new Epic("Эпик №1","Описание ЭПИКА №1","NEW");
        Epic epic2 = new Epic("Эпик №2","Описание ЭПИКА №2","NEW");
        Subtask subtask1 = new Subtask("Подзадача №1","Описание ПОДЗАДАЧИ №1","NEW",epic1);
        Subtask subtask2 = new Subtask("Подзадача №2","Описание ПОДЗАДАЧИ №2","NEW",epic1);
        Subtask subtask3 = new Subtask("Подзадача №3","Описание ПОДЗАДАЧИ №3","NEW",epic2);
        epic1.addSubtask(subtask1);
        epic1.addSubtask(subtask2);
        epic2.addSubtask(subtask3);

        Manager manager = new Manager();

        manager.addNewTask(task1);
        manager.addNewTask(task2);
        manager.addNewEpic(epic1);
        manager.addNewEpic(epic2);
        manager.addNewSubtask(subtask1);
        manager.addNewSubtask(subtask2);
        manager.addNewSubtask(subtask3);

        System.out.println(manager.getAllTasks());
        System.out.println(manager.getAllEpics());
        System.out.println(manager.getAllSubtasks());

        System.out.println("МЕНЯЕМ СТАТУСЫ");

        task1.setStatus("DONE");
        task2.setStatus("DONE");
        epic1.setStatus("IN_PROGRESS");
        epic2.setStatus("IN_PROGRESS");
        subtask1.setStatus("DONE");
        subtask2.setStatus("IN_PROGRESS");
        subtask3.setStatus("DONE");

        manager.updateTask(task1);
        manager.updateTask(task2);
        manager.updateSubtask(subtask1);
        manager.updateSubtask(subtask2);
        manager.updateSubtask(subtask3);
        manager.updateEpic(epic1);
        manager.updateEpic(epic2);

        System.out.println(manager.getAllTasks());
        System.out.println(manager.getAllEpics());
        System.out.println(manager.getAllSubtasks());

        System.out.println("УДАЛЯЕМ");

        manager.deleteTask(1);
        manager.deleteEpic(3);

        System.out.println(manager.getAllTasks());
        System.out.println(manager.getAllEpics());
        System.out.println(manager.getAllSubtasks());

    }
}
