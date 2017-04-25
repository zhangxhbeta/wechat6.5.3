package com.tencent.mm.plugin.favorite.b;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.protocal.c.ff;
import com.tencent.mm.protocal.c.fg;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.protocal.c.qd;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class z extends k implements j {
    private static AtomicInteger fLN = new AtomicInteger(0);
    private final b cif;
    private e cii = null;
    private LinkedList<Integer> fLJ;
    private int fLK = 0;
    private boolean fLL = false;
    private boolean fLM = false;

    public z(LinkedList<Integer> linkedList) {
        a aVar = new a();
        aVar.czn = new ff();
        aVar.czo = new fg();
        aVar.uri = "/cgi-bin/micromsg-bin/batchgetfavitem";
        aVar.czm = 402;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        this.fLJ = linkedList;
        fLN.incrementAndGet();
    }

    public static void amf() {
        fLN.set(0);
    }

    public static void amg() {
        fLN.decrementAndGet();
    }

    public static int amh() {
        return fLN.get();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        v.i("MicroMsg.NetSceneBatchgetFav", "ashutest::doscene count:%d", new Object[]{Integer.valueOf(fLN.get())});
        if (this.fLJ == null || this.fLJ.isEmpty() || this.fLK >= this.fLJ.size()) {
            v.e("MicroMsg.NetSceneBatchgetFav", "klem doScene, idlist null, begIndex %d", new Object[]{Integer.valueOf(this.fLK)});
            return -1;
        }
        v.i("MicroMsg.NetSceneBatchgetFav", "ashutest::do netscene size %d, begIndex %d, total %s", new Object[]{Integer.valueOf(this.fLJ.size()), Integer.valueOf(this.fLK), this.fLJ});
        ak.yW();
        if (be.f((Integer) c.vf().get(8217, null)) == 0) {
            v.w("MicroMsg.NetSceneBatchgetFav", "klem doScene, init not done, do not batchget");
            return -1;
        }
        ff ffVar = (ff) this.cif.czk.czs;
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(this.fLJ.subList(this.fLK, Math.min(this.fLK + 15, this.fLJ.size())));
        ffVar.mfI = linkedList;
        ffVar.eet = linkedList.size();
        this.fLK += 15;
        v.i("MicroMsg.NetSceneBatchgetFav", "ashutest::do netscene checkd size %d, %s", new Object[]{Integer.valueOf(linkedList.size()), linkedList});
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    private boolean ame() {
        boolean z;
        boolean z2;
        ak.yW();
        if (be.f((Integer) c.vf().get(8217, null)) == 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.fLJ == null || this.fLK >= this.fLJ.size()) {
            z2 = false;
        } else {
            z2 = true;
        }
        v.i("MicroMsg.NetSceneBatchgetFav", "check needContinue, notInit %B indexOK %B", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)});
        if (z || !z2) {
            return false;
        }
        return true;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneBatchgetFav", "netId %d errType %d errCode %d begIndex %d idListSize %d errMsg[%s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.fLK), Integer.valueOf(this.fLJ.size()), str});
        if (i2 == 0 && i3 == 0) {
            fg fgVar = (fg) ((b) pVar).czl.czs;
            int i4 = fgVar.eet;
            int size = fgVar.mfQ.size();
            if (i4 != size) {
                String str2 = "MicroMsg.NetSceneBatchgetFav";
                String str3 = "klem onGYNet resp list size:%d, return count %d, request count %d";
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(size);
                objArr[1] = Integer.valueOf(i4);
                objArr[2] = Integer.valueOf(this.fLK > this.fLJ.size() ? this.fLJ.size() % 15 : 15);
                v.e(str2, str3, objArr);
                if (ame()) {
                    a(this.czE, this.cii);
                    return;
                }
                fLN.decrementAndGet();
                this.cii.a(i2, -1, str, this);
                return;
            }
            for (int i5 = 0; i5 < size; i5++) {
                qd qdVar = (qd) fgVar.mfQ.get(i5);
                v.i("MicroMsg.NetSceneBatchgetFav", "klem onGYNet favid:%d, status:%d", new Object[]{Integer.valueOf(qdVar.mbJ), Integer.valueOf(qdVar.eeO)});
                if (qdVar.eeO == 0) {
                    i bC = h.alu().bC((long) qdVar.mbJ);
                    if (bC == null) {
                        v.e("MicroMsg.NetSceneBatchgetFav", "klem onGYNet favid:%d not exist!", new Object[]{Integer.valueOf(qdVar.mbJ)});
                    } else {
                        bC.field_xml = qdVar.mbQ;
                        bC.sM(qdVar.mbQ);
                        bC.field_flag = qdVar.mbK;
                        bC.field_localSeq = qdVar.mbM;
                        bC.field_updateTime = (((long) qdVar.mbL) * 1000) + ((long) i5);
                        int size2 = bC.field_favProto.mtR.size();
                        if (size2 == 0) {
                            v.v("MicroMsg.NetSceneBatchgetFav", "this item has no data, favId:%d", new Object[]{Integer.valueOf(bC.field_id)});
                        } else {
                            List list = bC.field_favProto.mtR;
                            for (int i6 = 0; i6 < size2; i6++) {
                                pw pwVar = (pw) list.get(i6);
                                if (!be.kS(pwVar.msj)) {
                                    v.i("MicroMsg.NetSceneBatchgetFav", "dataFIle: %s", new Object[]{new File(v.f(pwVar)).getName()});
                                    if (new File(v.f(pwVar)).exists()) {
                                        if (pwVar.msI != 0) {
                                            v.v("MicroMsg.NetSceneBatchgetFav", "server upload data failed, client upload, md5%s", new Object[]{pwVar.msj});
                                            this.fLM = true;
                                            v.a(pwVar, bC, 0, false);
                                        }
                                        v.d("MicroMsg.NetSceneBatchgetFav", "data exist, favId:%d, dataIndex:%d", new Object[]{Integer.valueOf(bC.field_id), Integer.valueOf(i6)});
                                    } else if (be.kS(pwVar.mrU) || be.kS(pwVar.mrS)) {
                                        v.e("MicroMsg.NetSceneBatchgetFav", "data key or url null. favId:%d", new Object[]{Integer.valueOf(bC.field_id)});
                                    } else {
                                        v.d("MicroMsg.NetSceneBatchgetFav", "local data not exist, insert cdninfo, favId:%d, dataIndex:%d", new Object[]{Integer.valueOf(bC.field_id), Integer.valueOf(i6)});
                                        v.a(pwVar, bC, 1, false);
                                        this.fLL = true;
                                    }
                                }
                                if (!be.kS(pwVar.msu)) {
                                    if (new File(v.g(pwVar)).exists()) {
                                        v.d("MicroMsg.NetSceneBatchgetFav", "thumb exist, favId:%d, dataIndex:%d", new Object[]{Integer.valueOf(bC.field_id), Integer.valueOf(i6)});
                                    } else if (be.kS(pwVar.mrO) || be.kS(pwVar.coj)) {
                                        v.w("MicroMsg.NetSceneBatchgetFav", "thumb key or url null. favId:%d", new Object[]{Integer.valueOf(bC.field_id)});
                                    } else {
                                        v.d("MicroMsg.NetSceneBatchgetFav", "local thumb not exist, insert cdninfo, favId:%d, dataIndex:%d", new Object[]{Integer.valueOf(bC.field_id), Integer.valueOf(i6)});
                                        v.a(pwVar, bC, 1);
                                        this.fLL = true;
                                    }
                                }
                            }
                        }
                        v.i("MicroMsg.NetSceneBatchgetFav", "data dealed needUpload:%b  needDownload:%b", new Object[]{Boolean.valueOf(this.fLM), Boolean.valueOf(this.fLL)});
                        if (this.fLM) {
                            bC.field_itemStatus = 15;
                            h.alu().a(bC, "localId");
                            h.alo().run();
                        } else if (this.fLL) {
                            bC.field_itemStatus = 10;
                            h.alu().a(bC, "localId");
                        } else {
                            bC.field_itemStatus = 10;
                            h.alu().a(bC, "localId");
                        }
                        v.r(bC);
                        bC.sN("MicroMsg.NetSceneBatchgetFav");
                    }
                }
                if (qdVar.eeO == 1) {
                    v.d("MicroMsg.NetSceneBatchgetFav", "klem onGYNet favId: %d status not exist, delete local item", new Object[]{Integer.valueOf(qdVar.mbJ)});
                    v.a(h.alu().bC((long) qdVar.mbJ), null);
                }
            }
            h.alo().run();
            if (ame()) {
                a(this.czE, this.cii);
                return;
            }
            fLN.decrementAndGet();
            this.cii.a(i2, i3, str, this);
        } else if (ame()) {
            a(this.czE, this.cii);
        } else {
            fLN.decrementAndGet();
            this.cii.a(i2, i3, str, this);
        }
    }

    protected final int a(p pVar) {
        return k.b.czU;
    }

    protected final int ul() {
        return 10;
    }

    public final int getType() {
        return 402;
    }
}
