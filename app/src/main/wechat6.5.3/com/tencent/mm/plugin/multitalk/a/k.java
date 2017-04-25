package com.tencent.mm.plugin.multitalk.a;

import android.os.Looper;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.pluginsdk.j.m;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.pb.talkroom.sdk.f;
import java.util.concurrent.LinkedBlockingQueue;

public final class k implements Runnable {
    boolean aVv;
    protected ac[] hAa;
    m hAb = new m("multitalk_network");
    private int hAc;
    private int hAd = 5;
    private int hAe;
    private int hAf;
    protected LinkedBlockingQueue<c> hzZ = new LinkedBlockingQueue();
    protected a hzt;

    private class a implements Runnable {
        final /* synthetic */ k hAg;
        int index;

        a(k kVar, int i) {
            this.hAg = kVar;
            this.index = i;
        }

        public final void run() {
            Looper.prepare();
            v.i("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "start drawer handler");
            this.hAg.hAa[this.index] = new ac();
            Looper.loop();
        }
    }

    protected class b implements Runnable {
        final /* synthetic */ k hAg;
        private c hAh;

        public b(k kVar, c cVar) {
            this.hAg = kVar;
            this.hAh = cVar;
        }

        public final void run() {
            if (this.hAh != null) {
                v.d("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "draw user %s threadId %d", new Object[]{this.hAh.username, Long.valueOf(Thread.currentThread().getId())});
                if (this.hAg.hzt != null) {
                    this.hAg.hzt.a(this.hAh.username, this.hAh.hAi, this.hAh.hAk, this.hAh.hAl, OpenGlRender.kBw);
                }
                try {
                    this.hAg.hzZ.put(this.hAh);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    public class c {
        boolean cvW;
        final /* synthetic */ k hAg;
        int[] hAi;
        int hAj;
        int hAk;
        int hAl;
        String username;

        c(k kVar, boolean z) {
            this.hAg = kVar;
            this.cvW = z;
        }
    }

    public k(a aVar) {
        this.hzt = aVar;
    }

    public final void start() {
        int i;
        v.i("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "current member size %d", new Object[]{Integer.valueOf(this.hAc)});
        this.aVv = true;
        e.d(this, "MultiTalk_videoReceiver1", 1).start();
        e.d(this, "MultiTalk_videoReceiver2", 1).start();
        this.hAa = new ac[2];
        for (i = 0; i < this.hAa.length; i++) {
            e.d(new a(this, i), "MultiTalkVideoTaskManager_drawer_handler", 1).start();
        }
        for (i = 0; i < 36; i++) {
            this.hzZ.add(new c(this, false));
        }
    }

    public final void stop() {
        int i = 0;
        this.hzt = null;
        this.aVv = false;
        this.hAc = 0;
        if (this.hAa != null) {
            while (i < this.hAa.length) {
                if (this.hAa[i] != null) {
                    this.hAa[i].removeCallbacksAndMessages(null);
                    this.hAa[i].getLooper().quit();
                    this.hAa[i] = null;
                }
                i++;
            }
        }
        this.hzZ.clear();
        this.hzZ.add(new c(this, true));
        this.hzZ.add(new c(this, true));
    }

    public final void run() {
        v.i("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "start run receiver sleepTime: " + this.hAd);
        while (this.aVv) {
            this.hAb.GW("_total");
            c cVar = null;
            try {
                cVar = (c) this.hzZ.take();
            } catch (InterruptedException e) {
            }
            boolean z = false;
            if (cVar != null) {
                if (cVar.cvW) {
                    break;
                }
                z = a(cVar);
            }
            if (!z) {
                try {
                    Thread.sleep((long) this.hAd);
                } catch (InterruptedException e2) {
                }
            }
        }
        v.i("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "stop run receiver");
    }

    public final void nq(int i) {
        this.hAc = i;
        v.i("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "memberSize " + i);
    }

    private synchronized boolean a(c cVar) {
        boolean z = true;
        synchronized (this) {
            if (cVar != null) {
                if (cVar.hAi == null) {
                    cVar.hAi = new int[25600];
                }
                cVar.hAi[0] = 0;
                if (Thread.currentThread().getName().contains("MultiTalk_videoReceiver2")) {
                    cVar.hAi[0] = 1;
                }
                f u = o.aCF().hyY.u(cVar.hAi);
                if (this.hzt == null || u.ret <= 0 || be.kS(u.ptf)) {
                    if (u.ret == 0) {
                        this.hAe++;
                    }
                    this.hAb.GW("_fail");
                    v.v("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "handleIdleObj fail ret %d", new Object[]{Integer.valueOf(u.ret)});
                    if ((this.hAe + this.hAf) % 100 == 0) {
                        v.v("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "01_rate: 0:%f 1:%f", new Object[]{Float.valueOf(((float) this.hAe) / ((float) (this.hAe + this.hAf))), Float.valueOf(((float) this.hAf) / ((float) (this.hAe + this.hAf)))});
                    }
                    try {
                        this.hzZ.put(cVar);
                    } catch (InterruptedException e) {
                    }
                    z = false;
                } else {
                    int wD = this.hzt.wD(u.ptf);
                    cVar.username = u.ptf;
                    cVar.hAk = u.ptj;
                    cVar.hAl = u.ptk;
                    cVar.hAj = u.pti;
                    v.d("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "handleIdleObj get username: %s, position: %d", new Object[]{cVar.username, Integer.valueOf(wD)});
                    if (wD >= 0 && this.hAa[wD % 2] != null) {
                        this.hAa[wD % 2].post(new b(this, cVar));
                    }
                    this.hAb.GW("_success");
                    this.hAf++;
                    if ((this.hAe + this.hAf) % 100 == 0) {
                        v.v("MicroMsg.MT.MultiTalkVideoNetworkReceiver", "01_rate: 0:%d 1:%d", new Object[]{Integer.valueOf(this.hAe / (this.hAe + this.hAf)), Integer.valueOf(this.hAf / (this.hAe + this.hAf))});
                    }
                }
            } else {
                z = false;
            }
        }
        return z;
    }
}
