import java.util.ArrayList;

public class ListIntegerExtractor extends IExtract {
    @Override
    public int extract(String commandTexts, ArgSpec argSpec) {
        return 0;
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
