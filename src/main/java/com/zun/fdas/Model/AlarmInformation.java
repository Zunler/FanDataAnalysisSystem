/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: AlarmInformation
 * Author:   pengzijun
 * Date:     2020/4/4 11:34 上午
 * Description: 报警信息
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.zun.fdas.Model;

/**
 * 〈一句话功能简述〉<br> 
 * 〈报警信息〉
 *
 * @author pengzijun
 * @create 2020/4/4
 * @since 1.0.0
 */
public class AlarmInformation {


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFan_no() {
        return fan_no;
    }

    public void setFan_no(String fan_no) {
        this.fan_no = fan_no;
    }

    public String getAlarm_time() {
        return alarm_time;
    }

    public void setAlarm_time(String alarm_time) {
        this.alarm_time = alarm_time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private int id;
    //机组编号
    private String fan_no;
    //报警时间
    private String alarm_time;
    //报警描述
    private String description;
}