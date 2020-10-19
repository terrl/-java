package com.course.pojo;

import java.io.Serializable;
import java.util.Calendar;

/**
 * @author lixuy
 * Created on 2019-04-10
 */
public class PointObject implements Serializable{

    private static final long serialVersionUID = 123456789L;

    private Integer id;
    //成长积分数
    private Integer growScore;
    //可兑换积分数
    private Integer exchangeScore;
    //总积分数
    private Integer scoreTotal;
    //血糖记录次数
    private Integer bloodsugarCount;
    //监测胰岛时间
    private long jcTime;
    //是否填写信息
    private boolean inF;
    //填写信息标志
    public Integer flag;
    //上次登录时间
    private Calendar lastLogin;
    //上次填写并发症记录年份
    public int recordYear;
    
    public boolean getInf() {
    	return inF;
    }
    
    public void setInf(boolean inF) {
        this.inF=inF;
    }
    
    public Integer getFlag() {
    	return flag;
    }
    
    public void setFlag(Integer flag) {
        this.flag=flag;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGrowScore() {
        return growScore;
    }

    public void setGrowScore(Integer growScore) {
        this.growScore = growScore;
    }

    public Integer getExchangeScore() {
        return exchangeScore;
    }

    public void setExchangeScore(Integer exchangeScore) {
        this.exchangeScore = exchangeScore;
    }

    public Integer getScoreTotal() {
        return scoreTotal;
    }

    public void setScoreTotal(Integer scoreTotal) {
        this.scoreTotal = scoreTotal;
    }
    
    public Integer getBloodsugarCount() {
    	return bloodsugarCount;
    }

    public void setBloodsugarCount(Integer bloodsugarCount) {
        this.bloodsugarCount = bloodsugarCount;
    }
    
    public long getJcTime() {
        return jcTime;
    }

    public void setJcTime(long jcTime) {
        this.jcTime = jcTime;
    }
    
    public Calendar getLastLogin() {
    	return lastLogin;
    }
    
    public void setLastLogin(Calendar thisLogin) {
    	this.lastLogin=thisLogin;
    }
    
    public int getRecordYear() {
    	return recordYear;
    }
    
    public void setRecordYear(int recordYear) {
    	this.recordYear=recordYear;
    }
}
