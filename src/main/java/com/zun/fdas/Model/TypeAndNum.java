/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TypeAndNum
 * Author:   pengzijun
 * Date:     2020/4/4 9:08 下午
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.zun.fdas.Model;

/**
 * 〈封装groupby结果对象〉<br>
 * 〈〉
 *
 * @author pengzijun
 * @create 2020/4/4
 * @since 1.0.0
 */
public class TypeAndNum {


    public String getFan_no() {
        return fan_no;
    }

    public void setFan_no(String fan_no) {
        this.fan_no = fan_no;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
    //机组编号
    private String fan_no;
    //该机组编号下的报警数
    private int num;
}