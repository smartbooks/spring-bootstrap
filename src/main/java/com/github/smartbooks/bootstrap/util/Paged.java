package com.github.smartbooks.bootstrap.util;

import java.util.ArrayList;
import java.util.List;

public class Paged<T> extends Paging {

    private Long sizeCount;
    
    private List<T> data = new ArrayList<>();

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Long getSizeCount() {
        return sizeCount;
    }

    public void setSizeCount(Long sizeCount) {
        this.sizeCount = sizeCount;
    }
}
