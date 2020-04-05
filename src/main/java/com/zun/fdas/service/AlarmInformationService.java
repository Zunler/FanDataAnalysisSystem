/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: AlarmTimesInformationService
 * Author:   pengzijun
 * Date:     2020/4/4 11:55 上午
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.zun.fdas.service;

import com.zun.fdas.Model.AlarmInformation;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author pengzijun
 * @create 2020/4/4
 * @since 1.0.0
 */
@Service
public interface AlarmInformationService {

   List<AlarmInformation> getAlarmInformation();
   String addAlarmInformation(AlarmInformation alarmInformation);
   int alarmInformationCount();
}