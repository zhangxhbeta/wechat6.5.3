package com.tencent.mm.plugin.wear.model.g;

import android.app.KeyguardManager;
import android.content.Intent;
import android.os.PowerManager;
import com.tencent.mm.e.a.qz;
import com.tencent.mm.plugin.wear.ui.WearYoLockUI;
import com.tencent.mm.plugin.wear.ui.WearYoNoLockUI;
import com.tencent.mm.protocal.c.biq;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class a {
    private PowerManager lbm = ((PowerManager) aa.getContext().getSystemService("power"));
    private KeyguardManager lbn = ((KeyguardManager) aa.getContext().getSystemService("keyguard"));
    LinkedHashMap<String, a> lcs = new LinkedHashMap();

    private class a {
        String content;
        String lct;
        final /* synthetic */ a lcu;

        public a(a aVar, String str, String str2) {
            this.lcu = aVar;
            this.lct = str;
            this.content = str2;
        }
    }

    public static qz DO(String str) {
        qz qzVar = new qz();
        qzVar.bsE.aYt = 1;
        qzVar.bsE.username = str;
        com.tencent.mm.sdk.c.a.nhr.z(qzVar);
        return qzVar;
    }

    public final void bhW() {
        if (DO(null).bsF.bsG != 0) {
            v.i("MicroMsg.wear.WearYoLogic", "current show yo");
            return;
        }
        synchronized (this.lcs) {
            a aVar;
            Iterator it = this.lcs.entrySet().iterator();
            if (it.hasNext()) {
                aVar = (a) ((Entry) it.next()).getValue();
            } else {
                aVar = null;
            }
            if (aVar != null) {
                this.lcs.remove(aVar.lct);
            }
        }
        if (aVar != null) {
            int i;
            String str = aVar.content;
            biq com_tencent_mm_protocal_c_biq = new biq();
            Map q = bf.q(str, "msg");
            if (q == null) {
                com_tencent_mm_protocal_c_biq.efm = 0;
            } else {
                com_tencent_mm_protocal_c_biq.efm = be.getInt((String) q.get(".msg.yo.$type"), 0);
                com_tencent_mm_protocal_c_biq.eet = be.getInt((String) q.get(".msg.yo.$count"), 0);
            }
            Intent intent = new Intent();
            intent.putExtra("key_talker", aVar.lct);
            try {
                intent.putExtra("key_data", com_tencent_mm_protocal_c_biq.toByteArray());
            } catch (IOException e) {
            }
            intent.addFlags(268435456);
            if (this.lbn.inKeyguardRestrictedInputMode() || !this.lbm.isScreenOn()) {
                i = 1;
            } else {
                i = 0;
            }
            if (i != 0) {
                intent.setClass(aa.getContext(), WearYoLockUI.class);
            } else {
                intent.setClass(aa.getContext(), WearYoNoLockUI.class);
            }
            aa.getContext().startActivity(intent);
        }
    }
}
