import org.junit.Assert;
import org.junit.Test;

public class SchemaTest {
    @Test
    public void should_return_logging_when_get_it(){
        SchemaArg schemaArg = new SchemaArg();
        Assert.assertEquals("-l", schemaArg.getLogFlag().getFlag());
        Assert.assertEquals(false,schemaArg.getLogFlag().getDefaultValue());
        Assert.assertEquals(boolean.class,schemaArg.getLogFlag().getType());
    }

    @Test
    public void should_return_port_when_get_it(){
        SchemaArg schemaArg = new SchemaArg();
        Assert.assertEquals("-p", schemaArg.getPortArg().getFlag());
        Assert.assertEquals(8080,schemaArg.getPortArg().getDefaultValue());
        Assert.assertEquals(Integer.class,schemaArg.getPortArg().getType());
    }

    @Test
    public void should_return_directory_when_get_it(){
        SchemaArg schemaArg = new SchemaArg();
        Assert.assertEquals("-d", schemaArg.getDirectory().getFlag());
        Assert.assertEquals("",schemaArg.getDirectory().getDefaultValue());
        Assert.assertEquals(String.class,schemaArg.getDirectory().getType());
    }

    @Test
    public void should_return_flag_count_when_get_it(){
        SchemaArg schemaArg = new SchemaArg();
        Assert.assertEquals(3, schemaArg.getFlagCount());
    }
}
