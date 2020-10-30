package com.qc.algo.basic.unionSet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * description
 *
 * @author qinc 2020/10/28 11:17
 */
public class MergeUsers {

    public static class User {
        String a;
        String b;
        String c;

        public User(String a, String b, String c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public static int merge(List<User> list) {
        UnionFindSet unionSet = new UnionFindSet(list);
        Map<String, User> aMap = new HashMap<>();
        Map<String, User> bMap = new HashMap<>();
        Map<String, User> cMap = new HashMap<>();

        for (User user : list) {
            if (aMap.get(user.a) == null) {
                aMap.put(user.a, user);
            } else {
                unionSet.union(aMap.get(user.a), user);
            }
            if (bMap.get(user.b) == null) {
                bMap.put(user.b, user);
            } else {
                unionSet.union(bMap.get(user.b), user);
            }
            if (cMap.get(user.c) == null) {
                cMap.put(user.c, user);
            } else {
                unionSet.union(cMap.get(user.c), user);
            }
        }

        return unionSet.size();
    }

    public static void main(String[] args) {

    }
}
