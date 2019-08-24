public class ExtractorFactory {

    public static IExtract build(String typeText) {
        String type = typeText.trim();
        IExtract extractor = null;
        switch (type) {
            case "integer":
                extractor = new IntegerExtractor();break;
            case "boolean":
                extractor = new BooleanExtractor();break;
            case "string":
                extractor = new StringExtractor();break;
            case "list<string>":
                extractor = new ListStringExtractor();break;
            case "list<integer>":
                extractor = new ListIntegerExtractor();break;
        }
        return extractor;
    }
}
