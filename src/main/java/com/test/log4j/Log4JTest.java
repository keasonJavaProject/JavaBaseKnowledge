package com.test.log4j;

import org.slf4j.LoggerFactory;

import java.util.logging.Logger;

/**
 * Created by PicaHelth on 2017/7/6.
 */
public class Log4JTest {
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(Log4JTest.class);
    public static void main(String[] args) {
        logger.error("111111");
        logger.info("111111");
        logger.debug("111111");
        logger.trace("111111");
    }
}
