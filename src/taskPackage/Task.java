package taskPackage;

public class Task {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    private String status;
    private String name;
    private String description;

    public Task(String name, String description, String status) {
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

