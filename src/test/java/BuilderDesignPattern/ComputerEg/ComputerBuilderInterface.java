package BuilderDesignPattern.ComputerEg;

public interface ComputerBuilderInterface {

    ComputerBuilderInterface processsor(String processor);
    ComputerBuilderInterface ram(int ram);
    ComputerBuilderInterface storgae(int storgae);
    ComputerBuilderInterface isGraphicCardEnabled(boolean enable);
    ComputerBuilderInterface isWifiEnabled(boolean enable);
    Computer build();

}
