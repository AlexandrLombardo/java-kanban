package taskPackage;

import java.util.ArrayList;

public class Epic extends Task {
    private ArrayList<Subtask> subtasks;

    public ArrayList<Subtask> getSubtasks() {
        return (ArrayList<Subtask>) subtasks.clone();
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
    public Epic(String name, String discription, String status) {
        super(name, discription, status);
        subtasks = new ArrayList<>();
    }
    public void updateStatus(){
        if (subtasks.isEmpty()) {
            this.setStatus("NEW");
            return;
        }

        int newCount = 0;
        int doneCount = 0;

        for (Subtask subtask:subtasks) {
            if (subtask.getStatus().equals("NEW")) {
                newCount++;
            } else if (subtask.getStatus().equals("DONE")) {
                doneCount++;
            }
        }

        if (subtasks.size() == newCount) {
            this.setStatus("NEW");
            return;
        }
        if (subtasks.size() == doneCount) {
            this.setStatus("DONE");
            return;
        }

        this.setStatus("IN_PROGRESS");
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