package com.tencent.mm.plugin.favorite.ui.base;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.favorite.b.s;
import com.tencent.mm.plugin.favorite.b.u;
import com.tencent.mm.plugin.favorite.b.v;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;

public class FavVoiceBaseView extends LinearLayout implements com.tencent.mm.plugin.favorite.b.u.a {
    private int bdW;
    private int duration;
    public u fMi;
    private ViewGroup fQt;
    private TextView fQu;
    private ImageButton fQv;
    private TextView fQw;
    private a fQx;
    private String path = "";

    private class a extends ac {
        boolean cOX;
        float fQA;
        int fQB;
        int fQC;
        final /* synthetic */ FavVoiceBaseView fQy;
        float fQz;

        private a(FavVoiceBaseView favVoiceBaseView) {
            this.fQy = favVoiceBaseView;
        }

        public final void kO(int i) {
            this.cOX = false;
            this.fQz = v.au((long) i);
            this.fQA = this.fQz;
            this.fQC = com.tencent.mm.bd.a.fromDPToPix(this.fQy.getContext(), 3);
            this.fQy.fQw.setText(s.s(this.fQy.getContext(), (int) this.fQz));
            this.fQy.fQv.setImageResource(2131166002);
            this.fQy.fQv.setContentDescription(this.fQy.getContext().getResources().getString(2131231124));
            this.fQy.fQu.setWidth(this.fQC);
        }

        public final void begin() {
            stop();
            this.cOX = false;
            this.fQy.fQv.setImageResource(2131166003);
            this.fQy.fQv.setContentDescription(this.fQy.getContext().getResources().getString(2131231108));
            sendEmptyMessage(4096);
        }

        public final void stop() {
            this.cOX = false;
            removeMessages(4096);
            kO(this.fQy.duration);
        }

        public final void amW() {
            this.fQB = ((int) ((1.0f - (this.fQA / this.fQz)) * ((float) (this.fQy.fQt.getWidth() - this.fQC)))) + this.fQC;
            this.fQy.fQw.setText(s.s(this.fQy.getContext(), Math.min((int) Math.ceil((double) this.fQA), (int) this.fQz)));
            this.fQy.fQu.setWidth(this.fQB);
        }

        public final void b(double d, int i, boolean z) {
            this.fQz = v.au((long) i);
            this.fQA = (float) Math.max(0.0d, Math.min((double) this.fQz, ((double) this.fQz) * (1.0d - d)));
            this.fQC = com.tencent.mm.bd.a.fromDPToPix(this.fQy.getContext(), 3);
            this.fQy.fQv.setImageResource(2131166002);
            this.fQy.fQv.setContentDescription(this.fQy.getContext().getResources().getString(2131231124));
            amW();
            if (z) {
                this.fQy.fQv.setImageResource(2131166003);
                this.fQy.fQv.setContentDescription(this.fQy.getContext().getResources().getString(2131231108));
                sendEmptyMessage(4096);
            }
        }

        public final void handleMessage(Message message) {
            this.fQA = Math.max(0.0f, this.fQA - 0.256f);
            amW();
            if (this.fQA > 0.1f) {
                sendEmptyMessageDelayed(4096, 256);
            }
        }
    }

    static /* synthetic */ void i(FavVoiceBaseView favVoiceBaseView) {
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.FavVoiceBaseView", "start play, path[%s] voiceType[%d]", new Object[]{favVoiceBaseView.path, Integer.valueOf(favVoiceBaseView.bdW)});
        if (favVoiceBaseView.fMi.au(favVoiceBaseView.path, favVoiceBaseView.bdW)) {
            favVoiceBaseView.fQu.setKeepScreenOn(true);
            favVoiceBaseView.fQx.begin();
            return;
        }
        Toast.makeText(favVoiceBaseView.getContext(), 2131232754, 1).show();
    }

    static /* synthetic */ boolean j(FavVoiceBaseView favVoiceBaseView) {
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FavVoiceBaseView", "resume play");
        boolean alN = favVoiceBaseView.fMi.alN();
        a aVar = favVoiceBaseView.fQx;
        aVar.cOX = false;
        aVar.sendEmptyMessage(4096);
        aVar.fQy.fQv.setImageResource(2131166003);
        aVar.fQy.fQv.setContentDescription(aVar.fQy.getContext().getResources().getString(2131231108));
        favVoiceBaseView.fQu.setKeepScreenOn(true);
        return alN;
    }

    public FavVoiceBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FavVoiceBaseView", "on configuration changed, is paused ? %B", new Object[]{Boolean.valueOf(this.fQx.cOX)});
        if (this.fQx.cOX) {
            this.fQx.postDelayed(new Runnable(this) {
                final /* synthetic */ FavVoiceBaseView fQy;

                {
                    this.fQy = r1;
                }

                public final void run() {
                    this.fQy.fQx.amW();
                }
            }, 128);
        }
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.fQt = (ViewGroup) findViewById(2131757011);
        this.fQw = (TextView) findViewById(2131757010);
        this.fQu = (TextView) findViewById(2131757012);
        this.fQv = (ImageButton) findViewById(2131757009);
        this.fQx = new a();
        this.fQv.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FavVoiceBaseView fQy;

            {
                this.fQy = r1;
            }

            public final void onClick(View view) {
                if (!com.tencent.mm.as.u.bj(view.getContext()) && !com.tencent.mm.ah.a.aT(view.getContext())) {
                    if (!f.sj() && !be.kS(this.fQy.path)) {
                        com.tencent.mm.ui.base.s.ey(view.getContext());
                    } else if (!be.ah(this.fQy.path, "").equals(this.fQy.fMi.path)) {
                        FavVoiceBaseView.i(this.fQy);
                    } else if (this.fQy.fMi.alM()) {
                        this.fQy.alO();
                    } else if (!FavVoiceBaseView.j(this.fQy)) {
                        FavVoiceBaseView.i(this.fQy);
                    }
                }
            }
        });
    }

    public final void y(String str, int i, int i2) {
        this.path = be.ah(str, "");
        this.bdW = i;
        this.duration = i2;
        if (!this.path.equals(this.fMi.path)) {
            this.fQx.kO(i2);
        } else if (this.fMi.alM()) {
            this.fQx.b(this.fMi.oY(), i2, true);
        } else if (this.fMi.oZ()) {
            this.fQx.b(this.fMi.oY(), i2, false);
        } else {
            this.fQx.kO(i2);
        }
    }

    public final boolean alO() {
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.FavVoiceBaseView", "pause play");
        boolean alO = this.fMi.alO();
        a aVar = this.fQx;
        aVar.cOX = true;
        aVar.removeMessages(4096);
        aVar.fQy.fQv.setImageResource(2131166002);
        aVar.fQy.fQv.setContentDescription(aVar.fQy.getContext().getResources().getString(2131231124));
        this.fQu.setKeepScreenOn(false);
        return alO;
    }

    public final void XV() {
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.FavVoiceBaseView", "stop play");
        this.fMi.XV();
        this.fQx.stop();
        this.fQu.setKeepScreenOn(false);
    }

    public final void av(String str, int i) {
        com.tencent.mm.sdk.platformtools.v.d("MicroMsg.FavVoiceBaseView", "on play, my path %s, my duration %d, play path %s", new Object[]{this.path, Integer.valueOf(this.duration), str});
        if (be.ah(str, "").equals(this.path)) {
            this.fQu.setKeepScreenOn(true);
            this.fQx.begin();
            return;
        }
        this.fQx.stop();
        this.fQu.setKeepScreenOn(false);
    }

    public final void onFinish() {
        XV();
    }

    public final void onPause() {
        alO();
    }
}
