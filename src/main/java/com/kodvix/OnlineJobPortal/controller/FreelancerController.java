package com.kodvix.OnlineJobPortal.controller;

import com.kodvix.OnlineJobPortal.dto.FreelancerDto;
import com.kodvix.OnlineJobPortal.entity.Freelancer;
import com.kodvix.OnlineJobPortal.service.FreelancerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/freelancers")
public class FreelancerController {

    @Autowired
    FreelancerService freelancerService;

    @PostMapping("/save")
    public ResponseEntity<Freelancer> save(@RequestBody FreelancerDto freelancerDto) {
        Freelancer saved = freelancerService.save(freelancerDto);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Object> get(@PathVariable Long id, @RequestBody FreelancerDto freelancerDto) {
        Freelancer freelancer = freelancerService.getById(id);
        return ResponseEntity.ok(freelancer);
    }

    @GetMapping("/getAll")
    public ResponseEntity<Object> getAll() {
        //Freelancer freelancer = freelancerService.getById();
        return new ResponseEntity<>(freelancerService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        freelancerService.deleteById(id);
        return new ResponseEntity<>("Deleted succesfully", HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody FreelancerDto freelancerDto) {
        freelancerService.updateById(id, freelancerDto);
        return new ResponseEntity<>("Updated Freelancer Successfully", HttpStatus.OK);
    }

}
