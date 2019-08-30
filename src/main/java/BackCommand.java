public class BackCommand extends Command{
    private int step;

    public BackCommand(String commandText) {
        step = Integer.parseInt(commandText);
    }

    @Override
    public boolean run(IBehavior location) {
        return location.back(step);
    }

    public int getStep() {
        return step;
    }
}
