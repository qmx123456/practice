public class ArgSpec {
    public String label;
    public String type;
    public Object value;

    public ArgSpec(String argText) {
        label = argText.split(":")[0];
        type = argText.split(":")[1];
    }
    @Override
    public boolean equals(Object obj){
        ArgSpec another = (ArgSpec) obj;
        return another.type.equals(type) && another.label.equals(label);
    }

    public int resolve(String[] split, int i) {
        switch (type){
            case "boolean":value=Boolean.valueOf(split[i+1]);break;
            case "integer":value=Integer.valueOf(split[i+1]);break;
            case "string":value=String.valueOf(split[i+1]);break;
        }
        i = i+2;
        return i;
    }
}
