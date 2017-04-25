package com.tencent.mm.plugin.fingerprint.a;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.plugin.fingerprint.FingerPrintAuth;
import com.tencent.mm.plugin.fingerprint.b.e;
import com.tencent.mm.plugin.fingerprint.b.f;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.k;
import com.tencent.mm.wallet_core.b.m;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public final class g implements com.tencent.mm.pluginsdk.wallet.g {
    private String bft = null;
    ac fTH = new ac(new com.tencent.mm.sdk.platformtools.ac.a(this) {
        final /* synthetic */ g fTQ;

        {
            this.fTQ = r1;
        }

        public final boolean handleMessage(Message message) {
            if (1 != message.what) {
                return false;
            }
            Object string = message.getData().getString("rsaKey");
            if (TextUtils.isEmpty(string)) {
                v.e("MicroMsg.HwFingerprintOpenDelegate", "handleMessage msg.what=" + message.what + " rsaKey is null");
                ad.o(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 fTR;

                    {
                        this.fTR = r1;
                    }

                    public final void run() {
                        this.fTR.fTQ.fTL.K(-1, this.fTR.fTQ.fTN.getString(2131232833));
                    }
                });
            }
            this.fTQ.fTN.b(new e(string), false);
            return true;
        }
    });
    com.tencent.mm.pluginsdk.wallet.a fTL = null;
    private com.tencent.mm.pluginsdk.wallet.a fTM = null;
    WalletBaseUI fTN = null;
    private String fTO = null;
    private String fTP = null;

    private class a implements com.tencent.mm.plugin.fingerprint.a.n.a {
        final /* synthetic */ g fTQ;

        private a(g gVar) {
            this.fTQ = gVar;
        }

        public final void tp(final String str) {
            if (TextUtils.isEmpty(str)) {
                ad.o(new Runnable(this) {
                    final /* synthetic */ a fTS;

                    {
                        this.fTS = r1;
                    }

                    public final void run() {
                        this.fTS.fTQ.fTL.K(-1, this.fTS.fTQ.fTN.getString(2131232833));
                    }
                });
                v.e("MicroMsg.HwFingerprintOpenDelegate", "GenRsaKeySync.callback rsaKey is empty!");
                return;
            }
            ad.o(new Runnable(this) {
                final /* synthetic */ a fTS;

                public final void run() {
                    v.i("MicroMsg.HwFingerprintOpenDelegate", "GenRsaKeySync.callback running");
                    Message obtainMessage = this.fTS.fTQ.fTH.obtainMessage();
                    obtainMessage.what = 1;
                    Bundle bundle = new Bundle();
                    bundle.putString("rsaKey", str);
                    obtainMessage.setData(bundle);
                    obtainMessage.sendToTarget();
                }
            });
        }
    }

    public final void a(Context context, com.tencent.mm.pluginsdk.wallet.a aVar, String str) {
        this.fTN = (WalletBaseUI) context;
        this.fTL = aVar;
        this.fTP = str;
        Object rsaKey = FingerPrintAuth.getRsaKey(e.bL(aa.getContext()), e.getUserId(), p.rK());
        com.tencent.mm.pluginsdk.f.a.bmI();
        if (TextUtils.isEmpty(rsaKey)) {
            v.e("MicroMsg.HwFingerprintOpenDelegate", "FingerPrintAuth.getRsaKey() is null");
            new n(new a()).anR();
            return;
        }
        v.i("MicroMsg.HwFingerprintOpenDelegate", "do NetSceneTenpayGetOpenTouchCert");
        this.fTN.b(new e(rsaKey), false);
    }

    public final void clear() {
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        int i3 = 0;
        if (kVar instanceof e) {
            com.tencent.mm.pluginsdk.wallet.a aVar;
            if (i == 0 && i2 == 0) {
                v.i("MicroMsg.HwFingerprintOpenDelegate", "get FingerPrint cert success");
                e eVar = (e) kVar;
                this.fTO = eVar.fTO;
                this.bft = eVar.bft;
                aVar = this.fTL;
                str = "";
            } else {
                v.i("MicroMsg.HwFingerprintOpenDelegate", "get FingerPrint cert error");
                aVar = this.fTL;
                i3 = -1;
                if (be.kS(str)) {
                    str = this.fTN.getString(2131232833);
                }
            }
            aVar.K(i3, str);
            return true;
        } else if (!(kVar instanceof f)) {
            return false;
        } else {
            if (i == 0 && i2 == 0) {
                com.tencent.mm.pluginsdk.f.a.bmJ();
                com.tencent.mm.pluginsdk.f.a.b(0, 0, 0, "OK");
                this.fTM.K(0, "");
            } else {
                this.fTM.K(-2, "");
            }
            return true;
        }
    }

    public final void a(com.tencent.mm.pluginsdk.wallet.a aVar, String str, int i) {
        this.fTM = aVar;
        if (TextUtils.isEmpty(this.fTP)) {
            v.e("MicroMsg.HwFingerprintOpenDelegate", "get user pwd error");
            aVar.K(-1, this.fTN.getString(2131232833));
            return;
        }
        String userId = e.getUserId();
        String rK = p.rK();
        String bLf = m.bLf();
        String str2 = "";
        CharSequence charSequence = "";
        if (e.anx()) {
            userId = FingerPrintAuth.genOpenFPEncrypt(e.bL(aa.getContext()), userId, rK, str, bLf, "", this.fTO, this.bft, Build.MODEL);
            charSequence = FingerPrintAuth.genOpenFPSign(e.bL(aa.getContext()), e.getUserId(), p.rK(), userId);
        } else {
            userId = str2;
        }
        if (TextUtils.isEmpty(this.fTO)) {
            v.e("MicroMsg.HwFingerprintOpenDelegate", "The value of encrypted_device_info which return by FingerPrintAuth.genOpenFPEncrypt is null");
        } else if (TextUtils.isEmpty(charSequence)) {
            v.e("MicroMsg.HwFingerprintOpenDelegate", "The value of encrypto_open_sign which return by FingerPrintAuth.genOpenFPSign is null");
        }
        this.fTN.b(new f(userId, charSequence, this.fTP, i), false);
    }
}
