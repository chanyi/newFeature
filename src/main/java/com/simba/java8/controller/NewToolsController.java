package com.simba.java8.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import org.junit.Test;

/**
 *  提供新的的工具
 *    1、nashorn引擎jjs，让js程序在jvm上运行(java 11 中再次废弃，)
 *      java1.6,1.7使用的js引擎是rhino
 *      java1.8开始使用nashorn替代rhino
 *      java11废弃掉nashron
 *      nashorn（犀牛式自行反坦克炮） rhino（犀牛）
 *      js中也可以通过var BigDecimal = Java.type('java.math.BigDecimal');方式调用java的方法
 *    2、类依赖分析器jdeps
 *
 */
public class NewToolsController {

  /**
   * 使用nashorn引擎执行js代码
   * @throws ScriptException
   */
  @Test
  public void printJsCode() throws ScriptException {
    ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
    engine.eval("print('Hello World!');");
  }


  @Test
  public void printJsCodeFromFile() throws ScriptException, FileNotFoundException {
    ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
    String rootPath = System.getProperty("user.dir");
    System.out.println(rootPath);
    engine.eval(new FileReader(rootPath+"/script.js"));
  }

}
