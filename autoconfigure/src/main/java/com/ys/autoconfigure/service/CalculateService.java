package com.ys.autoconfigure.service;

/**
 * @author HuaDong
 * @date 2018/12/1 21:02
 *
 * 计算服务
 */
public interface CalculateService {

    /**
     * 从多个整数 sum 求和
     * @param values 多个整数
     * @return sum 累加值
     */
    Integer sum(Integer... values);
}
