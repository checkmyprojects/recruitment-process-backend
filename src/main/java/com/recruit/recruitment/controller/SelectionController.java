package com.recruit.recruitment.controller;

import com.recruit.recruitment.models.AppUser;
import com.recruit.recruitment.models.Selection;
import com.recruit.recruitment.service.AppUserService;
import com.recruit.recruitment.service.SelectionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

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
    ResponseEntity<Selection> editSelection(@RequestBody Selection selection){

        if(selection.getCreated_by().getId() == null){
            System.out.println("Error with Selection Process AppUser ID");
            return ResponseEntity.badRequest().body(selection);
        }else{
            AppUser creator = appUserService.findById(selection.getCreated_by().getId());
            URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/selection/edit").toUriString());
            System.out.println("Updating selection with ID: " + selection.getId());
            selection.setCreated_by(creator);
            return ResponseEntity.created(uri).body(selectionService.save(selection));
        }

    }
    /*
    @PutMapping("/edit")
    ResponseEntity<Selection> editSelection(@RequestBody Selection selection){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/selection/edit").toUriString());
        System.out.println("Updating selection with ID: " + selection.getId());
        return ResponseEntity.created(uri).body(selectionService.save(selection));
    }

     */

    @DeleteMapping("/delete/{id}")
    ResponseEntity<Void> deleteSelectionById(@PathVariable Long id){
        System.out.println("Deleting Selection Process with ID: " + id);
        selectionService.deleteSelectionById(id);
        return ResponseEntity.noContent().build();
    }

}
