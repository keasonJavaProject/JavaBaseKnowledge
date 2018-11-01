package com.util.stringFormat;

import org.apache.commons.lang3.StringUtils;

/**
 * @ClassName:
 * @Description:
 * @auther: yant09
 * @date: 2018/10/24 08:30
 */
public class StringFormatUtil {
    public static final String format(String parttern, Object... param) {
        if (StringUtils.isEmpty(parttern)) {
            return "";
        }
        parttern = parttern.replaceAll("\\{\\}", "%s");
        return String.format(parttern, param);
    }
}
