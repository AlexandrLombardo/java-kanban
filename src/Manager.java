import java.util.ArrayList;
import java.util.HashMap;

public class Manager {
    ArrayList<String> statusList = new ArrayList<>(); //{"NEW","IN_PROGRESS","DONE"};
    int lastID;
    HashMap<Integer,Task> taskList;
    HashMap<Integer,Subtask> subtaskList;
    HashMap<Integer,Epic> epicList;
    public Manager() {
        lastID = 0;
        subtaskList = new HashMap<>();
        epicList = new HashMap<>();
        taskList = new HashMap<>();
        //Хотел создать какую-то глобально видимую коллекцию чтобы в объектах Task не хранить строку с названием статуса а только идентификатор статуса, например 1,2,3.
        // но получилось не очень удобно, так как методы внутри класса Epic все равно не видят эту коллекцию
        statusList.add("NEW");
        statusList.add("IN_PROGRESS");
        statusList.add("DONE");
    }

    //a. Получение списка всех задач.
    public HashMap<Integer,Task> getAllTasks(){
        return taskList;
    }

    public HashMap<Integer,Epic> getAllEpics(){
        return epicList;
    }

    public HashMap<Integer,Subtask> getAllSubtasks(){
        return subtaskList;
    }

    //b. Удаление всех задач.
    public void deleteAllTasks(){
        taskList.clear();
    }

    public void deleteAllSubtask(){
        subtaskList.clear();
    }

    public void deleteAllEpics(){
        epicList.clear();
    }

    //c. Получение по идентификатору.
    public Task getTaskByID(int ID){
        return taskList.get(ID);
    }

    public Epic getEpicByID(int ID){
        return epicList.get(ID);
    }

    public Subtask getSubtaskByID(int ID){
        return subtaskList.get(ID);
    }
    //d. Создание. Сам объект должен передаваться в качестве параметра.
    public void addNewTask(Task task){
        task.id = ++lastID;
        task.status = statusList.get(0);
        taskList.put(task.id,task);
    }

    public void addNewEpic(Epic epic){
        epic.id = ++lastID;
        epic.status = statusList.get(0);
        epicList.put(epic.id,epic);
    }

    public void addNewSubtask(Subtask subtask){
        subtask.id = ++lastID;
        subtask.status = statusList.get(0);
        subtaskList.put(subtask.id,subtask);
    }
    //e. Обновление. Новая версия объекта с верным идентификатором передаётся в виде параметра.
    public void updateTask(Task task){
        //Обновление статуса
        taskList.put(task.id,task);
    }

    public void updateEpic(Epic epic){
        //Обновление статуса
        epic.updateStatus();
       epicList.put(epic.id,epic);
    }

    public void updateSubtask(Subtask subtask){
        //Обновление статуса

        subtaskList.put(subtask.id,subtask);
        subtask.epic.updateStatus();
    }
    //f. Удаление по идентификатору.
    public void deleteTask(int ID){
        taskList.remove(ID);
    }

    public void deleteEpic(int ID){
        epicList.remove(ID);
    }

    public void deleteSubtask(int ID){
        subtaskList.remove(ID);
    }
}
