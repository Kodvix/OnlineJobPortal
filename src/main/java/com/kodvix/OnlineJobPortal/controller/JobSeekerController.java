package com.kodvix.OnlineJobPortal.controller;

import com.kodvix.OnlineJobPortal.dto.JobSeekerDto;
import com.kodvix.OnlineJobPortal.entity.JobSeeker;
import com.kodvix.OnlineJobPortal.service.JobSeekerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jobSeeker")
public class JobSeekerController {

    @Autowired
    JobSeekerService jobSeekerService;

    @PostMapping("/save")
    public ResponseEntity<JobSeeker> save(@Valid @RequestBody JobSeekerDto jobSeekerDto) {
        JobSeeker saved = jobSeekerService.save(jobSeekerDto);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Object> get(@PathVariable Long id, @RequestBody JobSeekerDto jobSeekerDto) {
        JobSeeker got = jobSeekerService.getById(id);
        return ResponseEntity.ok(got);
    }

    @GetMapping("/getAll")
    public ResponseEntity<Object> getAll() {
        //JobSeeker jobSeeker = jobSeekerService.getById();
        return new ResponseEntity<>(jobSeekerService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        jobSeekerService.deleteById(id);
        return new ResponseEntity<>("Deleted succesfully", HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @Valid @RequestBody JobSeekerDto jobSeekerDto) {
        jobSeekerService.updateById(id, jobSeekerDto);
        return new ResponseEntity<>("Updated JobSeeker Successfully", HttpStatus.OK);
    }

}
