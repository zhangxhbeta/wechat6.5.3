package com.tencent.mm.plugin.favorite.b;

import android.os.Message;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.protocal.ae;
import com.tencent.mm.protocal.c.bh;
import com.tencent.mm.protocal.c.kz;
import com.tencent.mm.protocal.c.qh;
import com.tencent.mm.protocal.c.qi;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public final class ab extends k implements j {
    public static final byte[] fLS = null;
    private int cQR = 1;
    private final b cif;
    private e cii = null;
    private a fLT = new a(this);
    private long fLU = -1;
    public boolean fLV = false;

    class a {
        LinkedList<kz> fLW;
        ac fLX = new ac(this, ak.vA().htb.getLooper()) {
            final /* synthetic */ a fLZ;

            public final void handleMessage(Message message) {
                if (this.fLZ.fLW == null || this.fLZ.fLW.isEmpty()) {
                    ab.a(this.fLZ.fLY);
                    return;
                }
                kz kzVar = (kz) this.fLZ.fLW.getFirst();
                v.d("MicroMsg.NetSceneFavSync", "cmdId = " + kzVar.bkM);
                this.fLZ.fLW.removeFirst();
                switch (kzVar.bkM) {
                    case 200:
                        byte[] a = m.a(kzVar.mnB);
                        if (a == null) {
                            v.e("MicroMsg.NetSceneFavSync", "docmd: no protobuf found.");
                            sendEmptyMessage(0);
                            return;
                        }
                        ab.a(this.fLZ.fLY, a);
                        sendEmptyMessage(0);
                        return;
                    default:
                        return;
                }
            }
        };
        final /* synthetic */ ab fLY;

        a(ab abVar) {
            this.fLY = abVar;
        }
    }

    static /* synthetic */ void a(ab abVar) {
        qh qhVar = (qh) abVar.cif.czk.czs;
        qi qiVar = (qi) abVar.cif.czl.czs;
        byte[] i = ae.i(qhVar.mkF.mQw.toByteArray(), qiVar.mkF.mQw.toByteArray());
        if (i != null && i.length > 0) {
            h.alr().ao(i);
        }
        qhVar.mkF = m.H(i);
        if ((qhVar.mkE & qiVar.miR) == 0) {
            v.i("MicroMsg.NetSceneFavSync", "processEnd, minUpdateTime:%d", new Object[]{Long.valueOf(abVar.fLU)});
            ak.yW();
            c.vf().set(8217, Integer.valueOf(1));
            if (abVar.fLU > 0) {
                LinkedList l = h.alu().l(abVar.fLU, -1);
                if (l.size() > 0) {
                    if (l.size() > 40) {
                        Collection subList = l.subList(0, 40);
                        l = new LinkedList();
                        l.addAll(subList);
                    }
                    abVar.fLV = true;
                    v.i("MicroMsg.NetSceneFavSync", "processEnd, start batch get list size:%d", new Object[]{Integer.valueOf(l.size())});
                    if (!ak.vy().a(new z(l), 0)) {
                        v.w("MicroMsg.NetSceneFavSync", "do scene BatchGetFav fail");
                        z.amg();
                    }
                }
            }
            abVar.cii.a(0, 0, "", abVar);
            return;
        }
        v.i("MicroMsg.NetSceneFavSync", "continue flag:%d", new Object[]{Integer.valueOf(qiVar.miR)});
        abVar.a(abVar.czE, abVar.cii);
    }

    static /* synthetic */ void a(ab abVar, byte[] bArr) {
        int i = 1;
        try {
            String str = "MicroMsg.NetSceneFavSync";
            String str2 = "processAddItem bufSize=%d";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(bArr != null ? bArr.length : 0);
            v.i(str, str2, objArr);
            bh bhVar = (bh) new bh().az(bArr);
            if (bhVar == null) {
                v.e("MicroMsg.NetSceneFavSync", "klem processAddItem favitem null");
                return;
            }
            v.i("MicroMsg.NetSceneFavSync", "klem processAddItem id:%d, flag:%d, updateSeq:%d, updateTime:%d", new Object[]{Integer.valueOf(bhVar.mbJ), Integer.valueOf(bhVar.mbK), Integer.valueOf(bhVar.mbM), Integer.valueOf(bhVar.mbL)});
            if ((bhVar.mbK & 1) != 0) {
                v.a(h.alu().bC((long) bhVar.mbJ), false, null);
                return;
            }
            if (abVar.fLU < 0 || ((long) bhVar.mbL) < abVar.fLU) {
                abVar.fLU = (long) bhVar.mbL;
            }
            i bC = h.alu().bC((long) bhVar.mbJ);
            if (bC == null) {
                bC = new i();
                bC.field_updateTime = ((long) bhVar.mbL) * 1000;
            } else {
                i = 0;
            }
            bC.field_id = bhVar.mbJ;
            bC.field_updateSeq = bhVar.mbM;
            if (bC.field_localSeq == bhVar.mbM) {
                bC.field_updateTime = ((long) bhVar.mbL) * 1000;
            }
            bC.field_flag = bhVar.mbK;
            bC.field_type = bhVar.efm;
            if (i != 0) {
                bC.field_localId = System.currentTimeMillis();
                h.alu().c(bC);
                return;
            }
            h.alu().a(bC, "localId");
        } catch (Throwable e) {
            v.a("MicroMsg.NetSceneFavSync", e, "", new Object[0]);
        }
    }

    public ab() {
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = new qh();
        aVar.czo = new qi();
        aVar.uri = "/cgi-bin/micromsg-bin/favsync";
        aVar.czm = 400;
        aVar.czp = 195;
        aVar.czq = 1000000195;
        aVar.czr = false;
        this.cif = aVar.Bv();
    }

    public ab(int i) {
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czn = new qh();
        aVar.czo = new qi();
        aVar.uri = "/cgi-bin/micromsg-bin/favsync";
        aVar.czm = 400;
        aVar.czp = 195;
        aVar.czq = 1000000195;
        aVar.czr = false;
        this.cif = aVar.Bv();
        this.cQR = i;
    }

    public final boolean Bz() {
        return true;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        byte[] KG;
        this.cii = eVar2;
        qh qhVar = (qh) this.cif.czk.czs;
        qhVar.mkE = this.cQR;
        d alr = h.alr();
        c alw = alr.alw();
        if (8216 != alw.field_configId) {
            v.w("MicroMsg.FavConfigStorage", "get sync key from fav db fail, try to load from mmdb");
            ak.yW();
            if (((Boolean) c.vf().get(8224, Boolean.valueOf(false))).booleanValue()) {
                v.w("MicroMsg.FavConfigStorage", "get sync from mmdb fail, has trans");
            } else {
                ak.yW();
                v.i("MicroMsg.FavConfigStorage", "get sync key(%s) from mmdb, do update fav sync key", new Object[]{be.ma((String) c.vf().get(8216, ""))});
                KG = be.KG(r1);
                alr.ao(KG);
                v.w("MicroMsg.FavConfigStorage", "set fav sync key has trans");
                ak.yW();
                c.vf().set(8224, Boolean.valueOf(true));
                if (this.cQR == 2) {
                    KG = new byte[0];
                }
                qhVar.mkF = m.H(KG);
                return a(eVar, this.cif, this);
            }
        }
        v.i("MicroMsg.FavConfigStorage", "get sync key, id %d, value %s", new Object[]{Integer.valueOf(alw.field_configId), alw.field_value});
        KG = be.KG(alw.field_value);
        if (this.cQR == 2) {
            KG = new byte[0];
        }
        qhVar.mkF = m.H(KG);
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneFavSync", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (h.alk().aVu) {
            v.w("MicroMsg.NetSceneFavSync", "sending item, skip sync onGYNetEnd");
            this.cii.a(i2, i3, str, this);
        } else if (i2 == 0 && i3 == 0) {
            qi qiVar = (qi) ((b) pVar).czl.czs;
            LinkedList linkedList = qiVar.mkI.eeu;
            if (linkedList == null || linkedList.size() <= 0) {
                if (qiVar.mkF.mQw != null) {
                    byte[] i4 = ae.i(((qh) ((b) pVar).czk.czs).mkF.mQw.toByteArray(), qiVar.mkF.mQw.toByteArray());
                    if (i4 != null && i4.length > 0) {
                        h.alr().ao(i4);
                    }
                } else {
                    v.e("MicroMsg.NetSceneFavSync", "merge key should not be null");
                }
                ak.yW();
                c.vf().set(8217, Integer.valueOf(1));
                this.cii.a(i2, i3, str, this);
                return;
            }
            v.i("MicroMsg.NetSceneFavSync", "cmdList size:" + linkedList.size());
            if (this.cQR != 2) {
                a aVar = this.fLT;
                aVar.fLW = linkedList;
                if (aVar.fLW != null && aVar.fLW.size() > 0) {
                    ak.vy().a(new ac(), 0);
                }
                aVar.fLX.sendEmptyMessage(0);
                return;
            }
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                try {
                    int i5 = ((bh) new bh().az(m.a(((kz) it.next()).mnB))).mbK;
                } catch (IOException e) {
                    v.e("MicroMsg.NetSceneFavSync", "get favdelitem error, errmsg is %s", new Object[]{e.getMessage()});
                }
            }
            this.cii.a(i2, i3, str, this);
        } else {
            this.cii.a(i2, i3, str, this);
        }
    }

    protected final int ul() {
        return 50;
    }

    protected final int a(p pVar) {
        return k.b.czU;
    }

    public final int getType() {
        return 400;
    }
}
