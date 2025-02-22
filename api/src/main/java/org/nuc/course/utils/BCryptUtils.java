package org.nuc.course.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptUtils {
    /**
     * 对密码进行加密
     *
     * @param password
     * @return
     */
    public static String encode(String password) {
        BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
        String hashPass = bcryptPasswordEncoder.encode(password);
        return hashPass;
    }

    /**
     * 对原密码和已加密的密码进行匹配，判断是否相等
     *
     * @param password
     * @param encodedPassword
     * @return
     */
    public static boolean match(String password, String encodedPassword) {
        BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
        boolean result = bcryptPasswordEncoder.matches(password, encodedPassword);
        return result;
    }
}

