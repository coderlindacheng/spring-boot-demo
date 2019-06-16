package com.sf.shiva.sws.web.controller;

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 *
 *
 * <pre>
 * HISTORY
 * ****************************************************************************
 *  ID    DATE            PERSON            REASON
 *  1     2019/6/12         01370605           Create
 * ****************************************************************************
 * </pre>
 *
 * @author 01370605
 * @version 1.0
 */
@RestController
public class JsonParserController {
  private static final Log logger = LogFactory.getLog(JsonParserController.class);
  private static final String BRACE = "{}";
  private static final String SQUARE_BRACKETS = "[]";

  @PostMapping(path = "/json_parser/send")
  public String sendData(String type, String sendData) {
    try {
      final String json = StringUtils.trim(sendData);
      // 检查json报文是否合法
      final Gson gson = new Gson();
      gson.fromJson(sendData, Map.class);
      if (StringUtils.isNotBlank(json) || BRACE.equals(json) || SQUARE_BRACKETS.equals(json)) {
        logger.info("json报文发送成功");
        return gson.toJson(Maps.immutableEntry("msg","json报文发送成功"));
      } else {
        logger.info("[JsonParserController.sendData] 不可以推空的json报文上来");
        return gson.toJson(Maps.immutableEntry("msg","不可以推空的json报文上来"));
      }
    } catch (Exception e) {
      logger.error("[ToolAction.sendData]", e);
      throw e;
    }
  }
}
