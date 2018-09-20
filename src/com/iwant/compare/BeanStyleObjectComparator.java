package com.iwant.compare;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.TreeSet;

import com.alibaba.fastjson.JSON;

public class BeanStyleObjectComparator {
	
	// 自己实现了equals的常见数据类型
			static Class<?> SupportedClasses[] = { Integer.class, String.class, Boolean.class, Character.class, Byte.class,
					Short.class, Long.class, Float.class, Double.class, ArrayList.class, LinkedList.class, Date.class,
					HashSet.class, TreeSet.class, LinkedHashSet.class };
			static ArrayList<Class<?>> SupportedClassesList = null;

			static {
				SupportedClassesList = new ArrayList<Class<?>>();
				Collections.addAll(SupportedClassesList, SupportedClasses);// 转化为List
			}
			//使用fastjson将
			static public boolean compareByJson(Object a, Object b) {
				String jsona = JSON.toJSONString(a);
				String jsonb = JSON.toJSONString(b);
				return jsona.equals(jsonb);
			}

			// 深克隆（因为compare会修改对象的变量的权限）
			static public Object deepClone(Object o) {
				// 将对象写到流里
				ByteArrayOutputStream bo = new ByteArrayOutputStream();
				ObjectOutputStream oo = null;
				try {
					oo = new ObjectOutputStream(bo);
					oo.writeObject(o);
				} catch (Exception e) {
					e.printStackTrace();
				}
				// 从流里读出来
				ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
				ObjectInputStream oi = null;
				try {
					oi = new ObjectInputStream(bi);
					return (oi.readObject());
				} catch (Exception e) {
					e.printStackTrace();
					return null;
				}
			}

			@SuppressWarnings({ "rawtypes", "unchecked" })
			static public boolean compare(Object obj_a, Object obj_b) {
				if (obj_a == null && obj_b == null) {
					return true;
				} else if (obj_a == null || obj_b == null) {
					return false;
				} else {
					Field[] fields_a = obj_a.getClass().getDeclaredFields();
					Field[] fields_b = obj_b.getClass().getDeclaredFields();
					// 变量数不等则错
					if (fields_a.length != fields_b.length)
						return false;
					// else if(fields_a.length==0 && fields_b.length) 经测试，就算是一个空类Class
					// A{}也有一个隐藏的成员变量this$0
					else
						for (int i = 0; i < fields_a.length; i++) {
							// 防止有的是private的
							fields_a[i].setAccessible(true);
							fields_b[i].setAccessible(true);

							// 先获得这个变量的实体
							Object obj_a_innerobj_i = null, obj_b_innerobj_i = null;
							try {
								obj_a_innerobj_i = fields_a[i].get(obj_a);
								obj_b_innerobj_i = fields_b[i].get(obj_b);
							} catch (IllegalArgumentException e) {
								e.printStackTrace();
							} catch (IllegalAccessException e) {
								e.printStackTrace();
							}
//							System.out.println("变量名:" + fields_a[i].getName() + ";" + fields_b[i].getName());
//							System.out.println("变量类型:" + fields_a[i].getGenericType() + ";" + fields_b[i].getGenericType());
							// 如果变量名不同,则false
							if (fields_a[i].getName() != fields_b[i].getName()) {
								return false;
							}
							// 如果变量类型不同，则false(注：此处不可用fields_a[i].getClass().toString()!!否则都会返回Field类)
							else if (!fields_a[i].getGenericType().equals(fields_b[i].getGenericType())) {
								return false;
							}
							// 经测试，传入Integer和int的getclass()相同.new
							// ArrayList().getClass()跟ArrayList.class也相同。
							// 但是List跟ArrayList不同（哪怕是以函数参数：List的形式传进来，它也还是ArrayList.
							// 如果变量不是常见类型,就继续深入比较.
							else if (!SupportedClassesList.contains(obj_a_innerobj_i.getClass())) {
								if (compare(obj_a_innerobj_i, obj_b_innerobj_i) == false)
									return false;
								// 如果两者是集合，且值不相等()
							} else if (obj_a_innerobj_i instanceof Collection) {
								// TODO 不完善的地方
								// if(!CollectionUtils.isEqualCollection((Collection<?>)obj_a_innerobj_i,
								// (Collection<?>)obj_b_innerobj_i))
								if (!(((Collection) obj_a_innerobj_i).containsAll((Collection) (obj_b_innerobj_i))
										&& ((Collection) obj_b_innerobj_i).containsAll((Collection) (obj_a_innerobj_i))))
									return false;
							}
							// 如果两者不是集合，且值不相等
							else if (!obj_a_innerobj_i.equals(obj_b_innerobj_i)) {
								return false;
							}
						}
				}
				return true;
			}

}
