package com.loctp.phr_system.service;

import com.loctp.phr_system.dto.AccountDTO;
import com.loctp.phr_system.dto.TestDTO;
import com.loctp.phr_system.dto.TestIndexReq;
import com.loctp.phr_system.dto.TestResultSampleDTO;
import com.loctp.phr_system.model.Account;
import com.loctp.phr_system.model.Test;
import com.loctp.phr_system.model.TestResultSample;
import com.loctp.phr_system.repository.IAccountRepository;
import com.loctp.phr_system.repository.ITestRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestService implements ITestService{

    @Autowired
    private ITestRepository testRepository;

    @Autowired
    private ITestResultSampleService iTestResultSampleService;

    @Autowired
    private ModelMapper mapper;

    @Override
    public TestDTO createTest(TestDTO dto) {
        Test testModel = new Test();
        testModel = mapper.map(dto, Test.class);
        testModel = testRepository.save(testModel);
        return mapper.map(testModel,TestDTO.class);
    }

    @Override
    public int getCountForName(String name) {
       return testRepository.countByNameIgnoreCase(name).intValue();
    }

    @Override
    public Boolean updateTestById(TestDTO dto) {
        Boolean check = false;
        // take the entity from db
        Test test = testRepository.findById(dto.getId()).get();
        if(test != null){
            // change Name and Description of this entity
            //nameDTO == name existing of this ID object => update Description
            //nameDTO == one of names in orther object => check trung => if has duplicated => cannot update

            if(test.getName().equalsIgnoreCase(dto.getName())){
                test.setDescription(dto.getDescription());
                check = true;

            }else{
                int count = testRepository.countByNameIgnoreCase(dto.getName());
                if(count == 0){ // NOT duplicated name
                    test.setName(dto.getName());
                    test.setDescription(dto.getDescription());
                    check = true;
                }
            }

            test = testRepository.save(test);
        }
        return check;
    }

    @Override
    public List<TestIndexReq> getAllTestIndex() {
        List<Test> testList = testRepository.findAll();
        List<TestIndexReq> indexReqList = new ArrayList<>();
        //begin foreach
        for (Test test: testList
             ) {
            TestIndexReq testIndexReq = new TestIndexReq();
            testIndexReq = mapper.map(test,TestIndexReq.class);

            List<TestResultSampleDTO> sampleList = iTestResultSampleService.getListTestSampleByTestId(test.getId());
            testIndexReq.setSamplelst(sampleList);
            indexReqList.add(testIndexReq);
        }
        //end of foreach

        return indexReqList;
    }
}
