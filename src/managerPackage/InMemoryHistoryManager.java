package managerPackage;

import taskPackage.Task;

import java.util.LinkedList;

public class InMemoryHistoryManager implements HistoryManager{
    private static final int MAX_HISTORY_COUNT = 10;
    private LinkedList<Task> browsingHistory = new LinkedList<>();

    @Override
    public void add(Task task){
        if (browsingHistory.size() == MAX_HISTORY_COUNT) {
            browsingHistory.remove(0);
        }
        browsingHistory.add(task);
    }
    @Override
    public LinkedList<Task> getHistory(){
        return (LinkedList<Task>) browsingHistory.clone();
    }
}
