
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArgSpec {
    private static final String listStringType = "list<string>";
    private static final String listIntegerType = "list<integer>";
    public String label;
    public String type;
    private static final String boolType = "boolean";
    private static final String integerType = "integer";
    private static final String stringType = "string";
    public Object value;

    public ArgSpec(String label, String type, Object value) {
        this.label = label;
        this.type = type;
        this.value = value;
    }

    private static Object getValue(List<String> argSpecFlagTexts) {
        String typeText = argSpecFlagTexts.get(1);
        return argSpecFlagTexts.size() == 2 ? valueIfNotInput(typeText) : valueIfInputValue(typeText, argSpecFlagTexts.get(2));
    }

    private static Object valueIfInputValue(String type, String val) {
        switch (type) {
            case stringType:
                return String.valueOf(val);
            case boolType:
                return Boolean.valueOf(val);
            case integerType: {
                try {
                    return Integer.valueOf(val);
                } catch (Exception e) {
                    return 0;
                }
            }
            case listStringType:

            default:
                return null;
        }
    }

    private static Object valueIfNotInput(String type) {
        switch (type) {
            case stringType:
                return "";
            case boolType:
                return false;
            case integerType:
                return 0;
            case listStringType:
                return new ArrayList<String>();
            case listIntegerType:
                return new ArrayList<Integer>();
            default:
                return null;
        }
    }

    @Override
    public boolean equals(Object obj) {
        ArgSpec another = (ArgSpec) obj;
        return type.equals(another.type) && label.equals(another.label);
    }

    public static ArgSpec build(String argText) {
        List<String> splits = Arrays.asList(argText.split(":")).stream().map(t -> t.trim()).collect(Collectors.toList());
        String labelText = splits.get(0);
        if (labelText.length() != 1 || splits.size() < 2) {
            return null;
        }
        char flagChar = labelText.charAt(0);
        boolean flagFormat = (flagChar >= 'a' && flagChar <= 'z') || (flagChar >= 'A' && flagChar <= 'Z');

        String typeText = splits.get(1);
        boolean typeFormat = typeText.equals(boolType) || typeText.equals(integerType)
                || typeText.equals(stringType) || typeText.equals(listStringType) || typeText.equals(listIntegerType);

        if (flagFormat && typeFormat) {
            return new ArgSpec(labelText, typeText, getValue(splits));
        }
        return null;
    }

    private int calIndexForNextLabelStart(String commandTexts, int index) {
        return index + spacesCountStartWith(commandTexts.substring(index));
    }

    private int calIndexForValueStart(String commandTexts, int index) {
        int slashLength = 1;
        int labelLength = 1;
        int indexAfterLabel = index + slashLength + labelLength;
        String textContainValue = commandTexts.substring(indexAfterLabel);
        index = indexAfterLabel + spacesCountStartWith(textContainValue);
        return index;
    }

    private int spacesCountStartWith(String str) {
        int a = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                break;
            }
            a++;
        }
        return a;
    }

    public String set(String commandTexts) {
        int index=0;
        int indexForValueStart = calIndexForValueStart(commandTexts, 0);

        switch (type) {
            case integerType:
                index = tryExtractInteger(commandTexts, indexForValueStart);break;
            case boolType:
                index = tryExtractBoolean(commandTexts, indexForValueStart);break;
            case stringType:
                index = tryExtractDirectory(commandTexts, indexForValueStart);break;
            case listStringType:
                index = tryExtractListStringValue(commandTexts,indexForValueStart);break;
        }
        return commandTexts.substring(index);
    }

    private int tryExtractInteger(String commandTexts, int indexForValueStart) {
        String valueText = commandTexts.substring(indexForValueStart).split(" ")[0];
        int index = indexForValueStart;
        if (valueText.matches("[0-9]+")) {
            value = Integer.parseInt(valueText);
            int valueEndIndex2 = indexForValueStart + valueText.length();
            index = calIndexForNextLabelStart(commandTexts, valueEndIndex2);
        }
        return index;
    }

    private int tryExtractBoolean(String commandTexts, int indexForValueStart) {
        String valueText = commandTexts.substring(indexForValueStart).split(" ")[0];

        int index = indexForValueStart;
        if (valueText.equals("false") || valueText.equals("true")) {
            value = Boolean.valueOf(valueText);
            int valueEndIndex1 = indexForValueStart + valueText.length();
            index = calIndexForNextLabelStart(commandTexts, valueEndIndex1);
        }
        return index;
    }

    private int tryExtractDirectory(String commandTexts, int indexForValueStart) {
        String valueText = commandTexts.substring(indexForValueStart).split(" ")[0];

        int res = indexForValueStart;
        File file = new File(valueText);
        if (file.isDirectory()) {
            value = valueText;
            int valueEndIndex = indexForValueStart + valueText.length();
            res = calIndexForNextLabelStart(commandTexts, valueEndIndex);
        }
        return res;
    }

    private int tryExtractListStringValue(String commandTexts, int indexForValueStart) {
        String textWithValue = commandTexts.substring(indexForValueStart);
        int res = indexForValueStart;
        if (textWithValue.charAt(0)=='[' && textWithValue.contains("]")){
            String[] splitValue = textWithValue.substring(1).split("]");
            if (splitValue.length > 0 && !splitValue[0].equals("")) {
                String value = splitValue[0];
                this.value = Arrays.asList(value.split(","));
                int valueEndIndex = indexForValueStart + 1 + value.length() + 1;
                res = calIndexForNextLabelStart(commandTexts, valueEndIndex);
            }else {
                this.value = Arrays.asList(new String[]{});
                int valueEndIndex = indexForValueStart + 1 + 1;
                res = calIndexForNextLabelStart(commandTexts, valueEndIndex);
            }
        }
        return res;
    }

}
