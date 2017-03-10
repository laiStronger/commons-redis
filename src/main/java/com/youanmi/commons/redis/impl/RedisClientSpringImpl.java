
package com.youanmi.commons.redis.impl;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import redis.clients.jedis.BitPosParams;
import redis.clients.jedis.GeoCoordinate;
import redis.clients.jedis.GeoRadiusResponse;
import redis.clients.jedis.GeoUnit;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ScanResult;
import redis.clients.jedis.Tuple;
import redis.clients.jedis.params.geo.GeoRadiusParam;
import redis.clients.jedis.params.sortedset.ZAddParams;
import redis.clients.jedis.params.sortedset.ZIncrByParams;

/**
 * @author Yang Sheng Jun
 *
 */
public class RedisClientSpringImpl extends RedisCommands<JedisPool, Jedis> {


	@Autowired
	JedisPool pool;
    
	public RedisClientSpringImpl() {
	}

	@Override
	public void initPool() {
		this.setRedisPool(pool);
		
	}
	
    public Jedis getJedis(){
    	if(getRedisPool()==null) {
    		initPool();
    	}
    	return (Jedis)getRedisPool().getResource();
    }

	
   
}
