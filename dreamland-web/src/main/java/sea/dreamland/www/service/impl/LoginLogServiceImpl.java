
/*
 * Copyright (C) 2013-2016 ShangHai DoIT Network
 * All rights reserved.
 * ShangHai DoIt Network
 */
package sea.dreamland.www.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sea.dreamland.www.dao.LoginLogMapper;
import sea.dreamland.www.entity.LoginLog;
import sea.dreamland.www.service.LoginLogService;

import java.util.List;


/**
 * Created by wly on 2017/12/15.
 */
@Service
public class LoginLogServiceImpl implements LoginLogService {
    
    @Autowired
    private LoginLogMapper loginLogMapper;


    public int add(LoginLog loginLog) {
        return loginLogMapper.insert( loginLog );
    }

    @Override
    public List<LoginLog> findAll() {
        return loginLogMapper.select(null);
    }

    @Override
    public List<LoginLog> findByUid(Long uid) {
        LoginLog loginLog = new LoginLog();
        loginLog.setuId(uid);
        return loginLogMapper.select(loginLog);
    }
}

