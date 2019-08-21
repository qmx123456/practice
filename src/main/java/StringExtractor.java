import java.io.File;

public class StringExtractor extends IExtract {
    @Override
    public int extract(String valueText, ArgSpec argSpec) {
        int spacesStartWith = spacesStartWith(valueText);
        String valueStartText = valueText.substring(spacesStartWith).split(" ")[0];

        int res = spacesStartWith;
        File file = new File(valueStartText);
        if (file.isDirectory()) {
            argSpec.value = valueStartText;
            int valueEndIndex = spacesStartWith + valueStartText.length();
            res = calIndexForNextLabelStart(valueText, valueEndIndex);
        }
        return res;
    }

    @Override
    public void valueIfInputValue(String val, ArgSpec argSpec) {
        argSpec.value = String.valueOf(val);

    }

    @Override
    public void valueIfNotInput(ArgSpec argSpec) {
        argSpec.value = "";
    }
}
