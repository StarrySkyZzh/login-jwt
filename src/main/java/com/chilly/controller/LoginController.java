package com.chilly.controller;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.InvalidClaimException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.chilly.entity.User;
import com.chilly.service.UserService;
import com.chilly.utils.JWTUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@RestController
@Api(tags = "用户管理相关接口")
@Slf4j
@CrossOrigin
public class LoginController {

    @Resource
    private UserService userService;

    @PostMapping("/login")
    @ApiOperation("登录的接口")
    public void login(User user, HttpServletResponse response) {
        log.info("用户名：{}", user.getName());
        log.info("password: {}", user.getPassword());

        Map<String, Object> map = new HashMap<>();
        try {
            User userDB = userService.login(user);//实现验证用户密码

            Map<String, String> payload = new HashMap<>();
            payload.put("id", userDB.getId());
            payload.put("name", userDB.getName());
            payload.put("capacity",userDB.getCapacity());
            String token = JWTUtils.getToken(payload);

            map.put("state", true);
            map.put("msg", "登录成功");
            map.put("capacity",userDB.getCapacity());
            map.put("token", token);

        } catch (Exception e) {
            e.printStackTrace();
            map.put("state", false);
            map.put("msg", e.getMessage());
            map.put("token", "");
        }
        JSONObject json = new JSONObject().fromObject(map);
        try {
            response.setContentType("text/json");
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/user/test")
    @ApiOperation("验证登录的接口")
    public Map<String, Object> test(HttpServletRequest request) {
        String token = request.getHeader("token");
        DecodedJWT verify = JWTUtils.verify(token);
        String id = verify.getClaim("id").asString();
        String name = verify.getClaim("name").asString();
        String capacity=verify.getClaim("capacity").asString();
        log.info("用户id：{}", id);
        log.info("用户名: {}", name);
        log.info("capacity:{}",capacity);

        //TODO 业务逻辑
        Map<String, Object> map = new HashMap<>();
        map.put("state", true);
        map.put("msg", "请求成功");
        return map;
    }
}
