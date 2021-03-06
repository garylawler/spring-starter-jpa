package starter.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import starter.app.service.HelloService;

@Controller()
public class HelloController {

    @Autowired
    protected HelloService helloService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ModelAndView test() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.getModelMap().addAttribute("resultFromDatabase", helloService.getFromDatabase());
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
