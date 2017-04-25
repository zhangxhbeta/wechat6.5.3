package com.tencent.mm.v;

import android.os.Looper;
import com.tencent.mm.model.al;
import com.tencent.mm.network.p;
import com.tencent.mm.network.q.a;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.report.b;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.c.asj;
import com.tencent.mm.protocal.c.nr;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.h;
import com.tencent.mm.protocal.i;
import com.tencent.mm.protocal.j.c;
import com.tencent.mm.protocal.j.f;
import com.tencent.mm.protocal.j.g;
import com.tencent.mm.protocal.z;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class s extends a {
    h cAG;
    i cAH;
    private p cAt;
    ac handler;

    public s(p pVar) {
        this(pVar, Looper.myLooper() == null ? new ac(Looper.getMainLooper()) : new ac());
    }

    public s(p pVar, ac acVar) {
        this.cAt = pVar;
        this.cAG = new r(pVar.Bx(), pVar.getType());
        this.cAH = new t(pVar.ze(), pVar.getType());
        this.handler = acVar;
    }

    public final boolean By() {
        return this.cAt.By();
    }

    public final int BE() {
        return this.cAt.hashCode();
    }

    public final int Bu() {
        return this.cAt.Bu();
    }

    public final h Ce() {
        return this.cAG;
    }

    public final i Cf() {
        return this.cAH;
    }

    public final int getType() {
        return this.cAt.getType();
    }

    public final String getUri() {
        return this.cAt.getUri();
    }

    public final void gX(String str) {
    }

    public final void a(com.tencent.mm.network.i iVar, final int i, final int i2, final String str) {
        this.handler.post(new Runnable(this) {
            final /* synthetic */ s cAI;

            public final void run() {
                v.d("MicroMsg.RemoteReqResp", "summerauth doAutoAuthEnd type:%d, stack[%s]", Integer.valueOf(this.cAI.cAt.getType()), be.bur());
                f fVar = (f) this.cAI.cAt.Bx();
                g gVar = (g) this.cAI.cAt.ze();
                if (gVar == null) {
                    v.f("MicroMsg.RemoteReqResp", "null auth.resp");
                } else {
                    c.a.lWC.a(fVar, gVar, i, i2, str);
                }
            }
        });
    }

    public final void a(final com.tencent.mm.network.i iVar, final int i, final int i2) {
        this.handler.post(new Runnable(this) {
            final /* synthetic */ s cAI;

            public final void run() {
                int i;
                int i2 = al.zc().getInt("key_auth_update_version", 0);
                int i3 = i2 <= 637665332 ? 701 : 702;
                if (i2 == 0) {
                    if (be.kS(aa.getContext().getSharedPreferences("ticket_prefs", 4).getString("_auth_ticket", SQLiteDatabase.KeyEmpty))) {
                        v.i("MicroMsg.RemoteReqResp", "summerauth dealWithAutoAuth revise to autoauth");
                        b.itm.a(148, 50, 1, true);
                        i3 = 702;
                    } else {
                        b.itm.a(148, 49, 1, true);
                        v.i("MicroMsg.RemoteReqResp", "summerauth dealWithAutoAuth keep manual as old [%s]", be.KW(r13.getString("_auth_ticket", SQLiteDatabase.KeyEmpty)));
                    }
                }
                v.i("MicroMsg.RemoteReqResp", "summerauth dealWithAutoAuth updateVersion:%d, clientVersion:%d WLOGIN_BUG_VERSION:%d, newAuthType:%d", Integer.valueOf(i2), Integer.valueOf(d.lWh), Integer.valueOf(637665332), Integer.valueOf(i3));
                if (i3 == 701) {
                    b.itm.a(148, 48, 1, true);
                }
                if ((this.cAI.cAt.getType() == 702 || this.cAI.cAt.getType() == 701) && ((g) this.cAI.cAt.ze()).lWI == 2) {
                    i = 1;
                } else {
                    i = 0;
                }
                v.i("MicroMsg.RemoteReqResp", "summerauth dealWithAutoAuth old type:%d new auth type:%d, reqFlag:%d", Integer.valueOf(this.cAI.cAt.getType()), Integer.valueOf(i3), Integer.valueOf(i));
                p aD = c.a.lWC.aD(i3, i);
                try {
                    iVar.a(aD == null ? null : new s(aD, this.cAI.handler), i, i2, SQLiteDatabase.KeyEmpty);
                } catch (Throwable e) {
                    v.e("MicroMsg.RemoteReqResp", "exception:%s", be.e(e));
                }
            }
        });
    }

    public final void a(com.tencent.mm.network.d dVar, final com.tencent.mm.network.i iVar, final int i, final int i2) {
        this.handler.post(new Runnable(this) {
            final /* synthetic */ s cAI;

            public final void run() {
                try {
                    iVar.a(new s(new j(), this.cAI.handler), i, i2, SQLiteDatabase.KeyEmpty);
                } catch (Throwable e) {
                    v.e("MicroMsg.RemoteReqResp", "exception:%s", be.e(e));
                }
            }
        });
    }

    public final int Cg() {
        int i = -1;
        v.d("MicroMsg.RemoteReqResp", "summerauth decodeAndRetriveAccInfo type:%d", Integer.valueOf(getType()));
        switch (getType()) {
            case 126:
                p pVar = this.cAt;
                z.a aVar = (z.a) pVar.Bx();
                z.b bVar = (z.b) pVar.ze();
                v.i("MicroMsg.MMReqRespReg2", "summerauth decodeAndRetriveAccInfo type:%d, stack[%s]", Integer.valueOf(126), be.bur());
                if (bVar.lWI != 0) {
                    v.d("MicroMsg.MMReqRespReg2", "summerauth decodeAndRetriveAccInfo resp just decoded and ret result:%d", Integer.valueOf(bVar.lWI));
                } else {
                    asj com_tencent_mm_protocal_c_asj = bVar.lXv.mKY;
                    if (com_tencent_mm_protocal_c_asj != null) {
                        int i2 = com_tencent_mm_protocal_c_asj.mej;
                        nr nrVar = com_tencent_mm_protocal_c_asj.mdT;
                        byte[] a = m.a(com_tencent_mm_protocal_c_asj.mdU);
                        String str = "MicroMsg.MMReqRespReg2";
                        String str2 = "summerauth svr ecdh key len:%d, nid:%d sessionKey len:%d, sessionKey：%s";
                        Object[] objArr = new Object[4];
                        objArr[0] = Integer.valueOf(nrVar.mes.mQu);
                        objArr[1] = Integer.valueOf(nrVar.mpx);
                        objArr[2] = Integer.valueOf(a == null ? -1 : a.length);
                        objArr[3] = be.KW(be.bk(a));
                        v.d(str, str2, objArr);
                        byte[] a2 = m.a(nrVar.mes);
                        byte[] bArr = aVar.lWF;
                        byte[] bArr2 = null;
                        if (be.bl(a2)) {
                            v.w("MicroMsg.MMReqRespReg2", "summerauth svr ecdh key is null!");
                        } else {
                            String str3 = "MicroMsg.MMReqRespReg2";
                            String str4 = "summerauth svrPubKey len:%d value:%s prikey len:%d, values:%s";
                            Object[] objArr2 = new Object[4];
                            objArr2[0] = Integer.valueOf(a2.length);
                            objArr2[1] = be.KW(be.bk(a2));
                            objArr2[2] = Integer.valueOf(bArr == null ? -1 : bArr.length);
                            objArr2[3] = be.KW(be.bk(bArr));
                            v.d(str3, str4, objArr2);
                            PByteArray pByteArray = new PByteArray();
                            int computerKeyWithAllStr = MMProtocalJni.computerKeyWithAllStr(nrVar.mpx, a2, bArr, pByteArray, 0);
                            bArr2 = pByteArray.value;
                            str = "MicroMsg.MMReqRespReg2";
                            str2 = "summerauth ComputerKeyWithAllStr ret:%d, agreedECDHKey len: %d, values:%s";
                            objArr = new Object[3];
                            objArr[0] = Integer.valueOf(computerKeyWithAllStr);
                            objArr[1] = Integer.valueOf(bArr2 == null ? -1 : bArr2.length);
                            objArr[2] = be.KW(be.bk(bArr2));
                            v.i(str, str2, objArr);
                        }
                        bVar.lWH = bArr2 != null ? bArr2 : new byte[0];
                        if ((i2 & 4) != 0) {
                            v.d("MicroMsg.MMReqRespReg2", "summerauth must decode session key");
                            if (be.bl(bArr2)) {
                                v.d("MicroMsg.MMReqRespReg2", "summerauth decode session key failed as agreedECDHKey is null!");
                                bVar.aV(new byte[0]);
                                bVar.lWI = 2;
                            } else {
                                bArr2 = MMProtocalJni.aesDecrypt(a, bArr2);
                                String str5 = "MicroMsg.MMReqRespReg2";
                                String str6 = "summerauth aesDecrypt sessionKey len:%d, value:%s, session len:%d, value:%s";
                                Object[] objArr3 = new Object[4];
                                objArr3[0] = Integer.valueOf(a == null ? -1 : a.length);
                                objArr3[1] = be.bk(a);
                                if (bArr2 != null) {
                                    i = bArr2.length;
                                }
                                objArr3[2] = Integer.valueOf(i);
                                objArr3[3] = be.KW(be.bk(bArr2));
                                v.d(str5, str6, objArr3);
                                if (be.bl(bArr2)) {
                                    v.d("MicroMsg.MMReqRespReg2", "summerauth decode session key failed ret null!");
                                    bVar.aV(new byte[0]);
                                    bVar.lWI = 2;
                                } else {
                                    v.d("MicroMsg.MMReqRespReg2", "summerauth decode session key succ session:%s", be.KW(be.bk(bArr2)));
                                    bVar.aV(bArr2);
                                    bVar.lWI = 1;
                                }
                            }
                        } else {
                            v.d("MicroMsg.MMReqRespReg2", "summerauth not need decode session key");
                            bVar.aV(a);
                            bVar.lWI = 1;
                        }
                    } else {
                        v.d("MicroMsg.MMReqRespReg2", "summerauth decodeAndRetriveAccInfo sect null and decode failed!");
                        bVar.aV(new byte[0]);
                        bVar.lWI = 2;
                    }
                }
                return bVar.lWI;
            case 701:
            case 702:
                return al.b(this.cAt);
            default:
                return -1;
        }
    }
}
