package serie3;

import org.junit.Test;

import static org.junit.Assert.*;
import static serie3.TreeUtils.*;

public class isAllLeavesInSameLevelTest {

	@Test
	public void levelTest1()
	{
		Node <Integer> root = TreeUtils.createBSTFromRange(1, 3);
		assertTrue(isAllLeavesInSameLevel(root));
	}
	
	@Test
	public void levelTest2()
	{
		Node <Integer> root = TreeUtils.createBSTFromRange(1, 7);
		assertTrue(isAllLeavesInSameLevel(root));
	}
	
	@Test
	public void levelTest3()
	{
		Node <Integer> root = TreeUtils.createBSTFromRange(1, 6);
		assertFalse(isAllLeavesInSameLevel(root));
	}
	@Test
	public void levelTest4()
	{
		assertFalse(isAllLeavesInSameLevel(null));
	}
	@Test
	public void levelTest5()
	{
		Node <Integer> root = TreeUtils.createBSTFromRange(1, 9);
		assertFalse(isAllLeavesInSameLevel(root));
	}
	@Test
	public void levelTest6()
	{
		Node <Integer> root = TreeUtils.createBSTFromRange(1, 14);
		assertFalse(isAllLeavesInSameLevel(root));
	}
	@Test
	public void levelTest7()
	{
		Node <Integer> root = TreeUtils.createBSTFromRange(1, 15);
		assertTrue(isAllLeavesInSameLevel(root));
	}
}
