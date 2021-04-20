package com.zhjinyang.cn.transfer.base;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Zjy
 * @date 2021/4/17 10:05
 */
@Slf4j
public class BaseTransfer<T, VO> {
    private Class<T> clazzT;
    private Class<VO> clazzVO;

    public BaseTransfer() {
        Type types = this.getClass().getGenericSuperclass();
        Type[] genericType = ((ParameterizedType) types).getActualTypeArguments();
        clazzT = (Class<T>) genericType[0];
        clazzVO = (Class<VO>) genericType[1];
    }

    /**
     * 转VO
     */
    public VO toVO(T t) {
        try {
            VO vo = clazzVO.newInstance();
            BeanUtils.copyProperties(t, vo);
            return vo;
        } catch (Exception e) {
            log.error("toVo转换错误", t);
        }
        return null;

    }


    /**
     * 转Entity
     */
    public T toEntity(VO vo) {
        try {
            T t = clazzT.newInstance();
            BeanUtils.copyProperties(vo, t);
            return t;
        } catch (Exception e) {
            log.error("toEntity转换错误", vo);
        }
        return null;

    }

    /**
     * 转Vo
     */
    public List<VO> toVO(List<T> list) {
        ArrayList<VO> list1 = new ArrayList<>();
        list.forEach(t -> list1.add(toVO(t)));
        return list1;
    }


    /**
     * 转Entity
     */
    public List<T> toEntity(List<VO> list) {
        ArrayList<T> list1 = new ArrayList<>();
        list.forEach(vo -> list1.add(toEntity(vo)));
        return list1;

    }
}
