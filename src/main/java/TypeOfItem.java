
public class TypeOfItem implements ItemTyeConstants{

    public boolean checkIfItemIsImported(Item item) {
          return item.getTypeOfItem().equals(IMPORTED);
    }

    public boolean checkIfGoodsAreExemptedFromTax(String itemName) {
        boolean flag=false;
        String exemptedlList[]={"book","chocolate","pills","tablets"};
        int count=0;
        for(count=0;count<exemptedlList.length;count++){
            if(itemName.indexOf(exemptedlList[count])>=0){
                     flag=true;
            }
        }
        return flag;
    }

}
