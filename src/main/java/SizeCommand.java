public class SizeCommand extends Command {
    private Size size;

    public SizeCommand(String commandText) {
        String[] split = commandText.split(",");
        size = new Size(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
    }

    public boolean run(IBehavior location) {
        return location.setSize(size);
    }

    public Size getSize() {
        return size;
    }
}
