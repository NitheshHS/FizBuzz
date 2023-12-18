package BuilderDesignPattern.ComputerEg;

public class Computer {
    private String processer;
    private int ram;
    private int storage;
    private boolean isGraphicCardEnabled;
    private boolean isWifiEnabled;

    public Computer(String processer, int ram, int storage, boolean isGraphicCardEnabled, boolean isWifiEnabled) {
        this.processer = processer;
        this.ram = ram;
        this.storage = storage;
        this.isGraphicCardEnabled = isGraphicCardEnabled;
        this.isWifiEnabled = isWifiEnabled;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "processer='" + processer + '\'' +
                ", ram=" + ram +
                ", storage=" + storage +
                ", isGraphicCardEnabled=" + isGraphicCardEnabled +
                ", isWifiEnabled=" + isWifiEnabled +
                '}';
    }
}
