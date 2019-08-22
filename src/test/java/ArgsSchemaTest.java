import org.junit.Assert;
import org.junit.Test;

public class ArgsSchemaTest {

    private ArgsSchema argsSchema;

    @Test
    public void should_get_arg_of_arg_from_text(){
        argsSchema = new ArgsSchema("l:boolean:true p:integer:0 d:string:");
        Assert.assertEquals(3, argsSchema.count());

        Assert.assertEquals(ArgSpec.build("l:boolean:true"), argsSchema.get("l"));

        Assert.assertEquals(null, argsSchema.get("w"));
    }

    @Test
    public void should_extract_schema_when_schema_text_with_wrong_format(){
        String textWithOutType = "wp";
        ArgsSchema argsSchema = new ArgsSchema(textWithOutType);
        Assert.assertEquals(0, argsSchema.count());
    }


    @Test
    public void should_match_command_with_label(){
        argsSchema = new ArgsSchema("l:boolean:true p:integer:0 d:string:");
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
