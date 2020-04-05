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

import com.zun.fdas.Model.TypeAndNum;
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
public interface TypeAndNumMapper {
    @Select("SELECT fan_no ,count(id) as num FROM \n" +
            "(select * from alarm_information where alarm_time > DATE_SUB((SELECT alarm_time FROM alarm_information ORDER BY alarm_time DESC LIMIT 1),INTERVAL  1 HOUR) ) as res \n" +
            "GROUP BY fan_no\n" +
            "ORDER BY num DESC")
    List<TypeAndNum> getResult() ;
}