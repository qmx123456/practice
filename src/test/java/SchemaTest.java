import org.junit.Assert;
import org.junit.Test;

public class SchemaTest {
    @Test
    public void should_return_logging_when_get_it(){
        SchemaArg schemaArg = new SchemaArg();
        Assert.assertEquals("-l", schemaArg.getLogging().getFlag());
        Assert.assertEquals(false,schemaArg.getLogging().getDefaultValue());
        Assert.assertEquals(boolean.class,schemaArg.getLogging().getType());
    }
}
