package com.example.demo.service;

import com.example.demo.mapper.RatePlanMapper;
import com.example.demo.model.Rateplans;
import com.example.demo.repository.RatePlansRepository;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;
import java.util.List;

@Service
public class MigrateService {

    private static RestClientService restClientService;
    private static RatePlansRepository ratePlansRepository;

    public MigrateService(RestClientService restClientService, RatePlansRepository ratePlansRepository) {
        this.restClientService = restClientService;
        this.ratePlansRepository = ratePlansRepository;
    }

    public List<Rateplans> findAllandMigrate() throws URISyntaxException {
        List<Rateplans> ratePlans = RatePlanMapper.MAPPER.toDoToratePlans(restClientService.findAllRatePlans());
        if (!ratePlans.isEmpty()) {
            ratePlansRepository.saveAll(ratePlans);
            return ratePlans;
        }
        return null;
    }

    public List<Rateplans> findAll() throws URISyntaxException {
        List<Rateplans> ratePlans = RatePlanMapper.MAPPER.toDoToratePlans(restClientService.findAllRatePlans());
        if (!ratePlans.isEmpty()) {
            ratePlansRepository.saveAll(ratePlans);
            return ratePlans;
        }
        return null;
    }


}
