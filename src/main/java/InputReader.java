import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class InputReader {
    List<Item> itemList;
    LinkedHashMap<Integer,Integer> noORecordsPerInput=new LinkedHashMap<Integer, Integer>();

    public boolean inputFileExist(String file){
        try{
            File fileName=new File(file);
            return fileName.exists();
        }catch (Exception e){
            System.out.print("File not Found");
        }
        return false;
    }

    public Boolean readInputFromFile(String filename) {
        itemList=new ArrayList<Item>();
        int recordsPerInput=0;
        int numOfInput=0;
        if (inputFileExist(filename)){
            BufferedReader reader= null;
            try {
                reader = new BufferedReader(new FileReader(filename));
                String line=null;
                while ((line=reader.readLine())!=null){
                    if(!line.isEmpty())
                    {
                         if(!line.contains("Input") ){
                            makeItem(line);
                            recordsPerInput++;
                         }
                         else{
                            if(recordsPerInput>0){
                                numOfInput++;
                                noORecordsPerInput.put(numOfInput,recordsPerInput);
                                recordsPerInput=0;
                            }
                         }
                    }
                }
                numOfInput++;
                noORecordsPerInput.put(numOfInput,recordsPerInput);
                return true;
            }catch (IOException e) {
                System.out.println("Unable to read from file");
            }
            return false;
        }
        else {
            return false;
        }

    }

    private void makeItem(String line) {
        int itemQuantiy=Integer.parseInt(line.substring(0,line.indexOf(" ")));
        String itemName=line.substring(line.indexOf(" ")+1,line.lastIndexOf(" ")-3);
        double itemPrice=Double.parseDouble(line.substring(line.lastIndexOf(" "),line.length()));
        Item item=new Item(itemQuantiy,itemName,itemPrice);
        itemList.add(item);
    }

    public List<Item> getItemList() {
        return itemList;
    }


    public int totalNumOfInput() {
        return noORecordsPerInput.size();
    }

    public Integer getNumOfItemsPerInput(int key) {
        return noORecordsPerInput.get(key);
    }
}
