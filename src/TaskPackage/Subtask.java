package TaskPackage;

public class Subtask extends Task {
    public Epic epic;

    public Subtask(String name, String discription, String status, Epic epic) {
        super(name, discription, status);
        this.epic = epic;
    }
}