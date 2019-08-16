public class PortFlag implements IFlag {
    int value;
    String parserRes;

    public PortFlag() {
        this.value = (Integer) getDefaultValue();
        parserRes = "";
    }

    public String getFlag() {
        return "-p";
    }

    public Object getDefaultValue() {
        return 8080;
    }

    public Object getType() {
        return Integer.class;
    }

    public Object getValue() {
        return value;
    }

    public int set(String[] split, int index) {
        int i = 0;
        if (i != split.length - 1) {
            value = Integer.parseInt(split[i + 1]);
            parserRes = ParserMes.success;
            index = index + 2;
        } else {
            parserRes = ParserMes.needPortNum;
            index = index + 1;
        }
        return index;
    }

    public String getParserRes() {
        return parserRes;
    }
}
