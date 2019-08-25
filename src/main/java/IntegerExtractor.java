public class IntegerExtractor extends IExtract {
    static IExtract extractor;

    public IntegerExtractor(){
        type = "integer";
    }

    @Override
    public String extract(String valueText, ArgSpec argSpec) {
        String valueStartText = valueText.substring(spacesStartWith(valueText)).split(" ")[0];

        int index = spacesStartWith(valueText);
        if (valueStartText.matches("[0-9]+")) {
            argSpec.value = Integer.parseInt(valueStartText);
            int valueEndIndex2 = spacesStartWith(valueText) + valueStartText.length();
            index = calIndexForNextLabelStart(valueText, valueEndIndex2);
        }
        return valueText.substring(index);
    }

    @Override
    public void valueDefault(ArgSpec argSpec) {
        argSpec.value = 0;
    }

    public static IExtract build(){
        if (extractor == null){
            extractor = new IntegerExtractor();
        }
        return extractor;
    }
}
