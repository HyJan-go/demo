package com.example.demo.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.TreeMap;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TencentApiCostTypeEnums {

    //
    BID_TYPE_CPC("BID_TYPE_CPC","CPC"),
    BID_TYPE_CPM("BID_TYPE_CPM","CPM"),
    ;

    private final String msg;

    private final String key;

    private static TreeMap<String, String> map = new TreeMap<>();

    static {
        TencentApiCostTypeEnums[] values = TencentApiCostTypeEnums.values();
        if (values.length > 0) {
            for (TencentApiCostTypeEnums value : values) {
            map.put(value.name(), value.getMsg());
           }
        }
    }

    TencentApiCostTypeEnums(String key, String msg) {
        this.key = key;
        this.msg = msg;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getKey() {
        return this.key;
    }

    public static TreeMap<String, String> getMap() {
        return map;
    }
}
