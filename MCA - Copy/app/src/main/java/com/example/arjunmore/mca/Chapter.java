package com.example.arjunmore.mca;

/**
 * Created by ARJUN on 2/4/2018.
 */

public class Chapter {
    private String ChapterId;
    private String ChapterName;
    private String subId;
    private String weightage;

    Chapter(String ChapterId,String subId,String ChapterName,String weightage){
        this.ChapterId = ChapterId;
        this.subId = subId;
        this.ChapterName = ChapterName;
        this.weightage =weightage;
    }
    Chapter()
    {super();}

    public String getChapterId() {
        return ChapterId;
    }

    public void setChapterId(String chapterId) {
        ChapterId = chapterId;
    }

    public String getChapterName() {
        return ChapterName;
    }

    public void setChapterName(String chapterName) {
        ChapterName = chapterName;
    }

    public String getSubId() {
        return subId;
    }

    public void setSubId(String subId) {
        this.subId = subId;
    }

    public String getWeightage() {
        return weightage;
    }

    public void setWeightage(String weightage) {
        this.weightage = weightage;
    }
}
