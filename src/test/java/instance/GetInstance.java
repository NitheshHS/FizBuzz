package instance;

public class GetInstance {

    public static void main(String[] args) {
        Zip zip=new Zip();
        zip.setStateCode("NR");
        zip.setTaxRate("123");

       /* Instance<Zip> zipInstance=new Instance<>();
        System.out.println(zipInstance.getInstance());

        zipInstance.setInstance(zip, zip.getStateCode());
        System.out.println(zipInstance.getInstance());
        System.out.println(zipInstance.getInstance());
        zipInstance.setInstance(zip, "IB");
        System.out.println(zipInstance.getInstance());*/
    }
}
