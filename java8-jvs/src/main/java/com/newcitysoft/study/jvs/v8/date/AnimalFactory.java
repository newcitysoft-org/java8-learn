package com.newcitysoft.study.jvs.v8.date;

public class AnimalFactory {
	
	public static BaseAnimalImpl createAnimal(String type, String name){
		BaseAnimalImpl baseAnimalImpl;
		if(type.equals("dog")){
			baseAnimalImpl = new Dog(name);
		}else{
			baseAnimalImpl = new Cat(name);
		}
		return baseAnimalImpl;
	}
}
