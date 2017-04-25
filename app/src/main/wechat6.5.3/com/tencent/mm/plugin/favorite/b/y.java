package com.tencent.mm.plugin.favorite.b;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.et;
import com.tencent.mm.protocal.c.eu;
import com.tencent.mm.protocal.c.mm;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class y extends k implements j {
    private final b cif;
    private e cii = null;
    private LinkedList<Integer> fLJ;
    private int fLK = 0;

    public y(LinkedList<Integer> linkedList) {
        a aVar = new a();
        aVar.czn = new et();
        aVar.czo = new eu();
        aVar.uri = "/cgi-bin/micromsg-bin/batchdelfavitem";
        aVar.czm = 403;
        aVar.czp = 194;
        aVar.czq = 1000000194;
        this.cif = aVar.Bv();
        this.fLJ = linkedList;
    }

    private boolean ame() {
        boolean z;
        if (this.fLJ == null || this.fLK >= this.fLJ.size()) {
            z = false;
        } else {
            z = true;
        }
        v.i("MicroMsg.NetSceneBatchDelFavItem", "check need continue, indexOK %B", new Object[]{Boolean.valueOf(z)});
        return z;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        if (this.fLJ == null || this.fLJ.isEmpty() || this.fLK >= this.fLJ.size()) {
            v.e("MicroMsg.NetSceneBatchDelFavItem", "klem doScene idList null, begIndex %d", new Object[]{Integer.valueOf(this.fLK)});
            return -1;
        }
        this.cii = eVar2;
        v.i("MicroMsg.NetSceneBatchDelFavItem", "ashutest::do netscene size %d, begIndex %d, total %s", new Object[]{Integer.valueOf(this.fLJ.size()), Integer.valueOf(this.fLK), this.fLJ});
        et etVar = (et) this.cif.czk.czs;
        etVar.mfI.clear();
        int i = 0;
        int i2 = this.fLK;
        while (i2 < this.fLJ.size()) {
            int intValue = ((Integer) this.fLJ.get(i2)).intValue();
            if (intValue > 0) {
                etVar.mfI.add(Integer.valueOf(intValue));
                intValue = i + 1;
            } else {
                intValue = i;
            }
            if (intValue >= 20) {
                break;
            }
            i2++;
            i = intValue;
        }
        this.fLK = i2 + 1;
        etVar.eet = etVar.mfI.size();
        v.i("MicroMsg.NetSceneBatchDelFavItem", "ashutest::do netscene checkd size %d, %s", new Object[]{Integer.valueOf(etVar.eet), etVar.mfI});
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneBatchDelFavItem", "netId %d errType %d errCode %d begIndex %d idListSize %d errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.fLK), Integer.valueOf(this.fLJ.size()), str});
        if (i2 == 0 && i3 == 0) {
            LinkedList linkedList = ((eu) ((b) pVar).czl.czs).eeu;
            if (linkedList == null || linkedList.size() == 0) {
                v.e("MicroMsg.NetSceneBatchDelFavItem", "klem onGYNet resp list null");
                if (ame()) {
                    a(this.czE, this.cii);
                    return;
                } else {
                    this.cii.a(i2, i3, str, this);
                    return;
                }
            }
            List arrayList = new ArrayList();
            v.i("MicroMsg.NetSceneBatchDelFavItem", "klem onGYNet respList size:%d", new Object[]{Integer.valueOf(linkedList.size())});
            for (int i4 = 0; i4 < linkedList.size(); i4++) {
                mm mmVar = (mm) linkedList.get(i4);
                if (mmVar.mcj < 0) {
                    v.w("MicroMsg.NetSceneBatchDelFavItem", "klem onGYNet favId:%d, delete failed", new Object[]{Integer.valueOf(mmVar.mbJ)});
                } else {
                    arrayList.add(Integer.valueOf(mmVar.mbJ));
                    v.i("MicroMsg.NetSceneBatchDelFavItem", "klem onGYNet favId:%d deleted", new Object[]{Integer.valueOf(mmVar.mbJ)});
                }
            }
            v.at(arrayList);
            if (ame()) {
                a(this.czE, this.cii);
            } else {
                this.cii.a(i2, i3, str, this);
            }
        } else if (ame()) {
            a(this.czE, this.cii);
        } else {
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
        return 403;
    }
}
