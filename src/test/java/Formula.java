public class Formula {
    public static void main(String[] args) {
        double netcap=38390.11;
        double residual=12000;
        double rate=0.08873;
        int term=72;

        double calc1=(1+((rate*100)/1200));
        double numerator  =(netcap-(residual/Math.pow(calc1,term+1)));
        System.out.println("numerator: "+numerator);
        
        double denominator =(((1-(1/Math.pow(calc1,term-1))))/((rate*100)/1200))+1;
        System.out.println("denominator: "+denominator);

        double nr1=numerator/denominator;

        double nr2=nr1*term;

        double result = residual-netcap+nr2;

        System.out.println("Finance charge: "+result);


        System.out.println("added new line");
    }
}
