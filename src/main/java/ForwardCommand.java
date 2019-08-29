public class ForwardCommand extends Command {
    private int step;

    public ForwardCommand(String commandText) {
        step = Integer.parseInt(commandText);
    }

    @Override
    public boolean run(IBehavior location) {
        return location.forward(step);
    }

    public int getStep() {
        return step;
    }
}
