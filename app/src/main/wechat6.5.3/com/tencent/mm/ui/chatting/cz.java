package com.tencent.mm.ui.chatting;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.m;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import java.util.ArrayList;
import java.util.List;

final class cz implements ac {
    final a oxo;
    df oxp = new df();

    public cz(a aVar) {
        this.oxo = aVar;
    }

    public final void a(at atVar) {
        if (this.oxo == null) {
            v.w("MicroMsg.ChattingUIKeywordChecker", "chatting ui is null.");
            return;
        }
        this.oxo.bDM();
        if (atVar.field_talker.equals(this.oxo.bEn()) && atVar.bwm()) {
            aA(atVar);
        }
    }

    public final void q(List<at> list) {
        if (this.oxo == null) {
            v.w("MicroMsg.ChattingUIKeywordChecker", "chatting ui is null.");
        } else if (!m.dE(this.oxo.bEn())) {
            List arrayList = new ArrayList();
            for (at atVar : list) {
                if (atVar.field_talker.equals(this.oxo.bEn()) && atVar.bwm()) {
                    arrayList.add(atVar);
                }
            }
            cw(arrayList);
        }
    }

    public final void aA(at atVar) {
        if (atVar != null) {
            List arrayList = new ArrayList();
            arrayList.add(atVar);
            cw(arrayList);
        }
    }

    private void cw(List<at> list) {
        if (this.oxp != null && this.oxo != null) {
            this.oxp.a(this.oxo.bzo(), list);
        }
    }

    public final Looper getLooper() {
        return Looper.getMainLooper();
    }

    public final void a(int i, String str, String str2, String str3, String str4, Bundle bundle) {
    }
}
