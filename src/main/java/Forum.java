
public class Forum {

    public static void main(String[] args){
        SalesCounter counter1=new SalesCounter();
        counter1.printReceipt("basket1.txt");

        SalesCounter counter2=new SalesCounter();
        counter2.printReceipt("basket2.txt");

        SalesCounter counter3=new SalesCounter();
        counter3.printReceipt("basket3.txt");
    }
}
