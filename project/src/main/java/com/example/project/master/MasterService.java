package com.example.project.master;

import com.example.project.appuser.AppUserRepository;
import com.example.project.notification.Notification;
import com.example.project.topic.Topic;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MasterService {

    private final MasterRepository masterRepository;
    private final AppUserRepository appUserRepository;

    public MasterService(MasterRepository masterRepository, AppUserRepository appUserRepository) {
        this.masterRepository = masterRepository;
        this.appUserRepository = appUserRepository;
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
}
