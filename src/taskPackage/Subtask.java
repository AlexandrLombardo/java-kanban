package taskPackage;

import managerPackage.TaskStatus;

public class Subtask extends Task {
    public Epic getEpic() {
        return epic;
    }

    private Epic epic;

    public Subtask(String name, String discription, TaskStatus status, Epic epic) {
        super(name, discription, status);
        this.epic = epic;
    }
}