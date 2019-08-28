public class ForwardCommand extends Command {
    private int step;

    public ForwardCommand(String commandText) {
        step = Integer.parseInt(commandText);
    }

    @Override
    public void run(Location location) {
        location.forward(step);
    }

    public int getStep() {
        return step;
    }
}
