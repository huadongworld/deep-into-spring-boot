package com.ys.autoconfigure.repository;

import com.ys.autoconfigure.annotation.SecondLevelRepository;

/**
 * @author HuaDong
 * @date 2018/12/1 20:08
 *
 * myFirstLevelRepository : Bean名称
 */
@SecondLevelRepository(value = "myFirstLevelRepository")
public class MyFirstLevelRepository {
}
