package com.tencent.mm.plugin.emoji.model;

import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.protocal.c.oa;
import com.tencent.mm.protocal.c.oc;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.storage.a.a;
import java.util.ArrayList;
import java.util.List;

public final class e {
    public int fcS;
    public List<f> fcT;
    public oa fcU;
    public List<oa> fcV;
    public List<oc> fcW;
    public List<oc> fcX;

    public final void jM(int i) {
        this.fcS += i;
    }

    public final void afn() {
        if (this.fcX != null && this.fcX != null && !this.fcX.isEmpty()) {
            List arrayList = new ArrayList();
            arrayList.addAll(this.fcX);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                this.fcT.add(0, new f((oc) arrayList.get(size)));
                this.fcS++;
                this.fcX.remove(arrayList.get(size));
            }
        }
    }

    public final void ak(List<f> list) {
        if (this.fcT == null) {
            this.fcT = new ArrayList();
        } else {
            int size = this.fcT.size() - 1;
            if (size >= 0 && size < this.fcT.size()) {
                f fVar = (f) this.fcT.get(size);
                if (!(fVar == null || fVar.fai == null || be.kS(fVar.fai.mdM) || !fVar.fai.mdM.equals(a.nwJ))) {
                    this.fcT.remove(fVar);
                }
            }
        }
        this.fcT.addAll(list);
    }
}
