/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: AlarmInformationController
 * Author:   pengzijun
 * Date:     2020/4/4 2:01 下午
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.zun.fdas.controller;

import com.zun.fdas.Model.AlarmInformation;
import com.zun.fdas.serviceimpl.AlarmInformationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author pengzijun
 * @create 2020/4/4
 * @since 1.0.0
 */
@RestController
public class AlarmInformationController {
    @Autowired

    AlarmInformationServiceImpl alarmInformationService;
    @RequestMapping("/add")
    public String add() {
        AlarmInformation alarmInformation = new AlarmInformation();
        Date date = new Date();
        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        alarmInformation.setAlarm_time(df.format(day));
        alarmInformation.setDescription("出现12次");
        alarmInformation.setFan_no("WT11111");
        return alarmInformationService.addAlarmInformation(alarmInformation);
    }
    @RequestMapping("/count")
    public String count() {
        AlarmInformation alarmInformation = new AlarmInformation();

        return String.valueOf(alarmInformationService.alarmInformationCount());
    }
}