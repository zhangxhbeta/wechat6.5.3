package com.tencent.mm.o;

import com.tencent.mm.model.ak;
import com.tencent.mm.protocal.c.wd;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import java.util.List;

public final class b implements e {
    private List<d> chU = null;
    private List<d> chV = null;
    private d chW = null;
    private a chX;

    public interface a {
        void r(List<d> list);
    }

    public b(List<d> list, a aVar) {
        this.chU = list;
        this.chV = new ArrayList();
        this.chX = aVar;
    }

    public final boolean start() {
        if (this.chU == null || this.chU.size() <= 0) {
            return false;
        }
        v.i("MicroMsg.FunctionMsgFetchLooper", "start, fetchItemList.size: %s", Integer.valueOf(this.chU.size()));
        ak.vy().a(825, (e) this);
        uf();
        return true;
    }

    private void uf() {
        v.d("MicroMsg.FunctionMsgFetchLooper", "fetchNext, fetchItemList.size: %s", Integer.valueOf(this.chU.size()));
        if (this.chU.size() > 0) {
            this.chW = (d) this.chU.remove(0);
            d dVar = this.chW;
            if (dVar != null) {
                v.i("MicroMsg.FunctionMsgFetchLooper", "fetchInternal, functionMsgId: %s", dVar.field_functionmsgid);
                dVar.field_status = 0;
                ak.vy().a(new g(dVar), 0);
                return;
            }
            return;
        }
        ak.vy().b(825, (e) this);
        if (this.chX != null) {
            this.chX.r(this.chV);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.FunctionMsgFetchLooper", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (kVar.getType() == 825) {
            g gVar = (g) kVar;
            wd wdVar = gVar.cih;
            d dVar = gVar.cij;
            if (dVar != null && dVar.field_functionmsgid.equals(this.chW.field_functionmsgid)) {
                if (i == 0 || i2 == 0) {
                    v.i("MicroMsg.FunctionMsgFetchLooper", "functionMsgId: %s fetch success, response.version: %s, fetchItem.version: %s", dVar.field_functionmsgid, Long.valueOf(wdVar.myF), Long.valueOf(dVar.field_version));
                    if (wdVar.myF >= dVar.field_version) {
                        dVar.field_preVersion = dVar.field_version;
                        dVar.field_version = wdVar.myF;
                        dVar.field_status = 2;
                        dVar.b(wdVar.myG);
                        h.uo().a(dVar.field_functionmsgid, dVar);
                        this.chV.add(dVar);
                    }
                } else {
                    v.i("MicroMsg.FunctionMsgFetchLooper", "functionMsgId: %s, fetch failed, mark as fetch failed, preVersion: %s, version: %s", dVar.field_functionmsgid, Long.valueOf(dVar.field_preVersion), Long.valueOf(dVar.field_version));
                    dVar.field_status = 3;
                    dVar.field_version = dVar.field_preVersion;
                    h.uo().a(dVar.field_functionmsgid, dVar);
                }
                uf();
            }
        }
    }
}
