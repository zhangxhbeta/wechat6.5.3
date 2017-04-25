package com.tencent.mm.platformtools;

import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class q {
    public static boolean dpA = false;
    public static boolean dpB = false;
    public static boolean dpC = false;
    public static boolean dpD = false;
    public static boolean dpE = false;
    public static boolean dpF = false;
    public static boolean dpG = false;
    public static boolean dpH = false;
    public static boolean dpI = false;
    public static String dpJ = SQLiteDatabase.KeyEmpty;
    public static boolean dpK = false;
    public static boolean dpL = false;
    public static boolean dpM = false;
    public static boolean dpN = false;
    public static int dpO = 0;
    public static boolean dpP = false;
    public static boolean dpQ = false;
    public static boolean dpR = false;
    public static String dpS = SQLiteDatabase.KeyEmpty;
    public static String dpT = SQLiteDatabase.KeyEmpty;
    public static boolean dpU = false;
    public static boolean dpV = false;
    public static boolean dpW = false;
    public static boolean dpX = false;
    public static boolean dpY = false;
    public static boolean dpZ = false;
    public static boolean dpx = false;
    public static boolean dpy = false;
    public static boolean dpz = false;
    public static boolean dqA = false;
    public static int dqB = 0;
    public static boolean dqC = false;
    public static boolean dqD = false;
    public static boolean dqE = false;
    public static boolean dqF = false;
    public static boolean dqG = false;
    public static boolean dqH = false;
    public static int dqI = 3000;
    public static boolean dqJ = true;
    public static boolean dqK = false;
    public static boolean dqL = false;
    public static String dqM = SQLiteDatabase.KeyEmpty;
    public static int dqN = 0;
    public static boolean dqO = false;
    public static boolean dqP = false;
    public static int dqQ = -1;
    public static boolean dqR = false;
    public static String dqS = SQLiteDatabase.KeyEmpty;
    public static boolean dqT = false;
    public static boolean dqU = false;
    public static int dqV = 5;
    public static int dqW = 0;
    public static boolean dqX = false;
    public static String dqY = SQLiteDatabase.KeyEmpty;
    public static String dqZ = SQLiteDatabase.KeyEmpty;
    public static boolean dqa = false;
    public static int dqb = 0;
    public static int dqc = 0;
    public static boolean dqd = false;
    public static String dqe = null;
    public static String dqf = null;
    public static boolean dqg = false;
    public static boolean dqh = false;
    public static int dqi = 0;
    public static int dqj = 0;
    public static int dqk = 0;
    public static String dql = SQLiteDatabase.KeyEmpty;
    public static String dqm = SQLiteDatabase.KeyEmpty;
    public static String dqn = null;
    public static String dqo = null;
    public static boolean dqp = false;
    public static boolean dqq = false;
    public static boolean dqr = false;
    public static boolean dqs = false;
    public static String dqt = SQLiteDatabase.KeyEmpty;
    public static String dqu = SQLiteDatabase.KeyEmpty;
    public static String dqv = SQLiteDatabase.KeyEmpty;
    public static String dqw = SQLiteDatabase.KeyEmpty;
    public static String dqx = SQLiteDatabase.KeyEmpty;
    public static boolean dqy = false;
    public static boolean dqz = false;
    public static boolean dra = false;
    public static boolean drb = false;
    public static String drc = SQLiteDatabase.KeyEmpty;
    public static String drd = SQLiteDatabase.KeyEmpty;
    public static boolean dre = false;
    public static boolean drf = false;
    public static boolean drg = false;
    private static HashMap<Integer, ConcurrentLinkedQueue<Integer>> drh = new HashMap();
    public static boolean dri = false;
    public static boolean drj = false;
    public static boolean drk = false;
    public static double lat = 0.0d;
    public static double lng = 0.0d;

    public static void aX(int i, int i2) {
        synchronized (drh) {
            ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) drh.get(Integer.valueOf(i));
            if (concurrentLinkedQueue == null) {
                concurrentLinkedQueue = new ConcurrentLinkedQueue();
                drh.put(Integer.valueOf(i), concurrentLinkedQueue);
            }
            concurrentLinkedQueue.add(Integer.valueOf(i2));
        }
    }
}
