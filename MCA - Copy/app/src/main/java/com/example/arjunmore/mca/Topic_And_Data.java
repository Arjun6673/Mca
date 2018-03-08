package com.example.arjunmore.mca;

/**
 * Created by ARJUN on 2/4/2018.
 */

public class Topic_And_Data {

    String topicId;
    String topicName;
    String topicData;

    public Topic_And_Data(String topicId, String topicName, String topicData) {
        this.topicId = topicId;
        this.topicName = topicName;
        this.topicData = topicData;
    }
    Topic_And_Data()
    {
        super();
    }
    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicData() {
        return topicData;
    }

    public void setTopicData(String topicData) {
        this.topicData = topicData;
    }
}
