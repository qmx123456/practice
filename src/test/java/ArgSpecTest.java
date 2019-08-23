import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ArgSpecTest {

    private IExtract booleanExtractor;
    private IntegerExtractor integerExtractor;
    private ListIntegerExtractor listIntegerExtractor;
    private ListStringExtractor listStringExtractor;
    private StringExtractor stringExtractor;

    @Before
    public void setUp(){
        booleanExtractor = new BooleanExtractor();
        integerExtractor = new IntegerExtractor();
        listIntegerExtractor = new ListIntegerExtractor();
        listStringExtractor = new ListStringExtractor();
        stringExtractor = new StringExtractor();
    }

    @Test
    public void should_get_label_type_from_arg_text(){
        ArgSpec argSpec = new ArgSpec("l", booleanExtractor);
        Assert.assertEquals("boolean", argSpec.type);
        Assert.assertEquals("l", argSpec.label);

        argSpec = new ArgSpec("g", listStringExtractor);
        Assert.assertEquals("list<string>", argSpec.type);

        argSpec = new ArgSpec("g", stringExtractor);
        Assert.assertEquals("string", argSpec.type);

        argSpec = new ArgSpec("g", listIntegerExtractor);
        Assert.assertEquals("list<integer>", argSpec.type);
    }

    @Test
    public void should_override_equals(){
        ArgSpec argSpec = new ArgSpec("l", booleanExtractor);
        ArgSpec argSpecAnother = new ArgSpec("l", booleanExtractor);

        Assert.assertEquals(argSpecAnother, argSpec);
    }

    @Test
    public void should_extract_integer_value(){
        ArgSpec argSpec = new ArgSpec("l", integerExtractor);
        argSpec.value = 0;

        String commandsTextNormal = " 1 -l true";
        String nextCommand = argSpec.set(commandsTextNormal);
        Assert.assertEquals("-l true", nextCommand);
        Assert.assertEquals(1, argSpec.value);

        String cWithMultiSpaceBetweenLabelAndValue = "  1 -l true";
        nextCommand = argSpec.set(cWithMultiSpaceBetweenLabelAndValue);
        Assert.assertEquals("-l true", nextCommand);
        Assert.assertEquals(1, argSpec.value);

        String cWithMultiSpaceBeforeNextLabel = " 1  -l true";
        nextCommand = argSpec.set(cWithMultiSpaceBeforeNextLabel);
        Assert.assertEquals("-l true", nextCommand);
        Assert.assertEquals(1, argSpec.value);

        String cWithoutValue = " ";
        nextCommand = argSpec.set(cWithoutValue);
        Assert.assertEquals("", nextCommand);
        Assert.assertEquals(1, argSpec.value);

        String cWithValueIsNotRight = " ll";
        nextCommand = argSpec.set(cWithValueIsNotRight);
        Assert.assertEquals("ll", nextCommand);
        Assert.assertEquals(1, argSpec.value);
    }

    @Test
    public void should_extract_boolean_value() {
        ArgSpec argSpec = new ArgSpec("l", booleanExtractor);
        argSpec.value = false;

        String commandsTextNormal = " true -p 80";
        String nextCommand = argSpec.set(commandsTextNormal);
        Assert.assertEquals("-p 80", nextCommand);
        Assert.assertEquals(true, argSpec.value);

        argSpec.value = false;
        String ctWithValueNotRight = " tt -p 80";
        nextCommand = argSpec.set(ctWithValueNotRight);
        Assert.assertEquals("tt -p 80", nextCommand);
        Assert.assertEquals(false, argSpec.value);
    }

    @Test
    public void should_extract_string_value() {
        ArgSpec argSpec = new ArgSpec("l", stringExtractor);
        argSpec.value = "";

        String commandsTextNormal = " d:/ -p 80";
        String index = argSpec.set(commandsTextNormal);
        Assert.assertEquals("-p 80", index);
        Assert.assertEquals("d:/", argSpec.value);

        argSpec.value = "";
        String ctWithValueNotRight = " tt -p 80";
        index = argSpec.set(ctWithValueNotRight);
        Assert.assertEquals("tt -p 80", index);
        Assert.assertEquals("", argSpec.value);
    }

    @Test
    public void should_extract_list_string_value() {
        ArgSpec argSpec = new ArgSpec("g", listStringExtractor);
        argSpec.value = new ArrayList<String>();

        String commandsTextNormal = " [this,is] -d [1,2,-3,5]";
        String ct = argSpec.set(commandsTextNormal);
        List<String> value = (List<String>)argSpec.value;

        Assert.assertEquals(2, value.size());
        Assert.assertEquals("this", value.get(0));
        Assert.assertEquals("is", value.get(1));
        Assert.assertEquals("-d [1,2,-3,5]", ct);

        argSpec.set("-g [this,is]");
        commandsTextNormal = " [this,is,a,list";
        ct = argSpec.set(commandsTextNormal);
        value = (List<String>)argSpec.value;
        Assert.assertEquals(2, value.size());

        argSpec.set("-g [this,is]");
        commandsTextNormal = " this,is,a,list]";
        ct = argSpec.set(commandsTextNormal);
        value = (List<String>)argSpec.value;
        Assert.assertEquals(2, value.size());

        argSpec.set("-g [this,is]");
        commandsTextNormal = " []";
        ct = argSpec.set(commandsTextNormal);
        value = (List<String>)argSpec.value;
        Assert.assertEquals(0, value.size());
        Assert.assertEquals("", ct);

        argSpec.set("-g [this,is]");
        commandsTextNormal = " [] -d";
        ct = argSpec.set(commandsTextNormal);
        value = (List<String>)argSpec.value;
        Assert.assertEquals(0, value.size());
        Assert.assertEquals("-d", ct);
    }
}
