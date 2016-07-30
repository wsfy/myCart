package com.hsp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList al = new ArrayList();
		al.add(null);
		al.add(null);
		al.add(null);
		
		for (int i = 0; i < al.size(); i++) {
			System.out.println(al.get(i));
		}
		
		Map map = new HashMap();
		map.put(null, null);
		map.put(null, null);
		map.put(null, null);
		
		System.out.println(map.get(null));
	}
}
