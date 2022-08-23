package com.power.doc.api.demo;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

import javax.ws.rs.QueryParam;

/**
 * demo测试
 * @tag dev
 * @order 1
 * @author cqmike 2021-07-16 14:09
 **/
@RestController
public class DemoController {

    /**
     * demo00
     * @order 1
     * @scan
     * @apiNote 测试servlet情况
     * @uparamAnno org.springframework.web.bind.annotation.RequestBody
     * @uparam demoObject com.power.doc.api.demo.DemoObject|
     *                   demo对象
     *                   |非空
     * @response demoObject com.power.doc.api.demo.DemoObject
     * @author CUP
     */
    @RequestMapping(value = "test/demo00.do", method = RequestMethod.POST)
    public void demo00() {
    }

    /**
     * testRequestParam
     *
     * @param author 者sjdkfal，按实际发甲方的\n
     *               啊大师金克拉放假撒</br>
     *               asfdajfk
     *               |村上春树
     *               |
     * @param type   type
     */
    @GetMapping("testRequestParam")
    public void testRequestParam(@RequestHeader String token, @RequestParam String author, @RequestParam String type) {
    }

    /**
     * demo01
     * @param demoObject com.power.doc.api.demo.DemoObject
     * @response demoObject com.power.doc.api.demo.DemoObject
     */
    @RequestMapping(value = "test/demo01.do", method = RequestMethod.POST)
    public String demo01() {
        return "abc";
    }

    /**
     * demo1
     * @param demoObject
     * @return
     */
    @RequestMapping(value = "test/demo1.do", method = RequestMethod.POST)
    public DemoObject demo1(@RequestBody DemoObject demoObject) {
        return demoObject;
    }

    /**
     * demo4
     * @param str
     * @return
     */
    @RequestMapping(value = "test/demo4.do", method = RequestMethod.POST)
    public String demo4(@QueryParam(value = "") String str) {
        return str;
    }
}
