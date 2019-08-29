public class DirectionFactory {
    public static Direction build(String directionText) {
        switch (directionText){
            case "N": return North.build();
            case "S": return South.build();
            case "W": return West.build();
            case "E": return East.build();
        }
        return null;
    }
}
