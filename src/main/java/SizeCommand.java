public class SizeCommand extends Command {
    public static String commandType = "size";
    private int x;
    private int y;

    public SizeCommand(String commandText) {
        String[] split = commandText.split(",");
        x = Integer.parseInt(split[0]);
        y = Integer.parseInt(split[1]);
    }

    public void run(IBehavior location) {

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
