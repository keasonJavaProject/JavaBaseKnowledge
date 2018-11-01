package com.util.sort;
import org.apache.commons.collections.CollectionUtils;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName:
 * @Description:
 * @auther: yant09
 * @date: 2018/10/31 22:14
 */
public class SortUtil {


    public List<Integer> sort(List<Integer> data) {
        if (CollectionUtils.isEmpty(data)) {
            return data;
        }
        //升序
        Collections.sort(data, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) {
                    return 1;
                } else if (o1 == 02) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });

        //降序
        Collections.sort(data, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) {
                    return -1;
                } else if (o1 == 02) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });

        return data;
    }
}
