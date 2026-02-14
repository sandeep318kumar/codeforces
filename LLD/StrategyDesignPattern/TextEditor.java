class TextEditor {
    private TextFormatter textFormatter;

    public void setTextFormatter(TextFormatter textFormatter) {
        this.textFormatter = textFormatter;
    }

    // public void getTextFormatter() {
    // }

    public void publishTheText(String text) {
        if(textFormatter == null) {
            System.out.println("Error: no text formatter selected.");
        } else {
            System.out.println(textFormatter.getClass());
            textFormatter.formatText(text);
        }
    }
}