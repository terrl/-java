package com.course.service;

import com.course.pojo.PointObject;
import com.course.utils.FileUtils;
import com.course.utils.JsonUtils;

/**
 * @author lixuy
 * Created on 2019-04-11
 */
//类名与方法名须与controller层拦截的方法一致
public class FillInformation {

    public void fillInformation(){
    	String file = FileUtils.readFile("score");
    	PointObject pointObject = JsonUtils.jsonToPojo(file, PointObject.class);
    	Integer grow = pointObject.getGrowScore();
    	Integer total = pointObject.getScoreTotal();
    	boolean inf = pointObject.getInf();
    	if((inf)&&(pointObject.flag==0)) {//已填写资料且首次填写
    	pointObject.setGrowScore(grow+2);
    	pointObject.setScoreTotal(total+2);
    	pointObject.flag=1;
    	}
    	String content = JsonUtils.objectToJson(pointObject);
    	FileUtils.writeFile("score", content);
        System.out.println("+++++fillInformation积分计算方法执行+++++");
    }

}
