public class ArgsParser {

    private final ArgsSchema argsSchema;

    public ArgsParser(String schemaText) {
        argsSchema = new ArgsSchema(schemaText);
    }

    public Object get(String label) {
        ArgSpec argSpec = argsSchema.get(label);
        if (argSpec != null) {
            return argSpec.value;
        }else {
            return null;
        }
    }

    public void parse(String commandText) {
        String[] split = commandText.split(" ");
        for (int i=0; i<split.length;){
            ArgSpec argSpec = argsSchema.get(split[i].replace("-", ""));
            if (argSpec != null) {
                i = argSpec.set(split, i);
            } else {
                i = i + 1;
            }
        }
    }
}
