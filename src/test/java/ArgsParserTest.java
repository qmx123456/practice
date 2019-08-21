import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ArgsParserTest {

    private final ArgsParser argsParser = new ArgsParser("l:boolean:true p:integer:0 d:string:");

    @Test
    public void should_parse_all_arg_value_with_schema_and_command(){
        String commandText = "-l true -p 8080 -d d:/";
        argsParser.parse(commandText);

        Assert.assertEquals(true, argsParser.get("l"));
        Assert.assertEquals(8080, argsParser.get("p"));
        Assert.assertEquals("d:/", argsParser.get("d"));
    }

//    @Test
    public void should_parse_list_value_with_command(){
        String commandText = "-g [this,is,a,list] -d [1,2,-3,5]";
        argsParser.parse(commandText);

        List<String> g= Arrays.asList((String[])argsParser.get("g"));
        Assert.assertEquals(4, g.size());
        Assert.assertEquals("this", g.get(0));
    }
}
