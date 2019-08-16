public interface IFlag {
    String getFlag();

    Object getDefaultValue();

    Object getType();

    Object getValue();

    String set(String[] split);
}
