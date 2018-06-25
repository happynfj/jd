package cn.nfj.mservice.util;


import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class Result implements Serializable {
    private HashMap map;

    public Result() {
        this.map = new HashMap();
    }

    public Result Add(String key, Object value) {
        this.map.put(key, value);
        return this;
    }

    public Result Add(Object value) {
        return this;
    }

    public HashMap Success() {
        this.map.put("code", 1);
        this.map.put("message", "");
        return this.map;
    }

    public HashMap Error(String msg) {
        this.map.put("code", -1);
        this.map.put("message", msg);
        return this.map;
    }

    public HashMap Warn(String msg) {
        this.map.put("code", 2);
        this.map.put("message", msg);
        return this.map;
    }


    public HashMap layuiPage(List list, long count) {
        this.map.put("data", list);
        this.map.put("count", count);
        this.map.put("code", 0);
        this.map.put("msg", "");
        return this.map;
    }
}
