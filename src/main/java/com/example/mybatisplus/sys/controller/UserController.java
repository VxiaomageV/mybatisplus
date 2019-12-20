package com.example.mybatisplus.sys.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatisplus.sys.entity.User;
import com.example.mybatisplus.sys.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.sql.Wrapper;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author mal
 * @since 2019-12-05
 */
@RestController
@RequestMapping("/sys/user")
public class UserController {

    @Autowired
    IUserService iUserService;

    @PostMapping("/updateById")
    public void updateById(@RequestBody User user) {
        iUserService.updateById(user);
    }

    @GetMapping("/selectList")
    public ArrayList<User> selectList() {
        ArrayList<User> users = (ArrayList<User>) iUserService.list();
        return users;
    }

    @GetMapping("/selectById")
    public User selectById() {
        return iUserService.getById(1);
    }

    @GetMapping("/selectPage")
    public void selectPage() {
        // 1代表当前页 5代表每页条数
        Page<User> page = new Page<>(1, 5);
        IPage<User> lstUser = iUserService.page(page);
        System.out.println("page:" + lstUser);
    }

    @PostMapping("/selectByPage")
    public IPage<User> selectByPage(@RequestBody Page page) {
        Page<User> pageNew = new Page<>();
        IPage<User> users = iUserService.page(page);
        System.out.println("page:" + users);
        return users;
    }

    @GetMapping("/save")
    public void save() {
        User user = new User();
        user.setName("呵呵");
        iUserService.save(user);
    }

    @PostMapping("/saveUser")
    public void saveUser(@RequestBody User user) {
        iUserService.save(user);
    }

    @GetMapping("/delete")
    public void delete() {
        HashMap<String, Object> map = new HashMap<>(16);
        map.put("name", "Billie");
        map.put("age", 24);
        iUserService.removeByMap(map);
    }

    @GetMapping("/deleteByID")
    public void deleteByID(@RequestParam int id) {
        iUserService.removeById(new BigInteger(id + ""));
    }


}
