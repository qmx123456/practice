public class CommandFactory {
    public static Command build(String commandText) {
        String[] split = commandText.split(":");
        switch (split[0]){
            case "size": return new SizeCommand(split[1]);
            case "location": return new LocationCommand(split[1]);
        }
        return null;
    }
}
