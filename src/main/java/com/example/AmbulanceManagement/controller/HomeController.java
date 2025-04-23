package com.example.AmbulanceManagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
//    @RequestMapping("/")
//    public void homePage(HttpServletResponse httpServletResponse) throws GlobalException {
//        try {
//            httpServletResponse.sendRedirect("/swagger-ui/index.html");
//        } catch (Exception exception) {
//            throw new GlobalException("Page Not Found Exception!", HttpStatus.NOT_FOUND);
//        }
//    }

    @GetMapping("/health")
    public String healthCheck() {
        return "OK !!!";
    }
}
