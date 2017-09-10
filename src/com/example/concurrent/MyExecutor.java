package com.example.concurrent;

import java.util.concurrent.Executor;

public class MyExecutor implements Executor {

	@Override
	public void execute(Runnable r) {
		(new Thread(r)).start();

	}

}
