class Runner {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        History history = new History();

        editor.type("Hello");
        history.save(editor.save());

        editor.type("Dogs");
        history.save(editor.save());

        System.out.println("current: " + editor.getContent());

        editor.restore(history.undo());
        System.out.println("after undo: " + editor.getContent());

        editor.restore(history.undo());
        System.out.println("after undo: " + editor.getContent());
    }
}