package com.ijunfu;

import org.iq80.leveldb.DB;
import org.iq80.leveldb.DBComparator;
import org.iq80.leveldb.DBFactory;
import org.iq80.leveldb.Options;
import org.iq80.leveldb.impl.Iq80DBFactory;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @title  : 
 * @author : ijunfu <ijunfu@163.com>
 * @date   : 2024/7/2 9:17
 * @version: 1.0
 * @motto  : 简洁的代码是智慧的结晶 卓越的编码是对复杂性的优雅征服
 *
 */
class LevelDBApplicationTest {

    @Test
    void test() {
        DBFactory dbFactory = new Iq80DBFactory();

        Options options = new Options();
        options.createIfMissing(Boolean.FALSE);
        options.errorIfExists(Boolean.FALSE);
        options.comparator(new DBComparator() {
            @Override
            public String name() {
                return "idb_cmp1";
            }

            @Override
            public byte[] findShortestSeparator(byte[] start, byte[] limit) {
                System.out.println("start:" +new String(start));
                System.out.println("limit:" +new String(limit));

                if(start.length < limit.length) return start;

                if(start.length > limit.length) return limit;

                return start;
            }

            @Override
            public byte[] findShortSuccessor(byte[] key) {
                System.out.println("key:" +new String(key));
                return key;
            }

            @Override
            public int compare(byte[] o1, byte[] o2) {
                System.out.println("o1:" +new String(o1));
                System.out.println("o2:" +new String(o2));
                return new String(o1).compareTo(new String(o2));
            }
        });

//        try {
//            dbFactory.repair(new File("D:\\OKKI\\appData\\IndexedDB\\file__0.indexeddb.leveldb"), options);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        try(DB db = dbFactory.open(new File("D:\\OKKI\\appData\\IndexedDB\\file__0.indexeddb.leveldb"), options)) {

            // 读取数据
            db.iterator().forEachRemaining(entry -> {
                String key = new String(entry.getKey());
                String value = new String(entry.getValue());
                System.out.println("Key: " + key + ", Value: " + value);
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}