package com.tencent.mm.plugin.wear.model.f;

import android.graphics.Bitmap;
import com.tencent.mm.ba.b;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.f;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.c.bhw;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.z;
import com.tencent.mm.storage.at;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public final class j extends b {
    private int aWI;
    private String bdo;
    private boolean biZ;

    public j(String str, int i, boolean z) {
        this.bdo = str;
        this.aWI = i;
        this.biZ = z;
    }

    private String f(String str, ArrayList<at> arrayList) {
        v.d("MicroMsg.WearNotificationCreateTask", "Talker: %s, MsgSize: %d", new Object[]{str, Integer.valueOf(arrayList.size())});
        StringBuffer stringBuffer = new StringBuffer();
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            stringBuffer.append(b(str, (at) arrayList.get(size)));
            stringBuffer.append("​​");
        }
        return stringBuffer.toString().trim();
    }

    private static String S(ArrayList<at> arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            at atVar = (at) it.next();
            stringBuffer.append(atVar.field_msgId);
            stringBuffer.append(atVar.field_talker);
            stringBuffer.append(atVar.field_content);
            stringBuffer.append(atVar.field_type);
            stringBuffer.append(atVar.field_createTime);
        }
        return z.Kg(stringBuffer.toString());
    }

    public final String getName() {
        return "WearNotificationCreateTask";
    }

    protected final void send() {
        v.d("MicroMsg.WearNotificationCreateTask", "start to execute notification create task");
        f DH = a.bhH().laT.DH(this.bdo);
        ArrayList arrayList = new ArrayList();
        int i = this.aWI - DH.lbA;
        if (i < 0) {
            i = 0;
        }
        v.d("MicroMsg.WearNotificationCreateTask", "limit=%d", new Object[]{Integer.valueOf(i)});
        ak.yW();
        for (at atVar : c.wJ().bM(this.bdo, i)) {
            if ((atVar.isSystem() ? 0 : 1) != 0) {
                arrayList.add(atVar);
            }
        }
        v.i("MicroMsg.WearNotificationCreateTask", "receiveUnreadMsgList.size=%d", new Object[]{Integer.valueOf(arrayList.size())});
        if (arrayList.size() != 0) {
            String S = S(arrayList);
            if (DH.aZy.equals(S)) {
                v.i("MicroMsg.WearNotificationCreateTask", "same md5, not to update");
                return;
            }
            DH.aZy = S;
            bhw com_tencent_mm_protocal_c_bhw = new bhw();
            com_tencent_mm_protocal_c_bhw.gof = DH.id;
            com_tencent_mm_protocal_c_bhw.ncy = DH.bdo;
            com_tencent_mm_protocal_c_bhw.aXz = h.DM(DH.bdo);
            com_tencent_mm_protocal_c_bhw.hQP = f(DH.bdo, arrayList);
            com_tencent_mm_protocal_c_bhw.ncK = this.aWI;
            com_tencent_mm_protocal_c_bhw.ncM = this.biZ;
            com_tencent_mm_protocal_c_bhw.ncL = !be.bup();
            Bitmap DL = h.DL(DH.bdo);
            if (DL != null) {
                com_tencent_mm_protocal_c_bhw.ncq = new b(h.A(DL));
            }
            v.d("MicroMsg.WearNotificationCreateTask", "generate notification content and ready to send");
            try {
                a.bhH();
                r.a(20003, com_tencent_mm_protocal_c_bhw.toByteArray(), true);
            } catch (IOException e) {
            }
            v.d("MicroMsg.WearNotificationCreateTask", "start to update notification status");
            a.bhH().laT.a(DH);
            a.bhH().laT.DK(this.bdo);
            com.tencent.mm.plugin.wear.model.c.a.cL(6, 0);
            com.tencent.mm.plugin.wear.model.c.a.sy(1);
        }
    }
}
