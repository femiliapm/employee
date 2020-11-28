package com.example.employee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MvcBaseController {
  @GetMapping("/employee")
  public String index() {
    return "index";
  }
}
