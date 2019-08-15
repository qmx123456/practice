public class FlagArg implements IFlag {
    public String getFlag() {
        return "-l";
    }

    public boolean getDefaultValue() {
        return false;
    }

    public String getType() {
        return "bool";
    }
}
