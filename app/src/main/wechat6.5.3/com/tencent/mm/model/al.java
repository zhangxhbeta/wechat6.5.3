package com.tencent.mm.model;

import android.content.SharedPreferences;
import com.tencent.mm.a.o;
import com.tencent.mm.network.ac;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.c.acf;
import com.tencent.mm.protocal.c.acg;
import com.tencent.mm.protocal.c.aho;
import com.tencent.mm.protocal.c.ahq;
import com.tencent.mm.protocal.c.ajs;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.baq;
import com.tencent.mm.protocal.c.bgl;
import com.tencent.mm.protocal.c.biv;
import com.tencent.mm.protocal.c.dl;
import com.tencent.mm.protocal.c.dm;
import com.tencent.mm.protocal.c.dn;
import com.tencent.mm.protocal.c.dp;
import com.tencent.mm.protocal.c.em;
import com.tencent.mm.protocal.c.ht;
import com.tencent.mm.protocal.c.hu;
import com.tencent.mm.protocal.c.nr;
import com.tencent.mm.protocal.j.b;
import com.tencent.mm.protocal.j.c;
import com.tencent.mm.protocal.j.d;
import com.tencent.mm.protocal.j.e;
import com.tencent.mm.protocal.j.f;
import com.tencent.mm.protocal.j.g;
import com.tencent.mm.protocal.l;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.q;
import com.tencent.mm.v.i;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class al extends i implements c {
    private static a csR = null;
    private final int csO;
    private final f csP;
    private final g csQ;

    public interface a {
        void b(f fVar, g gVar);
    }

    public al(int i) {
        boolean z = i == 702 || i == 701;
        Assert.assertTrue(z);
        this.csO = i;
        if (i == 702) {
            this.csP = new com.tencent.mm.protocal.j.a();
            this.csQ = new b();
            return;
        }
        this.csP = new d();
        this.csQ = new e();
    }

    private p eL(int i) {
        v.i("MicroMsg.MMReqRespAuth", "summerauth autoAuthReq authReqFlag:%d, this:%d, stack:%s", Integer.valueOf(i), Integer.valueOf(hashCode()), be.bur());
        f fVar = (f) Bx();
        g gVar = this.csQ;
        SharedPreferences zc = am.zc();
        v.d("MicroMsg.MMReqRespAuth", "summerauth updateVersion:%d, clientVersion:%d", Integer.valueOf(zc.getInt("key_auth_update_version", 0)), Integer.valueOf(com.tencent.mm.protocal.d.lWh));
        if (zc.getInt("key_auth_update_version", 0) < com.tencent.mm.protocal.d.lWh) {
            fVar.lWQ = this.csO == 702 ? 12 : 16;
            com.tencent.mm.plugin.report.b.itm.a(148, this.csO == 702 ? 14 : 13, 1, false);
        } else {
            fVar.lWQ = this.csO == 702 ? 2 : 1;
        }
        em emVar = new em();
        emVar.mfy = i;
        emVar.meb = new are().ba(new byte[0]);
        emVar.mea = new are().ba(new byte[0]);
        bgl com_tencent_mm_protocal_c_bgl = new bgl();
        emVar.mfw = com_tencent_mm_protocal_c_bgl;
        com_tencent_mm_protocal_c_bgl.mgU = SQLiteDatabase.KeyEmpty;
        com_tencent_mm_protocal_c_bgl.mgT = SQLiteDatabase.KeyEmpty;
        com_tencent_mm_protocal_c_bgl.nbU = SQLiteDatabase.KeyEmpty;
        biv com_tencent_mm_protocal_c_biv = new biv();
        emVar.mfx = com_tencent_mm_protocal_c_biv;
        com_tencent_mm_protocal_c_biv.mAS = SQLiteDatabase.KeyEmpty;
        com_tencent_mm_protocal_c_biv.mAR = SQLiteDatabase.KeyEmpty;
        if (com.tencent.mm.kernel.g.uz()) {
            String oVar;
            byte[] bArr;
            com.tencent.mm.kernel.g.vx();
            String ma = be.ma((String) com.tencent.mm.kernel.g.vw().vf().get(2, null));
            com.tencent.mm.kernel.g.vx();
            o oVar2 = new o(be.a((Integer) com.tencent.mm.kernel.g.vw().vf().get(9, null), 0));
            if (be.kS(ma)) {
                oVar = oVar2.toString();
            } else {
                oVar = ma;
            }
            com.tencent.mm.kernel.g.vx();
            byte[] a = com.tencent.mm.kernel.g.vu().cjh.a(oVar2.longValue(), SQLiteDatabase.KeyEmpty, this.csO == 701);
            String str = "MicroMsg.MMReqRespAuth";
            String str2 = "summerauth loginbuf username:%s, qq:%s, len:%d, content:[%s]";
            Object[] objArr = new Object[4];
            objArr[0] = oVar;
            objArr[1] = oVar2;
            objArr[2] = Integer.valueOf(a == null ? -1 : a.length);
            objArr[3] = a == null ? "null" : be.KW(be.bk(a));
            v.i(str, str2, objArr);
            are com_tencent_mm_protocal_c_are = new are();
            if (be.bl(a)) {
                bArr = new byte[0];
            } else {
                bArr = a;
            }
            emVar.mfv = com_tencent_mm_protocal_c_are.ba(bArr);
            if (this.csO == 702) {
                com.tencent.mm.protocal.j.a aVar = (com.tencent.mm.protocal.j.a) fVar;
                b bVar = (b) gVar;
                dm dmVar = new dm();
                dp dpVar = new dp();
                aVar.lWB.met = dpVar;
                aVar.lWB.meu = dmVar;
                bArr = be.KG(zc.getString("_auth_key", SQLiteDatabase.KeyEmpty));
                dn dnVar = new dn();
                if (be.bl(bArr)) {
                    com.tencent.mm.plugin.report.b.itm.a(148, 16, 1, false);
                    dmVar.mdV = new are().ba(new byte[0]);
                } else {
                    dmVar.mdV = new are().ba(bArr);
                    try {
                        dnVar.az(bArr);
                    } catch (Throwable e) {
                        com.tencent.mm.plugin.report.b.itm.a(148, 15, 1, false);
                        v.a("MicroMsg.MMReqRespAuth", e, "summerauthkey Failed parse autoauthkey buf", new Object[0]);
                    }
                }
                if (dnVar.mer != null) {
                    dpVar.mev = dnVar.mer;
                } else {
                    com.tencent.mm.plugin.report.b.itm.a(148, 17, 1, false);
                    dpVar.mev = new are().ba(new byte[0]);
                    v.w("MicroMsg.MMReqRespAuth", "summerauthkey AesEncryptKey null!");
                }
                dmVar.mel = emVar;
                aVar.username = oVar;
                bVar.dli = oVar;
                return this;
            }
            d dVar = (d) fVar;
            ahq com_tencent_mm_protocal_c_ahq = new ahq();
            aho com_tencent_mm_protocal_c_aho = new aho();
            dVar.lWD.mHk = com_tencent_mm_protocal_c_ahq;
            dVar.lWD.mHl = com_tencent_mm_protocal_c_aho;
            com_tencent_mm_protocal_c_aho.mHj = 2;
            com_tencent_mm_protocal_c_aho.mel = emVar;
            com_tencent_mm_protocal_c_ahq.gln = oVar;
            com.tencent.mm.kernel.g.vx();
            ma = be.ma((String) com.tencent.mm.kernel.g.vw().vf().get(3, null));
            com.tencent.mm.kernel.g.vx();
            com_tencent_mm_protocal_c_ahq.mgI = be.ma((String) com.tencent.mm.kernel.g.vw().vf().get(19, null));
            com_tencent_mm_protocal_c_ahq.mgS = ma;
            return this;
        }
        v.e("MicroMsg.MMReqRespAuth", "autoAuthReq build autoauth Req  , failed  acc not ready");
        return null;
    }

    public final int zb() {
        if (com.tencent.mm.kernel.g.uz()) {
            com.tencent.mm.kernel.g.vx();
            return com.tencent.mm.kernel.g.vu().uin;
        }
        v.e("MicroMsg.MMReqRespAuth", "dkwt acc NOT Ready , the fucking MMReqRespBase need the fucking uin ???  if u find this log , fuck dk. %s", be.bur());
        return 0;
    }

    public final p aD(int i, int i2) {
        return new al(i).eL(i2);
    }

    public static void a(a aVar) {
        csR = aVar;
    }

    public final void a(f fVar, g gVar, int i, int i2, String str) {
        if (com.tencent.mm.kernel.g.uz()) {
            baq com_tencent_mm_protocal_c_baq = gVar.lWG;
            v.i("MicroMsg.MMReqRespAuth", "summerauth onAutoAuthEnd errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), str);
            if (i == 0 && i2 == 0) {
                if (csR != null) {
                    csR.b(fVar, gVar);
                    return;
                }
                return;
            } else if (i == 4 && i2 == -301) {
                com.tencent.mm.plugin.report.b.itm.a(148, 18, 1, false);
                v.d("MicroMsg.MMReqRespAuth", "dkidc onAutoAuthEnd RedirectIDC");
                if (com_tencent_mm_protocal_c_baq == null || com_tencent_mm_protocal_c_baq.mXh == null) {
                    v.w("MicroMsg.MMReqRespAuth", "dkidc onAutoAuthEnd RedirectIDC but NetworkSectResp is null");
                    return;
                } else {
                    a(true, gVar.lWG.mXh.mgK, gVar.lWG.mXh.mgL, gVar.lWG.mXh.mgJ);
                    return;
                }
            } else {
                return;
            }
        }
        v.e("MicroMsg.MMReqRespAuth", "summerauth onAutoAuthEnd but account not ready");
    }

    public static void a(boolean z, hu huVar, ajs com_tencent_mm_protocal_c_ajs, acg com_tencent_mm_protocal_c_acg) {
        String str = "MicroMsg.MMReqRespAuth";
        String str2 = "dkidc updateMultiIDCInfo resetnewwork:%b iplist[l:%d s:%d] hostList[%d] noop[%d %d] typing[%d] port[%s] timeout[%s]";
        Object[] objArr = new Object[9];
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(huVar == null ? -1 : huVar.miG);
        objArr[2] = Integer.valueOf(huVar == null ? -1 : huVar.miH);
        objArr[3] = Integer.valueOf(com_tencent_mm_protocal_c_acg == null ? -1 : com_tencent_mm_protocal_c_acg.eet);
        objArr[4] = Integer.valueOf(com_tencent_mm_protocal_c_ajs == null ? -1 : com_tencent_mm_protocal_c_ajs.mKs);
        objArr[5] = Integer.valueOf(com_tencent_mm_protocal_c_ajs == null ? -1 : com_tencent_mm_protocal_c_ajs.mKt);
        objArr[6] = Integer.valueOf(com_tencent_mm_protocal_c_ajs == null ? -1 : com_tencent_mm_protocal_c_ajs.mKu);
        objArr[7] = com_tencent_mm_protocal_c_ajs == null ? "null" : com_tencent_mm_protocal_c_ajs.mKq;
        objArr[8] = com_tencent_mm_protocal_c_ajs == null ? "null" : com_tencent_mm_protocal_c_ajs.mKr;
        v.i(str, str2, objArr);
        if (com_tencent_mm_protocal_c_acg == null || com_tencent_mm_protocal_c_acg.eeu == null || com_tencent_mm_protocal_c_acg.eeu.size() <= 0) {
            v.f("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo give empty host request! stack:[%s]", be.bur());
        } else if (com_tencent_mm_protocal_c_acg == null || com_tencent_mm_protocal_c_acg.eeu == null || com_tencent_mm_protocal_c_acg.eeu.size() <= 0) {
            v.f("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo give empty host request! stack:[%s]", be.bur());
        } else {
            ht htVar;
            List linkedList = new LinkedList();
            linkedList.clear();
            Iterator it = huVar.miK.iterator();
            while (it.hasNext()) {
                htVar = (ht) it.next();
                str = SQLiteDatabase.KeyEmpty;
                if (htVar.miF != null) {
                    str = htVar.miF.brp();
                }
                linkedList.add(new com.tencent.mm.protocal.o(htVar.type, htVar.miE.brp(), htVar.port, str));
                v.d("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo short type:%d port:%d ip:%s", Integer.valueOf(htVar.type), Integer.valueOf(htVar.port), htVar.miE.brp());
            }
            str2 = com.tencent.mm.protocal.o.bN(linkedList);
            List linkedList2 = new LinkedList();
            Iterator it2 = huVar.miJ.iterator();
            while (it2.hasNext()) {
                htVar = (ht) it2.next();
                str = SQLiteDatabase.KeyEmpty;
                if (htVar.miF != null) {
                    str = htVar.miF.brp();
                }
                linkedList2.add(new com.tencent.mm.protocal.o(htVar.type, htVar.miE.brp(), htVar.port, str));
                v.d("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo long type:%d port:%d ip:%s", Integer.valueOf(htVar.type), Integer.valueOf(htVar.port), htVar.miE.brp());
            }
            String bN = com.tencent.mm.protocal.o.bN(linkedList2);
            v.d("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo builtin ip long[%s] short[%s]", bN, str2);
            com.tencent.mm.kernel.g.vx();
            com.tencent.mm.kernel.g.vw().cjT.set(2, str2);
            SharedPreferences sharedPreferences = aa.getContext().getSharedPreferences("system_config_prefs", 0);
            sharedPreferences.edit().putString("builtin_short_ips", str2).commit();
            com.tencent.mm.kernel.g.vx();
            com.tencent.mm.kernel.g.vw().cjT.set(3, bN);
            com.tencent.mm.kernel.g.vx();
            com.tencent.mm.kernel.g.vw().cjT.set(6, com_tencent_mm_protocal_c_ajs.mKq);
            com.tencent.mm.kernel.g.vx();
            com.tencent.mm.kernel.g.vw().cjT.set(7, com_tencent_mm_protocal_c_ajs.mKr);
            if (com_tencent_mm_protocal_c_ajs.mKu != 0) {
                int i;
                com.tencent.mm.kernel.g.vx();
                q qVar = com.tencent.mm.kernel.g.vw().cjT;
                if (com_tencent_mm_protocal_c_ajs.mKu > 60) {
                    i = 60;
                } else {
                    i = com_tencent_mm_protocal_c_ajs.mKu;
                }
                qVar.set(35, Integer.valueOf(i));
            }
            ac.g((long) com_tencent_mm_protocal_c_ajs.mKs, (long) com_tencent_mm_protocal_c_ajs.mKv);
            com.tencent.mm.protocal.o.a dv = com.tencent.mm.protocal.o.dv(com_tencent_mm_protocal_c_ajs.mKq, com_tencent_mm_protocal_c_ajs.mKr);
            String str3 = SQLiteDatabase.KeyEmpty;
            String str4 = SQLiteDatabase.KeyEmpty;
            String[] strArr = new String[com_tencent_mm_protocal_c_acg.eeu.size()];
            String[] strArr2 = new String[com_tencent_mm_protocal_c_acg.eeu.size()];
            int[] iArr = new int[com_tencent_mm_protocal_c_acg.eeu.size()];
            v.d("MicroMsg.MMReqRespAuth", "hostlist.Count=%d", Integer.valueOf(com_tencent_mm_protocal_c_acg.eet));
            Iterator it3 = com_tencent_mm_protocal_c_acg.eeu.iterator();
            int i2 = 0;
            while (it3.hasNext()) {
                acf com_tencent_mm_protocal_c_acf = (acf) it3.next();
                v.d("MicroMsg.MMReqRespAuth", "dkidc host org:%s sub:%s", com_tencent_mm_protocal_c_acf.mDp, com_tencent_mm_protocal_c_acf.mDq);
                strArr[i2] = com_tencent_mm_protocal_c_acf.mDp;
                strArr2[i2] = com_tencent_mm_protocal_c_acf.mDq;
                iArr[i2] = com_tencent_mm_protocal_c_acf.mDr;
                i2++;
                if (!(be.kS(com_tencent_mm_protocal_c_acf.mDp) || be.kS(com_tencent_mm_protocal_c_acf.mDq))) {
                    if (com_tencent_mm_protocal_c_acf.mDp.equals("short.weixin.qq.com")) {
                        com.tencent.mm.kernel.g.vx();
                        com.tencent.mm.kernel.g.vw().cjT.set(24, com_tencent_mm_protocal_c_acf.mDq);
                        str4 = com_tencent_mm_protocal_c_acf.mDq;
                    } else if (com_tencent_mm_protocal_c_acf.mDp.equals("long.weixin.qq.com")) {
                        com.tencent.mm.kernel.g.vx();
                        com.tencent.mm.kernel.g.vw().cjT.set(25, com_tencent_mm_protocal_c_acf.mDq);
                        str3 = com_tencent_mm_protocal_c_acf.mDq;
                    } else if (com_tencent_mm_protocal_c_acf.mDp.equals("support.weixin.qq.com") && !be.kS(com_tencent_mm_protocal_c_acf.mDq)) {
                        sharedPreferences.edit().putString("support.weixin.qq.com", com_tencent_mm_protocal_c_acf.mDq).commit();
                    }
                }
            }
            com.tencent.mm.kernel.g.vx();
            com.tencent.mm.network.e eVar = com.tencent.mm.kernel.g.vv().cjC.cAa;
            if (strArr.length > 0 && eVar != null) {
                eVar.setHostInfo(strArr, strArr2, iArr);
            }
            if (!be.kS(str3)) {
                com.tencent.mm.kernel.g.vx();
                com.tencent.mm.kernel.g.vw().cjT.set(25, str3);
            }
            if (!be.kS(str4)) {
                com.tencent.mm.kernel.g.vx();
                com.tencent.mm.kernel.g.vw().cjT.set(24, str4);
            }
            if (eVar != null) {
                eVar.a(z, str2, bN, dv.lXa, dv.lXb, dv.lXc, dv.lXd, str4, str3);
            }
        }
    }

    public static SharedPreferences zc() {
        return am.zc();
    }

    protected final l.c zd() {
        return this.csP;
    }

    public final l.d ze() {
        return this.csQ;
    }

    public final int getType() {
        return this.csP.zg();
    }

    public final String getUri() {
        return this.csP.getUri();
    }

    public static int b(p pVar) {
        g gVar = (g) pVar.ze();
        v.i("MicroMsg.MMReqRespAuth", "summerauth decodeAndRetriveAccInfo type:%d, hashcode:%d, ret:%d, stack[%s]", Integer.valueOf(((f) pVar.Bx()).zg()), Integer.valueOf(pVar.hashCode()), Integer.valueOf(gVar.lWI), be.bur());
        if (gVar.lWI != 0) {
            v.d("MicroMsg.MMReqRespAuth", "summerauth decodeAndRetriveAccInfo resp just decoded and ret result:%d", Integer.valueOf(gVar.lWI));
            return gVar.lWI;
        }
        baq com_tencent_mm_protocal_c_baq = gVar.lWG;
        int i = com_tencent_mm_protocal_c_baq.mXe;
        if ((i & 1) != 0) {
            dl dlVar = com_tencent_mm_protocal_c_baq.mXf;
            v.i("MicroMsg.MMReqRespAuth", "decodeAndRetriveAccInfo authResultFlag:%d UpdateFlag:%d ", Integer.valueOf(dlVar.mej), Integer.valueOf(dlVar.mei));
            nr nrVar = dlVar.mdT;
            byte[] a = m.a(dlVar.mdU);
            String str = "MicroMsg.MMReqRespAuth";
            String str2 = "summerauth svr ecdh key len:%d, nid:%d sessionKey len:%d, sessionKey：%s";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(nrVar.mes.mQu);
            objArr[1] = Integer.valueOf(nrVar.mpx);
            objArr[2] = Integer.valueOf(a == null ? -1 : a.length);
            objArr[3] = be.KW(be.bk(a));
            v.d(str, str2, objArr);
            byte[] a2 = m.a(nrVar.mes);
            byte[] bArr = r0.lWF;
            if (be.bl(a2)) {
                com.tencent.mm.plugin.report.b.itm.a(148, 24, 1, false);
                v.w("MicroMsg.MMReqRespAuth", "summerauth svr ecdh key is null!");
                a2 = null;
            } else {
                str2 = "MicroMsg.MMReqRespAuth";
                String str3 = "summerauth svrPubKey len:%d value:%s prikey len:%d, values:%s";
                Object[] objArr2 = new Object[4];
                objArr2[0] = Integer.valueOf(a2.length);
                objArr2[1] = be.KW(be.bk(a2));
                objArr2[2] = Integer.valueOf(bArr == null ? -1 : bArr.length);
                objArr2[3] = be.KW(be.bk(bArr));
                v.d(str2, str3, objArr2);
                PByteArray pByteArray = new PByteArray();
                int computerKeyWithAllStr = MMProtocalJni.computerKeyWithAllStr(nrVar.mpx, a2, bArr, pByteArray, 0);
                a2 = pByteArray.value;
                str = "MicroMsg.MMReqRespAuth";
                str2 = "summerauth ComputerKeyWithAllStr ret:%d, agreedECDHKey len: %d, values:%s";
                objArr = new Object[3];
                objArr[0] = Integer.valueOf(computerKeyWithAllStr);
                objArr[1] = Integer.valueOf(a2 == null ? -1 : a2.length);
                objArr[2] = be.KW(be.bk(a2));
                v.i(str, str2, objArr);
            }
            gVar.lWH = a2 != null ? a2 : new byte[0];
            if ((r12 & 4) != 0) {
                v.d("MicroMsg.MMReqRespAuth", "summerauth must decode session key");
                if (be.bl(a2)) {
                    com.tencent.mm.plugin.report.b.itm.a(148, 26, 1, false);
                    v.d("MicroMsg.MMReqRespAuth", "summerauth decode session key failed as agreedECDHKey is null!");
                    gVar.aV(new byte[0]);
                    gVar.lWI = 2;
                } else {
                    a2 = MMProtocalJni.aesDecrypt(a, a2);
                    String str4 = "MicroMsg.MMReqRespAuth";
                    str = "summerauth aesDecrypt sessionKey len:%d, value:%s, session len:%d, value:%s";
                    Object[] objArr3 = new Object[4];
                    objArr3[0] = Integer.valueOf(a == null ? -1 : a.length);
                    objArr3[1] = be.KW(be.bk(a));
                    objArr3[2] = Integer.valueOf(a2 == null ? -1 : a2.length);
                    objArr3[3] = be.KW(be.bk(a2));
                    v.d(str4, str, objArr3);
                    if (be.bl(a2)) {
                        com.tencent.mm.plugin.report.b.itm.a(148, 25, 1, false);
                        v.d("MicroMsg.MMReqRespAuth", "summerauth decode session key failed ret null!");
                        gVar.aV(new byte[0]);
                        gVar.lWI = 2;
                    } else {
                        v.d("MicroMsg.MMReqRespAuth", "summerauth decode session key succ session:%s", be.KW(be.bk(a2)));
                        gVar.aV(a2);
                        gVar.lWI = 1;
                    }
                }
            } else {
                com.tencent.mm.plugin.report.b.itm.a(148, 27, 1, false);
                v.d("MicroMsg.MMReqRespAuth", "summerauth not need decode session key");
                gVar.aV(a);
                gVar.lWI = 1;
            }
        } else {
            v.d("MicroMsg.MMReqRespAuth", "summerauth auth sect not set so ret failed");
            gVar.aV(new byte[0]);
            gVar.lWI = 2;
        }
        if ((i & 2) != 0) {
            gVar.dli = com_tencent_mm_protocal_c_baq.mXg.gln;
        } else {
            v.d("MicroMsg.MMReqRespAuth", "summerauth acct sect not set!");
        }
        return gVar.lWI;
    }
}
