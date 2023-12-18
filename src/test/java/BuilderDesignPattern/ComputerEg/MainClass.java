package BuilderDesignPattern.ComputerEg;

public class MainClass {
    public static void main(String[] args) {
        Computer computer=new ComputerBuilder().
                processsor("intel")
                .ram(16)
                .storgae(512)
                .isGraphicCardEnabled(false)
                .isWifiEnabled(true)
                .build();
        System.out.println(computer);
    }
}
