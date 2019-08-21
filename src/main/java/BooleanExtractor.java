public class BooleanExtractor extends IExtract {

    @Override
    public int extract(String valueText, ArgSpec argSpec) {

        String valueStartText = valueText.substring(spacesStartWith(valueText)).split(" ")[0];

        int index = spacesStartWith(valueText);

        if (valueStartText.equals("false") || valueStartText.equals("true")) {
            argSpec.value = Boolean.valueOf(valueStartText);
            int valueEndIndex = spacesStartWith(valueText) + valueStartText.length();
            index = calIndexForNextLabelStart(valueText, valueEndIndex);
        }
        return index;
    }

    @Override
    public void valueIfInputValue(String val, ArgSpec argSpec) {
        argSpec.value = Boolean.valueOf(val);
    }

    @Override
    public void valueIfNotInput(ArgSpec argSpec) {
        argSpec.value = false;
    }
}
