package com.example.mybatisplus.sys.service.impl;

import com.example.mybatisplus.sys.entity.User;
import com.example.mybatisplus.sys.mapper.UserMapper;
import com.example.mybatisplus.sys.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mal
 * @since 2019-12-05
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
