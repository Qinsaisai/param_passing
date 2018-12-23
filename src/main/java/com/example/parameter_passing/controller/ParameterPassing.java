package com.example.parameter_passing.controller;

import com.example.parameter_passing.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * SpringBoot获取前端页面参数的几种方式总结
 */

@Controller
public class ParameterPassing {

    //指定前端url请求参数名称与方法名一致，即url请求格式中的参数需要与方法的参数名称对应。
    @RequestMapping("/test1")
    @ResponseBody
    public String test1(String name,String pwd){
        String s1=name;
        String s2=pwd;
        return s1+s2;
    }

    //通过HttpServletRequest来获取前端页面参数，即通过调用request的getParameter方法来获取参数
    @RequestMapping("/test2")
    @ResponseBody
    public String test2(HttpServletRequest request){
        String firstName=request.getParameter("firstName");
        String lastName=request.getParameter("lastName");
        return firstName+lastName;
    }

    //通过创建一个JavaBean对象来封装表单参数或者是请求url路径中的参数
    @RequestMapping("/test3")
    @ResponseBody
    public String test3(Student student){
        String firstName=student.getFirstName();
        String lastName=student.getLastName();
        return firstName+lastName;
    }

    //通过PathVariable注解来绑定请求路径的参数，简单来说就是url中采用动态绑定的形式表示
    @RequestMapping("/test4/{a}/{bbb}")
    @ResponseBody
    public String test4(@PathVariable("a") String aaa,@PathVariable String bbb){
        return aaa+bbb;
    }

    //通过RequestParam注解，这种方式是通过url路径的形式将请求路径上的参数绑定到方法的参数上
    @RequestMapping("/test5")
    @ResponseBody
    public String test5(@RequestParam("aaa") String acc,@RequestParam String bbb){
        return acc+bbb;
    }
}
