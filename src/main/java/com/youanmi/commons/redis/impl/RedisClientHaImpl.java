
package com.youanmi.commons.redis.impl;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import org.springframework.beans.factory.annotation.Autowired;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.exceptions.JedisConnectionException;

/**
 * @author Yang Sheng Jun
 *
 */
public class RedisClientHaImpl extends AbstractRedisClient<JedisPool, Jedis> {

	AtomicBoolean isMainPool=new AtomicBoolean(true);
	
	@Autowired
	JedisPool jedisPool;
	
	@Autowired
	JedisPool jedisPoolSecond;
    
	public RedisClientHaImpl() {
	}
    

	@Override
	public void initPool() {
		this.setRedisPool(jedisPool);
		
	}
	
    /**
     * 获取一个jedis 客户端
     * @return
     */
	public Jedis getJedis() {
		Jedis jedis=null;
		try{

	    	if(getRedisPool()==null) {
	    		initPool();
	    	}
			//jedis = jedisPool.getResource();//有缺陷，pool1 down掉后，后续的每次操作都要试错一次
	    	jedis = this.getRedisPool().getResource();
			isMainPool.set(true);

			return jedis;
		}catch(JedisConnectionException e){
			//第一次用“备用redis”的时候得初始化，以后就不用再初始化了
	    	if(getRedisPool()==null || !isMainPool.get()) {
	    		this.setRedisPool(jedisPoolSecond);
	    	}
			jedis = jedisPoolSecond.getResource();
			isMainPool.set(false);
			
			return jedis;
		}


	}

}
