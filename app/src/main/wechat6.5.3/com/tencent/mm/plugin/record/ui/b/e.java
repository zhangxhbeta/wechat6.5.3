package com.tencent.mm.plugin.record.ui.b;

import android.content.Context;
import android.view.View;
import com.tencent.mm.e.a.ez;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.record.a.d;
import com.tencent.mm.plugin.record.a.r;
import com.tencent.mm.plugin.record.ui.RecordVoiceBaseView;
import com.tencent.mm.plugin.record.ui.h.b;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class e implements b {
    private r iqJ = new r();

    public final View cq(Context context) {
        View inflate = View.inflate(context, 2130904260, null);
        RecordVoiceBaseView recordVoiceBaseView = (RecordVoiceBaseView) inflate.findViewById(2131757008);
        recordVoiceBaseView.iqJ = this.iqJ;
        r rVar = recordVoiceBaseView.iqJ;
        for (Object obj : rVar.bXt) {
            if (recordVoiceBaseView == obj) {
                break;
            }
        }
        rVar.bXt.add(recordVoiceBaseView);
        return inflate;
    }

    public final void a(View view, int i, com.tencent.mm.plugin.record.ui.a.b bVar) {
        View findViewById = view.findViewById(2131758849);
        RecordVoiceBaseView recordVoiceBaseView = (RecordVoiceBaseView) view.findViewById(2131757008);
        if (bVar.aKG == 0) {
            recordVoiceBaseView.setVisibility(8);
            findViewById.setVisibility(0);
        } else if (bVar.aKG == 1) {
            findViewById.setVisibility(8);
            recordVoiceBaseView.setVisibility(0);
            String a = d.a(bVar);
            ez ezVar = new ez();
            ezVar.bdQ.type = 17;
            ezVar.bdQ.bdS = bVar.bdE;
            a.nhr.z(ezVar);
            int i2 = ezVar.bdR.ret;
            if (!com.tencent.mm.a.e.aR(a)) {
                if (be.kS(bVar.bdE.mrS)) {
                    findViewById.setVisibility(0);
                    recordVoiceBaseView.setVisibility(8);
                } else {
                    v.d("MicroMsg.VoiceViewWrapper", "restart voice %s, url %s", new Object[]{Long.valueOf(bVar.ipT.field_localId), bVar.bdE.mrS});
                    ez ezVar2 = new ez();
                    ezVar2.bdQ.type = 16;
                    ezVar2.bdQ.aZa = bVar.ipT.field_localId;
                    a.nhr.z(ezVar2);
                }
            }
            int i3 = bVar.bdE.duration;
            recordVoiceBaseView.path = be.ah(a, "");
            recordVoiceBaseView.bdW = i2;
            if (recordVoiceBaseView.duration != i3) {
                recordVoiceBaseView.duration = i3;
                recordVoiceBaseView.setText(((int) q.au((long) i3)) + "''");
            }
        }
    }

    public final void destroy() {
    }
}
