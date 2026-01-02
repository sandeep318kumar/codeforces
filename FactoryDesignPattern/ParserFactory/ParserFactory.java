class ParserFactory {
    public static Parser getParser(String fileType) {
        if(fileType == "pdf") {
            return new PdfParser();
        }
        if(fileType == "word") {
            return new WordParser();
        }
        throw new IllegalArgumentException("Unsupported file type: " + fileType);
    }
}