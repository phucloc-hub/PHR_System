package com.loctp.phr_system.controller;

import com.loctp.phr_system.dto.RatingResponse;
import com.loctp.phr_system.service.IRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    IRatingService ratingService;

    @GetMapping("/ratings")
    public ResponseEntity<List<RatingResponse>> getAll() {
        List<RatingResponse> rs = ratingService.getRatingList();
        return new ResponseEntity<>(rs, HttpStatus.OK);
    }


}
