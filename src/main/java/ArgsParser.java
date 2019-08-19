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

    public void parse1(String commandText) {
        for (int i = 0; i < commandText.length(); ) {
            int slashIndex = i;
            int labelIndex = i + 1;
            int spaceIndex = i+2;
            String slash = commandText.substring(slashIndex, labelIndex);
            if (slash.equals("-")) {
                String labelText = commandText.substring(labelIndex, labelIndex+1);
                //todo 确定label后面有space分割 并增加测试
                ArgSpec argSpec = argsSchema.get(labelText);
                if (argSpec != null) {
                    i = argSpec.set(commandText, labelIndex);
                } else {
                    i = labelIndex;
                }
            }
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
