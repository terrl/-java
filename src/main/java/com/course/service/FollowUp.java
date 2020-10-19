package com.course.service;

import com.course.pojo.PointObject;
import com.course.utils.FileUtils;
import com.course.utils.JsonUtils;

/**
 * @author lixuy
 * Created on 2019-04-11
 */
//a1
//完成门诊随访
//无限制，每次可交换积分+3分
//类名与方法名须与controller层拦截的方法一致
public class FollowUp {

  public void followUp(){
  	String file = FileUtils.readFile("score");             //读取score字符串
   	PointObject pointObject =JsonUtils.jsonToPojo(file, PointObject.class); //将file字符串转换成PointObject类对象
   	Integer exchange = pointObject.getExchangeScore();     //获得可交换积分
   	Integer total = pointObject.getExchangeScore();        //获得总积分
   	pointObject.setExchangeScore(exchange+3);              //可交换积分+3
   	pointObject.setScoreTotal(total+3);                    //总积分+3
   	String content = JsonUtils.objectToJson(pointObject);  //将PointObject类对象转换成content字符串
   	FileUtils.writeFile("score", content);                 //将content字符串写入file
    System.out.println("+++++followUp积分计算方法执行+++++");
  }
  
}
