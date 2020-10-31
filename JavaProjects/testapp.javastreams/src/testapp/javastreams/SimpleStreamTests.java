package testapp.javastreams;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

public class SimpleStreamTests {
	
	List<Integer> source;

	@Before
	public void setUp() throws Exception {
		source=Arrays.asList(2,8,11,4,21,30,47,109,29,27,14,54,98,61, 35);
		
	}

	@Test
	public void stream_collectionStreamIsAStream() {		
		
		assertTrue(source.stream() instanceof Stream);		
			
	}
	
	@Test
	public void count_canCountIsATerminalOperation() {
		long count= source
							.stream() //get a stream
							.count();  //count the items it has
		
		assertEquals( source.size(), count);
	}

	
	@Test
	public void streamCanBeCollected() {
		Stream<Integer> stream= source.stream();
		
		List<Integer> result= stream.collect(Collectors.toList());
		
		assertArrayEquals(source.toArray(), result.toArray());
		
		
	}
	
	
	@Test
	public void streamCanBeFilterEvenNumbers() {
		
		long count= source
						.stream()
						.filter(n-> n%2==0)
						.count();
		
		assertEquals(7, count);
	}
	
	
	@Test
	public void streamCanBeFilterMultiplesOf7AndStoreIt() {
		
		List<Integer> list= source
						.stream()
						.filter(n-> n%7==0)
						.collect(Collectors.toList());
		
		
						
		Integer []expectedResult= {	21,14,98, 35 };					
		
		
		assertArrayEquals(expectedResult, list.toArray());
		
		
		
	}
	
	
	@Test
	public void streamCanTransformStringToNumberStream() {
		
		List<Integer> list= Stream.of("India","USA","UK","HongKong","Singapore")
						
						.map( str-> str.length())
						.collect(Collectors.toList());
		
		
						
		Integer []expectedResult= {	5,3,2,8,9 };					
		
		
		assertArrayEquals(expectedResult, list.toArray());
		
		
		
	}
	
	
	@Test
	public void streamCanFilterAndTransformStream() {
		
		List<String> list= Stream.of("India","USA","UK","HongKong","Singapore","Germany","Japan")
						.filter(s->s.length()>3)      //filters out USA, UK
						.map( str-> str.toLowerCase()) // india, hongkong, singapore, germany, japan
						.limit(3) //takes first 3 values only -->germany japan removed
						.collect(Collectors.toList());
		
		
						
		String []expectedResult= {"india","hongkong","singapore" };					
		
		
		assertArrayEquals(expectedResult, list.toArray());		
		
		
	}
	
	
	@Test
	public void streamIntermediatesDontWorkWithoutTerminalAttached() {
		
		
		
		int []filterCount= {0}; //use an array instead of primitive int
		Counter mapCount=new Counter();
		
		Stream<Integer> stream=source //2,8,11,4,21,30,47,109,29,27,14,54,98,61, 35
									.stream()
									.filter(n->{
										filterCount[0]++;		//15 times we reach here
										return n%7==0;		    // 4 value matches the filter condition
									})				
									.map(n->{
										mapCount.increment();   //4 times   
										return n*10;
									});
		
		//stream doesn't work without terminals
		assertEquals(0, filterCount[0]);
		assertEquals(0,mapCount.getValue());
		
		//let us apply a terminal called for-each
		Counter forEachCounter=new Counter();
		
		//This operation will trigger the stream
		stream.forEach(n->forEachCounter.increment());
		
		assertEquals(source.size(), filterCount[0]);
		assertEquals(4, mapCount.getValue());
		assertEquals(4, forEachCounter.getValue());
		
		
		
	}
	
	@Test(expected = IllegalStateException.class)
	public void streamCantBeConsumedMoreThanOnce() {
		
		Stream<Integer> stream=source.stream();
		
		long count=stream.count(); // stream is consumed here
		
		List<Integer> result= stream.collect(Collectors.toList()); //attempt to consume again
		
		
	}
	
	
	
	
	
	
}
