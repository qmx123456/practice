public class Logging implements IFlag {
    public String getFlag() {
        return "-l";
    }

    public Object getDefaultValue() {
        return false;
    }

    public Class<Boolean> getType() {
        return boolean.class;
    }
}
