import java.io.File;

public class StringExtractor extends IExtract {
    public StringExtractor(){
        type = "string";
    }

    @Override
    public String extract(String valueText, ArgSpec argSpec) {
        int spacesStartWith = spacesStartWith(valueText);
        String valueStartText = valueText.substring(spacesStartWith).split(" ")[0];

        int index = spacesStartWith;
        File file = new File(valueStartText);
        if (file.isDirectory()) {
            argSpec.value = valueStartText;
            int valueEndIndex = spacesStartWith + valueStartText.length();
            index = calIndexForNextLabelStart(valueText, valueEndIndex);
        }
        return valueText.substring(index);
    }

    @Override
    public void valueDefault(ArgSpec argSpec) {
        argSpec.value = "";
    }
}
