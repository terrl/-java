package com.course.service;

import com.course.pojo.PointObject;
import com.course.utils.FileUtils;
import com.course.utils.JsonUtils;
/**
 * @author lixuy
 * Created on 2019-04-11
 */
//类名与方法名须与controller层拦截的方法一致
public class EvaluateReport {

    public void evaluateReport(){
    	String file = FileUtils.readFile("score");
    	PointObject pointObject = JsonUtils.jsonToPojo(file, PointObject.class);
    	Integer grow = pointObject.getGrowScore();
    	Integer total = pointObject.getScoreTotal();
    	Integer bloodsugar = pointObject.getBloodsugarCount();
    	pointObject.setBloodsugarCount(bloodsugar+1);
    	boolean inF = pointObject.getInf();
    	if((inF)&&(pointObject.getBloodsugarCount()>=10)) {//已填写资料且血糖记录大于等于10
    	pointObject.setGrowScore(grow+2);
    	pointObject.setScoreTotal(total+2);
    	}
    	String content = JsonUtils.objectToJson(pointObject);
    	FileUtils.writeFile("score", content);
        System.out.println("+++++evaluateReport积分计算方法执行+++++");
    }

}
