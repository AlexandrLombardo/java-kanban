package TaskPackage;

public class Task {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    int id;
    public String status;
    String name;
    String discription;

    public Task(String name, String discription, String status) {
        this.id = 0;
        this.name = name;
        this.discription = discription;
        this.status = status;

    }

    @Override
    public String toString() {
        return "Task.Task{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", name='" + name + '\'' +
                ", discription='" + discription + '\'' +
                '}';
    }
}

