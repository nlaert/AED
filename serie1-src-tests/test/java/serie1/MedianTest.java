package serie1;

import static org.junit.Assert.assertEquals;
import static serie1.Arrays.median;

import org.junit.Test;
public class MedianTest {

		@Test
		public void getMedian_onArrayWith1Element(){
			int[] array={1};
			assertEquals(1,median(array,0,0));
		}
		
		@Test
		public void getMedian_onArrayWith2Elements(){
			int[] array={1,3};
			assertEquals(2,median(array,0,1));
		}
		
		@Test
		public void getMedian_onArrayWithImparNumberOfElements(){
			int[] array={20,2,10,9,7,6,5,4,30,50,60,1,0};
			assertEquals(7,median(array,0,array.length-1));
			
		}
		
		@Test
		public void getMedian_onArrayWithParNumberOfElements(){
			int[] array={20,2,10,9,7,6,5,4,30,50,60,1,0,70};
			assertEquals(8,median(array,0,array.length-1));
			
		}
		
		

	}

	
