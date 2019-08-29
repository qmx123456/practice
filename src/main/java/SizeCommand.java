public class SizeCommand extends Command {
    private int x;
    private int y;
    private Size size;

    public SizeCommand(String commandText) {
        String[] split = commandText.split(",");
        x = Integer.parseInt(split[0]);
        y = Integer.parseInt(split[1]);
        size = new Size(x, y);
    }

    public void run(IBehavior location) {
        location.setSize(size);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Size getSize() {
        return size;
    }
}
