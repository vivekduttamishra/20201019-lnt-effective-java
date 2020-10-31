package in.conceptarchitect.collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import in.conceptarchitect.utils.EvenNumberMatcher;
import in.conceptarchitect.utils.PrimeUtils;

public class IndexedListSearchSpecs {
	
	
	
	
	
	
	IndexedList<Integer> numbers;
	IndexedList<String> names;
	
	@Before
	public void init(){
		
		numbers=new LinkedList<Integer>().addMany(2,11,18,21,109,42,53,3, 108, 13, 22, 105);
		names=new DynamicArray<String>(5).addMany("Amit Singh","Jai Kumar","Chetan Deshmukh","Singh Kumar","Praveen","Steve Jobs","Suman Singh","Ranjan Singh","Manas");
		
	}
	
	private <E> void assertListContainsAll(IndexedList<E> list, E ...values) {		
		for(E value: values) {
			if(! list.contains(value) )
				fail("list doesn't contain expected "+value);
		}		
	}
	
	
	
	@Test
	public void searchShouldReturnAllEvenNumbers() {
		IndexedList<Integer> result= 
				numbers.search(new EvenNumberMatcher());
		
		assertListContainsAll(result, 2,18,42,108,22);
		assertEquals(3, result.size());
		
	}
	
	@Ignore @Test
	public void searchShouldReturnMultiplesOf7LessThan100() {
		
		
		Matcher<Integer> custom= new Matcher<Integer>() {
			
			@Override
			public boolean isMatch(Integer value) {
				// TODO Auto-generated method stub
				return value%7==0 &&value<100;
			}
		};
		
		IndexedList<Integer> result= numbers.search(custom);
		
		assertListContainsAll(result, 21,42);
		assertEquals(2, result.size());
		
		throw new RuntimeException("Some error occured");
		 
		
	}	
	
	
	@Test
	public void searchShouldReturnMultiplesValuesBetween50And100() {
		
		
		Matcher<Integer> range= (value) -> {
			return value>=50 && value<100;
		};
		
		IndexedList<Integer> result= numbers.search(range);
		
		assertListContainsAll(result, 53);
		assertEquals(1, result.size());
		 
		
	}	
	
	
	
		
	
	@Test
	public void search_canSearchAllPrimeNumbers() {
		
		//IndexedList<Integer> result= numbers.search(number-> PrimeUtils.isPrime(number));
		
		IndexedList<Integer> result = numbers.search(PrimeUtils::isPrime);
		
		assertListContainsAll(result, 2,11,53,3,13,109);
		assertEquals(6, result.size());		
	}
	
	
	
	
	
	
	
	@Test
	public void searchNamesShouldReturn3NamesWithSurnameSingh() {

		//search names with Surname as Singh
		IndexedList<String> result=
				names.search(new SurNameMatcher("Singh")); 
		
		assertListContainsAll(result, "Amit Singh","Suman Singh","Ranjan Singh");
		
		assertEquals(3, result.size());	
		
		
	}
	
	@Test
	public void searchNamesShouldReturn0NamesForMissingSurName() {
		
		SurNameMatcher matcher=new SurNameMatcher("Mishra");
		
		IndexedList<String> result= names.search(matcher::isMatch);
		
		assertEquals(0, result.size());
		
	}
	
	@Test
	public void searchNamesShouldReturnAllNamesBeforeLetterM() {
		
		IndexedList<String> result= names.search(name->name.compareToIgnoreCase("M")<0);
		
		assertListContainsAll(result, "Amit Singh","Jai Kumar","Chetan Deshmukh");
		
		assertEquals(3, result.size());	
		
		
	}
	
	@Test
	public void searchNamesShouldReturnAllNamesWithoutASurname() {
		
		IndexedList<String> result= names.search(new Matcher<String>() {
			
			@Override
			public boolean isMatch(String name) {
				// TODO Auto-generated method stub
				return name.indexOf(" ")==-1;
			}
		});
		
		assertListContainsAll(result, "Praveen","Manas");
		
		assertEquals(2, result.size());	
		
		
	}
	
	
	
	
	
	
	

}
