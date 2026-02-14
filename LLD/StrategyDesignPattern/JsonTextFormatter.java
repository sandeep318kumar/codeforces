class JsonTextFormatter implements TextFormatter {
    public void formatText(String text) {
        System.out.println("Json format is: {context: \n" + text + "}" );
    }
}