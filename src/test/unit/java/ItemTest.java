import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ItemTest{

    @Test
    public void shouldCreateChoclateItem(){
        Item choclate = new Item(1,"Choclate",20);
        assertThat(choclate.getItemName(),is("Choclate"));
        assertThat(choclate.getItemQuantity(), is(1));
        assertThat(choclate.getPrice(),is(20.0));
    }
}
