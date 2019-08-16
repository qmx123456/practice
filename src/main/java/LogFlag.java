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

    public String set(String[] split) {
        for (int i=0;i<split.length;i++){
            if (split[i].equals(getFlag())){
                value = true;
                break;
            }
        }
        return ParserMes.success;
    }
}
