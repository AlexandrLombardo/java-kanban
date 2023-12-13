package managerPackage;

import taskPackage.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTaskManager implements TaskManager{
    private int lastID;
    private HashMap<Integer,Task> taskList;
    private HashMap<Integer, Subtask> subtaskList;
    private HashMap<Integer, Epic> epicList;

    private HistoryManager historyManager = new Managers().getDefaultHistory();
    public InMemoryTaskManager() {
        lastID = 0;
        subtaskList = new HashMap<>();
        epicList = new HashMap<>();
        taskList = new HashMap<>();

     }
    //История просмотров задач
    @Override
    public List<Task> getHistory(){
        return historyManager.getHistory();
    }

    //a. Получение списка всех задач.
    @Override
    public List<Task> getAllTasks(){
        return  new ArrayList<Task>(taskList.values());
    }

    @Override
    public List<Epic> getAllEpics(){
        return new ArrayList<Epic>(epicList.values());
    }

    @Override
    public List<Subtask> getAllSubtasks(){
        return new ArrayList<Subtask>(subtaskList.values());
    }

    //b. Удаление всех задач.
    @Override
    public void deleteAllTasks(){
        taskList.clear();
    }

    @Override
    public void deleteAllSubtask(){

        for (Epic epic:epicList.values()) {
            epic.deleteAllSubtask();
            epic.updateStatus();
        }

        subtaskList.clear();
    }

    @Override
    public void deleteAllEpics(){
        deleteAllSubtask();
        epicList.clear();
    }

    //c. Получение по идентификатору.
    @Override
    public Task getTask (int ID){
        historyManager.add(taskList.get(ID));
        return taskList.get(ID);
    }

    @Override
    public Epic getEpic(int ID){
        historyManager.add(epicList.get(ID));
        return epicList.get(ID);
    }
    @Override
    public Subtask getSubtask(int ID){
        historyManager.add(subtaskList.get(ID));
        return subtaskList.get(ID);
    }
    @Override
    public Task getAnyTask(int ID){
        Task result = null;

        result = getTask(ID);
        if (result==null){
            result = getEpic(ID);
        }
        if (result==null) {
            result = getSubtask(ID);
        }
        return result;
    }

    @Override
    public List<Subtask> getSubtaskByEpic(Epic epic){
        return (List<Subtask>) epic.getSubtasks();
    }


    //d. Создание. Сам объект должен передаваться в качестве параметра.
    @Override
    public void addNewTask(Task task){
        task.setId(++lastID);
        task.setStatus(TaskStatus.NEW);
        taskList.put(task.getId(),task);
    }

    @Override
    public void addNewEpic(Epic epic){
        epic.setId(++lastID);
        epic.setStatus(TaskStatus.NEW);
        epicList.put(epic.getId(),epic);
    }

    @Override
    public void addNewSubtask(Subtask subtask){
        subtask.setId(++lastID);
        subtask.setStatus(TaskStatus.NEW);
        subtaskList.put(subtask.getId(),subtask);
    }
    //e. Обновление. Новая версия объекта с верным идентификатором передаётся в виде параметра.
    @Override
    public void updateTask(Task task){
        //Обновление статуса
        taskList.put(task.getId(),task);
    }

    @Override
    public void updateEpic(Epic epic){
        //Обновление статуса
        epic.updateStatus();
       epicList.put(epic.getId(),epic);
    }

    @Override
    public void updateSubtask(Subtask subtask){
        //Обновление статуса

        subtaskList.put(subtask.getId(),subtask);
        subtask.getEpic().updateStatus();
    }
    //f. Удаление по идентификатору.
    @Override
    public void deleteTask(int ID){
        taskList.remove(ID);
        historyManager.remove(ID);
    }

    @Override
    public void deleteEpic(int ID){
        for (Subtask subtask:epicList.get(ID).getSubtasks()) {
            deleteSubtask(subtask.getId());
        }
        epicList.remove(ID);
        historyManager.remove(ID);
    }

    @Override
    public void deleteSubtask(int ID){

        subtaskList.remove(ID);
        historyManager.remove(ID);

    }
}
