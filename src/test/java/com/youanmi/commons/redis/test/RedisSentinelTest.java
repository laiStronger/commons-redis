package com.youanmi.commons.redis.test;



import junit.framework.TestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;
import redis.clients.jedis.exceptions.JedisException;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:sentinel.xml")
public class RedisSentinelTest extends TestCase {

	@Autowired
	private JedisSentinelPool pool;

	@Test
	public void set() {
		Jedis jedis = null;
	    try {
	        jedis = pool.getResource();
	       jedis.set("f", "bbbb");
	        System.out.println(jedis.get("f"));
	    } catch (JedisException je) {
	        throw je;
	    } finally {
	        if (jedis != null) pool.returnResource(jedis);
	    }
	}

}
