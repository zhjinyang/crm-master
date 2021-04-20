package com.zhjinyang.cn.transfer;

import com.zhjinyang.cn.domin.entity.Category;
import com.zhjinyang.cn.domin.vo.CategoryVo;
import com.zhjinyang.cn.transfer.base.BaseTransfer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author Zjy
 * @date 2021/4/18 11:39
 */
@Component
@RequiredArgsConstructor
public class CategoryTransfer extends BaseTransfer<Category, CategoryVo> {

}
