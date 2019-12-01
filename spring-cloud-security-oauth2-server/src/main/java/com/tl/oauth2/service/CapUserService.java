package com.tl.oauth2.service;


import com.tl.oauth2.domain.CapUser;
import com.tl.oauth2.mapper.CapUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

@Service
public class CapUserService {
    @Autowired
    private CapUserMapper capUserMapper;

    public CapUser getUserByUserId(String userId){

        Example example = new Example(CapUser.class);
        example.createCriteria().andEqualTo("userId", userId);
        return capUserMapper.selectOneByExample(example);
    }
}
