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

import com.zun.fdas.Model.TypeAndNum;
import com.zun.fdas.mapper.TypeAndNumMapper;
import com.zun.fdas.service.TypeAndNumService;
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
public class TypeAndNumServiceImpl implements TypeAndNumService {
    @Autowired
    private TypeAndNumMapper typeAndNumMapper;


    @Override
    public List<TypeAndNum> getTypeAndNum() {

        try {
            List<TypeAndNum> result = typeAndNumMapper.getResult();

            return result;
        } catch (Exception e) {
            throw e;
        }
    }
}
