import org.junit.Assert;
import org.junit.Test;

public class ArgsParserTest {

    private final ArgsParser argsParser = new ArgsParser("l:boolean:true p:integer:0 d:string:");

    @Test
    public void should_parse_all_arg_value_with_schema_and_command(){

        String commandText = "-l true -p 8080 -d /usr/logs";
        argsParser.parse(commandText);

        Assert.assertEquals(true, argsParser.get("l"));
        Assert.assertEquals(8080, argsParser.get("p"));
        Assert.assertEquals("/usr/logs", argsParser.get("d"));
    }

    @Test
    public void should_parse_arg_value_at_best_with_not_format_command(){

        String commandText = "-w true -p 8080 -d /usr/logs";
        argsParser.parse(commandText);

        Assert.assertEquals(null, argsParser.get("w"));
    }
}
