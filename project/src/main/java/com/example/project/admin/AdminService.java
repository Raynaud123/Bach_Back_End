package com.example.project.admin;

import com.example.project.appuser.AppUserRole;
import com.example.project.keyword.Keyword;
import com.example.project.keyword.KeywordRepository;
import com.example.project.master.Master;
import com.example.project.master.MasterRepository;
import com.example.project.notification.Notification;
import com.example.project.notification.NotificationObjectSort;
import com.example.project.notification.NotificationRepository;
import com.example.project.notification.NotificationSort;
import com.example.project.phase.Phase;
import com.example.project.phase.PhaseRepository;
import com.example.project.promotor.Promotor;
import com.example.project.promotor.PromotorRepository;
import com.example.project.student.Student;
import com.example.project.student.StudentRepository;
import com.example.project.student.Topic_choice;
import com.example.project.targetAudience.TargetAudience;
import com.example.project.targetAudience.TargetAudienceRepository;
import com.example.project.topic.Topic;
import com.example.project.topic.TopicRepository;
import com.example.project.topicprovider.TopicProvider;
import com.example.project.topicprovider.TopicProviderRepository;
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
    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private NotificationRepository notificationRepository;

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
            if(!Objects.equals(phaseBody.getBegin_deadline(), null)){
                phaseBody.getBegin_deadline().setHours(0);
                phaseBody.getBegin_deadline().setMinutes(0);
                phaseBody.getBegin_deadline().setSeconds(0);
                System.out.println(fase.getBegin_deadline() + " en " + phaseBody.getBegin_deadline());
                fase.setBegin_deadline(phaseBody.getBegin_deadline());
            }
            if(!Objects.equals(phaseBody.getEnd_deadline(), null)){
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

    public void createTopic(UpdateTopicRequest r) throws ParseException {
        System.out.print(r);
        Topic t = new Topic(
                r.getTopicName(),
                r.getProvider(),
                getPromotor(r.getPromotor()),
                r.getAantal_studenten(),
                getKeywords(r.getKeyword_list()),
                getSudents(r.getStudent_list()),
                getTA(r.getTargetAudiences()),
                r.getApproved_topic(),
                r.getHide_topic(),
                r.getDescription_topic(),
                getDatum(r.getRelease_date())
                //getTopicCoices(r.getTags())
        );
        System.out.print(t);
        topicRepository.save(t);
    }
    public void updateTopicWithBody(long kid, UpdateTopicRequest r) throws ParseException {
        Topic t = topicRepository.findById(kid).get();
        if (!Objects.equals(r.getTopicName(), "")){
            t.setTopicName(r.getTopicName());
        }
        if (r.getProvider() != null && r.getProvider() != -1 ){
            t.setProvider(r.getProvider());
        }
        if (r.getPromotor() != null && r.getPromotor() != -1){
            t.setPromotor(promotorRepository.getById(r.getPromotor()));
        }
        t.setAantal_studenten(r.getAantal_studenten());
        if (r.getKeyword_list() != null){
            t.setKeyword_list(getKeywords(r.getKeyword_list()));
        }
        if (r.getStudent_list() != null){
            t.setStudent_list(getSudents(r.getStudent_list()));
        }
        if (r.getTargetAudiences() != null){
            t.setTargetAudiences(getTA(r.getTargetAudiences()));
        }
        if (r.getApproved_topic() != null){
            t.setApproved_topic(r.getApproved_topic());
        }
        if (r.getHide_topic() != null){
            t.setHide_topic(r.getHide_topic());
        }
        if (!Objects.equals(r.getDescription_topic(), "")){
            t.setDescription_topic(r.getDescription_topic());
        }
        if (!Objects.equals(r.getRelease_date(), "")){
            t.setRelease_date(getDatum(r.getRelease_date()));
        }
        topicRepository.save(t);
    }
    public void deleteTopic(Topic body) {
        topicRepository.delete(body);
    }

    private Promotor getPromotor(Long promotor) {
        if (promotor != -1 || promotor != null){
            return promotorRepository.getById(promotor);
        }
        return null;
    }
    private Date getDatum(String release_date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.parse(release_date);
    }
    private List<TargetAudience> getTA(Long[] targetAudiences) {
        if (targetAudiences.length!=0){
            List<TargetAudience> tas = new ArrayList<>();
            for (int i = 0; i<targetAudiences.length; i++){
                System.out.println(targetAudiences[i]);
                tas.add(targetAudienceRepository.getById(targetAudiences[i]));
            }
            System.out.println(tas);
            return tas;
        }
        return null;
    }
    private List<TargetAudience> getTAOne(TargetAudience ta) {
        if (ta != null){
            List<TargetAudience> tas = new ArrayList<>();
            tas.add(ta);
            return tas;
        }
        return null;
    }
    private List<Student> getSudents(Long[] student_list) {
        if(student_list != null) {
            List<Student> students = new ArrayList<>();
            for (int i = 0; i<student_list.length; i++){
                if (!students.contains(studentRepository.getById(student_list[i])))
                    students.add(studentRepository.getById(student_list[i]));
            }
            return students;
        }
        return null;
    }
    private List<Keyword> getKeywords(Long[] klist) {
        if(klist != null) {
            List<Keyword> keywords = new ArrayList<>();
            for (int i = 0; i < klist.length; i++) {
                keywords.add(keywordRepository.getById(klist[i]));
            }
            return keywords;
        }
        return null;
    }
    private Master getMaster(Long master) {
        if (master != -1 && master != null){
            return masterRepository.getById(master);
        }
        return null;
    }


    public void updateStudentWithBody(long sid, UpdateStudentRequest r) {
        System.out.println(r);
        Student t = studentRepository.findById(sid).get();
        if (!Objects.equals(r.getFirstName(), "")){
            t.setFirstName(r.getFirstName());
        }
        if (!Objects.equals(r.getLastName(), "")){
            t.setLastName(r.getLastName());
        }
        if (r.getTargetAudience() != null){
            t.setTargetAudience(getTA(r.getTargetAudience()));
        }
        if (r.getMaster() != null){
            t.setMaster(getMaster(r.getMaster()));
        }
        if (!Objects.equals(r.getCity(), "")){
            t.setCity(r.getCity());
        }
        if (!Objects.equals(r.getCountry(), "")){
            t.setCountry(r.getCountry());
        }
        if (!Objects.equals(r.getEmail(), "")){
            t.setEmail(r.getEmail());
        }
        if (!Objects.equals(r.getStreetName(), "")){
            t.setStreetName(r.getStreetName());
        }
        if (!Objects.equals(r.getPhoneNumber(), "0")){
            t.setPhoneNumber(r.getPhoneNumber());
        }
        if (!Objects.equals(r.getPostNumber(), 0)){
            t.setPostNumber(r.getPostNumber());
        }
        if (!Objects.equals(r.getStreetNumber(), 0)){
            t.setStreetNumber(r.getStreetNumber());
        }
        studentRepository.save(t);
    }
    public void createStudent(UpdateStudentRequest r) {
        System.out.println(r);
        Student s = new Student(
                r.getFirstName(),
                r.getLastName(),
                r.getStreetName(),
                r.getStreetNumber(),
                r.getPhoneNumber(),
                r.getPostNumber(),
                r.getCountry(),
                r.getCity(),
                r.getEmail(),
                getMaster(r.getMaster()),
                getTA(r.getTargetAudience())
        );
        studentRepository.save(s);
    }
    public void deleteStudent(Student s) {
        System.out.println(s);
        studentRepository.delete(s);
    }

    public void createMaster(UpdateMasterRequest r) {
        System.out.println(r);
        Master m = new Master(
                r.getFirstName(),
                r.getLastName(),
                r.getStreetName(),
                r.getStreetNumber(),
                r.getPhoneNumber(),
                r.getPostNumber(),
                r.getCountry(),
                r.getCity(),
                r.getEmail(),
                getTA(r.getTargetAudience())
        );
        masterRepository.save(m);
    }
    public void updateMasterWithBody(long mid, UpdateMasterRequest r) {
        System.out.println(r);
        Master t = masterRepository.findById(mid).get();
        if (!Objects.equals(r.getFirstName(), "")){
            t.setFirstName(r.getFirstName());
        }
        if (!Objects.equals(r.getLastName(), "")){
            t.setLastName(r.getLastName());
        }
        if (r.getTargetAudience() != null){
            t.setTargetAudience(getTA(r.getTargetAudience()));
        }
        if (!Objects.equals(r.getCity(), "")){
            t.setCity(r.getCity());
        }
        if (!Objects.equals(r.getCountry(), "")){
            t.setCountry(r.getCountry());
        }
        if (!Objects.equals(r.getEmail(), "")){
            t.setEmail(r.getEmail());
        }
        if (!Objects.equals(r.getStreetName(), "")){
            t.setStreetName(r.getStreetName());
        }
        if (!Objects.equals(r.getPhoneNumber(), "0")){
            t.setPhoneNumber(r.getPhoneNumber());
        }
        if (!Objects.equals(r.getPostNumber(), 0)){
            t.setPostNumber(r.getPostNumber());
        }
        if (!Objects.equals(r.getStreetNumber(), 0)){
            t.setStreetNumber(r.getStreetNumber());
        }
        masterRepository.save(t);
    }
    public void deleteMaster(Master m) {
        masterRepository.delete(m);
    }

    public void createPromotor(UpdatePromotorRequest r) {
        System.out.println(r);
        Promotor p = new Promotor(
                r.getFirstName(),
                r.getLastName(),
                r.getStreetName(),
                r.getStreetNumber(),
                r.getPhoneNumber(),
                r.getPostNumber(),
                r.getCountry(),
                r.getCity(),
                r.getEmail(),
                getTA(r.getTargetAudience()),
                r.getApprove()
        );
        promotorRepository.save(p);
    }
    public void updatePromotorWithBody(long pid, UpdatePromotorRequest r) {
        System.out.println(r);
        Promotor t = promotorRepository.findById(pid).get();
        if (!Objects.equals(r.getFirstName(), "")){
            t.setFirstName(r.getFirstName());
        }
        if (!Objects.equals(r.getLastName(), "")){
            t.setLastName(r.getLastName());
        }
        if (r.getTargetAudience() != null){
            t.setTargetAudience(getTA(r.getTargetAudience()));
        }
        if (!Objects.equals(r.getCity(), "")){
            t.setCity(r.getCity());
        }
        if (!Objects.equals(r.getCountry(), "")){
            t.setCountry(r.getCountry());
        }
        if (!Objects.equals(r.getEmail(), "")){
            t.setEmail(r.getEmail());
        }
        if (!Objects.equals(r.getStreetName(), "")){
            t.setStreetName(r.getStreetName());
        }
        if (!Objects.equals(r.getPhoneNumber(), "0")){
            t.setPhoneNumber(r.getPhoneNumber());
        }
        if (!Objects.equals(r.getPostNumber(), 0)){
            t.setPostNumber(r.getPostNumber());
        }
        if (!Objects.equals(r.getStreetNumber(), 0)){
            t.setStreetNumber(r.getStreetNumber());
        }
        if (!Objects.equals(r.getApprove(), null)){
            t.setApproved(r.getApprove());
        }
        promotorRepository.save(t);
    }
    public void deletePromotor(Promotor p) {
        promotorRepository.delete(p);
    }


    public void createProvider(UpdateProviderRequest r) {
        System.out.println(r);
        TopicProvider p = new TopicProvider(
                r.getName(),
                r.getIsCompany(),
                r.getApproved()
        );
        topicProviderRepository.save(p);
    }
    public void updateProviderWithBody(long pid, UpdateProviderRequest r) {
        System.out.println(r);
        TopicProvider t = topicProviderRepository.findById(pid).get();
        if (!Objects.equals(r.getName(), "")){
            t.setName(r.getName());
        }
        if (!Objects.equals(r.getApproved(), null)){
            t.setApproved(r.getApproved());
        }
        if (!Objects.equals(r.getIsCompany(), null)){
            t.setIsCompany(r.getIsCompany());
        }
        topicProviderRepository.save(t);
    }
    public void deleteProvider(TopicProvider body) {
        topicProviderRepository.delete(body);
    }

    public void askHelpFromAdmin(Long masterid) {
        Notification n = new Notification(NotificationSort.HELP, NotificationObjectSort.MASTER, masterid, new Date());
        notificationRepository.save(n);
        for (Admin a : adminRepository.findAll()){
            a.getNotification_list().add(n);
            adminRepository.save(a);
        }
    }
}
