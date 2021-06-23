package com.loctp.phr_system.service;

import com.loctp.phr_system.dto.RatingResponse;
import com.loctp.phr_system.model.Rating;
import com.loctp.phr_system.repository.IRatingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RatingService implements IRatingService {


    @Autowired
    private IRatingRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public List<RatingResponse> getRatingList() {
        List<Rating> rs = repository.findAll();
        List<String> clinicNamels = new ArrayList<>();

        for (Rating rating : rs
        ) {
            String clinicName = rating.getExamination().getTestRequest().getDoctor().getClinic().getName();
            clinicNamels.add(clinicName);
        }

        List<RatingResponse> ratingResponses = rs
                .stream()
                .map(rating -> mapper.map(rating, RatingResponse.class))
                .collect(Collectors.toList());

        int index = 0;
        for (RatingResponse ratingResponse : ratingResponses
        ) {
            ratingResponse.setClinicName(clinicNamels.get(index));
            index++;
        }

        return ratingResponses;

    }
}
