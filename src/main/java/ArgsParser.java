public class ArgsParser {

    private final ArgsSchema argsSchema;

    public ArgsParser(String schemaText) {
        argsSchema = new ArgsSchema(schemaText);
    }

    public Object get(String label) {
        ArgSpec argSpec = argsSchema.get(label);
        if (argSpec != null) {
            return argSpec.value;
        } else {
            return null;
        }
    }

    public void parse(String commandText){
        argsSchema.parse(commandText);
    }
}
