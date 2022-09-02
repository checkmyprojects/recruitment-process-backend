package com.recruit.recruitment.controller;

import com.recruit.recruitment.models.AppUser;
import com.recruit.recruitment.models.Candidate;
import com.recruit.recruitment.models.Interview;
import com.recruit.recruitment.models.Selection;
import com.recruit.recruitment.payload.request.InterviewRequest;
import com.recruit.recruitment.security.MailSender;
import com.recruit.recruitment.service.AppUserService;
import com.recruit.recruitment.service.CandidateService;
import com.recruit.recruitment.service.InterviewService;
import com.recruit.recruitment.service.SelectionService;
import javax.mail.MessagingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/interview")
@RestController
public class InterviewController {

    private final InterviewService interviewService;

    private final AppUserService appUserService;

    private final SelectionService selectionService;

    private final CandidateService candidateService;

    public InterviewController(InterviewService interviewService, AppUserService appUserService, SelectionService selectionService, CandidateService candidateService) {
        this.interviewService = interviewService;
        this.appUserService = appUserService;
        this.selectionService = selectionService;
        this.candidateService = candidateService;
    }

    @GetMapping("/list")
    ResponseEntity<List<Interview>> allList(){
        return ResponseEntity.ok().body(interviewService.listAll());
    }


    @GetMapping("/id/{id}")
    ResponseEntity<Interview> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(interviewService.findById(id));
    }

    @PostMapping("/new")
    ResponseEntity<?> saveInterview(@RequestBody InterviewRequest interviewRequest){
        if(interviewRequest.getCandidateId() == null || interviewRequest.getInterviewerId() == null || interviewRequest.getSelectionId() == null){
            return ResponseEntity.badRequest().body("Missing parameters on url");
        }else{
            URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/interview/new").toUriString());
            System.out.println("Interviewer ID: " + interviewRequest.getInterviewerId() + ", Selection ID: " + interviewRequest.getSelectionId() + ", Candidate ID: " + interviewRequest.getCandidateId());

            AppUser interviewer = appUserService.findById(interviewRequest.getInterviewerId());
            Selection selection = selectionService.findById(interviewRequest.getSelectionId());
            Candidate candidate = candidateService.findById(interviewRequest.getCandidateId());

            Interview interview = new Interview();
            interview.setInterviewer(interviewer);
            interview.setCandidate(candidate);
            interview.setSelection(selection);
            interview.setFeedback(interviewRequest.getFeedback());
            interview.setStatus(interviewRequest.getStatus());
            interview.setInterview_date(LocalDateTime.parse(interviewRequest.getDate()));
            interview.setCreation_date(LocalDateTime.now());
            System.out.println("Saving new Interview");
            interviewService.save(interview);
            try {
                MailSender.send("https://us02web.zoom.us/j/87256604237?pwd=YkxyRkcvVGljdDVMTU80ZjdjVWtZUT09", candidate.getEmail(), interview.getSelection().getName(), candidate.getName(), interviewer.getName(), interviewer.getEmail(), interview.getInterview_date().toString(), interview.getSelection().getLocation(), interview.getSelection().isRemote(), interview.getSelection().getDescription());
            } catch (MessagingException e)
            {
                System.out.println(e.getMessage());
                return ResponseEntity.badRequest().body("The email couldn't be sent");
            }
            // Return interview so we add it to the frontend table
            return ResponseEntity.created(uri).body(interviewService.save(interview));
        }
    }

    /*
    @PostMapping("/new")
    ResponseEntity<Interview> saveInterview(@RequestBody Interview interview, @RequestParam (value = "candidateid")Long candidateId, @RequestParam (value = "interviewerid")Long interviewerId, @RequestParam (value = "selectionid")Long selectionId){
        if(candidateId == null || interviewerId == null || selectionId == null){
            return ResponseEntity.badRequest().body(interview);
        }else{
            URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/interview/new").toUriString());
            System.out.println("Interviewer ID: " + interviewerId + ", Selection ID: " + selectionId + ", Candidate ID: " + candidateId);
            AppUser interviewer = appUserService.findById(interviewerId);
            Selection selection = selectionService.findById(selectionId);
            Candidate candidate = candidateService.findById(candidateId);
            interview.setInterviewer(interviewer);
            interview.setCandidate(candidate);
            interview.setSelection(selection);
            System.out.println("Saving new Interview");
            // Should send email to candidate on create
            return ResponseEntity.created(uri).body(interviewService.save(interview));
        }
    }

     */

    /*
    @PostMapping("/new")
    ResponseEntity<Interview> saveInterview(@RequestBody Interview interview){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/interview/new").toUriString());
        System.out.println("Saving new Interview");
        return ResponseEntity.created(uri).body(interviewService.save(interview));
    }
     */

//    @PutMapping("/edit")
//    ResponseEntity<Interview> editInterview(@RequestBody Interview interview){
//        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/interview/edit").toUriString());
//        return ResponseEntity.created(uri).body(interviewService.save(interview));
//    }

    @PutMapping("/edit/{interviewId}")
    ResponseEntity<?> editInterview(@RequestBody InterviewRequest interviewRequest, @PathVariable Long interviewId){
        if(interviewRequest.getCandidateId() == null || interviewRequest.getInterviewerId() == null || interviewRequest.getSelectionId() == null){
            return ResponseEntity.badRequest().body("Missing parameters on url");
        }else{
            URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/interview/edit").toUriString());
            System.out.println("Interviewer ID: " + interviewRequest.getInterviewerId() + ", Selection ID: " + interviewRequest.getSelectionId() + ", Candidate ID: " + interviewRequest.getCandidateId());

            AppUser interviewer = appUserService.findById(interviewRequest.getInterviewerId());
            Selection selection = selectionService.findById(interviewRequest.getSelectionId());
            Candidate candidate = candidateService.findById(interviewRequest.getCandidateId());

            Interview interview = interviewService.findById(interviewId);
            interview.setInterviewer(interviewer);
            interview.setCandidate(candidate);
            interview.setSelection(selection);
            interview.setFeedback(interviewRequest.getFeedback());
            interview.setStatus(interviewRequest.getStatus());
            interview.setInterview_date(LocalDateTime.parse(interviewRequest.getDate()));
            System.out.println("Saving edited Interview");

            // interviewService.save(interview);
//            try {
//                MailSender.send(candidate.getEmail(), interview.getSelection().getName(), candidate.getName(), interviewer.getName(), interviewer.getEmail(), interview.getInterview_date().toString(), interview.getSelection().getLocation(), interview.getSelection().isRemote(), interview.getSelection().getDescription());
//            } catch (MessagingException e)
//            {
//                System.out.println(e.getMessage());
//                return ResponseEntity.badRequest().body("The email couldn't be sent");
//            }
            return ResponseEntity.created(uri).body(interviewService.save(interview));
        }
    }

    // Make @Requestbody not required. If it's not present, textarea on frontend was empty
    @PutMapping("/feedback/{interviewId}")
    ResponseEntity<Interview> leaveFeedback(@RequestBody (required=false) String feedback, @PathVariable Long interviewId){
        if(interviewId == null){
            System.out.println("Interview with ID: " + interviewId + ", not found");
            return ResponseEntity.badRequest().body(new Interview());
        }else{
            // If feedback is null, it means the textarea on the frontend for was empty, so we remove feedback from the interview ( feedback == "" )
            if(feedback == null){
                feedback = "";
            }
            URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/interview/feedback").toUriString());
            System.out.println("Setting feedback for Interview with ID: " + interviewId);
            Interview interview = interviewService.findById(interviewId);
            interview.setFeedback(feedback);
            System.out.println("Saving interview");
            return ResponseEntity.created(uri).body(interviewService.save(interview));
        }
    }

    @PutMapping("/changedate")
    ResponseEntity<String> changeDate(@RequestBody LocalDateTime date, @RequestParam (value = "interviewid")Long interviewId){
        if(interviewId == null){
            System.out.println("Interview with ID: " + interviewId + ", not found");
            return ResponseEntity.badRequest().body("Interview with ID: " + interviewId + ", not found");
        }else{
            System.out.println("Changing date for Interview with ID: " + interviewId);
            Interview interview = interviewService.findById(interviewId);
            interview.setInterview_date(date);
            return ResponseEntity.ok("Date for Interview with ID: " + interviewId + " changed to: " + date);
        }
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<Void> deleteInterviewById(@PathVariable Long id){
        System.out.println("Deleting Interview with ID: " + id);
        interviewService.deleteInterviewById(id);
        // Should send email to candidate on delete
        return ResponseEntity.ok().build();
    }
}
