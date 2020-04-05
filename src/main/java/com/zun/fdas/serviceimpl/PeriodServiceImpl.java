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

import com.zun.fdas.Model.Period;
import com.zun.fdas.mapper.PeriodMapper;
import com.zun.fdas.service.PeriodService;
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
public class PeriodServiceImpl implements PeriodService {
    @Autowired
    private PeriodMapper periodMapper;


    @Override
    public List<Period> getPeriod() {

        try {
            List<Period> result = periodMapper.getPeriod();

            return result;
        } catch (Exception e) {
            throw e;
        }
    }
}
