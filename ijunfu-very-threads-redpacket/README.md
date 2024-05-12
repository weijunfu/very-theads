
# 抢红包

## 1. 拆包要求
+ 所有人抢到的金额之和等于红包总额
+ 每个人最少抢到`0.01`原
+ 每个人抢到的红包金额不要相差太大

## 2. 拆包算法：二倍均值法
假设红包总金额为`N`，红包个数为`M`，每个红包的最低金额是`0.01`元。
那么每次抢到的红包金额的范围在`[0.01, (N/M) * 2)`之间。
即每次运算时，在`[0.01, 剩余金额/剩余红包个数 * 2)`的范围内随机取值。

## 3. 示例：发100元的红包，总个数为5
+ 第一个红包金额：`[0.01, 100/5*2)`范围内的随机数，假设是`10`元
+ 第二个红包金额：`[0.01, (100-10)/4*2)`范围内的随机数，假设是`30`元
+ ...依次类推，假设第三个红包金额为`25`，第四金额为`15`，那么最后一个红包金额为`100-10-30-25-15`，等于`20`元。

## 4. 解决方案

### 4.1 基于红包预分配方式结合Redis无锁原子化操作规避并发争抢

核心代码示例：
```java
public String unpack(Double money, Integer total) throws IOException {

    String redPacketKey = String.format("red-packet:%s", NanoId.randomNanoId());

    // 1. 预拆分红包
    List<Double> redPacketList = RedPacketUtil.unpack(money, total);

    // 2. 存入Redis
    redisUtil.lPush(redPacketKey, redPacketList);
    redisUtil.expire(redPacketKey, 60 * 60 * 24);

    // TODO 3. 监听红包过期，将过期的金额返还到余额


    return redPacketKey + "|" + JsonUtil.toJson(redPacketList);
}

// RedPacketUtil.java
public static List<Double> unpack(Double totalAmount, Integer total) {

    List<Double> redPacketList = new Vector<>();

    // 总金额
    double restAmount = totalAmount;

    // 总人数
    double restTotal = total;

    for(int i = 0; i<total-1; i++) {
        double amount = RANDOM.nextDouble() * 2 * restAmount / restTotal;

        amount = Math.max(0.01,  format(amount));

        restAmount -= amount;
        restTotal--;

        redPacketList.add(amount);
    }

    redPacketList.add(format(restAmount));

    return redPacketList;
}
```


