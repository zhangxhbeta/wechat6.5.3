package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.i;
import com.tencent.mm.model.k;
import com.tencent.mm.model.l;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.u;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public final class QQMailHistoryExporter {
    private static final char[] dSF = new char[]{'<', '>', '\"', '\'', '&', '\n'};
    private static final String[] dSG = new String[]{"&lt;", "&gt;", "&quot;", "&apos;", "&amp;", "<br />"};
    private static final String oyL = ("<img id=\"%d:%d\" src=\"%s\" height=\"100\" onclick=\"" + s.dt("weixin://img_onclick/", "this.id + '@@' + this.src") + "\"></img>");
    private u bhV = null;
    private float cmK = 1.0f;
    private Context context;
    private List<at> omM;
    private String oyI = null;

    public static class ImageSpanData implements Parcelable {
        public static final Creator<ImageSpanData> CREATOR = new Creator<ImageSpanData>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                ImageSpanData imageSpanData = new ImageSpanData();
                imageSpanData.cyv = parcel.readInt();
                imageSpanData.oyM = parcel.readInt();
                imageSpanData.path = parcel.readString();
                imageSpanData.thumbnail = parcel.readInt();
                return imageSpanData;
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new ImageSpanData[i];
            }
        };
        int cyv;
        int oyM;
        String path;
        private int thumbnail = 0;

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.cyv);
            parcel.writeInt(this.oyM);
            parcel.writeString(this.path);
            parcel.writeInt(this.thumbnail);
        }
    }

    private static String KJ(String str) {
        if (str == null) {
            return SQLiteDatabase.KeyEmpty;
        }
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            Object obj = 1;
            for (int length2 = dSF.length - 1; length2 >= 0; length2--) {
                if (dSF[length2] == charAt) {
                    stringBuffer.append(dSG[length2]);
                    obj = null;
                    break;
                }
            }
            if (obj != null) {
                stringBuffer.append(charAt);
            }
        }
        return stringBuffer.toString();
    }

    public QQMailHistoryExporter(Context context, List<at> list, u uVar) {
        this.context = context;
        this.omM = list;
        this.bhV = uVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String bGp() {
        /*
        r15 = this;
        r14 = 4;
        r13 = 3;
        r12 = 2;
        r4 = 0;
        r3 = 1;
        r0 = "MicroMsg.QQMailHistoryExporter";
        r1 = "selectItems.size = %d";
        r2 = new java.lang.Object[r3];
        r5 = r15.omM;
        r5 = r5.size();
        r5 = java.lang.Integer.valueOf(r5);
        r2[r4] = r5;
        com.tencent.mm.sdk.platformtools.v.i(r0, r1, r2);
        r0 = r15.context;
        r0 = com.tencent.mm.bd.a.dt(r0);
        if (r0 == 0) goto L_0x002c;
    L_0x0024:
        r0 = r15.context;
        r0 = com.tencent.mm.bd.a.ds(r0);
        r15.cmK = r0;
    L_0x002c:
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r0 = "<div id=\"history\">\n";
        r5.append(r0);
        r0 = "<p style=\"font-size:%fem;\">Dear:</p> <br> <p style=\"text-indent:2em; font-size:%fem;\">%s</p> <br>";
        r1 = new java.lang.Object[r13];
        r2 = r15.cmK;
        r2 = java.lang.Float.valueOf(r2);
        r1[r4] = r2;
        r2 = r15.cmK;
        r2 = java.lang.Float.valueOf(r2);
        r1[r3] = r2;
        r2 = r15.bGq();
        r1[r12] = r2;
        r0 = java.lang.String.format(r0, r1);
        r5.append(r0);
        r0 = r15.omM;
        r6 = r0.iterator();
    L_0x005f:
        r0 = r6.hasNext();
        if (r0 == 0) goto L_0x0516;
    L_0x0065:
        r0 = r6.next();
        r0 = (com.tencent.mm.storage.at) r0;
        r1 = r15.oyI;
        if (r1 != 0) goto L_0x00cb;
    L_0x006f:
        r8 = r0.field_createTime;
        r1 = eB(r8);
        r15.oyI = r1;
        r1 = "<p style=\"text-align:center; font-size:%fem;\"><span style=\"color:#b8b8b8;\">—————  %s  —————</span></p>\n \n";
        r2 = new java.lang.Object[r12];
        r7 = r15.cmK;
        r7 = java.lang.Float.valueOf(r7);
        r2[r4] = r7;
        r7 = r15.oyI;
        r2[r3] = r7;
        r1 = java.lang.String.format(r1, r2);
        r5.append(r1);
    L_0x008f:
        r1 = r0.bwm();
        if (r1 == 0) goto L_0x016e;
    L_0x0095:
        r1 = r0.bwm();
        if (r1 == 0) goto L_0x016b;
    L_0x009b:
        r1 = 0;
        r2 = r0.field_isSend;
        if (r2 != r3) goto L_0x00fa;
    L_0x00a0:
        r1 = "<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n";
        r2 = new java.lang.Object[r14];
        r7 = r15.cmK;
        r7 = java.lang.Float.valueOf(r7);
        r2[r4] = r7;
        r7 = r15.aB(r0);
        r2[r3] = r7;
        r7 = r15.cmK;
        r7 = java.lang.Float.valueOf(r7);
        r2[r12] = r7;
        r0 = r0.field_content;
        r0 = KJ(r0);
        r2[r13] = r0;
        r0 = java.lang.String.format(r1, r2);
    L_0x00c7:
        r5.append(r0);
        goto L_0x005f;
    L_0x00cb:
        r8 = r0.field_createTime;
        r1 = eB(r8);
        r2 = r15.oyI;
        r2 = r1.equals(r2);
        if (r2 != 0) goto L_0x008f;
    L_0x00d9:
        r15.oyI = r1;
        r1 = "<br>";
        r5.append(r1);
        r1 = "<p style=\"text-align:center; font-size:%fem;\"><span style=\"color:#b8b8b8;\">—————  %s  —————</span></p>\n \n";
        r2 = new java.lang.Object[r12];
        r7 = r15.cmK;
        r7 = java.lang.Float.valueOf(r7);
        r2[r4] = r7;
        r7 = r15.oyI;
        r2[r3] = r7;
        r1 = java.lang.String.format(r1, r2);
        r5.append(r1);
        goto L_0x008f;
    L_0x00fa:
        r2 = r15.bhV;
        r2 = r2.field_username;
        r7 = "@chatroom";
        r2 = r2.endsWith(r7);
        if (r2 != 0) goto L_0x012f;
    L_0x0107:
        r1 = "<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n";
        r2 = new java.lang.Object[r14];
        r7 = r15.cmK;
        r7 = java.lang.Float.valueOf(r7);
        r2[r4] = r7;
        r7 = r15.aB(r0);
        r2[r3] = r7;
        r7 = r15.cmK;
        r7 = java.lang.Float.valueOf(r7);
        r2[r12] = r7;
        r0 = r0.field_content;
        r0 = KJ(r0);
        r2[r13] = r0;
        r0 = java.lang.String.format(r1, r2);
        goto L_0x00c7;
    L_0x012f:
        r2 = r0.field_content;
        r2 = com.tencent.mm.model.aw.fK(r2);
        r7 = -1;
        if (r2 == r7) goto L_0x0524;
    L_0x0138:
        r1 = "<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n";
        r7 = new java.lang.Object[r14];
        r8 = r15.cmK;
        r8 = java.lang.Float.valueOf(r8);
        r7[r4] = r8;
        r8 = r15.aB(r0);
        r7[r3] = r8;
        r8 = r15.cmK;
        r8 = java.lang.Float.valueOf(r8);
        r7[r12] = r8;
        r0 = r0.field_content;
        r2 = r2 + 1;
        r0 = r0.substring(r2);
        r0 = r0.trim();
        r0 = KJ(r0);
        r7[r13] = r0;
        r0 = java.lang.String.format(r1, r7);
        goto L_0x00c7;
    L_0x016b:
        r0 = 0;
        goto L_0x00c7;
    L_0x016e:
        r1 = r0.bwj();
        if (r1 == 0) goto L_0x01f3;
    L_0x0174:
        r1 = r0.bwj();
        if (r1 == 0) goto L_0x01f1;
    L_0x017a:
        r8 = r0.field_msgId;
        r10 = r0.field_msgSvrId;
        r1 = com.tencent.mm.ui.chatting.dj.ez(r8);
        r2 = com.tencent.mm.sdk.platformtools.be.kS(r1);
        if (r2 == 0) goto L_0x018c;
    L_0x0188:
        r1 = com.tencent.mm.ui.chatting.dj.eA(r10);
    L_0x018c:
        r2 = "MicroMsg.QQMailHistoryExporter";
        r7 = "hdPath[%s]";
        r8 = new java.lang.Object[r3];
        r8[r4] = r1;
        com.tencent.mm.sdk.platformtools.v.d(r2, r7, r8);
        r2 = com.tencent.mm.sdk.platformtools.be.kS(r1);
        if (r2 != 0) goto L_0x01f1;
    L_0x019f:
        r2 = new java.lang.StringBuilder;
        r7 = "file://";
        r2.<init>(r7);
        r2 = r2.append(r1);
        r2 = r2.toString();
        r7 = oyL;
        r8 = new java.lang.Object[r14];
        r10 = r0.field_msgId;
        r9 = java.lang.Long.valueOf(r10);
        r8[r4] = r9;
        r10 = r0.field_msgSvrId;
        r9 = java.lang.Long.valueOf(r10);
        r8[r3] = r9;
        r8[r12] = r2;
        r8[r13] = r1;
        r1 = java.lang.String.format(r7, r8);
        r2 = "<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n";
        r7 = new java.lang.Object[r14];
        r8 = r15.cmK;
        r8 = java.lang.Float.valueOf(r8);
        r7[r4] = r8;
        r0 = r15.aB(r0);
        r7[r3] = r0;
        r0 = r15.cmK;
        r0 = java.lang.Float.valueOf(r0);
        r7[r12] = r0;
        r7[r13] = r1;
        r0 = java.lang.String.format(r2, r7);
    L_0x01ec:
        r5.append(r0);
        goto L_0x005f;
    L_0x01f1:
        r0 = 0;
        goto L_0x01ec;
    L_0x01f3:
        r1 = 0;
        r2 = r0.bwb();
        if (r2 == 0) goto L_0x0241;
    L_0x01fa:
        r1 = "[%s]";
        r2 = new java.lang.Object[r3];
        r7 = r15.context;
        r8 = 2131232320; // 0x7f080640 float:1.8080746E38 double:1.0529686726E-314;
        r7 = r7.getString(r8);
        r2[r4] = r7;
        r1 = java.lang.String.format(r1, r2);
    L_0x020e:
        r2 = "MicroMsg.QQMailHistoryExporter";
        r7 = "formatOtherMsg, msgStr = %s";
        r8 = new java.lang.Object[r3];
        r8[r4] = r1;
        com.tencent.mm.sdk.platformtools.v.d(r2, r7, r8);
        r2 = "<p style=\"font-size:%fem;\"><b>%s</b></p>\n  <p style=\"font-size:%fem;\">%s</p>\n <p style=\"line-height:1.5em;\"></p>\n";
        r7 = new java.lang.Object[r14];
        r8 = r15.cmK;
        r8 = java.lang.Float.valueOf(r8);
        r7[r4] = r8;
        r0 = r15.aB(r0);
        r7[r3] = r0;
        r0 = r15.cmK;
        r0 = java.lang.Float.valueOf(r0);
        r7[r12] = r0;
        r7[r13] = r1;
        r0 = java.lang.String.format(r2, r7);
        r5.append(r0);
        goto L_0x005f;
    L_0x0241:
        r2 = r0.bwf();
        if (r2 == 0) goto L_0x025f;
    L_0x0247:
        r1 = r0.field_isSend;
        if (r1 != r3) goto L_0x0255;
    L_0x024b:
        r1 = r15.context;
        r2 = 2131232318; // 0x7f08063e float:1.8080742E38 double:1.0529686716E-314;
        r1 = r1.getString(r2);
        goto L_0x020e;
    L_0x0255:
        r1 = r15.context;
        r2 = 2131232317; // 0x7f08063d float:1.808074E38 double:1.052968671E-314;
        r1 = r1.getString(r2);
        goto L_0x020e;
    L_0x025f:
        r2 = r0.bwl();
        if (r2 == 0) goto L_0x0287;
    L_0x0265:
        r1 = new com.tencent.mm.e.a.hq;
        r1.<init>();
        r2 = r1.bhv;
        r2.bhq = r3;
        r2 = r1.bhv;
        r2.aXd = r0;
        r2 = com.tencent.mm.sdk.c.a.nhr;
        r2.z(r1);
        r1 = r1.bhw;
        r1 = r1.bhy;
        r2 = "[%s]";
        r7 = new java.lang.Object[r3];
        r7[r4] = r1;
        r1 = java.lang.String.format(r2, r7);
        goto L_0x020e;
    L_0x0287:
        r2 = r0.bvY();
        if (r2 == 0) goto L_0x048c;
    L_0x028d:
        r2 = "";
        r1 = r0.field_content;
        r7 = r15.bhV;
        r7 = r7.field_username;
        r8 = "@chatroom";
        r7 = r7.endsWith(r8);
        if (r7 == 0) goto L_0x02c1;
    L_0x029f:
        r7 = "MicroMsg.QQMailHistoryExporter";
        r8 = "chatroom msg, parse it";
        com.tencent.mm.sdk.platformtools.v.d(r7, r8);
        r7 = r0.field_content;
        r7 = com.tencent.mm.model.aw.fK(r7);
        r8 = -1;
        if (r7 == r8) goto L_0x02c1;
    L_0x02b1:
        r1 = r0.field_content;
        r7 = r7 + 1;
        r1 = r1.substring(r7);
        r1 = r1.trim();
        r1 = KJ(r1);
    L_0x02c1:
        r1 = com.tencent.mm.sdk.platformtools.be.KK(r1);
        r7 = com.tencent.mm.q.a.a.dV(r1);
        if (r7 != 0) goto L_0x02ea;
    L_0x02cb:
        r1 = "MicroMsg.QQMailHistoryExporter";
        r2 = "appmsg content is null";
        com.tencent.mm.sdk.platformtools.v.w(r1, r2);
        r1 = "[%s]";
        r2 = new java.lang.Object[r3];
        r7 = r15.context;
        r8 = 2131232310; // 0x7f080636 float:1.8080726E38 double:1.0529686677E-314;
        r7 = r7.getString(r8);
        r2[r4] = r7;
        r1 = java.lang.String.format(r1, r2);
        goto L_0x020e;
    L_0x02ea:
        r1 = r7.appId;
        r8 = com.tencent.mm.pluginsdk.model.app.g.aC(r1, r3);
        if (r8 == 0) goto L_0x02fa;
    L_0x02f2:
        r1 = r8.field_appName;
        r1 = com.tencent.mm.sdk.platformtools.be.kS(r1);
        if (r1 == 0) goto L_0x0316;
    L_0x02fa:
        r1 = r7.appName;
    L_0x02fc:
        r9 = r15.context;
        r8 = com.tencent.mm.pluginsdk.model.app.g.a(r9, r8, r1);
        r1 = r0.field_type;
        r9 = 16777265; // 0x1000031 float:2.3510024E-38 double:8.2890703E-317;
        if (r1 != r9) goto L_0x0319;
    L_0x0309:
        r1 = r3;
    L_0x030a:
        if (r1 == 0) goto L_0x032c;
    L_0x030c:
        r1 = com.tencent.mm.sdk.platformtools.be.kS(r8);
        if (r1 == 0) goto L_0x031b;
    L_0x0312:
        r1 = r7.title;
        goto L_0x020e;
    L_0x0316:
        r1 = r8.field_appName;
        goto L_0x02fc;
    L_0x0319:
        r1 = r4;
        goto L_0x030a;
    L_0x031b:
        r1 = "[%s: %s]";
        r2 = new java.lang.Object[r12];
        r2[r4] = r8;
        r7 = r7.title;
        r2[r3] = r7;
        r1 = java.lang.String.format(r1, r2);
        goto L_0x020e;
    L_0x032c:
        r1 = r0.bwr();
        if (r1 == 0) goto L_0x036a;
    L_0x0332:
        r1 = com.tencent.mm.ui.chatting.dj.a(r0, r7);
        r7 = com.tencent.mm.sdk.platformtools.be.kS(r1);
        if (r7 != 0) goto L_0x0521;
    L_0x033c:
        r2 = new java.lang.StringBuilder;
        r7 = "file://";
        r2.<init>(r7);
        r2 = r2.append(r1);
        r2 = r2.toString();
        r7 = oyL;
        r8 = new java.lang.Object[r14];
        r10 = r0.field_msgId;
        r9 = java.lang.Long.valueOf(r10);
        r8[r4] = r9;
        r10 = r0.field_msgSvrId;
        r9 = java.lang.Long.valueOf(r10);
        r8[r3] = r9;
        r8[r12] = r2;
        r8[r13] = r1;
        r1 = java.lang.String.format(r7, r8);
        goto L_0x020e;
    L_0x036a:
        r1 = r7.type;
        switch(r1) {
            case 1: goto L_0x045e;
            case 2: goto L_0x0426;
            case 3: goto L_0x0385;
            case 4: goto L_0x0479;
            case 5: goto L_0x0479;
            case 6: goto L_0x03db;
            case 7: goto L_0x036f;
            case 8: goto L_0x03c5;
            default: goto L_0x036f;
        };
    L_0x036f:
        r1 = "[%s]";
        r2 = new java.lang.Object[r3];
        r7 = r15.context;
        r8 = 2131232310; // 0x7f080636 float:1.8080726E38 double:1.0529686677E-314;
        r7 = r7.getString(r8);
        r2[r4] = r7;
        r1 = java.lang.String.format(r1, r2);
        goto L_0x020e;
    L_0x0385:
        r1 = r7.description;
        r1 = com.tencent.mm.sdk.platformtools.be.kS(r1);
        if (r1 == 0) goto L_0x03a7;
    L_0x038d:
        r1 = "[%s: %s]";
        r2 = new java.lang.Object[r12];
        r8 = r15.context;
        r9 = 2131232316; // 0x7f08063c float:1.8080738E38 double:1.0529686706E-314;
        r8 = r8.getString(r9);
        r2[r4] = r8;
        r7 = r7.title;
        r2[r3] = r7;
        r1 = java.lang.String.format(r1, r2);
        goto L_0x020e;
    L_0x03a7:
        r1 = "[%s: %s-%s]";
        r2 = new java.lang.Object[r13];
        r8 = r15.context;
        r9 = 2131232316; // 0x7f08063c float:1.8080738E38 double:1.0529686706E-314;
        r8 = r8.getString(r9);
        r2[r4] = r8;
        r8 = r7.title;
        r2[r3] = r8;
        r7 = r7.description;
        r2[r12] = r7;
        r1 = java.lang.String.format(r1, r2);
        goto L_0x020e;
    L_0x03c5:
        r1 = "[%s]";
        r2 = new java.lang.Object[r3];
        r7 = r15.context;
        r8 = 2131232313; // 0x7f080639 float:1.8080732E38 double:1.052968669E-314;
        r7 = r7.getString(r8);
        r2[r4] = r7;
        r1 = java.lang.String.format(r1, r2);
        goto L_0x020e;
    L_0x03db:
        r1 = r7.description;
        r1 = com.tencent.mm.sdk.platformtools.be.kS(r1);
        if (r1 == 0) goto L_0x03fd;
    L_0x03e3:
        r1 = "[%s: %s]";
        r2 = new java.lang.Object[r12];
        r8 = r15.context;
        r9 = 2131232314; // 0x7f08063a float:1.8080734E38 double:1.0529686697E-314;
        r8 = r8.getString(r9);
        r2[r4] = r8;
        r7 = r7.title;
        r2[r3] = r7;
        r1 = java.lang.String.format(r1, r2);
        goto L_0x020e;
    L_0x03fd:
        r1 = "[%s: %s-%s(%s)]";
        r2 = new java.lang.Object[r14];
        r8 = r15.context;
        r9 = 2131232314; // 0x7f08063a float:1.8080734E38 double:1.0529686697E-314;
        r8 = r8.getString(r9);
        r2[r4] = r8;
        r8 = r7.title;
        r2[r3] = r8;
        r7 = r7.description;
        r2[r12] = r7;
        r7 = r15.context;
        r8 = 2131232311; // 0x7f080637 float:1.8080728E38 double:1.052968668E-314;
        r7 = r7.getString(r8);
        r2[r13] = r7;
        r1 = java.lang.String.format(r1, r2);
        goto L_0x020e;
    L_0x0426:
        r1 = com.tencent.mm.ui.chatting.dj.a(r0, r7);
        r7 = com.tencent.mm.sdk.platformtools.be.kS(r1);
        if (r7 != 0) goto L_0x0521;
    L_0x0430:
        r2 = new java.lang.StringBuilder;
        r7 = "file://";
        r2.<init>(r7);
        r2 = r2.append(r1);
        r2 = r2.toString();
        r7 = oyL;
        r8 = new java.lang.Object[r14];
        r10 = r0.field_msgId;
        r9 = java.lang.Long.valueOf(r10);
        r8[r4] = r9;
        r10 = r0.field_msgSvrId;
        r9 = java.lang.Long.valueOf(r10);
        r8[r3] = r9;
        r8[r12] = r2;
        r8[r13] = r1;
        r1 = java.lang.String.format(r7, r8);
        goto L_0x020e;
    L_0x045e:
        r1 = com.tencent.mm.sdk.platformtools.be.kS(r8);
        if (r1 == 0) goto L_0x0468;
    L_0x0464:
        r1 = r7.title;
        goto L_0x020e;
    L_0x0468:
        r1 = "[%s: %s]";
        r2 = new java.lang.Object[r12];
        r2[r4] = r8;
        r7 = r7.title;
        r2[r3] = r7;
        r1 = java.lang.String.format(r1, r2);
        goto L_0x020e;
    L_0x0479:
        r1 = "[%s: %s]";
        r2 = new java.lang.Object[r12];
        r8 = r7.title;
        r2[r4] = r8;
        r7 = r7.url;
        r2[r3] = r7;
        r1 = java.lang.String.format(r1, r2);
        goto L_0x020e;
    L_0x048c:
        r2 = r0.bwk();
        if (r2 == 0) goto L_0x04b9;
    L_0x0492:
        com.tencent.mm.model.ak.yW();
        r1 = com.tencent.mm.model.c.wJ();
        r2 = r0.field_content;
        r1 = r1.MU(r2);
        r1 = r1.cID;
        r2 = "[%s: %s]";
        r7 = new java.lang.Object[r12];
        r8 = r15.context;
        r9 = 2131232312; // 0x7f080638 float:1.808073E38 double:1.0529686687E-314;
        r8 = r8.getString(r9);
        r7[r4] = r8;
        r7[r3] = r1;
        r1 = java.lang.String.format(r2, r7);
        goto L_0x020e;
    L_0x04b9:
        r2 = r0.bwn();
        if (r2 == 0) goto L_0x04f4;
    L_0x04bf:
        r1 = "[%s: %s(%s)]";
        r2 = new java.lang.Object[r13];
        r7 = r15.context;
        r8 = 2131232319; // 0x7f08063f float:1.8080744E38 double:1.052968672E-314;
        r7 = r7.getString(r8);
        r2[r4] = r7;
        r7 = new java.io.File;
        com.tencent.mm.as.k.KV();
        r8 = r0.field_imgPath;
        r8 = com.tencent.mm.as.o.lc(r8);
        r7.<init>(r8);
        r7 = r7.getName();
        r2[r3] = r7;
        r7 = r15.context;
        r8 = 2131232311; // 0x7f080637 float:1.8080728E38 double:1.052968668E-314;
        r7 = r7.getString(r8);
        r2[r12] = r7;
        r1 = java.lang.String.format(r1, r2);
        goto L_0x020e;
    L_0x04f4:
        r2 = r0.bwp();
        if (r2 != 0) goto L_0x0500;
    L_0x04fa:
        r2 = r0.bwq();
        if (r2 == 0) goto L_0x020e;
    L_0x0500:
        r1 = "[%s]";
        r2 = new java.lang.Object[r3];
        r7 = r15.context;
        r8 = 2131232313; // 0x7f080639 float:1.8080732E38 double:1.052968669E-314;
        r7 = r7.getString(r8);
        r2[r4] = r7;
        r1 = java.lang.String.format(r1, r2);
        goto L_0x020e;
    L_0x0516:
        r0 = "\n</div>\n";
        r5.append(r0);
        r0 = r5.toString();
        return r0;
    L_0x0521:
        r1 = r2;
        goto L_0x020e;
    L_0x0524:
        r0 = r1;
        goto L_0x00c7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.QQMailHistoryExporter.bGp():java.lang.String");
    }

    private String bGq() {
        String str;
        if (this.bhV.field_username.endsWith("@chatroom")) {
            if (be.kS(this.bhV.field_nickname)) {
                List<String> ej = i.ej(this.bhV.field_username);
                str = SQLiteDatabase.KeyEmpty;
                String str2 = str;
                for (String str3 : ej) {
                    str2 = str2 + l.er(str3) + ", ";
                }
                str3 = str2.substring(0, str2.length() - 2);
            } else {
                str3 = this.bhV.tT();
            }
            return String.format(this.context.getString(2131234906), new Object[]{str3});
        }
        str3 = this.context.getString(2131234907);
        Object[] objArr = new Object[2];
        objArr[0] = this.bhV.tT();
        ak.yW();
        objArr[1] = c.vf().get(4, null);
        return String.format(str3, objArr);
    }

    private String aB(at atVar) {
        String str;
        String str2 = null;
        if (this.bhV.field_username.endsWith("@chatroom")) {
            str = atVar.field_content;
            int fK = aw.fK(str);
            if (fK != -1) {
                str2 = l.er(str.substring(0, fK).trim());
            }
        } else {
            str2 = l.er(atVar.field_talker);
        }
        if (atVar.field_isSend == 1) {
            v.i("MicroMsg.QQMailHistoryExporter", "isSend");
            str2 = k.xH();
        }
        str = new SimpleDateFormat("HH:mm").format(new Date(atVar.field_createTime));
        StringBuilder stringBuilder = new StringBuilder(SQLiteDatabase.KeyEmpty);
        stringBuilder.append(str2);
        stringBuilder.append("  ");
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    private static String eB(long j) {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date(j));
    }
}
