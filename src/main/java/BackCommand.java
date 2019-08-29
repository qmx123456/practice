public class BackCommand extends Command{
    private int step;

    public BackCommand(String commandText) {
        step = Integer.parseInt(commandText);
    }

    @Override
    public boolean run(IBehavior location) {
        location.back(step);
        return true;
    }

    public int getStep() {
        return step;
    }
}
