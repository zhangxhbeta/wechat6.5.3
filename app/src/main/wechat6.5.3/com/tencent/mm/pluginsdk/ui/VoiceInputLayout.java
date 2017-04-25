package com.tencent.mm.pluginsdk.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.mm.at.f;
import com.tencent.mm.at.f.b;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.v;

public abstract class VoiceInputLayout extends LinearLayout {
    private ac eFT = new ac(this) {
        final /* synthetic */ VoiceInputLayout lIx;

        {
            this.lIx = r1;
        }

        public final void handleMessage(Message message) {
            if (message.what != 0) {
                if (message.what == 1) {
                    v.w("MicroMsg.VoiceInputLayout", "Recognized revealTime force finished %s", Integer.valueOf(this.lIx.lIh));
                } else {
                    return;
                }
            }
            v.d("MicroMsg.VoiceInputLayout", "Recognized force finished %s", Integer.valueOf(this.lIx.lIh));
            if (this.lIx.lIh == 3) {
                this.lIx.eFT.removeMessages(0);
                this.lIx.eFT.removeMessages(1);
                if (this.lIx.lIt != null) {
                    this.lIx.lIt.bl(true);
                }
                this.lIx.hW(true);
            }
        }
    };
    private final ah exb = new ah(new com.tencent.mm.sdk.platformtools.ah.a(this) {
        final /* synthetic */ VoiceInputLayout lIx;

        {
            this.lIx = r1;
        }

        public final boolean oU() {
            if (this.lIx.lIt != null) {
                f b = this.lIx.lIt;
                int i = b.dkl;
                b.dkl = 0;
                if (i > f.aVI) {
                    f.aVI = i;
                }
                int i2 = (i * 100) / f.aVI;
                if (this.lIx.lIh == 2) {
                    this.lIx.tP(i2);
                }
            }
            return true;
        }
    }, true);
    protected int lIh = 1;
    public a lIs = null;
    private f lIt;
    private int lIu = 3000;
    private int lIv = 5000;
    private ac lIw = new ac(this) {
        final /* synthetic */ VoiceInputLayout lIx;

        {
            this.lIx = r1;
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    this.lIx.boQ();
                    return;
                case 1:
                    Bundle data = message.getData();
                    this.lIx.O(data.getInt("localCode"), data.getInt("errType"), data.getInt("errCode"));
                    return;
                default:
                    return;
            }
        }
    };

    public interface a {
        void B(String[] strArr);

        void P(int i, int i2, int i3);

        void boT();

        void boU();

        void boV();

        void boW();
    }

    protected abstract void hU(boolean z);

    protected abstract void hV(boolean z);

    protected abstract void onReset();

    protected abstract void tP(int i);

    @TargetApi(11)
    public VoiceInputLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public VoiceInputLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void boO() {
        v.d("MicroMsg.VoiceInputLayout", "summerper checkPermission checkMicrophone[%s]", Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.aP(getContext(), "android.permission.RECORD_AUDIO")));
        if (com.tencent.mm.pluginsdk.i.a.aP(getContext(), "android.permission.RECORD_AUDIO")) {
            v.d("MicroMsg.VoiceInputLayout", "doStart currentState = %s", Integer.valueOf(this.lIh));
            if (this.lIh == 1) {
                this.lIh = 2;
                if (this.lIs != null) {
                    this.lIs.boT();
                }
                this.exb.ea(50);
                hU(true);
                this.lIt = new f(new b(this) {
                    final /* synthetic */ VoiceInputLayout lIx;

                    {
                        this.lIx = r1;
                    }

                    public final void LM() {
                        v.d("MicroMsg.VoiceInputLayout", "onRecordFin() onRecordFin currentState = %s", Integer.valueOf(this.lIx.lIh));
                        if (this.lIx.exb != null) {
                            this.lIx.exb.QI();
                        }
                        this.lIx.lIw.sendEmptyMessage(0);
                    }

                    public final void LR() {
                        v.d("MicroMsg.VoiceInputLayout", "onRecognize Finish");
                        this.lIx.eFT.removeMessages(0);
                        this.lIx.eFT.removeMessages(1);
                        this.lIx.lIs.boW();
                        this.lIx.hW(false);
                    }

                    public final void f(String[] strArr) {
                        this.lIx.lIs.B(strArr);
                        this.lIx.eFT.removeMessages(0);
                        this.lIx.eFT.sendEmptyMessageDelayed(0, (long) this.lIx.lIu);
                    }

                    public final void u(int i, int i2, int i3) {
                        this.lIx.eFT.removeMessages(0);
                        this.lIx.eFT.removeMessages(1);
                        Message message = new Message();
                        Bundle bundle = new Bundle();
                        bundle.putInt("localCode", i);
                        bundle.putInt("errType", i2);
                        bundle.putInt("errCode", i3);
                        message.setData(bundle);
                        message.what = 1;
                        this.lIx.lIw.sendMessage(message);
                    }
                });
                f fVar = this.lIt;
                v.i("MicroMsg.SceneVoiceInputAddr", "start record");
                e.b(new a(), "SceneVoiceInputAddr_record", 10);
            }
        } else if (getContext() instanceof Activity) {
            com.tencent.mm.pluginsdk.i.a.e((Activity) getContext(), "android.permission.RECORD_AUDIO");
        }
    }

    public final void boP() {
        v.d("MicroMsg.VoiceInputLayout", "doCancel. state = %s", Integer.valueOf(this.lIh));
        if (this.lIh != 1) {
            this.lIh = 1;
            if (this.lIs != null) {
                this.lIs.boU();
            }
            if (this.lIt != null) {
                this.lIt.bl(true);
            }
            onReset();
        }
    }

    public final void bf() {
        v.d("MicroMsg.VoiceInputLayout", "do Stop. currentState = %s", Integer.valueOf(this.lIh));
        if (this.lIh != 1 && this.lIh == 2) {
            this.lIh = 3;
            if (this.exb != null) {
                this.exb.QI();
            }
            this.eFT.removeMessages(0);
            this.eFT.sendEmptyMessageDelayed(0, (long) this.lIu);
            this.eFT.sendEmptyMessageDelayed(1, (long) this.lIv);
            hV(true);
            if (this.lIt != null) {
                this.lIt.bk(true);
            }
        }
    }

    public final void boQ() {
        v.d("MicroMsg.VoiceInputLayout", "doWaiting currentState = %s", Integer.valueOf(this.lIh));
        if (this.lIh == 2) {
            this.lIh = 3;
            this.eFT.removeMessages(0);
            this.eFT.sendEmptyMessageDelayed(0, (long) this.lIu);
            this.eFT.sendEmptyMessageDelayed(1, (long) this.lIv);
            hV(false);
        }
    }

    public final void boR() {
        O(12, -1, -1);
    }

    public final void O(int i, int i2, int i3) {
        v.d("MicroMsg.VoiceInputLayout", "doNetworkError localerrorType:%s,errorType:%s,errCode:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        this.lIh = 1;
        onReset();
        if (this.lIs != null) {
            this.lIs.P(i, i2, i3);
        }
    }

    protected final void hW(boolean z) {
        v.d("MicroMsg.VoiceInputLayout", "reset currentState %s", Integer.valueOf(this.lIh));
        if (this.lIh != 1) {
            this.lIh = 1;
            onReset();
            if (z && this.lIs != null) {
                this.lIs.boV();
            }
        }
    }

    public final int boS() {
        return this.lIh;
    }
}
