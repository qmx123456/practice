public class Directory implements IFlag {
    public String getFlag() {
        return "-d";
    }

    public Object getDefaultValue() {
        return "";
    }

    public Object getType() {
        return String.class;
    }
}
