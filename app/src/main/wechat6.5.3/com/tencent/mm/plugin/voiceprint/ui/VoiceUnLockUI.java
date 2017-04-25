package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.voiceprint.model.d;
import com.tencent.mm.plugin.voiceprint.model.j;
import com.tencent.mm.plugin.voiceprint.model.q;
import com.tencent.mm.plugin.voiceprint.model.q.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public class VoiceUnLockUI extends BaseVoicePrintUI implements a {
    private q kqz;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kqz = new q(this);
        v.d("MicroMsg.VoicePrintUnLockService", "getVoiceText");
        ak.vy().a(new d(73, ""), 0);
    }

    protected final void baZ() {
        v.d("MicroMsg.VoiceUnLockUI", "sendVoice, filename:%s", new Object[]{this.kpj});
        if (!be.kS(this.kpj) && !be.kS(this.kqz.koM)) {
            j jVar = new j(this.kpj, this.kqz.koN);
            jVar.kot = true;
            ak.vy().a(jVar, 0);
            this.kpe.setEnabled(false);
            this.kph.bbi();
        }
    }

    protected final void axf() {
        findViewById(2131756773).setVisibility(8);
        this.kph.bbi();
        this.kph.ry(2131235816);
        this.kph.bbl();
        this.kpe.setEnabled(false);
    }

    public final void CL(String str) {
        this.koM = str;
        this.kph.bbk();
        this.kph.CM(str);
        this.kph.bbj();
        this.kpe.setEnabled(true);
    }

    public final void gK(boolean z) {
        this.kph.bbj();
        this.kpe.setEnabled(true);
        if (z) {
            v.d("MicroMsg.VoiceUnLockUI", "unlock success");
            bbh();
            return;
        }
        this.kph.rz(2131235815);
        this.kph.bbm();
    }

    protected void bbh() {
        Intent intent = new Intent();
        intent.putExtra("kscene_type", 73);
        intent.setClass(this, VoicePrintFinishUI.class);
        startActivity(intent);
        finish();
    }

    public final void baS() {
        baY();
    }

    protected void onDestroy() {
        super.onDestroy();
        q qVar = this.kqz;
        ak.vy().b(611, qVar);
        ak.vy().b(613, qVar);
        qVar.kpd = null;
    }
}
