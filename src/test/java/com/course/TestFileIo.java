package com.course;

import com.course.pojo.PointObject;
import com.course.utils.FileUtils;
import com.course.utils.JsonUtils;

import java.util.Calendar;

import org.junit.Test;

/**
 * @author lixuy
 * Created on 2019-04-10
 */
public class TestFileIo {

    @Test
    public void testWrite(){
        try {
            PointObject pointObject = new PointObject();
            Calendar thisLogin=Calendar.getInstance();
            thisLogin.set(2020, 5, 14);   //设置上次登录时间为 2020.6.14
            pointObject.setId(1);
            pointObject.setGrowScore(0);
            pointObject.setExchangeScore(0);
            pointObject.setScoreTotal(0);
            pointObject.setInf(true);
            pointObject.setFlag(0);
            pointObject.setRecordYear(2019);
            pointObject.setLastLogin(thisLogin);
            String json = JsonUtils.objectToJson(pointObject);
            FileUtils.writeFile("score",json);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testRead(){
        try {
            String file = FileUtils.readFile("score");
            System.out.println(file);
            PointObject pointObject = JsonUtils.jsonToPojo(file,PointObject.class);
            System.out.println(pointObject);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
