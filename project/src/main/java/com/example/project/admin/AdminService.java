package com.example.project.admin;

import com.example.project.phase.Phase;
import com.example.project.phase.PhaseRepository;
import com.example.project.promotor.Promotor;
import com.example.project.promotor.PromotorRepository;
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
}
