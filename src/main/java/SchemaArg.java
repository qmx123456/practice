public class SchemaArg {

    public IFlag getLogging() {
        return new Logging();
    }

    public IFlag getPortArg() {
        return new PortArg();
    }
}
