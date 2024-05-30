package com.ijunfu.starter.service;

/**
 * @Title : Ip计数器服务类接口
 * @Author : ijunfu <ijunfu@163.com>
 * @Date : 2024/5/30 14:56
 * @Version: 1.0
 * @Motto : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 */
public interface IpCounterService {

    /**
     * @Title  : 根据IP记录访问次数
     *
     * @Param	:
     * @Return : void
     * @Author : ijunfu <ijunfu@163.com>
     * @Date   : 2024/5/30 19:00
     * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
     */
    void record();

}
