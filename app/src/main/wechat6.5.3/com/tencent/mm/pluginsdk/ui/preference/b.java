package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import com.tencent.mm.ar.f;
import com.tencent.mm.ar.j;
import com.tencent.mm.e.a.es;
import com.tencent.mm.e.b.bu;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.at.d;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class b {
    public boolean cFQ;
    public String cID;
    public String cqK;
    public String hWt;
    public int iRy;
    public long id;
    public String lPz;
    public String username;

    public static b a(Context context, f fVar) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6 = null;
        long j = fVar.nmb;
        boolean Ku = fVar.Ku();
        String str7 = fVar.field_talker;
        String str8 = fVar.field_msgContent;
        int i = fVar.field_type;
        int i2 = 0;
        if (i == 0) {
            a My = a.My(str8);
            str = My.lct;
            str2 = My.cID;
            str3 = My.nvG;
            str4 = My.nvH;
            i2 = My.scene;
            str5 = null;
        } else if (Ku) {
            d MB = d.MB(str8);
            str = MB.lct;
            str2 = MB.cID;
            str5 = MB.content;
            if (MB.nvS == 1) {
                str4 = null;
                str3 = null;
                str6 = MB.nvU;
            } else {
                str4 = null;
                str3 = null;
            }
        } else {
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
        }
        b a = a(context, j, Ku, str7, str8, i, str, str2, str3, str4, str5, i2);
        a.lPz = str6;
        return a;
    }

    public static b a(Context context, long j, boolean z, String str, String str2, int i, String str3, String str4, String str5, String str6, String str7, int i2) {
        b bVar = new b();
        bVar.id = j;
        bVar.cFQ = !z;
        v.d("MicroMsg.FMessageProvider", "build, fmsgInfo.type:%d, fmsgInfo.talker:%s, scene:%d  ", Integer.valueOf(i), str, Integer.valueOf(i2));
        if (i == 0) {
            if (str2 != null) {
                bVar.username = str3;
                bVar.cID = str4;
                switch (i2) {
                    case 4:
                        bVar.cqK = context.getString(2131231782);
                        break;
                    case 10:
                    case 11:
                        com.tencent.mm.sdk.c.b esVar = new es();
                        esVar.bdu.bdr = str5;
                        esVar.bdu.bds = str6;
                        com.tencent.mm.sdk.c.a.nhr.z(esVar);
                        bVar.cqK = context.getString(2131231785, new Object[]{be.ah(esVar.bdv.bdw, SQLiteDatabase.KeyEmpty)});
                        break;
                    case 31:
                        bVar.cqK = context.getString(2131231794);
                        break;
                    case FileUtils.S_IRGRP /*32*/:
                        bVar.cqK = context.getString(2131231788);
                        break;
                    case 58:
                    case 59:
                    case 60:
                        bVar.hWt = a.My(str2).hWt;
                        bVar.cqK = context.getString(2131231783);
                        break;
                    default:
                        bVar.cqK = context.getString(2131231787);
                        break;
                }
            }
            v.e("MicroMsg.FMessageProvider", "build fail, fmsgInfo msgContent is null, fmsgInfo.talker = " + str);
            return null;
        } else if (z) {
            bVar.username = str3;
            bVar.cID = str4;
            if (str7 == null || str7.trim().equals(SQLiteDatabase.KeyEmpty)) {
                bVar.cqK = context.getString(2131232845);
            } else {
                bVar.cqK = str7;
            }
        } else {
            bVar.username = str;
            bVar.cqK = str2;
        }
        return bVar;
    }

    public static b a(Context context, bu buVar) {
        v.d("MicroMsg.FMessageProvider", "build lbs, talker = " + buVar.field_sayhiuser + ", scene = " + buVar.field_scene);
        b bVar = new b();
        bVar.id = buVar.nmb;
        bVar.cFQ = buVar.field_isSend == 1;
        bVar.username = buVar.field_sayhiuser;
        bVar.iRy = buVar.field_scene;
        if (buVar.field_isSend == 1) {
            bVar.cqK = buVar.field_content;
        } else {
            d MB = d.MB(buVar.field_content);
            if (MB.content == null || MB.content.trim().equals(SQLiteDatabase.KeyEmpty)) {
                bVar.cqK = context.getString(2131231796);
            } else {
                bVar.cqK = MB.content;
            }
            bVar.cID = MB.cID;
        }
        return bVar;
    }

    public static b a(Context context, j jVar) {
        v.d("MicroMsg.FMessageProvider", "build shake, talker = " + jVar.field_talker + ", scene = " + jVar.field_scene);
        b bVar = new b();
        bVar.id = jVar.nmb;
        bVar.cFQ = jVar.field_isSend == 1;
        bVar.username = jVar.field_sayhiuser;
        bVar.iRy = jVar.field_scene;
        if (jVar.field_isSend == 1) {
            bVar.cqK = jVar.field_content;
        } else {
            d MB = d.MB(jVar.field_content);
            if (MB.content == null || MB.content.trim().equals(SQLiteDatabase.KeyEmpty)) {
                bVar.cqK = context.getString(2131231796);
            } else {
                bVar.cqK = MB.content;
            }
            bVar.cID = MB.cID;
        }
        return bVar;
    }

    public static b[] a(Context context, f[] fVarArr) {
        String str = "MicroMsg.FMessageProvider";
        StringBuilder stringBuilder = new StringBuilder("convert fmsgList, talker = ");
        String str2 = (fVarArr == null || fVarArr[0] == null) ? "null" : fVarArr[0].field_talker;
        v.d(str, stringBuilder.append(str2).toString());
        if (fVarArr == null || fVarArr.length == 0) {
            v.e("MicroMsg.FMessageProvider", "convert fmsg fail, fmsgList is null");
            return null;
        }
        b[] bVarArr = new b[fVarArr.length];
        for (int i = 0; i < bVarArr.length; i++) {
            bVarArr[i] = a(context, fVarArr[i]);
        }
        return bVarArr;
    }

    public static b[] a(Context context, bu[] buVarArr) {
        String str = "MicroMsg.FMessageProvider";
        StringBuilder stringBuilder = new StringBuilder("convert lbsList, talker = ");
        String str2 = (buVarArr == null || buVarArr[0] == null) ? "null" : buVarArr[0].field_sayhiuser;
        v.d(str, stringBuilder.append(str2).toString());
        if (buVarArr == null || buVarArr.length == 0) {
            v.e("MicroMsg.FMessageProvider", "convert lbs fail, lbsList is null");
            return null;
        }
        b[] bVarArr = new b[buVarArr.length];
        for (int i = 0; i < bVarArr.length; i++) {
            bVarArr[i] = a(context, buVarArr[i]);
        }
        return bVarArr;
    }

    public static b[] a(Context context, j[] jVarArr) {
        String str = "MicroMsg.FMessageProvider";
        StringBuilder stringBuilder = new StringBuilder("convert shakeList, talker = ");
        String str2 = (jVarArr == null || jVarArr[0] == null) ? "null" : jVarArr[0].field_sayhiuser;
        v.d(str, stringBuilder.append(str2).toString());
        if (jVarArr == null || jVarArr.length == 0) {
            v.e("MicroMsg.FMessageProvider", "convert shake fail, shakeList is null");
            return null;
        }
        b[] bVarArr = new b[jVarArr.length];
        for (int i = 0; i < bVarArr.length; i++) {
            bVarArr[i] = a(context, jVarArr[i]);
        }
        return bVarArr;
    }
}
