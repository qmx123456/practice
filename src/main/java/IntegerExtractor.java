public class IntegerExtractor extends IExtract {
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

    @Override
    public String getType() {
        return integerType;
    }
}
