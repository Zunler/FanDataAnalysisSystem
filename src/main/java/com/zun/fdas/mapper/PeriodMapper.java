/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: TypeAndNumMapper
 * Author:   pengzijun
 * Date:     2020/4/4 9:10 下午
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.zun.fdas.mapper;

import com.zun.fdas.Model.Period;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author pengzijun
 * @create 2020/4/4
 * @since 1.0.0
 */
@Component
public interface PeriodMapper {
    @Select("SELECT period ,num from\n" +
            "(SELECT FROM_UNIXTIME((UNIX_TIMESTAMP(alarm_time) DIV 600)*600) as period,count(id) as num \n" +
            "FROM alarm_information \n" +
            "GROUP BY period\n" +
            "ORDER BY period desc LIMIT 6) as res\n" +
            "ORDER BY period \n")
    List<Period> getPeriod();
}