package Level2.행렬의곱셈;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class Practice {
	public static void main(String[] args ) {
		AtomicLong atomicTime = new AtomicLong(System.currentTimeMillis() * 1000);
		UUID uuid = UUID.randomUUID();
		
		
		System.out.println(uuid.toString());
		System.out.println(atomicTime.toString());
	}
}
