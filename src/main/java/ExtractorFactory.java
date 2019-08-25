public class ExtractorFactory {

    public static IExtract build(String typeText) {
        String type = typeText.trim();
        IExtract extractor = null;
        switch (type) {
            case "integer":
                extractor = IntegerExtractor.build();break;
            case "boolean":
                extractor = BooleanExtractor.build();break;
            case "string":
                extractor = StringExtractor.build();break;
            case "list<string>":
                extractor = ListStringExtractor.build();break;
            case "list<integer>":
                extractor = ListIntegerExtractor.build();break;
        }
        return extractor;
    }
}
