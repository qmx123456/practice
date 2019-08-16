public interface IFlag {
    String getFlag();

    Object getDefaultValue();

    Object getType();

    Object getValue();

    int set(String[] split, int index);
}
