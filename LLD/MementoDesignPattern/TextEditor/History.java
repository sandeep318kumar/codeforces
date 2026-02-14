import java.util.Stack;

class History {
    Stack<EditorMemento> history = new Stack<>();

    public void save(EditorMemento memento) {
        history.push(memento);
    }
 
    public EditorMemento undo() {
        return history.pop();
    }
}