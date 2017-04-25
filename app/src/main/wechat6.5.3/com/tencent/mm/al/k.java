package com.tencent.mm.al;

import android.os.Looper;
import com.tencent.mm.e.a.fa;
import com.tencent.mm.e.a.jw;
import com.tencent.mm.e.a.pv;
import com.tencent.mm.h.c;
import com.tencent.mm.model.ak;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.protocal.c.ali;
import com.tencent.mm.protocal.c.xp;
import com.tencent.mm.protocal.c.xq;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.m;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class k extends com.tencent.mm.v.k implements j, m {
    private int aZc;
    private boolean cUp;
    private b cif;
    private e cii;
    private int flags;

    public k(boolean z) {
        this.cUp = false;
        this.flags = -1;
        this.aZc = 26;
        this.cUp = false;
        v.d("MicroMsg.NetSceneGetPackageList", new StringBuilder("Init dkregcode:26").toString());
        v.d("MicroMsg.NetSceneGetPackageList", "isOnlyCheckInReqList: %b", Boolean.valueOf(z));
        if (z) {
            this.flags = 1;
        }
    }

    public k(int i) {
        this.cUp = false;
        this.flags = -1;
        this.aZc = i;
        this.cUp = false;
        v.d("MicroMsg.NetSceneGetPackageList", "Init dkregcode:" + i);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        v.d("MicroMsg.NetSceneGetPackageList", "DoScene dkregcode :" + this.aZc);
        a aVar = new a();
        aVar.czn = new xp();
        aVar.czo = new xq();
        aVar.uri = "/cgi-bin/micromsg-bin/getpackagelist";
        aVar.czm = 159;
        aVar.czp = 51;
        aVar.czq = 1000000051;
        this.cif = aVar.Bv();
        xp xpVar = (xp) this.cif.czk.czs;
        LinkedList linkedList = new LinkedList();
        if (!ak.uz()) {
            return -1;
        }
        m[] fU = t.HS().fU(this.aZc);
        if (fU != null && fU.length > 0) {
            for (int i = 0; i < fU.length; i++) {
                ali com_tencent_mm_protocal_c_ali = new ali();
                com_tencent_mm_protocal_c_ali.gof = fU[i].id;
                if (q.dpZ && this.aZc == 7) {
                    v.d("MicroMsg.NetSceneGetPackageList", "isShakeGetConfigList");
                    com_tencent_mm_protocal_c_ali.efl = 0;
                } else {
                    com_tencent_mm_protocal_c_ali.efl = fU[i].version;
                }
                v.d("MicroMsg.NetSceneGetPackageList", "package, id:%d, ver:%d", Integer.valueOf(com_tencent_mm_protocal_c_ali.gof), Integer.valueOf(com_tencent_mm_protocal_c_ali.efl));
                linkedList.add(com_tencent_mm_protocal_c_ali);
            }
        }
        xpVar.eeu = linkedList;
        xpVar.eet = linkedList.size();
        xpVar.efm = this.aZc;
        if (this.flags != -1) {
            xpVar.mbK = this.flags;
        }
        return a(eVar, this.cif, this);
    }

    protected final int a(p pVar) {
        return b.czU;
    }

    protected final int ul() {
        return 20;
    }

    protected final void a(a aVar) {
    }

    public final boolean Bz() {
        return true;
    }

    private m a(ali com_tencent_mm_protocal_c_ali) {
        m mVar = new m();
        mVar.id = com_tencent_mm_protocal_c_ali.gof;
        mVar.version = com_tencent_mm_protocal_c_ali.efl;
        mVar.name = com_tencent_mm_protocal_c_ali.gkB;
        mVar.size = com_tencent_mm_protocal_c_ali.efj;
        mVar.cUu = com_tencent_mm_protocal_c_ali.mqd;
        mVar.status = 5;
        mVar.cUv = this.aZc;
        return mVar;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneGetPackageList", "onGYNetEnd, netid:%d, errType:%d, errCode:%d, pkgType:%d, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.aZc), str);
        if (i2 == 0 || i3 == 0) {
            xq xqVar = (xq) ((b) pVar).czl.czs;
            if (xqVar.efm != this.aZc) {
                v.e("MicroMsg.NetSceneGetPackageList", "packageType is not consistent, respType = %d", Integer.valueOf(xqVar.efm));
                this.cii.a(3, -1, SQLiteDatabase.KeyEmpty, this);
                return;
            }
            LinkedList linkedList = xqVar.eeu;
            v.v("MicroMsg.NetSceneGetPackageList", "summer list size:" + (linkedList == null ? 0 : linkedList.size()) + " packageType: " + this.aZc + " resp.Type: " + xqVar.efm);
            if (this.aZc == 2) {
                j(linkedList);
            } else if (this.aZc == 1) {
                i(linkedList);
            } else if (this.aZc == 4) {
                k(linkedList);
            } else if (this.aZc == 6) {
                v.i("MicroMsg.NetSceneGetPackageList", "change new egg.");
            } else if (this.aZc == 7) {
                l(linkedList);
            } else if (this.aZc == 8) {
                if (linkedList == null || linkedList.size() <= 0) {
                    v.d("MicroMsg.NetSceneGetPackageList", "empty regioncode pkg list");
                } else {
                    v.d("MicroMsg.NetSceneGetPackageList", "pkgList size " + linkedList.size());
                    r1 = (ali) linkedList.get(0);
                    r3 = t.HS().aK(r1.gof, this.aZc);
                    r4 = a(r1);
                    r4.bkU = -1;
                    if (r3 == null) {
                        t.HS().a(r4);
                    } else {
                        t.HS().b(r4);
                    }
                    v.d("MicroMsg.NetSceneGetPackageList", r1.gkB + " - " + r1.gof + " - " + r1.mqd + " - " + r1.efj);
                }
            } else if (this.aZc == 9) {
                h(linkedList);
            } else if (this.aZc == 10) {
                if (linkedList == null || linkedList.size() <= 0) {
                    v.e("MicroMsg.NetSceneGetPackageList", "empty mass send top config package");
                } else {
                    v.d("MicroMsg.NetSceneGetPackageList", "pkgList size " + linkedList.size());
                    r1 = (ali) linkedList.get(0);
                    r3 = t.HS().aK(r1.gof, this.aZc);
                    r1 = a(r1);
                    r1.bkU = -1;
                    if (r3 == null) {
                        t.HS().a(r1);
                    } else {
                        t.HS().b(r1);
                    }
                }
            } else if (this.aZc != 11) {
                if (this.aZc == 12) {
                    n(linkedList);
                } else if (this.aZc == 5) {
                    o(linkedList);
                } else if (this.aZc == 20) {
                    m(linkedList);
                } else if (this.aZc == 17) {
                    if (linkedList == null || linkedList.size() == 0) {
                        v.d("MicroMsg.NetSceneGetPackageList", "poi type is null");
                    } else {
                        r1 = (ali) linkedList.get(0);
                        v.d("MicroMsg.NetSceneGetPackageList", r1.gkB + " - " + r1.gof + " - " + r1.mqd + " - " + r1.efj);
                        r3 = t.HS().aK(r1.gof, this.aZc);
                        r4 = a(r1);
                        r4.bkU = -1;
                        if (r3 == null) {
                            t.HS().a(r4);
                        } else {
                            t.HS().b(r4);
                        }
                        com.tencent.mm.sdk.c.b jwVar = new jw();
                        try {
                            jwVar.bkA.content = com.tencent.mm.platformtools.m.a(r1.mcO);
                            if (jwVar.bkA.content != null) {
                                com.tencent.mm.sdk.c.a.nhr.a(jwVar, Looper.getMainLooper());
                            }
                        } catch (Exception e) {
                            v.e("MicroMsg.NetSceneGetPackageList", e.getMessage());
                        }
                    }
                } else if (this.aZc == 18) {
                    if (linkedList == null || linkedList.size() == 0) {
                        v.d("MicroMsg.NetSceneGetPackageList", "feature list type is null");
                    } else {
                        r1 = (ali) linkedList.get(0);
                        v.d("MicroMsg.NetSceneGetPackageList", r1.gkB + " - " + r1.gof + " - " + r1.mqd + " - " + r1.efj + "-" + r1.efl);
                        r3 = t.HS().aK(r1.gof, this.aZc);
                        if (r3 == null) {
                            v.i("MicroMsg.NetSceneGetPackageList", "Feature List First Time Update");
                            t.HS().a(a(r1));
                            b(r1);
                        } else if (r3.version < r1.efl) {
                            v.i("MicroMsg.NetSceneGetPackageList", "Feature List New Version");
                            t.HS().b(a(r1));
                            b(r1);
                        } else {
                            v.i("MicroMsg.NetSceneGetPackageList", "Feature List Old Version");
                        }
                    }
                } else if (this.aZc == 19) {
                    K(linkedList);
                } else if (this.aZc == 21) {
                    if (linkedList == null || linkedList.size() <= 0) {
                        v.d("MicroMsg.NetSceneGetPackageList", "summer trace config empty scene list");
                    } else {
                        r1 = (ali) linkedList.get(0);
                        v.d("MicroMsg.NetSceneGetPackageList", "summer getpackage pkg: " + r1 + "|id = " + r1.gof + "|Name = " + r1.gkB + "|PackName = " + r1.mqd + "|Size = " + r1.efj + "|Version = " + r1.efl);
                        r3 = t.HS().aK(r1.gof, this.aZc);
                        r1 = a(r1);
                        r1.bkU = -1;
                        if (r3 == null) {
                            t.HS().a(r1);
                        } else if (r3.version < r1.version) {
                            t.HS().b(r1);
                        } else {
                            v.d("MicroMsg.NetSceneGetPackageList", "summer old version [%d] new version[%d], not need update", Integer.valueOf(r3.version), Integer.valueOf(r1.version));
                        }
                    }
                } else if (23 == this.aZc) {
                    if (linkedList == null || linkedList.size() <= 0) {
                        v.d("MicroMsg.NetSceneGetPackageList", "permission tips config is empty");
                    } else {
                        r1 = (ali) linkedList.get(0);
                        v.d("MicroMsg.NetSceneGetPackageList", "permission getpackage pkg: " + r1 + "|id = " + r1.gof + "|Name = " + r1.gkB + "|PackName = " + r1.mqd + "|Size = " + r1.efj + "|Version = " + r1.efl);
                        r3 = t.HS().aK(r1.gof, this.aZc);
                        r1 = a(r1);
                        r1.bkU = -1;
                        if (r3 == null) {
                            t.HS().a(r1);
                        } else if (r3.version < r1.version) {
                            t.HS().b(r1);
                        }
                    }
                } else if (this.aZc == 26) {
                    L(linkedList);
                } else if (this.aZc == 36) {
                    M(linkedList);
                } else if (this.aZc == 37) {
                    p(linkedList);
                }
            }
            com.tencent.mm.sdk.c.b pvVar = new pv();
            pvVar.bre.brf = linkedList;
            pvVar.bre.aZc = this.aZc;
            com.tencent.mm.sdk.c.a.nhr.z(pvVar);
            if (xqVar.miR <= 0) {
                this.cii.a(i2, i3, str, this);
                return;
            } else if (a(this.czE, this.cii) == -1) {
                this.cii.a(3, -1, "doScene failed", this);
                return;
            } else {
                return;
            }
        }
        this.cii.a(i2, i3, str, this);
    }

    private static void b(ali com_tencent_mm_protocal_c_ali) {
        com.tencent.mm.sdk.c.b faVar = new fa();
        faVar.bei.bej = com_tencent_mm_protocal_c_ali;
        com.tencent.mm.sdk.c.a.nhr.z(faVar);
    }

    protected final boolean b(com.tencent.mm.v.k kVar) {
        if ((kVar instanceof k) && this.aZc == ((k) kVar).aZc) {
            return false;
        }
        return true;
    }

    private void h(LinkedList<ali> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            v.d("MicroMsg.NetSceneGetPackageList", "empty upload speex config list");
            return;
        }
        t.HS();
        String HO = n.HO();
        for (int i = 0; i < linkedList.size(); i++) {
            ali com_tencent_mm_protocal_c_ali = (ali) linkedList.get(i);
            m aK = t.HS().aK(com_tencent_mm_protocal_c_ali.gof, this.aZc);
            if (aK == null || aK.version != com_tencent_mm_protocal_c_ali.efl) {
                com.tencent.mm.loader.stub.b.deleteFile(HO + t.HS().aM(com_tencent_mm_protocal_c_ali.gof, this.aZc));
                m a = a(com_tencent_mm_protocal_c_ali);
                a.bkU = -1;
                if (aK == null) {
                    t.HS().a(a);
                } else {
                    t.HS().b(a);
                }
                ak.vy().a(new j(a.id, 9), 0);
            }
            if (com.tencent.mm.platformtools.m.a(com_tencent_mm_protocal_c_ali.mcO) != null) {
                v.v("MicroMsg.NetSceneGetPackageList", "xml:" + new String(com.tencent.mm.platformtools.m.a(com_tencent_mm_protocal_c_ali.mcO)));
            }
            if (com.tencent.mm.platformtools.m.a(com_tencent_mm_protocal_c_ali.mMh) != null) {
                v.v("MicroMsg.NetSceneGetPackageList", "xml2:" + new String(com.tencent.mm.platformtools.m.a(com_tencent_mm_protocal_c_ali.mMh)));
            }
            v.v("MicroMsg.NetSceneGetPackageList", "xml3:" + com_tencent_mm_protocal_c_ali.toString());
            v.v("MicroMsg.NetSceneGetPackageList", "xml4:" + com_tencent_mm_protocal_c_ali.gkB);
            v.v("MicroMsg.NetSceneGetPackageList", "xml5:" + com_tencent_mm_protocal_c_ali.mqd);
        }
    }

    private void i(LinkedList<ali> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            v.d("MicroMsg.NetSceneGetPackageList", "empty background pkg list");
            return;
        }
        t.HS();
        String HO = n.HO();
        for (int i = 0; i < linkedList.size(); i++) {
            ali com_tencent_mm_protocal_c_ali = (ali) linkedList.get(i);
            m aK = t.HS().aK(com_tencent_mm_protocal_c_ali.gof, this.aZc);
            if (aK == null || aK.version != com_tencent_mm_protocal_c_ali.efl) {
                com.tencent.mm.loader.stub.b.deleteFile(HO + t.HS().aM(com_tencent_mm_protocal_c_ali.gof, this.aZc));
                m a = a(com_tencent_mm_protocal_c_ali);
                a.bkU = -1;
                if (aK == null) {
                    t.HS().a(a);
                } else {
                    t.HS().b(a);
                }
            }
            byte[] a2 = com.tencent.mm.platformtools.m.a(com_tencent_mm_protocal_c_ali.mcO);
            if (a2 != null && a2.length > 0) {
                t.HS();
                String aL = n.aL(com_tencent_mm_protocal_c_ali.gof, this.aZc);
                com.tencent.mm.loader.stub.b.deleteFile(HO + aL);
                com.tencent.mm.a.e.a(HO, aL, a2);
            }
        }
    }

    @Deprecated
    private void j(LinkedList<ali> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            v.d("MicroMsg.NetSceneGetPackageList", "empty emoji pkg list");
            return;
        }
        for (int i = 0; i < linkedList.size(); i++) {
            ali com_tencent_mm_protocal_c_ali = (ali) linkedList.get(i);
            m aK = t.HS().aK(com_tencent_mm_protocal_c_ali.gof, this.aZc);
            m a = a(com_tencent_mm_protocal_c_ali);
            a.bkU = -1;
            if (aK == null) {
                t.HS().a(a);
            } else {
                t.HS().b(a);
            }
            byte[] a2 = com.tencent.mm.platformtools.m.a(com_tencent_mm_protocal_c_ali.mcO);
            if (a2 != null && a2.length > 0) {
                List arrayList = new ArrayList();
                arrayList.add(new String(a2));
                arrayList.size();
            }
        }
    }

    private void k(LinkedList<ali> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            v.d("MicroMsg.NetSceneGetPackageList", "empty emoji pkg list");
            return;
        }
        v.d("MicroMsg.NetSceneGetPackageList", "pkgList size " + linkedList.size());
        t.HS();
        String HO = n.HO();
        for (int i = 0; i < linkedList.size(); i++) {
            ali com_tencent_mm_protocal_c_ali = (ali) linkedList.get(i);
            m aK = t.HS().aK(com_tencent_mm_protocal_c_ali.gof, this.aZc);
            byte[] a = com.tencent.mm.platformtools.m.a(com_tencent_mm_protocal_c_ali.mcO);
            if (com_tencent_mm_protocal_c_ali.mcO == null) {
                v.e("MicroMsg.NetSceneGetPackageList", "error give me a null thumb it should be xml");
            } else {
                if (aK == null || aK.version != com_tencent_mm_protocal_c_ali.efl) {
                    String str = new String(a);
                    String str2 = "zh_CN";
                    if (str.indexOf(str2) < 0) {
                        str2 = "en";
                        if (str.indexOf(str2) < 0) {
                            str2 = "zh_TW";
                            if (str.indexOf(str2) < 0) {
                                str2 = "en";
                            }
                        }
                    }
                    str = str2 + "_ARTIST.mm";
                    com.tencent.mm.loader.stub.b.deleteFile(HO + str);
                    com.tencent.mm.loader.stub.b.deleteFile(HO + str2 + "_ARTISTF.mm");
                    com.tencent.mm.a.e.a(HO, str, a);
                }
                m a2 = a(com_tencent_mm_protocal_c_ali);
                a2.bkU = -1;
                if (aK == null) {
                    t.HS().a(a2);
                } else {
                    t.HS().b(a2);
                }
                v.d("MicroMsg.NetSceneGetPackageList", com_tencent_mm_protocal_c_ali.gkB + " - " + com_tencent_mm_protocal_c_ali.gof + " - " + com_tencent_mm_protocal_c_ali.mqd + " - " + com_tencent_mm_protocal_c_ali.efj);
            }
        }
    }

    private void l(LinkedList<ali> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            v.d("MicroMsg.NetSceneGetPackageList", "empty config list");
            return;
        }
        v.d("MicroMsg.NetSceneGetPackageList", "updateConfigList pkgList size " + linkedList.size());
        for (int i = 0; i < linkedList.size(); i++) {
            ali com_tencent_mm_protocal_c_ali = (ali) linkedList.get(i);
            m aK = t.HS().aK(com_tencent_mm_protocal_c_ali.gof, this.aZc);
            m a = a(com_tencent_mm_protocal_c_ali);
            a.bkU = -1;
            if (aK == null) {
                t.HS().a(a);
            } else {
                t.HS().b(a);
            }
            v.d("MicroMsg.NetSceneGetPackageList", com_tencent_mm_protocal_c_ali.gkB + " - " + com_tencent_mm_protocal_c_ali.gof + " - " + com_tencent_mm_protocal_c_ali.mqd + " - " + com_tencent_mm_protocal_c_ali.efj);
            byte[] a2 = com.tencent.mm.platformtools.m.a(com_tencent_mm_protocal_c_ali.mcO);
            v.d("MicroMsg.NetSceneGetPackageList", "ConfigList xml : " + new String(a2));
            c sV = com.tencent.mm.h.j.sV();
            int i2 = com_tencent_mm_protocal_c_ali.gof;
            File file = new File(c.cgM);
            if (!file.exists()) {
                file.mkdir();
            }
            try {
                file = new File(c.dZ(i2));
                if (!file.exists()) {
                    file.createNewFile();
                }
                com.tencent.mm.a.e.b(c.dZ(i2), a2, a2.length);
                sV.m(i2, new String(a2));
            } catch (Throwable e) {
                v.e("MicroMsg.ConfigListDecoder", "exception:%s", be.e(e));
            }
        }
    }

    private void m(LinkedList<ali> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            v.d("MicroMsg.NetSceneGetPackageList", "empty regioncode pkg list");
            return;
        }
        v.d("MicroMsg.NetSceneGetPackageList", "pkgList size " + linkedList.size());
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ali com_tencent_mm_protocal_c_ali = (ali) it.next();
            m aK = t.HS().aK(com_tencent_mm_protocal_c_ali.gof, this.aZc);
            m a = a(com_tencent_mm_protocal_c_ali);
            a.bkU = -1;
            if (aK == null) {
                t.HS().a(a);
            } else {
                t.HS().b(a);
            }
            v.d("MicroMsg.NetSceneGetPackageList", com_tencent_mm_protocal_c_ali.gkB + " - " + com_tencent_mm_protocal_c_ali.gof + " - " + com_tencent_mm_protocal_c_ali.mqd + " - " + com_tencent_mm_protocal_c_ali.efj);
        }
    }

    private void n(LinkedList<ali> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            v.d("MicroMsg.NetSceneGetPackageList", "empty address pkg list");
            return;
        }
        v.d("MicroMsg.NetSceneGetPackageList", "pkgList size " + linkedList.size());
        for (int i = 0; i < linkedList.size(); i++) {
            ali com_tencent_mm_protocal_c_ali = (ali) linkedList.get(i);
            m aK = t.HS().aK(com_tencent_mm_protocal_c_ali.gof, this.aZc);
            m a = a(com_tencent_mm_protocal_c_ali);
            a.bkU = -1;
            if (aK == null) {
                t.HS().a(a);
            } else {
                t.HS().b(a);
            }
            ak.vy().a(new j(a.id, 12), 0);
        }
    }

    private void K(List<ali> list) {
        if (list == null || list.size() <= 0) {
            v.d("MicroMsg.NetSceneGetPackageList", "[oneliang]empty update expose scene list");
            return;
        }
        t.HS();
        String HO = n.HO();
        for (int i = 0; i < list.size(); i++) {
            ali com_tencent_mm_protocal_c_ali = (ali) list.get(i);
            m aK = t.HS().aK(com_tencent_mm_protocal_c_ali.gof, this.aZc);
            if (aK == null || aK.version != com_tencent_mm_protocal_c_ali.efl) {
                com.tencent.mm.loader.stub.b.deleteFile(HO + t.HS().aM(com_tencent_mm_protocal_c_ali.gof, this.aZc));
                m a = a(com_tencent_mm_protocal_c_ali);
                a.bkU = -1;
                if (aK == null) {
                    t.HS().a(a);
                } else {
                    t.HS().b(a);
                }
                ak.vy().a(new j(a.id, 19), 0);
            }
            v.d("MicroMsg.NetSceneGetPackageList", "[oneliang]name:%s,packName:%s", com_tencent_mm_protocal_c_ali.gkB, com_tencent_mm_protocal_c_ali.mqd);
        }
    }

    private void L(List<ali> list) {
        if (list == null || list.size() == 0) {
            v.d("MicroMsg.NetSceneGetPackageList", "updateIPCallCountryCodeConfig, package list is empty");
            return;
        }
        v.d("MicroMsg.NetSceneGetPackageList", "updateIPCallCountryCodeConfig, pkgList.size: %d", Integer.valueOf(list.size()));
        ak.yW();
        int intValue = ((Integer) com.tencent.mm.model.c.vf().get(t.a.USERINFO_IPCALL_COUNTRY_CODE_RESTRCTION_INT, Integer.valueOf(-1))).intValue();
        v.d("MicroMsg.NetSceneGetPackageList", "configPkgId: %d", Integer.valueOf(intValue));
        if (intValue != -1) {
            m aK = t.HS().aK(intValue, this.aZc);
            for (ali a : list) {
                m a2 = a(a);
                v.d("MicroMsg.NetSceneGetPackageList", "newInfo.id: %d, version: %d", Integer.valueOf(a2.id), Integer.valueOf(a2.version));
                if (aK != null && a2.id == intValue) {
                    v.d("MicroMsg.NetSceneGetPackageList", "find match old pkg, update one");
                    t.HS().b(a2);
                    return;
                } else if (aK == null && a2.id == intValue) {
                    v.d("MicroMsg.NetSceneGetPackageList", "insert new pkg");
                    t.HS().a(a2);
                    return;
                }
            }
        }
    }

    private void M(List<ali> list) {
        if (list == null || list.size() == 0) {
            v.d("MicroMsg.NetSceneGetPackageList", "update sense where location but package list is empty.");
            return;
        }
        v.i("MicroMsg.NetSceneGetPackageList", "start update sense where location. package list size " + list.size());
        for (ali com_tencent_mm_protocal_c_ali : list) {
            m aK = t.HS().aK(com_tencent_mm_protocal_c_ali.gof, this.aZc);
            if (aK == null || aK.version != com_tencent_mm_protocal_c_ali.efl) {
                m a = a(com_tencent_mm_protocal_c_ali);
                a.bkU = -1;
                if (aK == null) {
                    t.HS().a(a);
                } else {
                    t.HS().b(a);
                }
                ak.vy().a(new j(a.id, 36), 0);
            }
        }
    }

    private void o(LinkedList<ali> linkedList) {
        v.d("MicroMsg.NetSceneGetPackageList", "updateLangPkg");
        if (linkedList == null || linkedList.size() == 0) {
            v.d("MicroMsg.NetSceneGetPackageList", "empty langage package list");
            return;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ali com_tencent_mm_protocal_c_ali = (ali) it.next();
            v.d("MicroMsg.NetSceneGetPackageList", "pkg.toString %s", com_tencent_mm_protocal_c_ali.toString());
            m aK = t.HS().aK(com_tencent_mm_protocal_c_ali.gof, this.aZc);
            m a = a(com_tencent_mm_protocal_c_ali);
            a.bkU = -1;
            if (aK == null) {
                t.HS().a(a);
            } else {
                t.HS().b(a);
            }
        }
    }

    private void p(LinkedList<ali> linkedList) {
        v.d("MicroMsg.NetSceneGetPackageList", "updateAppleEmojiPackage");
        if (linkedList == null || linkedList.size() == 0) {
            v.d("MicroMsg.NetSceneGetPackageList", "update apple emoji but package list is empty.");
            return;
        }
        v.i("MicroMsg.NetSceneGetPackageList", "start update apple emoji. package list size " + linkedList.size());
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ali com_tencent_mm_protocal_c_ali = (ali) it.next();
            m aK = t.HS().aK(com_tencent_mm_protocal_c_ali.gof, this.aZc);
            if (aK == null || aK.version != com_tencent_mm_protocal_c_ali.efl) {
                m a = a(com_tencent_mm_protocal_c_ali);
                a.bkU = -1;
                if (aK == null) {
                    t.HS().a(a);
                } else {
                    t.HS().b(a);
                }
                ak.vy().a(new j(a.id, 37), 0);
            }
        }
    }

    public final int getType() {
        return 159;
    }

    public final int BI() {
        return this.aZc;
    }
}
