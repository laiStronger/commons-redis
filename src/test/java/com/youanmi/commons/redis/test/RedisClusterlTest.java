package com.youanmi.commons.redis.test;

import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisSentinelPool;
import redis.clients.jedis.exceptions.JedisException;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:cluster.xml")
public class RedisClusterlTest extends TestCase {

	@Autowired
	private JedisCluster jedisCluster;

	@Test
	public void set() {
		int num = 1000;
		String key = "abc";
		String value = "";
		for (int i = 1; i <= num; i++) {
			jedisCluster.set(key + i, "tt:" + i);
			value = jedisCluster.get(key + i);
			System.out.println(key + i + "=" + value);
		}
	}

}
