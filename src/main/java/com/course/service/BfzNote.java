package com.course.service;


import java.util.Calendar;

import com.course.pojo.PointObject;
import com.course.utils.FileUtils;
import com.course.utils.JsonUtils;

/**
 * @author lixuy
 * Created on 2019-04-11
 */
//c1
//填写并发症记录
//并发症记录每年填写一次，每年只计分一次，成长积分+1分
//类名与方法名须与controller层拦截的方法一致
public class BfzNote {

 public void bfzNote(){
 	String file = FileUtils.readFile("score");             //读取score字符串
 	PointObject pointObject =JsonUtils.jsonToPojo(file, PointObject.class);  //将file字符串转换成PointObject类对象
 	Integer grow = pointObject.getGrowScore();             //获得成长积分
 	Integer total = pointObject.getScoreTotal();           //获得总积分
 	int LastRecordYear = pointObject.getRecordYear();  //获取上次填写并发症记录年份
 	
	Calendar ThisLogin=Calendar.getInstance();              //获取当前时间
 	int ThisRecordYear=ThisLogin.get(Calendar.YEAR);        //这次登录年份
 	//判断 如果是今年第一次 +1分
 	if((ThisRecordYear-LastRecordYear)>=1) {                //如果此次记录年份与上次记录年份相差大于等于1
 		pointObject.setGrowScore(grow+1);                  //成长积分+1
 		pointObject.setScoreTotal(total+1);                //总积分+1
 	    pointObject.setRecordYear(ThisRecordYear);         //将记录年份改成本次记录年份
 	}
 	String content = JsonUtils.objectToJson(pointObject);  //将PointObject类对象转换成content字符串
 	FileUtils.writeFile("score", content);                 //将content字符串写入file

  	String content1 = JsonUtils.objectToJson(pointObject);  //将PointObject类对象转换成content字符串
 	FileUtils.writeFile("score", content1);                 //将content字符串写入file
        System.out.println("+++++bfzNote积分计算方法执行+++++");
    }

}
