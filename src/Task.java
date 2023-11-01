public class Task {
    int id;
    String status;
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
        return "Task{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", name='" + name + '\'' +
                ", discription='" + discription + '\'' +
                '}';
    }
}

