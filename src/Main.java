import managerPackage.InMemoryTaskManager;
import managerPackage.TaskStatus;
import taskPackage.*;

public class Main {
    public static void main(String[] args) {

        //Тестовые данные
        Task task1 = new Task("Задача №1","Описание ЗАДАЧИ №1", TaskStatus.NEW);
        Task task2 = new Task("Задача №2","Описание ЗАДАЧИ №2",TaskStatus.NEW);
        Epic epic1 = new Epic("Эпик №1","Описание ЭПИКА №1",TaskStatus.NEW);
        Epic epic2 = new Epic("Эпик №2","Описание ЭПИКА №2",TaskStatus.NEW);
        Subtask subtask1 = new Subtask("Подзадача №1","Описание ПОДЗАДАЧИ №1",TaskStatus.NEW,epic1);
        Subtask subtask2 = new Subtask("Подзадача №2","Описание ПОДЗАДАЧИ №2",TaskStatus.NEW,epic1);
        Subtask subtask3 = new Subtask("Подзадача №3","Описание ПОДЗАДАЧИ №3",TaskStatus.NEW,epic2);
        epic1.addSubtask(subtask1);
        epic1.addSubtask(subtask2);
        epic2.addSubtask(subtask3);

        InMemoryTaskManager inMemoryTaskManager = new InMemoryTaskManager();

        inMemoryTaskManager.addNewTask(task1);
        inMemoryTaskManager.addNewTask(task2);
        inMemoryTaskManager.addNewEpic(epic1);
        inMemoryTaskManager.addNewEpic(epic2);
        inMemoryTaskManager.addNewSubtask(subtask1);
        inMemoryTaskManager.addNewSubtask(subtask2);
        inMemoryTaskManager.addNewSubtask(subtask3);

        System.out.println(inMemoryTaskManager.getTasks());
        System.out.println(inMemoryTaskManager.getAllEpics());
        System.out.println(inMemoryTaskManager.getAllSubtasks());

        System.out.println("МЕНЯЕМ СТАТУСЫ");

        task1.setStatus(TaskStatus.DONE);
        task2.setStatus(TaskStatus.DONE);
        epic1.setStatus(TaskStatus.IN_PROGRESS);
        epic2.setStatus(TaskStatus.IN_PROGRESS);
        subtask1.setStatus(TaskStatus.DONE);
        subtask2.setStatus(TaskStatus.IN_PROGRESS);
        subtask3.setStatus(TaskStatus.DONE);

        inMemoryTaskManager.updateTask(task1);
        inMemoryTaskManager.updateTask(task2);
        inMemoryTaskManager.updateSubtask(subtask1);
        inMemoryTaskManager.updateSubtask(subtask2);
        inMemoryTaskManager.updateSubtask(subtask3);
        inMemoryTaskManager.updateEpic(epic1);
        inMemoryTaskManager.updateEpic(epic2);

        System.out.println(inMemoryTaskManager.getTasks());
        System.out.println(inMemoryTaskManager.getAllEpics());
        System.out.println(inMemoryTaskManager.getAllSubtasks());

        System.out.println("УДАЛЯЕМ");

        inMemoryTaskManager.deleteTask(1);
        inMemoryTaskManager.deleteEpic(3);

        System.out.println(inMemoryTaskManager.getTasks());
        System.out.println(inMemoryTaskManager.getAllEpics());
        System.out.println(inMemoryTaskManager.getAllSubtasks());

        //Получение и вывод истории
        System.out.println("ПРОВЕРЯЕМ ИСТОРИЮ");
        System.out.println(inMemoryTaskManager.getTask(2));
        System.out.println(inMemoryTaskManager.getTask(2));
        System.out.println(inMemoryTaskManager.getTask(2));
        System.out.println(inMemoryTaskManager.getTask(2));
        System.out.println(inMemoryTaskManager.getEpic(4));
        System.out.println(inMemoryTaskManager.getSubtask(7));

        inMemoryTaskManager.deleteTask(2);
        inMemoryTaskManager.deleteEpic(4);
        System.out.println(inMemoryTaskManager.getAllSubtasks());
        System.out.println("ПОСЛЕ УДАЛЕНИЯ");
        System.out.println(inMemoryTaskManager.getHistory());


    }
}
