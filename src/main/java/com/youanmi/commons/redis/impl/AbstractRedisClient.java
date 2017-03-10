package com.youanmi.commons.redis.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;
import redis.clients.util.Pool;

/**
 * @FileName AbstractRedistClient.java
 * @Description:
 *
 * @Date 2014年7月24日
 * @author Yang Sheng Jun
 * @version 1.0
 * 
 */

@SuppressWarnings("rawtypes")
public abstract class AbstractRedisClient<T extends Pool, R extends Jedis> {

	private static Logger logger = LoggerFactory
			.getLogger(AbstractRedisClient.class);
	ThreadLocal<T> redisPool = new ThreadLocal<T>();

	abstract public void initPool();

	public T getRedisPool() {
		logger.info("Get Redis Pool Instant:{}", redisPool.get());
		return redisPool.get();
	}

	public void setRedisPool(T pool) {
		logger.info("Set Redis Pool Instant:{}", pool);
		redisPool.set(pool);
	}

	@SuppressWarnings("unchecked")
	public void returnResource(Jedis jedis) {
		// try {
		logger.info("Get Redis Pool Instant (returnResource):{}",
				redisPool.get());
		if (jedis != null) {
			redisPool.get().returnResource(jedis);
		}
		// } catch (Exception e) {
		// if (jedis != null) {
		// redisPool.get().returnBrokenResource(jedis);
		// }
		// }

	}

	@SuppressWarnings("unchecked")
	public void returnBrokeRedis(Jedis jedis) {
		// TODO: pending
		// try {
		logger.info("Get Redis Pool Instant (returnResource):{}",
				redisPool.get());
		if (jedis != null) {
			redisPool.get().returnResource(jedis);
		}
		// } catch (Exception e) {
		// if (jedis != null) {
		// redisPool.get().returnBrokenResource(jedis);
		// }
		// }

	}

	/**
	 * 获取一个jedis 客户端
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public R getJedis() {
		return (R) redisPool.get().getResource();
	}


}
