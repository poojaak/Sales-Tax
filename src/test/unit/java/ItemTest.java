import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ItemTest{

    @Test
    public void shouldCreateChoclateBarItem(){
        Item choclateBar = new Item(1,"Choclate bar",0.85);
        assertThat(choclateBar.getItemName(),is("Choclate bar"));
        assertThat(choclateBar.getItemQuantity(), is(1));
        assertThat(choclateBar.getPrice(),is(0.85));
    }
}
