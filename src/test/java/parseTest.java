import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class parseTest {
    @Test
    public  void should_output_schema_when_input_format_command(){
        ParserArg parserArg = new ParserArg();
        List<String> parser = parserArg.parser("-l -p 80 -d /usr/logs");
        Assert.assertEquals(0,parser.size());
        Assert.assertEquals(true,parserArg.getSchema().getLogFlag().getValue());
        Assert.assertEquals(80,parserArg.getSchema().getPortArg().getValue());
        Assert.assertEquals("/usr/logs",parserArg.getSchema().getDirectory().getValue());
    }
}
