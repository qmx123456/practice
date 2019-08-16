import java.util.List;

public class ParserArg {

    private final SchemaArg schemaArg;

    public ParserArg() {
        schemaArg = new SchemaArg();
    }

    public List<String> parser(String s) {
        return schemaArg.match(s);
    }

    public SchemaArg getSchema() {
        return schemaArg;
    }
}
