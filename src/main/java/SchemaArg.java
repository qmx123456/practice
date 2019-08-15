import java.util.HashMap;
import java.util.Map;

public class SchemaArg {

    private final LogFlag logFlag;
    private final PortFlag arg;
    private Map<String, IFlag> flag;
    private IFlag directory;

    public SchemaArg(){
        flag=new HashMap<String, IFlag>();
        logFlag = new LogFlag();
        arg = new PortFlag();
        directory=new DirectoryFlag();
        flag.put(logFlag.getFlag(), logFlag);
        flag.put(arg.getFlag(), arg);
        flag.put(directory.getFlag(), directory);
    }
    public IFlag getLogFlag() {
        return logFlag;
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
