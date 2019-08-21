import java.util.ArrayList;
import java.util.Arrays;

public class ListStringExtractor extends IExtract {
    @Override
    public int extract(String valueText, ArgSpec argSpec) {
        String textWithValue = valueText.substring(spacesStartWith(valueText));
        int res = spacesStartWith(valueText);
        if (textWithValue.charAt(0) == '[' && textWithValue.contains("]")) {
            String[] splitValue = textWithValue.substring(1).split("]");
            if (splitValue.length > 0 && !splitValue[0].equals("")) {
                String value = splitValue[0];
                argSpec.value = Arrays.asList(value.split(","));
                int valueEndIndex = spacesStartWith(valueText) + 1 + value.length() + 1;
                res = calIndexForNextLabelStart(valueText, valueEndIndex);
            } else {
                argSpec.value = Arrays.asList(new String[]{});
                int valueEndIndex = spacesStartWith(valueText) + 1 + 1;
                res = calIndexForNextLabelStart(valueText, valueEndIndex);
            }
        }
        return res;
    }

    @Override
    public void valueIfInputValue(String val, ArgSpec argSpec) {
        argSpec.value = null;
    }

    @Override
    public void valueIfNotInput(ArgSpec argSpec) {
        argSpec.value = new ArrayList<String>();
    }
}
