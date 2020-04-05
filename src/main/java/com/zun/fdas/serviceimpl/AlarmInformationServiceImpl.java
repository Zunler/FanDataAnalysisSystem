/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: AlarmInformationServiceImpl
 * Author:   pengzijun
 * Date:     2020/4/4 12:05 下午
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.zun.fdas.serviceimpl;

import com.zun.fdas.Model.AlarmInformation;
import com.zun.fdas.mapper.AlarmInformationMapper;
import com.zun.fdas.service.AlarmInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author pengzijun
 * @create 2020/4/4
 * @since 1.0.0
 */
@Repository
public class AlarmInformationServiceImpl implements AlarmInformationService {
    @Autowired
    private AlarmInformationMapper alarmInformationMapper;

    @Override
    public List<AlarmInformation> getAlarmInformation() {

        try {
            List<AlarmInformation> alarmInformations = alarmInformationMapper.getAlarmInformationList();

            return alarmInformations;
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public String addAlarmInformation(AlarmInformation alarmInformation) {
        try {

            int i = alarmInformationMapper.addAlarmInformation(alarmInformation);
            return "添加成功" + i + "条数据";
        } catch (Exception e) {
            throw e;
        }

    }

    @Override
    public int alarmInformationCount() {
        return alarmInformationMapper.getAlarmInformationCount();

    }
}