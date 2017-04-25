package com.tencent.mm.c.a;

import android.content.Context;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvoice.d;
import com.tencent.mm.modelvoice.i;
import com.tencent.mm.modelvoice.j;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.g;
import com.tencent.mm.v.g.b;
import junit.framework.Assert;

public final class a implements com.tencent.mm.compatible.b.d.a, g {
    private d aTd;
    boolean aTe;
    private boolean aTf;
    private int aTg;
    private boolean aTh;
    boolean aTi;
    public b aTj;
    public com.tencent.mm.v.g.a aTk;
    Context context;

    public a(Context context) {
        this(context, 0);
    }

    public a(Context context, int i) {
        this.aTd = null;
        this.context = null;
        this.aTe = false;
        this.aTf = false;
        this.aTg = 0;
        this.aTh = false;
        this.aTi = false;
        this.aTj = null;
        this.context = context;
        this.aTg = i;
        com.tencent.mm.c.b.g.b bVar = new com.tencent.mm.c.b.g.b();
    }

    public final boolean isPlaying() {
        if (this.aTd == null) {
            return false;
        }
        return this.aTd.isPlaying();
    }

    public final boolean a(String str, boolean z, boolean z2, int i) {
        v.i("MicroMsg.SceneVoicePlayer", "start file name:[%s] speakerOn:[%b], isFullPath: %s, type: %s, userType: %s", str, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(this.aTg));
        ak.yX().a((com.tencent.mm.compatible.b.d.a) this);
        ak.yX().qS();
        this.aTi = true;
        Assert.assertTrue(str.length() > 0);
        String str2;
        if (FileOp.aR(z2 ? str : q.iU(str))) {
            if (i == -1) {
                i = o.e(str, this.aTg, z2);
            }
            if (i == 0) {
                if (this.context != null) {
                    this.aTd = new s(this.context);
                } else {
                    this.aTd = new s();
                }
            } else if (i == 1) {
                if (this.context != null) {
                    this.aTd = new j(this.context);
                } else {
                    this.aTd = new j();
                }
            } else if (i == 2) {
                if (this.context != null) {
                    this.aTd = new i(this.context);
                } else {
                    this.aTd = new i();
                }
            }
            this.aTe = z;
            this.aTh = z;
            if (ak.yX().ra() || ak.yX().qU()) {
                v.i("MicroMsg.SceneVoicePlayer", "headset plugged: %b, bluetoothon: %b", Boolean.valueOf(ak.yX().ra()), Boolean.valueOf(ak.yX().qU()));
                this.aTe = false;
            }
            ak.yX().d(this.aTe, false);
            oX();
            setError();
            str2 = null;
            if (z2) {
                str2 = str;
            } else if (this.aTg == 0) {
                str2 = q.iU(str);
            }
            if (this.aTd.E(str2, this.aTe)) {
                return true;
            }
            v.i("MicroMsg.SceneVoicePlayer", "start play error fileName[" + str + "], [" + z + "]");
            return false;
        }
        str2 = "MicroMsg.SceneVoicePlayer";
        String str3 = "start, file %s not exist!, fullPath: %s";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        if (!z2) {
            str = q.iU(str);
        }
        objArr[1] = str;
        v.e(str2, str3, objArr);
        return false;
    }

    public final boolean a(String str, boolean z, int i, int i2) {
        v.i("MicroMsg.SceneVoicePlayer", "start file name:[%s] speakerOn:[%b], isFullPath: %s, type: %s, userType: %s", str, Boolean.valueOf(z), Boolean.valueOf(true), Integer.valueOf(i), Integer.valueOf(this.aTg));
        ak.yX().a((com.tencent.mm.compatible.b.d.a) this);
        ak.yX().qS();
        Assert.assertTrue(str.length() > 0);
        if (FileOp.aR(str)) {
            if (i == -1) {
                i = o.e(str, this.aTg, true);
            }
            if (i == 0) {
                if (this.context != null) {
                    this.aTd = new s(this.context);
                } else {
                    this.aTd = new s();
                }
            } else if (i == 1) {
                if (this.context != null) {
                    this.aTd = new j(this.context);
                } else {
                    this.aTd = new j();
                }
            } else if (i == 2) {
                if (this.context != null) {
                    this.aTd = new i(this.context);
                } else {
                    this.aTd = new i();
                }
            }
            this.aTe = z;
            this.aTh = z;
            if (ak.yX().ra() || ak.yX().qU()) {
                v.i("MicroMsg.SceneVoicePlayer", "headset plugged: %b, bluetoothon: %b", Boolean.valueOf(ak.yX().ra()), Boolean.valueOf(ak.yX().qU()));
                this.aTe = false;
            }
            ak.yX().d(this.aTe, false);
            oX();
            setError();
            if (this.aTd.c(str, z, i2)) {
                return true;
            }
            v.i("MicroMsg.SceneVoicePlayer", "start play fileName[" + str + "], [" + z + "]");
            return false;
        }
        v.e("MicroMsg.SceneVoicePlayer", "start, file %s not exist!, fullPath: %s", str, str);
        return false;
    }

    public final boolean pause() {
        if (this.aTd == null) {
            return false;
        }
        boolean pause;
        v.i("MicroMsg.SceneVoicePlayer", "pause");
        if (this.aTd.isPlaying()) {
            pause = this.aTd.pause();
        } else {
            pause = false;
        }
        if (this.aTi) {
            ak.yX().qT();
            this.aTi = false;
        }
        ak.yX().setMode(0);
        return pause;
    }

    public final boolean oV() {
        if (this.aTd == null) {
            return false;
        }
        v.i("MicroMsg.SceneVoicePlayer", "resume");
        ak.yX().qS();
        this.aTi = true;
        if (ak.yX().qU()) {
            this.aTe = false;
        }
        ak.yX().d(this.aTe, false);
        return this.aTd.oV();
    }

    public final boolean h(String str, boolean z) {
        return a(str, z, false, -1);
    }

    public final boolean oW() {
        return this.aTf;
    }

    public final void stop() {
        if (this.aTd != null) {
            v.i("MicroMsg.SceneVoicePlayer", "stop, isRequestStartBluetooth: %b, player.isPlaying: %b", Boolean.valueOf(this.aTi), Boolean.valueOf(this.aTd.isPlaying()));
            this.aTd.ph();
            ak.yX().b((com.tencent.mm.compatible.b.d.a) this);
            if (this.aTi) {
                ak.yX().qT();
            }
            this.aTi = false;
            ak.yX().setMode(0);
        }
    }

    public final void ak(boolean z) {
        if (this.aTe != z) {
            this.aTe = z;
            if (this.aTd != null && this.aTd.isPlaying()) {
                this.aTd.ak(z);
            }
            ak.yX().d(z, false);
        }
    }

    public final void a(b bVar) {
        this.aTj = bVar;
    }

    private void setError() {
        d.b anonymousClass1 = new d.b(this) {
            final /* synthetic */ a aTl;

            {
                this.aTl = r1;
            }

            public final void onError() {
                ak.yX().b(this.aTl);
                if (this.aTl.aTi) {
                    ak.yX().qT();
                    this.aTl.aTi = false;
                }
                ak.yX().setMode(0);
                if (this.aTl.aTj != null) {
                    ad.o(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 aTm;

                        {
                            this.aTm = r1;
                        }

                        public final void run() {
                            this.aTm.aTl.aTj.onError();
                        }
                    });
                }
            }
        };
        if (this.aTd != null) {
            this.aTd.a(anonymousClass1);
        }
    }

    public final void a(com.tencent.mm.v.g.a aVar) {
        this.aTk = aVar;
    }

    private void oX() {
        com.tencent.mm.modelvoice.d.a anonymousClass2 = new com.tencent.mm.modelvoice.d.a(this) {
            final /* synthetic */ a aTl;

            {
                this.aTl = r1;
            }

            public final void pa() {
                e.a(new Runnable(this) {
                    final /* synthetic */ AnonymousClass2 aTn;

                    {
                        this.aTn = r1;
                    }

                    public final void run() {
                        try {
                            if (p.ceB.cbA == 1) {
                                Thread.sleep(300);
                            }
                            v.i("MicroMsg.SceneVoicePlayer", "onCompletion, intOnCompletion: %s", this.aTn.aTl.aTk);
                            ad.o(new Runnable(this) {
                                final /* synthetic */ AnonymousClass1 aTo;

                                {
                                    this.aTo = r1;
                                }

                                public final void run() {
                                    b bVar;
                                    ak.yX().d(this.aTo.aTn.aTl.aTe, false);
                                    Context context = this.aTo.aTn.aTl.context;
                                    boolean z = this.aTo.aTn.aTl.aTe;
                                    com.tencent.mm.sdk.platformtools.ao.a anonymousClass1 = new com.tencent.mm.sdk.platformtools.ao.a(this) {
                                        final /* synthetic */ AnonymousClass1 aTp;

                                        {
                                            this.aTp = r1;
                                        }

                                        public final void pa() {
                                            v.i("MicroMsg.SceneVoicePlayer", "play sound end onCompletion");
                                            if (!this.aTp.aTo.aTn.aTl.isPlaying()) {
                                                ak.yX().b(this.aTp.aTo.aTn.aTl);
                                                ak.yX().qT();
                                                this.aTp.aTo.aTn.aTl.aTi = false;
                                                ak.yX().setMode(0);
                                                v.i("MicroMsg.SceneVoicePlayer", "onCompletion() resetSpeaker");
                                            }
                                        }
                                    };
                                    if (z) {
                                        bVar = b.ON;
                                    } else {
                                        bVar = b.OFF;
                                    }
                                    ao.a(context, 2131234178, bVar, false, anonymousClass1);
                                    if (this.aTo.aTn.aTl.aTk != null) {
                                        v.i("MicroMsg.SceneVoicePlayer", "intOnCompletion onCompletion()");
                                        this.aTo.aTn.aTl.aTk.pa();
                                        return;
                                    }
                                    v.e("MicroMsg.SceneVoicePlayer", "intOnCompletion is null!!!");
                                }
                            });
                        } catch (Throwable e) {
                            v.e("MicroMsg.SceneVoicePlayer", "exception:%s", be.e(e));
                        }
                    }
                }, "SceneVoice_onCompletion");
            }
        };
        if (this.aTd != null) {
            this.aTd.a(anonymousClass2);
        }
    }

    public final double oY() {
        if (this.aTd == null) {
            return 0.0d;
        }
        return this.aTd.oY();
    }

    public final boolean oZ() {
        if (this.aTd != null && this.aTd.getStatus() == 2) {
            return true;
        }
        return false;
    }

    public final void cK(int i) {
        v.i("MicroMsg.SceneVoicePlayer", "onBluetoothHeadsetStateChange, status: %d, currentSpeaker: %b, bluetoothResumeSpeaker: %b, isRequestStartBluetooth: %b", Integer.valueOf(i), Boolean.valueOf(this.aTe), Boolean.valueOf(this.aTh), Boolean.valueOf(this.aTi));
        switch (i) {
            case 1:
                ak(false);
                return;
            case 2:
                ak(this.aTh);
                if (this.aTi) {
                    ak.yX().qT();
                    this.aTi = false;
                }
                ak.yX().b((com.tencent.mm.compatible.b.d.a) this);
                return;
            default:
                return;
        }
    }
}
