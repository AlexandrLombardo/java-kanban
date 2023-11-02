package TaskPackage;

import java.util.ArrayList;

public class Epic extends Task {
    private ArrayList<Subtask> subtasks;

    public ArrayList<Subtask> getSubtasks() {
        return subtasks;
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
            status = "NEW";
            return;
        }

        int newCount = 0;
        int doneCount = 0;

        for (Subtask subtask:subtasks) {
            if (subtask.status.equals("NEW")) {
                newCount++;
            } else if (subtask.status.equals("DONE")) {
                doneCount++;
            }
        }

        if (subtasks.size() == newCount) {
            status = "NEW";
            return;
        }
        if (subtasks.size() == doneCount) {
            status = "DONE";
            return;
        }

        status = "IN_PROGRESS";
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