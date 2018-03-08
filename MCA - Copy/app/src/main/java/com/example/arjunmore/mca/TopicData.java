package com.example.arjunmore.mca;

/**
 * Created by ARJUN on 2/4/2018.
 */

public class TopicData {

    private String Topicid;
    private String Topicpoints;
    TopicData(String Topicid,String Topicpoints)
    {
        this.Topicid= Topicid;
        this.Topicpoints = Topicpoints;
    }
    TopicData(){super();}

    public String getTopicid() {
        return Topicid;
    }

    public void setTopicid(String topicid) {
        Topicid = topicid;
    }

    public String getTopicpoints() {
        return Topicpoints;
    }

    public void setTopicpoints(String topicpoints) {
        Topicpoints = topicpoints;
    }
}
