package com.jikexueyuan.rpc.container;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.util.concurrent.CountDownLatch;

/**
 * Created by version_z on 2015/9/8.
 */
public class Main
{
    public static void main(String[] args) throws Exception
    {
        //ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:/resources/spring-*.xml");
    	FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("src/main/resources/spring-*.xml");
        context.start();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        countDownLatch.await();
    }
}
