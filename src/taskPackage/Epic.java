package taskPackage;

import managerPackage.TaskStatus;

import java.util.ArrayList;
import java.util.List;

public class Epic extends Task {
    private List<Subtask> subtasks;

    public List<Subtask> getSubtasks() {
        return new ArrayList<>(subtasks);
    }

    public void addSubtask(Subtask subtask) {
        subtasks.add(subtask);
    }
    public void deleteAllSubtask() {
        subtasks.clear();
    }
    public void deleteSubtask(Subtask subtask) {
        subtasks.remove(subtask);
    }
    public Epic(String name, String discription, TaskStatus status) {
        super(name, discription, status);
        subtasks = new ArrayList<>();
    }
    public void updateStatus(){
        if (subtasks.isEmpty()) {
            this.setStatus(TaskStatus.NEW);
            return;
        }

        int newCount = 0;
        int doneCount = 0;

        for (Subtask subtask:subtasks) {
            if (subtask.getStatus() == TaskStatus.NEW) {
                newCount++;
            } else if (subtask.getStatus() == TaskStatus.DONE) {
                doneCount++;
            }
        }

        if (subtasks.size() == newCount) {
            this.setStatus(TaskStatus.NEW);
            return;
        }
        if (subtasks.size() == doneCount) {
            this.setStatus(TaskStatus.DONE);
            return;
        }

        this.setStatus(TaskStatus.IN_PROGRESS);
    }
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder(super.toString() + "\n");
        for (Subtask subtask:subtasks) {
            str.append("subtask").append(subtask.toString()).append("\n");
        }
        return str.toString();
        }
    }