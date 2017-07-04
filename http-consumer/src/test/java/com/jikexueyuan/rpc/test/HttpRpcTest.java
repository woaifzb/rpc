package com.jikexueyuan.rpc.test;

import com.jikexueyuan.rpc.People;
import com.jikexueyuan.rpc.PeopleController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by version_z on 2015/8/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring-*.xml"})
public class HttpRpcTest
{
    private static final Logger logger = LoggerFactory.getLogger(HttpRpcTest.class);

    @Resource
    private PeopleController peopleController;

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @Test
    public void test() throws InterruptedException {
        //开始的倒数锁
        final CountDownLatch countDownLatch=new CountDownLatch(10000);
        final ExecutorService exec= Executors.newFixedThreadPool(50);
        Date date = new Date();
        for(int index=0; index<10000;index++){
            final int NO=index + 1;//Cannot refer to a non-final variable NO inside an inner class defined in a different method
            Runnable run=new Runnable(){
                public void run()
                {
                    logger.info(peopleController.getSpeak(new Random().nextInt(18),new Random().nextInt(1)));
                    countDownLatch.countDown();
                }
            };
            exec.submit(run);
        }
        countDownLatch.await();
        System.out.println(new Date().getTime() - date.getTime());
        exec.shutdown();
    }
    
    
    
    public static void main(String[] args) {
    	for(int i=0;i<10;i++)
		System.out.println("age :"+ new Random().nextInt(100)+"set:"+new Random().nextInt(1));
	}
}
