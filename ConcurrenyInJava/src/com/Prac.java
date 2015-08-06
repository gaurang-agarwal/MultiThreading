package com;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Prac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List lst = new ArrayList();
		for(int i = 1; i < 5; i++)
		lst.add(i);
		Iterator iter = lst.iterator();
		for(Object e : lst)
		System.out.println(e);
	}
}
