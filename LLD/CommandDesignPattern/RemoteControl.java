import java.util.Stack;
class RemoteControl {
    private Command command;
    private Stack<Command> undoStack = new Stack<>();
    private Stack<Command> redoStack = new Stack<>();

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
        undoStack.push(command);
    }

    public void undo() {
        if(!undoStack.isEmpty()) {
            Command command = undoStack.pop();
            redoStack.push(command);
            command.undo();
        }
    }

    public void redo() {
        if(!redoStack.isEmpty()) {
            Command command = redoStack.pop();
            command.execute();
        }
    }
}