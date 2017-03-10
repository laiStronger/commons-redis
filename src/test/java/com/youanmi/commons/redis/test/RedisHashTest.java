
package com.youanmi.commons.redis.test;

import java.util.Map;
import java.util.Random;
import java.util.Set;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.youanmi.commons.redis.RedisClient;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-redis.xml")
public class RedisHashTest extends TestCase {

	@Autowired
	private RedisClient redisClient;

	@Test
	public void set() {
		String key="h1";
		String field="key1";
		String value="v18648264848415489";
		redisClient.hset(key, field, value);
		String result = redisClient.hget(key, field);
		System.out.println(result);
		//Map mapEntries=redisClient.hgetAll(key);
		//System.out.println(mapEntries);

	}

	@Test
	public void get() {
		//set();
		String value=redisClient.hget("h1", "key1");
		System.out.println("=====" + value);
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
	
	
	public static void main(String args[]) {
		System.out.println(11);
	}
}
