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
        ArgSpec argSpec = ArgSpec.build(argText);

        Assert.assertEquals("boolean", argSpec.type);
        Assert.assertEquals("l", argSpec.label);
    }

    @Test
    public void should_get_value_format(){
        ArgSpec argSpec = ArgSpec.build("l:integer:0");
        Assert.assertEquals(0, argSpec.value);

        argSpec = ArgSpec.build("l:boolean:false");
        Assert.assertEquals(false, argSpec.value);

        argSpec = ArgSpec.build("l:string:");
        Assert.assertEquals("", argSpec.value);

        argSpec = ArgSpec.build("l:integer");
        Assert.assertEquals(0, argSpec.value);

        argSpec = ArgSpec.build("l:boolean");
        Assert.assertEquals(false, argSpec.value);

        argSpec = ArgSpec.build("l:integer:wp");
        Assert.assertEquals(0, argSpec.value);

        argSpec = ArgSpec.build("l:boolean:wp");
        Assert.assertEquals(false, argSpec.value);
    }

    @Test
    public void should_override_equals(){
        ArgSpec argSpec = ArgSpec.build(argText);

        Assert.assertEquals(new ArgSpec(argText), argSpec);
    }

    @Test
    public void should_be_null_when_arg_text_is_not_format(){
        ArgSpec argSpec = ArgSpec.build("wp");
        Assert.assertEquals(null, argSpec);

        argSpec = ArgSpec.build("-");
        Assert.assertEquals(null, argSpec);

        argSpec = ArgSpec.build("p:bb:");
        Assert.assertEquals(null, argSpec);
    }

    @Test
    public void should_be_fomat_when_arg_text_contain_space_before_or_after(){
        ArgSpec argSpec = ArgSpec.build("w :boolean");
        Assert.assertEquals("w", argSpec.label);

        argSpec = ArgSpec.build("w: boolean ");
        Assert.assertEquals("boolean", argSpec.type);

        argSpec = ArgSpec.build("w: boolean: false ");
        Assert.assertEquals(false, argSpec.value);
    }
}
