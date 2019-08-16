public class DirectoryFlag implements IFlag {
    String value;
    String parserRes;
    public DirectoryFlag(){
        value=(String) getDefaultValue();
        parserRes = "";
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

    public int set(String[] split, int index) {
        if (index == split.length - 1){
            parserRes = ParserMes.needDirectory;
            index = index + 1;
        }else {
            value = split[index+1];
            index = index + 2;
        }
        return index;
    }

    public String getParserRes() {
        return parserRes;
    }

    public void clearParserRes() {
        parserRes = "";
    }
}
