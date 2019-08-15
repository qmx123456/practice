public class PortFlag implements IFlag {
    public String getFlag() {
        return "-p";
    }

    public Object getDefaultValue() {
        return 8080;
    }

    public Object getType() {
        return Integer.class;
    }
}
