package com.newcitysoft.study.jvs.v8.date;

public abstract class BaseAnimalImpl implements Action {

	private String name;
	public BaseAnimalImpl(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println(this.name+"愉快地跑着！");
	}

	@Override
	public void eat() {
		System.out.println(this.name+"愉快地吃着！");
	}

}
