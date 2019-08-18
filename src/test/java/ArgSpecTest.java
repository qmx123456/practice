import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArgSpecTest {

    private String argText;
    private ArgSpec argSpec;
    private String commandText;

    @Before
    public void setUp() {
        argText = "l:boolean:false";
        argSpec = new ArgSpec(argText);
        commandText = "-l true -p 8080 -d /usr/logs";
    }

    @Test
    public void should_extract_arg_spec_out_of_text(){
        Assert.assertEquals("l", argSpec.label);
        Assert.assertEquals("boolean", argSpec.type);
    }

    @Test
    public void should_override_equal(){
        Assert.assertEquals(argSpec, new ArgSpec("l:boolean:true"));
    }

    @Test
    public void should_resolve_boolean_command(){
        argSpec = new ArgSpec("l:boolean:true");
        int resolve = argSpec.resolve(commandText.split(" "), 0);
        Assert.assertEquals(2, resolve);
        Assert.assertEquals(true, argSpec.value);
    }

    @Test
    public void should_resolve_integer_command(){
        argSpec = new ArgSpec("p:integer:0");
        int resolve = argSpec.resolve(commandText.split(" "), 2);
        Assert.assertEquals(4, resolve);
        Assert.assertEquals(8080, argSpec.value);
    }

    @Test
    public void should_resolve_string_command(){
        argSpec = new ArgSpec("d:string:");
        int resolve = argSpec.resolve(commandText.split(" "), 4);
        Assert.assertEquals(6, resolve);
        Assert.assertEquals("/usr/logs", argSpec.value);
    }
}
