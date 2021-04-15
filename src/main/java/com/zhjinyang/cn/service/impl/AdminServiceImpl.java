package com.zhjinyang.cn.service.impl;

import com.zhjinyang.cn.domin.entity.Admin;
import com.zhjinyang.cn.service.AdminService;
import com.zhjinyang.cn.service.base.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Zjy
 * @date 2021/4/14 23:14
 */
@Service
@Transactional
public class AdminServiceImpl extends BaseServiceImpl<Admin> implements AdminService {
}
