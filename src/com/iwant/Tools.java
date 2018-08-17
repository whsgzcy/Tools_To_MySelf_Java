package com.iwant;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Tools {
	
	
	public static void main(String[] args) {
		
		// 两个循环 一个对象 找出交集
		List<A> la = new ArrayList<>();
		for(int i = 0; i < 8; i++){
			A a = new A();
			a.setName("name" + i);
			la.add(a);
		}
	
		List<B> lb = new ArrayList<>();
		for(int i = 0; i < 16; i++){
			B b = new B();
			b.setName("name" + i);
			if(i > 8){
				b.setName2("name" + i);
			}else{
				b.setName2("name" + i);
			}
			lb.add(b);
		}
		
		String name = "name6";
		
		// 找出交集
		List<String> names = new ArrayList<>();
		for(int i = 0; i < la.size(); i++){
			String aName = la.get(i).getName();
			for(int m = 0; m < lb.size(); m++){
				String bName = lb.get(m).getName();
				String b2Name = lb.get(m).getName2();
				if(aName.equals(bName) && aName.equals(b2Name) && aName.equals(name)){
					System.out.println("name ---> " + aName);
				}
			}
		}
		
		List<String> lc = new ArrayList<>();
		lc.add("a");
		lc.add("b");
		lc.add("c");
		lc.add("g");
		List<String> ld = new ArrayList<>();
		ld.add("a");
		ld.add("b");
		ld.add("c");
		ld.add("d");
		ld.add("e");
		ld.add("f");		

		lc.addAll(ld);
		
		lc = removeDuplicteUsers(lc);
		System.out.println(lc);
				
		int code1 = (Integer.parseInt("020000") / 100000) * 10 + Integer.parseInt("020000") % 100000 / 10000;
		int code2 = (Integer.parseInt("020000") % 100000 % 10000 / 1000) * 10 + Integer.parseInt("020000") % 100000 % 10000 % 1000 / 100;
		int code3 = (Integer.parseInt("020000") % 100000 % 10000 % 1000 % 100 / 10) * 10 + Integer.parseInt("020000") % 100000 % 10000 % 1000 % 100 % 10;
		
		System.out.println(code1);
		System.out.println(code2);
		System.out.println(code3);
	}
	
	 public static List<String> removeDuplicteUsers(List<String> list) {
	        Set<String> s = new TreeSet<String>(new Comparator<String>() {

	            @Override
	            public int compare(String o1, String o2) {
	                return o1.compareTo(o2);
	            }
	        });
	        s.addAll(list);
	        return new ArrayList<String>(s);
	    }
	
	static class A{
		String name;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
	}
	
	static class B{
		String name;
		String name2;
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		public String getName2() {
			return name2;
		}
		public void setName2(String name2) {
			this.name2 = name2;
		}
		
	}

}