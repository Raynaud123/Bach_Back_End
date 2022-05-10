package com.example.project.admin;

import com.example.project.keyword.Keyword;
import com.example.project.keyword.KeywordRepository;
import com.example.project.master.MasterRepository;
import com.example.project.phase.Phase;
import com.example.project.phase.PhaseRepository;
import com.example.project.promotor.Promotor;
import com.example.project.promotor.PromotorRepository;
import com.example.project.student.Student;
import com.example.project.student.StudentRepository;
import com.example.project.targetAudience.TargetAudience;
import com.example.project.targetAudience.TargetAudienceRepository;
import com.example.project.topicprovider.TopicProvider;
import com.example.project.topicprovider.TopicProviderRepository;
import com.sun.tools.jconsole.JConsoleContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class AdminService {

    @Autowired
    private AdminRepository repository;
    @Autowired
    private TopicProviderRepository topicProviderRepository;
    @Autowired
    private PhaseRepository phaseRepository;
    @Autowired
    private TargetAudienceRepository targetAudienceRepository;
    @Autowired
    private PromotorRepository promotorRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private KeywordRepository keywordRepository;
    @Autowired
    private MasterRepository masterRepository;

    public List<TopicProvider> findAllTopicProviders() {
        return topicProviderRepository.findAll();
    }

    public List<TopicProvider> findAllApprovedTopicProviders() {

        List<TopicProvider> appr = new ArrayList<>();
        List<TopicProvider> all = topicProviderRepository.findAll();

        for(TopicProvider top: all){
            if(top.isApproved()){
                appr.add(top);
            }
        }
        return appr;
    }

    public List<Phase> getAllPhases() {
        return phaseRepository.findAll();
    }

    public void updatePhase(long id, Map<String,String> test) throws ParseException {
        Optional<Phase> faseResponse = phaseRepository.findById(id);

        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

        java.util.Date bDate = format.parse(test.get("test"));
        java.util.Date eDate = format.parse(test.get("eindDatum"));


        if(faseResponse.isPresent()){
            Phase fase = faseResponse.get();
            fase.setBegin_deadline(bDate);
            fase.setEnd_deadline(eDate);
            phaseRepository.save(fase);
        }else {
            throw new IllegalStateException();
        }
    }

    public List<TargetAudience> findAllTargetAudience() {
        return targetAudienceRepository.findAll();
    }

    public List<Promotor> findAllPromotors() { return promotorRepository.findAll(); }

    public void updatePhaseWithBody(long pid, Phase phaseBody) {
        System.out.print("Phasebody: name:" + phaseBody.getPhase_name()
                + " round: " + phaseBody.getFirstRound()
                + " end_deadline: " + phaseBody.getEnd_deadline()
                + " begin_deadline: " + phaseBody.getBegin_deadline()
                + " hide: " + phaseBody.getHide());
        if(phaseRepository.findById(pid).isPresent()){
            Phase fase = phaseRepository.findById(pid).get();
            if(!Objects.equals(phaseBody.getPhase_name(), "")){
                System.out.println(fase.getPhase_name() + " en " + phaseBody.getPhase_name());
                fase.setPhase_name(phaseBody.getPhase_name());
            }
            if(!Objects.equals(phaseBody.getFirstRound(), null)){
                System.out.println(fase.getFirstRound() + " en " + phaseBody.getFirstRound());
                fase.setFirstRound(phaseBody.getFirstRound());
            }
            if(!Objects.equals(phaseBody.getBegin_deadline(), "") && !Objects.equals(phaseBody.getEnd_deadline(), null)){
                phaseBody.getEnd_deadline().setHours(23);
                phaseBody.getEnd_deadline().setMinutes(55);
                phaseBody.getEnd_deadline().setSeconds(55);
                System.out.println(fase.getBegin_deadline() + " en " + phaseBody.getBegin_deadline());
                fase.setBegin_deadline(phaseBody.getBegin_deadline());
            }
            if(!Objects.equals(phaseBody.getEnd_deadline(), "") && !Objects.equals(phaseBody.getEnd_deadline(), null)){
                phaseBody.getEnd_deadline().setHours(23);
                phaseBody.getEnd_deadline().setMinutes(55);
                phaseBody.getEnd_deadline().setSeconds(55);
                System.out.println(fase.getEnd_deadline() + " en " + phaseBody.getEnd_deadline());
                fase.setEnd_deadline(phaseBody.getEnd_deadline());
                System.out.println(fase.getEnd_deadline() + " en " + phaseBody.getEnd_deadline());
            }
            if(!Objects.equals(phaseBody.getHide(), null)){
                System.out.println(fase.getHide() + " en " + phaseBody.getHide());
                fase.setHide(phaseBody.getHide());
            }
            phaseRepository.save(fase);
        }else {
            throw new IllegalStateException();
        }
    }

    public void createPhase(Phase phaseBody) {
        System.out.print("Phasebody: name:" + phaseBody.getPhase_name()
                + " round: " + phaseBody.getFirstRound()
                + " end_deadline: " + phaseBody.getEnd_deadline()
                + " begin_deadline: " + phaseBody.getBegin_deadline()
                + " hide: " + phaseBody.getHide());
        Phase fase = new Phase(
                phaseBody.getPhase_name(),
                phaseBody.getBegin_deadline(),
                phaseBody.getEnd_deadline(),
                phaseBody.getFirstRound(),
                phaseBody.getHide()
        );
        phaseRepository.save(fase);
    }

    public void deletePhase(Phase f) {
        phaseRepository.delete(f);
    }

    public Optional<Admin> findAdmin(long id) {
        return repository.findById(id);
    }

    public void createTargetAudience(TargetAudience taBody) {
        System.out.print("taBody: getCampus_name:" + taBody.getCampus().getCampus_name()
                + " getCity: " + taBody.getCampus().getCity()
                + " getCountry: " + taBody.getCampus().getCountry()
                + " getPostNumber: " + taBody.getCampus().getPostNumber()
                + " getStreetName: " + taBody.getCampus().getStreetName()
                + " getStreetNumber: " + taBody.getCampus().getStreetNumber()
                + " getCourse_name: " + taBody.getCourse().getCourse_name()
                + " getAbbriviationName: " + taBody.getCourse().getAbbriviationName()
                + " hide: " + taBody.getHide());
        TargetAudience ta = new TargetAudience(
                taBody.getCampus(),
                taBody.getCourse(),
                taBody.getHide()
        );
        targetAudienceRepository.save(ta);
    }

    public void updateTargetAudienceWithBody(long taid, TargetAudience taBody) {
        System.out.print("taBody: getCampus_name:" + taBody.getCampus().getCampus_name()
                + " getCity: " + taBody.getCampus().getCity()
                + " getCountry: " + taBody.getCampus().getCountry()
                + " getPostNumber: " + taBody.getCampus().getPostNumber()
                + " getStreetName: " + taBody.getCampus().getStreetName()
                + " getStreetNumber: " + taBody.getCampus().getStreetNumber()
                + " getCourse_name: " + taBody.getCourse().getCourse_name()
                + " getAbbriviationName: " + taBody.getCourse().getAbbriviationName()
                + " hide: " + taBody.getHide());
        if(targetAudienceRepository.findById(taid).isPresent()){
            TargetAudience ta = targetAudienceRepository.findById(taid).get();
            if(!Objects.equals(taBody.getCampus().getCampus_name(), "")){
                System.out.println(ta.getCampus().getCampus_name() + " en " + taBody.getCampus().getCampus_name());
                ta.getCampus().setCampus_name(taBody.getCampus().getCampus_name());
            }
            if(!Objects.equals(taBody.getCampus().getCountry(), "")){
                System.out.println(ta.getCampus().getCountry() + " en " + taBody.getCampus().getCountry());
                ta.getCampus().setCountry(taBody.getCampus().getCountry());
            }
            if(!Objects.equals(taBody.getCampus().getCity(), "")){
                System.out.println(ta.getCampus().getCity() + " en " + taBody.getCampus().getCity());
                ta.getCampus().setCity(taBody.getCampus().getCity());
            }
            if(!Objects.equals(taBody.getCampus().getStreetName(), "")){
                System.out.println(ta.getCampus().getStreetName() + " en " + taBody.getCampus().getStreetName());
                ta.getCampus().setStreetName(taBody.getCampus().getStreetName());
            }
            if(!Objects.equals(taBody.getCourse().getCourse_name(), "")){
                System.out.println(ta.getCourse().getCourse_name() + " en " + taBody.getCourse().getCourse_name());
                ta.getCourse().setCourse_name(taBody.getCourse().getCourse_name());
            }
            if(!Objects.equals(taBody.getCourse().getAbbriviationName(), "")){
                System.out.println(ta.getCourse().getAbbriviationName() + " en " + taBody.getCourse().getAbbriviationName());
                ta.getCourse().setAbbriviationName(taBody.getCourse().getAbbriviationName());
            }
            if(!Objects.equals(taBody.getCampus().getPostNumber(), -1)){
                System.out.println(ta.getCampus().getPostNumber() + " en " + taBody.getCampus().getPostNumber());
                ta.getCampus().setPostNumber(taBody.getCampus().getPostNumber());
            }
            if(!Objects.equals(taBody.getCampus().getStreetNumber(), -1)){
                System.out.println(ta.getCampus().getStreetNumber() + " en " + taBody.getCampus().getStreetNumber());
                ta.getCampus().setStreetNumber(taBody.getCampus().getStreetNumber());
            }
            if(!Objects.equals(taBody.getHide(), null)){
                System.out.println(ta.getHide() + " en " + taBody.getHide());
                ta.setHide(taBody.getHide());
            }
            targetAudienceRepository.save(ta);
        }else {
            throw new IllegalStateException();
        }
    }

    public void deleteTargetAudience(TargetAudience ta) {
        targetAudienceRepository.delete(ta);
    }

    public void createKeyword(Keyword kBody) {
        Keyword k = new Keyword(
                kBody.getKeyword_name(),
                kBody.getHide()
        );
        keywordRepository.save(k);
    }

    public void updateKeywordWithBody(long kid, Keyword keywordBody) {
        if(keywordRepository.findById(kid).isPresent()){
            Keyword k = keywordRepository.findById(kid).get();
            if(!Objects.equals(keywordBody.getKeyword_name(), "")){
                k.setKeyword_name(keywordBody.getKeyword_name());
            }
            if(!Objects.equals(keywordBody.getHide(), null)){
                k.setHide(keywordBody.getHide());
            }
            keywordRepository.save(k);
        }else {
            throw new IllegalStateException();
        }
    }

    public void deleteKeyword(Keyword k) {
        keywordRepository.delete(k);
    }
}
