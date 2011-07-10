import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InputReader {
    List<Item> itemList;

    public boolean inputFileExist(String file){
        try{
        File fileName=new File(file);
        return fileName.exists()?true:false;
        }catch (Exception e){
            System.out.print(e);
        }
        return false;
    }

    public Boolean readInputFromFile(String filename) {
        itemList=new ArrayList<Item>();
        if (inputFileExist(filename)){
            BufferedReader reader= null;
            try {
                reader = new BufferedReader(new FileReader(filename));
                String line=null;
                while ((line=reader.readLine())!=null){
                    if(!line.contains("Input") && !line.isEmpty())
                        makeItem(line);
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        }
        else {
            return false;
        }

    }

    private void makeItem(String line) {
        int itemQuantiy=Integer.parseInt(line.substring(0,line.indexOf(" ")));
        String itemName=line.substring(line.indexOf(" ")+1,line.lastIndexOf(" "));
        itemName=itemName.substring(0,itemName.length()-3);
        double itemPrice=Double.parseDouble(line.substring(line.lastIndexOf(" "),line.length()));
        Item item=new Item(itemQuantiy,itemName,itemPrice);
        itemList.add(item);

    }

    public List<Item> getItemList() {
        return itemList;
    }


}
