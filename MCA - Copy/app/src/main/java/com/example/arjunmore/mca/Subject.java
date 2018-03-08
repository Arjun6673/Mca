package com.example.arjunmore.mca;

/**
 * Created by ARJUN on 2/4/2018.
 */

public class Subject {
    private String SubId;
    private String SemId;
    private String subname;
    private String subchptrs;


    Subject(String SubId,String SemId,String subname,String subchptrs)
    {

        this.SubId =SubId;
        this.SemId = SemId;
        this.subname = subname;
        this.subchptrs = subchptrs;

    }
    Subject(){super();}

    public String getSubId() {
        return SubId;
    }

    public void setSubId(String subId) {
        SubId = subId;
    }

    public String getSemId() {
        return SemId;
    }

    public void setSemId(String semId) {
        SemId = semId;
    }

    public String getSubname() {
        return subname;
    }

    public void setSubname(String subname) {
        this.subname = subname;
    }

    public String getSubchptrs() {
        return subchptrs;
    }

    public void setSubchptrs(String subchptrs) {
        this.subchptrs = subchptrs;
    }
}

