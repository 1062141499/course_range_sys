package com.course.model;

public class TermInfo {
    private Integer id;
    private String termName;
    private String termIntro;
    private String endTime;
    private Integer weekNum;
    private Integer enterYear;
    private Integer isSetting;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTermName() {
        return termName;
    }

    public void setTermName(String termName) {
        this.termName = (termName == null) ? null : termName.trim();
    }

    public String getTermIntro() {
        return termIntro;
    }

    public void setTermIntro(String termIntro) {
        this.termIntro = (termIntro == null) ? null : termIntro.trim();
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = (endTime == null) ? null : endTime.trim();
    }

    public Integer getWeekNum() {
        return weekNum;
    }

    public void setWeekNum(Integer weekNum) {
        this.weekNum = weekNum;
    }

    public Integer getEnterYear() {
        return enterYear;
    }

    public void setEnterYear(Integer enterYear) {
        this.enterYear = enterYear;
    }

    public Integer getIsSetting() {
        return isSetting;
    }

    public void setIsSetting(Integer isSetting) {
        this.isSetting = isSetting;
    }
}

