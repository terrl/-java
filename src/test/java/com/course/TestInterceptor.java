package com.course;

import com.course.controller.BfzNote;
import com.course.controller.FollowUp;
import com.course.controller.Login;
import com.course.controller.FillInformation;
import com.course.controller.EvaluateReport;
import com.course.controller.ExtendedActivity;
import com.course.controller.TestDesign;
import com.course.pojo.PointObject;
import com.course.utils.FileUtils;
import com.course.utils.JsonUtils;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author lixuy
 * Created on 2019-04-10
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/*.xml"})
public class TestInterceptor {
	
	@Autowired
	TestDesign testDesign;
	@Autowired
	FollowUp followUp;
	@Autowired
	Login login;
	@Autowired
	BfzNote bfzNote;
	@Autowired
	FillInformation fillInformation;
	@Autowired
	EvaluateReport evaluateReport;
	@Autowired
	ExtendedActivity extendedActivity;
    //检验当前积分情况
    private int assertScore(){
        try {
            String file = FileUtils.readFile("score");
            PointObject pointObject = JsonUtils.jsonToPojo(file,PointObject.class);
            
           	int LastLoginYear=pointObject.getLastLogin().get(Calendar.YEAR);         //上次登录年份
           	int LastLoginMonth=pointObject.getLastLogin().get(Calendar.MONTH)+1;     //上次登录月份(默认为0-11，需要+1)
        	int LastLoginDay=pointObject.getLastLogin().get(Calendar.DAY_OF_MONTH);  //上次登录日
        	
            System.out.println("成长积分："+pointObject.getGrowScore());
            System.out.println("可交换积分："+pointObject.getExchangeScore());
            System.out.println("总积分："+pointObject.getScoreTotal());
            System.out.println("血糖记录次数："+pointObject.getBloodsugarCount());
            System.out.println("胰岛监测时间："+pointObject.getJcTime());
            System.out.println("上次登录时间："+LastLoginYear+"."+LastLoginMonth+"."+LastLoginDay);
            System.out.println("上次填写并发症记录年份"+pointObject.getRecordYear());
            
            return pointObject.getScoreTotal();
        }catch (Exception e){
            e.printStackTrace();
        }
		return 0;        
    }
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("this is setUpBeforeClass...");
    }
 
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("this is tearDownAfterClass...");
    }
 
    @Before
    public void setUp() throws Exception {
        System.out.println("this is setUp...");
    }
 
    @After
    public void tearDown() throws Exception {
        System.out.println("this is tearDown...");
    }
    
    @Test
    public void testDesign() {
    	try {
    		int score1=assertScore();
    		testDesign.testDesign();
    		int score2=assertScore();
    		
    		assertEquals(1, score2-score1);
    	}catch (Exception e) {
			// TODO: handle exception
		}
    }
    
    @Test
    public void FollowUpTest() {
    	try {
    		assertScore();
    		followUp.followUp();
    		assertScore();
    	}catch (Exception e) {
			// TODO: handle exception
		}
    }
    
    @Test
    public void LoginTest() {
    	try {
    		assertScore();
    		login.login();
    		assertScore();
    	}catch (Exception e) {
			// TODO: handle exception
		}
    }
    
    @Test
    public void BfzNoteTest() {
    	try {
    		assertScore();
    		bfzNote.bfzNote();
    		assertScore();
    	}catch (Exception e) {
			// TODO: handle exception
		}
    }
    
    
    @Test
    public void FillInformationTest() {
    	try {
    		assertScore();
    		fillInformation.fillInformation();
    		assertScore();
    	}catch (Exception e) {
			// TODO: handle exception
		}
    }
    @Test
    public void EvaluateReportTest() {
    	try {
    		assertScore();
    		evaluateReport.evaluateReport();
    		assertScore();
    	}catch (Exception e) {
			// TODO: handle exception
		}
    }
    @Test
    public void ExtendedActivityTest() {
    	try {
    		assertScore();
    		extendedActivity.extendedActivity();
    		assertScore();
    	}catch (Exception e) {
			// TODO: handle exception
		}
    }
}
