package io1803.bio;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * MyThreadPoolExecutor这个类的目的是实现一个线程池。
 * 实现的思路就是包装JDK提供的原生的线程池
 *  
 * MyThreadPoolExecutor类其实就是包装了 ThreadPoolExecutor类
 * 当调用MyThreadPoolExecutor.executor()方法时, 其实底层就是调用 MyThreadPoolExecutor.execute();
 *  
 * 这其实就是一种装饰器设计模式。
 * 不直接使用 MyThreadPoolExecutor.execute()方法,而选择装饰一下再使用,这样做的目的就是为了对该方法进行增强,
 * 自定义一下该方法,添加上额外的自己需要的功能。这也是装饰器模式的作用。
 */
public class MyThreadPoolExecutor {
	
	/**
	 * ThreadPoolExecutor是JDK提供的原生的线程池的实现
	 */
	private ThreadPoolExecutor pool;
	
	public MyThreadPoolExecutor(){
		/*
		 *
		 * ThreadPoolExecutor的构造器参数中, 
		 * 第一个参数是 int corePoolSize, 表示线程池的核心size,也就是核心线程数
		 * 第二个参数是 int maximumPoolSize, 线程池的最大size,也就是最大线程数
		 * 第三个参数是 long keepAliveTime, 表示每个空闲线程的存活时间
		 * 第四个参数是 TimeUnit unit, 表示第三个参数的时间单位
		 * 第五个参数是 BlockingQueue<Runnable> workQueue, 表示任务的阻塞队列,当maximumPoolSize数量的
		 * 	所有线程都在工作,仍然有任务还没被执行时,就要将任务放在阻塞队列中, 阻塞队列中的元素其实就是Runnable实现类的
		 * 	对象,等待将该其作为参数加载到Thread类的对象里去。
		 */
		pool = new ThreadPoolExecutor(4, 10, 300, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(20));
		System.out.println("初始化线程池成功");
	}

	public void execute(Runnable command){
		
		pool.execute(command);
	}
}
