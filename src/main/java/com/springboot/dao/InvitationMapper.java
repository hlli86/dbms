package com.springboot.dao;

import com.springboot.domain.po.Invitation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface InvitationMapper {
    Invitation findByCode(String code);
}
