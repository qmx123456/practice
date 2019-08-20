import org.junit.Assert;
import org.junit.Test;

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
    public void should_escape_command_with_label_is_not_right(){
        String ctWithLabelNotRight = "-lp false -p 8080 -d d:/";
        argsParser.parse(ctWithLabelNotRight);
        Assert.assertEquals(null, argsParser.get("lp"));
        Assert.assertEquals(true, argsParser.get("l"));


        ctWithLabelNotRight = "-w true -p 8080 -d d:/";
        argsParser.parse(ctWithLabelNotRight);
        Assert.assertEquals(null, argsParser.get("w"));

        ctWithLabelNotRight = "p-l false -p 8080 -d d:/";
        argsParser.parse(ctWithLabelNotRight);
        Assert.assertEquals(true, argsParser.get("l"));

        ctWithLabelNotRight = "-w-l false -p 8080 -d d:/";
        argsParser.parse(ctWithLabelNotRight);
        Assert.assertEquals(true, argsParser.get("l"));

        ctWithLabelNotRight = "-";
        argsParser.parse(ctWithLabelNotRight);
        Assert.assertEquals(true, argsParser.get("l"));
    }

//    @Test
    public void should_parse_list_value_with_command(){
        String commandText = "-g [this,is,a,list] -d [1,2,-3,5]";
        argsParser.parse(commandText);

        Assert.assertEquals(4, argsParser.get("g"));
//        Assert.assertEquals("this", argsParser.get("g").get(0));

        Assert.assertEquals(4, argsParser.get("d"));
//        Assert.assertEquals(1, argsParser.get("d").get(0));
    }
}
