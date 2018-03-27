package com.newcitysoft.study.jvs.v8.date;

public class Cat extends BaseAnimalImpl {
	public Cat(String name) {
		super(name);
	}

	@Override
	public void run() {
		System.out.println("cat:"+this.getName()+"再跑！");;
	}

	@Override
	public void eat() {
		System.out.println("cat:"+this.getName()+"再吃！");;
	}

}
