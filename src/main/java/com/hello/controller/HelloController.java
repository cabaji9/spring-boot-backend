package com.hello.controller;

import com.hello.entity.Test;
import com.hello.service.HelloService;
import com.hello.util.ResultEnum;
import com.hello.vo.ResultVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import com.hello.vo.HelloVo;


import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 4/12/17.
 */
@RestController
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Inject
    protected HelloService helloService;

    @RequestMapping("/hello")
    public String index() {
        return "Greetings from Spring Boot!";
    }


    @RequestMapping(value="/data",method = RequestMethod.GET)
    public List<HelloVo> data() {
        List<HelloVo> helloVoList = new ArrayList<>();

        logger.info("HELLO LOGGER!");
        logger.error("ERROR TEST LOGGER!");
        logger.debug("DEBUG TEST LOGGER!");
        HelloVo helloVo = new HelloVo();
        helloVo.setName("Test");
        helloVo.setLastName("Last Test");
        helloVoList.add(helloVo);
        return helloVoList;
    }

    @RequestMapping(value="/test",method = RequestMethod.GET)
    public List<Test> obtainTest() {
        List<Test> helloVoTest =helloService.getAll();
        return helloVoTest;
    }

    @RequestMapping(value="/save",method = RequestMethod.POST)
    public Test saveTest(@RequestBody Test test) {
        return helloService.save(test);
    }


    @RequestMapping(value = "/delete/{test_id}", method = RequestMethod.DELETE)
    public ResultVo delete(@PathVariable("test_id") String test_id) throws Exception {
        logger.debug("delete | test_id {} ", test_id);
         String idDeleted =   helloService.delete(test_id);

        ResultVo resultVo = new ResultVo();
        resultVo.setResult(ResultEnum.OK.getValue());
        resultVo.setData(idDeleted);
        return  resultVo ;

    }




    @RequestMapping("/param/{param}")
    public String param(@PathVariable("param") String param) {
        return "You passed the next parameter" +param;
    }

}
