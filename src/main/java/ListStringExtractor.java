import java.util.ArrayList;
import java.util.Arrays;

public class ListStringExtractor extends IExtract {
    static IExtract extractor;

    public ListStringExtractor() {
        type = "list<string>";
    }

    @Override
    public String extract(String valueText, ArgSpec argSpec) {
        String textWithValue = valueText.substring(spacesStartWith(valueText));
        int index = spacesStartWith(valueText);
        if (textWithValue.charAt(0) == '[' && textWithValue.contains("]")) {
            String[] splitValue = textWithValue.substring(1).split("]");
            if (splitValue.length > 0 && !splitValue[0].equals("")) {
                String value = splitValue[0];
                argSpec.value = Arrays.asList(value.split(","));
                int valueEndIndex = spacesStartWith(valueText) + 1 + value.length() + 1;
                index = calIndexForNextLabelStart(valueText, valueEndIndex);
            } else {
                argSpec.value = Arrays.asList(new String[]{});
                int valueEndIndex = spacesStartWith(valueText) + 1 + 1;
                index = calIndexForNextLabelStart(valueText, valueEndIndex);
            }
        }
        return valueText.substring(index);
    }

    @Override
    public void valueDefault(ArgSpec argSpec) {
        argSpec.value = new ArrayList<String>();
    }

    public static IExtract build() {
        if (extractor == null){
            extractor = new ListStringExtractor();
        }
        return extractor;
    }
}
