package com.example.project.student;

import com.example.project.master.MasterRepository;
import com.example.project.appuser.AppUserRepository;
import com.example.project.exceptions.IdNotFoundRequestException;
import com.example.project.exceptions.NietApprovedRequestException;
import com.example.project.targetAudience.TargetAudience;
import com.example.project.topic.Topic;
import com.example.project.topic.TopicRepository;
import com.example.project.topic.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {


    @Autowired
    private MasterRepository masterRepository;
    @Autowired
    private Topic_choiceRepository topic_choiceRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private TopicService topicService;

    public List<Student> findAllStudents() { return studentRepository.findAll();}

    public boolean findBoolPreferredTopicByID(long id, long topicid) {
        List<Student> all = studentRepository.findAll();
        for(Student s: all){
            if(Objects.equals(s.getId(), id)){
                topicRepository.getById(topicid);
                if (s.getPreferredTopics().contains(topicRepository.getById(topicid)))
                    return true;
            }
        }
        return false;
    }

    public boolean findBoolPreferredTopicByName(long id, String topicname) {
        List<Student> all = studentRepository.findAll();
        for(Student s: all){
            if(Objects.equals(s.getId(), id)){
                if (s.getPreferredTopics().contains(topicService.getTopicByString(topicname)))
                    return true;
            }
        }
        return false;
    }

    public void setPreferrence(Long id, Long topicid) throws NietApprovedRequestException, IdNotFoundRequestException {
        System.out.println("Student id: " + id + " and topicid: " + topicid);
        Topic t = topicService.getTopic(topicid);
        for(Student s: studentRepository.findAll()){
            if(Objects.equals(s.getId(), id)){
                System.out.println("Student found: " + s);
                System.out.println("Student contains: " + topicid + " = " + s.getPreferredTopics().contains(t));
                if (s.getPreferredTopics().contains(t)) {
                    s.getPreferredTopics().remove(t);
                    System.out.println("Remove topicid: " + t.toString());
                }
                else {
                    s.getPreferredTopics().add(t);
                    System.out.println("Add topicid: " + t.toString());
                }
                studentRepository.save(s);
//                System.out.println("Student contains: " + t.toString() + " = " + s.getPreferredTopics().contains(t));
//                if (preferred && !s.getPreferredTopics().contains(t)) {
//                    s.getPreferredTopics().add(t);
//                    System.out.println("Add topicid: " + t.toString());
//                }
//                else {
//                    s.getPreferredTopics().remove(t);
//                    System.out.println("Remove topicid: " + t.toString());
//                    System.out.println("Student without topic: " + s);
//
//                }
            }
        }
        if (studentRepository.count() == 0) System.out.println("No students");
    }

    public List<Topic> findAllPreferredTopics(long id) {
        for(Student s: studentRepository.findAll()){
            if(Objects.equals(s.getId(), id)){
                return s.getPreferredTopics();
            }
        }
        return null;
    }

    public Student setTop3(Long id, Topic topic1, Topic topic2, Topic topic3) {
        Optional<Student> s = studentRepository.findById(id);
        List<Topic_choice> opTeSlaan = new ArrayList<>();
        if(s.isPresent()){
            if (s.get().getChoices().size()>0){
                s.get().getChoices().get(0).setTopic(topic1);
                s.get().getChoices().get(1).setTopic(topic2);
                s.get().getChoices().get(2).setTopic(topic3);
            }
            else{
                Topic_choice t1  = new Topic_choice(s.get(), topic1, 1);
                Topic_choice t2 = new Topic_choice(s.get(), topic2, 2);
                Topic_choice t3 = new Topic_choice(s.get(), topic3, 3);
                opTeSlaan.add(t1);
                opTeSlaan.add(t2);
                opTeSlaan.add(t3);
            }

        }
        studentRepository.saveAndFlush(s.get());
        topic_choiceRepository.saveAllAndFlush(opTeSlaan);
        return s.get();
    }

    public List<Topic> getTop3(long id) {
        List<Topic> top3 = new ArrayList<>(3);
        if(studentRepository.findById(id).isPresent()) {
            Optional<Student> s = studentRepository.findById(id);
            List<Topic_choice> jeWeetZelf = topic_choiceRepository.findAllByStudent(s.get());
            if (!jeWeetZelf.isEmpty()){
                do{
                    for (int i = 0; i < jeWeetZelf.size(); i++){
                        if(jeWeetZelf.get(i).getChoice() == 1 && top3.size() == 0){
                            top3.add(jeWeetZelf.get(i).getTopic());
                        }else if(jeWeetZelf.get(i).getChoice() == 2 && top3.size() == 1){
                            top3.add(jeWeetZelf.get(i).getTopic());
                        }else if(jeWeetZelf.get(i).getChoice() == 3 && top3.size() == 2){
                            top3.add(jeWeetZelf.get(i).getTopic());
                        }
                    }
                }while (top3.size() != 3);
            }
        }
        return top3;
    }

    public Optional<Student> findStudent(long id) {
        return studentRepository.findById(id);
    }

    public List<Student> findAllNotHidedStudents() {
        List<Student> all = studentRepository.findAll();
        List<Student> returnStu = new ArrayList<>();

        for(Student s: all){
            if(!s.getHide()){
                returnStu.add(s);
            }
        }
        return returnStu;
    }

    public int isPresentInTop3(Long topic_id, Student s) {
        List<Topic_choice> choices = topic_choiceRepository.findAllByStudent(s);
        int contains = 0;
        for (Topic_choice topic_choice : choices){
            if(topic_choice.getTopic().getTopic_id() == topic_id){
                contains = topic_choice.getChoice();
            }
        }
        return contains;
    }

    public List<Student> findAllNotHidedMasterproefIDStudents(long id, long topicid) throws IdNotFoundRequestException {
        if(masterRepository.findById(id).isPresent()){
            List<Student> studenten = studentRepository.findAllByMaster(masterRepository.findById(id).get());
            List<Student> returnStu = new ArrayList<>();
            if(topicRepository.findById(topicid).isPresent()){
                Topic t = topicRepository.findById(topicid).get();
                for(Student s: studenten){
                    if(!s.getHide() && !s.getAssignedTopic()){
                        if(isPresentInTop3(topicid,s) > 0 && isTargetaudience(topicid,s)){
                            returnStu.add(s);
                        }
                    }
                }
                return returnStu;
            }else {
                throw new IdNotFoundRequestException("id niet gevonden");
            }
        }else{
            throw new IdNotFoundRequestException("Masterid niet gevonden");
        }
    }

    private boolean isTargetaudience(long topicid, Student s) {
        Topic t = topicRepository.findById(topicid).get();
        List<TargetAudience> topicsTarget = t.getTargetAudiences();
        List<TargetAudience> studentsTarget = s.getTargetAudience();
        boolean gelijken = false;
        for (TargetAudience target : topicsTarget){
            if(studentsTarget.contains(target)) {gelijken =true;}
        }
        return gelijken;
    }

    public List<Student> findAllChoice3TopicStudenten(long topicid) throws IdNotFoundRequestException {
        if(topicRepository.findById(topicid).isPresent()){
            Topic t = topicRepository.findById(topicid).get();
            if(t.getApproved_topic() && !t.getHide_topic()){
                List<Student> studenten = new ArrayList<>();
                List<Student> all = studentRepository.findAll();
                for (Student s: all){
                    if(!s.getHide() && !s.getAssignedTopic() && isTargetaudience(topicid,s)){
                        if(isPresentInTop3(topicid,s)>0){
                            studenten.add(s);
                        }
                    }
                }
                return studenten;
            }
        }else throw new IdNotFoundRequestException("TopicId is niet present");
        return null;
    }
}
