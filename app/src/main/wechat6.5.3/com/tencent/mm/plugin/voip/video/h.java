package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.net.Uri;
import android.os.Looper;
import android.os.Vibrator;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class h {
    public boolean aYi = false;
    private AudioManager cfZ;
    ac cnC = new ac(Looper.getMainLooper());
    private b djL;
    private Vibrator eWH;
    public MediaPlayer kBT;
    public int kBU = 0;
    public long kBV;
    public long kBW;
    a kBX;
    public Context mContext;

    private class a implements Runnable {
        final /* synthetic */ h kBY;
        private int kCd;
        private long kCe;
        private boolean kCf;
        private int streamType;

        public a(h hVar, int i, long j, boolean z, int i2) {
            this.kBY = hVar;
            this.kCd = i;
            this.kCe = j;
            this.kCf = z;
            this.streamType = i2;
        }

        public final void run() {
            this.kBY.a(this.kCd, this.kCe, this.kCf, this.streamType);
        }
    }

    public h(Context context) {
        this.mContext = context;
        if (this.mContext != null) {
            this.cfZ = ak.yX().cba;
            if (this.cfZ == null) {
                this.cfZ = (AudioManager) this.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
            }
            this.eWH = (Vibrator) this.mContext.getSystemService("vibrator");
        }
        this.djL = new b(aa.getContext());
    }

    public final void gY(boolean z) {
        int i = 0;
        v.i("MicroMsg.RingPlayer", "setSpeakerStatus, isSpeakerOn: %b", new Object[]{Boolean.valueOf(z)});
        if (!z) {
            if (d.dW(21)) {
                i = 3;
            } else {
                i = 2;
            }
        }
        if (z && p.ceB.cbZ >= 0) {
            i = p.ceB.cbZ;
        } else if (!z && p.ceB.cbX >= 0) {
            i = p.ceB.cbX;
        }
        if (i != this.cfZ.getMode()) {
            this.cfZ.setMode(i);
        }
        if (z != this.cfZ.isSpeakerphoneOn()) {
            this.cfZ.setSpeakerphoneOn(z);
        }
    }

    public final void stop() {
        v.d("MicroMsg.RingPlayer", "stop, isStarted: %b", new Object[]{Boolean.valueOf(this.aYi)});
        if (this.eWH != null) {
            this.eWH.cancel();
            this.eWH = null;
        }
        if (this.kBT != null && this.aYi) {
            try {
                this.kBT.stop();
                this.kBT.release();
                if (this.kBX != null) {
                    this.cnC.removeCallbacks(this.kBX);
                }
                this.aYi = false;
                ak.yX().setMode(0);
            } catch (Exception e) {
                v.e("MicroMsg.RingPlayer", e.toString());
            }
        }
    }

    public final boolean bdP() {
        return !this.aYi;
    }

    public final void i(int i, int i2, boolean z) {
        boolean booleanValue;
        if (i2 == 0) {
            try {
                ak.yW();
                booleanValue = ((Boolean) c.vf().get(73217, Boolean.valueOf(true))).booleanValue();
            } catch (Exception e) {
                v.e("MicroMsg.RingPlayer", "get voip sound failed: " + e.getMessage());
            }
        } else {
            if (i2 == 1 || i2 == 2) {
                ak.yW();
                booleanValue = ((Boolean) c.vf().get(73218, Boolean.valueOf(true))).booleanValue();
            }
            booleanValue = true;
        }
        if (booleanValue && !this.aYi) {
            try {
                this.kBV = System.currentTimeMillis();
                this.kBT = new MediaPlayer();
                try {
                    this.kBT.setDataSource(this.mContext, Uri.parse("android.resource://" + this.mContext.getPackageName() + "/" + i));
                    this.kBT.setOnCompletionListener(new OnCompletionListener(this) {
                        final /* synthetic */ h kBY;

                        {
                            this.kBY = r1;
                        }

                        public final void onCompletion(MediaPlayer mediaPlayer) {
                            if (System.currentTimeMillis() - this.kBY.kBV > 70000) {
                                this.kBY.kBU = 4;
                            }
                        }
                    });
                    this.kBT.setOnErrorListener(new OnErrorListener(this) {
                        final /* synthetic */ h kBY;

                        {
                            this.kBY = r1;
                        }

                        public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                            this.kBY.kBU = 1;
                            v.w("MicroMsg.RingPlayer", "RingPlayer startPlayCustomRing MediaPlayer onError, what: " + i + ":extra:" + i2);
                            return false;
                        }
                    });
                    boolean qU = ak.yX().qU();
                    boolean ra = ak.yX().ra();
                    v.d("MicroMsg.RingPlayer", "isBluetoothOn: %b, isHeadsetPlugged: %b", new Object[]{Boolean.valueOf(qU), Boolean.valueOf(ra)});
                    int i3 = (qU || ra) ? 0 : 2;
                    if (((i2 == 1 || i2 == 2) && z) || ra || qU) {
                        if (p.ceB.cbW >= 0) {
                            i3 = p.ceB.cbW;
                        } else {
                            i3 = 0;
                        }
                        gY(false);
                    } else if (!z || i2 == 0) {
                        if (!ak.yX().qU() && p.ceB.cbY >= 0) {
                            i3 = p.ceB.cbY;
                        }
                        gY(true);
                    }
                    this.kBT.setAudioStreamType(i3);
                    if (z) {
                        this.kBT.setVolume(0.6f, 0.6f);
                    } else {
                        bdQ();
                    }
                    this.kBT.setLooping(true);
                    this.kBT.prepare();
                    this.kBT.start();
                    if (System.currentTimeMillis() - this.kBV > 2000) {
                        this.kBU = 3;
                    }
                } catch (Throwable th) {
                    v.e("MicroMsg.RingPlayer", "startPlayCustomRing failed, " + th.getMessage());
                    this.kBU = 2;
                }
                this.aYi = true;
            } catch (Exception e2) {
                v.e("MicroMsg.RingPlayer", "new MediaPlayer failed, " + e2.toString());
            }
        }
    }

    public final void a(int i, long j, boolean z, int i2) {
        this.kBV = System.currentTimeMillis();
        this.kBT = new MediaPlayer();
        try {
            this.kBT.setDataSource(this.mContext, Uri.parse("android.resource://" + this.mContext.getPackageName() + "/" + i));
            final int i3 = i;
            final long j2 = j;
            final boolean z2 = z;
            final int i4 = i2;
            this.kBT.setOnCompletionListener(new OnCompletionListener(this) {
                final /* synthetic */ h kBY;

                public final void onCompletion(MediaPlayer mediaPlayer) {
                    if (System.currentTimeMillis() - this.kBY.kBV > 70000) {
                        this.kBY.kBU = 4;
                    }
                    if (this.kBY.aYi) {
                        this.kBY.kBX = new a(this.kBY, i3, j2, z2, i4);
                        this.kBY.cnC.postDelayed(this.kBY.kBX, j2);
                    }
                }
            });
            this.kBT.setOnErrorListener(new OnErrorListener(this) {
                final /* synthetic */ h kBY;

                {
                    this.kBY = r1;
                }

                public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                    this.kBY.kBU = 1;
                    v.w("MicroMsg.RingPlayer", "RingPlayer startPlayCustomRing MediaPlayer onError, what: " + i + ":extra:" + i2);
                    return false;
                }
            });
            this.kBT.setAudioStreamType(i2);
            if (z) {
                this.kBT.setVolume(0.6f, 0.6f);
            } else {
                bdQ();
            }
            this.kBT.setLooping(false);
            this.kBT.prepare();
            this.kBT.start();
            if (System.currentTimeMillis() - this.kBV > 2000) {
                this.kBU = 3;
            }
        } catch (Exception e) {
            v.e("MicroMsg.RingPlayer", "new MediaPlayer failed, " + e.toString());
        }
    }

    private void bdQ() {
        if (this.mContext.getSharedPreferences(aa.bti(), 0).getBoolean("settings_shake", true)) {
            int ringerMode = this.cfZ.getRingerMode();
            if (ringerMode == 1 || ringerMode == 2) {
                this.eWH = (Vibrator) this.mContext.getSystemService("vibrator");
                if (this.eWH != null) {
                    this.eWH.vibrate(new long[]{1000, 1000, 1000, 1000}, 0);
                }
            }
        }
    }

    public final void j(int i, int i2, boolean z) {
        i(2131165830, i2, z);
    }

    public final void b(int i, boolean z, int i2, boolean z2) {
        boolean z3 = this.mContext.getSharedPreferences(aa.bti(), 0).getBoolean("settings_shake", true);
        if (z) {
            be.j(this.mContext, z3);
        }
        if (i2 == 0) {
            try {
                ak.yW();
                z3 = ((Boolean) c.vf().get(73217, Boolean.valueOf(true))).booleanValue();
            } catch (Exception e) {
                v.e("MicroMsg.RingPlayer", "get voip sound failed: " + e.getMessage());
            }
        } else {
            if (i2 == 1) {
                ak.yW();
                z3 = ((Boolean) c.vf().get(73218, Boolean.valueOf(true))).booleanValue();
            }
            z3 = true;
        }
        if (z3) {
            this.kBW = System.currentTimeMillis();
            MediaPlayer mediaPlayer = new MediaPlayer();
            try {
                mediaPlayer.setDataSource(this.mContext, Uri.parse("android.resource://" + this.mContext.getPackageName() + "/" + i));
                mediaPlayer.setOnCompletionListener(new OnCompletionListener(this) {
                    final /* synthetic */ h kBY;

                    {
                        this.kBY = r1;
                    }

                    public final void onCompletion(MediaPlayer mediaPlayer) {
                        mediaPlayer.release();
                        if (System.currentTimeMillis() - this.kBY.kBW > 5000) {
                            this.kBY.kBU = 8;
                        }
                    }
                });
                mediaPlayer.setOnErrorListener(new OnErrorListener(this) {
                    final /* synthetic */ h kBY;

                    {
                        this.kBY = r1;
                    }

                    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                        if (mediaPlayer != null) {
                            mediaPlayer.release();
                            this.kBY.kBU = 5;
                            v.w("MicroMsg.RingPlayer", "RingPlayer playSound :onError", new Object[]{mediaPlayer, Integer.valueOf(i), Integer.valueOf(i2)});
                        }
                        return false;
                    }
                });
                if (z2) {
                    mediaPlayer.setAudioStreamType(ak.yX().qU() ? 0 : 2);
                    if (ak.yX().qU()) {
                        mediaPlayer.setVolume(0.5f, 0.5f);
                    }
                }
                mediaPlayer.prepare();
                mediaPlayer.setLooping(false);
                mediaPlayer.start();
                if (System.currentTimeMillis() - this.kBW > 2000) {
                    this.kBU = 7;
                }
            } catch (Throwable th) {
                v.w("MicroMsg.RingPlayer", "playSound Failed Throwable t = ", new Object[]{th});
                this.kBU = 6;
            }
        }
    }

    public final void d(int i, boolean z, int i2) {
        b(2131165831, false, i2, true);
    }

    public final int bdR() {
        v.d("MicroMsg.RingPlayer", "RingPlayer  mRingPlayerErrState:" + this.kBU);
        return this.kBU;
    }
}
