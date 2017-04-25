package com.tencent.mm.plugin.mmsight.segment.mp.inner;

import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager.WakeLock;
import android.os.SystemClock;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;
import java.io.IOException;

public final class h {
    MediaFormat hoj;
    a htI;
    int hts = 0;
    public int htt = 3;
    float htu = 1.0f;
    float htv = 1.0f;
    g huA;
    public d huB;
    e huC;
    public i huD;
    b huE;
    private WakeLock huF = null;
    boolean huG;
    private boolean huH;
    public boolean huI;
    b huJ;
    boolean huK;
    m huL = m.AUTO;
    int huM = l.hvd;
    final Object huN = new Object();
    public k hug = k.EXACT;
    public Surface huh;
    public SurfaceHolder hui;
    g huj;
    g huk;
    int hul;
    private MediaFormat hum;
    private long hun;
    int huo;
    private long hup;
    public j huq = null;
    long hur;
    private long hus;
    boolean hut;
    int huu;
    j huv = new j();
    a huw = new a(this, Looper.getMainLooper());
    public f hux;
    c huy;
    h huz;

    private class a extends Handler {
        final /* synthetic */ h huO;

        public a(h hVar, Looper looper) {
            this.huO = hVar;
            super(looper);
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if (this.huO.hux != null) {
                        this.huO.hux.a(this.huO);
                        return;
                    }
                    return;
                case 2:
                    if (this.huO.huy != null) {
                        this.huO.huy.b(this.huO);
                    }
                    this.huO.es(false);
                    return;
                case 3:
                    if (this.huO.huE != null) {
                        this.huO.huE.a(this.huO, message.arg1);
                    }
                    this.huO.huu = message.arg1;
                    return;
                case 4:
                    if (this.huO.huA != null) {
                        this.huO.huA.c(this.huO);
                        return;
                    }
                    return;
                case 5:
                    if (this.huO.huD != null) {
                        this.huO.huD.bU(message.arg1, message.arg2);
                        return;
                    }
                    return;
                case 100:
                    new StringBuilder("Error (").append(message.arg1).append(",").append(message.arg2).append(")");
                    boolean a;
                    if (this.huO.huB != null) {
                        a = this.huO.huB.a(this.huO, message.arg1, message.arg2);
                    } else {
                        a = false;
                    }
                    if (!(this.huO.huy == null || r0)) {
                        this.huO.huy.b(this.huO);
                    }
                    this.huO.es(false);
                    return;
                case 200:
                    if (this.huO.huC != null) {
                        this.huO.huC.b(this.huO, message.arg1, message.arg2);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public interface b {
        void a(h hVar, int i);
    }

    public interface c {
        void b(h hVar);
    }

    public interface d {
        boolean a(h hVar, int i, int i2);
    }

    public interface e {
        boolean b(h hVar, int i, int i2);
    }

    public interface f {
        void a(h hVar);
    }

    public interface g {
        void c(h hVar);
    }

    public interface h {
        void d(h hVar);
    }

    public interface i {
        void bU(int i, int i2);
    }

    private class j extends HandlerThread implements Callback {
        boolean doh = true;
        final /* synthetic */ h huO;
        private a huQ;
        private boolean huR;
        private double huS;
        private boolean huT;
        private boolean hue;
        Handler mHandler;

        static /* synthetic */ void a(j jVar) {
            if (jVar.isAlive()) {
                synchronized (jVar.huO.huN) {
                    jVar.doh = true;
                    if (jVar.mHandler != null) {
                        jVar.mHandler.removeMessages(4);
                        jVar.mHandler.removeMessages(3);
                        jVar.mHandler.sendEmptyMessage(5);
                        try {
                            jVar.huO.huN.wait();
                        } catch (InterruptedException e) {
                        }
                    } else {
                        jVar.aBm();
                    }
                }
            }
        }

        public j(h hVar) {
            this.huO = hVar;
            super("InnerMediaPlayer#" + j.class.getSimpleName(), -16);
            this.hue = hVar.huL.aBn();
            this.huR = true;
            this.huT = false;
        }

        public synchronized void start() {
            super.start();
            this.mHandler = new Handler(getLooper(), this);
        }

        public final void setSurface(Surface surface) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(100, surface));
        }

        public boolean handleMessage(Message message) {
            if (isInterrupted()) {
                return true;
            }
            try {
                switch (message.what) {
                    case 1:
                        aBk();
                        return true;
                    case 2:
                        et(false);
                        return true;
                    case 3:
                        aBl();
                        return true;
                    case 4:
                        long longValue = ((Long) message.obj).longValue();
                        if (this.huQ != null) {
                            this.huO.huJ.htF.a(this.huQ);
                            this.huQ = null;
                        }
                        if (this.huO.htI != null) {
                            this.huO.htI.en(true);
                        }
                        this.huO.huJ.a(this.huO.hug, longValue);
                        this.huO.huv.ci(this.huO.huJ.aBa());
                        boolean hasMessages = this.mHandler.hasMessages(4);
                        if (hasMessages) {
                            for (e eVar : this.huO.huJ.htE) {
                                if (eVar.htY != null) {
                                    eVar.a(eVar.htY);
                                }
                            }
                        } else {
                            this.huO.huJ.aAZ();
                        }
                        if (!hasMessages) {
                            this.huO.hur = this.huO.huJ.aBa();
                            this.huO.hut = false;
                            this.huT = false;
                            this.huO.huw.sendEmptyMessage(4);
                            if (!this.doh) {
                                aBk();
                            }
                        }
                        return true;
                    case 5:
                        aBm();
                        return true;
                    case 6:
                        if (this.huO.htI != null) {
                            this.huO.htI.en(true);
                        }
                        return true;
                    case 100:
                        Surface surface = (Surface) message.obj;
                        if (!(this.huO.huJ == null || this.huO.huJ.htF == null)) {
                            if (this.huQ != null) {
                                this.huO.huJ.htF.a(this.huQ);
                                this.huQ = null;
                            }
                            this.huO.huJ.htF.a(surface);
                        }
                        return true;
                    default:
                        return false;
                }
            } catch (InterruptedException e) {
                this.huO.huw.sendMessage(this.huO.huw.obtainMessage(100, 1, 0));
                aBm();
                return true;
            } catch (IllegalStateException e2) {
                this.huO.huw.sendMessage(this.huO.huw.obtainMessage(100, 1, 0));
                aBm();
                return true;
            } catch (IOException e3) {
                this.huO.huw.sendMessage(this.huO.huw.obtainMessage(100, 1, -1004));
                aBm();
                return true;
            }
        }

        private void aBk() {
            if (this.huO.huJ.aBb()) {
                this.huO.hur = 0;
                this.huO.huJ.a(k.FAST_TO_PREVIOUS_SYNC, 0);
            }
            this.huO.huv.ci(this.huO.huJ.aBa());
            if (this.huO.htI != null) {
                this.mHandler.removeMessages(6);
                this.huO.htI.play();
            }
            this.huS = this.huO.huv.aIr;
            if (this.huO.htI != null) {
                this.huO.htI.R((float) this.huS);
            }
            this.mHandler.removeMessages(3);
            aBl();
        }

        private void et(boolean z) {
            this.mHandler.removeMessages(3);
            if (this.huO.htI == null) {
                return;
            }
            if (z) {
                Handler handler = this.mHandler;
                long aAW = this.huO.htI.aAW();
                a aVar = this.huO.htI;
                handler.sendEmptyMessageDelayed(6, ((aAW + ((long) ((((double) (aVar.htp / aVar.htn)) / ((double) aVar.aTB)) * 1000000.0d))) / 1000) + 1);
                return;
            }
            this.huO.htI.en(false);
        }

        private void aBl() {
            long cachedDuration = this.huO.huJ.getCachedDuration();
            if (cachedDuration != -1) {
                this.huO.huw.sendMessage(this.huO.huw.obtainMessage(3, (int) ((100.0d / ((double) (this.huO.getDuration() * BaseReportManager.MAX_READ_COUNT))) * ((double) (this.huO.hur + cachedDuration))), 0));
            }
            if (!this.huO.huK || cachedDuration <= -1 || cachedDuration >= 2000000 || this.huO.huJ.hasCacheReachedEndOfStream()) {
                if (this.huO.huJ.htF != null && this.huQ == null) {
                    this.huQ = this.huO.huJ.eq(false);
                    if (this.huQ == null && !this.huO.huJ.aBb()) {
                        this.mHandler.sendEmptyMessageDelayed(3, 10);
                        return;
                    }
                }
                long elapsedRealtime = SystemClock.elapsedRealtime();
                if (this.huO.huK) {
                    this.huO.huK = false;
                    this.huO.huw.sendMessage(this.huO.huw.obtainMessage(200, 702, 0));
                    this.huO.huv.ci(this.huO.huJ.aBa());
                }
                if (this.huQ == null || this.huO.huv.cj(this.huQ.presentationTimeUs) <= 60000) {
                    long cj;
                    this.huO.hur = this.huO.huJ.aBa();
                    if (!(this.huO.huJ.htF == null || this.huQ == null)) {
                        a aVar = this.huQ;
                        if (aVar.hub) {
                            this.huO.huJ.htF.a(aVar);
                        } else {
                            cj = this.huO.huv.cj(aVar.presentationTimeUs);
                            if (cj < -1000) {
                                this.huO.huw.sendMessage(this.huO.huw.obtainMessage(200, 700, 0));
                            }
                            if (aVar.huc) {
                                this.huO.huw.sendMessage(this.huO.huw.obtainMessage(5, this.huO.huJ.htF.getVideoWidth(), this.huO.huJ.htF.getVideoHeight()));
                            }
                            if (!this.hue && cj > 5000) {
                                Thread.sleep(cj / 1000);
                            }
                            this.huO.huJ.htF.a(aVar, cj);
                        }
                        this.huQ = null;
                        if (this.huR) {
                            this.huR = false;
                            this.huO.huw.sendMessage(this.huO.huw.obtainMessage(200, 3, 0));
                        }
                    }
                    if (this.huO.htI != null) {
                        if (this.huS != this.huO.huv.aIr) {
                            this.huS = this.huO.huv.aIr;
                            this.huO.htI.R((float) this.huS);
                        }
                        a aVar2 = this.huO.htI;
                        if (aVar2.htw == a.htk) {
                            cachedDuration = a.htk;
                        } else {
                            cj = aVar2.aAX();
                            if (cj < aVar2.htx) {
                                aVar2.htw += (long) ((-1.0d / ((double) aVar2.aTB)) * 1000000.0d);
                            }
                            aVar2.htx = cj;
                            cachedDuration = aVar2.htw + cj;
                        }
                        if (cachedDuration > a.htk) {
                            this.huO.huv.ci(cachedDuration);
                        }
                    }
                    if (this.huO.huJ.aBb()) {
                        this.huO.huw.sendEmptyMessage(2);
                        if (this.huO.huI) {
                            if (this.huO.htI != null) {
                                this.huO.htI.flush();
                            }
                            this.huO.huJ.a(k.FAST_TO_PREVIOUS_SYNC, 0);
                            this.huO.huJ.aAZ();
                        } else {
                            this.doh = true;
                            et(true);
                        }
                    } else {
                        this.huQ = this.huO.huJ.eq(false);
                    }
                    if (!this.doh) {
                        cachedDuration = ((long) (10.0d / this.huO.huv.aIr)) - (SystemClock.elapsedRealtime() - elapsedRealtime);
                        if (cachedDuration > 0) {
                            this.mHandler.sendEmptyMessageDelayed(3, cachedDuration);
                            return;
                        } else {
                            this.mHandler.sendEmptyMessage(3);
                            return;
                        }
                    }
                    return;
                }
                this.mHandler.sendEmptyMessageDelayed(3, 50);
                return;
            }
            this.mHandler.sendEmptyMessageDelayed(3, 100);
        }

        private void aBm() {
            int i = 1;
            interrupt();
            this.doh = true;
            if (this.mHandler != null) {
                this.mHandler.removeMessages(4);
                this.mHandler.removeMessages(3);
                this.mHandler.removeMessages(2);
                this.mHandler.removeMessages(6);
            }
            if (this.huO.huJ != null) {
                if (this.huQ != null) {
                    this.huO.huJ.htF.b(this.huQ);
                    this.huQ = null;
                }
                b bVar = this.huO.huJ;
                for (e eVar : bVar.htE) {
                    eVar.htM.stop();
                    eVar.htM.release();
                }
                bVar.htE.clear();
            }
            if (this.huO.htI != null) {
                this.huO.htI.eo(true);
            }
            int i2 = this.huO.huk != null ? 1 : 0;
            if (this.huO.huk == this.huO.huj) {
                i = 0;
            }
            if ((i2 & i) != 0) {
                this.huO.huk.huf.release();
            }
            if (this.huO.huj != null) {
                this.huO.huj.huf.release();
            }
            synchronized (this.huO.huN) {
                this.huO.huN.notify();
            }
        }
    }

    public enum k {
        FAST(0),
        FAST_TO_PREVIOUS_SYNC(0),
        FAST_TO_NEXT_SYNC(1),
        FAST_TO_CLOSEST_SYNC(2),
        PRECISE(0),
        EXACT(0),
        FAST_EXACT(0);
        
        int hvb;

        private k(int i) {
            this.hvb = 0;
            this.hvb = i;
        }
    }

    private enum l {
        ;

        static {
            hvd = 1;
            hve = 2;
            hvf = 3;
            hvg = 4;
            hvh = 5;
            hvi = 6;
            hvj = 7;
            hvk = 8;
            hvl = new int[]{hvd, hve, hvf, hvg, hvh, hvi, hvj, hvk};
        }
    }

    public enum m {
        AUTO,
        SLEEP,
        SURFACEVIEW_TIMESTAMP_API21;

        public final boolean aBn() {
            switch (this) {
                case AUTO:
                    if (VERSION.SDK_INT < 21) {
                        return false;
                    }
                    return true;
                case SLEEP:
                    return false;
                case SURFACEVIEW_TIMESTAMP_API21:
                    return true;
                default:
                    return false;
            }
        }
    }

    public final void a(i iVar) {
        int i = 0;
        if (this.huM != l.hvd) {
            throw new IllegalStateException();
        }
        this.huj = iVar.aBc();
        this.huk = iVar.aBd();
        this.hul = -1;
        this.huo = -1;
        for (int i2 = 0; i2 < this.huj.huf.getTrackCount(); i2++) {
            MediaFormat trackFormat = this.huj.getTrackFormat(i2);
            trackFormat.toString();
            String string = trackFormat.getString("mime");
            if (this.hul < 0 && string.startsWith("video/")) {
                this.huj.selectTrack(i2);
                this.hul = i2;
                this.hum = trackFormat;
                this.hun = this.huj.huf.getSampleTime();
            } else if (this.huk == null && this.huo < 0 && string.startsWith("audio/")) {
                this.huj.selectTrack(i2);
                this.huo = i2;
                this.hoj = trackFormat;
                this.hup = this.huj.huf.getSampleTime();
                this.huk = this.huj;
            }
        }
        if (this.huk != null && this.huo == -1) {
            while (i < this.huk.huf.getTrackCount()) {
                MediaFormat trackFormat2 = this.huk.getTrackFormat(i);
                trackFormat2.toString();
                String string2 = trackFormat2.getString("mime");
                if (this.huo < 0 && string2.startsWith("audio/")) {
                    this.huk.selectTrack(i);
                    this.huo = i;
                    this.hoj = trackFormat2;
                    this.hup = this.huk.huf.getSampleTime();
                }
                i++;
            }
        }
        if (this.hul == -1) {
            this.huj = null;
        }
        if (this.hul == -1 && this.huo == -1) {
            throw new IOException("invalid data source, no supported stream found");
        }
        this.huM = l.hve;
    }

    public final void prepareAsync() {
        if (this.huM == l.hve || this.huM == l.hvh) {
            this.huM = l.hvf;
            new Thread(new Runnable(this) {
                final /* synthetic */ h huO;

                {
                    this.huO = r1;
                }

                public final void run() {
                    try {
                        int i;
                        h hVar = this.huO;
                        if (hVar.hoj != null) {
                            hVar.htI = new a();
                            a aVar = hVar.htI;
                            i = hVar.hts;
                            if (aVar.isInitialized()) {
                                throw new IllegalStateException("cannot set session id on an initialized audio track");
                            }
                            aVar.hts = i;
                            float f = hVar.htu;
                            float f2 = hVar.htv;
                            hVar.htu = f;
                            hVar.htv = f2;
                            if (hVar.htI != null) {
                                hVar.htI.u(f, f2);
                            }
                        }
                        b anonymousClass1 = new b(hVar) {
                            final /* synthetic */ h huO;

                            {
                                this.huO = r1;
                            }

                            public final void aBi() {
                                if (this.huO.huq != null && !this.huO.huq.doh && !this.huO.huK && this.huO.huJ.getCachedDuration() < 2000000 && !this.huO.huJ.hasCacheReachedEndOfStream()) {
                                    this.huO.huK = true;
                                    this.huO.huw.sendMessage(this.huO.huw.obtainMessage(200, 701, 0));
                                }
                            }
                        };
                        hVar.huJ = new b();
                        if (hVar.hul != -1) {
                            try {
                                hVar.huJ.a(new f(hVar.huj, hVar.hul, anonymousClass1, hVar.huh, hVar.huL.aBn()));
                            } catch (Exception e) {
                                new StringBuilder("cannot create video decoder: ").append(e.getMessage());
                            }
                        }
                        if (hVar.huo != -1) {
                            try {
                                boolean z;
                                g gVar;
                                if (hVar.huk == hVar.huj || hVar.huk == null) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (hVar.huk != null) {
                                    gVar = hVar.huk;
                                } else {
                                    gVar = hVar.huj;
                                }
                                hVar.huJ.a(new d(gVar, z, hVar.huo, anonymousClass1, hVar.htI));
                            } catch (Exception e2) {
                                new StringBuilder("cannot create audio decoder: ").append(e2.getMessage());
                            }
                        }
                        if (hVar.huJ.htE.isEmpty()) {
                            throw new IOException("cannot decode any stream");
                        }
                        if (hVar.htI != null) {
                            hVar.hts = hVar.htI.hts;
                            hVar.htt = hVar.htI.htt;
                        }
                        if (hVar.huJ.htF != null) {
                            int i2;
                            i = hVar.huJ.htF.getVideoWidth();
                            int videoHeight = hVar.huJ.htF.getVideoHeight();
                            MediaFormat mediaFormat = hVar.huJ.htF.htL;
                            if (mediaFormat == null || !mediaFormat.containsKey("rotation-degrees")) {
                                i2 = 0;
                            } else {
                                i2 = mediaFormat.getInteger("rotation-degrees");
                            }
                            if (i2 <= 0 || i2 == 180) {
                                int i3 = i;
                                i = videoHeight;
                                videoHeight = i3;
                            }
                            hVar.huw.sendMessage(hVar.huw.obtainMessage(5, videoHeight, i));
                        }
                        if (!(hVar.huM == l.hvi || hVar.huM == l.hvj)) {
                            if (hVar.huJ.htF != null) {
                                hVar.huJ.htF.b(hVar.huJ.eq(true));
                            } else {
                                hVar.huJ.eq(false);
                            }
                            if (hVar.htI != null) {
                                hVar.htI.en(true);
                            }
                            hVar.huJ.a(k.FAST_TO_PREVIOUS_SYNC, 0);
                            synchronized (hVar.huN) {
                                if (hVar.huM == l.hvi || hVar.huM == l.hvj) {
                                } else {
                                    hVar.huq = new j(hVar);
                                    hVar.huq.start();
                                    hVar.huM = l.hvg;
                                }
                            }
                        }
                        if (this.huO.huM == l.hvg) {
                            this.huO.huw.sendEmptyMessage(1);
                        }
                    } catch (IOException e3) {
                        this.huO.huw.sendMessage(this.huO.huw.obtainMessage(100, 1, -1004));
                    } catch (IllegalStateException e4) {
                        this.huO.huw.sendMessage(this.huO.huw.obtainMessage(100, 1, 0));
                    }
                }
            }).start();
            return;
        }
        throw new IllegalStateException();
    }

    public final void start() {
        if (this.huM != l.hvg) {
            this.huM = l.hvk;
            throw new IllegalStateException();
        }
        j jVar = this.huq;
        jVar.doh = false;
        jVar.mHandler.sendEmptyMessage(1);
        es(true);
    }

    public final void pause() {
        if (this.huM != l.hvg) {
            this.huM = l.hvk;
            throw new IllegalStateException();
        }
        j jVar = this.huq;
        jVar.doh = true;
        jVar.mHandler.sendEmptyMessage(2);
        es(false);
    }

    public final void seekTo(int i) {
        long j = ((long) i) * 1000;
        if (this.huM - 1 >= l.hvg - 1 || this.huM - 1 < l.hvi - 1) {
            if (this.huz != null) {
                this.huz.d(this);
            }
            this.hut = true;
            this.hus = Math.max(this.hun, j);
            j jVar = this.huq;
            long j2 = this.hus;
            jVar.mHandler.removeMessages(4);
            jVar.mHandler.obtainMessage(4, Long.valueOf(j2)).sendToTarget();
            return;
        }
        this.huM = l.hvk;
        throw new IllegalStateException();
    }

    public final boolean isPlaying() {
        if (this.huM - 1 < l.hvi - 1) {
            return (this.huq == null || this.huq.doh) ? false : true;
        } else {
            this.huM = l.hvk;
            throw new IllegalStateException();
        }
    }

    public final void stop() {
        if (this.huq != null) {
            j.a(this.huq);
            this.huq = null;
        }
        es(false);
        this.huM = l.hvh;
    }

    public final void release() {
        this.huM = l.hvi;
        stop();
        this.huM = l.hvj;
    }

    final void es(boolean z) {
        if (this.huF != null) {
            if (z && !this.huF.isHeld()) {
                this.huF.acquire();
            } else if (!z && this.huF.isHeld()) {
                this.huF.release();
            }
        }
        this.huH = z;
        aBj();
    }

    public final void aBj() {
        if (this.hui != null) {
            SurfaceHolder surfaceHolder = this.hui;
            boolean z = this.huG && this.huH;
            surfaceHolder.setKeepScreenOn(z);
        }
    }

    public final int getDuration() {
        if (this.huM - 1 <= l.hvf - 1 && this.huM - 1 >= l.hvi - 1) {
            this.huM = l.hvk;
            throw new IllegalStateException();
        } else if (this.hum != null) {
            return (int) (this.hum.getLong("durationUs") / 1000);
        } else {
            return (this.hoj == null || !this.hoj.containsKey("durationUs")) ? 0 : (int) (this.hoj.getLong("durationUs") / 1000);
        }
    }

    public final int getCurrentPosition() {
        if (this.huM - 1 >= l.hvi - 1) {
            this.huM = l.hvk;
            throw new IllegalStateException();
        }
        return (int) ((this.hut ? this.hus : this.hur) / 1000);
    }

    public final void a(m mVar) {
        if (this.huq != null) {
            throw new IllegalStateException("called after prepare/prepareAsync");
        } else if (mVar != m.SURFACEVIEW_TIMESTAMP_API21 || VERSION.SDK_INT >= 21) {
            new StringBuilder("setVideoRenderTimingMode ").append(mVar);
            this.huL = mVar;
        } else {
            throw new IllegalArgumentException("this mode needs min API 21");
        }
    }
}
