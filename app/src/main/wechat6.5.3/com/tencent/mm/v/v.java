package com.tencent.mm.v;

import com.tencent.mm.platformtools.q;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mmdb.database.SQLiteDatabase;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.b;
import oicq.wlogin_sdk.sharemem.WloginSigInfo;
import oicq.wlogin_sdk.tools.util;

public final class v {
    private b cBa = null;
    private long cBb = 0;

    class a extends oicq.wlogin_sdk.tools.b {
        final /* synthetic */ v cBc;

        public a(v vVar) {
            this.cBc = vVar;
        }

        public final void q(int i, String str) {
            e(i, SQLiteDatabase.KeyEmpty, str);
        }

        public final void e(int i, String str, String str2) {
            if (i == 1) {
                com.tencent.mm.sdk.platformtools.v.i("MicroMsg.WtloginMgr.Core", "[%s]%s", str, str2);
            } else if (i == 2) {
                com.tencent.mm.sdk.platformtools.v.d("MicroMsg.WtloginMgr.Core", "[%s]%s", str, str2);
            } else if (i == 0) {
                com.tencent.mm.sdk.platformtools.v.w("MicroMsg.WtloginMgr.Core", "[%s]%s", str, str2);
            }
        }
    }

    public v() {
        try {
            long Ni = be.Ni();
            this.cBa = new b(aa.getContext(), d.lWh);
            util.pOM = 1;
            util.pON = new a(this);
            com.tencent.mm.sdk.platformtools.v.d("MicroMsg.WtloginMgr", "dkstart wtlogin init :%d", Long.valueOf(be.ay(Ni)));
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.v.a("MicroMsg.WtloginMgr", e, "Failed initializing WtloginMgr.", new Object[0]);
        }
    }

    public final byte[] a(long j, String str, boolean z) {
        String str2 = "MicroMsg.WtloginMgr";
        String str3 = "dkwt isTestWtLogin:%b val:%d";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(q.dqj == 10006);
        objArr[1] = Integer.valueOf(q.dqk);
        com.tencent.mm.sdk.platformtools.v.d(str2, str3, objArr);
        if (q.dqj == 10006) {
            if (q.dqk == 1) {
                q.dqk = 0;
                return new byte[0];
            } else if (q.dqk == 2) {
                return new byte[0];
            }
        }
        try {
            boolean z2;
            this.cBb = j;
            byte[] a = z ? null : this.cBa.a(j, oicq.wlogin_sdk.request.b.a.USER_WITH_A1, SQLiteDatabase.KeyEmpty);
            str3 = "MicroMsg.WtloginMgr";
            String str4 = "dkwt getReqLoginBuf sig:%d uin:%d manualauth:%b  byA1Buf:%b ";
            Object[] objArr2 = new Object[4];
            objArr2[0] = Integer.valueOf(8256);
            objArr2[1] = Long.valueOf(j);
            objArr2[2] = Boolean.valueOf(z);
            if (be.bl(a)) {
                z2 = false;
            } else {
                z2 = true;
            }
            objArr2[3] = Boolean.valueOf(z2);
            com.tencent.mm.sdk.platformtools.v.d(str3, str4, objArr2);
            if (be.bl(a)) {
                return this.cBa.a(j, oicq.wlogin_sdk.request.b.a.USER_WITH_MD5, new String(be.KG(str), "ISO-8859-1"));
            }
            return a;
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WtloginMgr", "dkwt getReqLoginBuf e:%s", e.getMessage());
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WtloginMgr", "exception:%s", be.e(e));
            return new byte[0];
        }
    }

    public final boolean a(long j, byte[] bArr) {
        if (j != this.cBb) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WtloginMgr", "dkwt parseRespLoginBuf Error uin ReqUin:%d RespUin:%d", Long.valueOf(this.cBb), Long.valueOf(j));
            return false;
        } else if (be.bl(bArr)) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WtloginMgr", "dkwt parseRespLoginBuf respBuf is null.");
            return false;
        } else {
            try {
                int i;
                b bVar = this.cBa;
                if (bArr == null || bArr.length == 0 || bVar.pMx == null) {
                    i = -1017;
                } else {
                    util.Rc("user:" + bVar.pMr._uin + " ResolveSvrData ...");
                    i = bVar.pMx.F(bArr, bArr.length);
                    if (i == 1) {
                        bVar.eO(bVar.pMr._uin);
                    }
                    util.Rc("user:" + bVar.pMr._uin + " ResolveSvrData ret=" + i);
                }
                com.tencent.mm.sdk.platformtools.v.d("MicroMsg.WtloginMgr", "dkwt parseRespLoginBuf buflen:%d ret:%d", Integer.valueOf(bArr.length), Integer.valueOf(i));
                if (i == 0) {
                    return true;
                }
                return false;
            } catch (Throwable e) {
                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WtloginMgr", "dkwt parseRespLoginBuf e:%s", e.getMessage());
                com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WtloginMgr", "exception:%s", be.e(e));
                return false;
            }
        }
    }

    public final byte[] Q(long j) {
        if (j != this.cBb) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WtloginMgr", "dkwt getVerifyImg Error uin ReqUin:%d RespUin:%d", Long.valueOf(this.cBb), Long.valueOf(j));
            return new byte[0];
        }
        try {
            return this.cBa.eN(j);
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WtloginMgr", "dkwt getVerifyImg e:%s", e.getMessage());
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WtloginMgr", "exception:%s", be.e(e));
            return new byte[0];
        }
    }

    public final byte[] b(long j, String str) {
        if (j != this.cBb) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WtloginMgr", "dkwt getReqLoginBufbyVerifyImg Error uin ReqUin:%d RespUin:%d", Long.valueOf(this.cBb), Long.valueOf(j));
            return new byte[0];
        }
        byte[] bytes;
        if (be.kS(str)) {
            bytes = "****".getBytes();
        } else {
            bytes = str.getBytes();
        }
        try {
            return this.cBa.e(j, bytes);
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WtloginMgr", "dkwt getReqLoginBufbyVerifyImg e:%s", e.getMessage());
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WtloginMgr", "exception:%s", be.e(e));
            return new byte[0];
        }
    }

    public final byte[] R(long j) {
        if (j != this.cBb) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WtloginMgr", "dkwt getA2KeyByRespBuf Error uin ReqUin:%d RespUin:%d", Long.valueOf(this.cBb), Long.valueOf(j));
            return new byte[0];
        }
        try {
            WUserSigInfo wUserSigInfo;
            WloginSigInfo t = this.cBa.pMr.t(j, 522017402);
            if (t == null) {
                wUserSigInfo = null;
            } else {
                wUserSigInfo = new WUserSigInfo();
                wUserSigInfo.get_clone(t);
            }
            return wUserSigInfo == null ? new byte[0] : wUserSigInfo._A2;
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WtloginMgr", "dkwt getA2KeyByRespBuf e:%s", e.getMessage());
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WtloginMgr", "exception:%s", be.e(e));
            return new byte[0];
        }
    }

    public final void S(long j) {
        if (j != this.cBb) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WtloginMgr", "dkwt clearUserWtInfo Error uin ReqUin:%d RespUin:%d", Long.valueOf(this.cBb), Long.valueOf(j));
            return;
        }
        try {
            this.cBa.eO(j);
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WtloginMgr", "dkwt clearUserWtInfo e:%s", e.getMessage());
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.WtloginMgr", "exception:%s", be.e(e));
        }
    }
}
