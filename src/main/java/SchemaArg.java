import java.util.HashMap;
import java.util.Map;

public class SchemaArg {

    private final Logging logging;
    private final PortArg arg;
    private Map<String, IFlag> flag;
    private IFlag directory;

    public SchemaArg(){
        flag=new HashMap<String, IFlag>();
        logging = new Logging();
        arg = new PortArg();
        directory=new Directory();
        flag.put(logging.getFlag(),logging);
        flag.put(arg.getFlag(), arg);
        flag.put(directory.getFlag(), directory);
    }
    public IFlag getLogging() {
        return logging;
    }

    public IFlag getPortArg() {
        return arg;
    }

    public int getFlagCount() {
        return flag.size();
    }

    public IFlag getDirectory() {
        return directory;
    }
}
