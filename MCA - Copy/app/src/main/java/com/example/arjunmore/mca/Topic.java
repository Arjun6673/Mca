package com.example.arjunmore.mca;

/**
 * Created by ARJUN on 2/4/2018.
 */
public class Topic {
    private String Topicid;
    private String Topictitle;
    private String ChapterId;

    Topic(){
        super();
    }
    Topic(String Topicid,String ChapterId,String Topictitle)
    {
        this.Topicid = Topicid;
        this.ChapterId = ChapterId;
        this.Topictitle =Topictitle;
    }

    public String getTopicid() {
        return Topicid;
    }

    public void setTopicid(String topicid) {
        Topicid = topicid;
    }

    public String getTopictitle() {
        return Topictitle;
    }

    public void setTopictitle(String topictitle) {
        Topictitle = topictitle;
    }

    public String getChapterId() {
        return ChapterId;
    }

    public void setChapterId(String chapterId) {
        ChapterId = chapterId;
    }
}
