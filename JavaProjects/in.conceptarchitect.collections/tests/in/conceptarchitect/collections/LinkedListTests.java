package in.conceptarchitect.collections;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import static in.conceptarchitect.collections.MyAsserts.*;
public class LinkedListTests {

	LinkedList list;
	@Before
	public void setUp() throws Exception {
		list=new LinkedList();
	}
	
	@Test
	public void init_listShouldBeEmpty() {
		
		assertEquals("LinkedList()", list.toString());
		
	}
	
	
	
	

	@Test
	public void size_shouldBe0ForNewList() {
		assertEquals(0,list.size());
	}
	
	@Test
	public void add_increasesListSize() {
		list.add("one");
		list.add("two");
		
		assertEquals(2,list.size());
	}
	
	@Test
	public void adds_addsItemToTheEndOfTheList() {
		String last="final";
		list.add("one");
		list.add("two");
		list.add(last);
		
		
		assertEquals(last, list.last.value);
		
		
	}
	
	@Test
	public void adds_shouldAddValueAsFirstItemInEmptyList() {
	
		String first="first";		
		list.add("first");
		
		assertEquals(first,list.first.value);
		
	}
	
	@Test
	public void toString_shouldIncludeAddedItems() {
	
		list.add("one");
		list.add("two");
		
		assertStringContains("one", list.toString());
		assertStringContains("two", list.toString());
		
		
	}
	
	//@Test
	public void get_0shouldReturnFirstItem() {
		
	}
	
	//@Test
	public void get_sizeMinus1ShouldReturnLastItem() {
		
	}
	
	//@Test
	public void get_minus1ShouldReturnLastItem() {
		
	}
	
	//@Test
	public void get_returnsEachItemInZeroBasedIndex() {
		
	}
	
	//@Test
	public void get_shouldThrowIndexOutOfBoundsForInvalidIndex() {
		
	}
	
	//@Test
	public void set_shouldReplaceExistingItem() {
		
	}
	
	//@Test
	public void set_doesntAddNewItem() {
		
	}

	
	//@Test
	public void set_0shouldModifyFirstItem() {
		
	}
	
	//@Test
	public void set_sizeMinus1ShouldModifyLastItem() {
		
	}
	
	//@Test
	public void set_minus1ShouldModifyLastItem() {
		
	}
	
	//@Test
	public void set_shouldThrowIndexOutOfBoundsForInvalidIndex() {
		
	}
	


}
