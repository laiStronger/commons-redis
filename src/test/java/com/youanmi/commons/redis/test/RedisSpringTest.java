
package com.youanmi.commons.redis.test;

import java.util.Random;
import java.util.Set;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import redis.clients.jedis.Jedis;

import com.youanmi.commons.redis.RedisClient;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-redis.xml")
public class RedisSpringTest extends TestCase {

	@Autowired
	private RedisClient redisClient;

	@Test
	public void set() {
		// listOps.leftPush(userId, url.toExternalForm());
		redisClient.set("109", "abc");

	}

	
	
	@Test
	public void select() {
		// listOps.leftPush(userId, url.toExternalForm());
		//String r=redisClient.select(5);
		//System.out.println(r);
		Jedis j=redisClient.getJedis();
		j.select(5);
		String r2=j.set("105", "abcderewa");
		System.out.println(r2);
		redisClient.returnResource(j);

	}
	
	@Test
	public void del() {
		// listOps.leftPush(userId, url.toExternalForm());
		redisClient.del("109");

	}
	
	@Test
	public void get() {
		String value=redisClient.get("109");
		System.out.println("=====" + value);
		 //System.out.println(redisClient.get("foo"));
	}

	@Test
	public void sadd() {
		// listOps.leftPush(userId, url.toExternalForm());
		long l=redisClient.sadd("set1","431245");
		System.out.println("=====" + l);
	}
	
	@Test
	public void saddMulti() {
		// listOps.leftPush(userId, url.toExternalForm());
		Random random=new Random(System.currentTimeMillis());
		long l=redisClient.sadd("set1",""+random.nextInt(),""+random.nextInt());
		System.out.println("=====" + l);
		assertSame("",2L,l);
	}
	
	@Test
	public void smembers() {
		// listOps.leftPush(userId, url.toExternalForm());
		Set s=redisClient.smembers("set1");
		System.out.println("=====" + s);
		System.out.println("=====" + s.size());
	}
	
	@Test
	public void saddTwice() {
		sadd();
		Set s=redisClient.smembers("set1");
		System.out.println("before:" + s.size());
		sadd();
		s=redisClient.smembers("set1");
		System.out.println("after:" + s.size());
		System.out.println("===:" + s);
	}
	
}
