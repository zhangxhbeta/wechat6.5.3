package com.tencent.mm.ui.contact;

import com.tencent.mm.model.m;
import com.tencent.mmdb.FileUtils;
import java.util.HashSet;

public final class r {
    public static final int oHI = s(FileUtils.S_IRUSR, 16, 1, 2, 4);
    public static final int oHJ = s(16, 1, 2, 4, 64, 16384);
    public static final int oHK = s(16, 1, 2, 4, 64, 4096);
    public static final int oHL = s(oHI, 64, 16384, 4096);
    public static final int oHM = s(16, 2, 16384, 4);
    public static final int oHN = s(oHI, 16384, 64, 4096);
    public static final int oHO = s(oHI, 16384, 64, 131072, 8192);
    public static final int oHP = s(16, 32, 1, 4, 2, 64);
    public static final int oHQ = s(oHJ, 131072);

    public static HashSet<String> bHP() {
        HashSet<String> hashSet = new HashSet();
        hashSet.add("weixin");
        return hashSet;
    }

    public static void e(HashSet<String> hashSet) {
        hashSet.remove("filehelper");
    }

    public static HashSet<String> bHQ() {
        HashSet<String> hashSet = new HashSet();
        hashSet.add("officialaccounts");
        hashSet.add("newsapp");
        for (Object add : m.crG) {
            hashSet.add(add);
        }
        hashSet.add("weibo");
        hashSet.add("qqmail");
        hashSet.add("fmessage");
        hashSet.add("tmessage");
        hashSet.add("qmessage");
        hashSet.add("qqsync");
        hashSet.add("floatbottle");
        hashSet.add("lbsapp");
        hashSet.add("shakeapp");
        hashSet.add("medianote");
        hashSet.add("qqfriend");
        hashSet.add("readerapp");
        hashSet.add("newsapp");
        hashSet.add("blogapp");
        hashSet.add("facebookapp");
        hashSet.add("masssendapp");
        hashSet.add("meishiapp");
        hashSet.add("feedsapp");
        hashSet.add("voipapp");
        hashSet.add("filehelper");
        hashSet.add("officialaccounts");
        hashSet.add("helper_entry");
        hashSet.add("pc_share");
        hashSet.add("cardpackage");
        hashSet.add("voicevoipapp");
        hashSet.add("voiceinputapp");
        hashSet.add("linkedinplugin");
        hashSet.add("appbrandcustomerservicemsg");
        return hashSet;
    }

    public static boolean dn(int i, int i2) {
        return (i & i2) > 0;
    }

    public static int do(int i, int i2) {
        return (i2 ^ -1) & i;
    }

    public static int s(int... iArr) {
        int i = 0;
        int i2 = 0;
        while (i < iArr.length) {
            i2 |= iArr[i];
            i++;
        }
        return i2;
    }
}
