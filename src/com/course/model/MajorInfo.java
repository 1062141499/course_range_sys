package com.course.model;

public class MajorInfo {
    private Integer id;
    private String majorName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = (majorName == null) ? null : majorName.trim();
    }
}

