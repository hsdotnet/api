package com.hcr.api.util;

import java.util.List;

public class Paged<T> {
    private int records;    //总记录数
    private int page;       //当前页
    private int size;       //页大小
    private int total;      //总页数
    private List<T> rows;   //记录

    public int getRecords() {
        return records;
    }

    public int getPage() {
        return page;
    }

    public int getSize() {
        return size;
    }

    public int getTotal() {
        return total;
    }

    public List<T> getRows() {
        return rows;
    }

    public Paged(int page, int size, int records, List<T> rows) {
        this.page = page;
        this.size = size;
        this.records = records;
        this.total = (records + size - 1) / size;
        this.rows = rows;
    }
}
