package com.newcitysoft.study.jvs.v8.date;

public class SimpleFactoryTest {
	public static void main(String[] args) {
		BaseAnimalImpl baseAnimalImpl = AnimalFactory.createAnimal("dog", "xiaohua");
		baseAnimalImpl.eat();
		baseAnimalImpl.run();
	}
}
