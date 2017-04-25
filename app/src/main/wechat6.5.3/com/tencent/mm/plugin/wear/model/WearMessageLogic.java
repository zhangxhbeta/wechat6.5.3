package com.tencent.mm.plugin.wear.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.wear.model.e.p;
import com.tencent.mm.plugin.wear.model.e.p.AnonymousClass1;
import com.tencent.mm.plugin.wear.model.f.d;
import com.tencent.mm.protocal.c.bin;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.qqpinyin.voicerecoapi.c;
import java.io.IOException;

public class WearMessageLogic extends BroadcastReceiver {

    private class a extends d {
        public int iwf;
        public int lbw;
        public int lbx;
        public byte[] lby;
        final /* synthetic */ WearMessageLogic lbz;

        private a(WearMessageLogic wearMessageLogic) {
            this.lbz = wearMessageLogic;
        }

        protected final void execute() {
            v.i("MicroMsg.Wear.WearMessageLogic", "handle message %s", new Object[]{toString()});
            com.tencent.mm.plugin.wear.model.e.a sD = a.bhH().laP.sD(this.lbx);
            if (sD != null) {
                sD.b(this.lbw, this.iwf, this.lbx, this.lby);
            }
        }

        public final String getName() {
            return "HttpMessageTask";
        }

        public final String toString() {
            return String.format("connectType=%d funId=%d sessionId=%d", new Object[]{Integer.valueOf(this.lbw), Integer.valueOf(this.lbx), Integer.valueOf(this.iwf)});
        }
    }

    private class b extends d {
        public int iwf;
        public int lbw;
        public int lbx;
        public byte[] lby;
        final /* synthetic */ WearMessageLogic lbz;

        private b(WearMessageLogic wearMessageLogic) {
            this.lbz = wearMessageLogic;
        }

        protected final void execute() {
            switch (this.lbx) {
                case 30001:
                    p pVar = a.bhH().laR.lbl;
                    int i = this.iwf;
                    byte[] bArr = this.lby;
                    if (!pVar.lcl.contains(Integer.valueOf(i))) {
                        bin com_tencent_mm_protocal_c_bin = new bin();
                        try {
                            com_tencent_mm_protocal_c_bin.az(bArr);
                        } catch (IOException e) {
                        }
                        if (pVar.lcj != i) {
                            pVar.reset();
                            pVar.lcj = i;
                            v.i("MicroMsg.Wear.VoiceToTextServer", "startNewSession %s", new Object[]{Integer.valueOf(pVar.lcj)});
                            com.tencent.mm.loader.stub.b.deleteFile(p.lce);
                            if (pVar.lch == null) {
                                pVar.lch = new com.tencent.mm.c.c.d();
                                pVar.lch.bA(p.lce);
                            }
                            if (pVar.lcg == null) {
                                pVar.lcg = new c(1500000);
                                if (pVar.lcg.start() != 0) {
                                    pVar.lck = -2;
                                    return;
                                }
                            }
                            String str = com_tencent_mm_protocal_c_bin.ncy;
                            if (pVar.lcf == null) {
                                ad.o(new AnonymousClass1(pVar, str));
                            }
                            pVar.a(i, com_tencent_mm_protocal_c_bin);
                            return;
                        } else if (com_tencent_mm_protocal_c_bin.ndc) {
                            v.i("MicroMsg.Wear.VoiceToTextServer", "cancel session %d", new Object[]{Integer.valueOf(i)});
                            pVar.reset();
                            return;
                        } else if (com_tencent_mm_protocal_c_bin.ndb) {
                            pVar.a(i, com_tencent_mm_protocal_c_bin);
                            if (pVar.lch != null) {
                                pVar.lch.pv();
                                pVar.lch = null;
                                v.i("MicroMsg.Wear.VoiceToTextServer", "finish speex compress");
                            }
                            if (pVar.lcg != null) {
                                pVar.lcg.stop();
                                pVar.lcg = null;
                                v.i("MicroMsg.Wear.VoiceToTextServer", "finish voiceDetectAPI");
                            }
                            if (pVar.lcf != null) {
                                pVar.lcf.diB = true;
                                if (!pVar.cFQ) {
                                    ak.vy().a(pVar.lcf, 0);
                                }
                                pVar.lcf = null;
                                v.i("MicroMsg.Wear.VoiceToTextServer", "finish netSceneVoiceToText");
                                return;
                            }
                            return;
                        } else {
                            pVar.a(i, com_tencent_mm_protocal_c_bin);
                            return;
                        }
                    }
                    return;
                default:
                    return;
            }
        }

        public final String getName() {
            return "LongConnectTask";
        }
    }

    public WearMessageLogic() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mm.wear.message");
        aa.getContext().registerReceiver(this, intentFilter, "com.tencent.mm.wear.message", null);
    }

    public void onReceive(Context context, Intent intent) {
        byte b = (byte) 0;
        if (intent.getAction().equals("com.tencent.mm.wear.message")) {
            Bundle extras = intent.getExtras();
            int i = extras.getInt("key_connecttype");
            if (i == 1) {
                Runnable aVar = new a();
                aVar.lbw = i;
                aVar.lbx = extras.getInt("key_funid");
                aVar.iwf = extras.getInt("key_sessionid");
                aVar.lby = extras.getByteArray("key_data");
                com.tencent.mm.plugin.wear.model.e.a sD = a.bhH().laP.sD(aVar.lbx);
                if (sD != null) {
                    b = sD.sB(aVar.lbx);
                }
                if (b != (byte) 0) {
                    ad.o(aVar);
                } else {
                    e.a(aVar, "WearHttpMessageTask_" + aVar.lbx);
                }
            } else if (i == 2) {
                d bVar = new b();
                bVar.lbw = i;
                bVar.lbx = extras.getInt("key_funid");
                bVar.iwf = extras.getInt("key_sessionid");
                bVar.lby = extras.getByteArray("key_data");
                a.bhH().laX.a(bVar);
            }
        }
    }
}
