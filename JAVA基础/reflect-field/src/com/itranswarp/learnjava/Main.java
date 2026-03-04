package com.itranswarp.learnjava;

import java.lang.reflect.Field;

/**
 * Learn Java from https://www.liaoxuefeng.com/
 * 
 * @author liaoxuefeng
 */
public class Main {

	public static void main(String[] args) {
		String name = "Xiao Ming";
		int age = 20;
		Person p = new Person();
		// TODO: 利用反射给name和age字段赋值
		try {

			Class<?> clazz = p.getClass();
			Field pName = clazz.getDeclaredField("name");
			pName.setAccessible(true);
			pName.set(p, name);

			Field pAge = clazz.getDeclaredField("age");
			pAge.setAccessible(true);
			pAge.set(p, age);

		} catch (NoSuchFieldException | IllegalAccessException e) {
			e.printStackTrace();
		}

		System.out.println(p.getName()); // "Xiao Ming"
		System.out.println(p.getAge()); // 20
	}
}
