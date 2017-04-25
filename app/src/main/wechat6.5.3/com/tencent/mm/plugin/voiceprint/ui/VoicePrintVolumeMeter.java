package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;

public class VoicePrintVolumeMeter extends View {
    static int gWP = 20;
    private static int kqc = Color.rgb(240, 250, 235);
    private static int kqd = Color.rgb(210, 240, 200);
    private static int kqe = 100;
    private static float kql = DownloadHelper.SAVE_FATOR;
    private static float kqm = 2.0f;
    private static float kqn = 0.1f;
    private static float kqo = 0.05f;
    private Paint ft;
    boolean gCX = false;
    View gWD;
    private int kpY = -1;
    private int kpZ = -1;
    ad kqa = null;
    ah kqb = null;
    private float kqf = 0.0f;
    private float kqg = 0.0f;
    private float kqh = 0.0f;
    private float kqi = 0.0f;
    private float kqj = 0.0f;
    private float kqk = 0.0f;
    float kqp = -1.0f;
    boolean kqq = true;
    private Context mContext;

    static /* synthetic */ void a(VoicePrintVolumeMeter voicePrintVolumeMeter) {
        if (voicePrintVolumeMeter.gCX) {
            if (voicePrintVolumeMeter.kqq) {
                voicePrintVolumeMeter.kqj *= kqn + 1.0f;
                voicePrintVolumeMeter.kqk = voicePrintVolumeMeter.kqj * kql;
            } else {
                voicePrintVolumeMeter.kqj *= 1.0f - kqo;
                voicePrintVolumeMeter.kqk = voicePrintVolumeMeter.kqj * kql;
            }
            voicePrintVolumeMeter.postInvalidate();
        }
    }

    public VoicePrintVolumeMeter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public VoicePrintVolumeMeter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.ft = new Paint();
        this.kqa = new ad("VoicePrintVolumeMeter");
        this.kqb = new ah(this.kqa.htb.getLooper(), new a(this) {
            final /* synthetic */ VoicePrintVolumeMeter kqr;

            {
                this.kqr = r1;
            }

            public final boolean oU() {
                VoicePrintVolumeMeter.a(this.kqr);
                return this.kqr.gCX;
            }
        }, true);
    }

    final void bbg() {
        if (this.gWD != null && this.gWD.getVisibility() != 8) {
            int[] iArr = new int[2];
            this.gWD.getLocationOnScreen(iArr);
            if (iArr[0] == 0 || iArr[1] == 0) {
                v.d("MicroMsg.VoicePrintVolumeMeter", "setCenterLocation, cannot get archView location");
                return;
            }
            int width = this.gWD.getWidth();
            int height = this.gWD.getHeight();
            if (height == 0 || width == 0) {
                v.d("MicroMsg.VoicePrintVolumeMeter", "setCenterLocation, cannot get archView size");
                return;
            }
            this.kpY = iArr[0] + (width / 2);
            this.kpZ = (iArr[1] + (height / 2)) - com.tencent.mm.bd.a.fromDPToPix(this.mContext, 25);
            v.d("MicroMsg.VoicePrintVolumeMeter", "setCenterLocation, mCenterX:%d, mCenterY:%d", new Object[]{Integer.valueOf(this.kpY), Integer.valueOf(this.kpZ)});
            this.kqf = ((float) width) / 2.0f;
            this.kqg = this.kqf * kql;
            this.kqh = this.kqf * kqm;
            this.kqi = this.kqg * kqm;
            this.kqk = this.kqg;
            this.kqj = this.kqf;
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.gCX) {
            if (this.kpY == -1 || this.kpZ == -1) {
                bbg();
            }
            this.ft.setAlpha(kqe);
            if (this.kqk > this.kqi) {
                this.kqk = this.kqi;
            }
            if (this.kqk < this.kqg) {
                this.kqk = this.kqg;
            }
            this.ft.setColor(kqc);
            canvas.drawCircle((float) this.kpY, (float) this.kpZ, this.kqk, this.ft);
            if (this.kqj > this.kqh) {
                this.kqj = this.kqh;
            }
            if (this.kqj < this.kqf) {
                this.kqj = this.kqf;
            }
            this.ft.setColor(kqd);
            canvas.drawCircle((float) this.kpY, (float) this.kpZ, this.kqj, this.ft);
        }
    }

    public final void stop() {
        reset();
        this.gCX = false;
        this.kqb.QI();
        postInvalidate();
    }

    public final void reset() {
        this.kqq = false;
        this.kqp = -1.0f;
        this.gCX = false;
        this.kqj = 0.0f;
        this.kqk = 0.0f;
        postInvalidate();
    }
}
