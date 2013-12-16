package serie3;

import java.util.Comparator;

import static org.junit.Assert.*;
import static serie3.TreeUtils.*;

import org.junit.Test;







public class ContainsTest {

	static final Comparator<Integer> CMP_NATURAL_ORDER = new Comparator<Integer>() {
		public int compare(Integer i1, Integer i2) {
			return i1.compareTo(i2);
		}
	};
	
	@Test
	public void containsTest1()
	{
		Node <Integer> root = TreeUtilsTest.zeroToNineBST();
		assertFalse(contains(root, 10, 15, CMP_NATURAL_ORDER));
	}
	@Test
	public void containsTest2()
	{
		Node <Integer> root = TreeUtilsTest.zeroToNineBST();
		assertTrue(contains(root, 0, 15, CMP_NATURAL_ORDER));
	}
	@Test
	public void containsTest3()
	{
		Node <Integer> root = TreeUtilsTest.zeroToNineBST();
		assertFalse(contains(root, 15, 15, CMP_NATURAL_ORDER));
	}
	@Test
	public void containsTest4()
	{
		Node <Integer> root = TreeUtilsTest.zeroToNineBST();
		assertTrue(contains(root, 2, 3, CMP_NATURAL_ORDER));
	}
	@Test
	public void containsTestNullRoot()
	{
		Node <Integer> root = null;
		assertFalse(contains(root, 10, 15, CMP_NATURAL_ORDER));
	}
}
