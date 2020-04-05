/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: Period
 * Author:   pengzijun
 * Date:     2020/4/5 11:23 上午
 * Description: 曲线数据
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.zun.fdas.Model;

/**
 * 〈一句话功能简述〉<br> 
 * 〈曲线数据〉
 *
 * @author pengzijun
 * @create 2020/4/5
 * @since 1.0.0
 */
public class Period {
    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    private String period;
    private int num;

}