package com.tencent.mm.plugin.wear.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.v.g;
import com.tencent.mm.v.g.b;
import java.util.LinkedList;

public final class i {
    private com.tencent.mm.v.g.a bcI = new com.tencent.mm.v.g.a(this) {
        final /* synthetic */ i lbL;

        {
            this.lbL = r1;
        }

        public final void pa() {
            this.lbL.lbJ.fLu.a(null);
            this.lbL.lbJ.fLu.a(null);
            this.lbL.b(this.lbL.lbJ);
        }
    };
    private b bcJ = new b(this) {
        final /* synthetic */ i lbL;

        {
            this.lbL = r1;
        }

        public final void onError() {
            this.lbL.lbJ.fLu.a(null);
            this.lbL.lbJ.fLu.a(null);
            this.lbL.b(this.lbL.lbJ);
        }
    };
    AudioManager cba = ((AudioManager) aa.getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE));
    a lbJ;
    BroadcastReceiver lbK = new BroadcastReceiver(this) {
        final /* synthetic */ i lbL;

        {
            this.lbL = r1;
        }

        public final void onReceive(Context context, Intent intent) {
            if (intent.hasExtra("state") && intent.getIntExtra("state", 2) == 0) {
                this.lbL.bhQ();
            }
        }
    };

    private class a {
        g fLu;
        LinkedList<at> lbM;
    }

    public i() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        aa.getContext().registerReceiver(this.lbK, intentFilter);
    }

    public final void bhQ() {
        a(this.lbJ);
    }

    private static a a(a aVar) {
        if (aVar != null) {
            aVar.fLu.stop();
            aVar.fLu.a(null);
            aVar.fLu.a(null);
            aVar.lbM.clear();
        }
        return null;
    }

    final void b(a aVar) {
        while (aVar != null) {
            if (aVar.lbM.size() > 0) {
                at atVar = (at) aVar.lbM.getLast();
                aVar.lbM.removeLast();
                q.A(atVar);
                v.i("MicroMsg.Wear.WearVoicePlayLogic", "play: msgid=%d, fullpath=%s", new Object[]{Long.valueOf(atVar.field_msgId), q.iU(atVar.field_imgPath)});
                if (aVar.fLu.a(q.iU(atVar.field_imgPath), true, true, -1)) {
                    aVar.fLu.a(this.bcI);
                    aVar.fLu.a(this.bcJ);
                    return;
                }
            }
            a(aVar);
            return;
        }
    }
}
