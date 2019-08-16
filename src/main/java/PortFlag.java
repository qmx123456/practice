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

    public String set(String[] split) {
        int i=0;
        for (;i<split.length;i++){
            if (split[i].equals(getFlag())){
                if (i!=split.length-1) {
                    value = Integer.parseInt(split[i + 1]);
                    break;
                }
            }
        }
        if (i == split.length){
            return ParserMes.notContained;
        }
        return ParserMes.success;
    }
}
