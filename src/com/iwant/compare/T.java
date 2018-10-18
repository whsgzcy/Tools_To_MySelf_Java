package com.iwant.compare;

import java.util.ArrayList;
import java.util.List;

public class T {
	
	public static void main(String[] args) {
		
		A aa = new A();
		List<A.AT> alist = new ArrayList<>();
		for(int i = 0; i < 10; i++){
			A.AT a = new A.AT();
			a.setAge(i + "");
			a.setName(i + "");
			alist.add(a);
		}
		aa.setList(alist);
		
		B bb = new B();
		List<B.BT> blist = new ArrayList<>();
		for(int i = 0; i < 10; i++){
			B.BT a = new B.BT();
			a.setAge(i + "");
			a.setName(i + "");
			blist.add(a);
		}
		bb.setList(blist);
		
//		System.out.println(aa.getList().equals(bb.getList()) + "");
		System.out.println(BeanStyleObjectComparator.compare(aa,bb));
		System.out.println(BeanStyleObjectComparator.compareByJson(aa,bb));
		
		A aaa = aa;
		
		System.out.println(aa.getList().equals(aaa.getList()) + "");
		System.out.println(BeanStyleObjectComparator.compare(aa.getList(), aaa.getList()) + "");
		
		A aaaa = new A();
		List<A.AT> aaaalist = new ArrayList<>();
		for(int i = 0; i < 10; i++){
			A.AT a = new A.AT();
			a.setAge(i + "");
			a.setName(i + "");
			aaaalist.add(a);
		}
		aaaa.setList(aaaalist);
		
//		System.out.println(aaaa.getList().equals(aaa.getList()) + "");
//		System.out.println(BeanStyleObjectComparator.compare(aaaa.getList(),aaa.getList()) + "");

	}
}