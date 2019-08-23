public abstract class IExtract {

    public static final String listIntegerType = "list<integer>";
    public static final String listStringType = "list<string>";
    public static final String boolType = "boolean";
    public static final String integerType = "integer";
    public static final String stringType = "string";

    public abstract String extract(String commandTexts, ArgSpec argSpec);
    public abstract String getType();

    public abstract void valueDefault(ArgSpec argSpec);

    int calIndexForNextLabelStart(String commandTexts, int index) {
        return index + spacesStartWith(commandTexts.substring(index));
    }

    int spacesStartWith(String str) {
        int a = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                break;
            }
            a++;
        }
        return a;
    }

    public static IExtract build(String typeText) {
        String type = typeText.trim();
        IExtract extractor = null;
        switch (type) {
            case integerType:
                extractor = new IntegerExtractor();break;
            case boolType:
                extractor = new BooleanExtractor();break;
            case stringType:
                extractor = new StringExtractor();break;
            case listStringType:
                extractor = new ListStringExtractor();break;
            case listIntegerType:
                extractor = new ListIntegerExtractor();break;
        }
        return extractor;
    }

    public String getInitValue(String substring, ArgSpec argSpec){
        valueDefault(argSpec);
        return extract(substring, argSpec);
    }
}
