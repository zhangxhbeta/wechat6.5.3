package com.tencent.mm.plugin.ext.openapi.provider;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Looper;
import android.support.v7.a.a.k;
import com.tencent.mm.a.e;
import com.tencent.mm.e.a.eb;
import com.tencent.mm.e.a.ee;
import com.tencent.mm.e.a.em;
import com.tencent.mm.e.a.on;
import com.tencent.mm.e.b.ab;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvoice.i;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.plugin.ext.provider.ExtContentProviderBase;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.c;
import com.tencent.mm.pluginsdk.a;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.storage.av;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.bc;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.d;
import com.tencent.mm.u.n;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;

public class ExtControlProviderOpenApi extends ExtContentProviderBase {
    private static final String[] fGS = new String[]{"retCode", "selfId"};
    private static final String[] fGT = new String[]{"retCode", "sportConfig"};
    private static final String[] fGU = new String[]{"openid", "avatar"};
    private static final String[] fGV = new String[]{"voiceType", "sampleRateInHz", "channelConfig", "audioFormat", "filePath"};
    private static final String[] fGW = new String[]{"ssid", "macAddress", "isSupportWechat", "name"};
    private Context context;
    private String[] fGX = null;
    private int fGY = -1;
    private ac handler;

    public ExtControlProviderOpenApi(String[] strArr, int i, Context context) {
        this.fGX = strArr;
        this.fGY = i;
        this.context = context;
    }

    public String getType(Uri uri) {
        return null;
    }

    public boolean onCreate() {
        this.handler = new ac();
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, final String[] strArr2, String str2) {
        v.i("MicroMsg.ExtControlProviderOpenApi", "query(), ApiId = %s", Integer.valueOf(this.fGY));
        a(uri, this.context, this.fGY, this.fGX);
        if (uri == null) {
            v.e("MicroMsg.ExtControlProviderOpenApi", "uri == null return code = 5");
            bB(3, 5);
            return ExtContentProviderBase.kC(5);
        } else if (be.kS(this.fHh)) {
            v.e("MicroMsg.ExtControlProviderOpenApi", "AppID == null return code = 7");
            bB(3, 7);
            return ExtContentProviderBase.kC(7);
        } else if (be.kS(akY())) {
            v.e("MicroMsg.ExtControlProviderOpenApi", "PkgName == null return code = 6");
            bB(3, 6);
            return ExtContentProviderBase.kC(6);
        } else if (WN()) {
            int akZ = akZ();
            if (akZ != 1) {
                v.e("MicroMsg.ExtControlProviderOpenApi", "invalid appid ! return code = " + akZ);
                bB(2, akZ);
                return ExtContentProviderBase.kC(akZ);
            }
            String str3;
            String str4;
            switch (this.fGY) {
                case k.MM /*22*/:
                    return f(uri.getQueryParameter("op"), uri.getQueryParameter("scene"), uri.getQueryParameter("msgType"), uri.getQueryParameter("msgState"));
                case k.Nb /*23*/:
                    return h(strArr2);
                case 25:
                    return i(strArr2);
                case 34:
                    v.i("MicroMsg.ExtControlProviderOpenApi", "sendSight ");
                    if (strArr2 == null || strArr2.length <= 0 || strArr2[0].length() <= 0) {
                        String str5 = "MicroMsg.ExtControlProviderOpenApi";
                        str3 = "sendSight wrong args,args == null:%s";
                        Object[] objArr = new Object[1];
                        objArr[0] = Boolean.valueOf(strArr2 == null);
                        v.e(str5, str3, objArr);
                        bB(3, 3401);
                        return ExtContentProviderBase.kC(3401);
                    }
                    Object obj;
                    str4 = strArr2[0];
                    if (be.kS(str4) || !e.aR(str4)) {
                        obj = null;
                    } else {
                        c cVar = new c();
                        obj = SightVideoJNI.isSightOk(str4, cVar.iTB, cVar.iTC, cVar.iTD, cVar.iTF, cVar.iTE, cVar.iTE.length) == 0 ? 1 : null;
                    }
                    if (obj == null) {
                        v.e("MicroMsg.ExtControlProviderOpenApi", "isSightOk wrong args");
                        bB(3, 3402);
                        return ExtContentProviderBase.kC(3402);
                    }
                    Intent intent = new Intent();
                    intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    intent.addFlags(67108864);
                    intent.putExtra("sight_local_path", str4);
                    com.tencent.mm.ay.c.a(this.context, ".ui.transmit.SightForwardUI", intent);
                    z(12, 0, 1);
                    return ExtContentProviderBase.kC(1);
                case 35:
                    v.i("MicroMsg.ExtControlProviderOpenApi", "hy: start redirect to chatting by phone num");
                    if (strArr2 == null || strArr2.length <= 0 || be.kS(strArr2[0])) {
                        v.e("MicroMsg.ExtControlProviderOpenApi", "hy: args error: no phone num or phone num is null or nil");
                        bB(3, 3201);
                        return ExtContentProviderBase.kC(3201);
                    }
                    v.i("MicroMsg.ExtControlProviderOpenApi", "hy: start searching for phone num: %s", strArr2[0]);
                    akZ = new com.tencent.mm.plugin.ext.b.c(this.context, str4).akS();
                    v.i("MicroMsg.ExtControlProviderOpenApi", " ret =  ", Integer.valueOf(akZ));
                    if (akZ != -1) {
                        z(14, 0, akZ);
                        akZ = 0;
                    } else {
                        z(15, 0, akZ);
                    }
                    return ExtContentProviderBase.kC(akZ);
                case 36:
                    v.i("MicroMsg.ExtControlProviderOpenApi", "hy: start redirect to wechat out by phone num");
                    if (strArr2 == null || strArr2.length < 3) {
                        v.e("MicroMsg.ExtControlProviderOpenApi", "hy: wechat out args error: args length error");
                        bB(3, 3301);
                        return ExtContentProviderBase.kC(3301);
                    }
                    str4 = strArr2[0];
                    int i = be.getInt(strArr2[1], -1);
                    str3 = strArr2[2];
                    v.i("MicroMsg.ExtControlProviderOpenApi", "hy: start wechat out: contactid: %s, countrycode: %s,  phone num: %s", str4, Integer.valueOf(i), str3);
                    if (be.kS(str4) || i < 0 || be.kS(str3)) {
                        v.i("MicroMsg.ExtControlProviderOpenApi", "hy: param err");
                        bB(3, 3302);
                        return ExtContentProviderBase.kC(3302);
                    }
                    b onVar = new on();
                    onVar.bpM.bpN = str4;
                    onVar.bpM.bpO = i;
                    onVar.bpM.bpP = str3;
                    onVar.bpM.aGX = a.g(str4, this.context);
                    com.tencent.mm.sdk.c.a.nhr.z(onVar);
                    z(16, 0, 1);
                    return ExtContentProviderBase.kC(1);
                case 37:
                    v.d("MicroMsg.ExtControlProviderOpenApi", "getWifiList");
                    this.handler = new ac(Looper.getMainLooper());
                    MatrixCursor matrixCursor = (MatrixCursor) new az<MatrixCursor>(this) {
                        final /* synthetic */ ExtControlProviderOpenApi fHa;

                        protected final /* synthetic */ Object run() {
                            return akW();
                        }

                        private MatrixCursor akW() {
                            try {
                                v.d("MicroMsg.ExtControlProviderOpenApi", "syncTaskCur run ");
                                final b eeVar = new ee();
                                eeVar.bcv.bcx = strArr2;
                                eeVar.bpT = new Runnable(this) {
                                    final /* synthetic */ AnonymousClass1 fHc;

                                    public final void run() {
                                        v.i("MicroMsg.ExtControlProviderOpenApi", "getWifiList run");
                                        if (eeVar != null && eeVar.bcw != null && eeVar.bcw.bcc != 0) {
                                            v.i("MicroMsg.ExtControlProviderOpenApi", "getWifiList return cursor");
                                            this.fHc.bd(eeVar.bcw.bcy);
                                        }
                                    }
                                };
                                if (!com.tencent.mm.sdk.c.a.nhr.z(eeVar)) {
                                    v.i("MicroMsg.ExtControlProviderOpenApi", "getWifiList publish getWifiListEvent fail");
                                    bd(ExtContentProviderBase.kC(8));
                                }
                            } catch (Exception e) {
                                v.e("MicroMsg.ExtControlProviderOpenApi", "exception in getWifiList syncTaskCur.", e);
                                bd(ExtContentProviderBase.kC(12));
                            }
                            return null;
                        }
                    }.c(this.handler);
                    if (matrixCursor == null) {
                        z(19, 4, 14);
                        return ExtContentProviderBase.kC(14);
                    }
                    z(18, 0, 1);
                    v.i("MicroMsg.ExtControlProviderOpenApi", "returnMatrix syncTaskCur");
                    return matrixCursor;
                case 38:
                    v.d("MicroMsg.ExtControlProviderOpenApi", "connectWifi");
                    this.handler = new ac(Looper.getMainLooper());
                    Integer num = (Integer) new az<Integer>(this) {
                        final /* synthetic */ ExtControlProviderOpenApi fHa;

                        protected final /* synthetic */ Object run() {
                            return Mi();
                        }

                        private Integer Mi() {
                            try {
                                v.d("MicroMsg.ExtControlProviderOpenApi", "syncTaskCur run ");
                                final b ebVar = new eb();
                                ebVar.bbZ.version = be.getInt(strArr2[0], 0);
                                ebVar.bbZ.ssid = strArr2[1];
                                ebVar.bbZ.bssid = strArr2[2];
                                ebVar.bbZ.bcb = be.getInt(strArr2[3], 0);
                                ebVar.bpT = new Runnable(this) {
                                    final /* synthetic */ AnonymousClass2 fHe;

                                    public final void run() {
                                        v.i("MicroMsg.ExtControlProviderOpenApi", "connectWifi run");
                                        if (ebVar != null && ebVar.bca != null && ebVar.bca.bcc != 0) {
                                            v.i("MicroMsg.ExtControlProviderOpenApi", "connectWifi errcode = %s,errmsg = %s", Integer.valueOf(ebVar.bca.bcd), ebVar.bca.bce);
                                            this.fHe.bd(Integer.valueOf(ebVar.bca.bcd));
                                        }
                                    }
                                };
                                if (!com.tencent.mm.sdk.c.a.nhr.z(ebVar)) {
                                    v.i("MicroMsg.ExtControlProviderOpenApi", "connectWifi publish getWifiListEvent fail");
                                    bd(Integer.valueOf(8));
                                }
                            } catch (Exception e) {
                                v.e("MicroMsg.ExtControlProviderOpenApi", "exception in connectWifi syncTaskInt.", e);
                                bd(Integer.valueOf(12));
                            }
                            return Integer.valueOf(0);
                        }
                    }.c(this.handler);
                    if (num == null) {
                        z(21, 4, 14);
                        return ExtContentProviderBase.kC(14);
                    }
                    z(20, 0, num.intValue());
                    return ExtContentProviderBase.kC(num.intValue());
                case 40:
                    v.i("MicroMsg.ExtControlProviderOpenApi", "setSportStep start");
                    if (strArr2 == null || strArr2.length < 3) {
                        v.e("MicroMsg.ExtControlProviderOpenApi", "args error: args length error");
                        z(23, 3, 2);
                        return ExtContentProviderBase.kC(2);
                    }
                    long j = be.getLong(strArr2[0], -1);
                    long j2 = be.getLong(strArr2[1], -1);
                    long j3 = be.getLong(strArr2[2], -1);
                    v.i("MicroMsg.ExtControlProviderOpenApi", "setSportStep: timestampe: %s, stepcount: %s,  version: %s", Long.valueOf(j2), Long.valueOf(j), Long.valueOf(j3));
                    if (j2 < 0 || j < 0 || j3 < 0) {
                        v.i("MicroMsg.ExtControlProviderOpenApi", "param err");
                        z(23, 3, 2);
                        return ExtContentProviderBase.kC(2);
                    }
                    akT();
                    b emVar = new em();
                    emVar.bcU.action = 2;
                    emVar.bcU.bcW = j2;
                    emVar.bcU.bcX = j;
                    emVar.bcU.bcY = j3;
                    if (com.tencent.mm.sdk.c.a.nhr.z(emVar) && emVar.bcV.bda) {
                        z(22, 0, emVar.bcV.bdb);
                        return ExtContentProviderBase.kC(emVar.bcV.bdb);
                    }
                    z(23, 4, 8);
                    return ExtContentProviderBase.kC(8);
                case 41:
                    v.i("MicroMsg.ExtControlProviderOpenApi", "getSportConfig start");
                    akT();
                    b emVar2 = new em();
                    emVar2.bcU.action = 3;
                    if (com.tencent.mm.sdk.c.a.nhr.z(emVar2) && emVar2.bcV.bda) {
                        str3 = emVar2.bcV.bcZ;
                        Cursor matrixCursor2 = new MatrixCursor(fGT);
                        matrixCursor2.addRow(new Object[]{Integer.valueOf(emVar2.bcV.bdb), be.ma(str3)});
                        z(22, 0, emVar2.bcV.bdb);
                        v.i("MicroMsg.ExtControlProviderOpenApi", "return  code =%s ", Integer.valueOf(emVar2.bcV.bdb));
                        return matrixCursor2;
                    }
                    z(23, 4, 8);
                    return ExtContentProviderBase.kC(8);
                case 42:
                    Intent intent2 = new Intent();
                    intent2.addFlags(131072);
                    intent2.putExtra("key_from_scene", 4);
                    com.tencent.mm.ay.c.b(this.context, "offline", ".ui.WalletOfflineEntranceUI", intent2);
                    g.iuh.h(12097, Integer.valueOf(9), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()));
                    z(24, 0, 1);
                    return ExtContentProviderBase.kC(1);
                default:
                    bB(3, 15);
                    return null;
            }
        } else {
            v.e("MicroMsg.ExtControlProviderOpenApi", "not login return code = 3");
            bB(1, 3);
            return ExtContentProviderBase.kC(3);
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

    private Cursor f(String str, String str2, String str3, String str4) {
        int i = -1;
        v.i("MicroMsg.ExtControlProviderOpenApi", "registerMsgReceiver, op = %s", str);
        if (this.context == null) {
            v.e("MicroMsg.ExtControlProviderOpenApi", "context == null return code = 2001");
            bB(4, MMBitmapFactory.ERROR_PNG_BUG_DETECTED_BEGIN);
            return ExtContentProviderBase.kC(MMBitmapFactory.ERROR_PNG_BUG_DETECTED_BEGIN);
        } else if (be.kS(str)) {
            v.e("MicroMsg.ExtControlProviderOpenApi", "wrong args, op is null return code = 2002");
            bB(3, MMBitmapFactory.ERROR_ILLEGAL_NPTC_CHUNK);
            return ExtContentProviderBase.kC(MMBitmapFactory.ERROR_ILLEGAL_NPTC_CHUNK);
        } else {
            try {
                i = be.getInt(str, -1);
            } catch (Exception e) {
            }
            if (i == 1) {
                return D(str2, str3, str4);
            }
            if (i == 2) {
                v.d("MicroMsg.ExtControlProviderOpenApi", "doUnRegisterMsgListener");
                if (com.tencent.mm.plugin.ext.b.akM().Nl(this.fHh) == null) {
                    v.w("MicroMsg.ExtControlProviderOpenApi", "This app never been registered, appId = %s, pkg = %s", this.fHh, akY());
                    return ExtContentProviderBase.kC(2007);
                }
                boolean z;
                aw akM = com.tencent.mm.plugin.ext.b.akM();
                String str5 = this.fHh;
                if (str5 == null || str5.length() <= 0) {
                    z = false;
                } else {
                    z = akM.cie.delete("OpenMsgListener", "appId=?", new String[]{be.lZ(str5)}) > 0;
                }
                v.i("MicroMsg.ExtControlProviderOpenApi", "doUnRegisterMsgListener ret = %s, appId = %s, pkg = %s", Boolean.valueOf(z), this.fHh, akY());
                if (!z) {
                    return ExtContentProviderBase.kC(2008);
                }
                z(0, 0, 1);
                return ExtContentProviderBase.kC(1);
            }
            v.e("MicroMsg.ExtControlProviderOpenApi", "wrong args, no such op, %s", Integer.valueOf(i));
            bB(3, MMBitmapFactory.ERROR_ILLEGAL_IDATA_CHUNK);
            return ExtContentProviderBase.kC(MMBitmapFactory.ERROR_ILLEGAL_IDATA_CHUNK);
        }
    }

    private Cursor D(String str, String str2, String str3) {
        Exception exception;
        v.i("MicroMsg.ExtControlProviderOpenApi", "doRegisterMsgListener");
        if (be.kS(str) || be.kS(str2) || be.kS(str3)) {
            v.e("MicroMsg.ExtControlProviderOpenApi", "wrong args, scene = %s, msgType = %s, msgState = %s", str, str2, str3);
            bB(3, 2004);
            return ExtContentProviderBase.kC(2004);
        }
        MatrixCursor matrixCursor = null;
        try {
            int parseInt = Integer.parseInt(str3);
            int parseInt2 = Integer.parseInt(str);
            int parseInt3 = Integer.parseInt(str2);
            if (parseInt != 2) {
                v.e("MicroMsg.ExtControlProviderOpenApi", "wrong msgState: " + parseInt);
                bB(3, 2005);
                return ExtContentProviderBase.kC(2005);
            }
            if (com.tencent.mm.plugin.ext.b.akM().Nl(this.fHh) == null) {
                com.tencent.mm.sdk.h.c avVar = new av();
                avVar.field_appId = this.fHh;
                avVar.field_packageName = akY();
                String str4 = this.fHh;
                if (be.kS(str4) ? false : com.tencent.mm.pluginsdk.model.app.g.j(com.tencent.mm.pluginsdk.model.app.g.aC(str4, true))) {
                    avVar.field_status = 1;
                } else {
                    avVar.field_status = 0;
                }
                avVar.field_sceneFlag = parseInt2;
                avVar.field_msgTypeFlag = parseInt3;
                avVar.field_msgState = parseInt;
                v.i("MicroMsg.ExtControlProviderOpenApi", "registerMsgReceiver ret = %s, pkgName = %s, scene = %s, msgType = %s, msgState = %s, appStatus = %s", Boolean.valueOf(com.tencent.mm.plugin.ext.b.akM().b(avVar)), akY(), Integer.valueOf(parseInt2), Integer.valueOf(parseInt), Integer.valueOf(parseInt), Integer.valueOf(avVar.field_status));
                if (!com.tencent.mm.plugin.ext.b.akM().b(avVar)) {
                    return ExtContentProviderBase.kC(2006);
                }
            }
            v.w("MicroMsg.ExtControlProviderOpenApi", "This app had already been registered, appId = %s, pkg = %s", this.fHh, akY());
            StringBuilder append = new StringBuilder().append(com.tencent.mm.model.k.xF());
            ak.yW();
            String Kg = z.Kg(append.append(com.tencent.mm.model.c.ww()).toString());
            Cursor matrixCursor2 = new MatrixCursor(fGS);
            try {
                matrixCursor2.addRow(new Object[]{Integer.valueOf(1), be.ma(Kg)});
                z(0, 0, 1);
                v.i("MicroMsg.ExtControlProviderOpenApi", "return  code =%s ", Integer.valueOf(1));
                return matrixCursor2;
            } catch (Exception e) {
                Exception exception2 = e;
                Cursor cursor = matrixCursor2;
                exception = exception2;
                z(1, 4, 12);
                v.e("MicroMsg.ExtControlProviderOpenApi", "exception in doRegisterMsgListener, %s", exception.getMessage());
                if (matrixCursor != null) {
                    matrixCursor.close();
                }
                return ExtContentProviderBase.kC(12);
            }
        } catch (Exception e2) {
            exception = e2;
            z(1, 4, 12);
            v.e("MicroMsg.ExtControlProviderOpenApi", "exception in doRegisterMsgListener, %s", exception.getMessage());
            if (matrixCursor != null) {
                matrixCursor.close();
            }
            return ExtContentProviderBase.kC(12);
        }
    }

    private Cursor h(String[] strArr) {
        v.i("MicroMsg.ExtControlProviderOpenApi", "getUserAvatarByOpenId");
        if (strArr == null || strArr.length <= 0) {
            v.e("MicroMsg.ExtControlProviderOpenApi", "wrong args");
            bB(3, 3001);
            return ExtContentProviderBase.kC(3001);
        }
        Cursor matrixCursor = new MatrixCursor(fGU);
        int i = 0;
        while (i < strArr.length && i < 5) {
            if (!be.kS(strArr[i])) {
                bc Ny = com.tencent.mm.plugin.ext.b.akN().Ny(strArr[i]);
                if (Ny == null || be.kS(Ny.field_openId) || be.kS(Ny.field_username)) {
                    v.e("MicroMsg.ExtControlProviderOpenApi", "openidInApp is null");
                } else {
                    ak.yW();
                    ab LX = com.tencent.mm.model.c.wH().LX(Ny.field_username);
                    if (LX == null || LX.field_username == null || LX.field_username.length() <= 0) {
                        v.e("MicroMsg.ExtControlProviderOpenApi", "contact is null");
                    } else {
                        try {
                            n.AX();
                            String s = d.s(LX.field_username, false);
                            if (be.kS(s)) {
                                v.w("MicroMsg.ExtControlProviderOpenApi", "hy: get avatar sfs path is null or nil");
                            } else {
                                String str = LX.field_username;
                                d.b.gN(s);
                                if (FileOp.jO(s)) {
                                    matrixCursor.addRow(new Object[]{strArr[i], s});
                                } else {
                                    v.w("MicroMsg.ExtControlProviderOpenApi", "hy: copy or replace avatar from sfs to file system failed");
                                }
                            }
                        } catch (Exception e) {
                            v.e("MicroMsg.ExtControlProviderOpenApi", "Exception occur, %s", e.getMessage());
                            z(7, 4, 12);
                            matrixCursor.close();
                            return ExtContentProviderBase.kC(12);
                        }
                    }
                }
            }
            i++;
        }
        z(6, 0, 1);
        return matrixCursor;
    }

    private Cursor i(String[] strArr) {
        v.i("MicroMsg.ExtControlProviderOpenApi", "decodeVoice");
        if (strArr == null || strArr.length <= 0 || strArr[0].length() <= 0) {
            v.e("MicroMsg.ExtControlProviderOpenApi", "decodeVoice wrong args");
            bB(3, 3101);
            return ExtContentProviderBase.kC(3101);
        }
        MatrixCursor matrixCursor = null;
        int i = 0;
        while (i < 5 && i < strArr.length) {
            String str = strArr[i];
            try {
                if (o.g(str, 0, true)) {
                    String ae;
                    if (matrixCursor == null) {
                        matrixCursor = new MatrixCursor(fGV);
                    }
                    i iVar = new i();
                    String str2 = com.tencent.mm.plugin.ext.b.akO() + "/" + z.Kg(str);
                    if (!e.aR(str2) || aQ(str2) == 0) {
                        ae = iVar.ae(str, str2);
                    } else {
                        v.d("MicroMsg.ExtControlProviderOpenApi", "pcm already exist");
                        ae = str2;
                    }
                    if (aQ(str2) == 0) {
                        ae = iVar.ae(str, str2);
                    }
                    if (be.kS(ae)) {
                        v.w("MicroMsg.ExtControlProviderOpenApi", "wrong args targetFilePath is null");
                    } else {
                        v.d("MicroMsg.ExtControlProviderOpenApi", "decode to pcm success %d", Integer.valueOf(i));
                        matrixCursor.addRow(new Object[]{Integer.valueOf(1), Integer.valueOf(iVar.aTB), Integer.valueOf(iVar.aUr), Integer.valueOf(2), ae});
                    }
                } else {
                    v.w("MicroMsg.ExtControlProviderOpenApi", "wrong args : %s", strArr[i]);
                }
            } catch (Exception e) {
                v.e("MicroMsg.ExtControlProviderOpenApi", "Exception in decodeVoice, %s", e.getMessage());
            }
            i++;
        }
        if (matrixCursor != null) {
            z(8, 0, 1);
            return matrixCursor;
        }
        z(9, 3, 4);
        return ExtContentProviderBase.kC(4);
    }

    private static int aQ(String str) {
        if (str == null) {
            return 0;
        }
        File file = new File(str);
        if (file.exists()) {
            return (int) file.length();
        }
        return 0;
    }

    private void akT() {
        String str = (String) com.tencent.mm.plugin.ext.b.akL().get(t.a.USERINFO_EXT_SPORT_PKGNAME_STRING, null);
        v.i("MicroMsg.ExtControlProviderOpenApi", "setSportBroadPkg: pkgNames: %s, pkg: %s", str, akY());
        if (str == null) {
            com.tencent.mm.plugin.ext.b.akL().a(t.a.USERINFO_EXT_SPORT_PKGNAME_STRING, akY());
        } else if (!com.tencent.mm.compatible.loader.a.a(str.split(";"), r1)) {
            com.tencent.mm.plugin.ext.b.akL().a(t.a.USERINFO_EXT_SPORT_PKGNAME_STRING, str + ";" + akY());
        }
    }
}
