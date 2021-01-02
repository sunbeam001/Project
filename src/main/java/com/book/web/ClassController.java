package com.book.web;

import com.book.service.ClassService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
public class ClassController {
    @Resource
    private ClassService classService;

    @RequestMapping("/class_query.html")
    public ModelAndView classList() {
        ModelAndView modelAndView = new ModelAndView("class_list");
        modelAndView.addObject("classInfos", classService.list());
        return modelAndView;
    }
}
