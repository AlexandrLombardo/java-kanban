package ManagerPackage;

import TaskPackage.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Manager {
    private ArrayList<String> statusList = new ArrayList<>();
    private int lastID;
    private HashMap<Integer,Task> taskList;
    private HashMap<Integer, Subtask> subtaskList;
    private HashMap<Integer, Epic> epicList;
    public Manager() {
        lastID = 0;
        subtaskList = new HashMap<>();
        epicList = new HashMap<>();
        taskList = new HashMap<>();
        //Хотел создать какую-то глобально видимую коллекцию чтобы в объектах Task.Task не хранить строку с названием статуса а только идентификатор статуса, например 1,2,3.
        // но получилось не очень удобно, так как методы внутри класса Task.Epic все равно не видят эту коллекцию
        statusList.add("NEW");
        statusList.add("IN_PROGRESS");
        statusList.add("DONE");
    }

    //a. Получение списка всех задач.
    public Collection<Task> getAllTasks(){
        return  taskList.values();
    }

    public Collection<Epic> getAllEpics(){
        return epicList.values();
    }

    public Collection<Subtask> getAllSubtasks(){
        return subtaskList.values();
    }

    //b. Удаление всех задач.
    public void deleteAllTasks(){
        taskList.clear();
    }

    public void deleteAllSubtask(){

        for (Epic epic:epicList.values()) {
            epic.deleteAllSubtask();
            epic.updateStatus();
        }

        subtaskList.clear();
    }

    public void deleteAllEpics(){
        deleteAllSubtask();
        epicList.clear();
    }

    //c. Получение по идентификатору.
    public Task getTaskByID(int ID){
        return taskList.get(ID);
    }

    public Epic getEpicByID(int ID){
        return epicList.get(ID);
    }

    public ArrayList<Subtask> getSubtaskByEpic(Epic epic){
        return epic.getSubtasks();
    }

    public Subtask getSubtaskByID(int ID){
        return subtaskList.get(ID);
    }
    //d. Создание. Сам объект должен передаваться в качестве параметра.
    public void addNewTask(Task task){
        task.setId(++lastID);
        task.status = statusList.get(0);
        taskList.put(task.getId(),task);
    }

    public void addNewEpic(Epic epic){
        epic.setId(++lastID);
        epic.status = statusList.get(0);
        epicList.put(epic.getId(),epic);
    }

    public void addNewSubtask(Subtask subtask){
        subtask.setId(++lastID);
        subtask.status = statusList.get(0);
        subtaskList.put(subtask.getId(),subtask);
    }
    //e. Обновление. Новая версия объекта с верным идентификатором передаётся в виде параметра.
    public void updateTask(Task task){
        //Обновление статуса
        taskList.put(task.getId(),task);
    }

    public void updateEpic(Epic epic){
        //Обновление статуса
        epic.updateStatus();
       epicList.put(epic.getId(),epic);
    }

    public void updateSubtask(Subtask subtask){
        //Обновление статуса

        subtaskList.put(subtask.getId(),subtask);
        subtask.epic.updateStatus();
    }
    //f. Удаление по идентификатору.
    public void deleteTask(int ID){
        taskList.remove(ID);
    }

    public void deleteEpic(int ID){
        for (Subtask subtask:epicList.get(ID).getSubtasks()) {
            deleteSubtask(subtask.getId());
        }
        epicList.remove(ID);
    }

    public void deleteSubtask(int ID){

        subtaskList.remove(ID);

    }
}
