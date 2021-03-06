package com.example.project.student;

import com.example.project.exceptions.IdNotFoundRequestException;
import com.example.project.exceptions.NietApprovedRequestException;
import com.example.project.topic.BoostStudentRequest;
import com.example.project.topic.Topic;
import com.example.project.topic.TopicService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
//import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@ResponseBody
//@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "student")
@AllArgsConstructor
public class StudentController {

    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TopicService topicService;


//    @CrossOrigin(origins = "http://localhost:3000")
//    @GetMapping(path = "/preferred")
//    public List<Topic> getPreferredTopics() { return studentService.findPreferredTopics(); }

    @GetMapping(path = "/topics/{id}")
    public List<Topic> getTopicsById(@PathVariable long id) {
        return topicService.findById(id);
    }

    @GetMapping(path = "/{id}")
    public Optional<Student> getStudentById(@PathVariable long id) {
        return studentService.findStudent(id);
    }

    @GetMapping(path = "/all")
    public List<Student> getAllStudents() {
        return studentService.findAllStudents();
    }

    @GetMapping(path = "/hided/all")
    public List<Student> getAllNotHidedStudents() {
        return studentService.findAllNotHidedStudents();
    }

    @GetMapping(path = "/hided/{id}/{topicid}")
    public List<Student> getAllNotHidedMasterProefIdStudents(@PathVariable long id, @PathVariable long topicid) throws IdNotFoundRequestException {
     return studentService.findAllNotHidedMasterproefIDStudents(id,topicid);
    }

    @GetMapping(path = "/hided/boost/{topicid}")
    public List<Student> getAllChoice3TopicStudenten(@PathVariable long topicid) throws IdNotFoundRequestException {
        return studentService.findAllChoice3TopicStudenten(topicid);
    }

    @GetMapping(path = "/{id}/preferred/all")
    public List<Topic> getAllPreferredTopics(@PathVariable long id) {
        return studentService.findAllPreferredTopics(id);
    }

    @GetMapping(path = "/{id}/preferred/{topicid}")
    public boolean getBoolPreferredTopic(@PathVariable long id, @PathVariable long topicid) {
        return studentService.findBoolPreferredTopicByID(id, topicid);
    }

    @GetMapping(path = "/{id}/top3")
    public List<Topic> getTop3(@PathVariable long id) {
        return studentService.getTop3(id);
    }

    @PutMapping(path = "/{id}/submitpreferrencetopic/{topicid}")
    public void setPreferenceTopic(@PathVariable Long id, @PathVariable Long topicid) throws NietApprovedRequestException, IdNotFoundRequestException { studentService.setPreferrence(id, topicid);
    }

    @PutMapping(path = "/{id}/updatetop3/{topic1id}/{topic2id}/{topic3id}")
    public void setTop3(@PathVariable Long id, @PathVariable Long topic1id, @PathVariable Long topic2id, @PathVariable Long topic3id) throws NietApprovedRequestException, IdNotFoundRequestException {
        studentService.setTop3(id, topicService.getTopic(topic1id),topicService.getTopic(topic2id),topicService.getTopic(topic3id));
    }
//    @GetMapping("/topics/{topic_id}")
//    public List<Student> allStudents(@PathVariable int topic_id){
//        return studentService.getStudents(topic_id);
//    }
}
