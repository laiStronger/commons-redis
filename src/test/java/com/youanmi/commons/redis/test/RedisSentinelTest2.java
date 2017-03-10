package com.youanmi.commons.redis.test;


import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.youanmi.commons.redis.RedisClient;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;
import redis.clients.jedis.exceptions.JedisException;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:sentinel.xml")
public class RedisSentinelTest2 extends TestCase {

	@Autowired
	private RedisClient redisClient;

	@Test
	public void get() {
	    System.out.println("==========="+redisClient.get("f"));
	}

}
