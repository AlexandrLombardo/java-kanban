package taskPackage;

import managerPackage.TaskStatus;

public class Task {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public TaskStatus getStatus() {
        return status;
    }

    private TaskStatus status;
    private String name;
    private String description;

    public Task(String name, String description, TaskStatus status) {
        this.id = 0;
        this.name = name;
        this.description = description;
        this.status = status;

    }

    @Override
    public String toString() {
        return "Task.Task{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

