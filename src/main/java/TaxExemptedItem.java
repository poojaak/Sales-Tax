public class TaxExemptedItem extends ItemType{

    public boolean checkItemType(Item item) {
            boolean flag=false;
            String exemptedlList[]={"book","chocolate","pills","tablets"};
            int count=0;
            for(count=0;count<exemptedlList.length;count++){
                if(item.getItemName().indexOf(exemptedlList[count])>=0){
                         flag=true;
                }
            }
            return flag;
        }

}
