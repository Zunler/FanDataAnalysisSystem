/**
 * Copyright (C), 2015-2020, XXX有限公司
 * FileName: SendMessage
 * Author:   pengzijun
 * Date:     2020/4/4 6:43 下午
 * Description: 发送新增数据
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.zun.fdas.utils;

/**
 * 〈一句话功能简述〉<br>
 * 〈发送新增数据〉
 *
 * @author pengzijun
 * @create 2020/4/4
 * @since 1.0.0
 */

import com.zun.fdas.Model.AlarmInformation;
import com.zun.fdas.Model.Period;
import com.zun.fdas.Model.TypeAndNum;
import com.zun.fdas.serviceimpl.AlarmInformationServiceImpl;
import com.zun.fdas.serviceimpl.PeriodServiceImpl;
import com.zun.fdas.serviceimpl.TypeAndNumServiceImpl;
import org.json.JSONException;
import org.json.JSONObject;

import javax.websocket.Session;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;


public class SendMessage implements Runnable {


    private Session session;
    //曲线图节点数
    private final int GRAPH_NODE_NUM = 6;

    private List<AlarmInformation> currentMessage;

    private AlarmInformationServiceImpl alarmInformationService;
    private TypeAndNumServiceImpl typeAndNumService;
    private PeriodServiceImpl periodService;


    private int currentIndex;


    public SendMessage(Session session) {

        this.session = session;

        currentMessage = new ArrayList<AlarmInformation>();
        alarmInformationService = ApplicationContextProvider.getBean(AlarmInformationServiceImpl.class);
        typeAndNumService = ApplicationContextProvider.getBean(TypeAndNumServiceImpl.class);
        periodService = ApplicationContextProvider.getBean(PeriodServiceImpl.class);
        currentIndex = 0;

    }


    @Override
    public void run() {

        while (true) {

            List<AlarmInformation> list = null;
            List<TypeAndNum> typeAndNumList = typeAndNumService.getTypeAndNum();


            list = alarmInformationService.getAlarmInformation();
            int count = alarmInformationService.alarmInformationCount();


            if (list != null && currentIndex < list.size()) {

                for (int i = currentIndex; i < list.size(); i++) {

                    try {
                        JSONObject object = new JSONObject(new LinkedHashMap());

                        JSONObject groupby = new JSONObject(new LinkedHashMap());
                        JSONObject graph = new JSONObject(new LinkedHashMap());
                        int type = typeAndNumList.size();
                        //报警信息
                        object.put("count", count);
                        object.put("fanNo", list.get(i).getFan_no());
                        object.put("alarmTime", list.get(i).getAlarm_time());
                        object.put("description", list.get(i).getDescription());
                        object.put("type", type);
                        //取出分组聚合结果，每个机组的报警数
                        for (int j = 0; j < type; j++) {
                            TypeAndNum typeAndNum = typeAndNumList.get(j);
                            groupby.put(typeAndNum.getFan_no(), typeAndNum.getNum());
                        }
                        //取出曲线图节点数据
                        List<Period> period = periodService.getPeriod();

                        for (int j = 0; j < GRAPH_NODE_NUM; j++) {
                            JSONObject node = new JSONObject();
                            node.put(period.get(j).getPeriod(), period.get(j).getNum());
                            graph.put(String.valueOf(j),node);
                        }

                        object.put("groupByRes", groupby);

                        object.put("graph", graph);

                        System.out.println(String.valueOf(object));
                        session.getBasicRemote().sendText(String.valueOf(object));

                    } catch (IOException | JSONException e) {

                        e.printStackTrace();

                    }

                }

                currentIndex = list.size();
            }
            try {

                //3秒刷新一次

                Thread.sleep(3000);

            } catch (InterruptedException e) {

                e.printStackTrace();

            }


        }

    }

}