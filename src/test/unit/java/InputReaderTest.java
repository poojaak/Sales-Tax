import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class InputReaderTest {
    List<Item> itemList;

    @Test
    public void checkFileExist() throws FileNotFoundException {
        InputReader inputReader=new InputReader();
        assertThat(inputReader.inputFileExist("input.txt"),is(true));
    }

    @Test
    public void shouldReadInput() throws FileNotFoundException {
        InputReader inputReader=new InputReader();
        assertThat(inputReader.readInputFromFile("input.txt"),is(true));
    }
}
