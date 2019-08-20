import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArgsSchemaTest {

    private ArgsSchema argsSchema;


    @Before
    public void setUp() {
        argsSchema = new ArgsSchema("l:boolean:true p:integer:0 d:string:");
    }

    @Test
    public void should_get_count_of_arg_from_text(){
        Assert.assertEquals(3, argsSchema.count());
    }

    @Test
    public void should_get_argSpec_from_argText(){
        Assert.assertEquals(ArgSpec.build("l:boolean:true"), argsSchema.get("l"));
    }

    @Test
    public void should_return_null_when_label_not_exist(){
        Assert.assertEquals(null, argsSchema.get("w"));
    }

    @Test
    public void should_get_right_count_when_schema_text_with_wrong_format(){
        ArgsSchema argsSchema = new ArgsSchema("wp");
        Assert.assertEquals(0, argsSchema.count());
    }


    @Test
    public void should_match_command_with_label(){
        String ctWithLabelNotRight = "-lp false -p 8080 -d d:/";

        argsSchema.parse(ctWithLabelNotRight);
        Assert.assertEquals(null, argsSchema.get("lp"));
        Assert.assertEquals(true, argsSchema.get("l").value);

        ctWithLabelNotRight = "  -l false   -p 8080 -d d:/";
        argsSchema.parse(ctWithLabelNotRight);
        Assert.assertEquals(false, argsSchema.get("l").value);
        Assert.assertEquals(8080, argsSchema.get("p").value);

        ctWithLabelNotRight = "-w-l   false -p 8080 -d d:/";
        argsSchema.parse(ctWithLabelNotRight);
        Assert.assertEquals(false, argsSchema.get("l").value);
        Assert.assertEquals(8080, argsSchema.get("p").value);

        ctWithLabelNotRight = "-";
        argsSchema.parse(ctWithLabelNotRight);
        Assert.assertEquals(false, argsSchema.get("l").value);
    }


}
