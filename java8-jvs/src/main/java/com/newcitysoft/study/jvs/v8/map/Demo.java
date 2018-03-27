package com.newcitysoft.study.jvs.v8.map;

import java.util.HashMap;
import java.util.Map;

/**
 * 基于map接口的操作新特性
 * @author newcitysoft@163.com
 *
 */
public class Demo {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();
		for (int i = 0; i < 10; i++) {
			map.putIfAbsent(i, "val" + i);
		}
		map.forEach((id, val) -> System.out.println(val));
		//以上代码很容易理解， putIfAbsent 不需要我们做额外的存在性检查，
		//而forEach则接收一个Consumer接口来对map里的每一个键值对进行操作。
		//下面的例子展示了map上的其他有用的函数：
		map.computeIfPresent(3, (num, val) -> val + num);
		map.get(3);             // val33
		map.computeIfPresent(9, (num, val) -> null);
		map.containsKey(9);     // false
		map.computeIfAbsent(23, num -> "val" + num);
		map.containsKey(23);    // true
		map.computeIfAbsent(3, num -> "bam");
		map.get(3);             // val33
		//接下来展示如何在Map里删除一个键值全都匹配的项：
		map.remove(3, "val3");
		map.get(3);             // val33
		map.remove(3, "val33");
		map.get(3);             // null
		//另外一个有用的方法：
		map.getOrDefault(42, "not found");  // not found
		//对Map的元素做合并也变得很容易了：
		map.merge(9, "val9", (value, newValue) -> value.concat(newValue));
		map.get(9);             // val9
		map.merge(9, "concat", (value, newValue) -> value.concat(newValue));
		map.get(9);             // val9concat
	}
}
