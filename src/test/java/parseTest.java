import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class parseTest {
    @Test
    public  void should_output_schema_when_input_format_command(){
        ParserArg parserArg = new ParserArg();
        parserArg.parser("-l -p 80 -d /usr/logs");

        Assert.assertEquals(true,parserArg.getSchema().getLogFlag().getValue());
        Assert.assertEquals(80,parserArg.getSchema().getPortArg().getValue());
        Assert.assertEquals("/usr/logs",parserArg.getSchema().getDirectory().getValue());

        ArrayList<String> out = parserArg.out();
        Assert.assertEquals(3,out.size());
        Assert.assertEquals("log: true",out.get(0));
        Assert.assertEquals("port: 80",out.get(1));
        Assert.assertEquals("directory: /usr/logs",out.get(2));
    }

    @Test
    public  void should_output_schema_with_info_when_out(){
        ParserArg parserArg = new ParserArg();
        parserArg.parser("-l -p -d /usr/logs");

        ArrayList<String> out = parserArg.out();
        Assert.assertEquals(4,out.size());
    }
}
