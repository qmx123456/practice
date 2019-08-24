public class ArgSpec {
    public final String label;
    public final String type;
    public Object value;
    IExtract extract;

    public ArgSpec(String label, IExtract extract) {
        this.label =label;
        this.extract = extract;
        this.type = extract.getType();
    }

    @Override
    public boolean equals(Object obj) {
        ArgSpec another = (ArgSpec) obj;
        return type.equals(another.type) && label.equals(another.label);
    }

    public String set(String valueText) {
        return extract.extract(valueText, this);
    }
}
