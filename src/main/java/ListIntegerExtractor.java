import java.util.ArrayList;

public class ListIntegerExtractor extends IExtract {
    static IExtract extractor;

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

    public static IExtract build() {
        if (extractor == null){
            extractor = new ListIntegerExtractor();
        }
        return extractor;
    }
}
