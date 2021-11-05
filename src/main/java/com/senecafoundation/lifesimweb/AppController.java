package com.senecafoundation.lifesimweb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class AppController
{

  @RequestMapping(method=RequestMethod.GET)
  public String index()
  {
    return "index";
  }

  @RequestMapping(method=RequestMethod.GET, value = "/topdownmap/")
  public String topdownman()
  {
    return "topdownmap";
  }
  
}