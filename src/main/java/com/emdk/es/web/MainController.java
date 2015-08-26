package com.emdk.es.web;

import com.emdk.es.domain.Constants;
import com.emdk.es.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by HP on 25.08.2015.
 */
@Controller
@RequestMapping("/main")
public class MainController {

@Autowired
MainService mainService;




    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String testSelectListExample(ModelMap model) {


        model.addAttribute(Constants.TEST_ID_LIST, mainService.selectListExample());
        model.addAttribute(Constants.TEST_WORD, "Royal bunu ozum senin uchun test olaraq yazdim ki jsp -ye nece melumat oturulduyunu yeniden xatirlayasan");

        return "test";

    }






}
