/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: HelloController
 * Author:   pengzijun
 * Date:     2020/4/3 9:31 下午
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.zun.fdas.controller;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author pengzijun
 * @create 2020/4/3
 * @since 1.0.0
 */
import com.zun.fdas.Model.AlarmInformation;
import com.zun.fdas.serviceimpl.AlarmInformationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndexController {
@Autowired
AlarmInformationServiceImpl alarmInformationService;
    @RequestMapping("/index")
    public String hello() {
        List<AlarmInformation> informationList = alarmInformationService.getAlarmInformation();
        return "index";
    }


}