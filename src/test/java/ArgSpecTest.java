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
    public void should_set_current_value_from_command_texts(){
        ArgSpec argSpec = ArgSpec.build("l:boolean:false");

        String commandsText = "-l true -p 8080 -d /usr/logs";
        String[] commandTexts = commandsText.split(" ");
        int index = argSpec.set(commandTexts, 0);

        Assert.assertEquals(2, index);
        Assert.assertEquals(true, argSpec.value);
    }

    @Test
    public void should_extract_integer_value(){
        ArgSpec argSpec = ArgSpec.build("d:integer:0");

        String commandsTextNormal = "-d 1 -l true";
        int index = argSpec.set(commandsTextNormal, 0);
        Assert.assertEquals(5, index);
        Assert.assertEquals(1, argSpec.value);

        String cWithMultiSpaceBetweenLabelAndValue = "-d  1 -l true";
        index = argSpec.set(cWithMultiSpaceBetweenLabelAndValue, 0);
        Assert.assertEquals(6, index);
        Assert.assertEquals(1, argSpec.value);

        String cWithMultiSpaceBeforeNextLabel = "-d 1  -l true";
        index = argSpec.set(cWithMultiSpaceBeforeNextLabel, 0);
        Assert.assertEquals(6, index);
        Assert.assertEquals(1, argSpec.value);

        String cWithoutValue = "-d ";
        index = argSpec.set(cWithoutValue, 0);
        Assert.assertEquals(3, index);
        Assert.assertEquals(1, argSpec.value);

        String cWithValueIsNotRight = "-d ll";
        index = argSpec.set(cWithValueIsNotRight, 0);
        Assert.assertEquals(3, index);
        Assert.assertEquals(1, argSpec.value);

    }

    @Test
    public void should_extract_boolean_value() {
        ArgSpec argSpec = ArgSpec.build("l:boolean:false");

        String commandsTextNormal = "-l true -p 80";
        int index = argSpec.set(commandsTextNormal, 0);
        Assert.assertEquals(8, index);
        Assert.assertEquals(true, argSpec.value);

        argSpec = ArgSpec.build("l:boolean:false");
        String ctWithValueNotRight = "-l tt -p 80";
        index = argSpec.set(ctWithValueNotRight, 0);
        Assert.assertEquals(3, index);
        Assert.assertEquals(false, argSpec.value);

    }

    @Test
    public void should_extract_string_value() {
        ArgSpec argSpec = ArgSpec.build("l:string:");

        String commandsTextNormal = "-l d:/ -p 80";
        int index = argSpec.set(commandsTextNormal, 0);
        Assert.assertEquals(7, index);
        Assert.assertEquals("d:/", argSpec.value);

        argSpec = ArgSpec.build("l:string:");
        String ctWithValueNotRight = "-l tt -p 80";
        index = argSpec.set(ctWithValueNotRight, 0);
        Assert.assertEquals(3, index);
        Assert.assertEquals("", argSpec.value);

    }
}
