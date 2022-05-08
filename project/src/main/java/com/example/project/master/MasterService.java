package com.example.project.master;

import com.example.project.appuser.AppUserRepository;
import com.example.project.notification.Notification;
import com.example.project.notification.NotificationObjectSort;
import com.example.project.phase.Phase;
import com.example.project.topic.Topic;
import com.example.project.topic.TopicRepository;
import com.example.project.topic.TopicService;
import com.example.project.topic.UpdateTopicApproveRequest;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MasterService {

    private final MasterRepository masterRepository;
    private final AppUserRepository appUserRepository;
    private final TopicRepository topicRepository;


    public MasterService(MasterRepository masterRepository, AppUserRepository appUserRepository, TopicRepository topicRepository) {
        this.masterRepository = masterRepository;
        this.appUserRepository = appUserRepository;
        this.topicRepository = topicRepository;
    }

    public List<Master> findAll() {
        return masterRepository.findAll();
    }

    public Master findById(Long id) {
        List<Master> all = masterRepository.findAll();
        for (Master m : all){
            if (Objects.equals(m.getId(), id)) {
                return m;
            }
        }
        return null;
    }

//    public void addAwaitApprovedTopicToList(Long id, Topic topic) {
//        if (findById(id).isPresent()){
//            Master m = masterRepository.getById(id);
//            System.out.println("Master id: " + id);
//            //System.out.println(m.getAwaitApproved_topic_list());
//            List<Topic> apprTopicList = new ArrayList<>();
////            if (m.getAwaitApproved_topic_list().isEmpty() || m.getAwaitApproved_topic_list() == null)
////                apprTopicList = m.getAwaitApproved_topic_list();
//            apprTopicList.add(topic);
//            m.setAwaitApproved_topic_list(apprTopicList);
//            masterRepository.save(m);
//        }
//    }

    public List<Notification> getNotifications(Long id) {
        List<Master> all = masterRepository.findAll();
        for (Master m : all){
            if (Objects.equals(m.getId(), id)) {
                return m.getNotification_list();
            }
        }
        return null;
    }

    public void approveTopicById(Long masterid, Long topicid, Boolean approve) {
        System.out.println("Masterid: " + masterid);
        System.out.println("Topicid: " + topicid);
        System.out.println("Approve: " + approve);
        if(topicRepository.findById(topicid).isPresent()){
            Topic t = topicRepository.findById(topicid).get();
            t.setApproved_topic(approve);

            List<Master> all = masterRepository.findAll();
            Notification not = null;
            for (Master m : all){
                if (Objects.equals(m.getId(), masterid)) {
                    if (!m.getNotification_list().isEmpty() && m.getNotification_list() != null){
                        for (Notification n : m.getNotification_list()){
                            if (Objects.equals(n.getObject_id(), topicid) && n.getObject_name() == NotificationObjectSort.TOPIC){
                                not = n;
                            }
                        }
                        m.getNotification_list().remove(not);
                        masterRepository.save(m);
                    }
                }
            }
            topicRepository.save(t);
        }else {
            throw new IllegalStateException();
        }
    }
}
