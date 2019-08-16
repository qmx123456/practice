public class PortFlag implements IFlag {
    int value;
    public PortFlag(){
        this.value = (Integer) getDefaultValue();
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
}
