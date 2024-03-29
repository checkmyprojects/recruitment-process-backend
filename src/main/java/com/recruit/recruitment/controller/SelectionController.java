package com.recruit.recruitment.controller;

import com.recruit.recruitment.models.AppUser;
import com.recruit.recruitment.models.Selection;
import com.recruit.recruitment.payload.response.MessageResponse;
import com.recruit.recruitment.service.AppUserService;
import com.recruit.recruitment.service.SelectionService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/selection")
@RestController
public class SelectionController {

    private final SelectionService selectionService;
    private final AppUserService appUserService;

    public SelectionController(SelectionService selectionService, AppUserService appUserService) {
        this.selectionService = selectionService;
        this.appUserService = appUserService;
    }

    @GetMapping("/list")
    ResponseEntity<List<Selection>> listAll(){
        System.out.println("List All Selection Processes");
        return ResponseEntity.ok().body(selectionService.listAll());
    }


    @PostMapping("/new")
    ResponseEntity<?> saveSelection(@RequestBody Selection selection, Authentication authentication){
        // Ask for frontend authenticated user to make user was sent. If not, throw error
        if(authentication == null){
            return ResponseEntity.badRequest().body(new MessageResponse("Error: User is not logged in"));

            // If we can't find user on the database with authenticated user username, throw error
        }else if(!appUserService.existsByUsername(authentication.getName())){
            return ResponseEntity.badRequest().body(new MessageResponse("Error: logged user not found on the database"));

        }else{
            Optional<AppUser> appUser = appUserService.findByUsername(authentication.getName());
            // If a appUser is found on the database, create the selection
            if(appUser.isPresent()){
                selection.setCreated_by(appUser.get());
                URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/selection/new").toUriString());
                System.out.println("Saving New Selection Process");
                return ResponseEntity.created(uri).body(selectionService.save(selection));

                // If appUser was not found, throw error
            }else{
                return ResponseEntity.badRequest().body(new MessageResponse("Error: logged user not found on the database"));

            }

        }

    }

    /*
    @PostMapping("/new")
    ResponseEntity<Selection> saveSelection(@RequestBody Selection selection, @RequestParam (value = "creatorid")Long creatorId){

        // If creator is not found on DB, send error
        if(appUserService.findById(creatorId) == null){
            System.out.println("Error with Selection Process AppUser ID");
            return ResponseEntity.internalServerError().body(selection);
        }else{
            AppUser creator = appUserService.findById(creatorId);
            selection.setCreated_by(creator);
            URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/selection/new").toUriString());
            System.out.println("Saving New Selection Process");
            return ResponseEntity.created(uri).body(selectionService.save(selection));
        }
    }
     */

    /*
    @PostMapping("/new")
    ResponseEntity<Selection> saveSelection(@RequestBody Selection selection){

        // If created_by ID does not exist, selection is not created
        if(selection.getCreated_by().getId() == null){
            System.out.println("Error with Selection Process AppUser ID");
            return ResponseEntity.internalServerError().body(selection);
        }else{
            AppUser creator = appUserService.findById(selection.getId());
            selection.setCreated_by(creator);
            URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/selection/new").toUriString());
            System.out.println("Saving New Selection Process");
            return ResponseEntity.created(uri).body(selectionService.save(selection));
        }
    }
*/
    @PutMapping("/edit")
    ResponseEntity<?> editSelection(@RequestBody Selection selection){

        if (selection.getId() == null){
            return ResponseEntity.badRequest().body("Missing selection id");
        }else{
            Selection editedSelection = selectionService.findById(selection.getId());
            if(editedSelection == null){
                return ResponseEntity.badRequest().body("Selection process not found");
            }else{
                editedSelection.setCreated_by(selection.getCreated_by());
                editedSelection.setStart_date(selection.getStart_date());
                editedSelection.setEnd_date(selection.getEnd_date());
                editedSelection.setName(selection.getName());
                editedSelection.setDescription(selection.getDescription());
                editedSelection.setRequirements(selection.getRequirements());
                editedSelection.setLocation(selection.getLocation());
                editedSelection.setSector(selection.getSector());
                editedSelection.setStatus(selection.getStatus());
                editedSelection.setPriority(selection.getPriority());
                editedSelection.setProject_id(selection.getProject_id());
                editedSelection.setRemote(selection.isRemote());

                URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/selection/edit").toUriString());
                System.out.println("Updating selection with ID: " + selection.getId());
                return ResponseEntity.created(uri).body(selectionService.save(editedSelection));
            }
        }

    }

//    @PutMapping("/edit")
//    ResponseEntity<Selection> editSelection(@RequestBody Selection selection){
//
//        if(selection.getCreated_by().getId() == null){
//            System.out.println("Error with Selection Process AppUser ID");
//            return ResponseEntity.badRequest().body(selection);
//        }else{
//            AppUser creator = appUserService.findById(selection.getCreated_by().getId());
//            URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/selection/edit").toUriString());
//            System.out.println("Updating selection with ID: " + selection.getId());
//            selection.setCreated_by(creator);
//            return ResponseEntity.created(uri).body(selectionService.save(selection));
//        }
//
//    }
    /*
    @PutMapping("/edit")
    ResponseEntity<Selection> editSelection(@RequestBody Selection selection){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/selection/edit").toUriString());
        System.out.println("Updating selection with ID: " + selection.getId());
        return ResponseEntity.created(uri).body(selectionService.save(selection));
    }

     */

    @GetMapping("/end/{selectionId}")
    ResponseEntity<?> endSelectionById(@PathVariable Long selectionId){

        Selection selection = selectionService.findById(selectionId);
        if(selection == null){
            return ResponseEntity.badRequest().body("Selection process not found");
        }else{
            selection.setEnd_date(new Date());
            selection.setStatus("Cerrado");
            return ResponseEntity.ok().body(selectionService.save(selection));
        }

    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<Void> deleteSelectionById(@PathVariable Long id){
        System.out.println("Deleting Selection Process with ID: " + id);
        selectionService.deleteSelectionById(id);
        return ResponseEntity.noContent().build();
    }

}
