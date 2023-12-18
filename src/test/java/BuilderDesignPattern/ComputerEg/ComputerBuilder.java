package BuilderDesignPattern.ComputerEg;

public class ComputerBuilder implements ComputerBuilderInterface{
    private String processor;
    private int ram;
    private int storage;
    private boolean isGraphicCardEnabled;
    private boolean isWifiEnabled;
    @Override
    public ComputerBuilderInterface processsor(String processor) {
        this.processor = processor;
        return this;
    }

    @Override
    public ComputerBuilderInterface ram(int ram) {
        this.ram=ram;
        return this;
    }

    @Override
    public ComputerBuilderInterface storgae(int storgae) {
        this.storage = storgae;
        return this;
    }

    @Override
    public ComputerBuilderInterface isGraphicCardEnabled(boolean enable) {
        this.isGraphicCardEnabled = enable;
        return this;
    }

    @Override
    public ComputerBuilderInterface isWifiEnabled(boolean enable) {
        this.isWifiEnabled = enable;
        return this;
    }

    @Override
    public Computer build() {
        return new Computer(processor,ram,storage,isGraphicCardEnabled,isWifiEnabled);
    }
}
