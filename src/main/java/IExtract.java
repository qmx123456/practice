import java.util.List;

public abstract class IExtract {

    private static final String listIntegerType = "list<integer>";
    private static final String listStringType = "list<string>";
    private static final String boolType = "boolean";
    private static final String integerType = "integer";
    private static final String stringType = "string";
    public abstract int extract(String commandTexts, ArgSpec argSpec);

    public abstract void valueIfInputValue(String val, ArgSpec argSpec);

    public abstract void valueIfNotInput(ArgSpec argSpec);

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

    public void getDefaultValue(List<String> splits, ArgSpec argSpec) {
        if (splits.size() == 2) {
            valueIfNotInput(argSpec);
        }
        else{
            valueIfInputValue(splits.get(2), argSpec);
        }
    }

    public static IExtract build(String typeText) {
        IExtract extractor = null;
        switch (typeText) {
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

    public static boolean isTypeRight(String typeText) {
            return typeText.equals(boolType) || typeText.equals(integerType)
                    || typeText.equals(stringType) || typeText.equals(listStringType) || typeText.equals(listIntegerType);
    }
}
