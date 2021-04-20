package com.zhjinyang.cn.common.utils;

import com.zhjinyang.cn.common.reflect.ReflectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Zjy
 * @date 2021/4/18 11:56
 */
public class TreeUtils {

    /**
     * 构建树形菜单
     *
     * @param list
     * @param <T>
     * @return
     */
    public static <T> List<T> buildTree(List<T> list) {
        //获取一级分类
        List<T> root = list.stream().filter(item -> (long) ReflectionUtils.getFieldValue(item, "parentId") == 0).collect(Collectors.toList());
        root.forEach(item -> {
            getChildren(item, list);
        });
        return root;
    }

    public static <T> void getChildren(T t, List<T> list) {
        if (hasChildren(t, list)) {
            //获取二级分类
            List<T> collect = list.stream().filter(item -> (long) ReflectionUtils.getFieldValue(item, "parentId")
                    == (long) ReflectionUtils.getFieldValue(t, "id")).collect(Collectors.toList());

            ReflectionUtils.setFieldValue(t, "children", collect);
            //使用递归获取三级分类
            collect.forEach(item1 -> getChildren(item1, list));
        }

    }

    public static <T> boolean hasChildren(T t, List<T> list) {
        long b = (long) ReflectionUtils.getFieldValue(t, "id");
        return list.stream().anyMatch(item -> {
            long a = (long) ReflectionUtils.getFieldValue(item, "parentId");

            return a == b;
        });
    }
}
