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
    public void should_return_null_when_label_not_exst(){
        Assert.assertEquals(null, argsSchema.get("w"));
    }

    @Test
    public void should_get_right_count_when_schema_text_with_wrong_format(){
        String schemaText = "wp";
        ArgsSchema argsSchema = new ArgsSchema(schemaText);
        Assert.assertEquals(0, argsSchema.count());
    }

}
