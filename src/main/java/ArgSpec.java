public class ArgSpec {
    public String label;
    public String type;

    public ArgSpec(String argText) {
        label=argText.split(":")[0];
        type=argText.split(":")[1];
    }

    @Override
    public boolean equals(Object obj){
        ArgSpec another = (ArgSpec) obj;
        return type.equals(another.type) && label.equals(another.label);
    }
}
