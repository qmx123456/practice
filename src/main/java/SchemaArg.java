import java.util.HashMap;
import java.util.Map;

public class SchemaArg {

    private final LogFlag logFlag;
    private final PortFlag portFlag;
    private Map<String, IFlag> flag;
    private IFlag directory;

    public SchemaArg() {
        flag = new HashMap<String, IFlag>();
        logFlag = new LogFlag();
        portFlag = new PortFlag();
        directory = new DirectoryFlag();
        flag.put(logFlag.getFlag(), logFlag);
        flag.put(portFlag.getFlag(), portFlag);
        flag.put(directory.getFlag(), directory);
    }

    public IFlag getLogFlag() {
        return logFlag;
    }

    public IFlag getPortArg() {
        return portFlag;
    }

    public int getFlagCount() {
        return flag.size();
    }

    public IFlag getDirectory() {
        return directory;
    }

    public String match(String s) {
        String[] split = s.split(" ");
        if (split.length == 0) {
            return ParserMes.wrong;
        }

        String res = "";
        boolean contained = false;
        boolean turn = false;
        int i = 0;
        for (; i < split.length; ) {
            if (split[i].equals(logFlag.getFlag())) {
                contained = true;
                i = logFlag.set(split, i);
                continue;
            }
            if (split[i].equals(portFlag.getFlag())) {
                contained = true;
                i = portFlag.set(split, i);
                continue;
            }
            if (split[i].equals(directory.getFlag())) {
                contained = true;
                i = directory.set(split, i);
            }
            i = i + 1;
        }
        if (!contained) {
            return ParserMes.wrong;
        }
        res += logFlag.getParserRes();
        res += portFlag.getParserRes();
        res += directory.getParserRes();
        return res;
    }
}
