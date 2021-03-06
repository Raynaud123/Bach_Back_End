package com.example.project.master;

import com.example.project.appuser.AppUser;
import com.example.project.appuser.AppUserRepository;
import com.example.project.exceptions.IdNotFoundRequestException;
import com.example.project.notification.Notification;
import com.example.project.notification.NotificationObjectSort;
import com.example.project.notification.NotificationRepository;
import com.example.project.notification.NotificationSort;
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
    @Autowired
    private NotificationRepository notificationRepository;


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
            addApprovedTopicNotificationProvider(appUserRepository.getById(t.getProvider()), approve, topicid);
        }else {
            throw new IdNotFoundRequestException("Id " + topicid + "niet gevonden");
        }
    }

    public void approvePromotorById(Long masterid, Long promotorid, Boolean approve) throws IdNotFoundRequestException {
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
            addApprovedNotificationPromotor(p, approve);
            promotorRepository.save(p);
        }else {
            throw new IdNotFoundRequestException("Id " + promotorid + "niet gevonden");
        }
    }

    private void addApprovedNotificationPromotor(Promotor p, Boolean approve) {
        NotificationSort ns;
        if (approve)
            ns = NotificationSort.APPROVED;
        else
            ns = NotificationSort.NOTAPPROVED;
        Notification n = new Notification(ns, NotificationObjectSort.PROMOTOR, p.getId(), new Date());
        notificationRepository.save(n);
        p.getNotification_list().add(n);
    }
    private void addApprovedNotificationTopicProvider(TopicProvider tp, Boolean approve) {
        NotificationSort ns;
        if (approve)
            ns = NotificationSort.APPROVED;
        else
            ns = NotificationSort.NOTAPPROVED;
        Notification n = new Notification(ns, NotificationObjectSort.COMPANY, tp.getId(), new Date());
        notificationRepository.save(n);
        tp.getNotification_list().add(n);
    }
    private void addApprovedTopicNotificationProvider(AppUser a, Boolean approve, Long topicid) {
        NotificationSort ns;
        if (approve)
            ns = NotificationSort.APPROVED;
        else
            ns = NotificationSort.NOTAPPROVED;
        Notification n = new Notification(ns, NotificationObjectSort.TOPIC, topicid, new Date());
        notificationRepository.save(n);
        a.getNotification_list().add(n);
        appUserRepository.save(a);
    }

    public void approveCompanyById(Long masterid, Long companyid, Boolean approve) throws IdNotFoundRequestException {
        System.out.println(masterid);
        System.out.println(masterid);
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
            addApprovedNotificationTopicProvider(t, approve);
            topicProviderRepository.save(t);
        }else {
            throw new IdNotFoundRequestException("Id " + masterid + "niet gevonden");
        }
    }

    public void testFunctie(int lll){
        System.out.println("kqjkdfjjqfdjmqd");
    }

}
