package com.util.pageUtil;

/**
 * @ClassName:
 * @Description:
 * @auther: yant09
 * @date: 2018/11/1 10:09
 */
public class PageUtil {
    private int pageSize = 15;
    private int pageNum = 1;


    public int getStart() {
        return (pageNum - 1) * pageSize;
    }

    public int getLimit() {
        return pageSize;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public PageUtil(int pageNum, int pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public PageUtil() {
    }
}
