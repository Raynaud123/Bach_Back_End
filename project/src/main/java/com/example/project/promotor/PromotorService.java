package com.example.project.promotor;

import com.example.project.exceptions.IdNotFoundRequestException;
import com.example.project.student.Student;
import com.example.project.student.StudentRepository;
import com.example.project.targetAudience.TargetAudience;
import com.example.project.topic.Topic;
import com.example.project.topic.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PromotorService {

    private PromotorRepository promotorRepository;
    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private StudentRepository studentRepository;

    public PromotorService(PromotorRepository promotorRepository) { this.promotorRepository = promotorRepository; }

//    public List<Promotor> findAllPromotors() { return promotorRepository.findAll(); }

    public List<Promotor> findPromotorsWithTopic() {
        List<Promotor> all = promotorRepository.findAll();
        ArrayList<Promotor> pwt = new ArrayList<>();

        for(Promotor p: all){
            if(p.isApproved() && p.getTopic() != null){
                pwt.add(p);
            }
        }
        return pwt;
    }

    public Promotor findById(Long id) {
        List<Promotor> all = promotorRepository.findAll();
        for(Promotor p: all){
            if(Objects.equals(p.getId(), id))
                return p;
        }
        return null;
    }

    public List<Promotor> findAllPromotors() { return promotorRepository.findAll(); }

    public Optional<Promotor> findByIdFromFrontend(Long id) {
        return promotorRepository.findById(id);
    }

    public List<Promotor> findTargetPromotors(long topicid) throws IdNotFoundRequestException {
        List<Promotor> promotors = new ArrayList<Promotor>();
        if(topicRepository.findById(topicid).isPresent()){
            Topic t = topicRepository.findById(topicid).get();

            List<Promotor> prom = promotorRepository.findAll();
            for(Promotor pr: prom){
                if(pr.isApproved() && !pr.getHide()){
                    if(containsTarget(pr,t)){
                        promotors.add(pr);
                    }
                }
            }
            return promotors;
        }
        else throw new IdNotFoundRequestException("Id van topic niet gevonden");
    }


    public boolean containsTarget(Promotor pr,Topic t){
        List<TargetAudience> topicsTarget = t.getTargetAudiences();
        List<TargetAudience> promTarget = pr.getTargetAudience();
        boolean gelijken=false;
        for (TargetAudience target : topicsTarget){
            if(promTarget.contains(target)) {gelijken =true;
            break;}
        }
        return gelijken;
    }

    public List<Promotor> findTargetPromotorsStudent(long id) throws IdNotFoundRequestException {
        List<Promotor> promotors = new ArrayList<Promotor>();
        if(studentRepository.findById(id).isPresent()){
            Student t = studentRepository.findById(id).get();

            List<Promotor> prom = promotorRepository.findAll();
            for(Promotor pr: prom){
                if(pr.isApproved() && !pr.getHide()){
                    if(containsTargetStudent(pr,t)){
                        promotors.add(pr);
                    }
                }
            }
            return promotors;
        }
        else throw new IdNotFoundRequestException("Id van topic niet gevonden");
    }

    private boolean containsTargetStudent(Promotor pr, Student t) {
        List<TargetAudience> studentsTarget = t.getTargetAudience();
        List<TargetAudience> promTarget = pr.getTargetAudience();
        boolean gelijken=false;
        for (TargetAudience target : studentsTarget){
            if(promTarget.contains(target)) {gelijken =true;
                break;}
        }
        return gelijken;
    }
}
