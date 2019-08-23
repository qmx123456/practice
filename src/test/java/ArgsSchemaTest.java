import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArgsSchemaTest {

    private ArgsSchema argsSchema;

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
    public void should_get_arg_of_arg_from_text(){
        ArgSpec boolArg = new ArgSpec("l", booleanExtractor);
        boolArg.value = true;
        ArgSpec integerArg = new ArgSpec("p", integerExtractor);
        integerArg.value = 0;
        ArgSpec stringArg = new ArgSpec("d", stringExtractor);
        stringArg.value="";

        argsSchema = new ArgsSchema("l:boolean:true p:integer:0 d:string:");

        Assert.assertEquals(3, argsSchema.count());
        Assert.assertEquals(boolArg, argsSchema.get("l"));
        Assert.assertEquals(integerArg, argsSchema.get("p"));
        Assert.assertEquals(stringArg, argsSchema.get("d"));
        Assert.assertEquals(null, argsSchema.get("w"));
    }

    @Test
    public void should_extract_schema_label_when_label_with_wrong_format(){
        ArgSpec anotherArgSpec = new ArgSpec("l", booleanExtractor);
        anotherArgSpec.value = true;

        String textWithOutType = "wp";
        ArgsSchema argsSchema = new ArgsSchema(textWithOutType);
        Assert.assertEquals(0, argsSchema.count());

        String textHeadWithSpaces = " l:boolean:true";
        argsSchema = new ArgsSchema(textHeadWithSpaces);
        Assert.assertEquals(1, argsSchema.count());
        Assert.assertEquals(anotherArgSpec, argsSchema.get("l"));

        String textFirstLabelNotLetter = "-:boolean:true";
        argsSchema = new ArgsSchema(textFirstLabelNotLetter);
        Assert.assertEquals(0, argsSchema.count());

        String textFirstLabelWithTwoLetter = "l :boolean:true";
        argsSchema = new ArgsSchema(textFirstLabelWithTwoLetter);
        Assert.assertEquals(1, argsSchema.count());
        Assert.assertEquals(anotherArgSpec, argsSchema.get("l"));
    }

    @Test
    public void should_extract_type_after_label(){
        String textWithOutType = "l:bb:";
        ArgsSchema argsSchema = new ArgsSchema(textWithOutType);
        Assert.assertEquals(0, argsSchema.count());

        String textHeadWithSpace = "l: boolean:true";
        argsSchema = new ArgsSchema(textHeadWithSpace);
        Assert.assertEquals(1, argsSchema.count());
        Assert.assertEquals("boolean", argsSchema.get("l").type);
    }

    public void should_extract_default_boolean_value() {

        String withOutValue = "l:boolean:";
        ArgsSchema argsSchema = new ArgsSchema(withOutValue);
        Assert.assertEquals(false, argsSchema.get("l").value);

        String withSpacesValue = "l:boolean: false ";
        argsSchema = new ArgsSchema(withSpacesValue);
        Assert.assertEquals(false, argsSchema.get("l").value);
    }

    public void should_extract_default_integer_value() {
        String withOutValue = "l:integer:";
        ArgsSchema argsSchema = new ArgsSchema(withOutValue);
        Assert.assertEquals(0, argsSchema.get("l").value);

        String withSpacesValue = "l:integer:  10";
        argsSchema = new ArgsSchema(withSpacesValue);
        Assert.assertEquals(10, argsSchema.get("l").value);

        String withWrongValue = "l:integer:wp";
        argsSchema = new ArgsSchema(withWrongValue);
        Assert.assertEquals(0, argsSchema.get("l").value);
    }

//        argSpec = ArgSpec.build("l:string:wp");
//        Assert.assertEquals("wp", argSpec.value);
//
//        argSpec = ArgSpec.build("l:string:");
//        Assert.assertEquals("", argSpec.value);
//
//
//        argSpec = ArgSpec.build("g:list<string>:");
//        Assert.assertEquals(0, ((List<?>)argSpec.value).size());
//
//        argSpec = ArgSpec.build("g:list<integer>:");
//        Assert.assertEquals(0, ((List<?>)argSpec.value).size());

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
