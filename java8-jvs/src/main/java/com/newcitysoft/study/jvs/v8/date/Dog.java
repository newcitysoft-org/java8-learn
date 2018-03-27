package com.newcitysoft.study.jvs.v8.date;

public class Dog extends BaseAnimalImpl {
	public Dog(String name) {
		super(name);
	}

	@Override
	public void run() {
		System.out.println("dog:"+this.getName()+"再跑！");;
	}

	@Override
	public void eat() {
		System.out.println("dog:"+this.getName()+"再吃！");;
	}

}
