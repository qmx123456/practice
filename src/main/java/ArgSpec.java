
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArgSpec {
    public final String label;
    public final String type;
    public Object value;
    IExtract extract;

    public ArgSpec(String label, String type, IExtract extract) {
        this.label = label;
        this.type = type;
        this.extract = extract;
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
        if (flagFormat && IExtract.isTypeRight(typeText)) {
            IExtract extract = IExtract.build(typeText);
            ArgSpec argSpec = new ArgSpec(labelText, typeText, extract);
            extract.getDefaultValue(splits, argSpec);
            return argSpec;
        }
        return null;
    }

    public String set(String valueText) {
        int index = extract.extract(valueText, this);
        return valueText.substring(index);
    }
}
