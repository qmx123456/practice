import org.junit.Assert;

public class ArgsParserTest {
//    @Test
    public void should_parse_arg_value_with_schema_and_command(){
        String commandText = "-l -p 8080 -d /usr/logs";
        String schemaText = "l:boolean:true p:integer:0 d:string:";

        ArgsParser argsParser = new ArgsParser(schemaText);
        argsParser.parse(commandText);

        Assert.assertEquals(true, argsParser.get("l"));
        Assert.assertEquals(8080, argsParser.get("p"));
        Assert.assertEquals("/usr/logs", argsParser.get("d"));
    }
}
