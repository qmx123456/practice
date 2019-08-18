import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArgsSchemaTest {

    private ArgsSchema argsSchema;

    @Before
    public void setUp() {
        String argsSchemaText = "l:boolean:true p:integer:0 d:string:";
        argsSchema = new ArgsSchema(argsSchemaText);
    }

    @Test
    public void should_get_count_of_args(){
        Assert.assertEquals(3, argsSchema.size());
    }

    @Test
    public void should_extract_arg_spec_out_of_text(){
        Assert.assertEquals(new ArgSpec("l:boolean:true"), argsSchema.get("l"));
    }
}
