import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArgsSchema {
    private final Map<String, ArgSpec> argSpecDict;

    public ArgsSchema(String schemaText) {
        argSpecDict = new HashMap<>();
        extractorSchema(schemaText);
    }

    private void extractorSchema(String schemaText) {
        String[] split = schemaText.split(" ");
        Arrays.asList(split).stream().map(ArgSpec::build).filter(arg -> arg != null).forEach(a -> argSpecDict.put(a.label, a));
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
            if (b && argSpecDict.get(split[0].substring(1))!=null) {
                ct = argSpecDict.get(split[0].substring(1)).set(ct.substring(2));
            }else {
                ct = ct.substring(split[0].length()).trim();
            }
        }
    }
}
