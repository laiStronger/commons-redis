
package com.youanmi.commons.redis.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisSentinelPool;

/**
 * @author Yang Sheng Jun
 * 
 */
public class RedisClientSentinelImpl extends RedisCommands<JedisSentinelPool, Jedis> {

	private static Logger logger = LoggerFactory.getLogger(RedisClientSentinelImpl.class);
	
	@Autowired
	JedisSentinelPool pool;

	public RedisClientSentinelImpl() {
	}

	@Override
	public void initPool() {
		logger.info("initPool ...");
		this.setRedisPool(pool);
		
	}
	
    public Jedis getJedis(){
    	if(getRedisPool()==null) {
    		initPool();
    	}
    	return (Jedis) getRedisPool().getResource();
    }	

	
}
