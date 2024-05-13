local function unpackRedPacket(key_amount, key_count, key_hash, userId)
    -- 获取红包总金额 和 总个数
    local total_amount = tonumber(redis.call('GET', key_amount));
    local total_count = tonumber(redis.call('GET', key_count));

    -- 确保红包还有剩余
    if total_count <= 0 then
        return "客官，您来晚了！";
    end;

    -- 二倍均值算法计算红包金额
    local max_amount = total_amount / total_count * 2;
    local random_amount = math.random() * max_amount;
    local final_amout = math.max(0.01, random_amount); -- 最低0.01元

    -- 更新红包金额和总个数
    redis.call("SET", key_amount, final_amout);
    redis.call("DECR", key_count);

    -- 将拆出来的红包金额和userId存入RedisHash结构中
    redis.call('HSET', key_hash, userId, final_amout);

    return "抢到红包金额：" .. final_amout;
 end;

 return unpackRedPacket(KEYS[1], KEYS[2], KEYS[3], ARGV[1]);