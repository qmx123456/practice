public class DirectoryFlag implements IFlag {
    String value;

    public DirectoryFlag(){
        value=(String) getDefaultValue();
    }
    public String getFlag() {
        return "-d";
    }

    public Object getDefaultValue() {
        return "";
    }

    public Object getType() {
        return String.class;
    }

    public Object getValue() {
        return value;
    }

    public String set(String[] split) {
        return null;
    }
}
