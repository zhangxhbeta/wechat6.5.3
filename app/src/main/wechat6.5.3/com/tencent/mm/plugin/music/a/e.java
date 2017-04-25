package com.tencent.mm.plugin.music.a;

import android.os.Looper;
import android.widget.Toast;
import com.tencent.mm.ai.d;
import com.tencent.mm.e.a.id;
import com.tencent.mm.plugin.music.a.a.a.b;
import com.tencent.mm.plugin.music.a.c.c;
import com.tencent.mm.protocal.c.ajr;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.v;

public final class e {
    com.tencent.mm.plugin.music.a.c.a hCC;
    com.tencent.mm.plugin.music.a.a.a hCD;
    private an hCE = new an();
    boolean hCF;
    boolean hCG;
    d hCH;
    public boolean hCI;
    b hCJ = new b(this) {
        final /* synthetic */ e hCL;

        {
            this.hCL = r1;
        }

        public final void nu(int i) {
            if (i == 1) {
                if (this.hCL.hCD != null && !this.hCL.hCI && this.hCL.hCC != null) {
                    this.hCL.hCC.xd(h.d(this.hCL.hCD.big, this.hCL.hCD.fMm));
                    e eVar = this.hCL;
                    if (i.aDg().requestFocus()) {
                        try {
                            if (eVar.hCC != null) {
                                eVar.hCC.play();
                            }
                        } catch (Throwable e) {
                            v.a("MicroMsg.Music.MusicPlayer", e, "startPlay", new Object[0]);
                        }
                        eVar.hCI = true;
                        eVar.hCG = false;
                        return;
                    }
                    v.e("MicroMsg.Music.MusicPlayer", "request focus error");
                }
            } else if (i == -2) {
                ad.o(new Runnable(this) {
                    final /* synthetic */ AnonymousClass3 hCN;

                    {
                        this.hCN = r1;
                    }

                    public final void run() {
                        Toast.makeText(aa.getContext(), aa.getContext().getString(2131233971), 0).show();
                    }
                });
            }
        }
    };
    public a hCK;

    public interface a {
        void bY(int i, int i2);
    }

    public e() {
        this.hCE.dU(aa.getContext());
        this.hCE.a(new com.tencent.mm.sdk.platformtools.an.a(this) {
            final /* synthetic */ e hCL;

            {
                this.hCL = r1;
            }

            public final void dx(int i) {
                switch (i) {
                    case 0:
                        if (this.hCL.hCF) {
                            this.hCL.hCF = false;
                            this.hCL.resume();
                            return;
                        }
                        return;
                    case 1:
                    case 2:
                        if (this.hCL.HC()) {
                            this.hCL.hCF = true;
                            this.hCL.pause();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        });
    }

    public final void b(com.tencent.mm.ai.a aVar) {
        XV();
        a(aVar, false);
        if (aVar == null) {
            v.i("MicroMsg.Music.MusicPlayer", "music is null");
            return;
        }
        this.hCD = new com.tencent.mm.plugin.music.a.a.a(aVar);
        this.hCD.hDn = this.hCJ;
        this.hCD.start();
    }

    final void a(com.tencent.mm.ai.a aVar, boolean z) {
        if (this.hCC == null) {
            if (z || !com.tencent.mm.compatible.util.d.dY(15)) {
                this.hCC = new com.tencent.mm.plugin.music.a.c.b();
            } else {
                this.hCC = new c();
            }
            this.hCC.f(aVar);
            this.hCC.a(new com.tencent.mm.plugin.music.a.c.d(this) {
                final /* synthetic */ e hCL;

                {
                    this.hCL = r1;
                }

                public final void c(com.tencent.mm.ai.a aVar) {
                    e eVar = this.hCL;
                    ajr HA = aVar.HA();
                    v.i("MicroMsg.Music.MusicPlayer", "onStartEvent %b", new Object[]{Boolean.valueOf(eVar.HC())});
                    id idVar = new id();
                    idVar.bif.action = 0;
                    idVar.bif.bib = HA;
                    com.tencent.mm.sdk.c.a.nhr.a(idVar, Looper.getMainLooper());
                    g.aDa();
                    g.hCZ = System.currentTimeMillis();
                    g.hDa = i.aDd().aCW();
                }

                public final void d(com.tencent.mm.ai.a aVar) {
                    com.tencent.mm.ai.a aCW = i.aDd().aCW();
                    if (aCW != null && aCW.a(aVar) && this.hCL.hCC != null && this.hCL.hCC.isPlaying()) {
                        int aDi = this.hCL.hCC.aDi();
                        int duration = this.hCL.hCC.getDuration();
                        if (aDi > 0 && duration > 0) {
                            float f = ((float) aDi) / ((float) duration);
                            if (this.hCL.hCD != null) {
                                float f2;
                                com.tencent.mm.plugin.music.a.a.a aVar2 = this.hCL.hCD;
                                aVar2.hDl = f;
                                boolean isNetworkConnected = ak.isNetworkConnected(aa.getContext());
                                if (aVar2.eUv && isNetworkConnected) {
                                    if (aVar2.fMm) {
                                        if (aVar2.big.field_songWifiFileLength != 0) {
                                            f2 = ((float) aVar2.big.field_wifiDownloadedLength) / ((float) aVar2.big.field_songWifiFileLength);
                                        }
                                    } else if (aVar2.big.field_songFileLength != 0) {
                                        f2 = ((float) aVar2.big.field_downloadedLength) / ((float) aVar2.big.field_songFileLength);
                                    }
                                    if (f2 < 1.0f && f2 - f <= 0.15f && isNetworkConnected) {
                                        v.v("MicroMsg.Music.MusicDownloadTask", "playPercent=%.2f downloadPercent=%.2f isConnectNetwork=%b", new Object[]{Float.valueOf(f), Float.valueOf(f2), Boolean.valueOf(isNetworkConnected)});
                                        aVar2.start();
                                    }
                                }
                                if (this.hCL.hCD != null && this.hCL.hCD.eUv) {
                                    Object obj;
                                    com.tencent.mm.plugin.music.a.a.a aVar3 = this.hCL.hCD;
                                    if (aVar3.fMm) {
                                        if (aVar3.big.field_songWifiFileLength != 0) {
                                            f2 = ((float) aVar3.big.field_wifiDownloadedLength) / ((float) aVar3.big.field_songWifiFileLength);
                                        }
                                        obj = null;
                                        if (obj == null) {
                                            v.i("MicroMsg.Music.MusicPlayer", "download percent not enough can not play");
                                            this.hCL.XV();
                                        }
                                    } else {
                                        if (aVar3.big.field_songFileLength != 0) {
                                            f2 = ((float) aVar3.big.field_downloadedLength) / ((float) aVar3.big.field_songFileLength);
                                        }
                                        obj = null;
                                        if (obj == null) {
                                            v.i("MicroMsg.Music.MusicPlayer", "download percent not enough can not play");
                                            this.hCL.XV();
                                        }
                                    }
                                    if (f2 >= 1.0f) {
                                        obj = 1;
                                    } else {
                                        if (f2 - f > 0.05f) {
                                            obj = 1;
                                        }
                                        obj = null;
                                    }
                                    if (obj == null) {
                                        v.i("MicroMsg.Music.MusicPlayer", "download percent not enough can not play");
                                        this.hCL.XV();
                                    }
                                }
                            }
                            if (this.hCL.hCK != null) {
                                this.hCL.hCK.bY(aDi, duration);
                            }
                        }
                    }
                }

                public final void b(com.tencent.mm.ai.a aVar, boolean z) {
                    com.tencent.mm.ai.a aCW = i.aDd().aCW();
                    if (aCW != null) {
                        if (aCW.a(aVar)) {
                            this.hCL.XV();
                        }
                        ajr HA = aVar.HA();
                        e.e(HA);
                        if (z) {
                            v.i("MicroMsg.Music.MusicPlayer", "onStopEvent");
                            id idVar = new id();
                            idVar.bif.action = 7;
                            idVar.bif.bib = HA;
                            com.tencent.mm.sdk.c.a.nhr.a(idVar, Looper.getMainLooper());
                            g.aDa();
                            if (i.aDd().mode == 2) {
                                f aDd = i.aDd();
                                if (aDd.mode != 1) {
                                    aDd.hCO++;
                                    aDd.hCO %= aDd.hCP.size();
                                    aDd.f(null);
                                }
                            }
                        }
                    }
                }

                public final void c(com.tencent.mm.ai.a aVar, boolean z) {
                    com.tencent.mm.ai.a aCW = i.aDd().aCW();
                    if (aCW != null) {
                        ajr HA = aVar.HA();
                        if (aCW.a(aVar)) {
                            this.hCL.XV();
                            if (z) {
                                v.i("MicroMsg.Music.MusicPlayer", "retry system media player again");
                                this.hCL.a(aCW, true);
                                this.hCL.hCD = new com.tencent.mm.plugin.music.a.a.a(aCW);
                                this.hCL.hCD.hDn = this.hCL.hCJ;
                                this.hCL.hCD.start();
                                return;
                            }
                            ad.o(new Runnable(this) {
                                final /* synthetic */ AnonymousClass2 hCM;

                                {
                                    this.hCM = r1;
                                }

                                public final void run() {
                                    Toast.makeText(aa.getContext(), aa.getContext().getString(2131233968), 0).show();
                                }
                            });
                        }
                        e.e(HA);
                    }
                }
            });
        }
    }

    public final void pause() {
        try {
            if (this.hCC != null && this.hCC.isPlaying()) {
                this.hCC.pause();
                this.hCG = true;
                ajr aCX = i.aDd().aCX();
                v.i("MicroMsg.Music.MusicPlayer", "onPauseEvent");
                id idVar = new id();
                idVar.bif.action = 3;
                idVar.bif.bib = aCX;
                com.tencent.mm.sdk.c.a.nhr.a(idVar, Looper.getMainLooper());
                g.rb();
            }
        } catch (Throwable e) {
            v.a("MicroMsg.Music.MusicPlayer", e, "pause", new Object[0]);
        }
    }

    public final void resume() {
        try {
            if (this.hCC != null && !this.hCC.isPlaying()) {
                if (i.aDg().requestFocus()) {
                    this.hCC.play();
                    this.hCG = false;
                    ajr aCX = i.aDd().aCX();
                    v.i("MicroMsg.Music.MusicPlayer", "onResumeEvent");
                    id idVar = new id();
                    idVar.bif.action = 1;
                    idVar.bif.bib = aCX;
                    com.tencent.mm.sdk.c.a.nhr.a(idVar, Looper.getMainLooper());
                    g.hCZ = System.currentTimeMillis();
                    return;
                }
                v.e("MicroMsg.Music.MusicPlayer", "request focus error");
            }
        } catch (Throwable e) {
            v.a("MicroMsg.Music.MusicPlayer", e, "resume", new Object[0]);
        }
    }

    public final boolean HC() {
        boolean z = false;
        if (this.hCC != null) {
            try {
                z = this.hCC.isPlaying();
            } catch (Throwable th) {
            }
        }
        return z;
    }

    public final void XV() {
        try {
            if (this.hCD != null) {
                this.hCD.eUv = true;
                this.hCD = null;
            }
            if (this.hCC != null) {
                this.hCC.stop();
                this.hCC = null;
            }
        } catch (Throwable e) {
            v.a("MicroMsg.Music.MusicPlayer", e, "stopPlay", new Object[0]);
        }
        i.aDg().aCU();
        this.hCI = false;
    }

    public final int getDuration() {
        if (this.hCC != null) {
            return this.hCC.getDuration();
        }
        return -1;
    }

    public final int aCV() {
        if (this.hCD == null) {
            return 0;
        }
        int i;
        com.tencent.mm.plugin.music.a.a.a aVar = this.hCD;
        if (aVar.fMm) {
            v.v("MicroMsg.Music.MusicDownloadTask", "WifiFileLength: %d downloadLength: %d", new Object[]{Long.valueOf(aVar.big.field_songWifiFileLength), Long.valueOf(aVar.big.field_wifiDownloadedLength)});
            i = aVar.big.field_songWifiFileLength != 0 ? (int) ((aVar.big.field_wifiDownloadedLength * 100) / aVar.big.field_songWifiFileLength) : 0;
        } else {
            v.v("MicroMsg.Music.MusicDownloadTask", "fileLength: %d downloadLength: %d", new Object[]{Long.valueOf(aVar.big.field_songFileLength), Long.valueOf(aVar.big.field_downloadedLength)});
            i = aVar.big.field_songFileLength != 0 ? (int) ((aVar.big.field_downloadedLength * 100) / aVar.big.field_songFileLength) : 0;
        }
        if (i > 0) {
            return i;
        }
        return 0;
    }

    public final boolean fR(int i) {
        try {
            int duration = getDuration();
            int aCV = aCV();
            if (duration < 0 || i > duration) {
                XV();
                return false;
            }
            duration = (int) ((((double) aCV) / 100.0d) * ((double) duration));
            if (aCV != 100 && i > duration) {
                i = duration - 2000;
                v.i("MicroMsg.Music.MusicPlayer", "on completed seekto, position is %d =", new Object[]{Integer.valueOf(i)});
            }
            if (this.hCC != null && i > 0) {
                this.hCC.seek((long) i);
                ajr aCX = i.aDd().aCX();
                v.i("MicroMsg.Music.MusicPlayer", "onSeekToEvent");
                id idVar = new id();
                idVar.bif.action = 8;
                idVar.bif.bib = aCX;
                com.tencent.mm.sdk.c.a.nhr.a(idVar, Looper.getMainLooper());
                g.aDa();
                return true;
            }
            return false;
        } catch (Throwable e) {
            v.a("MicroMsg.Music.MusicPlayer", e, "seekTo", new Object[0]);
        }
    }

    public static void e(ajr com_tencent_mm_protocal_c_ajr) {
        v.i("MicroMsg.Music.MusicPlayer", "onStopEvent");
        id idVar = new id();
        idVar.bif.action = 2;
        idVar.bif.bib = com_tencent_mm_protocal_c_ajr;
        com.tencent.mm.sdk.c.a.nhr.a(idVar, Looper.getMainLooper());
        g.aDa();
    }
}
