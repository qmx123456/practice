public class BooleanExtractor extends IExtract {

    @Override
    public String extract(String valueText, ArgSpec argSpec) {
        String valueStartText = valueText.substring(spacesStartWith(valueText)).split(" ")[0];

        int index = spacesStartWith(valueText);
        if (valueStartText.equals("false") || valueStartText.equals("true")) {
            argSpec.value = Boolean.valueOf(valueStartText);
            int valueEndIndex = spacesStartWith(valueText) + valueStartText.length();
            index = calIndexForNextLabelStart(valueText, valueEndIndex);
        }
        return valueText.substring(index);
    }

    @Override
    public void valueDefault(ArgSpec argSpec) {
        argSpec.value = false;
    }

    @Override
    public String getType() {
        return boolType;
    }
}
