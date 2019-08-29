public class TurnRightCommand extends Command {
    private int step;

    public TurnRightCommand(String s) {
        step = Integer.parseInt(s);
    }

    @Override
    public void run(Location location) {
        location.turnRight(step);
    }

    public int getStep() {
        return step;
    }
}
