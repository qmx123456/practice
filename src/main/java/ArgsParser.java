public class ArgsParser {
    private final ArgsSchema argsSchema;

    public ArgsParser(String schemaText) {
        argsSchema = new ArgsSchema(schemaText);
    }

    public void parser(String commandText) {
        String[] split = commandText.split(" ");
        for (int i=0; i< split.length;){
            ArgSpec argSpec = argsSchema.get(split[i].replace("-",""));
            if (argSpec != null){
                i = argSpec.resolve(split, i);
            }else {
                i++;
            }
        }
    }

    public Object get(String name) {
        return argsSchema.get(name).value;
    }
}
