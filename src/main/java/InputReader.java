import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class InputReader {
    List<Item> itemList;

    public boolean inputFileExist(String file) throws FileNotFoundException {
        File checkFile=new File(file);
        return checkFile.exists()?true:false;
    }
}
