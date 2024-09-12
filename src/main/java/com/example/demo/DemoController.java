package com.example.demo;

import com.example.demo.crystobol.entity.ServiceRequest;
import com.example.demo.crystobol.repository.ServiceRequestRepository;
import com.example.demo.map.entity.Partner;
import com.example.demo.map.repository.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoController {
    @Autowired
    ServiceRequestRepository serviceRequestRepository;

    @Autowired
    PartnerRepository partnerRepository;

    @Autowired
    CrudTestRepo crudTestRepo;

    @GetMapping("/crystobol")
    public void testData(){
        List<ServiceRequest> serviceRequestList = serviceRequestRepository.findAll();
        System.out.println(serviceRequestList.size());
    }

    @GetMapping("/map")
    public void testMap(){
        List<Partner> partnerList = partnerRepository.findAll();
        System.out.println(partnerList.size());
    }

    @GetMapping("/mongo")
    public void testMongo(){
        List<MongoEntity> mongoEntityList = crudTestRepo.findAll();
        System.out.println(mongoEntityList.size());
    }
}
