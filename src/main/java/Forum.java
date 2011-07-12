public class Forum {

    public static void main(String[] args){
        BasketOfGoods basketOfGoods1=new BasketOfGoods();
        basketOfGoods1.printReceipt("input.txt");

        BasketOfGoods basketOfGoods2=new BasketOfGoods();
        basketOfGoods2.printReceipt("basket2.txt");

        BasketOfGoods basketOfGoods3=new BasketOfGoods();
        basketOfGoods3.printReceipt("basket3.txt");
       
    }
}
