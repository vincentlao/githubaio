package com.laoning.githubaio.repository.remote.base;

/**
 * Created by laoni on 2018-2-3.
 */

public class Objects {
    public static boolean equals(Object o1, Object o2) {
        if (o1 == null) {
            return o2 == null;
        }
        if (o2 == null) {
            return false;
        }
        return o1.equals(o2);
    }
}