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

    public ArgSpec(String argText) {
        String[] split = argText.split(":");
        label = split[0];
        type = split[1];
        value = getValue(Arrays.asList(split));
    }

    public ArgSpec(String label, String type, Object value) {
        this.label = label;
        this.type = type;
        this.value=value;
    }

    private static Object getValue(List<String> argSpecFlagTexts) {
        return argSpecFlagTexts.size() == 2 ? valueIfNotInput(argSpecFlagTexts) : valueIfInputValue(argSpecFlagTexts);
    }

    private static Object valueIfInputValue(List<String> argSpecFlagTexts) {
        switch (argSpecFlagTexts.get(1)) {
            case stringType:
                return String.valueOf(argSpecFlagTexts.get(2));
            case boolType:
                return Boolean.valueOf(argSpecFlagTexts.get(2));
            case integerType: {
                try {
                    return Integer.valueOf(argSpecFlagTexts.get(2));
                } catch (Exception e) {
                    return 0;
                }
            }
            default:
                return null;
        }
    }

    private static Object valueIfNotInput(List<String> argSpecFlagTexts) {
        switch (argSpecFlagTexts.get(1)) {
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

        String cType = splits.get(1);
        boolean typeFormat = cType.equals(boolType) || cType.equals(integerType) || cType.equals(stringType);

        if (flagFormat && typeFormat) {
            return new ArgSpec(labelText, cType, getValue(splits));
        }
        return null;
    }
}
