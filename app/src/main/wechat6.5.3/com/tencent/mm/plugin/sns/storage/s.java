package com.tencent.mm.plugin.sns.storage;

import com.tencent.mm.sdk.platformtools.be;

public final class s {
    public static String A(String str, long j) {
        return str + j;
    }

    public static String B(String str, long j) {
        return str + j;
    }

    public static boolean BJ(String str) {
        return str != null && str.startsWith("ad_table_");
    }

    public static boolean zG(String str) {
        return str != null && str.startsWith("sns_table_");
    }

    public static long BK(String str) {
        if (be.kS(str)) {
            return 0;
        }
        if (str.startsWith("ad_table_")) {
            return be.KM(str.substring(9));
        }
        return be.KM(str.substring(10));
    }

    public static int BL(String str) {
        if (be.kS(str)) {
            return 0;
        }
        if (str.startsWith("ad_table_")) {
            return be.KL(str.substring(9));
        }
        return be.KL(str.substring(10));
    }

    public static boolean BM(String str) {
        if (str.startsWith("ad_table_")) {
            if (be.KM(str.substring(9)) != 0) {
                return true;
            }
            return false;
        } else if (be.KM(str.substring(10)) == 0) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean BN(String str) {
        return !BM(str);
    }
}
