package com.iwant.compare;

import java.util.List;

public class B {

	private List<BT> list;

	public List<BT> getList() {
		return list;
	}

	public void setList(List<BT> list) {
		this.list = list;
	}

	public static class BT {
		String name;
		String age;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAge() {
			return age;
		}

		public void setAge(String age) {
			this.age = age;
		}

	}

}
