package com.makercode.springbootdemo.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> getTopics() {
        List<Topic> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topic -> topics.add(topic));
        return topics;
    }

    public Topic getTopic(String topicId) {
        return topicRepository.findById(topicId).get();
    }

    public void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    public void updateTopic(String topicId, Topic topicUpdated) {
        topicRepository.save(topicUpdated);
    }

    public void deleteTopic(String topicId) {
        topicRepository.deleteById(topicId);
    }
}
