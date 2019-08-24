public abstract class IExtract {
    public String type;

    public abstract String extract(String commandTexts, ArgSpec argSpec);
    public abstract void valueDefault(ArgSpec argSpec);

    int calIndexForNextLabelStart(String commandTexts, int index) {
        return index + spacesStartWith(commandTexts.substring(index));
    }

    int spacesStartWith(String str) {
        int a = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                break;
            }
            a++;
        }
        return a;
    }

    public String getType(){
        return type;
    }

    public String getInitValue(String substring, ArgSpec argSpec){
        valueDefault(argSpec);
        return extract(substring, argSpec);
    }
}
