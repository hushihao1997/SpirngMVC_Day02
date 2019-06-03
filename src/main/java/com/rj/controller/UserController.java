package com.rj.controller;

import com.rj.domain.Test;
import com.rj.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
public class UserController {

    //带返回值的请求
    @RequestMapping("/testString")
    public String testString(Model model){
        System.out.println("testString 方法执行了");
        User user  = new User("胡世豪","123");
        model.addAttribute("data",user);
        return "success";
    }

    //void方式的请求
    /*
    * HttpServletRequest 里有个api可以实现请求转发
    *
    * 请求转发：请求转发一次请求，不用编写项目的名称
    * 重定向：两次请求，需要写项目名字
    * */
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("testVoid 方法执行了");
        //编写请求转发的代码，如果不希望后面的代码执行了，可以加一个return;
        //需要注意如果自己写请求转发需要些全路径
        //request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);

        //编写重定向来实现
        //response.sendRedirect(request.getContextPath()+"/index.jsp");

        //不跳转直接进行响应
        //注意如果写中文需要设置防止响应乱码
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println("你好");

       // return;
    }
    @RequestMapping("testBody")
     public String testBody(@RequestBody String body){
        System.out.println(body);
        return "success";
    }

    //ajax请求  模拟异步请求和响应的过程
    //由于前段传过来数据了这里需要用  @RequestBody 来获取请求体的内容
    /*
    * @ResponseBody: 通过适当的转换器转换为指定的格式之后，写入到response对象的body区，通常用来返回JSON数据或者是XML数据(需要引入jackson坐标)
    * @RequestBody：可以将请求体中的JSON字符串绑定到相应的bean上
    * */

//    @RequestMapping("/testJson")
//    public @ResponseBody User testAjax(@RequestBody User user){
//        System.out.println("ffff");
//        System.out.println(user);
//        user.setUsername("你好吗");
//        user.setPassword("123");
//        return user;
//    }

    @RequestMapping(value = "/testJson",method = RequestMethod.POST)
    @ResponseBody
    public Test testJson(@RequestBody Test test){
        System.out.println(test.getUsername());
        test.setUsername("ok");
        return test;
    }


}
