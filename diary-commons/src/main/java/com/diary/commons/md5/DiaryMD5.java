package com.diary.commons.md5;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author liuchaozheng
 * @since 2019/5/17
 */
public final class DiaryMD5 {
	/**
	 * md5加密
	 * @param 待加密的字符串
	 * @param false:16位 true:32位
	 * @param false:小写 true:大写
	 */
	public static final String md5(String str, boolean length, boolean capital) throws NoSuchAlgorithmException {
		String mdString = new String();
		// 生成一个MD5加密计算摘要
        MessageDigest md = MessageDigest.getInstance("MD5");
        // 计算md5函数
        md.update(str.getBytes());
        BigInteger bigInteger = new BigInteger(1, md.digest());
        if (length) { // 32
        	mdString = bigInteger.toString(16);
		} else { // 16
			mdString = bigInteger.toString(16).substring(8, 24);
		}
        if (capital) { // 大写
        	return mdString.toUpperCase();
		} else { // 小写
			return mdString;
		}
	}

}
