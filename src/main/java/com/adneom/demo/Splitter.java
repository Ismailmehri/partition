package com.adneom.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * Écrivez une fonction « partition » qui prend un paramètre « liste » et un paramètre 
 * « taille » et retourne une liste de sous liste, où chaque sous liste a au maximum 
 * « taille » éléments.
 * 
 * @author ismail
 *
 */
public class Splitter {
	
	/**
	 * This function allows to create lists from an initial list
	 * @param initialList the initial list
	 * @param maxListSize max list size
	 * @return 
	 */
	public static List<List<Integer>> partition(List<Integer> initialList, Integer maxListSize) {
		
		if (null == initialList || null == maxListSize) {
			throw new IllegalArgumentException("One of the parameters is null");
		}
		
		List<List<Integer>> finalList = new ArrayList<List<Integer>>();
		for (int i = 0; i < initialList.size(); i += maxListSize) {
		    int end = Math.min(initialList.size(), i + maxListSize);
		    finalList.add(initialList.subList(i, end));
		}
		return finalList;
	}

}
