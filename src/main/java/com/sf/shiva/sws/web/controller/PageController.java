package com.sf.shiva.sws.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 *
 * <pre>
 * HISTORY
 * ****************************************************************************
 *  ID    DATE            PERSON            REASON
 *  1     2019/5/31         01370605           Create
 * ****************************************************************************
 * </pre>
 *
 * @author 01370605
 * @version 1.0
 */
@Controller
public class PageController {

  @GetMapping(path = "/")
  public String homePage() {
    return "index";
  }

  @GetMapping(path = "/json_parser")
  public String jsonParser() {
    return "json_parser";
  }
}
