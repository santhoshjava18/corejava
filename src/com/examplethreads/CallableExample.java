package com.examplethreads;

import java.util.*;
import java.util.concurrent.*;

public class CallableExample {
	public static class WordLengthCallable implements Callable {
		private Employee emp;

		public WordLengthCallable(Employee emp) {
			this.emp = emp;
		}

		public String call() {
			System.out.println(new Date().getTime());
			return  emp.getName()+"--"+emp.getSalary();//Integer.valueOf(word.length());
		}
	}
	
	
	public List<Employee> createDataList(){
		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(new Employee("first", 200));
		employeeList.add(new Employee("second", 300));
		employeeList.add(new Employee("third", 400));
		return employeeList;
	}

	public static void main(String args[]) throws Exception {
		List<Employee> employeeList = new CallableExample().createDataList();
		ExecutorService pool = Executors.newFixedThreadPool(3);
		Set<Future<Integer>> set = new HashSet<Future<Integer>>();
		for (Employee emp : employeeList) {
			Callable<Integer> callable = new WordLengthCallable(emp);
			Future<Integer> future = pool.submit(callable);
			set.add(future);
		}
		/*String sum = "";
		for (Future<Integer> future : set) {
			sum += future.get();
		}
		System.out.printf("The sum of lengths is %s%n", sum);*/
		//System.exit(sum);
	}
}
