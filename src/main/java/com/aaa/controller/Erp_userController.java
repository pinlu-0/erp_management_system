package com.aaa.controller;

import com.aaa.model.Erp_role;
import com.aaa.model.Erp_user;
import com.aaa.model.Operator;
import com.aaa.service.Erp_userService;
import com.aaa.until.Picverifyaction;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/Erp_user")
public class Erp_userController {
    @Autowired
    Erp_userService service;
    @RequestMapping("/all")
    public String all(Model model, Erp_user erp_user){
        List<Erp_user> all = service.all(erp_user);
        List<Erp_role> rrall = service.rrall();
        List<Operator> opall = service.opall();
        model.addAttribute("uall",all);
        model.addAttribute("erp_user",erp_user);
        model.addAttribute("rrall",rrall);
        model.addAttribute("opall",opall);
        return "Erp_users";
    }
    @RequestMapping("/add")
    public String add(Erp_user erp_user){
        service.add(erp_user);
        return "redirect:/Erp_user/all";
    }
    @RequestMapping("/del")
    @ResponseBody
    public String del(int id){
        service.del(id);
        return "ok";
    }

    @RequestMapping("/selectByid")
    @ResponseBody
    public JSON select(Integer id){
        Erp_user selectbyid = service.selectbyid(id);
        JSON json= (JSON) JSON.toJSON(selectbyid);
        return json;
    }
    @RequestMapping("/upd")
    public String upd(Erp_user erp_user){
        service.upd(erp_user);
        return "redirect:/Erp_user/all";
    }
    @RequestMapping("/qi")
    @ResponseBody
    public String qi(Integer id){
        service.qi(id);
        return "ok";
    }
    @RequestMapping("/jin")
    @ResponseBody
    public String jin(Integer id){
        service.jin(id);
        return "ok";
    }
    @RequestMapping("/log")
    public String log(){
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        if (session.getAttribute("user")==null){
            return "login";
        }
        session.removeAttribute("user");
        return "login";
    }
    /*
    * 登录验证
    *
    * */
    @RequestMapping("/login")
    public String loginVerify(HttpServletRequest request, HttpSession session, Model model){
        String username = request.getParameter("u_name");
        String pwd = request.getParameter("u_pwd");
        String inputStr = request.getParameter("verify_input");
        System.out.println(username+pwd);
        Erp_user erp_user=new Erp_user(username,pwd);
        Erp_user verify = service.login(erp_user.getU_name(),erp_user.getU_pwd());
        /*model.addAttribute("users",verify.getOper_id());*/
        session.setAttribute("user",verify);
        session.setAttribute("userid",verify.getOper_id());
        session.setAttribute("username",verify.getOperator().getOper_name());
        boolean verifyCode = Picverifyaction.checkVerify(inputStr,session);
        if(verify!=null && verifyCode){

            if (verify.getU_state()==1){
                return "index";
            }else if(verify.getU_state()==0){
                session.setAttribute("state","该用户被禁用");
                session.setAttribute("loginname","");
                return "login";
            }
//            return "success";
        }else if(verify==null && verifyCode){

                session.setAttribute("state","");
                session.setAttribute("loginname","该用户账户或者密码错误");
                return "login";

//            return "fail";
        }
        return "login";
    }

}
