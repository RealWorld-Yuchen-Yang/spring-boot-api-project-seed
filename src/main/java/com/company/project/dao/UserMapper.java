package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.User;

import java.util.List;


public interface UserMapper extends Mapper<User> {
    List<User> selectAll();

    @Override
    int insertSelective(User user);

    @Override
    int updateByPrimaryKeySelective(User user);

    @Override
    User selectByPrimaryKey(Object o);

    @Override
    int deleteByPrimaryKey(Object o);
}