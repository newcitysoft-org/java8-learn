package com.newcitysoft.study.jvs.v8.macr;

public interface PersonFactory<P extends Person> {
	P create(String firstName, String lastName, int age);
}
