package com.java.test;

import java.util.function.Consumer;
import java.util.function.Predicate;

class Student{
	private String name;
	private boolean BPL_TAG;
	private int fee;
	private int feeDiscount;
	public Student(String name, boolean bPL_TAG, int fee) {
		super();
		this.name = name;
		BPL_TAG = bPL_TAG;
		this.fee = fee;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isBPL_TAG() {
		return BPL_TAG;
	}
	public void setBPL_TAG(boolean bPL_TAG) {
		BPL_TAG = bPL_TAG;
	}
	public int getFee() {
		return fee-feeDiscount;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	public int getFeeDiscount() {
		return feeDiscount;
	}
	public void setFeeDiscount(int feeDiscount) {
		this.feeDiscount = feeDiscount;
	}
}

public class Application{
	public static Student updateFee(Student student,Predicate<Student> predicate,Consumer<Student> consumer){
		if(predicate.test(student))
			consumer.accept(student);
		return student;
	}
	
	public static void main(String[] args){
		Student student1=new Student("Aakash",false,20000);
		Student student2=new Student("Ajay",true,10000);
		student1=updateFee(student1,student->student.isBPL_TAG()==true,student->student.setFeeDiscount(500));
		student2=updateFee(student2,student->student.isBPL_TAG()==true,student->student.setFeeDiscount(500));
		System.out.println(student1.getFee());
		System.out.println(student2.getFee());
	}
}