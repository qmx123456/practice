import java.util.HashMap;
import java.util.Map;

public class SchemaArg {

    private final Logging logging;
    private final PortArg arg;
    private Map<String, IFlag> flag;

    public SchemaArg(){
        flag=new HashMap<String, IFlag>();
        logging = new Logging();
        arg = new PortArg();
        flag.put(logging.getFlag(),logging);
        flag.put(arg.getFlag(), arg);
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
}
