/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: AlarmTimesInformationMapper
 * Author:   pengzijun
 * Date:     2020/4/4 11:54 上午
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.zun.fdas.mapper;

import com.zun.fdas.Model.AlarmInformation;
import org.apache.ibatis.annotations.Insert;
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
public interface AlarmInformationMapper {
    //获取总的报警数
    @Select("select count(id) from alarm_information")
    int getAlarmInformationCount();

    //获取在最后一条报警信息一小时范围内的20条报警信息
    @Select("SELECT *  FROM \n" +
            "(select * from alarm_information where alarm_time > DATE_SUB((SELECT alarm_time FROM alarm_information ORDER BY alarm_time DESC LIMIT 1),INTERVAL  1 HOUR) ) as res \n" +
            "ORDER BY id")
    List<AlarmInformation> getAlarmInformationList();

    //插入一条报警信息
    @Insert("insert into alarm_information(id,fan_no,alarm_time,description) values(#{id},#{fan_no},#{alarm_time},#{description})")
    int addAlarmInformation(AlarmInformation alarmInformation);
}