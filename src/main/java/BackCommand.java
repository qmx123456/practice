public class BackCommand extends Command{
    private int step;

    public BackCommand(String commandText) {
        step = Integer.parseInt(commandText);
    }

    @Override
    public void run(IBehavior location) {
        location.back(step);
    }

    public int getStep() {
        return step;
    }
}
