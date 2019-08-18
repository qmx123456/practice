import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArgSpec {
    public String label;
    public String type;
    private static final String boolType = "boolean";
    private static final String integerType = "integer";
    private static final String stringType = "string";
    public Object value;

    public ArgSpec(String label, String type, Object value) {
        this.label = label;
        this.type = type;
        this.value=value;
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
        List<String> splits = Arrays.asList(argText.split(":")).stream().map(t->t.trim()).collect(Collectors.toList());
        String labelText = splits.get(0);
        if (labelText.length() != 1 || splits.size() < 2) {
            return null;
        }
        char flagChar = labelText.charAt(0);
        boolean flagFormat = (flagChar >= 'a' && flagChar <= 'z') || (flagChar >= 'A' && flagChar <= 'Z');

        String typeText = splits.get(1);
        boolean typeFormat = typeText.equals(boolType) || typeText.equals(integerType) || typeText.equals(stringType);

        if (flagFormat && typeFormat) {
            return new ArgSpec(labelText, typeText, getValue(splits));
        }
        return null;
    }

    public int set(String[] commandTexts, int index) {
        value = valueIfInputValue(type, commandTexts[index+1]);
        index = index + 2;
        return index;
    }
}
