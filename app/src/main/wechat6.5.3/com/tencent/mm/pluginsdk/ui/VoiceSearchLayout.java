package com.tencent.mm.pluginsdk.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.at.e;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;

public class VoiceSearchLayout extends LinearLayout {
    private static final int[] ewF = new int[]{2130839437, 2130839438, 2130839439, 2130839440, 2130839417, 2130839418, 2130839419, 2130839420, 2130839421, 2130839422, 2130839423, 2130839424, 2130839425, 2130839426};
    private static final int[] lIX = new int[]{2130839437, 2130839437, 2130839437, 2130839438, 2130839439, 2130839438, 2130839437, 2130839440, 2130839437, 2130839437};
    private static final int[] lIY = new int[]{2130839427, 2130839436, 2130839436, 2130839436, 2130839427};
    public boolean bhY = false;
    private int cPY = 0;
    public final ah exb = new ah(new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ VoiceSearchLayout lJc;

        {
            this.lJc = r1;
        }

        public final boolean oU() {
            if (this.lJc.lIV != null) {
                if (this.lJc.lJb < VoiceSearchLayout.lIY.length) {
                    VoiceSearchLayout.a(this.lJc, VoiceSearchLayout.lIY[this.lJc.lJb = this.lJc.lJb + 1]);
                } else {
                    e a = this.lJc.lIV;
                    v.d("MicroMsg.SceneVoiceAddr", "cAmplitude " + a.dkl);
                    int i = a.dkl;
                    a.dkl = 0;
                    if (i > e.aVI) {
                        e.aVI = i;
                    }
                    v.d("getMaxAmplitude", " map: " + i + " max:" + e.aVI + " per:" + ((i * 100) / e.aVI));
                    int i2 = (i * 100) / e.aVI;
                    v.d("MicroMsg.VoiceSearchLayout", "addr vol:" + i2);
                    i = this.lJc.cPY;
                    if (this.lJc.cPY == this.lJc.lIZ) {
                        if (i2 <= 10) {
                            VoiceSearchLayout.f(this.lJc);
                            if (this.lJc.lJa >= VoiceSearchLayout.lIX.length) {
                                this.lJc.lJa = 0;
                            }
                            VoiceSearchLayout.a(this.lJc, VoiceSearchLayout.lIX[this.lJc.lJa]);
                        } else {
                            i2 /= 5;
                            if (i2 >= VoiceSearchLayout.ewF.length) {
                                i2 = VoiceSearchLayout.ewF.length - 1;
                            }
                            v.d("MicroMsg.VoiceSearchLayout", "addr mvol:" + i2);
                            this.lJc.lIZ = i2;
                        }
                    } else if (this.lJc.cPY > this.lJc.lIZ) {
                        VoiceSearchLayout.i(this.lJc);
                    } else {
                        VoiceSearchLayout.j(this.lJc);
                    }
                    VoiceSearchLayout.a(this.lJc, VoiceSearchLayout.ewF[i]);
                }
            }
            return true;
        }
    }, true);
    public View fDt = null;
    public a lIO = null;
    public Button lIP;
    public boolean lIQ = false;
    public int lIR = 0;
    public b lIS;
    public View lIT;
    public AnimationDrawable lIU;
    public e lIV;
    private boolean lIW = false;
    private int lIZ = 0;
    private int lJa = 0;
    public int lJb = 0;

    public interface a {
        void a(boolean z, String[] strArr, long j);

        void bpe();

        void bpf();
    }

    public interface b {
        void hY(boolean z);
    }

    static /* synthetic */ void a(VoiceSearchLayout voiceSearchLayout, int i) {
        if (voiceSearchLayout.lIP != null) {
            voiceSearchLayout.lIP.setBackgroundResource(i);
        }
    }

    static /* synthetic */ int f(VoiceSearchLayout voiceSearchLayout) {
        int i = voiceSearchLayout.lJa + 1;
        voiceSearchLayout.lJa = i;
        return i;
    }

    static /* synthetic */ int i(VoiceSearchLayout voiceSearchLayout) {
        int i = voiceSearchLayout.cPY - 1;
        voiceSearchLayout.cPY = i;
        return i;
    }

    static /* synthetic */ int j(VoiceSearchLayout voiceSearchLayout) {
        int i = voiceSearchLayout.cPY + 1;
        voiceSearchLayout.cPY = i;
        return i;
    }

    static /* synthetic */ void k(VoiceSearchLayout voiceSearchLayout) {
        voiceSearchLayout.lIQ = true;
        voiceSearchLayout.hX(true);
    }

    @TargetApi(11)
    public VoiceSearchLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public VoiceSearchLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public VoiceSearchLayout(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        this.fDt = inflate(context, 2130904589, this);
        this.lIP = (Button) this.fDt.findViewById(2131759642);
        this.lIT = this.fDt.findViewById(2131759673);
        hX(false);
        reset();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.lIQ) {
            bpa();
        }
        return true;
    }

    public final void bpa() {
        v.d("MicroMsg.VoiceSearchLayout", "checkStop " + this.bhY);
        if (this.bhY) {
            boP();
            this.bhY = false;
        }
    }

    public final void boP() {
        v.d("MicroMsg.VoiceSearchLayout", "doCancel " + this.bhY);
        if (this.bhY) {
            this.bhY = false;
            if (this.lIO != null) {
                this.lIO.bpf();
            }
        }
        reset();
        if (getVisibility() == 0) {
            setVisibility(8);
            if (this.lIS != null) {
                this.lIS.hY(false);
            }
        }
        rc();
        if (this.lIV != null) {
            this.lIV.cancel();
        }
        if (this.exb != null) {
            this.exb.QI();
        }
    }

    public final void reset() {
        hX(false);
        this.bhY = false;
        this.lIQ = false;
        this.lIP.setBackgroundResource(2130839415);
        this.lIT.setBackgroundDrawable(getResources().getDrawable(2130839414));
    }

    private void hX(boolean z) {
        if (z) {
            this.lIP.setBackgroundResource(2130839396);
            this.lIU = (AnimationDrawable) this.lIP.getBackground();
            if (this.lIU != null) {
                this.lIU.start();
                return;
            }
            return;
        }
        this.lIP.setBackgroundResource(2130839415);
    }

    public void setVisibility(int i) {
        if (super.getVisibility() != i && !this.lIW) {
            Animation loadAnimation;
            if (i == 8) {
                loadAnimation = AnimationUtils.loadAnimation(getContext(), 2130968623);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getContext(), 2130968622);
            }
            startAnimation(loadAnimation);
            super.setVisibility(i);
            if (this.lIS != null) {
                this.lIS.hY(i == 0);
            }
        }
    }

    public final void tR(int i) {
        LayoutParams layoutParams = (LayoutParams) this.lIT.getLayoutParams();
        layoutParams.topMargin = i;
        this.lIT.setLayoutParams(layoutParams);
    }

    public final void a(boolean z, g gVar) {
        if (z) {
            v.d("MicroMsg.VoiceSearchLayout", "pauseMusic");
            ak.yX().rb();
        } else {
            rc();
        }
        MediaPlayer mediaPlayer = new MediaPlayer();
        if (z) {
            try {
                mediaPlayer.setDataSource(getContext(), Uri.parse("android.resource://" + getContext().getPackageName() + "/2131165809"));
            } catch (Throwable e) {
                v.a("MicroMsg.VoiceSearchLayout", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                return;
            }
        }
        mediaPlayer.setDataSource(getContext(), Uri.parse("android.resource://" + getContext().getPackageName() + "/2131165769"));
        mediaPlayer.setAudioStreamType(5);
        mediaPlayer.setOnCompletionListener(new OnCompletionListener(this, null) {
            final /* synthetic */ VoiceSearchLayout lJc;

            public final void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.release();
            }
        });
        mediaPlayer.setOnErrorListener(new OnErrorListener(this, null) {
            final /* synthetic */ VoiceSearchLayout lJc;

            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                return false;
            }
        });
        mediaPlayer.prepare();
        mediaPlayer.setLooping(false);
        mediaPlayer.start();
    }

    private static void rc() {
        v.d("MicroMsg.VoiceSearchLayout", "resumeMusic");
        ak.yX().rc();
    }
}
