public class LogFlag implements IFlag {
    private String parserRes;
    boolean value;

    public LogFlag() {
        this.value = (Boolean) getDefaultValue();
        parserRes = "";
    }

    public String getFlag() {
        return "-l";
    }

    public Object getDefaultValue() {
        return false;
    }

    public Class<Boolean> getType() {
        return boolean.class;
    }

    public Object getValue() {
        return value;
    }

    public int set(String[] split, int index) {
        value = true;
        parserRes = ParserMes.success;
        index = index+1;
        return index;
    }

    public String getParserRes() {
        return parserRes;
    }

    public void clearParserRes() {

    }

    public String out() {
        return "log: " + String.valueOf(value);
    }
}
