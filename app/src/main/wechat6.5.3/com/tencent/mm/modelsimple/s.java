package com.tencent.mm.modelsimple;

import android.os.Process;
import android.text.TextUtils;
import com.tencent.mm.a.o;
import com.tencent.mm.e.a.hx;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.al;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bb;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.report.b;
import com.tencent.mm.plugin.report.b.c;
import com.tencent.mm.protocal.c.aho;
import com.tencent.mm.protocal.c.ahq;
import com.tencent.mm.protocal.c.ai;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.aux;
import com.tencent.mm.protocal.c.ayl;
import com.tencent.mm.protocal.c.baq;
import com.tencent.mm.protocal.c.bgl;
import com.tencent.mm.protocal.c.biv;
import com.tencent.mm.protocal.c.em;
import com.tencent.mm.protocal.j.d;
import com.tencent.mm.protocal.j.f;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Iterator;
import java.util.Random;

public final class s extends k implements j {
    private final p cAt;
    private String cYP;
    private String cYQ;
    private boolean cYR;
    private boolean cYS;
    private int cYT;
    private int cYU;
    e cii;
    private int czX;
    private int errCode;
    private int errType;

    public static class a {
        public String bax;
        public String bhe;
        public String cYX;
        public String username;

        public final String toString() {
            return String.format("AuthVoicePrintInfo hash[%d], username[%s], ticket[%s], helpUrlp[%s], wording[%s]", new Object[]{Integer.valueOf(hashCode()), this.username, be.KW(this.bax), this.cYX, this.bhe});
        }
    }

    public s(int i, String str, String str2, String str3) {
        this(SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, i, str, str2, str3, 0, SQLiteDatabase.KeyEmpty, false, false);
    }

    public s(String str, String str2, String str3, int i) {
        this(str, str2, 0, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, i, str3, false, false);
    }

    public s(String str, String str2, int i, String str3, String str4, String str5, int i2, String str6, boolean z, boolean z2) {
        this.cYP = SQLiteDatabase.KeyEmpty;
        this.cYQ = SQLiteDatabase.KeyEmpty;
        this.cYR = false;
        this.cYS = false;
        this.errType = 0;
        this.errCode = 0;
        this.czX = 3;
        this.cYT = 0;
        this.cYU = 0;
        v.d("MicroMsg.NetSceneManualAuth", "summerauth NetSceneManualAuth this: " + this + " account: " + str + " rawPsw len: " + (str2 == null ? -1 : str2.length()) + " secCodetype: " + i + " secCode: " + str3 + " sid: " + str4 + " encryptKey: " + str5 + " inputType: " + i2 + " authTicket: " + str6 + " isFacebook: " + z + " isMobileAutoLogin: " + z2 + " stack: " + be.bur());
        this.cYR = z;
        this.cYS = z2;
        this.cAt = new al(701);
        d dVar = (d) this.cAt.Bx();
        int i3 = al.zc().getInt("key_auth_update_version", 0);
        v.d("MicroMsg.NetSceneManualAuth", "summerauth updateVersion:%d, clientVersion:%d", Integer.valueOf(i3), Integer.valueOf(com.tencent.mm.protocal.d.lWh));
        if (i3 == 0) {
            dVar.lWQ = 1;
            b.itm.a(148, 0, 1, false);
            dVar.lWE = true;
        } else if (i3 < com.tencent.mm.protocal.d.lWh) {
            dVar.lWQ = 16;
            b.itm.a(148, 1, 1, false);
        } else {
            dVar.lWQ = 1;
        }
        dVar.cW(0);
        ahq com_tencent_mm_protocal_c_ahq = new ahq();
        aho com_tencent_mm_protocal_c_aho = new aho();
        dVar.lWD.mHk = com_tencent_mm_protocal_c_ahq;
        dVar.lWD.mHl = com_tencent_mm_protocal_c_aho;
        com_tencent_mm_protocal_c_aho.mHj = i2;
        em emVar = new em();
        com_tencent_mm_protocal_c_aho.mel = emVar;
        emVar.meg = str6;
        emVar.mfy = 0;
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
        if (i == 1) {
            com_tencent_mm_protocal_c_bgl.mgU = str3;
            com_tencent_mm_protocal_c_bgl.mgT = str4;
            com_tencent_mm_protocal_c_bgl.nbU = str5;
            com_tencent_mm_protocal_c_biv.mAS = SQLiteDatabase.KeyEmpty;
            com_tencent_mm_protocal_c_biv.mAR = SQLiteDatabase.KeyEmpty;
        } else if (i == 3) {
            com_tencent_mm_protocal_c_bgl.mgU = SQLiteDatabase.KeyEmpty;
            com_tencent_mm_protocal_c_bgl.mgT = SQLiteDatabase.KeyEmpty;
            com_tencent_mm_protocal_c_bgl.nbU = SQLiteDatabase.KeyEmpty;
            com_tencent_mm_protocal_c_biv.mAS = str3;
            com_tencent_mm_protocal_c_biv.mAR = str4;
        }
        if (be.kS(str) && g.uz() && com.tencent.mm.kernel.a.uQ() != 0) {
            b.itm.a(148, 2, 1, false);
            this.cYP = (String) g.vw().vf().get(3, null);
            this.cYQ = (String) g.vw().vf().get(19, null);
            com.tencent.mm.protocal.j.e eVar = (com.tencent.mm.protocal.j.e) this.cAt.ze();
            str = be.ma((String) g.vw().vf().get(2, null));
            if (be.kS(str)) {
                str = new o(be.a((Integer) g.vw().vf().get(9, null), 0)).toString();
            } else {
                eVar.dli = str;
            }
        } else if (z || z2) {
            this.cYP = str2;
            this.cYQ = str2;
        } else {
            this.cYP = be.KE(be.ma(str2));
            this.cYQ = be.KF(be.ma(str2));
        }
        com_tencent_mm_protocal_c_ahq.gln = str;
        byte[] bArr = null;
        if (!(i == 1 || i == 3)) {
            if (i == 2) {
                bArr = g.vu().cjh.b(be.getLong(str, 0), str3);
            } else if (be.Kw(str)) {
                bArr = g.vu().cjh.a(be.getLong(str, 0), this.cYQ, true);
            }
        }
        String str7 = "MicroMsg.NetSceneManualAuth";
        String str8 = "summerauth loginbuf len:%d content:[%s]";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        objArr[1] = be.KW(be.bk(bArr));
        v.i(str7, str8, objArr);
        are com_tencent_mm_protocal_c_are = new are();
        if (be.bl(bArr)) {
            bArr = new byte[0];
        }
        emVar.mfv = com_tencent_mm_protocal_c_are.ba(bArr);
        com_tencent_mm_protocal_c_ahq.mgI = this.cYQ;
        com_tencent_mm_protocal_c_ahq.mgS = this.cYP;
    }

    public final void kh(String str) {
        d dVar = (d) this.cAt.Bx();
        dVar.lWD.mHk.mgI = str;
        dVar.lWD.mHk.mgS = str;
        dVar.lWD.mHl.mel.mfv = new are().ba(new byte[0]);
        this.cYP = str;
        this.cYQ = str;
    }

    public final int getType() {
        return 701;
    }

    protected final int ul() {
        return 5;
    }

    protected final int a(p pVar) {
        return b.czU;
    }

    protected final void a(a aVar) {
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cAt, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        d dVar = (d) pVar.Bx();
        final com.tencent.mm.protocal.j.e eVar = (com.tencent.mm.protocal.j.e) pVar.ze();
        this.errType = i2;
        this.errCode = i3;
        baq com_tencent_mm_protocal_c_baq = eVar.lWG;
        if (com_tencent_mm_protocal_c_baq == null) {
            v.w("MicroMsg.NetSceneManualAuth", "summerauth error unifyAuthResp is null!");
            this.cii.a(4, -1, SQLiteDatabase.KeyEmpty, this);
            b.itm.a(148, 3, 1, false);
            return;
        }
        v.i("MicroMsg.NetSceneManualAuth", "summerauth errType:%d, errCode:%d, errMsg:%s unifyAuthResp:%s, unifyFlag:%d, auth:%s, acct:%s, network:%s", Integer.valueOf(i2), Integer.valueOf(i3), str, com_tencent_mm_protocal_c_baq, Integer.valueOf(com_tencent_mm_protocal_c_baq.mXe), com_tencent_mm_protocal_c_baq.mXf, com_tencent_mm_protocal_c_baq.mXg, com_tencent_mm_protocal_c_baq.mXh);
        int i4;
        if (i2 == 0 && i3 == 0) {
            int i5;
            if ((i5 & 2) != 0) {
                ai aiVar = com_tencent_mm_protocal_c_baq.mXg;
                if (aiVar == null || be.kS(aiVar.gln)) {
                    v.w("MicroMsg.NetSceneManualAuth", "summerauth UserName is null and return false!");
                    this.cii.a(4, -1, SQLiteDatabase.KeyEmpty, this);
                    return;
                } else if (al.b(pVar) == 2) {
                    b.itm.a(148, 7, 1, false);
                    v.d("MicroMsg.NetSceneManualAuth", "summerauth decode faild loginDecodeFailedTry:%d", Integer.valueOf(this.cYU));
                    this.cYU++;
                    if (this.cYU > 1) {
                        this.cii.a(4, -1, SQLiteDatabase.KeyEmpty, this);
                        return;
                    }
                    ((d) BD().Bx()).lWD.mHl.mel.mfy = 1;
                    a(this.czE, this.cii);
                    return;
                } else {
                    v.d("MicroMsg.NetSceneManualAuth", "summerauth decode succeed!");
                    g.vA().btu();
                    v.d("MicroMsg.NetSceneManualAuth", "summerauth dkidc setAccUin Begin thread:[%s,%d]", Thread.currentThread().getName(), Integer.valueOf(Process.getThreadPriority(Process.myTid())));
                    aj.a((f) dVar, com_tencent_mm_protocal_c_baq, false);
                    if (this.cYS) {
                        g.vw().vf().set(2, dVar.lWD.mHk.gln);
                    }
                    g.vv().cjC.a(new ay(new com.tencent.mm.model.ay.a(this) {
                        final /* synthetic */ s cYV;

                        public final void a(com.tencent.mm.network.e eVar) {
                            if (eVar == null || eVar.BU() == null || eVar.dlf == null || eVar.lWG == null || eVar.lWG.mXf == null) {
                                b.itm.a(148, 8, 1, false);
                                v.e("MicroMsg.NetSceneManualAuth", "[arthurdan.NetSceneManualAuthCrash] fatal error dispatcher == null || null == dispatcher.getAccInfo() || null == resp.getSession() || null == resp.rImpl || null == resp.rImpl.AuthSectResp !!!");
                                return;
                            }
                            v.d("MicroMsg.NetSceneManualAuth", "summerauth NetSceneLocalProxy setSessionInfo session:%s, uin:%d", be.KW(be.bk(eVar.dlf)), Integer.valueOf(eVar.lWG.mXf.fvo));
                            eVar.BU().i(eVar.dlf, eVar.lWG.mXf.fvo);
                        }
                    }), 0);
                    if (be.f((Integer) g.vw().vf().get(15, null)) != 0) {
                        ((com.tencent.mm.plugin.zero.a.d) g.f(com.tencent.mm.plugin.zero.a.d.class)).Ho().fP(10);
                    }
                    if ((com_tencent_mm_protocal_c_baq.mXf.mej & 8) == 0) {
                        Object xF = com.tencent.mm.model.k.xF();
                        if (!TextUtils.isEmpty(xF)) {
                            g.vv().cjC.a(new q(xF), 0);
                        }
                    } else {
                        v.i("MicroMsg.NetSceneManualAuth", "summerauth not need getProfile authResultFlag:%d", Integer.valueOf(com_tencent_mm_protocal_c_baq.mXf.mej));
                        b.itm.a(148, 9, 1, false);
                    }
                    i5 = 4;
                    if (dVar.lWD.mHl.mel.mfv != null && dVar.lWD.mHl.mel.mfv.mQu > 0) {
                        i5 = 1;
                    } else if (dVar.lWD.mHl.mHj == 1) {
                        i5 = 2;
                    }
                    c.j(1, i5, dVar.lWD.mHk.gln);
                    aj.a(dVar, eVar);
                    if (i2 == 0 && i3 == 0) {
                        aux com_tencent_mm_protocal_c_aux = ((com.tencent.mm.protocal.j.e) this.cAt.ze()).lWG.mXf.mef;
                        if (!(com_tencent_mm_protocal_c_aux == null || com_tencent_mm_protocal_c_aux.mSt == null || com_tencent_mm_protocal_c_aux.mSt.size() <= 0)) {
                            Iterator it = com_tencent_mm_protocal_c_aux.mSt.iterator();
                            while (it.hasNext()) {
                                ayl com_tencent_mm_protocal_c_ayl = (ayl) it.next();
                                if (com_tencent_mm_protocal_c_ayl.itH == 1) {
                                    i4 = be.getInt(com_tencent_mm_protocal_c_ayl.mVS, 0);
                                    break;
                                }
                            }
                        }
                        i4 = 0;
                        com.tencent.mm.plugin.a.b.gM(i4);
                        v.i("MicroMsg.NetSceneManualAuth", "publishManualAuthEvent");
                        com.tencent.mm.sdk.c.b hxVar = new hx();
                        hxVar.bhK.aXR = true;
                        com.tencent.mm.sdk.c.a.nhr.z(hxVar);
                        if (com.tencent.mm.model.ba.a.zv()) {
                            ba.b zx = bb.zx();
                            String a = ba.a(zx);
                            int nextInt = new Random().nextInt();
                            int length = a.length();
                            i5 = length / 1000;
                            if (length % 1000 > 0) {
                                i4 = 1;
                            } else {
                                i4 = 0;
                            }
                            int i6 = i5 + i4;
                            i5 = 0;
                            i4 = 0;
                            while (i4 < a.length()) {
                                int min = Math.min(1000, length - i4);
                                b.itm.a(13690, nextInt + "," + i6 + "," + i5 + ",0,0" + ",," + a.substring(i4, i4 + min), false, true);
                                i4 += min;
                                i5++;
                            }
                            v.d("MicroMsg.NormalMsgReporter", "kvreport: ctxId: %d, dataLen: %d, pkgCount: %d", Integer.valueOf(nextInt), Integer.valueOf(length), Integer.valueOf(i6));
                            ba.a(0, zx);
                        }
                    }
                    g.vA().btw();
                    this.cii.a(i2, i3, str, this);
                    return;
                }
            }
            v.w("MicroMsg.NetSceneManualAuth", "summerauth acct resp is null and return false!");
            this.cii.a(4, -1, SQLiteDatabase.KeyEmpty, this);
        } else if (i2 == 4 && i3 == -301) {
            v.d("MicroMsg.NetSceneManualAuth", "summerauth RedirectIDC");
            b.itm.a(148, 4, 1, false);
            if (com_tencent_mm_protocal_c_baq == null || com_tencent_mm_protocal_c_baq.mXh == null) {
                v.w("MicroMsg.NetSceneManualAuth", "summerauth RedirectIDC but NetworkSectResp is null");
            } else {
                al.a(true, com_tencent_mm_protocal_c_baq.mXh.mgK, com_tencent_mm_protocal_c_baq.mXh.mgL, com_tencent_mm_protocal_c_baq.mXh.mgJ);
            }
            this.czX--;
            if (this.czX <= 0) {
                v.w("MicroMsg.NetSceneManualAuth", "summerauth err and return with no try!");
                this.cii.a(3, -1, SQLiteDatabase.KeyEmpty, this);
                return;
            }
            v.d("MicroMsg.NetSceneManualAuth", "summerauth RedirectIDC do scene again redirectCount:%d", Integer.valueOf(this.czX));
            a(this.czE, this.cii);
        } else if (i2 == 4 && i3 == -102) {
            b.itm.a(148, 5, 1, false);
            i4 = pVar.Bx().lWS.ver;
            v.i("MicroMsg.NetSceneManualAuth", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", Integer.valueOf(i4));
            g.vA().x(new Runnable(this) {
                final /* synthetic */ s cYV;

                public final void run() {
                    new m().a(this.cYV.czE, new e(this) {
                        final /* synthetic */ AnonymousClass1 cYW;

                        {
                            this.cYW = r1;
                        }

                        public final void a(int i, int i2, String str, k kVar) {
                            v.d("MicroMsg.NetSceneManualAuth", "summerauth dkcert getcert type:%d ret [%d,%d]", Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2));
                            if (i == 0 && i2 == 0) {
                                this.cYW.cYV.a(this.cYW.cYV.czE, this.cYW.cYV.cii);
                            } else {
                                this.cYW.cYV.cii.a(i, i2, SQLiteDatabase.KeyEmpty, this.cYW.cYV);
                            }
                        }
                    });
                }

                public final String toString() {
                    return super.toString() + "|onGYNetEnd1";
                }
            });
        } else if (i2 == 4 && i3 == -217) {
            v.i("MicroMsg.NetSceneManualAuth", "summerauth auth MM_ERR_PWDOK_NEED_VOICEPRINT info[%s]", Jg());
            this.cii.a(i2, i3, str, this);
            b.itm.a(148, 47, 1, false);
        } else {
            v.w("MicroMsg.NetSceneManualAuth", "summerauth Failed. callback and return now ! [%d ,%d ,%s]", Integer.valueOf(i3), Integer.valueOf(i2), str);
            this.cii.a(i2, i3, str, this);
            b.itm.a(148, 6, 1, false);
        }
    }

    public final int Fl() {
        if (((com.tencent.mm.protocal.j.e) this.cAt.ze()).lWG.mXf == null) {
            return 3;
        }
        int i;
        aux com_tencent_mm_protocal_c_aux = ((com.tencent.mm.protocal.j.e) this.cAt.ze()).lWG.mXf.mef;
        if (!(com_tencent_mm_protocal_c_aux == null || com_tencent_mm_protocal_c_aux.mSt == null || com_tencent_mm_protocal_c_aux.mSt.size() <= 0)) {
            Iterator it = com_tencent_mm_protocal_c_aux.mSt.iterator();
            while (it.hasNext()) {
                ayl com_tencent_mm_protocal_c_ayl = (ayl) it.next();
                if (com_tencent_mm_protocal_c_ayl.itH == 6) {
                    i = be.getInt(com_tencent_mm_protocal_c_ayl.mVS, 3);
                    break;
                }
            }
        }
        i = 3;
        return i;
    }

    public final a Jg() {
        if (((com.tencent.mm.protocal.j.e) this.cAt.ze()).lWG.mXf == null) {
            return null;
        }
        aux com_tencent_mm_protocal_c_aux = ((com.tencent.mm.protocal.j.e) this.cAt.ze()).lWG.mXf.mef;
        if (!(com_tencent_mm_protocal_c_aux == null || com_tencent_mm_protocal_c_aux.mSt == null || com_tencent_mm_protocal_c_aux.mSt.size() <= 0)) {
            a aVar = new a();
            Iterator it = com_tencent_mm_protocal_c_aux.mSt.iterator();
            while (it.hasNext()) {
                ayl com_tencent_mm_protocal_c_ayl = (ayl) it.next();
                if (com_tencent_mm_protocal_c_ayl.itH == 19) {
                    aVar.bax = com_tencent_mm_protocal_c_ayl.mVS;
                } else if (com_tencent_mm_protocal_c_ayl.itH == 20) {
                    aVar.cYX = com_tencent_mm_protocal_c_ayl.mVS;
                } else if (com_tencent_mm_protocal_c_ayl.itH == 21) {
                    aVar.bhe = com_tencent_mm_protocal_c_ayl.mVS;
                }
            }
            if (!be.kS(aVar.bax)) {
                aVar.username = ((d) this.cAt.Bx()).lWD.mHk.gln;
                return aVar;
            }
        }
        return null;
    }

    public final String Jh() {
        return ((com.tencent.mm.protocal.j.e) this.cAt.ze()).lWG.mXf == null ? SQLiteDatabase.KeyEmpty : ((com.tencent.mm.protocal.j.e) this.cAt.ze()).lWG.mXf.mee;
    }

    public final String Fw() {
        if (((com.tencent.mm.protocal.j.e) this.cAt.ze()).lWG.mXf == null) {
            return SQLiteDatabase.KeyEmpty;
        }
        int Ji = Ji();
        if (Ji == 3) {
            if (((com.tencent.mm.protocal.j.e) this.cAt.ze()).lWG.mXf.mdZ != null) {
                return be.ma(((com.tencent.mm.protocal.j.e) this.cAt.ze()).lWG.mXf.mdZ.mAR);
            }
        } else if (Ji == 1 && ((com.tencent.mm.protocal.j.e) this.cAt.ze()).lWG.mXf.mdY != null) {
            return be.ma(((com.tencent.mm.protocal.j.e) this.cAt.ze()).lWG.mXf.mdY.mgT);
        }
        return SQLiteDatabase.KeyEmpty;
    }

    public final byte[] Fv() {
        if (((com.tencent.mm.protocal.j.e) this.cAt.ze()).lWG.mXf == null) {
            return new byte[0];
        }
        int Ji = Ji();
        if (Ji == 3) {
            if (((com.tencent.mm.protocal.j.e) this.cAt.ze()).lWG.mXf.mdZ != null) {
                return m.a(((com.tencent.mm.protocal.j.e) this.cAt.ze()).lWG.mXf.mdZ.mAU, new byte[0]);
            }
        } else if (Ji == 1) {
            if (((com.tencent.mm.protocal.j.e) this.cAt.ze()).lWG.mXf.mdY != null) {
                return m.a(((com.tencent.mm.protocal.j.e) this.cAt.ze()).lWG.mXf.mdY.mbY, new byte[0]);
            }
        } else if (Ji == 2 && ((d) this.cAt.Bx()).lWD.mHk != null) {
            g.vu().cjh.a(be.getLong(((d) this.cAt.Bx()).lWD.mHk.gln, 0), m.a(((com.tencent.mm.protocal.j.e) this.cAt.ze()).lWG.mXf.mdX));
            return g.vu().cjh.Q(be.getLong(((d) this.cAt.Bx()).lWD.mHk.gln, 0));
        }
        return new byte[0];
    }

    public final int Ji() {
        if (((com.tencent.mm.protocal.j.e) this.cAt.ze()).lWG.mXf == null) {
            v.e("MicroMsg.NetSceneManualAuth", "getSecCodeType ERROR AuthSectResp or WxVerifyCodeRespInfo is null");
            return 0;
        } else if (this.errType != 4) {
            v.e("MicroMsg.NetSceneManualAuth", "getSecCodeType ERROR errType :%d", Integer.valueOf(this.errType));
            return 0;
        } else if (this.errCode == -311) {
            return 2;
        } else {
            if (this.errCode == -6) {
                return 1;
            }
            return this.errCode == -310 ? 3 : 0;
        }
    }

    public final String Jj() {
        if (((com.tencent.mm.protocal.j.e) this.cAt.ze()).lWG.mXf == null) {
            return SQLiteDatabase.KeyEmpty;
        }
        if (Ji() != 1 || ((com.tencent.mm.protocal.j.e) this.cAt.ze()).lWG.mXf.mdY == null) {
            return SQLiteDatabase.KeyEmpty;
        }
        return ((com.tencent.mm.protocal.j.e) this.cAt.ze()).lWG.mXf.mdY.nbU != null ? ((com.tencent.mm.protocal.j.e) this.cAt.ze()).lWG.mXf.mdY.nbU : null;
    }

    public final String Fj() {
        return ((com.tencent.mm.protocal.j.e) this.cAt.ze()).lWG.mXf.meg;
    }

    public final String Jk() {
        return ((com.tencent.mm.protocal.j.e) this.cAt.ze()).lWG.mXg.mat;
    }

    public final int Jl() {
        if (((com.tencent.mm.protocal.j.e) this.cAt.ze()).lWG.mXf == null) {
            return 0;
        }
        int i;
        aux com_tencent_mm_protocal_c_aux = ((com.tencent.mm.protocal.j.e) this.cAt.ze()).lWG.mXf.mef;
        if (!(com_tencent_mm_protocal_c_aux == null || com_tencent_mm_protocal_c_aux.mSt == null || com_tencent_mm_protocal_c_aux.mSt.size() <= 0)) {
            Iterator it = com_tencent_mm_protocal_c_aux.mSt.iterator();
            while (it.hasNext()) {
                ayl com_tencent_mm_protocal_c_ayl = (ayl) it.next();
                if (com_tencent_mm_protocal_c_ayl.itH == 11) {
                    i = be.getInt(com_tencent_mm_protocal_c_ayl.mVS, 0);
                    break;
                }
            }
        }
        i = 0;
        return i;
    }

    public final BindWordingContent Jm() {
        if (((com.tencent.mm.protocal.j.e) this.cAt.ze()).lWG.mXf == null) {
            return null;
        }
        String str;
        BindWordingContent kc;
        aux com_tencent_mm_protocal_c_aux = ((com.tencent.mm.protocal.j.e) this.cAt.ze()).lWG.mXf.mef;
        if (!(com_tencent_mm_protocal_c_aux == null || com_tencent_mm_protocal_c_aux.mSt == null || com_tencent_mm_protocal_c_aux.mSt.size() <= 0)) {
            Iterator it = com_tencent_mm_protocal_c_aux.mSt.iterator();
            while (it.hasNext()) {
                ayl com_tencent_mm_protocal_c_ayl = (ayl) it.next();
                if (com_tencent_mm_protocal_c_ayl.itH == 12) {
                    str = com_tencent_mm_protocal_c_ayl.mVS;
                    break;
                }
            }
        }
        str = null;
        if (str != null) {
            a aVar = new a();
            try {
                kc = a.kc(str);
            } catch (Throwable e) {
                v.a("MicroMsg.NetSceneManualAuth", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                kc = null;
            } catch (Throwable e2) {
                v.a("MicroMsg.NetSceneManualAuth", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
            }
            return kc;
        }
        kc = null;
        return kc;
    }

    public final String Jn() {
        if (((com.tencent.mm.protocal.j.e) this.cAt.ze()).lWG.mXf == null) {
            return SQLiteDatabase.KeyEmpty;
        }
        aux com_tencent_mm_protocal_c_aux = ((com.tencent.mm.protocal.j.e) this.cAt.ze()).lWG.mXf.mef;
        if (!(com_tencent_mm_protocal_c_aux == null || com_tencent_mm_protocal_c_aux.mSt == null || com_tencent_mm_protocal_c_aux.mSt.size() <= 0)) {
            Iterator it = com_tencent_mm_protocal_c_aux.mSt.iterator();
            while (it.hasNext()) {
                ayl com_tencent_mm_protocal_c_ayl = (ayl) it.next();
                if (com_tencent_mm_protocal_c_ayl.itH == 16) {
                    return com_tencent_mm_protocal_c_ayl.mVS;
                }
            }
        }
        return SQLiteDatabase.KeyEmpty;
    }

    public final int Jo() {
        if (((com.tencent.mm.protocal.j.e) this.cAt.ze()).lWG.mXf == null) {
            return 0;
        }
        int i;
        aux com_tencent_mm_protocal_c_aux = ((com.tencent.mm.protocal.j.e) this.cAt.ze()).lWG.mXf.mef;
        if (!(com_tencent_mm_protocal_c_aux == null || com_tencent_mm_protocal_c_aux.mSt == null || com_tencent_mm_protocal_c_aux.mSt.size() <= 0)) {
            Iterator it = com_tencent_mm_protocal_c_aux.mSt.iterator();
            while (it.hasNext()) {
                ayl com_tencent_mm_protocal_c_ayl = (ayl) it.next();
                if (com_tencent_mm_protocal_c_ayl.itH == 13) {
                    i = be.getInt(com_tencent_mm_protocal_c_ayl.mVS, 0);
                    break;
                }
            }
        }
        i = 0;
        return i;
    }

    public final boolean Jp() {
        if (((com.tencent.mm.protocal.j.e) this.cAt.ze()).lWG.mXf == null) {
            return true;
        }
        aux com_tencent_mm_protocal_c_aux = ((com.tencent.mm.protocal.j.e) this.cAt.ze()).lWG.mXf.mef;
        if (!(com_tencent_mm_protocal_c_aux == null || com_tencent_mm_protocal_c_aux.mSt == null || com_tencent_mm_protocal_c_aux.mSt.size() <= 0)) {
            Iterator it = com_tencent_mm_protocal_c_aux.mSt.iterator();
            while (it.hasNext()) {
                ayl com_tencent_mm_protocal_c_ayl = (ayl) it.next();
                if (com_tencent_mm_protocal_c_ayl.itH == 18) {
                    if (be.getInt(com_tencent_mm_protocal_c_ayl.mVS, 0) == 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
