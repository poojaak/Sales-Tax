import java.io.*;
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

        if (inputFileExist(filename)){
            BufferedReader reader= null;
            try {
                reader = new BufferedReader(new FileReader(filename));
                String line=null;
                while ((line=reader.readLine())!=null){
                    System.out.println(line);

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
}
