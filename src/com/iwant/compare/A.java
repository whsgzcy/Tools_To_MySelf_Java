package com.iwant.compare;

import java.util.List;

public class A {

	private List<AT> list;

	public List<AT> getList() {
		return list;
	}

	public void setList(List<AT> list) {
		this.list = list;
	}

	public static class AT {
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