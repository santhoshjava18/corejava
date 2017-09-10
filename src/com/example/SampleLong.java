package com.example;

import java.util.concurrent.atomic.AtomicLong;

public class SampleLong {

	   private AtomicLong sample = new AtomicLong();

	public long getSample() {
		return sample.get();
	}

	public void setSample(long sample) {
		this.sample.set(sample);
	}

}
