package com.tencent.mm.storage;

import com.tencent.mm.a.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.List;

final class ae {
    protected final long nuX = 86400;
    private ad nuY = new ad();

    public ae() {
        StringBuilder stringBuilder = new StringBuilder();
        g.vx();
        byte[] d = e.d(stringBuilder.append(g.vw().cachePath).append("checkmsgid.ini").toString(), 0, -1);
        if (!be.bl(d)) {
            try {
                this.nuY.az(d);
                if (bvP()) {
                    bvO();
                }
            } catch (Throwable e) {
                v.w("MicroMsg.DelSvrIdMgr", "DelSvrIDs parse Error");
                v.e("MicroMsg.DelSvrIdMgr", "exception:%s", be.e(e));
            }
        }
    }

    private void bvO() {
        try {
            this.nuY.nuT.clear();
            this.nuY.nuS.clear();
            this.nuY.nuR.clear();
            byte[] toByteArray = this.nuY.toByteArray();
            StringBuilder stringBuilder = new StringBuilder();
            g.vx();
            e.b(stringBuilder.append(g.vw().cachePath).append("checkmsgid.ini").toString(), toByteArray, toByteArray.length);
        } catch (Throwable e) {
            v.e("MicroMsg.DelSvrIdMgr", "exception:%s", be.e(e));
        }
    }

    protected final boolean eh(long j) {
        if (bvP()) {
            bvO();
        }
        return this.nuY.nuU.contains(Long.valueOf(j)) || this.nuY.nuV.contains(Long.valueOf(j)) || this.nuY.nuW.contains(Long.valueOf(j));
    }

    protected final void a(int i, long j, long j2) {
        a(i, j, j2, true);
    }

    protected final void a(int i, long j, long j2, boolean z) {
        if (j != 0) {
            if (z) {
                bvP();
            }
            switch (i - ((int) (j2 / 86400))) {
                case 0:
                    this.nuY.nuU.add(Long.valueOf(j));
                    break;
                case 1:
                    this.nuY.nuV.add(Long.valueOf(j));
                    break;
                case 2:
                    this.nuY.nuW.add(Long.valueOf(j));
                    break;
                default:
                    v.e("MicroMsg.DelSvrIdMgr", "should not add to thease lists, dayIndex:%d", Integer.valueOf(i - ((int) (j2 / 86400))));
                    break;
            }
            if (z) {
                bvO();
            }
        }
    }

    protected final void f(List<Integer> list, List<Long> list2) {
        v.i("MicroMsg.DelSvrIdMgr", "add size:%d", Integer.valueOf(list.size()));
        bvP();
        int Nh = (int) (be.Nh() / 86400);
        for (int i = 0; i < list.size(); i++) {
            a(Nh, (long) ((Integer) list.get(i)).intValue(), ((Long) list2.get(i)).longValue(), false);
        }
        bvO();
    }

    private boolean bvP() {
        v.v("MicroMsg.DelSvrIdMgr", "checkOldData todayIndex:%d, t0Size:%d, t1Size:%d, t2Size:%d", Integer.valueOf(this.nuY.nuQ), Integer.valueOf(this.nuY.nuU.size()), Integer.valueOf(this.nuY.nuV.size()), Integer.valueOf(this.nuY.nuW.size()));
        int Nh = (int) (be.Nh() / 86400);
        int i = Nh - this.nuY.nuQ;
        this.nuY.nuQ = Nh;
        switch (i) {
            case 0:
                return false;
            case 1:
                this.nuY.nuW = this.nuY.nuV;
                this.nuY.nuV = this.nuY.nuU;
                this.nuY.nuU.clear();
                return true;
            case 2:
                this.nuY.nuW = this.nuY.nuU;
                this.nuY.nuV.clear();
                this.nuY.nuU.clear();
                return true;
            default:
                this.nuY.nuW.clear();
                this.nuY.nuV.clear();
                this.nuY.nuU.clear();
                return true;
        }
    }
}
