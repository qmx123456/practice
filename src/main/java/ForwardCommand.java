public class ForwardCommand extends Command {
    private int step;

    public ForwardCommand(String commandText) {
        step = Integer.parseInt(commandText);
    }

    @Override
    public boolean run(IBehavior location) {
        location.forward(step);
        return true;
    }

    public int getStep() {
        return step;
    }
}
