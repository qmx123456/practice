import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArgsSchema {
    private final String[] schemaTexts;
    private final List<ArgSpec> argSpecs;
    private String argsSchemaText;

    public ArgsSchema(String argsSchemaText) {
        schemaTexts = argsSchemaText.split(" ");
        argSpecs = Arrays.asList(schemaTexts).stream().map(ArgSpec::new).collect(Collectors.toList());
    }

    public int size() {
        return argSpecs.size();
    }

    public ArgSpec get(String label) {
        return argSpecs.stream().filter(arg-> arg.label.equals(label)).findFirst().get();
    }
}
