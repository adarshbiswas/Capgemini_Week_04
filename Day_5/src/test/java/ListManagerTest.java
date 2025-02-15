import static org.junit.jupiter.api.Assertions.*;

import basic_junit_testing.ListManager;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class ListManagerTest {

    @Test
    public void testAddElement() {
        ListManager manager = new ListManager();
        List<Integer> list = new ArrayList<>();
        manager.addElement(list, 5);
        assertTrue(list.contains(5));
    }

    @Test
    public void testRemoveElement() {
        ListManager manager = new ListManager();
        List<Integer> list = new ArrayList<>();
        list.add(5);
        manager.removeElement(list, 5);
        assertFalse(list.contains(5));
    }

    @Test
    public void testGetSize() {
        ListManager manager = new ListManager();
        List<Integer> list = new ArrayList<>();
        manager.addElement(list, 5);
        manager.addElement(list, 10);
        assertEquals(2, manager.getSize(list));
    }
}