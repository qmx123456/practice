import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ArgSpecTest {

    private String argText;

    @Before
    public void setUp() {
        argText = "l:boolean:true";
    }

    @Test
    public void should_get_label_type_from_arg_text(){
        ArgSpec argSpec = ArgSpec.build("l:boolean:true");

        Assert.assertEquals("boolean", argSpec.type);
        Assert.assertEquals("l", argSpec.label);

        argText = "g:list<string>";
        argSpec = ArgSpec.build(argText);
        Assert.assertEquals("list<string>", argSpec.type);

        argText = "g:list<integer>";
        argSpec = ArgSpec.build(argText);
        Assert.assertEquals("list<integer>", argSpec.type);
    }

    @Test
    public void should_get_default_value(){
        ArgSpec argSpec = ArgSpec.build("l:integer:0");
        Assert.assertEquals(0, argSpec.value);

        argSpec = ArgSpec.build("l:boolean:false");
        Assert.assertEquals(false, argSpec.value);

        argSpec = ArgSpec.build("l:string:wp");
        Assert.assertEquals("wp", argSpec.value);

        argSpec = ArgSpec.build("l:string:");
        Assert.assertEquals("", argSpec.value);

        argSpec = ArgSpec.build("g:list<string>:");
        Assert.assertEquals(0, ((List<?>)argSpec.value).size());

        argSpec = ArgSpec.build("g:list<integer>:");
        Assert.assertEquals(0, ((List<?>)argSpec.value).size());

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

        Assert.assertEquals(ArgSpec.build(argText), argSpec);
    }

    @Test
    public void should_argSpec_be_null_when_arg_text_is_not_right(){
        ArgSpec argSpec = ArgSpec.build("wp");
        Assert.assertEquals(null, argSpec);

        argSpec = ArgSpec.build("-");
        Assert.assertEquals(null, argSpec);

        argSpec = ArgSpec.build("p:bb");
        Assert.assertEquals(null, argSpec);
    }

    @Test
    public void should_be_trimed_when_arg_text_contain_spaces_before_or_after(){
        ArgSpec argSpec = ArgSpec.build(" l : boolean : false ");
        Assert.assertEquals("l", argSpec.label);
    }

    @Test
    public void should_extract_integer_value(){
        ArgSpec argSpec = ArgSpec.build("d:integer:0");

        String commandsTextNormal = "-d 1 -l true";
        String nextCommand = argSpec.set(commandsTextNormal);
        Assert.assertEquals("-l true", nextCommand);
        Assert.assertEquals(1, argSpec.value);

        String cWithMultiSpaceBetweenLabelAndValue = "-d  1 -l true";
        nextCommand = argSpec.set(cWithMultiSpaceBetweenLabelAndValue);
        Assert.assertEquals("-l true", nextCommand);
        Assert.assertEquals(1, argSpec.value);

        String cWithMultiSpaceBeforeNextLabel = "-d 1  -l true";
        nextCommand = argSpec.set(cWithMultiSpaceBeforeNextLabel);
        Assert.assertEquals("-l true", nextCommand);
        Assert.assertEquals(1, argSpec.value);

        String cWithoutValue = "-d ";
        nextCommand = argSpec.set(cWithoutValue);
        Assert.assertEquals("", nextCommand);
        Assert.assertEquals(1, argSpec.value);

        String cWithValueIsNotRight = "-d ll";
        nextCommand = argSpec.set(cWithValueIsNotRight);
        Assert.assertEquals("ll", nextCommand);
        Assert.assertEquals(1, argSpec.value);
    }

    @Test
    public void should_extract_boolean_value() {
        ArgSpec argSpec = ArgSpec.build("l:boolean:false");

        String commandsTextNormal = "-l true -p 80";
        String nextCommand = argSpec.set(commandsTextNormal);
        Assert.assertEquals("-p 80", nextCommand);
        Assert.assertEquals(true, argSpec.value);

        argSpec = ArgSpec.build("l:boolean:false");
        String ctWithValueNotRight = "-l tt -p 80";
        nextCommand = argSpec.set(ctWithValueNotRight);
        Assert.assertEquals("tt -p 80", nextCommand);
        Assert.assertEquals(false, argSpec.value);
    }

    @Test
    public void should_extract_string_value() {
        ArgSpec argSpec = ArgSpec.build("l:string:");

        String commandsTextNormal = "-l d:/ -p 80";
        String index = argSpec.set(commandsTextNormal);
        Assert.assertEquals("-p 80", index);
        Assert.assertEquals("d:/", argSpec.value);

        argSpec = ArgSpec.build("l:string:");
        String ctWithValueNotRight = "-l tt -p 80";
        index = argSpec.set(ctWithValueNotRight);
        Assert.assertEquals("tt -p 80", index);
        Assert.assertEquals("", argSpec.value);
    }

    @Test
    public void should_extract_list_string_value() {
        ArgSpec argSpec = ArgSpec.build("g:list<string>:");

        String commandsTextNormal = "-g [this,is] -d [1,2,-3,5]";
        String ct = argSpec.set(commandsTextNormal);
        List<String> value = (List<String>)argSpec.value;

        Assert.assertEquals(2, value.size());
        Assert.assertEquals("this", value.get(0));
        Assert.assertEquals("is", value.get(1));
        Assert.assertEquals("-d [1,2,-3,5]", ct);

        argSpec.set("-g [this,is]");
        commandsTextNormal = "-g [this,is,a,list";
        ct = argSpec.set(commandsTextNormal);
        value = (List<String>)argSpec.value;
        Assert.assertEquals(2, value.size());

        argSpec.set("-g [this,is]");
        commandsTextNormal = "-g this,is,a,list]";
        ct = argSpec.set(commandsTextNormal);
        value = (List<String>)argSpec.value;
        Assert.assertEquals(2, value.size());

        argSpec.set("-g [this,is]");
        commandsTextNormal = "-g []";
        ct = argSpec.set(commandsTextNormal);
        value = (List<String>)argSpec.value;
        Assert.assertEquals(0, value.size());
        Assert.assertEquals("", ct);

        argSpec.set("-g [this,is]");
        commandsTextNormal = "-g [] -d";
        ct = argSpec.set(commandsTextNormal);
        value = (List<String>)argSpec.value;
        Assert.assertEquals(0, value.size());
        Assert.assertEquals("-d", ct);
    }
}
