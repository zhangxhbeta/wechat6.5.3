package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.e.a.ef;
import com.tencent.mm.e.a.eh;
import com.tencent.mm.e.a.ei;
import com.tencent.mm.e.a.eo;
import com.tencent.mm.e.a.ep;
import com.tencent.mm.e.b.ab;
import com.tencent.mm.e.b.bx;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.l;
import com.tencent.mm.model.m;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.ext.a.a;
import com.tencent.mm.plugin.ext.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bc;
import com.tencent.mm.storage.u;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;

@JgClassChecked(author = 32, fComment = "checked", lastDate = "20141016", reviewer = 20, vComment = {EType.PROVIDERCHECK})
public class ExtControlProviderMsg extends ExtContentProviderBase {
    private static final UriMatcher fHn;
    private static final String[] fHq = new String[]{"msgId", "fromUserId", "fromUserNickName", "msgType", "contentType", "content", "status", "createTime"};
    private static final String[] fHr = new String[]{"userId", "unReadCount"};
    private static final String[] fHs = new String[]{"userId", "unReadCount"};
    private static final String[] fHt = new String[]{"userId", "retCode", "msgId"};
    private static final String[] fHu = new String[]{"msgId", "retCode"};
    private static final String[] fHv = new String[]{"msgId", "retCode"};
    private String[] fGX;
    private int fGY;
    private boolean fHo;
    private Context fHp;
    private MatrixCursor fHw;

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        fHn = uriMatcher;
        uriMatcher.addURI("com.tencent.mm.plugin.ext.message", "oneMsg", 7);
        fHn.addURI("com.tencent.mm.plugin.ext.message", "unReadCount", 8);
        fHn.addURI("com.tencent.mm.plugin.ext.message", "unReadMsgs", 9);
        fHn.addURI("com.tencent.mm.plugin.ext.message", "unReadUserList", 10);
        fHn.addURI("com.tencent.mm.plugin.ext.message", "recordMsg", 11);
        fHn.addURI("com.tencent.mm.plugin.ext.message", "playVoice", 12);
        fHn.addURI("com.tencent.mm.plugin.ext.message", "setReaded", 13);
        fHn.addURI("com.tencent.mm.plugin.ext.message", "sendTextMsg", 14);
    }

    public ExtControlProviderMsg() {
        this.fHw = null;
        this.fHo = false;
        this.fGX = null;
        this.fGY = -1;
    }

    public ExtControlProviderMsg(String[] strArr, int i, Context context) {
        this.fHw = null;
        this.fHo = false;
        this.fGX = null;
        this.fGY = -1;
        this.fHo = true;
        this.fGX = strArr;
        this.fGY = i;
        this.fHp = context;
    }

    public String getType(Uri uri) {
        return null;
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        v.i("MicroMsg.ExtControlProviderMsg", "ExtControlProviderMsg query() mIsLocalUsed :" + this.fHo);
        if (this.fHo) {
            a(uri, this.fHp, this.fGY, this.fGX);
            if (be.kS(this.fHh)) {
                v.e("MicroMsg.ExtControlProviderMsg", "AppID == null");
                bB(3, 7);
                return ExtContentProviderBase.kC(7);
            } else if (be.kS(akY())) {
                v.e("MicroMsg.ExtControlProviderMsg", "PkgName == null");
                bB(3, 6);
                return ExtContentProviderBase.kC(6);
            } else {
                int akZ = akZ();
                if (akZ != 1) {
                    v.e("MicroMsg.ExtControlProviderMsg", "invalid appid ! return code = " + akZ);
                    bB(2, akZ);
                    return ExtContentProviderBase.kC(akZ);
                }
            }
        }
        this.fHp = getContext();
        a(uri, this.fHp, fHn);
        if (uri == null) {
            kB(3);
            return null;
        } else if (be.kS(this.fHh) || be.kS(akY())) {
            kB(3);
            return null;
        } else if (!WN()) {
            kB(1);
            return this.enz;
        } else if (!bG(this.fHp)) {
            v.w("MicroMsg.ExtControlProviderMsg", "invalid appid ! return null");
            kB(2);
            return null;
        }
        String ma = be.ma(uri.getQueryParameter("source"));
        String ma2 = be.ma(uri.getQueryParameter("count"));
        if (!this.fHo) {
            this.fGY = fHn.match(uri);
        }
        switch (this.fGY) {
            case 7:
                return b(strArr2, ma);
            case 8:
                return l(strArr2);
            case 9:
                return a(strArr2, ma, ma2);
            case 10:
                return ala();
            case 11:
                return m(strArr2);
            case 12:
                return n(strArr2);
            case 13:
                return o(strArr2);
            case 14:
                return p(strArr2);
            default:
                bB(3, 15);
                return null;
        }
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    private Cursor l(String[] strArr) {
        v.d("MicroMsg.ExtControlProviderMsg", "getUnReadCount()");
        if (strArr == null || strArr.length <= 0) {
            v.e("MicroMsg.ExtControlProviderMsg", "wrong args");
            kB(3);
            return null;
        }
        Cursor matrixCursor = new MatrixCursor(fHr);
        try {
            int fv;
            if ("*".equals(strArr[0])) {
                ak.yW();
                fv = c.wK().fv(SQLiteDatabase.KeyEmpty);
                matrixCursor.addRow(new Object[]{"0", Integer.valueOf(fv)});
            } else {
                for (String sH : strArr) {
                    long sH2 = a.sH(sH);
                    ak.yW();
                    ab eg = c.wH().eg(sH2);
                    if (eg != null && ((int) eg.chr) > 0) {
                        ak.yW();
                        int fv2 = c.wK().fv(" and ( rconversation.username='" + eg.field_username + "' );");
                        matrixCursor.addRow(new Object[]{Long.valueOf(sH2), Integer.valueOf(fv2)});
                    }
                }
            }
            kB(0);
            return matrixCursor;
        } catch (Throwable e) {
            v.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
            v.a("MicroMsg.ExtControlProviderMsg", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            matrixCursor.close();
            kB(4);
            return null;
        }
    }

    private Cursor a(String[] strArr, String str, String str2) {
        Throwable e;
        v.i("MicroMsg.ExtControlProviderMsg", "getUnReadMsgs() ");
        v.d("MicroMsg.ExtControlProviderMsg", "getUnReadMsgs(), %s, %s", str, str2);
        if (strArr == null || strArr.length <= 0) {
            v.e("MicroMsg.ExtControlProviderMsg", "wrong args");
            bB(3, 3701);
            return ExtContentProviderBase.kC(3701);
        } else if (be.kS(str)) {
            v.e("MicroMsg.ExtControlProviderMsg", "callSource == null");
            bB(3, 3702);
            return ExtContentProviderBase.kC(3702);
        } else if (be.kS(str2)) {
            v.e("MicroMsg.ExtControlProviderMsg", "countStr == null");
            bB(3, 3703);
            return ExtContentProviderBase.kC(3703);
        } else {
            ab LX;
            MatrixCursor matrixCursor;
            boolean z = str != null && str.equalsIgnoreCase("openapi");
            if (z) {
                try {
                    bc Ny = b.akN().Ny(strArr[0]);
                    if (Ny == null || be.kS(Ny.field_openId) || be.kS(Ny.field_username)) {
                        v.e("MicroMsg.ExtControlProviderMsg", "openidInApp is null");
                        bB(3, 3704);
                        return ExtContentProviderBase.kC(3704);
                    }
                    ak.yW();
                    LX = c.wH().LX(Ny.field_username);
                } catch (Exception e2) {
                    e = e2;
                    matrixCursor = null;
                    v.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
                    v.a("MicroMsg.ExtControlProviderMsg", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                    if (matrixCursor != null) {
                        matrixCursor.close();
                    }
                    z(3, 4, 12);
                    return ExtContentProviderBase.kC(12);
                }
            }
            long sH = a.sH(strArr[0]);
            ak.yW();
            LX = c.wH().eg(sH);
            if (LX == null || LX.field_username == null || LX.field_username.length() <= 0) {
                v.e("MicroMsg.ExtControlProviderMsg", "contact is null");
                bB(3, 3705);
                return ExtContentProviderBase.kC(3705);
            }
            boolean z2;
            Cursor bR;
            String tU = LX.tU();
            if (LX.field_username.endsWith("@chatroom")) {
                tU = l.er(LX.field_username);
                z2 = true;
            } else {
                z2 = false;
            }
            if (z) {
                int i;
                try {
                    i = be.getInt(str2, 0);
                } catch (Exception e3) {
                    v.e("MicroMsg.ExtControlProviderMsg", "exception in parseInt(%s)", str2);
                    i = 0;
                }
                if (i <= 0 || i >= 15) {
                    ak.yW();
                    bR = c.wJ().bR(LX.field_username, 15);
                } else {
                    ak.yW();
                    bR = c.wJ().bR(LX.field_username, i);
                }
            } else {
                ak.yW();
                bR = c.wJ().bR(LX.field_username, 3);
            }
            if (bR == null) {
                v.e("MicroMsg.ExtControlProviderMsg", "msgCursor == null");
                z(3, 4, 3706);
                return ExtContentProviderBase.kC(3706);
            }
            matrixCursor = new MatrixCursor(fHq);
            try {
                if (bR.getCount() <= 0 || !bR.moveToFirst()) {
                    bR.close();
                    z(2, 0, 1);
                    return matrixCursor;
                }
                at atVar = new at();
                do {
                    atVar.b(bR);
                    a(matrixCursor, atVar, LX, z2, tU, z, strArr[0]);
                } while (bR.moveToNext());
                bR.close();
                z(2, 0, 1);
                return matrixCursor;
            } catch (Exception e4) {
                e = e4;
                v.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
                v.a("MicroMsg.ExtControlProviderMsg", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                if (matrixCursor != null) {
                    matrixCursor.close();
                }
                z(3, 4, 12);
                return ExtContentProviderBase.kC(12);
            }
        }
    }

    private Cursor ala() {
        v.d("MicroMsg.ExtControlProviderMsg", "getUnReadUserList()");
        MatrixCursor matrixCursor = new MatrixCursor(fHs);
        try {
            ak.yW();
            Cursor query = c.wJ().cuX.query("message", new String[]{"talker", "count(*) as unReadCount"}, "isSend=? AND status!=?", new String[]{"0", "4"}, "talker", null, null);
            if (query != null) {
                if (query.moveToFirst()) {
                    do {
                        String string = query.getString(query.getColumnIndex("talker"));
                        ak.yW();
                        ab LX = c.wH().LX(string);
                        if (!m.dE(string)) {
                            int i = (m.fn(LX.field_username) || m.fl(LX.field_username) || u.vd(LX.field_verifyFlag) || m.fc(LX.field_username) || m.fd(LX.field_username)) ? 0 : 1;
                            if (i == 0) {
                                long j = (long) ((int) LX.chr);
                                matrixCursor.addRow(new Object[]{a.bv(j), Integer.valueOf(query.getInt(query.getColumnIndex("unReadCount")))});
                            }
                        }
                    } while (query.moveToNext());
                }
                query.close();
            }
            kB(0);
            return matrixCursor;
        } catch (Throwable e) {
            v.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
            v.a("MicroMsg.ExtControlProviderMsg", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            matrixCursor.close();
            kB(4);
            return null;
        }
    }

    private Cursor b(String[] strArr, String str) {
        MatrixCursor matrixCursor;
        Throwable e;
        boolean z = true;
        v.d("MicroMsg.ExtControlProviderMsg", "getOneMsg()");
        if (strArr == null || strArr.length <= 0) {
            v.e("MicroMsg.ExtControlProviderMsg", "wrong args");
            kB(3);
            return null;
        }
        try {
            long sH = a.sH(strArr[0]);
            ak.yW();
            bx ek = c.wJ().ek(sH);
            ak.yW();
            ab LX = c.wH().LX(ek.field_talker);
            if (LX == null || ((int) LX.chr) <= 0) {
                kB(3);
                return null;
            }
            boolean z2;
            String tU = LX.tU();
            if (LX.field_username.endsWith("@chatroom")) {
                tU = l.er(LX.field_username);
                z2 = true;
            } else {
                z2 = false;
            }
            if (str == null || !str.equalsIgnoreCase("openapi")) {
                z = false;
            }
            matrixCursor = new MatrixCursor(fHq);
            try {
                a(matrixCursor, ek, LX, z2, tU, z, strArr[0]);
                kB(0);
                return matrixCursor;
            } catch (Exception e2) {
                e = e2;
                v.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
                v.a("MicroMsg.ExtControlProviderMsg", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                if (matrixCursor != null) {
                    matrixCursor.close();
                }
                kB(4);
                return null;
            }
        } catch (Exception e3) {
            e = e3;
            matrixCursor = null;
            v.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
            v.a("MicroMsg.ExtControlProviderMsg", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            if (matrixCursor != null) {
                matrixCursor.close();
            }
            kB(4);
            return null;
        }
    }

    private Cursor m(String[] strArr) {
        Cursor cursor = null;
        v.d("MicroMsg.ExtControlProviderMsg", "handleRecordMsg()");
        if (strArr == null || strArr.length < 2) {
            v.w("MicroMsg.ExtControlProviderMsg", "wrong args");
            kB(3);
        } else {
            try {
                final int intValue = Integer.valueOf(strArr[0]).intValue();
                final long sH = a.sH(strArr[1]);
                if (sH <= 0) {
                    kB(3);
                } else {
                    final com.tencent.mm.pluginsdk.e.a.a aVar = new com.tencent.mm.pluginsdk.e.a.a();
                    final String[] strArr2 = strArr;
                    aVar.b(4000, new Runnable(this) {
                        final /* synthetic */ ExtControlProviderMsg fHz;

                        public final void run() {
                            if (intValue == 1) {
                                b.akK();
                                ab bt = b.bt(sH);
                                if (bt == null || ((int) bt.chr) <= 0) {
                                    this.fHz.kB(3);
                                    aVar.countDown();
                                    return;
                                }
                                com.tencent.mm.sdk.c.b eiVar = new ei();
                                eiVar.bcK.op = 1;
                                eiVar.bcK.username = bt.field_username;
                                if (com.tencent.mm.sdk.c.a.nhr.z(eiVar)) {
                                    this.fHz.fHw = new MatrixCursor(ExtControlProviderMsg.fHt);
                                    if (bt == null || ((int) bt.chr) <= 0 || !eiVar.bcL.aYN) {
                                        this.fHz.fHw.addRow(new Object[]{strArr2[1], Integer.valueOf(2), "0"});
                                        this.fHz.kB(3);
                                    } else {
                                        this.fHz.fHw.addRow(new Object[]{strArr2[1], Integer.valueOf(1), "0"});
                                        this.fHz.kB(0);
                                    }
                                    v.d("MicroMsg.ExtControlProviderMsg", "start record, ret=[%s], fileName=[%s]", Boolean.valueOf(eiVar.bcL.aYN), eiVar.bcL.aST);
                                } else {
                                    this.fHz.kB(4);
                                    aVar.countDown();
                                    return;
                                }
                            } else if (intValue == 2) {
                                com.tencent.mm.sdk.c.b eiVar2 = new ei();
                                eiVar2.bcK.op = 2;
                                if (com.tencent.mm.sdk.c.a.nhr.z(eiVar2)) {
                                    String str = eiVar2.bcL.aST;
                                    this.fHz.fHw = new MatrixCursor(ExtControlProviderMsg.fHt);
                                    com.tencent.mm.sdk.c.b eoVar = new eo();
                                    eoVar.bdh.aST = str;
                                    if (com.tencent.mm.sdk.c.a.nhr.z(eoVar)) {
                                        v.d("MicroMsg.ExtControlProviderMsg", "stop record, msgId=[%s]", Long.valueOf(eoVar.bdi.bao));
                                        if (eoVar.bdi.bao > 0) {
                                            try {
                                                if (!eiVar2.bcL.aYN) {
                                                    this.fHz.fHw.addRow(new Object[]{strArr2[1], Integer.valueOf(4), a.bv(r2)});
                                                    this.fHz.kB(4);
                                                } else if (aa.getContext() == null || !com.tencent.mm.sdk.platformtools.ak.isConnected(aa.getContext())) {
                                                    this.fHz.fHw.addRow(new Object[]{strArr2[1], Integer.valueOf(6), a.bv(r2)});
                                                    this.fHz.kB(4);
                                                } else {
                                                    this.fHz.fHw.addRow(new Object[]{strArr2[1], Integer.valueOf(1), a.bv(r2)});
                                                    this.fHz.kB(0);
                                                }
                                            } catch (Throwable e) {
                                                v.w("MicroMsg.ExtControlProviderMsg", e.getMessage());
                                                v.a("MicroMsg.ExtControlProviderMsg", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                                                this.fHz.kB(4);
                                            }
                                        } else {
                                            this.fHz.kB(3);
                                        }
                                    } else {
                                        this.fHz.kB(4);
                                        this.fHz.fHw.close();
                                        aVar.countDown();
                                        return;
                                    }
                                }
                                this.fHz.kB(4);
                                aVar.countDown();
                                return;
                            }
                            aVar.countDown();
                        }
                    });
                    cursor = this.fHw;
                }
            } catch (Throwable e) {
                v.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
                v.a("MicroMsg.ExtControlProviderMsg", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                if (this.fHw != null) {
                    this.fHw.close();
                }
                kB(4);
            }
        }
        return cursor;
    }

    private Cursor n(String[] strArr) {
        MatrixCursor matrixCursor;
        Throwable th;
        v.d("MicroMsg.ExtControlProviderMsg", "handlePlayVoice()");
        if (strArr == null || strArr.length < 2) {
            v.e("MicroMsg.ExtControlProviderMsg", "wrong args");
            kB(3);
            return null;
        }
        try {
            int intValue = Integer.valueOf(strArr[0]).intValue();
            long sH = a.sH(strArr[1]);
            if (sH <= 0) {
                kB(3);
                return null;
            } else if (intValue == 3) {
                MatrixCursor matrixCursor2 = new MatrixCursor(fHu);
                try {
                    com.tencent.mm.sdk.c.b epVar = new ep();
                    epVar.bdj.bao = sH;
                    com.tencent.mm.sdk.c.a.nhr.z(epVar);
                    if (epVar.bdk.aST == null || epVar.bdk.aST.length() <= 0) {
                        matrixCursor2.addRow(new Object[]{strArr[1], Integer.valueOf(2)});
                        kB(4);
                        return matrixCursor2;
                    }
                    com.tencent.mm.sdk.c.b ehVar = new eh();
                    ehVar.bcF.op = 1;
                    ehVar.bcF.aST = epVar.bdk.aST;
                    if (com.tencent.mm.sdk.c.a.nhr.z(ehVar)) {
                        matrixCursor2.addRow(new Object[]{strArr[1], Integer.valueOf(1)});
                        kB(0);
                    } else {
                        v.e("MicroMsg.ExtControlProviderMsg", "play failed");
                        matrixCursor2.addRow(new Object[]{strArr[1], Integer.valueOf(2)});
                        kB(4);
                    }
                    b.akK();
                    b.bu(sH);
                    return matrixCursor2;
                } catch (Throwable e) {
                    Throwable th2 = e;
                    matrixCursor = matrixCursor2;
                    th = th2;
                    v.e("MicroMsg.ExtControlProviderMsg", th.getMessage());
                    v.a("MicroMsg.ExtControlProviderMsg", th, SQLiteDatabase.KeyEmpty, new Object[0]);
                    if (matrixCursor != null) {
                        matrixCursor.close();
                    }
                    kB(4);
                    return null;
                }
            } else if (intValue != 4) {
                return null;
            } else {
                com.tencent.mm.sdk.c.b ehVar2 = new eh();
                ehVar2.bcF.op = 2;
                if (com.tencent.mm.sdk.c.a.nhr.z(ehVar2)) {
                    v.i("MicroMsg.ExtControlProviderMsg", "stop last playing");
                    kB(0);
                    return null;
                }
                v.i("MicroMsg.ExtControlProviderMsg", "stop last playing fail");
                kB(4);
                return null;
            }
        } catch (Exception e2) {
            th = e2;
            matrixCursor = null;
            v.e("MicroMsg.ExtControlProviderMsg", th.getMessage());
            v.a("MicroMsg.ExtControlProviderMsg", th, SQLiteDatabase.KeyEmpty, new Object[0]);
            if (matrixCursor != null) {
                matrixCursor.close();
            }
            kB(4);
            return null;
        }
    }

    private Cursor o(String[] strArr) {
        v.i("MicroMsg.ExtControlProviderMsg", "setMsgReaded()");
        if (strArr == null || strArr.length <= 0) {
            v.e("MicroMsg.ExtControlProviderMsg", "wrong args");
            bB(3, 3801);
            return ExtContentProviderBase.kC(3801);
        }
        int i = 0;
        while (i < strArr.length) {
            try {
                if (strArr[i] == null || strArr[i].length() <= 0) {
                    v.w("MicroMsg.ExtControlProviderMsg", "setMsgReaded() wrongArgs i = " + i);
                } else {
                    long sH = a.sH(strArr[i]);
                    b.akK();
                    b.bu(sH);
                }
                i++;
            } catch (Throwable e) {
                v.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
                v.a("MicroMsg.ExtControlProviderMsg", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                bB(4, 12);
                return ExtContentProviderBase.kC(12);
            }
        }
        bB(0, 1);
        return ExtContentProviderBase.kC(1);
    }

    private Cursor p(final String[] strArr) {
        v.d("MicroMsg.ExtControlProviderMsg", "sendTextMsg()");
        if (strArr == null || strArr.length <= 0) {
            v.e("MicroMsg.ExtControlProviderMsg", "wrong args");
            kB(3);
            return null;
        }
        try {
            long sH = a.sH(strArr[0]);
            if (sH <= 0) {
                kB(3);
                return null;
            }
            b.akK();
            final com.tencent.mm.i.a bt = b.bt(sH);
            if (bt == null || ((int) bt.chr) <= 0) {
                v.e("MicroMsg.ExtControlProviderMsg", "toContact is null ");
                kB(3);
                return null;
            }
            this.fHw = new MatrixCursor(fHv);
            final com.tencent.mm.pluginsdk.e.a.a aVar = new com.tencent.mm.pluginsdk.e.a.a();
            aVar.b(15000, new Runnable(this) {
                final /* synthetic */ ExtControlProviderMsg fHz;

                public final void run() {
                    com.tencent.mm.sdk.c.b efVar = new ef();
                    efVar.bcz.bcB = bt.field_username;
                    efVar.bcz.content = strArr[1];
                    efVar.bcz.type = m.fp(bt.field_username);
                    efVar.bcz.flags = 0;
                    if (com.tencent.mm.sdk.c.a.nhr.z(efVar)) {
                        k kVar = efVar.bcA.bcC;
                        try {
                            final String bv = a.bv(efVar.bcA.bao);
                            ak.vy().a(522, new e(this) {
                                final /* synthetic */ AnonymousClass2 fHC;

                                /* JADX WARNING: inconsistent code. */
                                /* Code decompiled incorrectly, please refer to instructions dump. */
                                public final void a(int r10, int r11, java.lang.String r12, com.tencent.mm.v.k r13) {
                                    /*
                                    r9 = this;
                                    r8 = 522; // 0x20a float:7.31E-43 double:2.58E-321;
                                    r7 = 4;
                                    r6 = 2;
                                    r5 = 1;
                                    r4 = 0;
                                    r0 = "MicroMsg.ExtControlProviderMsg";
                                    r1 = "onSceneEnd errType=%s, errCode=%s";
                                    r2 = new java.lang.Object[r6];
                                    r3 = java.lang.Integer.valueOf(r10);
                                    r2[r4] = r3;
                                    r3 = java.lang.Integer.valueOf(r11);
                                    r2[r5] = r3;
                                    com.tencent.mm.sdk.platformtools.v.d(r0, r1, r2);
                                    if (r13 != 0) goto L_0x003e;
                                L_0x001f:
                                    r0 = "MicroMsg.ExtControlProviderMsg";
                                    r1 = "scene == null";
                                    com.tencent.mm.sdk.platformtools.v.e(r0, r1);
                                    r0 = com.tencent.mm.model.ak.vy();
                                    r0.b(r8, r9);
                                    r0 = r9.fHC;
                                    r0 = r0.fHz;
                                    r0.kB(r7);
                                    r0 = r9.fHC;
                                    r0 = r2;
                                    r0.countDown();
                                L_0x003d:
                                    return;
                                L_0x003e:
                                    r0 = r13.getType();
                                    switch(r0) {
                                        case 522: goto L_0x005b;
                                        default: goto L_0x0045;
                                    };
                                L_0x0045:
                                    r0 = r9.fHC;
                                    r0 = r0.fHz;
                                    r0.kB(r4);
                                L_0x004c:
                                    r0 = r9.fHC;
                                    r0 = r2;
                                    r0.countDown();
                                    r0 = com.tencent.mm.model.ak.vy();
                                    r0.b(r8, r9);
                                    goto L_0x003d;
                                L_0x005b:
                                    if (r10 != 0) goto L_0x0080;
                                L_0x005d:
                                    if (r11 != 0) goto L_0x0080;
                                L_0x005f:
                                    r0 = "MicroMsg.ExtControlProviderMsg";
                                    r1 = "rtSENDMSG onSceneEnd ok, ";
                                    com.tencent.mm.sdk.platformtools.v.d(r0, r1);
                                    r0 = r9.fHC;
                                    r0 = r0.fHz;
                                    r0 = r0.fHw;
                                    r1 = new java.lang.Object[r6];
                                    r2 = r0;
                                    r1[r4] = r2;
                                    r2 = java.lang.Integer.valueOf(r5);
                                    r1[r5] = r2;
                                    r0.addRow(r1);
                                    goto L_0x0045;
                                L_0x0080:
                                    r0 = "MicroMsg.ExtControlProviderMsg";
                                    r1 = new java.lang.StringBuilder;
                                    r2 = "rtSENDMSG onSceneEnd err, errType = ";
                                    r1.<init>(r2);
                                    r1 = r1.append(r10);
                                    r2 = ", errCode = ";
                                    r1 = r1.append(r2);
                                    r1 = r1.append(r11);
                                    r1 = r1.toString();
                                    com.tencent.mm.sdk.platformtools.v.e(r0, r1);
                                    r0 = r9.fHC;
                                    r0 = r0.fHz;
                                    r0 = r0.fHw;
                                    r1 = new java.lang.Object[r6];
                                    r2 = r0;
                                    r1[r4] = r2;
                                    r2 = java.lang.Integer.valueOf(r6);
                                    r1[r5] = r2;
                                    r0.addRow(r1);
                                    r0 = r9.fHC;
                                    r0 = r0.fHz;
                                    r0.kB(r7);
                                    goto L_0x004c;
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ext.provider.ExtControlProviderMsg.2.1.a(int, int, java.lang.String, com.tencent.mm.v.k):void");
                                }
                            });
                            ak.vy().a(kVar, 0);
                            return;
                        } catch (Throwable e) {
                            v.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
                            v.a("MicroMsg.ExtControlProviderMsg", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                            this.fHz.kB(4);
                            aVar.countDown();
                            return;
                        }
                    }
                    this.fHz.kB(4);
                    aVar.countDown();
                }
            });
            return this.fHw;
        } catch (Throwable e) {
            v.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
            v.a("MicroMsg.ExtControlProviderMsg", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            if (this.fHw != null) {
                this.fHw.close();
            }
            kB(4);
            return null;
        }
    }

    private void a(MatrixCursor matrixCursor, at atVar, u uVar, boolean z, String str, boolean z2, String str2) {
        if (atVar != null) {
            if (be.kS(str2)) {
                v.d("MicroMsg.ExtControlProviderMsg", "userOpenId is null");
            } else if (atVar.field_type != 9999 && atVar.field_type != 10000) {
                String str3 = SQLiteDatabase.KeyEmpty;
                String str4 = SQLiteDatabase.KeyEmpty;
                if (z) {
                    int fK = aw.fK(atVar.field_content);
                    if (fK != -1 && atVar.field_content.length() > fK) {
                        String trim = atVar.field_content.substring(0, fK).trim();
                        if (trim != null && trim.length() > 0 && atVar.field_content.length() >= fK + 2) {
                            str3 = l.er(trim);
                            str4 = atVar.field_content.substring(fK + 2);
                        }
                    }
                }
                String str5 = SQLiteDatabase.KeyEmpty;
                int D = com.tencent.mm.plugin.ext.b.b.D(atVar);
                if (D == 1) {
                    if (z) {
                        str3 = str3 + "!]" + str4;
                    } else {
                        str3 = atVar.field_content;
                    }
                } else if (D == 2) {
                    p gx = com.tencent.mm.modelvoice.m.Lz().gx((int) atVar.field_msgId);
                    if (gx == null || gx.aST == null) {
                        str4 = str5;
                    } else {
                        str4 = q.iU(gx.aST);
                        v.d("MicroMsg.ExtControlProviderMsg", "voice file = %s", str4);
                    }
                    str3 = str4;
                } else if (!z) {
                    if (this.fHp != null) {
                        str3 = this.fHp.getString(2131232600);
                    } else {
                        str3 = SQLiteDatabase.KeyEmpty;
                    }
                }
                if (!z2) {
                    str2 = a.bv((long) ((int) uVar.chr));
                }
                try {
                    if (be.kS(str2)) {
                        v.w("MicroMsg.ExtControlProviderMsg", "userId is null");
                        return;
                    }
                    Object[] objArr = new Object[8];
                    objArr[0] = a.bv(atVar.field_msgId);
                    objArr[1] = str2;
                    objArr[2] = str;
                    objArr[3] = Integer.valueOf(atVar.field_isSend == 0 ? 1 : 2);
                    objArr[4] = Integer.valueOf(D);
                    objArr[5] = str3;
                    objArr[6] = Integer.valueOf(atVar.field_status == 4 ? 1 : 2);
                    objArr[7] = Long.valueOf(atVar.field_createTime);
                    matrixCursor.addRow(objArr);
                } catch (Throwable e) {
                    v.e("MicroMsg.ExtControlProviderMsg", e.getMessage());
                    v.a("MicroMsg.ExtControlProviderMsg", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                }
            }
        }
    }
}
