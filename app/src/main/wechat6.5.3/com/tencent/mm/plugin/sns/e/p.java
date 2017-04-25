package com.tencent.mm.plugin.sns.e;

import android.os.Looper;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.network.j;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.ave;
import com.tencent.mm.protocal.c.avh;
import com.tencent.mm.protocal.c.avl;
import com.tencent.mm.protocal.c.avr;
import com.tencent.mm.protocal.c.awa;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.awe;
import com.tencent.mm.protocal.c.awf;
import com.tencent.mm.protocal.c.awg;
import com.tencent.mm.protocal.c.awh;
import com.tencent.mm.protocal.c.awn;
import com.tencent.mm.protocal.c.awo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.tmassistantsdk.logreport.UpdateInfoReportManager.UpdateLogConst;
import java.util.Iterator;
import java.util.LinkedList;

public final class p extends k implements j {
    private b cif;
    public e cii;
    private ac handler;
    public int jdV;
    public long jkf;
    private avr jkg;
    private int jkh;
    public int type;

    public p(int i) {
        this.type = -1;
        this.jkf = 0;
        this.jdV = -1;
        this.jkh = 0;
        this.handler = new ac(Looper.getMainLooper());
        this.type = 11;
        this.jkh = i;
        a aVar = new a();
        aVar.czn = new awg();
        aVar.czo = new awh();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnsobjectop";
        aVar.czm = 218;
        aVar.czp = UpdateLogConst.ACTION_POP_INSTALL_DIALOG;
        aVar.czq = 1000000104;
        this.cif = aVar.Bv();
        awg com_tencent_mm_protocal_c_awg = (awg) this.cif.czk.czs;
        awd com_tencent_mm_protocal_c_awd = new awd();
        com_tencent_mm_protocal_c_awd.gly = 11;
        awo com_tencent_mm_protocal_c_awo = new awo();
        ak.yW();
        int intValue = ((Integer) c.vf().get(t.a.nrY, Integer.valueOf(0))).intValue();
        com_tencent_mm_protocal_c_awo.mTV = i;
        com_tencent_mm_protocal_c_awo.mTW = intValue;
        v.i("MicroMsg.NetSceneSnsObjectOp", "switchState " + i + " count " + intValue);
        try {
            com_tencent_mm_protocal_c_awd.mMh = new are().ba(com_tencent_mm_protocal_c_awo.toByteArray());
        } catch (Exception e) {
            v.e("MicroMsg.NetSceneSnsObjectOp", "opSwitch error " + e.getMessage());
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(com_tencent_mm_protocal_c_awd);
        com_tencent_mm_protocal_c_awg.mTF = linkedList;
        com_tencent_mm_protocal_c_awg.mTE = linkedList.size();
    }

    public p(long j, int i) {
        this(j, i, null, null);
    }

    public p(long j, int i, avr com_tencent_mm_protocal_c_avr) {
        this(j, i, com_tencent_mm_protocal_c_avr, null);
    }

    public p(long j, int i, avr com_tencent_mm_protocal_c_avr, Object obj) {
        this.type = -1;
        this.jkf = 0;
        this.jdV = -1;
        this.jkh = 0;
        this.handler = new ac(Looper.getMainLooper());
        this.jkg = com_tencent_mm_protocal_c_avr;
        this.type = i;
        this.jkf = j;
        v.i("MicroMsg.NetSceneSnsObjectOp", "snsId : " + j + "  op : " + i);
        if (com_tencent_mm_protocal_c_avr != null) {
            v.i("MicroMsg.NetSceneSnsObjectOp", com_tencent_mm_protocal_c_avr.mSN + " " + com_tencent_mm_protocal_c_avr.mSQ);
        }
        a aVar = new a();
        aVar.czn = new awg();
        aVar.czo = new awh();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnsobjectop";
        aVar.czm = 218;
        aVar.czp = UpdateLogConst.ACTION_POP_INSTALL_DIALOG;
        aVar.czq = 1000000104;
        this.cif = aVar.Bv();
        awg com_tencent_mm_protocal_c_awg = (awg) this.cif.czk.czs;
        com.tencent.mm.plugin.sns.storage.k dd = ad.aSE().dd(j);
        if (dd != null) {
            this.jdV = dd.jBI;
        }
        awd a = a(j, i, this.jkg, obj);
        LinkedList linkedList = new LinkedList();
        linkedList.add(a);
        com_tencent_mm_protocal_c_awg.mTF = linkedList;
        com_tencent_mm_protocal_c_awg.mTE = linkedList.size();
    }

    public p(long j, int i, int i2, String str) {
        this.type = -1;
        this.jkf = 0;
        this.jdV = -1;
        this.jkh = 0;
        this.handler = new ac(Looper.getMainLooper());
        this.jkg = null;
        this.type = 9;
        this.jkf = j;
        v.i("MicroMsg.NetSceneSnsObjectOp", "snsId : " + j + "  op : " + this.type);
        a aVar = new a();
        aVar.czn = new awg();
        aVar.czo = new awh();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsnsobjectop";
        aVar.czm = 218;
        aVar.czp = UpdateLogConst.ACTION_POP_INSTALL_DIALOG;
        aVar.czq = 1000000104;
        this.cif = aVar.Bv();
        awg com_tencent_mm_protocal_c_awg = (awg) this.cif.czk.czs;
        com.tencent.mm.plugin.sns.storage.k dd = ad.aSE().dd(j);
        if (dd != null) {
            this.jdV = dd.jBI;
        }
        awd t = t(j, this.type);
        awf com_tencent_mm_protocal_c_awf = new awf();
        com_tencent_mm_protocal_c_awf.maG = i;
        com_tencent_mm_protocal_c_awf.mTC = i2;
        com_tencent_mm_protocal_c_awf.mTD = m.lY(str);
        try {
            t.mMh = new are().ba(com_tencent_mm_protocal_c_awf.toByteArray());
        } catch (Throwable e) {
            v.a("MicroMsg.NetSceneSnsObjectOp", e, "", new Object[0]);
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(t);
        com_tencent_mm_protocal_c_awg.mTF = linkedList;
        com_tencent_mm_protocal_c_awg.mTE = linkedList.size();
    }

    private static awd a(long j, int i, avr com_tencent_mm_protocal_c_avr, Object obj) {
        awd t = t(j, i);
        v.i("MicroMsg.NetSceneSnsObjectOp", "getSnsObjectOp " + i + " " + (obj == null ? "" : obj.toString()));
        com.tencent.mm.plugin.sns.storage.k kVar = null;
        String str = "";
        if (i == 8 || i == 10 || i == 7 || i == 8 || i == 6) {
            com.tencent.mm.plugin.sns.storage.c cV = ad.aSF().cV(j);
            if (cV != null) {
                kVar = cV.aUr();
            }
            if (kVar != null && kVar.qC(32)) {
                com.tencent.mm.plugin.sns.storage.a aUo = kVar.aUo();
                str = aUo == null ? "" : aUo.jpt;
                v.i("MicroMsg.NetSceneSnsObjectOp", "aduxinfo " + str);
            }
        }
        if (i == 6) {
            if (com_tencent_mm_protocal_c_avr == null || (com_tencent_mm_protocal_c_avr.mSN == 0 && com_tencent_mm_protocal_c_avr.mSQ == 0)) {
                return t;
            }
            avl com_tencent_mm_protocal_c_avl = new avl();
            com_tencent_mm_protocal_c_avl.mSJ = com_tencent_mm_protocal_c_avr.mSQ;
            com_tencent_mm_protocal_c_avl.mSC = m.lY(be.ah(str, ""));
            try {
                t.mMh = new are().ba(com_tencent_mm_protocal_c_avl.toByteArray());
            } catch (Throwable e) {
                v.a("MicroMsg.NetSceneSnsObjectOp", e, "", new Object[0]);
            }
        } else if (i == 7) {
            ave com_tencent_mm_protocal_c_ave = new ave();
            com_tencent_mm_protocal_c_ave.mSC = m.lY(be.ah(str, ""));
            try {
                t.mMh = new are().ba(com_tencent_mm_protocal_c_ave.toByteArray());
            } catch (Throwable e2) {
                v.a("MicroMsg.NetSceneSnsObjectOp", e2, "", new Object[0]);
            }
        } else if (i == 8) {
            ad.aSF().delete(j);
            ad.aSH().cX(j);
            avh com_tencent_mm_protocal_c_avh = new avh();
            com_tencent_mm_protocal_c_avh.mSC = m.lY(be.ah(str, ""));
            try {
                t.mMh = new are().ba(com_tencent_mm_protocal_c_avh.toByteArray());
            } catch (Throwable e22) {
                v.a("MicroMsg.NetSceneSnsObjectOp", e22, "", new Object[0]);
            }
        } else if (i == 4) {
            if (com_tencent_mm_protocal_c_avr == null || (com_tencent_mm_protocal_c_avr.mSN == 0 && com_tencent_mm_protocal_c_avr.mSQ == 0)) {
                return t;
            }
            awe com_tencent_mm_protocal_c_awe = new awe();
            com_tencent_mm_protocal_c_awe.mSN = com_tencent_mm_protocal_c_avr.mSN;
            try {
                t.mMh = new are().ba(com_tencent_mm_protocal_c_awe.toByteArray());
            } catch (Throwable e222) {
                v.a("MicroMsg.NetSceneSnsObjectOp", e222, "", new Object[0]);
            }
        } else if (i == 10) {
            awn com_tencent_mm_protocal_c_awn = new awn();
            if (obj instanceof com.tencent.mm.ba.b) {
                com.tencent.mm.ba.b bVar = (com.tencent.mm.ba.b) obj;
                com_tencent_mm_protocal_c_awn.mTU = m.H(bVar.lVU);
                v.i("MicroMsg.NetSceneSnsObjectOp", "NetSceneSnsObjectOpticket " + bVar.lVU.length);
            } else {
                v.e("MicroMsg.NetSceneSnsObjectOp", "error ticket");
            }
            try {
                byte[] toByteArray = com_tencent_mm_protocal_c_awn.toByteArray();
                t.mMh = new are().ba(toByteArray);
                v.i("MicroMsg.NetSceneSnsObjectOp", "opFree " + toByteArray.length);
            } catch (Throwable e2222) {
                v.e("MicroMsg.NetSceneSnsObjectOp", "error ticket " + e2222.getMessage());
                v.a("MicroMsg.NetSceneSnsObjectOp", e2222, "", new Object[0]);
            }
        }
        return t;
    }

    private static awd t(long j, int i) {
        awd com_tencent_mm_protocal_c_awd = new awd();
        com_tencent_mm_protocal_c_awd.mMh = new are();
        com_tencent_mm_protocal_c_awd.mjq = j;
        com_tencent_mm_protocal_c_awd.gly = i;
        return com_tencent_mm_protocal_c_awd;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final int getType() {
        return 218;
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneSnsObjectOp", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            com.tencent.mm.plugin.sns.storage.k dd;
            awa com_tencent_mm_protocal_c_awa;
            Iterator it;
            Object obj;
            switch (this.type) {
                case 1:
                    ad.aSD().cQ(this.jkf);
                    ad.aSE().delete(this.jkf);
                    break;
                case 2:
                    dd = ad.aSE().dd(this.jkf);
                    if (dd != null) {
                        dd.field_pravited = 1;
                        dd.aUF();
                        ad.aSE().b(this.jkf, dd);
                        break;
                    }
                    break;
                case 3:
                    dd = ad.aSE().dd(this.jkf);
                    if (dd != null) {
                        dd.field_pravited = 0;
                        dd.field_localPrivate = 0;
                        dd.aUI();
                        ad.aSE().b(this.jkf, dd);
                        break;
                    }
                    break;
                case 4:
                    com.tencent.mm.plugin.sns.storage.k dd2 = ad.aSE().dd(this.jkf);
                    if (dd2 != null) {
                        try {
                            com_tencent_mm_protocal_c_awa = (awa) new awa().az(dd2.field_attrBuf);
                            it = com_tencent_mm_protocal_c_awa.mTn.iterator();
                            while (it.hasNext()) {
                                obj = (avr) it.next();
                                if (this.jkg != null && obj.mSN == this.jkg.mSN) {
                                    if (obj != null) {
                                        com_tencent_mm_protocal_c_awa.mTn.remove(obj);
                                    }
                                    dd2.aC(com_tencent_mm_protocal_c_awa.toByteArray());
                                    ad.aSE().z(dd2);
                                    ad.aSH().e(dd2.field_snsId, (long) this.jkg.mSN, this.jkg.efm);
                                    break;
                                }
                            }
                            obj = null;
                            if (obj != null) {
                                com_tencent_mm_protocal_c_awa.mTn.remove(obj);
                            }
                            dd2.aC(com_tencent_mm_protocal_c_awa.toByteArray());
                            ad.aSE().z(dd2);
                            ad.aSH().e(dd2.field_snsId, (long) this.jkg.mSN, this.jkg.efm);
                        } catch (Throwable e) {
                            v.a("MicroMsg.NetSceneSnsObjectOp", e, "", new Object[0]);
                            break;
                        }
                    }
                    break;
                case 5:
                    ad.aSD().cS(this.jkf);
                    break;
                case 6:
                    com.tencent.mm.plugin.sns.storage.c cV = ad.aSF().cV(this.jkf);
                    if (cV != null) {
                        try {
                            com_tencent_mm_protocal_c_awa = (awa) new awa().az(cV.field_attrBuf);
                            it = com_tencent_mm_protocal_c_awa.mTn.iterator();
                            while (it.hasNext()) {
                                obj = (avr) it.next();
                                if (this.jkg != null && obj.mSQ == this.jkg.mSQ) {
                                    if (obj != null) {
                                        com_tencent_mm_protocal_c_awa.mTn.remove(obj);
                                    }
                                    cV.aC(com_tencent_mm_protocal_c_awa.toByteArray());
                                    ad.aSF().a(cV);
                                    ad.aSH().e(cV.field_snsId, this.jkg.mSQ, this.jkg.efm);
                                    break;
                                }
                            }
                            obj = null;
                            if (obj != null) {
                                com_tencent_mm_protocal_c_awa.mTn.remove(obj);
                            }
                            cV.aC(com_tencent_mm_protocal_c_awa.toByteArray());
                            ad.aSF().a(cV);
                            ad.aSH().e(cV.field_snsId, this.jkg.mSQ, this.jkg.efm);
                        } catch (Throwable e2) {
                            v.a("MicroMsg.NetSceneSnsObjectOp", e2, "", new Object[0]);
                            break;
                        }
                    }
                    break;
                case 7:
                    ad.aSD().cS(this.jkf);
                    break;
                case 8:
                    ad.aSF().delete(this.jkf);
                    ad.aSH().cX(this.jkf);
                    break;
                case 9:
                    dd = ad.aSE().dd(this.jkf);
                    if (dd != null) {
                        dd.qD(2);
                        ad.aSE().b(this.jkf, dd);
                        break;
                    }
                    break;
                case 11:
                    v.i("MicroMsg.NetSceneSnsObjectOp", "scene end switch " + this.jkh);
                    if (this.jkh == 0) {
                        ak.yW();
                        c.vf().a(t.a.nrW, Boolean.valueOf(true));
                    } else if (this.jkh == 1) {
                        ak.yW();
                        c.vf().a(t.a.nrW, Boolean.valueOf(false));
                    }
                    ak.yW();
                    int intValue = ((Integer) c.vf().get(t.a.nrY, Integer.valueOf(0))).intValue();
                    ak.yW();
                    c.vf().a(t.a.nrY, Integer.valueOf(intValue + 1));
                    ak.yW();
                    intValue = ((Integer) c.vf().get(t.a.nrZ, Integer.valueOf(0))).intValue();
                    int i4;
                    if (this.jkh == 0) {
                        intValue++;
                        i4 = (intValue * 2) + 198;
                        if (i4 >= 216) {
                            i4 = 216;
                        }
                        if (i4 >= 200) {
                            com.tencent.mm.plugin.sns.lucky.b.b.kZ(i4);
                        }
                        v.i("MicroMsg.NetSceneSnsObjectOp", "opcount open " + i4 + " " + intValue);
                    } else if (this.jkh == 1) {
                        intValue++;
                        i4 = ((intValue * 2) + 198) + 1;
                        if (i4 >= 217) {
                            i4 = 217;
                        }
                        if (i4 >= 201) {
                            com.tencent.mm.plugin.sns.lucky.b.b.kZ(i4);
                        }
                        v.i("MicroMsg.NetSceneSnsObjectOp", "opcount close " + i4 + " " + intValue);
                    }
                    ak.yW();
                    c.vf().a(t.a.nrZ, Integer.valueOf(intValue));
                    break;
            }
            ad.aSD().aSf();
            this.cii.a(i2, i3, str, this);
            return;
        }
        if (i2 == 4 && this.type == 1) {
            switch (this.type) {
                case 1:
                    ad.aSD().cQ(this.jkf);
                    break;
                case 5:
                case 7:
                    ad.aSD().cS(this.jkf);
                    break;
            }
        }
        this.cii.a(i2, i3, str, this);
    }
}
