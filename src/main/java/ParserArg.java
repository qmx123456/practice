import java.util.ArrayList;

public class ParserArg {

    private final SchemaArg schemaArg;
    private ArrayList<String> mes;

    public ParserArg() {
        schemaArg = new SchemaArg();
        mes = new ArrayList<String>();
    }

    public void parser(String s) {
        mes = schemaArg.match(s);
    }

    public SchemaArg getSchema() {
        return schemaArg;
    }

    public ArrayList<String> out() {
        ArrayList<String> out = new ArrayList<String>();
        out.addAll(schemaArg.out());
        out.addAll(mes);
        return out;
    }

}
