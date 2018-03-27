package com.newcitysoft.study.jvs.v8.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Demo1 {
	private static List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

	/**
	 * 只需要给静态方法 Collections.sort 传入一个List对象以及一个比较器来按指定顺序排列。
	 * 通常做法都是创建一个匿名的比较器对象然后将其传递给sort方法。
	 */
	public static void oldSort(){
		Collections.sort(names, new Comparator<String>() {
			@Override
			public int compare(String a, String b) {
				return b.compareTo(a);
			}
		});
	}

	/**
	 * 只需要给静态方法 Collections.sort 传入一个List对象以及一个比较器来按指定顺序排列。
	 * 通常做法都是创建一个匿名的比较器对象然后将其传递给sort方法。
	 */
	public static void newSort(){
//		Collections.sort(names, (String a, String b) -> {
//		    return b.compareTo(a);
//		});
//		//对于函数体只有一行代码的，你可以去掉大括号{}以及return关键字
//		Collections.sort(names, (String a, String b) -> b.compareTo(a));
//		
		Collections.sort(names, (a, b) -> b.compareTo(a));
	}
	public static void main(String[] args) {
		newSort();
		names.forEach(a -> {
			System.out.println(a);
		});
	}
}
