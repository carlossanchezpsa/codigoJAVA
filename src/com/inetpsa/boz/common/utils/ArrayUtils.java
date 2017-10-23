/*
 * Creation : 19/09/2014
 */
package com.inetpsa.boz.common.utils;

public final class ArrayUtils {

	/**
	 * Contruteur priv�
	 */
	private ArrayUtils() {

	}

	public static Object[] concat(Object[] A, Object[] B) {
		int aLen = A.length;
		int bLen = B.length;
		Object[] C = new Object[aLen + bLen];
		System.arraycopy(A, 0, C, 0, aLen);
		System.arraycopy(B, 0, C, aLen, bLen);
		return C;
	}
}
