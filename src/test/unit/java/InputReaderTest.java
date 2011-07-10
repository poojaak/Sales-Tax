import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;


public class InputReaderTest {
    List<Item> itemList;
    InputReader inputReader=new InputReader();

    @Test
    public void checkFileExist() throws FileNotFoundException {
        assertThat(inputReader.inputFileExist("input.txt"),is(true));
    }

    @Test
    public void shouldReadInput() throws FileNotFoundException {
        assertThat(inputReader.readInputFromFile("input.txt"), is(true));
    }

    @Test
    public void shouldMakeAnItem(){
        Item book=new Item(1,"book",12.49);
        inputReader.readInputFromFile("input.txt");
        itemList=inputReader.getItemList();
        Item retrievedItem=itemList.get(0);

        assertEquals(retrievedItem.getItemName(),book.getItemName());
        assertEquals(retrievedItem.getItemQuantity(),book.getItemQuantity());
        assertEquals(retrievedItem.getPrice(),book.getPrice(),0);

    }

    @Test
    public void shouldCheckInputCount() throws FileNotFoundException {
        inputReader.readInputFromFile("input.txt");
        assertThat(inputReader.totalNumOfInput(),is(3));
    }
}
