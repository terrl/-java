package com.course.service;

import java.util.Calendar;

import com.course.pojo.PointObject;
import com.course.utils.FileUtils;
import com.course.utils.JsonUtils;

/**
 * @author lixuy
 * Created on 2019-04-11
 */
//b1
//登录平台   
//每日首次登陆获得，成长积分+ 1分
//类名与方法名须与controller层拦截的方法一致
public class Login {

    public void login(){
    	String file = FileUtils.readFile("score");             //读取score字符串
    	PointObject pointObject =JsonUtils.jsonToPojo(file, PointObject.class);  //将file字符串转换成PointObject类对象
    	Integer grow = pointObject.getGrowScore();             //获得成长积分
    	Integer total = pointObject.getScoreTotal();           //获得总积分
    	
    	
    	
    	
    	Calendar LastLogin=pointObject.getLastLogin();          //获得上次登陆时间
       	int LastLoginYear=LastLogin.get(Calendar.YEAR);         //上次登录年份
       	int LastLoginMonth=LastLogin.get(Calendar.MONTH)+1;     //上次登录月份(默认为0-11，需要+1)
    	int LastLoginDay=LastLogin.get(Calendar.DAY_OF_MONTH);  //上次登录日
       	
    	Calendar ThisLogin=Calendar.getInstance();              //获取当前时间
     	int ThisLoginYear=ThisLogin.get(Calendar.YEAR);         //这次登录年份
       	int ThisLoginMonth=ThisLogin.get(Calendar.MONTH)+1;     //这次登录月份(默认为0-11，需要+1)
    	int ThisLoginDay=ThisLogin.get(Calendar.DAY_OF_MONTH);  //这次登录日
    	
    	if( LastLoginYear!=ThisLoginYear || LastLoginMonth!=ThisLoginMonth || LastLoginDay!=ThisLoginDay ) {
    		pointObject.setGrowScore(grow+1);                      //成长积分+1
    		pointObject.setScoreTotal(total+1);                    //总积分+1
    		pointObject.setLastLogin(ThisLogin);                   //上次登陆时间设置为本次登陆时间
    	}
    	String content = JsonUtils.objectToJson(pointObject);      //将PointObject类对象转换成content字符串
    	FileUtils.writeFile("score", content);                     //将content字符串写入file
        System.out.println("+++++login积分计算方法执行+++++");
    }

}
