public class IntegerExtractor extends IExtract {
    @Override
    public int extract(String valueText, ArgSpec argSpec) {
        String valueStartText = valueText.substring(spacesStartWith(valueText)).split(" ")[0];

        int index = spacesStartWith(valueText);
        if (valueStartText.matches("[0-9]+")) {
            argSpec.value = Integer.parseInt(valueStartText);
            int valueEndIndex2 = spacesStartWith(valueText) + valueStartText.length();
            index = calIndexForNextLabelStart(valueText, valueEndIndex2);
        }
        return index;
    }

    @Override
    public void valueIfInputValue(String val, ArgSpec argSpec) {
        try {
            argSpec.value = Integer.valueOf(val);
        } catch (Exception e) {
            argSpec.value = 0;
        }
    }

    @Override
    public void valueIfNotInput(ArgSpec argSpec) {
        argSpec.value = 0;
    }
}
