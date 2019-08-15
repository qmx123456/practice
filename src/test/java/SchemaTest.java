import org.junit.Assert;
import org.junit.Test;

public class SchemaTest {
    @Test
    public void should_return_logging_flag_when_get_its_flag(){
        SchemaArg schemaArg = new SchemaArg();
        Assert.assertEquals("-l", schemaArg.getLogging().getFlag());
        Assert.assertEquals(false,schemaArg.getLogging().getDefaultValue());
        Assert.assertEquals("bool",schemaArg.getLogging().getType());
    }
}
