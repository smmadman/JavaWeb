package com.junjie.test;

import com.junjie.utils.JdbcUtils;
import org.junit.Test;

public class JdbcUtilsTest {

    @Test
    public void testJdbcUtils(){
        System.out.println(JdbcUtils.getConnection());
    }
}
