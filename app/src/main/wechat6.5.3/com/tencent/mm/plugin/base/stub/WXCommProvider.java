package com.tencent.mm.plugin.base.stub;

import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Looper;
import android.os.Process;
import android.support.v7.a.a.k;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.ay.c;
import com.tencent.mm.e.a.av;
import com.tencent.mm.e.a.bk;
import com.tencent.mm.e.a.dz;
import com.tencent.mm.e.a.ea;
import com.tencent.mm.e.a.eg;
import com.tencent.mm.e.a.mc;
import com.tencent.mm.e.a.md;
import com.tencent.mm.e.a.qu;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.ay;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.d;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.PROVIDERCHECK})
public class WXCommProvider extends ContentProvider {
    public static final String PREF_NAME = (aa.getPackageName() + "_comm_preferences");
    private static final UriMatcher enA = new UriMatcher(-1);
    protected static boolean enB = false;
    private static final String[] eny = new String[]{"packageName", "data"};
    public static Object lock = new Object();
    private SharedPreferences cnm;
    protected MatrixCursor enz = new MatrixCursor(new String[0]);
    private ac handler;

    static {
        enA.addURI("com.tencent.mm.sdk.comm.provider", "pref", 1);
        enA.addURI("com.tencent.mm.sdk.comm.provider", "openQRCodeScan", 18);
        enA.addURI("com.tencent.mm.sdk.comm.provider", "batchAddShortcut", 19);
        enA.addURI("com.tencent.mm.sdk.comm.provider", "getUnreadCount", 20);
        enA.addURI("com.tencent.mm.sdk.comm.provider", "jumpToBizProfile", 21);
        enA.addURI("com.tencent.mm.sdk.comm.provider", "jumpToBizTempSession", 27);
        enA.addURI("com.tencent.mm.sdk.comm.provider", "registerMsgListener", 22);
        enA.addURI("com.tencent.mm.sdk.comm.provider", "getAvatar", 23);
        enA.addURI("com.tencent.mm.sdk.comm.provider", "regWatchAppId", 24);
        enA.addURI("com.tencent.mm.sdk.comm.provider", "decodeVoice", 25);
        enA.addURI("com.tencent.mm.sdk.comm.provider", "addCardToWX", 26);
        enA.addURI("com.tencent.mm.sdk.comm.provider", "unReadMsgs", 9);
        enA.addURI("com.tencent.mm.sdk.comm.provider", "to_chatting", 3);
        enA.addURI("com.tencent.mm.sdk.comm.provider", "setReaded", 13);
        enA.addURI("com.tencent.mm.sdk.comm.provider", "voiceControl", 29);
        enA.addURI("com.tencent.mm.sdk.comm.provider", "openRankList", 28);
        enA.addURI("com.tencent.mm.sdk.comm.provider", "openWebview", 30);
        enA.addURI("com.tencent.mm.sdk.comm.provider", "openBusiLuckyMoney", 31);
        enA.addURI("com.tencent.mm.sdk.comm.provider", "createChatroom", 32);
        enA.addURI("com.tencent.mm.sdk.comm.provider", "joinChatroom", 33);
        enA.addURI("com.tencent.mm.sdk.comm.provider", "sendSight", 34);
        enA.addURI("com.tencent.mm.sdk.comm.provider", "redirectToChattingByPhoneNumber", 35);
        enA.addURI("com.tencent.mm.sdk.comm.provider", "redirectToWechatOutByPhoneNumber", 36);
        enA.addURI("com.tencent.mm.sdk.comm.provider", "getWifiList", 37);
        enA.addURI("com.tencent.mm.sdk.comm.provider", "connectWifi", 38);
        enA.addURI("com.tencent.mm.sdk.comm.provider", "chooseCardFromWX", 39);
        enA.addURI("com.tencent.mm.sdk.comm.provider", "openOfflinePay", 42);
        enA.addURI("com.tencent.mm.sdk.comm.provider", "setWechatSportStep", 40);
        enA.addURI("com.tencent.mm.sdk.comm.provider", "getWechatSportConfig", 41);
    }

    public boolean onCreate() {
        v.d("MicroMsg.WXCommProvider", "onCreate");
        this.handler = new ac();
        v.i("MicroMsg.WXCommProvider", "pid = " + Process.myPid() + ", tid : = " + Process.myTid());
        this.cnm = getContext().getSharedPreferences(PREF_NAME, 0);
        getContext().registerReceiver(new BroadcastReceiver(this) {
            final /* synthetic */ WXCommProvider enC;

            {
                this.enC = r1;
            }

            public final void onReceive(Context context, Intent intent) {
                ao aoVar;
                if (System.currentTimeMillis() - ao.lBL >= 600000) {
                    v.e("MicroMsg.AppUtil", "hy: get comm model time expired");
                    aoVar = null;
                } else {
                    aoVar = ao.lBK;
                }
                if (aoVar != null) {
                    v.i("MicroMsg.WXCommProvider", "hy: has wxcomm query request. start to continue requesting");
                    this.enC.a(aoVar.uri, aoVar.projection, aoVar.selection, aoVar.selectionArgs, aoVar.lBI, aoVar.aJW, aoVar.lBJ);
                    p.bnu();
                }
            }
        }, new IntentFilter("com.tencent.mm.plugin.openapi.Intent.ACTION_REFRESH_WXAPP"));
        if (this.cnm != null) {
            return true;
        }
        return false;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        v.i("MicroMsg.WXCommProvider", "uri:%s", uri);
        if (uri == null) {
            v.e("MicroMsg.WXCommProvider", "query fail, uri is null return null");
            return null;
        }
        String[] WL = WL();
        if (WL == null || WL.length <= 0) {
            v.e("MicroMsg.WXCommProvider", "CallingPackages is null return null");
            return null;
        }
        int match = enA.match(uri);
        if (a.nhr == null) {
            new ah(Looper.getMainLooper(), new ah.a(this) {
                final /* synthetic */ WXCommProvider enC;

                {
                    this.enC = r1;
                }

                public final boolean oU() {
                    if (a.nhr == null || !a.nhr.m(dz.class)) {
                        return true;
                    }
                    synchronized (WXCommProvider.lock) {
                        v.i("MicroMsg.WXCommProvider", "The lock was released.");
                        WXCommProvider.lock.notifyAll();
                    }
                    return false;
                }
            }, true).ea(50);
            try {
                synchronized (lock) {
                    v.i("MicroMsg.WXCommProvider", "Lock to wait for the first initialize of the Application.");
                    lock.wait();
                }
            } catch (Throwable e) {
                v.e("MicroMsg.WXCommProvider", "the lock may have some problem," + e.getMessage());
                v.a("MicroMsg.WXCommProvider", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            }
        }
        return a(uri, strArr, str, strArr2, str2, match, WL);
    }

    public final Cursor a(Uri uri, String[] strArr, String str, String[] strArr2, String str2, int i, String[] strArr3) {
        Cursor matrixCursor;
        b eaVar;
        switch (i) {
            case 3:
            case 9:
            case 13:
            case k.MM /*22*/:
            case k.Nb /*23*/:
            case 25:
            case 29:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 40:
            case 41:
            case 42:
                long currentTimeMillis = System.currentTimeMillis();
                if (WN()) {
                    b egVar = new eg();
                    egVar.bcD.bbX = i;
                    egVar.bcD.uri = uri;
                    egVar.bcD.selectionArgs = strArr2;
                    egVar.bcD.context = getContext();
                    egVar.bcD.aWv = strArr3;
                    if (a.nhr.z(egVar)) {
                        v.i("MicroMsg.WXCommProvider", "[extApiCost] total cost = %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        return egVar.bcE.bbY;
                    }
                    v.e("MicroMsg.WXCommProvider", "ExtCallEvent fail return code = 8");
                    matrixCursor = new MatrixCursor(com.tencent.mm.protocal.b.fGL);
                    matrixCursor.addRow(new Object[]{Integer.valueOf(8)});
                    return matrixCursor;
                }
                String ma = be.ma(uri.getQueryParameter("appid"));
                if ("1".equals(be.ah(uri.getQueryParameter("autoLogin"), "0"))) {
                    v.i("MicroMsg.WXCommProvider", "hy: not login. try to login return code = 9");
                    ao.lBK = new ao(uri, strArr, str, strArr2, str2, i, strArr3);
                    ao.lBL = System.currentTimeMillis();
                    c.b(getContext(), "accountsync", "com.tencent.mm.ui.account.LoginUI", null);
                    matrixCursor = new MatrixCursor(com.tencent.mm.protocal.b.fGL);
                    matrixCursor.addRow(new Object[]{Integer.valueOf(9)});
                    return matrixCursor;
                }
                v.i("MicroMsg.WXCommProvider", "not login, appID = %s, apiID = %s return code =%s ", ma, Integer.valueOf(i), Integer.valueOf(3));
                g.iuh.h(10505, be.ma(strArr3[0]), ma, Integer.valueOf(i), Integer.valueOf(1), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                matrixCursor = new MatrixCursor(com.tencent.mm.protocal.b.fGL);
                matrixCursor.addRow(new Object[]{Integer.valueOf(3)});
                return matrixCursor;
            case k.MG /*18*/:
            case 19:
            case 20:
                if (!WM()) {
                    return null;
                }
                eaVar = new ea();
                eaVar.bbV.bbX = i;
                eaVar.bbV.uri = uri;
                eaVar.bbV.selectionArgs = strArr2;
                eaVar.bbV.context = getContext();
                eaVar.bbV.aWv = strArr3;
                if (a.nhr.z(eaVar)) {
                    return eaVar.bbW.bbY;
                }
                v.e("MicroMsg.WXCommProvider", "ExtCallEvent fail");
                return null;
            case 21:
                eaVar = new dz();
                eaVar.bbS.op = 21;
                eaVar.bbS.bbT = 1;
                eaVar.bbS.selectionArgs = strArr2;
                eaVar.bbS.context = getContext();
                eaVar.bbS.aWv = strArr3;
                if (!a.nhr.z(eaVar)) {
                    v.e("MicroMsg.WXCommProvider", "ExtCallBizEvent fail");
                }
                return null;
            case 24:
                if (!WM()) {
                    return this.enz;
                }
                b quVar = new qu();
                quVar.bsn.bbX = i;
                quVar.bsn.uri = uri;
                quVar.bsn.context = getContext();
                for (int i2 = 0; i2 < strArr3.length; i2++) {
                    if (strArr3[i2] != null) {
                        quVar.bsn.bsp = strArr3[i2];
                        if (!a.nhr.z(quVar)) {
                            return quVar.bso.bbY;
                        }
                        v.e("MicroMsg.WXCommProvider", "WatchAppIdRegEvent fail");
                        return null;
                    }
                }
                if (!a.nhr.z(quVar)) {
                    return quVar.bso.bbY;
                }
                v.e("MicroMsg.WXCommProvider", "WatchAppIdRegEvent fail");
                return null;
            case k.Kr /*26*/:
                eaVar = new com.tencent.mm.e.a.g();
                eaVar.aWu.selectionArgs = strArr2;
                eaVar.aWu.aWv = strArr3;
                eaVar.aWu.context = getContext();
                if (!a.nhr.z(eaVar)) {
                    v.e("MicroMsg.WXCommProvider", "add card to wx fail");
                }
                return null;
            case 27:
                if (strArr2 == null || strArr2.length < 2) {
                    v.e("MicroMsg.WXCommProvider", "wrong args");
                    return null;
                }
                eaVar = new dz();
                eaVar.bbS.op = 27;
                eaVar.bbS.bbT = 1;
                eaVar.bbS.selectionArgs = strArr2;
                eaVar.bbS.context = getContext();
                eaVar.bbS.aWv = strArr3;
                if (!a.nhr.z(eaVar)) {
                    v.e("MicroMsg.WXCommProvider", "ExtCallBizEvent fail");
                }
                return null;
            case 28:
                eaVar = new dz();
                eaVar.bbS.op = i;
                eaVar.bbS.selectionArgs = strArr2;
                eaVar.bbS.context = getContext();
                eaVar.bbS.aWv = strArr3;
                if (!a.nhr.z(eaVar)) {
                    v.e("MicroMsg.WXCommProvider", "ExtCallBizEvent fail");
                }
                return null;
            case 30:
                eaVar = new md();
                eaVar.bnl.selectionArgs = strArr2;
                eaVar.bnl.aWv = strArr3;
                eaVar.bnl.context = getContext();
                if (strArr2 != null && strArr2.length > 2) {
                    d.lxz = strArr2[2];
                }
                if (!a.nhr.z(eaVar)) {
                    v.e("MicroMsg.WXCommProvider", "open webview fail");
                }
                return null;
            case 31:
                eaVar = new mc();
                eaVar.bnk.selectionArgs = strArr2;
                eaVar.bnk.aWv = strArr3;
                eaVar.bnk.context = getContext();
                if (!a.nhr.z(eaVar)) {
                    v.e("MicroMsg.WXCommProvider", "open busi luckymoney fail");
                }
                return null;
            case FileUtils.S_IRGRP /*32*/:
                eaVar = new bk();
                eaVar.aYT.action = 1;
                eaVar.aYT.selectionArgs = strArr2;
                eaVar.aYT.aWv = strArr3;
                eaVar.aYT.context = getContext();
                if (!a.nhr.z(eaVar)) {
                    v.e("MicroMsg.WXCommProvider", "open webview fail");
                }
                return null;
            case 33:
                eaVar = new bk();
                eaVar.aYT.action = 2;
                eaVar.aYT.selectionArgs = strArr2;
                eaVar.aYT.aWv = strArr3;
                eaVar.aYT.context = getContext();
                if (!a.nhr.z(eaVar)) {
                    v.e("MicroMsg.WXCommProvider", "open webview fail");
                }
                return null;
            case 39:
                eaVar = new av();
                eaVar.aYC.selectionArgs = strArr2;
                eaVar.aYC.aWv = strArr3;
                eaVar.aYC.context = getContext();
                if (!a.nhr.z(eaVar)) {
                    v.e("MicroMsg.WXCommProvider", "choose card from wx fail");
                }
                return null;
            default:
                final MatrixCursor matrixCursor2 = new MatrixCursor(eny);
                final Uri uri2 = uri;
                final int i3 = i;
                final String[] strArr4 = strArr3;
                matrixCursor = (Cursor) new az<Cursor>(this) {
                    final /* synthetic */ WXCommProvider enC;

                    protected final /* synthetic */ Object run() {
                        v.d("MicroMsg.WXCommProvider", "query, uri = %s, code = %d", uri2.toString(), Integer.valueOf(i3));
                        if (i3 != 1) {
                            v.e("MicroMsg.WXCommProvider", "query fail, invalid code = %d", Integer.valueOf(i3));
                            return null;
                        }
                        for (String string : strArr4) {
                            String string2 = this.enC.cnm.getString(string, SQLiteDatabase.KeyEmpty);
                            matrixCursor2.addRow(new String[]{string, string2});
                        }
                        v.d("MicroMsg.WXCommProvider", "query size = %d", Integer.valueOf(matrixCursor2.getCount()));
                        return matrixCursor2;
                    }
                }.c(this.handler);
                if (matrixCursor != null) {
                    return matrixCursor;
                }
                matrixCursor2.close();
                return matrixCursor;
        }
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        if (uri == null) {
            v.e("MicroMsg.WXCommProvider", "delete fail, uri is null");
            return 0;
        }
        final int match = enA.match(uri);
        final String[] WL = WL();
        final Uri uri2 = uri;
        return ((Integer) new az<Integer>(this, Integer.valueOf(0)) {
            final /* synthetic */ WXCommProvider enC;

            protected final /* synthetic */ Object run() {
                v.d("MicroMsg.WXCommProvider", "delete, uri = %s, code = %d", uri2.toString(), Integer.valueOf(match));
                if (match != 1) {
                    v.e("MicroMsg.WXCommProvider", "delete fail, invalid code = %d", Integer.valueOf(match));
                    return null;
                }
                int i = 0;
                for (String str : WL) {
                    if (!be.kS(str)) {
                        int i2 = (this.enC.cnm.contains(str) && this.enC.cnm.edit().remove(str).commit()) ? 1 : 0;
                        if (i2 != 0) {
                            i++;
                        }
                    }
                }
                v.d("MicroMsg.WXCommProvider", "delete result = %d", Integer.valueOf(i));
                return Integer.valueOf(i);
            }
        }.c(this.handler)).intValue();
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    private String[] WL() {
        try {
            int callingUid = Binder.getCallingUid();
            String[] packagesForUid = getContext().getPackageManager().getPackagesForUid(Binder.getCallingUid());
            String str = "MicroMsg.WXCommProvider";
            String str2 = "getCallingPackages, callingUid = %d, packages size = %d";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(callingUid);
            objArr[1] = Integer.valueOf(packagesForUid == null ? 0 : packagesForUid.length);
            v.i(str, str2, objArr);
            if (packagesForUid == null) {
                v.w("MicroMsg.WXCommProvider", "getCallingPackages fail, packages is null");
                return new String[0];
            }
            int length = packagesForUid.length;
            for (callingUid = 0; callingUid < length; callingUid++) {
                v.i("MicroMsg.WXCommProvider", "getCallingPackages = %s", packagesForUid[callingUid]);
            }
            return packagesForUid;
        } catch (Exception e) {
            v.e("MicroMsg.WXCommProvider", "getCallingPackages, ex = %s", e.getMessage());
            return new String[0];
        }
    }

    private boolean WM() {
        try {
            v.i("MicroMsg.WXCommProvider", "checkIsLogin()");
            if (enB || ((Boolean) new az<Boolean>(this, Boolean.valueOf(false)) {
                final /* synthetic */ WXCommProvider enC;

                protected final /* synthetic */ Object run() {
                    return WO();
                }

                private Boolean WO() {
                    try {
                        v.i("MicroMsg.WXCommProvider", "checkIsLogin run");
                        if (!ak.uz()) {
                            return Boolean.valueOf(false);
                        }
                        v.i("MicroMsg.WXCommProvider", "checkIsLogin doScene");
                        return Boolean.valueOf(ak.vy().a(new ay(new ay.a(this) {
                            final /* synthetic */ AnonymousClass5 enH;

                            {
                                this.enH = r1;
                            }

                            public final void a(e eVar) {
                                v.i("MicroMsg.WXCommProvider", "checkIsLogin onSceneEnd() hasLogin:%s", Boolean.valueOf(WXCommProvider.enB));
                                this.enH.bd(Boolean.valueOf(true));
                            }
                        }), 0));
                    } catch (Exception e) {
                        v.e("MicroMsg.WXCommProvider", "exception in NetSceneLocalProxy.");
                        bd(Boolean.valueOf(false));
                        return Boolean.valueOf(false);
                    }
                }
            }.c(this.handler)).booleanValue()) {
                if (ak.uz() && ak.uN() && !ak.uG()) {
                    enB = true;
                } else {
                    enB = false;
                }
                v.i("MicroMsg.WXCommProvider", "hasLogin = " + enB);
                return enB;
            }
            v.i("MicroMsg.WXCommProvider", "checkIsLogin !syncTaskRet");
            enB = false;
            return false;
        } catch (Throwable e) {
            v.w("MicroMsg.WXCommProvider", e.getMessage());
            v.a("MicroMsg.WXCommProvider", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            return false;
        }
    }

    private boolean WN() {
        try {
            v.i("MicroMsg.WXCommProvider", "checkIsLogin()");
            if (!enB) {
                final com.tencent.mm.pluginsdk.e.a.a aVar = new com.tencent.mm.pluginsdk.e.a.a();
                aVar.b(4000, new Runnable(this) {
                    final /* synthetic */ WXCommProvider enC;

                    public final void run() {
                        try {
                            if (ak.uz()) {
                                ak.vy().a(new ay(new ay.a(this) {
                                    final /* synthetic */ AnonymousClass6 enJ;

                                    {
                                        this.enJ = r1;
                                    }

                                    public final void a(e eVar) {
                                        v.i("MicroMsg.WXCommProvider", "checkIsLogin() onSceneEnd()");
                                        aVar.countDown();
                                    }
                                }), 0);
                            }
                        } catch (Exception e) {
                            v.e("MicroMsg.WXCommProvider", "exception in NetSceneLocalProxy");
                            aVar.countDown();
                        }
                    }
                });
            }
            if (ak.uz() && ak.uN() && !ak.uG()) {
                enB = true;
            } else {
                enB = false;
            }
            v.i("MicroMsg.WXCommProvider", "hasLogin = " + enB);
            return enB;
        } catch (Throwable e) {
            v.w("MicroMsg.WXCommProvider", e.getMessage());
            v.a("MicroMsg.WXCommProvider", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            return false;
        }
    }
}
