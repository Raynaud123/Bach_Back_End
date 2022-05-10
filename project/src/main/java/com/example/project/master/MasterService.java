package com.example.project.Master;

import com.example.project.appuser.AppUserRepository;
import com.example.project.exceptions.IdNotFoundRequestException;
import com.example.project.notification.Notification;
import com.example.project.notification.NotificationObjectSort;
import com.example.project.promotor.Promotor;
import com.example.project.promotor.PromotorRepository;
import com.example.project.topic.Topic;
import com.example.project.topic.TopicRepository;
import com.example.project.topicprovider.TopicProvider;
import com.example.project.topicprovider.TopicProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MasterService {

    @Autowired
    private final MasterRepository masterRepository;
    @Autowired
    private final AppUserRepository appUserRepository;
    @Autowired
    private final TopicRepository topicRepository;
    @Autowired
    private final PromotorRepository promotorRepository;
    @Autowired
    private final TopicProviderRepository topicProviderRepository;


    public MasterService(MasterRepository masterRepository, AppUserRepository appUserRepository, TopicRepository topicRepository, PromotorRepository promotorRepository, TopicProviderRepository topicProviderRepository) {
        this.masterRepository = masterRepository;
        this.appUserRepository = appUserRepository;
        this.topicRepository = topicRepository;
        this.promotorRepository = promotorRepository;
        this.topicProviderRepository = topicProviderRepository;
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

    public void approveTopicById(Long masterid, Long topicid, Boolean approve) throws IdNotFoundRequestException {
//        System.out.println("Masterid: " + masterid);
//        System.out.println("Topicid: " + topicid);
//        System.out.println("Approve: " + approve);
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
            throw new IdNotFoundRequestException("Id " + topicid + "niet gevonden");
        }
    }

    public void approvePromotorById(Long masterid, Long promotorid, Boolean approve) throws IdNotFoundRequestException {
//        System.out.println("Masterid: " + masterid);
//        System.out.println("promotorid: " + promotorid);
//        System.out.println("Approve: " + approve);
        if(promotorRepository.findById(promotorid).isPresent()){
            Promotor p = promotorRepository.findById(promotorid).get();
            p.setApproved(approve);

            List<Master> all = masterRepository.findAll();
            Notification not = null;
            for (Master m : all){
                if (Objects.equals(m.getId(), masterid)) {
                    if (!m.getNotification_list().isEmpty() && m.getNotification_list() != null){
                        for (Notification n : m.getNotification_list()){
                            if (Objects.equals(n.getObject_id(), promotorid) && n.getObject_name() == NotificationObjectSort.PROMOTOR){
                                not = n;
                            }
                        }
                        m.getNotification_list().remove(not);
                        masterRepository.save(m);
                    }
                }
            }
            promotorRepository.save(p);
        }else {
            throw new IdNotFoundRequestException("Id " + promotorid + "niet gevonden");
        }
    }

    public void approveCompanyById(Long masterid, Long companyid, Boolean approve) throws IdNotFoundRequestException {
//        System.out.println("Masterid: " + masterid);
//        System.out.println("companyid: " + companyid);
//        System.out.println("Approve: " + approve);
        if(topicProviderRepository.findById(companyid).isPresent()){
            TopicProvider t = topicProviderRepository.findById(companyid).get();
            t.setApproved(approve);

            List<Master> all = masterRepository.findAll();
            Notification not = null;
            for (Master m : all){
                if (Objects.equals(m.getId(), masterid)) {
                    if (!m.getNotification_list().isEmpty() && m.getNotification_list() != null){
                        for (Notification n : m.getNotification_list()){
                            if (Objects.equals(n.getObject_id(), companyid) && n.getObject_name() == NotificationObjectSort.COMPANY){
                                not = n;
                            }
                        }
                        m.getNotification_list().remove(not);
                        masterRepository.save(m);
                    }
                }
            }
            topicProviderRepository.save(t);
        }else {
            throw new IdNotFoundRequestException("Id " + masterid + "niet gevonden");
        }
    }
}
