package com.tencent.mm.plugin.ipcall.a;

import com.tencent.mm.e.a.hf;
import com.tencent.mm.protocal.c.anu;
import com.tencent.mm.protocal.c.aod;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Iterator;
import java.util.LinkedList;

public final class h extends c<hf> {
    public a gFf;

    public interface a {
        void a(anu com_tencent_mm_protocal_c_anu);
    }

    public h() {
        this.nhz = hf.class.getName().hashCode();
    }

    private boolean a(hf hfVar) {
        if (hfVar instanceof hf) {
            Object obj = hfVar.bgW.bgX;
            if (obj != null && obj.length > 0 && obj[0] == (byte) 101) {
                Object obj2 = new byte[(obj.length - 1)];
                System.arraycopy(obj, 1, obj2, 0, obj2.length);
                try {
                    anu com_tencent_mm_protocal_c_anu = (anu) new anu().az(obj2);
                    v.d("MicroMsg.IPCallSvrNotifyListener", "roomId: %d, roomKey: %d, DtmfPayloadType: %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_anu.mqS), Long.valueOf(com_tencent_mm_protocal_c_anu.mqT), Integer.valueOf(com_tencent_mm_protocal_c_anu.gGc)});
                    LinkedList linkedList = com_tencent_mm_protocal_c_anu.mOf;
                    if (linkedList != null) {
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            aod com_tencent_mm_protocal_c_aod = (aod) it.next();
                            v.d("MicroMsg.IPCallSvrNotifyListener", "userstatus: %d, userstatusKey: %d, memberId: %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_aod.mNm), Integer.valueOf(com_tencent_mm_protocal_c_aod.mOp), Integer.valueOf(com_tencent_mm_protocal_c_aod.mOo)});
                        }
                    }
                    if (this.gFf != null) {
                        this.gFf.a(com_tencent_mm_protocal_c_anu);
                    }
                } catch (Exception e) {
                    v.e("MicroMsg.IPCallSvrNotifyListener", "parse PstnNotify error: %s", new Object[]{e.getMessage()});
                }
            }
        }
        return false;
    }
}
