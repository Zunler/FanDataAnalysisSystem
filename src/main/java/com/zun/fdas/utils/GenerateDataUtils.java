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
import java.util.Random;

/**
 * 〈模拟新增数据,每3秒插入一条数据〉<br>
 * 〈〉
 *
 * @author pengzijun
 * @create 2020/4/4
 * @since 1.0.0
 */
public class GenerateDataUtils implements Runnable {
    final String[] fanNos = {"WT02287", "WT02288", "WT02289"};

    private AlarmInformationServiceImpl alarmInformationService = ApplicationContextProvider.getBean(AlarmInformationServiceImpl.class);
    @Override
    public void run() {
        while (true) {
            Random random = new Random();
            AlarmInformation alarmInformation = new AlarmInformation();
            Date date = new Date();
            Date day = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            alarmInformation.setAlarm_time(df.format(day));
            alarmInformation.setDescription("过去30秒内发电机温度高于80度以上出现:" + (random.nextInt(10)+1)+ "次");
            alarmInformation.setFan_no(fanNos[(int) (Math.random() * 10 )% 3]);

            String s = alarmInformationService.addAlarmInformation(alarmInformation);
            System.out.println(s);
            try {

                Thread.sleep(random.nextInt(10)*30000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}