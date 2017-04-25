package com.tencent.wecall.talkroom.model;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.pb.common.c.c;
import com.tencent.pb.common.c.d;
import com.tencent.pb.common.c.g;
import java.util.ArrayList;

public class h {
    static final String TAG = h.class.getCanonicalName();
    public static h pJv = new h();
    String deviceModel;
    public int gFG = 0;
    public long gFH = 0;
    public int gGl = -1;
    long gHb = 0;
    int gHc = 0;
    int kDA = 0;
    int kDE = 0;
    long kDF = 0;
    int kDK = 0;
    public int kDL = 0;
    String kDQ = SQLiteDatabase.KeyEmpty;
    int kDx = 0;
    public int kvR = 1;
    public String lEs = SQLiteDatabase.KeyEmpty;
    public int netType = -1;
    int pJA = 0;
    public int pJB = 0;
    int pJC = 0;
    long pJD = 0;
    int pJE;
    int pJF = -1;
    String pJG;
    int pJH;
    StringBuffer pJI = new StringBuffer();
    long pJJ = 0;
    long pJK = 0;
    long pJL = 0;
    public int pJw = 0;
    int pJx = 0;
    long pJy = 0;
    long pJz = 0;
    public String ppQ = SQLiteDatabase.KeyEmpty;

    public final String bPM() {
        int i;
        c.d(TAG, "collectInfo");
        this.pJG = Build.MANUFACTURER;
        this.deviceModel = Build.MODEL;
        this.pJH = VERSION.SDK_INT;
        this.kDQ = VERSION.RELEASE;
        this.netType = k.gB(d.kzS);
        this.kDK = 0;
        this.kDL = 0;
        this.pJE = -1;
        this.pJF = -1;
        Iterable arrayList = new ArrayList();
        arrayList.add(this.lEs);
        arrayList.add(this.ppQ);
        arrayList.add(Integer.valueOf(this.kvR));
        arrayList.add(Integer.valueOf(this.gFG));
        arrayList.add(Long.valueOf(this.gFH));
        arrayList.add(Integer.valueOf(this.gGl));
        arrayList.add(Integer.valueOf(this.kDx));
        arrayList.add(Integer.valueOf(this.kDE));
        arrayList.add(Integer.valueOf(this.kDA));
        arrayList.add(Integer.valueOf(this.gHc));
        arrayList.add(Integer.valueOf(this.pJw));
        arrayList.add(Integer.valueOf(this.pJx));
        arrayList.add(Long.valueOf(this.pJy));
        arrayList.add(Long.valueOf(this.pJz));
        arrayList.add(Integer.valueOf(this.pJA));
        arrayList.add(Integer.valueOf(this.pJB));
        arrayList.add(Integer.valueOf(this.pJC));
        arrayList.add(Long.valueOf(this.pJD));
        arrayList.add(Long.valueOf(this.kDF));
        arrayList.add(Long.valueOf(this.gHb));
        arrayList.add(Integer.valueOf(this.kDK));
        arrayList.add(Integer.valueOf(this.kDL));
        arrayList.add(Integer.valueOf(this.netType));
        arrayList.add(Integer.valueOf(this.pJE));
        arrayList.add(Integer.valueOf(this.pJF));
        arrayList.add(this.pJG);
        arrayList.add(this.deviceModel);
        arrayList.add(Integer.valueOf(this.pJH));
        arrayList.add(this.kDQ);
        TalkRoom QK = c.bPu().QK(this.lEs);
        if (QK == null) {
            i = 0;
        } else {
            i = QK.pHJ.size();
            c.d("TalkRoomManager", "getGroupMemberSize groupid: ", r3, " size: ", Integer.valueOf(i));
        }
        arrayList.add(Integer.valueOf(i));
        arrayList.add(this.pJI.toString());
        String a = com.tencent.pb.common.c.h.a(arrayList, ",", "_");
        c.d(TAG, "logBuf: ", this.pJI.toString());
        c.d(TAG, "statresult", a);
        return a;
    }

    public static void a(String str, int i, long j, String... strArr) {
        if (TextUtils.isEmpty(str)) {
            c.i(TAG, "uploadTempReport groupId is null");
            return;
        }
        c.i(TAG, "uploadTempReport: ", str, Integer.valueOf(i), Long.valueOf(j));
        h hVar = new h();
        if (str == null) {
            str = SQLiteDatabase.KeyEmpty;
        }
        hVar.lEs = str;
        hVar.gFG = i;
        hVar.gFH = j;
        hVar.J(strArr);
        QS(hVar.bPM());
    }

    public static void a(String str, String str2, int i, long j, String... strArr) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            c.i(TAG, "uploadTempReport groupId and clientGroupId is null");
            return;
        }
        c.i(TAG, "uploadTempReport: ", str, " clientGroupId: ", str2, " roomid: ", Integer.valueOf(i), Long.valueOf(j));
        h hVar = new h();
        if (str == null) {
            str = SQLiteDatabase.KeyEmpty;
        }
        hVar.lEs = str;
        hVar.gFG = i;
        hVar.gFH = j;
        if (str2 == null) {
            str2 = SQLiteDatabase.KeyEmpty;
        }
        hVar.ppQ = str2;
        hVar.J(strArr);
        QS(hVar.bPM());
        g.bMn();
    }

    public static void a(int i, long j, String... strArr) {
        h hVar = new h();
        hVar.lEs = SQLiteDatabase.KeyEmpty;
        hVar.gFG = i;
        hVar.gFH = j;
        hVar.ppQ = SQLiteDatabase.KeyEmpty;
        hVar.J(strArr);
        QS(hVar.bPM());
        g.bMn();
    }

    public final void J(String... strArr) {
        int i = 0;
        if (strArr != null && strArr.length != 0) {
            if (this.pJI.length() > 900) {
                this.pJI.setLength(0);
                this.pJI.append("overmaxsize");
            }
            if (this.pJI.length() != 0) {
                this.pJI.append("-");
            }
            int length = strArr.length;
            while (i < length) {
                this.pJI.append(strArr[i]);
                this.pJI.append("|");
                i++;
            }
        }
    }

    public final void bPN() {
        this.pJJ = System.currentTimeMillis();
        c.d(TAG, "beginCreateOrEnter", Long.valueOf(this.pJJ));
    }

    public final void bPO() {
        c.i(TAG, "beginCreateOrNotify");
        this.pJK = System.currentTimeMillis();
    }

    public static void zJ(int i) {
        c.d(TAG, "sendNetSceneStat", Integer.valueOf(i));
        g.s(527, 3, String.valueOf(i));
    }

    public static void zK(int i) {
        c.d(TAG, "sendDeviceStat", Integer.valueOf(i));
        g.s(528, 3, String.valueOf(i));
    }

    public static void zL(int i) {
        c.d(TAG, "sendtalkRoomDialStat", Integer.valueOf(i));
        g.s(530, 3, String.valueOf(i));
    }

    public static void bPP() {
        c.d(TAG, "sendTalkRoomOnDialStat", Integer.valueOf(-5001));
        g.s(531, 3, "-5001");
    }

    public static void zM(int i) {
        c.d(TAG, "sendEngineStat", Integer.valueOf(i));
        g.s(529, 3, String.valueOf(i));
    }

    public static void QS(String str) {
        c.d(TAG, "sendSummaryNetScene", str);
        g.s(532, 3, str);
    }

    public static void QT(String str) {
        c.d(TAG, "sendEngineRecv", str);
        g.s(533, 3, str);
    }

    public static void QU(String str) {
        c.d(TAG, "sendEngineSend", str);
        g.s(534, 3, str);
    }

    public static void QV(String str) {
        c.d(TAG, "sendChannelStat", str);
        g.s(535, 3, str);
    }

    public final void zN(int i) {
        c.d(TAG, "stopStatus", Integer.valueOf(i));
        this.kDx = i;
    }
}
