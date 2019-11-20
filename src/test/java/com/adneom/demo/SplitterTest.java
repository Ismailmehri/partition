package com.adneom.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class SplitterTest {
	
	@Test
	public void shouldSplitAnEmptyList() {
		//Given
		List<Integer> in = new ArrayList<Integer>();
		Integer maxSize = 4;
		
		//When
		List<List<Integer>> out = Splitter.partition(in, maxSize);
		
		//Then
		assertNotNull(out);
		assertEquals(0, out.size());
	}
	
	@Test
	public void shouldSplitTheList() {
		
		//Given
		List<Integer> in = Arrays.asList(1,2,3,4,5,6,7,8,9);
		Integer maxSize = 4;
		
		//When
		List<List<Integer>> out = Splitter.partition(in, maxSize);
		
		//Then
		assertNotNull(out);
		assertEquals(3, out.size());
		assertEquals(maxSize, out.get(0).size());
	}
	
	@Test
	public void shouldSplitListWhenMaxSizeGreaterThanListSize() {
		
		//Given
		List<Integer> in = Arrays.asList(1,2);
		Integer maxSize = 4;
		
		//When
		List<List<Integer>> out = Splitter.partition(in, maxSize);
		
		//Then
		assertNotNull(out);
		assertEquals(1, out.size());
		assertEquals(in.size(), out.get(0).size());
	}
	
	@Test
	public void shouldThrowExceptionIfListIsNull() {
		
		//Given
		List<Integer> in = null;
		
		//Then
		assertThrows(IllegalArgumentException.class, () -> {
			Splitter.partition(in, 4);
		});

	}
	
	@Test
	public void shouldThrowExceptionIfTheListSizeIsNull() {
		
		//Given
		List<Integer> in = Arrays.asList(1,2);
		Integer maxSize = null;
		
		//Then
		assertThrows(IllegalArgumentException.class, () -> {
			Splitter.partition(in, maxSize);
		});

	}

}
