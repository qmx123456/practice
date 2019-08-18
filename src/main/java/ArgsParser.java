public class ArgsParser {

    private final ArgsSchema argsSchema;

    public ArgsParser(String schemaText) {
        argsSchema = new ArgsSchema(schemaText);
    }

    public Object get(String label) {
        return null;
    }

    public void parse(String commandText) {

    }
}
