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

import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author pengzijun
 * @create 2020/4/4
 * @since 1.0.0
 */
public interface AlarmTimesInformationMapper {
    @Select("select * from alarm order by id desc")
    List<AlarmInformationMapper> getUserList() ;
}