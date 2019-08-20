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

    public void parse1(String commandText){
        argsSchema.parse(commandText);
    }

    public void parse(String commandText) {
        int length = commandText.length();
        for (int i = 0; i < length; ) {
            int labelEndIndex = i + 2;
            int labelStartIndex = i + 1;
            boolean isLabelFormat = commandText.charAt(i) == '-' && labelEndIndex <= length - 1
                    && commandText.charAt(labelEndIndex) == ' ';
            if (isLabelFormat && argsSchema.get(commandText.substring(labelStartIndex, labelEndIndex)) != null) {
                i = argsSchema.get(commandText.substring(labelStartIndex, labelEndIndex)).set(commandText, i);
            } else {
                i = calIndex(commandText, i);
            }
        }
    }

    private int calIndex(String commandText, int index) {
        for (int j = index; j < commandText.length(); j++) {
            if (commandText.charAt(j) == ' ') {
                return j+1;
            }
        }
        return index+1;
    }
}
