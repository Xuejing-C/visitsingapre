package com.nus.visitsingapore.util;

import java.util.UUID;

/**
 * generate universally unique identifier(UUID), 32 characters
 */
public final class UuidUtil {
	private UuidUtil(){}
	public static String getUuid(){
		return UUID.randomUUID().toString().replace("-","");
	}

}
