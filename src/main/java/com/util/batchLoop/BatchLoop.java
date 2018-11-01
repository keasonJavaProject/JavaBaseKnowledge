package com.util.batchLoop;

import com.util.pageUtil.PageUtil;
import com.util.stringFormat.StringFormatUtil;
import org.apache.commons.collections.CollectionUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName:
 * @Description:
 * @auther: yant09
 * @date: 2018/11/1 09:57
 */
public abstract class BatchLoop {
    public <T> void startLoop(int pageSize) throws Exception{
        int dbTotalSize = this.getTotalSize(new Object());
        int pageNum = 1;
        int totalSize = 0;
        PageUtil pageUtil = new PageUtil();
        while (dbTotalSize > totalSize) {
            pageUtil.setPageNum(pageNum);
            pageUtil.setPageSize(pageSize);
            Map<String, Object> map = new HashMap<>();
            map.put("start", pageUtil.getStart());
            map.put("limit", pageUtil.getLimit());
            List<T> listTemp = this.getList(map);

            if (totalSize != dbTotalSize && listTemp.size() != pageSize) {
                throw new Exception(StringFormatUtil.format("循环所有列表异常 查询个数和期望个数不相等 查询个数-{} 期望个数-{}", listTemp.size(), pageSize));
            }
            // TODO: 2018/11/1  do something with listTemp

            pageNum++;
            totalSize = totalSize + listTemp.size();
        }


    }


    public int getTotalSize(Object object) {
        return 0;
    }


    public <T> List<T>getList(Object object) {
        // TODO: 2018/11/1 db operation search
        List<T> list = null;
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }
        return list;
    }
}
