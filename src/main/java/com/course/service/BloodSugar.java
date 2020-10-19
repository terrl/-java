package com.course.service;

import com.course.pojo.PointObject;
import com.course.utils.FileUtils;
import com.course.utils.JsonUtils;

/**
 * @author lixuy
 * Created on 2019-04-11
 */
//类名与方法名须与controller层拦截的方法一致
public class BloodSugar {

    public void bloodSugar(){
    	String file = FileUtils.readFile("score");
    	PointObject pointObject = JsonUtils.jsonToPojo(file, PointObject.class);
    	Integer grow = pointObject.getGrowScore();
    	Integer total = pointObject.getScoreTotal();
    	Integer bloodsugar = pointObject.getBloodsugarCount();
    	pointObject.setBloodsugarCount(bloodsugar+1);
    	if(pointObject.getBloodsugarCount()==3) {
    	pointObject.setGrowScore(grow+1);
    	pointObject.setScoreTotal(total+1);
    	}
    	String content = JsonUtils.objectToJson(pointObject);
    	FileUtils.writeFile("score", content);
        System.out.println("+++++bloodSugar积分计算方法执行+++++");
    }

}
