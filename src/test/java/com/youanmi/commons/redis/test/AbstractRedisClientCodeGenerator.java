//package com.youanmi.commons.redis.test;
//
//import java.lang.reflect.Field;
//import java.lang.reflect.GenericArrayType;
//import java.lang.reflect.Method;
//import java.lang.reflect.Parameter;
//import java.lang.reflect.ParameterizedType;
//import java.lang.reflect.Type;
//import java.lang.reflect.TypeVariable;
//import java.lang.reflect.WildcardType;
//
//
////it's ok, only in jdk1.7
//public class AbstractRedisClientCodeGenerator {
//
//	public static void main(String[] args) throws Exception {
//
//		 Class<?> class1 = null;  
//	       // class1 = Class.forName("redis.clients.jedis.JedisCommands");  
//	        //class1 = Class.forName("redis.clients.jedis.MultiKeyCommands");  
//	        class1 = Class.forName("redis.clients.jedis.BasicCommands");  
//	        
//
//	          
//	          
//	        //取得类方法  
//	        Method[] methods = class1.getDeclaredMethods(); 
////	        for (Method m : methods) {
////	            System.out.println("Demo6,取得SuperMan类的方法：");  
////	            System.out.println("函数名：" + m.getName());  
////	            System.out.println("函数返回类型：" + m.getReturnType());  
////	            System.out.println("函数访问修饰符：" + Modifier.toString(m.getModifiers()));  
////	            System.out.println("函数代码写法： " + m); 
////	            Class<?> params[]=m.getParameterTypes();
////	            for (Class<?> p : params) {
////	            	System.out.println("==参数： " + p.getName()); 
////				}
////			}
//	        
//	        /*
//	    	@Override
//	    	public String set(String key, String value) {
//	    		return execute(new RedisCallback<String>() {
//	    			public String call(Jedis jedis, Object... parms) {
//	    				String key = parms[0].toString();
//	    				String value = parms[1].toString();
//	    				return jedis.set(key, value);
//	    			}
//	    		}, key, value);
//	    	}
//	    	*/
//	        for (Method m : methods) {
//	        	System.out.println("@Override");
//
//	            String methodName= m.getName();
//	            String returnType = m.getGenericReturnType().getTypeName();
//	            //instanceActualTypeArguments(m.getGenericReturnType());
//	            StringBuilder sb=new StringBuilder();
//	            int i=0;
//	            StringBuilder sbR=new StringBuilder();
//	            StringBuilder sbParam=new StringBuilder();
//	            
//	            for (Type p : m.getGenericParameterTypes()) {
//	            	String arg="arg"+i;
//	            	
//	               sb.append(p.getTypeName() + " " + arg +",");
//	               sbParam.append(String.format("      %s %s = (%s)parms[%d];" ,p.getTypeName(),arg,p.getTypeName(),i));
//	               sbParam.append("\n");
//	               sbR.append(arg+",");
//	               i++;
//	            }
//	            if(sb.length()>0){
//	            	sb.deleteCharAt(sb.length()-1); 
//	            	sbR.deleteCharAt(sbR.length()-1); 
//	            }
//	            System.out.println(String.format("public %s %s(%s) {", returnType,methodName,sb));
//	            System.out.println(String.format("  return execute(new RedisCallback<%s>() {", returnType));
//
//	            System.out.println(String.format("    public %s call(Jedis jedis, Object... parms) {",returnType));
//	            System.out.println(                     sbParam);
//	            System.out.println(String.format("      return jedis.%s(%s);",methodName, sbR));
//	            
//	            System.out.println(              "    }");
//	            System.out.println(String.format("  }, %s);", sbR));
//	            System.out.println(              "}");
//	        }
// 
//	        
//	}
//
//
//
//}
