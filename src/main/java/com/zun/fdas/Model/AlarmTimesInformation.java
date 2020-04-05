/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: AlarmTimesInformation
 * Author:   pengzijun
 * Date:     2020/4/4 11:35 上午
 * Description: 报警次数
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.zun.fdas.Model;

/**
 * 〈一句话功能简述〉<br> 
 * 〈报警次数〉
 *
 * @author pengzijun
 * @create 2020/4/4
 * @since 1.0.0
 */
public class AlarmTimesInformation {


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getTimes() {
        return times;
    }

    public void setTimes(long times) {
        this.times = times;
    }

    private String id;
     private long times;

}