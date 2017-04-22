package me.newsong.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by SinjinSong on 2017/4/22.
 */
public enum DeptStatus {
    WORKING(1,"部门正在工作中"), MEETING(2,"部门正在开会中"), VACATION(3,"部门正在休假中");
    private static Map<Integer,DeptStatus> map = new HashMap<>();
    static {
        for(DeptStatus status:values()){
            map.put(status.code,status);
        }
    }
    private int code;
    private String desc;

    DeptStatus(int code,String desc) {
        this.code = code;
        this.desc = desc;
    }
    public String getDesc(){
        return this.desc;
    }
    public int getCode(){
        return this.code;
    }
    
    public static DeptStatus getDeptStatusByCode(int code){
        return map.get(code);
    }
}
