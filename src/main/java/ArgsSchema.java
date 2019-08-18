import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ArgsSchema {
    private final List<ArgSpec> argSpecs;
    private String schemaText;

    public ArgsSchema(String schemaText) {
        this.schemaText = schemaText;
        String[] split = schemaText.split(" ");
        argSpecs = Arrays.asList(split).stream().map(ArgSpec::build).filter(arg-> arg != null).collect(Collectors.toList());
    }

    public int count() {
        return argSpecs.size();
    }

    public ArgSpec get(String label) {
        Optional<ArgSpec> candidate = argSpecs.stream().filter(arg -> arg.label.equals(label)).findFirst();
        if (candidate.isPresent()) {
            return candidate.get();
        }else {
            return null;
        }
    }
}
