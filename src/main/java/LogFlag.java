public class LogFlag implements IFlag {
    boolean value;
    public LogFlag(){
        this.value=(Boolean) getDefaultValue();
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
}
