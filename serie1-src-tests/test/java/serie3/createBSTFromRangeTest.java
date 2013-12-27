package serie3;

import static org.junit.Assert.*;

import org.junit.Test;
import serie3.TreeUtilsTest;

public class createBSTFromRangeTest {

	@Test
	public void startEqualsEnd(){
		Node <Integer> aux = TreeUtils.createBSTFromRange(5,5);
		assertTrue(TreeUtilsTest.rootWithNoChild(aux));
	}
	
	@Test
	public void startBiggerThanEnd(){
		assertEquals(TreeUtils.createBSTFromRange(5, 4), null);
	}
	
	@Test
	public void isBST(){
		assertTrue(TreeUtilsTest.isBST(TreeUtils.createBSTFromRange(0, 9)));
		assertTrue(TreeUtilsTest.isBST(TreeUtils.createBSTFromRange(5, 9)));
		assertTrue(TreeUtilsTest.isBST(TreeUtils.createBSTFromRange(0, 2)));
	}
	
}
