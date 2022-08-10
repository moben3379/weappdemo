package cn.edu.guet.weappdemo.service.impl;

import cn.edu.guet.weappdemo.entity.SysLog;
import cn.edu.guet.weappdemo.service.SysLogService;

public class SysLogServiceImpl implements SysLogService {

    @Override
    public void save(SysLog sysLog) {
        System.out.println("日志");
    }
}
