package com.hello.service;

import com.hello.entity.Test;
import com.hello.repository.HelloRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by User on 4/12/17.
 */
@Service
public class HelloService {

    private static final Logger logger = LoggerFactory.getLogger(HelloService.class);

    @Inject
    protected HelloRepository helloRepository;


    public List<Test> getAll(){
        return helloRepository.findAll();
    }


    public Test save(Test test){ return  helloRepository.save(test);}

    public String delete(String testId) throws Exception {
        Test test = get(testId);
        logger.debug("delete | deleting {}", test);
        helloRepository.delete(test);
        return test.getId();
    }


    public Test get(String testId) {
        return helloRepository.findOne(testId);
    }



}
