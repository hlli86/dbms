package com.springboot.controller;

import com.springboot.api.ErrorCode;
import com.springboot.api.ResponseMessage;
import com.springboot.domain.po.Users;
import com.springboot.dao.InvitationMapper;
import com.springboot.dao.UsersMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;




@RestController
public class AuthController {
        private Logger log = LoggerFactory.getLogger(this.getClass());
        @Autowired
        private UsersMapper usersMapper;
        @Autowired
        private InvitationMapper invitationMapper;

        @PostMapping("/auth/login")
        @ResponseBody
        public ResponseMessage login(String username, String password )
        {
            //password = MD5Utils.encrypt(username, password);
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            Subject subject = SecurityUtils.getSubject();
            try {
                subject.login(token);
                log.info("认证成功");
                //System.out.println("认证成功");
                return new ResponseMessage(ErrorCode.SUCCESS,"认证成功");
            } catch (UnknownAccountException e) {
                return new ResponseMessage(ErrorCode.QUERY_DATA_ERROR,e.getMessage());
            } catch (IncorrectCredentialsException e) {
                return new ResponseMessage(ErrorCode.QUERY_DATA_ERROR,e.getMessage());
            } catch (LockedAccountException e) {
                return new ResponseMessage(ErrorCode.QUERY_DATA_ERROR,e.getMessage());
            } catch (AuthenticationException e) {
                return  new ResponseMessage(ErrorCode.QUERY_DATA_ERROR,"认证失败！");
            }
        }

    @GetMapping ("/auth/logout")
    @ResponseBody
    public ResponseMessage logout(String username, String password )
    {
        try {
            Subject subject =SecurityUtils.getSubject();
            if (subject != null)
                subject.logout();
                System.out.println("注销成功");
                return new ResponseMessage(ErrorCode.SUCCESS,"注销成功");
        } catch (UnknownAccountException e) {
            return new ResponseMessage(ErrorCode.QUERY_DATA_ERROR,e.getMessage());
        } catch (IncorrectCredentialsException e) {
            return new ResponseMessage(ErrorCode.QUERY_DATA_ERROR,e.getMessage());
        } catch (LockedAccountException e) {
            return new ResponseMessage(ErrorCode.QUERY_DATA_ERROR,e.getMessage());
        }
    }
    @PostMapping ("/auth/register")
    @ResponseBody
    public ResponseMessage register(@RequestBody Users users,@RequestParam ("code") String code)
    {
            System.out.println(users.gethospital());
            System.out.println("code:"+code);
            if(invitationMapper.findByCode(code)==null)
            {
                return new ResponseMessage(ErrorCode.QUERY_DATA_ERROR, "邀请码错误！");
            }
            else
            {
                usersMapper.insert(users);
                return new ResponseMessage(ErrorCode.SUCCESS,"注册成功");
            }

    }
}
