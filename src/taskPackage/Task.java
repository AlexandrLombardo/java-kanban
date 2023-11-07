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
    private TaskStatus status;
    private String name;
    private String description;

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


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

