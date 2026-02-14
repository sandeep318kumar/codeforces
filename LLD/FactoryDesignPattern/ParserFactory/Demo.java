class Demo {
    public static void main(String[] args) {
        Parser parser = ParserFactory.getParser("pdf");
        parser.parser("resume.txt");

        parser = ParserFactory.getParser("word");
        parser.parser("Here there");
    }
}