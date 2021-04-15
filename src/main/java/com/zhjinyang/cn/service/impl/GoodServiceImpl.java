package com.zhjinyang.cn.service.impl;

import com.zhjinyang.cn.domin.entity.Good;
import com.zhjinyang.cn.service.GoodService;
import com.zhjinyang.cn.service.base.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Zjy
 * @date 2021/4/14 23:19
 */
@Service
@Transactional
public class GoodServiceImpl extends BaseServiceImpl<Good> implements GoodService {
}
