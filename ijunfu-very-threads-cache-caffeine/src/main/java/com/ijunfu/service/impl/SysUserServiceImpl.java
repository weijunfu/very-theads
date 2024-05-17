package com.ijunfu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ijunfu.entity.SysUser;
import com.ijunfu.mapper.SysUserMapper;
import com.ijunfu.service.SysUserService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @Title  : 
 *
 * @Author : ijunfu <ijunfu@163.com>
 * @Date   : 2024/5/17 12:58
 * @Version: 1.0
 * @Motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Cacheable(cacheNames = "sys", key = "'user:list'")
    @Override
    public List<SysUser> list() {
        return super.list();
    }

    @Cacheable(cacheNames = "sys", key = "'user:'+#id")
    @Override
    public SysUser getById(Serializable id) {
        return super.getById(id);
    }

    @Caching(
            evict = {
                    @CacheEvict(cacheNames = "sys", key = "'user:'+#id"),
                    @CacheEvict(cacheNames = "sys", key = "'user:list'")
            }
    )
    @Override
    public boolean removeById(Serializable id) {
        return super.removeById(id);
    }


    @Caching(
            evict = {@CacheEvict(cacheNames = "sys", key = "'user:list'")},
            put = {@CachePut(cacheNames = "sys", key = "'user:'+#entity.userId")}
    )
    @Override
    public boolean updateById(SysUser entity) {
        return super.updateById(entity);
    }

    @CacheEvict(cacheNames = "sys", key = "'user:list'")
    @Override
    public boolean save(SysUser entity) {
        return super.save(entity);
    }
}
