package com.course.service;

import com.course.pojo.PointObject;
import com.course.utils.FileUtils;
import com.course.utils.JsonUtils;

/**
 * @author lixuy
 * Created on 2019-04-11
 */
//类名与方法名须与controller层拦截的方法一致
public class YdgnNote {

    public void ydgnNote(){
    	String file = FileUtils.readFile("score");
    	PointObject pointObject = JsonUtils.jsonToPojo(file, PointObject.class);
    	Integer grow = pointObject.getGrowScore();
    	Integer total = pointObject.getScoreTotal();
    	long jc = pointObject.getJcTime();
    	long st = System.currentTimeMillis();
    	if((st-jc)>(1000*60*60*24*90)) {
    	pointObject.setGrowScore(grow+2);
    	pointObject.setScoreTotal(total+2);
    	pointObject.setJcTime(st);
    	}
    	String content = JsonUtils.objectToJson(pointObject);
    	FileUtils.writeFile("score", content);
        System.out.println("+++++ydgnNote积分计算方法执行+++++");
    }

}
