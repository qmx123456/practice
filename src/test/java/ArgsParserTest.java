import org.junit.Assert;
import org.junit.Test;

public class ArgsParserTest {
    @Test
    public void should_parse_args_to_spec_value_of_text(){
        String commandText = "-l true -p 8080 -d /usr/logs";
        String schemaText = "l:boolean:true p:integer:0 d:string:";


        ArgsParser argsParser = new ArgsParser(schemaText);
        argsParser.parser(commandText);

        Assert.assertEquals(true, argsParser.get("l"));
        Assert.assertEquals(8080, argsParser.get("p"));
        Assert.assertEquals("/usr/logs", argsParser.get("d"));
    }
}
