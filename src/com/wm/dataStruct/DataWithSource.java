package com.wm.dataStruct;

class DataWithSource implements Comparable<DataWithSource> {
    // 数据
    private Integer value;
    // 来源的数组
    private Integer comeFrom;
    // 在数组中的 index
    private Integer index;

    public DataWithSource(Integer value, Integer comeFrom, Integer index) {
        this.value = value;
        this.comeFrom = comeFrom;
        this.index = index;
    }

    public Integer getComeFrom() {
        return comeFrom;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public int compareTo(DataWithSource o) {
        return this.value.compareTo(o.value);
    }
}
