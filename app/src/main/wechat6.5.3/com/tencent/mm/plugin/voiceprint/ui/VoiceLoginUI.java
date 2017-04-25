package com.tencent.mm.plugin.voiceprint.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.voiceprint.model.e;
import com.tencent.mm.plugin.voiceprint.model.h;
import com.tencent.mm.plugin.voiceprint.model.n;
import com.tencent.mm.plugin.voiceprint.model.n.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public class VoiceLoginUI extends BaseVoicePrintUI implements a {
    private String dRA = null;
    private n kpR = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g.iuh.h(11557, new Object[]{Integer.valueOf(1)});
        this.dRA = be.ah(getIntent().getStringExtra("Kusername"), null);
        v.d("MicroMsg.VoiceLoginUI", "summerauth onCreate, username:%s loginTicket==null:%b", new Object[]{this.dRA, Boolean.valueOf(be.kS(be.ah(getIntent().getStringExtra("Kvertify_key"), null)))});
        if (be.kS(this.dRA)) {
            v.e("MicroMsg.VoiceLoginUI", "onCreate error, username is null");
            return;
        }
        this.kpR = new n();
        this.kpR.dRA = this.dRA;
        this.kpR.koP = r0;
        this.kpR.koQ = this;
        n nVar = this.kpR;
        if (be.kS(nVar.koP)) {
            ak.vy().a(new e(nVar.dRA), 0);
        } else {
            nVar.baT();
        }
        boolean a = com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.RECORD_AUDIO", 80, "", "");
        v.i("MicroMsg.VoiceLoginUI", "summerper checkPermission checkmicrophone[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(a), be.bur(), this});
    }

    protected final void baZ() {
        v.d("MicroMsg.VoiceLoginUI", "sendVoice, filename:%s", new Object[]{this.kpj});
        if (!be.kS(this.kpj) && !be.kS(this.koM)) {
            n nVar = this.kpR;
            h hVar = new h(this.kpj, nVar.koN, nVar.koP);
            hVar.kot = true;
            ak.vy().a(hVar, 0);
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
        v.d("MicroMsg.VoiceLoginUI", "onGetText");
        this.koM = str;
        this.kph.bbk();
        this.kph.CM(str);
        this.kph.bbj();
        this.kpe.setEnabled(true);
    }

    public final void gJ(boolean z) {
        this.kph.bbj();
        this.kpe.setEnabled(true);
        if (z) {
            v.i("MicroMsg.VoiceLoginUI", "login success[%s]", new Object[]{be.KW(this.kpR.koC)});
            Intent intent = new Intent();
            intent.putExtra("VoiceLoginAuthPwd", this.kpR.koC);
            setResult(-1, intent);
            finish();
            return;
        }
        v.i("MicroMsg.VoiceLoginUI", "login failed");
        this.kph.rz(2131235815);
        this.kph.bbm();
    }

    public final void baS() {
        rx(2131235819);
    }

    public final void baU() {
        this.kpe.setEnabled(false);
        this.kpe.setVisibility(4);
        this.kph.bbj();
        this.kph.rz(2131235818);
        this.kph.bbm();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.kpR != null) {
            n nVar = this.kpR;
            ak.vy().b(618, nVar);
            ak.vy().b(616, nVar);
            ak.vy().b(617, nVar);
            nVar.koQ = null;
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        v.i("MicroMsg.VoiceLoginUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 80:
                if (iArr[0] == 0) {
                    baW();
                    return;
                } else {
                    com.tencent.mm.ui.base.g.a(this, getString(2131234163), getString(2131234166), getString(2131233450), getString(2131231565), false, new OnClickListener(this) {
                        final /* synthetic */ VoiceLoginUI kpS;

                        {
                            this.kpS = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            this.kpS.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ VoiceLoginUI kpS;

                        {
                            this.kpS = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
            default:
                return;
        }
    }
}
