package com.tencent.mm.plugin.sight.decode.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.NinePatchDrawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Build.VERSION;
import android.os.Looper;
import android.view.Surface;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.tencent.mm.e.a.pn;
import com.tencent.mm.memory.o;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class b {
    private static HashMap<String, WeakReference<Bitmap>> iUf = new HashMap();
    private static Map<String, Integer> iUj = new ConcurrentHashMap();
    private boolean cXI = false;
    private ac fnw;
    public boolean gFD = true;
    private Surface huh;
    private int iTH = 0;
    private int iTI = 0;
    public String iTJ = SQLiteDatabase.KeyEmpty;
    private String iTK = SQLiteDatabase.KeyEmpty;
    private int iTL = -1;
    protected int iTM = 41;
    private Bitmap iTN;
    public Bitmap iTO;
    private Bitmap iTP;
    private WeakReference<View> iTQ;
    private WeakReference<TextView> iTR;
    private long iTS;
    public WeakReference<View> iTT;
    private Animation iTU;
    private Animation iTV;
    private volatile h iTW;
    private volatile b iTX;
    public volatile i iTY;
    private volatile c iTZ;
    private k iUa;
    private j iUb;
    private d iUc;
    public boolean iUd = true;
    public boolean iUe = false;
    public boolean iUg = false;
    public double iUh = -1.0d;
    boolean iUi = false;
    public double iUk = -1.0d;
    private boolean iUl = false;
    public boolean iUm = false;
    private a iUn;
    public e iUo;
    public f iUp;
    public g iUq;
    public int position;

    class AnonymousClass3 implements Runnable {
        final /* synthetic */ b iUr;
        final /* synthetic */ double iUs;

        public AnonymousClass3(b bVar, double d) {
            this.iUr = bVar;
            this.iUs = d;
        }

        public final void run() {
            v.i("MicroMsg.SightPlayController", "SeekToFrame   %f  %s", Double.valueOf(this.iUs), be.bur().toString());
            this.iUr.iUk = this.iUs;
        }
    }

    private class b implements Runnable {
        volatile boolean ecS;
        final /* synthetic */ b iUr;
        c iUw;

        private b(b bVar) {
            this.iUr = bVar;
            this.ecS = false;
        }

        public final void run() {
            if (!(this.iUr.iUq == null || this.iUr.iUq.aPm() == null || this.iUr.iUq.aPm().getVisibility() != 0)) {
                this.iUr.fnw.post(new Runnable(this) {
                    final /* synthetic */ b iUx;

                    {
                        this.iUx = r1;
                    }

                    public final void run() {
                        this.iUx.iUr.iUq.aPm().setVisibility(8);
                    }
                });
            }
            if (this.iUr.iTL < 0) {
                v.w("MicroMsg.SightPlayController", "#0x%x-#0x%x error video id, path %s", Integer.valueOf(this.iUr.hashCode()), Integer.valueOf(hashCode()), this.iUr.iTJ);
            } else if (this.ecS) {
                v.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop decode cmd at beg", Integer.valueOf(this.iUr.hashCode()), Integer.valueOf(hashCode()));
            } else {
                float f;
                double aPp;
                if (this.iUr.iTS == 0) {
                    if (this.iUr.iTY != null) {
                        this.iUr.iTY.type = 1;
                        this.iUr.iTY.run();
                    }
                    this.iUr.iTS = System.currentTimeMillis();
                }
                Object obj = null;
                if (this.iUr.iUk != -1.0d) {
                    if (this.iUr.iUe) {
                        if (this.iUr.iTY != null) {
                            this.iUr.iTY.type = 4;
                            this.iUr.iTY.iUk = this.iUr.iUk;
                            this.iUr.iTY.run();
                            this.iUr.fnw.postDelayed(new Runnable(this) {
                                final /* synthetic */ b iUx;

                                {
                                    this.iUx = r1;
                                }

                                public final void run() {
                                    this.iUx.iUr.iUl = true;
                                }
                            }, 100);
                        } else if (SightVideoJNI.seekStream(this.iUr.iUk, this.iUr.iTL) > 0) {
                            if (this.iUr.iTY == null) {
                                this.iUr.iTY = new i();
                            }
                            this.iUr.iTY.type = 4;
                            this.iUr.iTY.iUk = this.iUr.iUk;
                            this.iUr.iTY.run();
                            obj = 1;
                        }
                    } else if (SightVideoJNI.seekStream(this.iUr.iUk, this.iUr.iTL) > 0) {
                        if (this.iUr.iTY == null) {
                            this.iUr.iTY = new i();
                        }
                        this.iUr.iTY.type = 4;
                        this.iUr.iTY.iUk = this.iUr.iUk;
                        this.iUr.iTY.run();
                        obj = 1;
                    }
                }
                float currentTimeMillis = (float) (System.currentTimeMillis() - this.iUr.iTS);
                if (obj != null) {
                    f = 0.0f;
                } else {
                    f = (currentTimeMillis / ((float) this.iUr.iTM)) + 0.5f;
                }
                if (this.iUr.iUe && this.iUr.iUl) {
                    this.iUr.iUl = false;
                    if (this.iUr.iTY != null) {
                        aPp = this.iUr.iTY.aPp() / 1000.0d;
                        if (SightVideoJNI.seekStream(aPp, this.iUr.iTL) > 0) {
                            f = 0.0f;
                            v.i("MicroMsg.SightPlayController", "seek to " + aPp + " modify time : 0.0");
                        }
                    }
                }
                float f2 = f;
                if (this.iUr.cXI) {
                    v.i("MicroMsg.SightPlayController", "#0x%x video %d id passedTime:  %s  seek  %s", Integer.valueOf(this.iUr.hashCode()), Integer.valueOf(this.iUr.iTL), Float.valueOf(currentTimeMillis), Float.valueOf(f2));
                }
                this.iUr.iTS = System.currentTimeMillis();
                if (f2 >= 2.0f) {
                    this.iUr.iTH = this.iUr.iTH + 1;
                } else {
                    this.iUr.iTH = Math.max(0, this.iUr.iTH - 1);
                }
                if (this.iUr.aPf()) {
                    v.e("MicroMsg.SightPlayController", "match tolerate bad seek times %d", Integer.valueOf(this.iUr.iTH));
                    this.iUr.clear();
                    return;
                }
                int i;
                Object obj2 = null;
                int i2 = 0;
                if (1 == this.iUr.iTI) {
                    Object obj3;
                    if (this.iUr.huh == null || this.iUr.huh.isValid()) {
                        i2 = SightVideoJNI.drawSurfaceFrame(this.iUr.iTL, this.iUr.huh, (int) f2, this.iUr.iTO, this.iUr.gFD);
                        if (this.iUr.iUp != null) {
                            aPp = SightVideoJNI.getVideoPlayTime(this.iUr.iTL);
                            i = (int) aPp;
                            if (i != ((int) this.iUr.iUh)) {
                                this.iUr.iUp.b(this.iUr, (long) i);
                            }
                            this.iUr.iUh = aPp;
                        }
                        if (i2 == 0) {
                            this.iUr.iUk = -1.0d;
                            obj3 = null;
                        } else if (1 == i2) {
                            this.iUr.iUk = -1.0d;
                            obj3 = 1;
                            this.iUr.iTS = 0;
                            b.A(this.iUr);
                        } else if (-7 == i2) {
                            v.w("MicroMsg.SightPlayController", "surface is null, continue");
                            obj3 = null;
                        } else {
                            v.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw surface match error:%d", Integer.valueOf(this.iUr.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2));
                            this.ecS = true;
                            if (this.iUw != null) {
                                this.iUw.ecS = true;
                            }
                            this.iUr.t(null);
                            if (this.iUr.iUo != null) {
                                this.iUr.iUo.d(this.iUr, -1);
                            }
                            obj3 = null;
                        }
                    } else {
                        v.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw surface match error, surface is not valid", Integer.valueOf(this.iUr.hashCode()), Integer.valueOf(hashCode()));
                        this.ecS = true;
                        if (this.iUw != null) {
                            this.iUw.ecS = true;
                            obj3 = null;
                        }
                        obj3 = null;
                    }
                    if (this.iUr.iTY != null) {
                        v.d("MicroMsg.SightPlayController", "voice time is" + (this.iUr.iTY.aPp() / 1000.0d));
                        obj2 = obj3;
                    } else {
                        obj2 = obj3;
                    }
                } else {
                    i2 = SightVideoJNI.drawFrame(this.iUr.iTL, this.iUr.iTN, (int) f2, null, false, this.iUr.gFD);
                    if (this.iUr.iUp != null) {
                        aPp = SightVideoJNI.getVideoPlayTime(this.iUr.iTL);
                        i = (int) aPp;
                        if (i != ((int) this.iUr.iUh)) {
                            this.iUr.iUp.b(this.iUr, (long) i);
                        }
                        this.iUr.iUh = aPp;
                        if (this.iUr.cXI) {
                            v.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d  time: %f", Integer.valueOf(this.iUr.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2), Double.valueOf(aPp));
                        }
                    } else if (this.iUr.cXI) {
                        aPp = SightVideoJNI.getVideoPlayTime(this.iUr.iTL);
                        if (this.iUr.cXI) {
                            v.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d  time: %f", Integer.valueOf(this.iUr.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2), Double.valueOf(aPp));
                        }
                    } else if (this.iUr.cXI) {
                        v.i("MicroMsg.SightPlayController", "#0x%x-#0x%drawFrame ret: %d", Integer.valueOf(this.iUr.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2));
                    }
                    if (i2 == 0) {
                        this.iUr.iUk = -1.0d;
                    } else if (1 == i2) {
                        this.iUr.iUk = -1.0d;
                        obj2 = 1;
                        this.iUr.iTS = 0;
                        b.A(this.iUr);
                    } else {
                        this.iUr.iUk = -1.0d;
                        v.e("MicroMsg.SightPlayController", "#0x%x-#0x%x draw bitmap match error:%d", Integer.valueOf(this.iUr.hashCode()), Integer.valueOf(hashCode()), Integer.valueOf(i2));
                        this.ecS = true;
                        if (this.iUw != null) {
                            this.iUw.ecS = true;
                        }
                        this.iUr.fnw.post(new Runnable(this) {
                            final /* synthetic */ b iUx;

                            {
                                this.iUx = r1;
                            }

                            public final void run() {
                                this.iUx.iUr.u(null);
                            }
                        });
                        if (this.iUr.iUo != null) {
                            this.iUr.iUo.d(this.iUr, -1);
                        }
                    }
                }
                if (1 == i2) {
                    this.iUr.fnw.post(new Runnable(this) {
                        final /* synthetic */ b iUx;

                        {
                            this.iUx = r1;
                        }

                        public final void run() {
                            if (this.iUx.iUr.iUo != null) {
                                this.iUx.iUr.iUo.d(this.iUx.iUr, 0);
                            }
                        }
                    });
                }
                if (this.ecS) {
                    v.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop decode cmd at end", Integer.valueOf(this.iUr.hashCode()), Integer.valueOf(hashCode()));
                    if (this.iUr.iTY != null) {
                        this.iUr.iTY.type = 0;
                        this.iUr.iTY.run();
                        return;
                    }
                    return;
                }
                if (1 == this.iUr.iTI) {
                    long currentTimeMillis2 = ((long) this.iUr.iTM) - (System.currentTimeMillis() - this.iUr.iTS);
                    if (this.iUr.iTS == 0) {
                        com.tencent.mm.as.k.b(this, (long) (this.iUr.iTM * 5));
                    } else if (currentTimeMillis2 > 0) {
                        com.tencent.mm.as.k.b(this, currentTimeMillis2);
                    } else {
                        com.tencent.mm.as.k.b(this, 0);
                    }
                } else if (obj2 == null || this.iUr.iUq == null) {
                    this.iUw.iUy = i2;
                    this.iUr.fnw.post(this.iUw);
                } else {
                    i = this.iUr.iUq.aPl();
                    this.iUr.fnw.post(new Runnable(this) {
                        final /* synthetic */ b iUx;

                        {
                            this.iUx = r1;
                        }

                        public final void run() {
                            if (this.iUx.iUr.iUq != null) {
                                View aPm = this.iUx.iUr.iUq.aPm();
                                if (aPm != null) {
                                    if (!(this.iUx.iUr.iTV != null || this.iUx.iUr.iUq.aPn() == -1 || this.iUx.iUr.iTT.get() == null)) {
                                        this.iUx.iUr.iTV = AnimationUtils.loadAnimation(((View) this.iUx.iUr.iTT.get()).getContext(), this.iUx.iUr.iUq.aPn());
                                    }
                                    if (this.iUx.iUr.iTV != null) {
                                        aPm.startAnimation(this.iUx.iUr.iTV);
                                    }
                                    aPm.setVisibility(0);
                                }
                            }
                        }
                    });
                    this.iUw.iUy = i2;
                    this.iUr.fnw.postDelayed(this.iUw, (long) i);
                }
                if (this.iUr.iTY != null) {
                    v.d("MicroMsg.SightPlayController", "voice time is" + (this.iUr.iTY.aPp() / 1000.0d));
                }
            }
        }
    }

    private class c implements Runnable {
        volatile boolean ecS = false;
        final /* synthetic */ b iUr;
        int iUy;
        b iUz;

        public c(b bVar) {
            this.iUr = bVar;
            v.i("MicroMsg.SightPlayController", "make sure drawJob alive");
        }

        public final void run() {
            if (this.ecS) {
                v.e("MicroMsg.SightPlayController", "#0x%x-#0x%x match stop draw", Integer.valueOf(this.iUr.hashCode()), Integer.valueOf(hashCode()));
                return;
            }
            this.iUr.u(this.iUr.iTN);
            if (this.iUr.iTS == 0) {
                com.tencent.mm.as.k.b(this.iUz, 0);
                return;
            }
            long currentTimeMillis = ((long) this.iUr.iTM) - (System.currentTimeMillis() - this.iUr.iTS);
            if (currentTimeMillis > 0) {
                com.tencent.mm.as.k.b(this.iUz, currentTimeMillis);
            } else {
                com.tencent.mm.as.k.b(this.iUz, 0);
            }
        }
    }

    private class d implements Runnable {
        final /* synthetic */ b iUr;

        private d(b bVar) {
            this.iUr = bVar;
        }

        public final void run() {
            if (this.iUr.iTT.get() != null) {
                ((View) this.iUr.iTT.get()).startAnimation(this.iUr.iTU);
            }
        }
    }

    public interface e {
        void d(b bVar, int i);
    }

    public interface f {
        void b(b bVar, long j);
    }

    public interface g {
        int aPl();

        View aPm();

        int aPn();
    }

    private class h implements Runnable {
        volatile boolean ecS;
        final /* synthetic */ b iUr;

        private h(b bVar) {
            this.iUr = bVar;
            this.ecS = false;
        }

        public final void run() {
            if (this.iUr.aPf()) {
                v.e("MicroMsg.SightPlayController", "is bad fps, do nothing when open file");
                return;
            }
            this.iUr.iTL = SightVideoJNI.openFile(this.iUr.iTJ, 1 == this.iUr.iTI ? 0 : 1, 1, false);
            if (this.iUr.iTL < 0) {
                v.w("MicroMsg.SightPlayController", "#0x%x-#0x%x error video id %d, path %s", Integer.valueOf(hashCode()), Integer.valueOf(this.iUr.hashCode()), Integer.valueOf(this.iUr.iTL), this.iUr.iTJ);
                this.iUr.t(null);
                if (this.iUr.iUo != null) {
                    this.iUr.iUo.d(this.iUr, -1);
                    return;
                }
                return;
            }
            ak.yW();
            if (((Boolean) com.tencent.mm.model.c.vf().get(344065, Boolean.valueOf(false))).booleanValue()) {
                if (this.iUr.iUb == null) {
                    this.iUr.iUb = new j();
                }
                this.iUr.fnw.removeCallbacks(this.iUr.iUb);
                this.iUr.fnw.post(this.iUr.iUb);
            }
            int max = Math.max(1, SightVideoJNI.getVideoWidth(this.iUr.iTL));
            int max2 = Math.max(1, SightVideoJNI.getVideoHeight(this.iUr.iTL));
            if (this.iUr.iTI == 0) {
                if (max * max2 >= 1048576 || max <= 0 || max2 <= 0) {
                    v.e("MicroMsg.SightPlayController", "get error info videoWidth %d height  %d", Integer.valueOf(max), Integer.valueOf(max2));
                    return;
                }
                b.a(this.iUr, max, max2);
            }
            this.iUr.aPg();
            if (Float.compare(((float) max) / ((float) max2), 5.0f) > 0 || Float.compare(((float) max2) / ((float) max), 5.0f) > 0) {
                v.w("MicroMsg.SightPlayController", "ERROR Video size %d, %d", Integer.valueOf(max), Integer.valueOf(max2));
                if (!be.kS(this.iUr.iTJ)) {
                    b.iUj.put(this.iUr.iTJ, Integer.valueOf(2));
                }
                this.iUr.iTS = 0;
                this.iUr.pw(this.iUr.iTL);
                this.iUr.iTL = -1;
                this.iUr.iTJ = SQLiteDatabase.KeyEmpty;
                this.iUr.iTK = "ERROR#PATH";
                this.iUr.iTP = null;
                this.ecS = true;
                if (this.iUr.iUo != null) {
                    this.iUr.iUo.d(this.iUr, -1);
                    return;
                }
                return;
            }
            this.iUr.br(max, max2);
            if (1 == this.iUr.iTI) {
                this.iUr.iTX = new b();
                this.iUr.iTZ = null;
                if (!this.ecS) {
                    com.tencent.mm.as.k.b(this.iUr.iTX, 0);
                }
            } else {
                this.iUr.iTX = new b();
                this.iUr.iTZ = new c(this.iUr);
                this.iUr.iTX.iUw = this.iUr.iTZ;
                this.iUr.iTZ.iUz = this.iUr.iTX;
                if (!this.ecS) {
                    com.tencent.mm.as.k.b(this.iUr.iTX, 0);
                }
            }
            if (this.ecS) {
                v.e("MicroMsg.SightPlayController", "#0x%x-#0x%x open file end, match stop %B", Integer.valueOf(this.iUr.hashCode()), Integer.valueOf(hashCode()), Boolean.valueOf(this.ecS));
            }
        }
    }

    private class i implements Runnable {
        MediaPlayer iUA;
        double iUk;
        final /* synthetic */ b iUr;
        public int type;

        private i(b bVar) {
            this.iUr = bVar;
            this.iUk = -1.0d;
        }

        private void aPo() {
            v.i("MicroMsg.SightPlayController", "stopPlayer");
            try {
                if (this.iUA != null) {
                    this.iUA.stop();
                    this.iUA.release();
                    this.iUA = null;
                }
            } catch (Throwable e) {
                v.a("MicroMsg.SightPlayController", e, "stop play sound error: %s", e.getMessage());
                this.iUA = null;
            }
        }

        public final double aPp() {
            if (this.iUA == null) {
                return 0.0d;
            }
            return (double) this.iUA.getCurrentPosition();
        }

        public final void run() {
            String str;
            String str2 = "MicroMsg.SightPlayController";
            String str3 = "do play sound, operation %s";
            Object[] objArr = new Object[1];
            switch (this.type) {
                case 0:
                    str = "stop";
                    break;
                case 1:
                    str = "start";
                    break;
                case 2:
                    str = "pause";
                    break;
                case 3:
                    str = "resume";
                    break;
                case 4:
                    str = "seek";
                    break;
                default:
                    str = "unknown";
                    break;
            }
            objArr[0] = str;
            v.i(str2, str3, objArr);
            switch (this.type) {
                case 0:
                    aPo();
                    return;
                case 1:
                    aPo();
                    if (!be.kS(this.iUr.iTJ)) {
                        try {
                            this.iUA = new MediaPlayer();
                            this.iUA.setDisplay(null);
                            this.iUA.reset();
                            this.iUA.setDataSource(this.iUr.iTJ);
                            this.iUA.setAudioStreamType(3);
                            this.iUA.setOnErrorListener(new OnErrorListener(this) {
                                final /* synthetic */ i iUB;

                                {
                                    this.iUB = r1;
                                }

                                public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                                    v.e("MicroMsg.SightPlayController", "on error: play %s ERROR!! %d %d", this.iUB.iUr.iTJ, Integer.valueOf(i), Integer.valueOf(i2));
                                    this.iUB.iUr.clear();
                                    if (this.iUB.iUr.iUo != null) {
                                        this.iUB.iUr.iUo.d(this.iUB.iUr, -1);
                                    }
                                    return true;
                                }
                            });
                            this.iUA.prepare();
                            this.iUA.start();
                            return;
                        } catch (Throwable e) {
                            v.a("MicroMsg.SightPlayController", e, "play sound error: %s", e.getMessage());
                            v.e("MicroMsg.SightPlayController", "on Exception: play %s ERROR!!", this.iUr.iTJ);
                            this.iUr.clear();
                            if (this.iUr.iUo != null) {
                                this.iUr.iUo.d(this.iUr, -1);
                                return;
                            }
                            return;
                        }
                    }
                    return;
                case 2:
                    try {
                        if (this.iUA != null && this.iUA.isPlaying()) {
                            this.iUA.pause();
                            return;
                        }
                        return;
                    } catch (Throwable e2) {
                        v.a("MicroMsg.SightPlayController", e2, "pause sound error: %s", e2.getMessage());
                        aPo();
                        return;
                    }
                case 3:
                    try {
                        if (this.iUA != null) {
                            this.iUA.start();
                            return;
                        }
                        return;
                    } catch (Throwable e22) {
                        v.a("MicroMsg.SightPlayController", e22, "pause sound error: %s", e22.getMessage());
                        aPo();
                        return;
                    }
                case 4:
                    try {
                        v.i("MicroMsg.SightPlayController", "soundplayer seek %f", Double.valueOf(this.iUk));
                        this.iUA.seekTo((int) (this.iUk * 1000.0d));
                        return;
                    } catch (Throwable e222) {
                        v.a("MicroMsg.SightPlayController", e222, "seek sound error: %s", e222.getMessage());
                        return;
                    }
                default:
                    return;
            }
        }
    }

    private class j implements Runnable {
        final /* synthetic */ b iUr;

        private j(b bVar) {
            this.iUr = bVar;
        }

        public final void run() {
            if (this.iUr.iTL >= 0 && this.iUr.iTR != null && this.iUr.iTR.get() != null) {
                ((TextView) this.iUr.iTR.get()).setText(SightVideoJNI.getVideoInfo(this.iUr.iTL));
            }
        }
    }

    private class k implements Runnable {
        WeakReference<Bitmap> iUC;
        final /* synthetic */ b iUr;

        private k(b bVar) {
            this.iUr = bVar;
            this.iUC = new WeakReference(null);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            r10 = this;
            r1 = 0;
            r2 = 1;
            r3 = 0;
            r0 = r10.iUr;	 Catch:{ Exception -> 0x00df }
            r0 = r0.huh;	 Catch:{ Exception -> 0x00df }
            if (r0 == 0) goto L_0x0017;
        L_0x000b:
            r0 = r10.iUr;	 Catch:{ Exception -> 0x00df }
            r0 = r0.huh;	 Catch:{ Exception -> 0x00df }
            r0 = r0.isValid();	 Catch:{ Exception -> 0x00df }
            if (r0 != 0) goto L_0x020a;
        L_0x0017:
            r4 = "MicroMsg.SightPlayController";
            r5 = "#0x%x-#0x%x want draw thumb, but surface status error, surface null ? %B, thumb bgView null ? %B, thumb null ? %B, mask null ? %B";
            r0 = 6;
            r6 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x00df }
            r0 = 0;
            r7 = r10.iUr;	 Catch:{ Exception -> 0x00df }
            r7 = r7.hashCode();	 Catch:{ Exception -> 0x00df }
            r7 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x00df }
            r6[r0] = r7;	 Catch:{ Exception -> 0x00df }
            r0 = 1;
            r7 = r10.hashCode();	 Catch:{ Exception -> 0x00df }
            r7 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x00df }
            r6[r0] = r7;	 Catch:{ Exception -> 0x00df }
            r7 = 2;
            r0 = r10.iUr;	 Catch:{ Exception -> 0x00df }
            r0 = r0.huh;	 Catch:{ Exception -> 0x00df }
            if (r0 != 0) goto L_0x00c9;
        L_0x0041:
            r0 = r2;
        L_0x0042:
            r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ Exception -> 0x00df }
            r6[r7] = r0;	 Catch:{ Exception -> 0x00df }
            r7 = 3;
            r0 = r10.iUr;	 Catch:{ Exception -> 0x00df }
            r0 = r0.iTQ;	 Catch:{ Exception -> 0x00df }
            if (r0 != 0) goto L_0x00cc;
        L_0x0051:
            r0 = r2;
        L_0x0052:
            r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ Exception -> 0x00df }
            r6[r7] = r0;	 Catch:{ Exception -> 0x00df }
            r7 = 4;
            r0 = r10.iUC;	 Catch:{ Exception -> 0x00df }
            r0 = r0.get();	 Catch:{ Exception -> 0x00df }
            if (r0 != 0) goto L_0x00ce;
        L_0x0061:
            r0 = r2;
        L_0x0062:
            r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ Exception -> 0x00df }
            r6[r7] = r0;	 Catch:{ Exception -> 0x00df }
            r7 = 5;
            r0 = r10.iUr;	 Catch:{ Exception -> 0x00df }
            r0 = r0.iTO;	 Catch:{ Exception -> 0x00df }
            if (r0 != 0) goto L_0x00d0;
        L_0x0071:
            r0 = r2;
        L_0x0072:
            r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ Exception -> 0x00df }
            r6[r7] = r0;	 Catch:{ Exception -> 0x00df }
            com.tencent.mm.sdk.platformtools.v.w(r4, r5, r6);	 Catch:{ Exception -> 0x00df }
            r0 = r10.iUr;	 Catch:{ Exception -> 0x00df }
            r0 = r0.iTO;	 Catch:{ Exception -> 0x00df }
            if (r0 != 0) goto L_0x00ec;
        L_0x0083:
            r0 = r10.iUC;	 Catch:{ Exception -> 0x00df }
            r0 = r0.get();	 Catch:{ Exception -> 0x00df }
            r0 = (android.graphics.Bitmap) r0;	 Catch:{ Exception -> 0x00df }
            r4 = r10.iUr;	 Catch:{ Exception -> 0x00df }
            r4 = r4.iTQ;	 Catch:{ Exception -> 0x00df }
            if (r4 == 0) goto L_0x009f;
        L_0x0093:
            r1 = r10.iUr;	 Catch:{ Exception -> 0x00df }
            r1 = r1.iTQ;	 Catch:{ Exception -> 0x00df }
            r1 = r1.get();	 Catch:{ Exception -> 0x00df }
            r1 = (android.view.View) r1;	 Catch:{ Exception -> 0x00df }
        L_0x009f:
            if (r1 == 0) goto L_0x00a9;
        L_0x00a1:
            if (r0 == 0) goto L_0x00a9;
        L_0x00a3:
            r4 = r0.isRecycled();	 Catch:{ Exception -> 0x00df }
            if (r4 == 0) goto L_0x00d6;
        L_0x00a9:
            r4 = "MicroMsg.SightPlayController";
            r5 = "bgView:%B, thumb:%B";
            r6 = 2;
            r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x00df }
            r7 = 0;
            if (r1 != 0) goto L_0x00d2;
        L_0x00b5:
            r1 = r2;
        L_0x00b6:
            r1 = java.lang.Boolean.valueOf(r1);	 Catch:{ Exception -> 0x00df }
            r6[r7] = r1;	 Catch:{ Exception -> 0x00df }
            r1 = 1;
            if (r0 != 0) goto L_0x00d4;
        L_0x00bf:
            r0 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x00df }
            r6[r1] = r0;	 Catch:{ Exception -> 0x00df }
            com.tencent.mm.sdk.platformtools.v.e(r4, r5, r6);	 Catch:{ Exception -> 0x00df }
        L_0x00c8:
            return;
        L_0x00c9:
            r0 = r3;
            goto L_0x0042;
        L_0x00cc:
            r0 = r3;
            goto L_0x0052;
        L_0x00ce:
            r0 = r3;
            goto L_0x0062;
        L_0x00d0:
            r0 = r3;
            goto L_0x0072;
        L_0x00d2:
            r1 = r3;
            goto L_0x00b6;
        L_0x00d4:
            r2 = r3;
            goto L_0x00bf;
        L_0x00d6:
            r2 = new com.tencent.mm.plugin.sight.decode.a.b$k$1;	 Catch:{ Exception -> 0x00df }
            r2.<init>(r10, r1, r0);	 Catch:{ Exception -> 0x00df }
            r1.post(r2);	 Catch:{ Exception -> 0x00df }
            goto L_0x00c8;
        L_0x00df:
            r0 = move-exception;
            r1 = "MicroMsg.SightPlayController";
            r2 = "";
            r3 = new java.lang.Object[r3];
            com.tencent.mm.sdk.platformtools.v.a(r1, r0, r2, r3);
            goto L_0x00c8;
        L_0x00ec:
            r0 = r10.iUr;	 Catch:{ Exception -> 0x00df }
            r0 = r0.iTP;	 Catch:{ Exception -> 0x00df }
            if (r0 == 0) goto L_0x0120;
        L_0x00f4:
            r0 = r10.iUr;	 Catch:{ Exception -> 0x00df }
            r0 = r0.iTP;	 Catch:{ Exception -> 0x00df }
            r0 = r0.getWidth();	 Catch:{ Exception -> 0x00df }
            r4 = r10.iUr;	 Catch:{ Exception -> 0x00df }
            r4 = r4.iTO;	 Catch:{ Exception -> 0x00df }
            r4 = r4.getWidth();	 Catch:{ Exception -> 0x00df }
            if (r0 != r4) goto L_0x0120;
        L_0x010a:
            r0 = r10.iUr;	 Catch:{ Exception -> 0x00df }
            r0 = r0.iTP;	 Catch:{ Exception -> 0x00df }
            r0 = r0.getHeight();	 Catch:{ Exception -> 0x00df }
            r4 = r10.iUr;	 Catch:{ Exception -> 0x00df }
            r4 = r4.iTO;	 Catch:{ Exception -> 0x00df }
            r4 = r4.getHeight();	 Catch:{ Exception -> 0x00df }
            if (r0 == r4) goto L_0x013f;
        L_0x0120:
            r0 = r10.iUr;	 Catch:{ Exception -> 0x018a }
            r4 = r10.iUr;	 Catch:{ Exception -> 0x018a }
            r4 = r4.iTO;	 Catch:{ Exception -> 0x018a }
            r4 = r4.getWidth();	 Catch:{ Exception -> 0x018a }
            r5 = r10.iUr;	 Catch:{ Exception -> 0x018a }
            r5 = r5.iTO;	 Catch:{ Exception -> 0x018a }
            r5 = r5.getHeight();	 Catch:{ Exception -> 0x018a }
            r6 = android.graphics.Bitmap.Config.ARGB_8888;	 Catch:{ Exception -> 0x018a }
            r4 = android.graphics.Bitmap.createBitmap(r4, r5, r6);	 Catch:{ Exception -> 0x018a }
            r0.iTP = r4;	 Catch:{ Exception -> 0x018a }
        L_0x013f:
            r0 = r10.iUr;	 Catch:{ Exception -> 0x00df }
            r0 = r0.iTP;	 Catch:{ Exception -> 0x00df }
            if (r0 == 0) goto L_0x015d;
        L_0x0147:
            r0 = r10.iUC;	 Catch:{ Exception -> 0x00df }
            r0 = r0.get();	 Catch:{ Exception -> 0x00df }
            if (r0 == 0) goto L_0x015d;
        L_0x014f:
            r0 = r10.iUC;	 Catch:{ Exception -> 0x00df }
            r0 = r0.get();	 Catch:{ Exception -> 0x00df }
            r0 = (android.graphics.Bitmap) r0;	 Catch:{ Exception -> 0x00df }
            r0 = r0.isRecycled();	 Catch:{ Exception -> 0x00df }
            if (r0 == 0) goto L_0x01a9;
        L_0x015d:
            r1 = "MicroMsg.SightPlayController";
            r4 = "mThubmBgBmp:%B, thumbRef:%B";
            r0 = 2;
            r5 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x00df }
            r6 = 0;
            r0 = r10.iUr;	 Catch:{ Exception -> 0x00df }
            r0 = r0.iTP;	 Catch:{ Exception -> 0x00df }
            if (r0 != 0) goto L_0x01a5;
        L_0x016f:
            r0 = r2;
        L_0x0170:
            r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ Exception -> 0x00df }
            r5[r6] = r0;	 Catch:{ Exception -> 0x00df }
            r0 = 1;
            r6 = r10.iUC;	 Catch:{ Exception -> 0x00df }
            r6 = r6.get();	 Catch:{ Exception -> 0x00df }
            if (r6 != 0) goto L_0x01a7;
        L_0x017f:
            r2 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x00df }
            r5[r0] = r2;	 Catch:{ Exception -> 0x00df }
            com.tencent.mm.sdk.platformtools.v.e(r1, r4, r5);	 Catch:{ Exception -> 0x00df }
            goto L_0x00c8;
        L_0x018a:
            r0 = move-exception;
            r4 = "MicroMsg.SightPlayController";
            r5 = "try to create thumb bmp error:%s";
            r6 = 1;
            r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x00df }
            r7 = 0;
            r8 = r0.getMessage();	 Catch:{ Exception -> 0x00df }
            r6[r7] = r8;	 Catch:{ Exception -> 0x00df }
            com.tencent.mm.sdk.platformtools.v.a(r4, r0, r5, r6);	 Catch:{ Exception -> 0x00df }
            r0 = r10.iUr;	 Catch:{ Exception -> 0x00df }
            r4 = 0;
            r0.iTP = r4;	 Catch:{ Exception -> 0x00df }
            goto L_0x013f;
        L_0x01a5:
            r0 = r3;
            goto L_0x0170;
        L_0x01a7:
            r2 = r3;
            goto L_0x017f;
        L_0x01a9:
            r4 = java.lang.System.nanoTime();	 Catch:{ Exception -> 0x00df }
            r0 = r10.iUC;	 Catch:{ Exception -> 0x00df }
            r0 = r0.get();	 Catch:{ Exception -> 0x00df }
            r0 = (android.graphics.Bitmap) r0;	 Catch:{ Exception -> 0x00df }
            r2 = r10.iUr;	 Catch:{ Exception -> 0x00df }
            r2 = r2.iTP;	 Catch:{ Exception -> 0x00df }
            r6 = r10.iUr;	 Catch:{ Exception -> 0x00df }
            r6 = r6.iTO;	 Catch:{ Exception -> 0x00df }
            com.tencent.mm.plugin.sight.base.SightVideoJNI.handleThumb(r0, r2, r6);	 Catch:{ Exception -> 0x00df }
            r0 = "MicroMsg.SightPlayController";
            r2 = "handle thumb use %d us";
            r6 = 1;
            r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x00df }
            r7 = 0;
            r8 = java.lang.System.nanoTime();	 Catch:{ Exception -> 0x00df }
            r4 = r8 - r4;
            r8 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
            r4 = r4 / r8;
            r4 = java.lang.Long.valueOf(r4);	 Catch:{ Exception -> 0x00df }
            r6[r7] = r4;	 Catch:{ Exception -> 0x00df }
            com.tencent.mm.sdk.platformtools.v.i(r0, r2, r6);	 Catch:{ Exception -> 0x00df }
            r0 = r10.iUr;	 Catch:{ Exception -> 0x00df }
            r2 = r0.iTP;	 Catch:{ Exception -> 0x00df }
            r0 = r10.iUr;	 Catch:{ Exception -> 0x00df }
            r0 = r0.iTQ;	 Catch:{ Exception -> 0x00df }
            if (r0 == 0) goto L_0x0208;
        L_0x01ee:
            r0 = r10.iUr;	 Catch:{ Exception -> 0x00df }
            r0 = r0.iTQ;	 Catch:{ Exception -> 0x00df }
            r0 = r0.get();	 Catch:{ Exception -> 0x00df }
            r0 = (android.view.View) r0;	 Catch:{ Exception -> 0x00df }
        L_0x01fa:
            if (r0 == 0) goto L_0x00c8;
        L_0x01fc:
            if (r2 == 0) goto L_0x00c8;
        L_0x01fe:
            r1 = new com.tencent.mm.plugin.sight.decode.a.b$k$2;	 Catch:{ Exception -> 0x00df }
            r1.<init>(r10, r0, r2);	 Catch:{ Exception -> 0x00df }
            r0.post(r1);	 Catch:{ Exception -> 0x00df }
            goto L_0x00c8;
        L_0x0208:
            r0 = r1;
            goto L_0x01fa;
        L_0x020a:
            r1 = "MicroMsg.SightPlayController";
            r4 = "#0x%x-#0x%x draw thumb, thumb empty ? %B";
            r0 = 3;
            r5 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x00df }
            r0 = 0;
            r6 = r10.iUr;	 Catch:{ Exception -> 0x00df }
            r6 = r6.hashCode();	 Catch:{ Exception -> 0x00df }
            r6 = java.lang.Integer.valueOf(r6);	 Catch:{ Exception -> 0x00df }
            r5[r0] = r6;	 Catch:{ Exception -> 0x00df }
            r0 = 1;
            r6 = r10.hashCode();	 Catch:{ Exception -> 0x00df }
            r6 = java.lang.Integer.valueOf(r6);	 Catch:{ Exception -> 0x00df }
            r5[r0] = r6;	 Catch:{ Exception -> 0x00df }
            r6 = 2;
            r0 = r10.iUC;	 Catch:{ Exception -> 0x00df }
            r0 = r0.get();	 Catch:{ Exception -> 0x00df }
            if (r0 != 0) goto L_0x0270;
        L_0x0234:
            r0 = r2;
        L_0x0235:
            r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ Exception -> 0x00df }
            r5[r6] = r0;	 Catch:{ Exception -> 0x00df }
            com.tencent.mm.sdk.platformtools.v.d(r1, r4, r5);	 Catch:{ Exception -> 0x00df }
            r0 = r10.iUr;	 Catch:{ Exception -> 0x00df }
            r0 = r0.iTQ;	 Catch:{ Exception -> 0x00df }
            if (r0 == 0) goto L_0x025c;
        L_0x0246:
            r0 = r10.iUr;	 Catch:{ Exception -> 0x00df }
            r0 = r0.iTQ;	 Catch:{ Exception -> 0x00df }
            r0 = r0.get();	 Catch:{ Exception -> 0x00df }
            r0 = (android.view.View) r0;	 Catch:{ Exception -> 0x00df }
            if (r0 == 0) goto L_0x025c;
        L_0x0254:
            r1 = new com.tencent.mm.plugin.sight.decode.a.b$k$3;	 Catch:{ Exception -> 0x00df }
            r1.<init>(r10, r0);	 Catch:{ Exception -> 0x00df }
            r0.post(r1);	 Catch:{ Exception -> 0x00df }
        L_0x025c:
            r0 = r10.iUC;	 Catch:{ Exception -> 0x00df }
            r0 = r0.get();	 Catch:{ Exception -> 0x00df }
            if (r0 != 0) goto L_0x0272;
        L_0x0264:
            r0 = r10.iUr;	 Catch:{ Exception -> 0x00df }
            r0 = r0.huh;	 Catch:{ Exception -> 0x00df }
            r1 = 0;
            com.tencent.mm.plugin.sight.base.SightVideoJNI.drawSurfaceColor(r0, r1);	 Catch:{ Exception -> 0x00df }
            goto L_0x00c8;
        L_0x0270:
            r0 = r3;
            goto L_0x0235;
        L_0x0272:
            r0 = r10.iUr;	 Catch:{ Exception -> 0x00df }
            r1 = r0.huh;	 Catch:{ Exception -> 0x00df }
            r0 = r10.iUC;	 Catch:{ Exception -> 0x00df }
            r0 = r0.get();	 Catch:{ Exception -> 0x00df }
            r0 = (android.graphics.Bitmap) r0;	 Catch:{ Exception -> 0x00df }
            r2 = r10.iUr;	 Catch:{ Exception -> 0x00df }
            r2 = r2.iTO;	 Catch:{ Exception -> 0x00df }
            com.tencent.mm.plugin.sight.base.SightVideoJNI.drawSurfaceThumb(r1, r0, r2);	 Catch:{ Exception -> 0x00df }
            goto L_0x00c8;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sight.decode.a.b.k.run():void");
        }
    }

    private static class a extends com.tencent.mm.sdk.c.c<pn> {
        int fNz = 0;
        int iUt = 0;
        int iUu = 0;
        WeakReference<b> iUv;

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b r9) {
            /*
            r8 = this;
            r7 = 2;
            r6 = 1;
            r5 = 0;
            r9 = (com.tencent.mm.e.a.pn) r9;
            r0 = r8.iUv;
            r0 = r0.get();
            if (r0 == 0) goto L_0x0082;
        L_0x000d:
            r1 = "MicroMsg.SightPlayController";
            r2 = "#0x%x on chatting status callback, type %d, selfPos %d, visiblePos[%d, %d], headerCount %d recording %B";
            r0 = 7;
            r3 = new java.lang.Object[r0];
            r0 = r8.iUv;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r0 = r0.hashCode();
            r0 = java.lang.Integer.valueOf(r0);
            r3[r5] = r0;
            r0 = r9.bqP;
            r0 = r0.type;
            r0 = java.lang.Integer.valueOf(r0);
            r3[r6] = r0;
            r0 = r8.iUv;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r0 = r0.position;
            r0 = java.lang.Integer.valueOf(r0);
            r3[r7] = r0;
            r0 = 3;
            r4 = r9.bqP;
            r4 = r4.bqQ;
            r4 = java.lang.Integer.valueOf(r4);
            r3[r0] = r4;
            r0 = 4;
            r4 = r9.bqP;
            r4 = r4.bqR;
            r4 = java.lang.Integer.valueOf(r4);
            r3[r0] = r4;
            r0 = 5;
            r4 = r9.bqP;
            r4 = r4.bqS;
            r4 = java.lang.Integer.valueOf(r4);
            r3[r0] = r4;
            r4 = 6;
            r0 = r8.iUv;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r0 = r0.iUm;
            r0 = java.lang.Boolean.valueOf(r0);
            r3[r4] = r0;
            com.tencent.mm.sdk.platformtools.v.d(r1, r2, r3);
            r0 = r9.bqP;
            r0 = r0.type;
            switch(r0) {
                case 0: goto L_0x00bf;
                case 1: goto L_0x009a;
                case 2: goto L_0x0082;
                case 3: goto L_0x0083;
                case 4: goto L_0x0082;
                case 5: goto L_0x00e2;
                case 6: goto L_0x008f;
                case 7: goto L_0x00a6;
                default: goto L_0x0082;
            };
        L_0x0082:
            return r5;
        L_0x0083:
            r0 = r8.iUv;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r0.clear();
            goto L_0x0082;
        L_0x008f:
            r0 = r8.iUv;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r0.iUm = r6;
        L_0x009a:
            r0 = r8.iUv;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r0.fz(r5);
            goto L_0x0082;
        L_0x00a6:
            r0 = r8.iUv;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r0 = r0.iUm;
            if (r0 == 0) goto L_0x0082;
        L_0x00b4:
            r0 = r8.iUv;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r0.iUm = r5;
        L_0x00bf:
            r8.a(r9);
            r0 = r8.aPk();
            if (r0 == 0) goto L_0x0082;
        L_0x00c8:
            r0 = r8.iUv;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r0 = r0.iUm;
            if (r0 != 0) goto L_0x0082;
        L_0x00d6:
            r0 = r8.iUv;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r0.restart();
            goto L_0x0082;
        L_0x00e2:
            r8.a(r9);
            r0 = r8.aPk();
            if (r0 == 0) goto L_0x01a4;
        L_0x00eb:
            r0 = r8.iUv;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r0 = r0.iUm;
            if (r0 != 0) goto L_0x01a4;
        L_0x00f9:
            r1 = "ERROR#PATH";
            r0 = r8.iUv;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r0 = r0.iTK;
            r0 = r1.equals(r0);
            if (r0 != 0) goto L_0x0189;
        L_0x010e:
            r0 = r8.iUv;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r1 = r0.iTJ;
            r0 = r8.iUv;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r0 = r0.iTK;
            r0 = r1.equals(r0);
            if (r0 != 0) goto L_0x0189;
        L_0x012c:
            r1 = "MicroMsg.SightPlayController";
            r2 = "match diff path, change %s to %s";
            r3 = new java.lang.Object[r7];
            r0 = r8.iUv;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r0 = r0.iTJ;
            r3[r5] = r0;
            r0 = r8.iUv;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r0 = r0.iTK;
            r3[r6] = r0;
            com.tencent.mm.sdk.platformtools.v.d(r1, r2, r3);
            r0 = r8.iUv;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r0 = r0.iTK;
            if (r0 != 0) goto L_0x0196;
        L_0x0161:
            r0 = "";
            r1 = r0;
        L_0x0165:
            r0 = r8.iUv;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r0.clear();
            r0 = r8.iUv;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r0.iTJ = r1;
            r0 = r8.iUv;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r1 = "ERROR#PATH";
            r0.iTK = r1;
        L_0x0189:
            r0 = r8.iUv;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r0.restart();
            goto L_0x0082;
        L_0x0196:
            r0 = r8.iUv;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r0 = r0.iTK;
            r1 = r0;
            goto L_0x0165;
        L_0x01a4:
            r0 = r8.iUv;
            r0 = r0.get();
            r0 = (com.tencent.mm.plugin.sight.decode.a.b) r0;
            r0.clear();
            goto L_0x0082;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sight.decode.a.b.a.a(com.tencent.mm.sdk.c.b):boolean");
        }

        public a(b bVar) {
            super(0);
            this.iUv = new WeakReference(bVar);
            this.nhz = pn.class.getName().hashCode();
        }

        private void a(pn pnVar) {
            this.iUt = pnVar.bqP.bqS;
            this.iUu = pnVar.bqP.bqQ;
            this.fNz = pnVar.bqP.bqR;
        }

        private boolean aPk() {
            if (this.iUv.get() == null) {
                return false;
            }
            int D = ((b) this.iUv.get()).position + this.iUt;
            if (D < this.iUu || D > this.fNz) {
                return false;
            }
            return true;
        }
    }

    public abstract void br(int i, int i2);

    public abstract void u(Bitmap bitmap);

    static /* synthetic */ void A(b bVar) {
        if (bVar.iTT != null && -1 != bVar.aPd()) {
            if (bVar.iTU == null && bVar.iTT.get() != null) {
                bVar.iTU = AnimationUtils.loadAnimation(((View) bVar.iTT.get()).getContext(), bVar.aPd());
            }
            if (bVar.iUc == null) {
                bVar.iUc = new d();
            }
            bVar.fnw.post(bVar.iUc);
        }
    }

    static /* synthetic */ void a(b bVar, int i, int i2) {
        v.d("MicroMsg.SightPlayController", "#0x%x check bmp, video width %d, height %d", Integer.valueOf(bVar.hashCode()), Integer.valueOf(i), Integer.valueOf(i2));
        if (bVar.iTN == null) {
            bVar.iTN = o.cnL.a(new com.tencent.mm.memory.o.b(i, i2));
            v.h("MicroMsg.SightPlayController", "checkBmp, create new one, videoPath: %s", bVar.iTJ);
        } else if (bVar.iTN.getWidth() != i || bVar.iTN.getHeight() != i2) {
            int i3;
            v.w("MicroMsg.SightPlayController", "reset bmp, old value " + bVar.iTN.getWidth() + "*" + bVar.iTN.getHeight());
            if (!com.tencent.mm.compatible.util.d.dW(19) || bVar.iTN.getAllocationByteCount() < (i2 * i) * 4) {
                i3 = 0;
            } else {
                try {
                    v.w("MicroMsg.SightPlayController", "reset bmp, try directly reconfigure");
                    bVar.iTN.reconfigure(i, i2, Config.ARGB_8888);
                    i3 = 1;
                } catch (Exception e) {
                    v.e("MicroMsg.SightPlayController", "reconfigure failed: %s" + e.getMessage());
                    i3 = 0;
                }
            }
            if (i3 == 0) {
                o.cnL.d(bVar.iTN);
                bVar.iTN = o.cnL.a(new com.tencent.mm.memory.o.b(i, i2));
            }
            v.h("MicroMsg.SightPlayController", "checkBmp, the origin bmp size not match, create new one, videoPath: %s", bVar.iTJ);
        }
    }

    public static Bitmap a(Context context, int i, int i2, int i3, int i4) {
        String format = String.format("%s-%s-%s-%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        WeakReference weakReference = (WeakReference) iUf.get(format);
        if (weakReference != null && weakReference.get() != null) {
            return (Bitmap) weakReference.get();
        }
        if (context == null) {
            v.w("MicroMsg.SightPlayController", "get mask bmp, but context is null");
            return null;
        } else if (i <= 0) {
            v.w("MicroMsg.SightPlayController", "get mask bmp, but mask id error");
            return null;
        } else if (i2 <= 0 || i4 <= 0 || i3 <= 0) {
            v.w("MicroMsg.SightPlayController", "get mask bmp, but size error");
            return null;
        } else {
            long Nj = be.Nj();
            int i5 = (i2 * i4) / i3;
            NinePatchDrawable ninePatchDrawable = (NinePatchDrawable) context.getResources().getDrawable(i);
            ninePatchDrawable.setBounds(0, 0, i2, i5);
            Bitmap createBitmap = Bitmap.createBitmap(i2, i5, Config.ARGB_8888);
            ninePatchDrawable.draw(new Canvas(createBitmap));
            iUf.put(format, new WeakReference(createBitmap));
            v.d("MicroMsg.SightPlayController", "create mask bmp use %dms", Long.valueOf(be.az(Nj)));
            return createBitmap;
        }
    }

    public static void wc() {
        com.tencent.mm.as.k.b(new Runnable() {
            public final void run() {
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    SightVideoJNI.freeAll();
                } catch (Throwable e) {
                    v.e("MicroMsg.SightPlayController", "free all sight error");
                    v.a("MicroMsg.SightPlayController", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                }
                v.i("MicroMsg.SightPlayController", "free all, use %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            }
        }, 0);
    }

    public b(int i, View view) {
        this.iTI = i;
        this.fnw = new ac(Looper.getMainLooper());
        this.iTT = new WeakReference(view);
        v.i("MicroMsg.SightPlayController", "new SightPlayController, drawType %d", Integer.valueOf(i));
    }

    public int aPd() {
        return -1;
    }

    public final void fz(boolean z) {
        if (this.iTW != null) {
            com.tencent.mm.as.k.e(this.iTW);
            this.iTW.ecS = true;
        }
        if (this.iTZ != null) {
            this.fnw.removeCallbacks(this.iTZ);
            this.iTZ.ecS = true;
        }
        if (this.iTX != null) {
            com.tencent.mm.as.k.e(this.iTX);
            this.iTX.ecS = true;
        }
        if (this.iTY != null) {
            this.iTY.type = z ? 0 : 2;
            com.tencent.mm.as.k.b(this.iTY, 0);
        }
    }

    public final boolean aPe() {
        if (1 == this.iTI) {
            if (this.iTX == null || this.iTX.ecS) {
                return false;
            }
            return true;
        } else if (this.iTZ == null || this.iTZ.ecS || this.iTX == null || this.iTX.ecS) {
            return false;
        } else {
            return true;
        }
    }

    public final void restart() {
        v.i("MicroMsg.SightPlayController", "#0x%x restart, canPlay %B, videoPath %s, videoId %d", Integer.valueOf(hashCode()), Boolean.valueOf(this.iUd), this.iTJ, Integer.valueOf(this.iTL));
        if (!this.iUd) {
            clear();
        } else if (aPe()) {
            v.w("MicroMsg.SightPlayController", "#0x%x is runing, do nothing when restart request asked, videoPath %s", Integer.valueOf(hashCode()), this.iTJ);
        } else {
            boolean z;
            if (this.iTL < 0) {
                z = true;
            } else {
                z = false;
            }
            fz(z);
            this.iTS = 0;
            if (aPf()) {
                v.e("MicroMsg.SightPlayController", "#0x%x is bad fps, do nothing when restart", Integer.valueOf(hashCode()));
            } else if (this.iTL < 0) {
                v.w("MicroMsg.SightPlayController", "#0x%x restart match error video id, try reopen video, videoPath %s", Integer.valueOf(hashCode()), this.iTJ);
                if (!be.kS(this.iTJ)) {
                    if (zE(this.iTJ)) {
                        this.iTW = new h();
                        com.tencent.mm.as.k.b(this.iTW, 0);
                        return;
                    }
                    v.w("MicroMsg.SightPlayController", "Check Sight Fail!!! return");
                    clear();
                }
            } else if (1 == this.iTI) {
                this.iTX = new b();
                this.iTZ = null;
                com.tencent.mm.as.k.b(this.iTX, 0);
            } else {
                this.iTX = new b();
                this.iTZ = new c(this);
                this.iTX.iUw = this.iTZ;
                this.iTZ.iUz = this.iTX;
                com.tencent.mm.as.k.b(this.iTX, 0);
            }
        }
    }

    public final void clear() {
        v.i("MicroMsg.SightPlayController", "#0x%x do clear, remove render job, video id %d, runing %B", Integer.valueOf(hashCode()), Integer.valueOf(this.iTL), Boolean.valueOf(aPe()));
        fz(true);
        this.iTS = 0;
        pw(this.iTL);
        this.iTL = -1;
        this.iTJ = SQLiteDatabase.KeyEmpty;
        this.iTK = "ERROR#PATH";
        this.iTP = null;
        this.iUh = 0.0d;
        this.iUi = false;
        o.cnL.d(this.iTN);
        this.iTN = null;
    }

    private void pw(final int i) {
        com.tencent.mm.as.k.b(new Runnable(this) {
            final /* synthetic */ b iUr;

            public final void run() {
                long currentTimeMillis = System.currentTimeMillis();
                SightVideoJNI.freeObj(i);
                v.d("MicroMsg.SightPlayController", "#0x%x tick: do clear video %d, use %d ms", Integer.valueOf(this.iUr.hashCode()), Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            }
        }, 0);
    }

    public final void ag(String str, boolean z) {
        v.i("MicroMsg.SightPlayController", "#0x%x data: set video[%s], old path[%s], fling[%B], last video id %d, recording %B, canPlay %B", Integer.valueOf(hashCode()), str, this.iTJ, Boolean.valueOf(z), Integer.valueOf(this.iTL), Boolean.valueOf(this.iUm), Boolean.valueOf(this.iUd));
        if (this.iUm) {
            fz(false);
        } else if (aPf()) {
            v.e("MicroMsg.SightPlayController", "is bad fps, do nothing when set video path");
            clear();
        } else if (!this.iUd) {
            clear();
        } else if (z) {
            this.iTK = str;
            fz(false);
        } else if (this.iTJ.equals(str)) {
            this.iTK = "ERROR#PATH";
            fz(false);
            restart();
        } else {
            clear();
            if (str == null) {
                str = SQLiteDatabase.KeyEmpty;
            }
            this.iTJ = str;
            if (be.kS(this.iTJ)) {
                v.w("MicroMsg.SightPlayController", "empty video path, do draw empty thumb and return");
                t(null);
            } else if (zE(this.iTJ)) {
                this.iTW = new h();
                com.tencent.mm.as.k.b(this.iTW, 0);
            } else {
                v.w("MicroMsg.SightPlayController", "Check Sight Fail!!! return");
                clear();
            }
        }
    }

    public static boolean zE(String str) {
        if (be.kS(str)) {
            return false;
        }
        Integer num = (Integer) iUj.get(str);
        if (num == null || 2 != num.intValue()) {
            return true;
        }
        return false;
    }

    public final boolean aPf() {
        if (this.iUg) {
            return false;
        }
        if (VERSION.SDK_INT >= 11) {
            if (this.iTH < 3) {
                return false;
            }
            v.v("MicroMsg.SightPlayController", "match not check bad fps, but now is bad fps");
            this.iTH = 0;
            return false;
        } else if (this.iTH >= 3) {
            return true;
        } else {
            return false;
        }
    }

    protected final void aPg() {
        this.iTM = 1000 / Math.max(1, (int) SightVideoJNI.getVideoRate(this.iTL));
        v.d("MicroMsg.SightPlayController", "#0x%x update video rate to %d fps, delay %d ms", Integer.valueOf(hashCode()), Integer.valueOf(r0), Integer.valueOf(this.iTM));
    }

    public final void b(Surface surface) {
        v.v("MicroMsg.SightPlayController", "set play surface %s", surface);
        this.huh = surface;
        com.tencent.mm.as.k.b(this.iUa, 0);
    }

    public final void g(TextView textView) {
        this.iTR = new WeakReference(textView);
    }

    public final void t(Bitmap bitmap) {
        boolean z = true;
        String str = "MicroMsg.SightPlayController";
        String str2 = "draw surface thumb, thumb is null ? %B";
        Object[] objArr = new Object[1];
        if (bitmap != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        v.v(str, str2, objArr);
        com.tencent.mm.as.k.e(this.iUa);
        if (this.iUa == null) {
            this.iUa = new k();
        }
        this.iUa.iUC = new WeakReference(bitmap);
        com.tencent.mm.as.k.b(this.iUa, 0);
    }

    public final com.tencent.mm.sdk.c.c aPh() {
        if (this.iUn == null) {
            this.iUn = new a(this);
        }
        return this.iUn;
    }

    public final double aPi() {
        if (this.iTL == -1) {
            return 0.0d;
        }
        return SightVideoJNI.getVideoDuration(this.iTL);
    }
}
