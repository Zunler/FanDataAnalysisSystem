/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: MysqlUtils
 * Author:   pengzijun
 * Date:     2020/4/4 11:48 上午
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.zun.fdas.utils;

import com.zun.fdas.Model.AlarmInformation;
import com.zun.fdas.serviceimpl.AlarmInformationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 〈模拟新增数据,每两秒插入一条数据〉<br>
 * 〈〉
 *
 * @author pengzijun
 * @create 2020/4/4
 * @since 1.0.0
 */
@Controller

public class GenerateDataUtils implements Runnable {
    final String[] fanNos = {"WT1231", "WT1232", "WT1233"};
    @Autowired
    private AlarmInformationServiceImpl alarmInformationService = ApplicationContextProvider.getBean(AlarmInformationServiceImpl.class);

    @Override
    public void run() {
        while (true) {
            AlarmInformation alarmInformation = new AlarmInformation();
            Date date = new Date();
            Date day = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            alarmInformation.setAlarm_time(df.format(day));
            alarmInformation.setDescription("过去30秒内发电机温度高于80度以上出现:" + (int) (Math.random() * 10) + "次");
            alarmInformation.setFan_no(fanNos[(int) (Math.random() * 10 )% 3]);

            String s = alarmInformationService.addAlarmInformation(alarmInformation);
            System.out.println(s);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}