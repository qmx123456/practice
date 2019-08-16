import java.util.ArrayList;
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

    public ArrayList<String> match(String s) {
        ArrayList<String> res = new ArrayList<String>();
        String[] split = s.split(" ");
        if (split.length == 0) {
            res.add(ParserMes.wrong);
            return res;
        }

        boolean contained = false;
        for (int i = 0; i < split.length; ) {
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
                continue;
            }
            i = i + 1;
        }
        if (!contained) {
            res.add(ParserMes.wrong);
        }
        addRes(res, logFlag);
        addRes(res, portFlag);
        addRes(res, directory);
        return res;
    }

    private void addRes(ArrayList<String> res, IFlag flag) {
        String s = flag.getParserRes();
        if (s != "") {
            res.add(s);
            flag.clearParserRes();
        }
    }
}
