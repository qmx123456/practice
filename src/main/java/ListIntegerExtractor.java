import java.util.ArrayList;

public class ListIntegerExtractor extends IExtract {
    public ListIntegerExtractor() {
        type = "list<integer>";
    }

    @Override
    public String extract(String commandTexts, ArgSpec argSpec) {
        return null;
    }

    @Override
    public void valueDefault(ArgSpec argSpec) {
        argSpec.value = new ArrayList<String>();
    }
}
