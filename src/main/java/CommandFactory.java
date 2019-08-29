public class CommandFactory {
    public static Command build(String commandText) {
        String[] split = commandText.split(":");
        switch (split[0]){
            case "size": return new SizeCommand(split[1]);
            case "location": return new LocationCommand(split[1]);
            case "f": return new ForwardCommand(split[1]);
            case "b": return new BackCommand(split[1]);
            case "l": return new TurnLeftCommand(split[1]);
        }
        return null;
    }
}
