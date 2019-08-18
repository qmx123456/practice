import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArgSpecTest {

    private String argText;

    @Before
    public void setUp() {
        argText = "l:boolean:true";
    }

    @Test
    public void should_get_label_type_from_arg_text(){
        ArgSpec argSpec = new ArgSpec(argText);

        Assert.assertEquals("boolean", argSpec.type);
        Assert.assertEquals("l", argSpec.label);
    }

    @Test
    public void should_override_equals(){
        ArgSpec argSpec = new ArgSpec(argText);

        Assert.assertEquals(new ArgSpec(argText), argSpec);
    }
}
