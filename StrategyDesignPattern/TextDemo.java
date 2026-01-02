class TextDemo {
    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();
        String text = "Hello, I am here";

        textEditor.setTextFormatter(new HtmlTextFormatter());
        textEditor.publishTheText(text);

        textEditor.setTextFormatter(new PlainTextFormatter());
        textEditor.publishTheText(text);

        textEditor.setTextFormatter(new JsonTextFormatter());
        textEditor.publishTheText(text);

        textEditor.setTextFormatter(System.out::println);
        textEditor.publishTheText("Direct plain text");
    }
}