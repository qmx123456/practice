import java.util.HashMap;
import java.util.Map;

public class ArgsSchema {
    private final Map<String, ArgSpec> argSpecDict;

    public ArgsSchema(String schemaText) {
        argSpecDict = new HashMap<>();
        extractSchema(schemaText);
    }

    private void extractSchema(String schemaText) {
        String ct = schemaText.trim();
        String[] split;
        while (ct.length() > 3) {
            split = ct.split(":");
            String labelText = split[0];
            if (split.length >= 2) {
                String label = extractLabel(split[0]);
                IExtract extract = IExtract.build(split[1]);
                if (label != null && extract != null) {
                    ArgSpec argSpec = new ArgSpec(label, extract);
                    ct = extract.getInitValue(ct.substring(labelText.length() + split[1].length() + 2), argSpec);
                    argSpecDict.put(argSpec.label, argSpec);
                } else {
                    ct = ct.substring(labelText.length() + 1);
                }
            } else {
                ct = ct.substring(labelText.length());
            }
        }
    }

    private String extractLabel(String labelText) {
        String label = labelText.trim();
        char flagChar = label.charAt(0);
        boolean flagFormat = (flagChar >= 'a' && flagChar <= 'z') || (flagChar >= 'A' && flagChar <= 'Z');
        boolean b = label.length() == 1;
        if (b && flagFormat) {
            return label;
        }
        return null;
    }

    public int count() {
        return argSpecDict.size();
    }

    public ArgSpec get(String label) {
        return argSpecDict.get(label);
    }

    public void parse(String commandText) {
        String ct = commandText.trim();
        String[] split;
        while (ct.length() > 0) {
            split = ct.split(" ");
            boolean b = split[0].length() == 2 && split[0].charAt(0) == '-';
            if (b && argSpecDict.get(split[0].substring(1)) != null) {
                ct = argSpecDict.get(split[0].substring(1)).set(ct.substring(2));
            } else {
                ct = ct.substring(split[0].length()).trim();
            }
        }
    }
}
