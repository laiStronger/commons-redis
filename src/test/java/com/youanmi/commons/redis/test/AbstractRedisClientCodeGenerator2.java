package com.youanmi.commons.redis.test;

import java.lang.reflect.Modifier;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.LocalVariableAttribute;
import javassist.bytecode.MethodInfo;

public class AbstractRedisClientCodeGenerator2 {

	//javassist
	public static void main(String[] args) throws Exception {
		System.out.println(1);

		 Class<?> clazz = null;  
		 clazz = Class.forName("redis.clients.jedis.JedisCommands");  
	        ClassPool pool = ClassPool.getDefault();  
	        CtClass cc = pool.get(clazz.getName());  
	        CtMethod cm = cc.getDeclaredMethod("concatString");

	        //使用javaassist的反射方法获取方法的参数名
	        MethodInfo methodInfo = cm.getMethodInfo();  
	        CodeAttribute codeAttribute = methodInfo.getCodeAttribute();  
	        LocalVariableAttribute attr = (LocalVariableAttribute) codeAttribute.getAttribute(LocalVariableAttribute.tag);  
	        if (attr == null)  {
	            //exception
	        }
	        String[] paramNames = new String[cm.getParameterTypes().length];  
	        int pos = Modifier.isStatic(cm.getModifiers()) ? 0 : 1;  
	        for (int i = 0; i < paramNames.length; i++)  
	            paramNames[i] = attr.variableName(i + pos);      
	        //paramNames即参数名
	        for (int i = 0; i < paramNames.length; i++) {
	            System.out.println(paramNames[i]);
	        }
	        
	}

}
