package managerPackage;

import taskPackage.Epic;
import taskPackage.Subtask;
import taskPackage.Task;
import java.util.List;


public interface TaskManager {

    List<Task> getHistory();
    //a. Получение списка всех задач.
    List<Task> getAllTasks();

    List<Epic> getAllEpics();

    List<Subtask> getAllSubtasks();

    //b. Удаление всех задач.
    void deleteAllTasks();

    void deleteAllSubtask();

    void deleteAllEpics();

    //c. Получение по идентификатору.
    Task getTask(int ID);

    Epic getEpic(int ID);

    List<Subtask> getSubtaskByEpic(Epic epic);

    Subtask getSubtask(int ID);
    //d. Создание. Сам объект должен передаваться в качестве параметра.
    void addNewTask(Task task);

    void addNewEpic(Epic epic);

    void addNewSubtask(Subtask subtask);
    //e. Обновление. Новая версия объекта с верным идентификатором передаётся в виде параметра.
    void updateTask(Task task);

    void updateEpic(Epic epic);

    void updateSubtask(Subtask subtask);
    //f. Удаление по идентификатору.
    void deleteTask(int ID);

    void deleteEpic(int ID);

    void deleteSubtask(int ID);
}
