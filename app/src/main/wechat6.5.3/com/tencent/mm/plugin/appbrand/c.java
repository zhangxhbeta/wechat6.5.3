package com.tencent.mm.plugin.appbrand;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class c {
    private static int dyV = b.dyX;
    private static Map<String, Set<a>> dyW = new ConcurrentHashMap();

    public static class a {
        public void gW(int i) {
        }
    }

    public enum b {
        ;

        public static int[] OG() {
            return (int[]) dzb.clone();
        }

        static {
            dyX = 1;
            dyY = 2;
            dyZ = 3;
            dza = 4;
            dzb = new int[]{dyX, dyY, dyZ, dza};
        }
    }

    public static void a(String str, a aVar) {
        if (!dyW.containsKey(str)) {
            dyW.put(str, Collections.newSetFromMap(new ConcurrentHashMap()));
        }
        ((Set) dyW.get(str)).add(aVar);
    }

    private static Iterator<a> mw(String str) {
        Set set = (Set) dyW.get(str);
        if (set == null) {
            set = new HashSet();
        }
        return set.iterator();
    }

    public static void mx(String str) {
        Iterator mw = mw(str);
        while (mw.hasNext()) {
            mw.next();
        }
    }

    public static void my(String str) {
        Iterator mw = mw(str);
        while (mw.hasNext()) {
            mw.next();
        }
    }

    public static void mz(String str) {
        Iterator mw = mw(str);
        while (mw.hasNext()) {
            ((a) mw.next()).gW(dyV);
        }
    }

    public static void mA(String str) {
        Iterator mw = mw(str);
        while (mw.hasNext()) {
            mw.next();
        }
    }

    public static void mB(String str) {
        Iterator mw = mw(str);
        while (mw.hasNext()) {
            mw.next();
        }
    }

    public static void b(String str, a aVar) {
        Set set = (Set) dyW.get(str);
        if (set != null && !set.isEmpty()) {
            set.remove(aVar);
        }
    }

    public static void mC(String str) {
        dyW.remove(str);
    }

    public static int OF() {
        return dyV;
    }

    public static void gV(int i) {
        dyV = i;
    }
}
