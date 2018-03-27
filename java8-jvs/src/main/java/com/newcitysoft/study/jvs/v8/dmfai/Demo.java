package com.newcitysoft.study.jvs.v8.dmfai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.newcitysoft.study.jvs.v8.macr.Person;

/**
 * 访问接口的默认方法
 * @author newcitysoft@163.com
 *
 */
public class Demo {
	private static List<String> stringCollection = new ArrayList<>();
	private static Set<Person> persons = new HashSet<Person>();

	static{
		stringCollection.add("ddd2");
		stringCollection.add("aaa2");
		stringCollection.add("bbb1");
		stringCollection.add("aaa1");
		stringCollection.add("bbb3");
		stringCollection.add("ccc");
		stringCollection.add("bbb2");
		stringCollection.add("ddd1");

		persons.add(new Person("Zhai", "YiHao", 26));
		persons.add(new Person("Liao", "PingZhou", 30));
		persons.add(new Person("Wang", "Shang", 26));
		persons.add(new Person("Tian", "LiXin", 26));
		persons.add(new Person("Zhao", "HongYu", 18));
	}

	/**
	 * Predicate接口
	 * Predicate 接口只有一个参数，返回boolean类型。
	 * 该接口包含多种默认方法来将Predicate组合成其他复杂的逻辑（比如：与，或，非）
	 */
	public static void testPredicate(){
		Predicate<String> predicate = (s) -> s.length() > 0;

		System.out.println(predicate.test("foo"));              // true
		System.out.println(predicate.negate().test("foo"));     // false

		Predicate<Boolean> nonNull = Objects::nonNull;
		System.out.println("noNull谓词是否为真："+nonNull.test(null));
		Predicate<Boolean> isNull = Objects::isNull;
		System.out.println("isNull谓词是否为真："+isNull.test(null));
		Predicate<String> isEmpty = String::isEmpty;
		System.out.println("isEmpty谓词是否为真："+isEmpty.test(new String()));
		Predicate<String> isNotEmpty = isEmpty.negate();
		System.out.println("isNotEmpty谓词是否为真："+isNotEmpty.test(new String()));
	}

	/**
	 * Function 接口
	 * Function 接口有一个参数并且返回一个结果，并附带了一些可以和其他函数组合的默认方法（compose, andThen）
	 */
	public static void testFunction(){
		Function<String, Integer> toInteger = Integer::valueOf;

		Function<String, String> backToString = toInteger.andThen(String::valueOf);

		System.out.println(backToString.apply("123"));     // "123"
	}

	/**
	 * Supplier 接口
	 * Supplier 接口返回一个任意范型的值，和Function接口不同的是该接口没有任何参数
	 */
	public static void testSupplier(){
		Supplier<String> strSupplier = String::new;
		String str = strSupplier.get();   // new Person
		System.out.println(str+"adsa");
		System.out.println(str+"123");
		System.out.println(str+"23432");
		System.out.println(str+"45");

		Supplier<Person> supplier = Person::new;
		Person person = supplier.get();
		person = new Person("Tian", "LiXin", 26);
		System.out.println(person.toString());
	}

	/**
	 * Consumer 接口
	 * Consumer 接口表示执行在单个参数上的操作
	 */
	public static void testConsumer(){
		Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.getFirstName());
		//greeter.accept(new Person("Luke", "Skywalker", 24));

		Consumer<Person> backGreeter = (p) -> System.out.println("Hi, " + p.getFirstName());
		greeter.andThen(backGreeter).accept(new Person("Alice", "Skywalker", 24));
	}

	/**
	 * Comparator 接口
	 * Comparator 是老Java中的经典接口， Java 8在此之上添加了多种默认方法
	 */
	public static void testComparator(){
		Comparator<Person> comparator = (p1, p2) -> p1.getFirstName().compareTo(p2.getFirstName());
		Person p1 = new Person("John", "Doe", 15);
		Person p2 = new Person("Alice", "Wonderland", 16);
		comparator.compare(p1, p2);             // > 0
		comparator.reversed().compare(p1, p2);  // < 0

		List<String> names = new ArrayList<String>();
		names.add("Google ");
		names.add("Runoob ");
		names.add("Taobao ");
		names.add("Baidu ");
		names.add("Sina ");

		Comparator<String> comparator2 = (s1, s2) -> s1.compareTo(s2);
		Collections.sort(names, comparator2);
		names.forEach(s->{
			System.out.println(s);
		});
	}

	/**
	 * Optional 接口
	 * Optional 不是函数是接口，这是个用来防止NullPointerException异常的辅助类型，
	 * 这是下一届中将要用到的重要概念，现在先简单的看看这个接口能干什么：
	 * Optional 被定义为一个简单的容器，其值可能是null或者不是null。
	 * 在Java 8之前一般某个函数应该返回非空对象但是偶尔却可能返回了null，
	 * 而在Java 8中，不推荐你返回null而是返回Optional。
	 */
	public static void testOptional(){
		Optional<String> optional = Optional.of("bam");

		optional.isPresent();           // true
		optional.get();                 // "bam"
		optional.orElse("fallback");    // "bam"
		optional.ifPresent((s) -> System.out.println(s.charAt(0)));     // "b"
	}

	/**
	 * Stream 接口
	 * java.util.Stream 表示能应用在一组元素上一次执行的操作序列。
	 * Stream 操作分为中间操作或者最终操作两种，
	 * 最终操作返回一特定类型的计算结果，而中间操作返回Stream本身，
	 * 这样你就可以将多个操作依次串起来。
	 * Stream 的创建需要指定一个数据源，
	 * 比如 java.util.Collection的子类，
	 * List或者Set， Map不支持。
	 * Stream的操作可以串行执行或者并行执行。
	 */
	public static void testStream(){
		List<String> stringCollection = new ArrayList<>();
		stringCollection.add("ddd2");
		stringCollection.add("aaa2");
		stringCollection.add("bbb1");
		stringCollection.add("aaa1");
		stringCollection.add("bbb3");
		stringCollection.add("ccc");
		stringCollection.add("bbb2");
		stringCollection.add("ddd1");

		stringCollection.stream();
	}

	/**
	 * Filter 过滤
	 * 过滤通过一个predicate接口来过滤并只保留符合条件的元素，
	 * 该操作属于中间操作，
	 * 所以我们可以在过滤后的结果来应用其他Stream操作（比如forEach）。
	 * forEach需要一个函数来对过滤后的元素依次执行。
	 * forEach是一个最终操作，所以我们不能在forEach之后来执行其他Stream操作。
	 */
	public static void testFilter(){
		stringCollection.stream()
				.filter((s)->s.startsWith("a"))
				.forEach(System.out::println);

		persons.stream().filter(person -> person.getAge()==26).forEach(System.out::println);
	}

	/**
	 * Sort 排序
	 * 排序是一个中间操作，返回的是排序好后的Stream。如果你不指定一个自定义的Comparator则会使用默认排序。
	 */
	public static void testSort(){
		stringCollection.stream()
				.filter((s)->s.startsWith("a"))
				.sorted()
				.forEach(System.out::println);
	}

	/**
	 * Map 映射
	 * 中间操作map会将元素根据指定的Function接口来依次将元素转成另外的对象，
	 * 下面的示例展示了将字符串转换为大写字符串。
	 * 你也可以通过map来讲对象转换成其他类型，
	 * map返回的Stream类型是根据你map传递进去的函数的返回值决定的。
	 */
	public static void testMap(){
		//stringCollection.forEach(System.out::println);
		stringCollection.stream()
				.map(String::toUpperCase)
				.sorted((a,b)->b.compareTo(a))
				.forEach(System.out::println);
	}

	/**
	 * Match 匹配
	 * Stream提供了多种匹配操作，
	 * 允许检测指定的Predicate是否匹配整个Stream。
	 * 所有的匹配操作都是最终操作，并返回一个boolean类型的值。
	 */
	public static void testMatch(){
		System.out.println("任意匹配："+stringCollection.stream().anyMatch(s->s.startsWith("a")));
		System.out.println("全部匹配："+stringCollection.stream().allMatch(s->s.startsWith("a")));
		System.out.println("无匹配："+stringCollection.stream().noneMatch(s->s.startsWith("z")));

	}

	/**
	 * Count 计数
	 * 计数是一个最终操作，返回Stream中元素的个数，返回值类型是long。
	 */
	public static void testCount(){
		System.out.println(stringCollection.stream().filter(s->s.startsWith("b")).count());
	}



	/**
	 * Reduce 规约
	 * 这是一个最终操作，
	 * 允许通过指定的函数来讲stream中的多个元素规约为一个元素，
	 * 规约后的结果是通过Optional接口表示的
	 */
	public static void testReduce(){
		Optional<String> reduced = stringCollection.stream().sorted().reduce((a,b)->a+"#"+b);
		reduced.ifPresent(System.out::print);

		System.out.println();
		Set<Integer> set = new HashSet<Integer>();

		set.add(1);
		set.add(2);
		set.add(3);
		set.add(4);
		set.add(5);

		Optional<Integer> max = set.stream().sorted().max((a,b)-> a.compareTo(b));
		max.ifPresent(System.out::println);

		//		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		List<Integer> trans = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		Optional<Integer> sum = trans.stream().reduce((a, b)->a+b);
		sum.ifPresent(System.out::println);
	}

	/**
	 * 并行Streams
	 * 前面提到过Stream有串行和并行两种，串行Stream上的操作是在一个线程中依次完成，而并行Stream则是在多个线程上同时执行。
	 */
	public static void testParallelStream(){
		int max = 1000000;
		List<String> values = new ArrayList<>(max);
		for (int i = 0; i < max; i++) {
			UUID uuid = UUID.randomUUID();
			values.add(uuid.toString());
		}
		//串行排序：
		long t0 = System.nanoTime();
		long count = values.stream().sorted().count();
		System.out.println(count);
		long t1 = System.nanoTime();
		long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
		System.out.println(String.format("sequential sort took: %d ms", millis));
		//并行排序
		long _t0 = System.nanoTime();
		long _count = values.parallelStream().sorted().count();
		System.out.println(_count);
		long _t1 = System.nanoTime();
		long _millis = TimeUnit.NANOSECONDS.toMillis(_t1 - _t0);
		System.out.println(String.format("parallel sort took: %d ms", _millis));
	}

	public static void main(String[] args) {
		//		testPredicate();
		//		testFunction();
		//		testSupplier();
		//		testConsumer();

		//		testComparator();
		//		testMap();
		//		testMatch();
		//		testCount();
		//		testReduce();
		testParallelStream();
	}
}
