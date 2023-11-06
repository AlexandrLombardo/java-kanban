package managerPackage;

import taskPackage.Task;

import java.util.ArrayList;
import java.util.List;

public class InMemoryHistoryManager implements HistoryManager{
    private static final int MAX_HISTORY_COUNT = 10;
    private List<Task> browsingHistory;

    public InMemoryHistoryManager() {
        browsingHistory = new ArrayList<>();
    }

    @Override
    public void add(Task task){
        if (browsingHistory.size() == MAX_HISTORY_COUNT) browsingHistory.remove(0);
        browsingHistory.add(task);
    }
    @Override
    public List<Task> getHistory(){
        return browsingHistory;
    }
}
