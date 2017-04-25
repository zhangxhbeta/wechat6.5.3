package com.tencent.mm.ui.base;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;

public class MMFalseProgressBar extends ProgressBar {
    private ac mHandler;
    private boolean nUM;
    private float nUN;
    private float nUO;
    private float nUP;
    private float nUQ;
    private float nUR;

    static /* synthetic */ void a(MMFalseProgressBar mMFalseProgressBar) {
        mMFalseProgressBar.setVisibility(0);
        mMFalseProgressBar.setAlpha(1.0f);
    }

    static /* synthetic */ void b(MMFalseProgressBar mMFalseProgressBar) {
        if (mMFalseProgressBar.nUN < 600.0f) {
            mMFalseProgressBar.nUN += mMFalseProgressBar.nUO;
        } else if (mMFalseProgressBar.nUN >= 600.0f && mMFalseProgressBar.nUN < 800.0f) {
            mMFalseProgressBar.nUN += mMFalseProgressBar.nUP;
        } else if (mMFalseProgressBar.nUN >= 800.0f && mMFalseProgressBar.nUN < 920.0f) {
            mMFalseProgressBar.nUN += mMFalseProgressBar.nUQ;
        }
        if (mMFalseProgressBar.mHandler != null) {
            if (mMFalseProgressBar.nUN < 920.0f) {
                mMFalseProgressBar.mHandler.sendEmptyMessageDelayed(1001, 10);
            } else {
                mMFalseProgressBar.mHandler.removeMessages(1001);
            }
        }
        mMFalseProgressBar.setProgress((int) mMFalseProgressBar.nUN);
    }

    static /* synthetic */ void c(MMFalseProgressBar mMFalseProgressBar) {
        Float valueOf;
        float f = 950.0f;
        if (mMFalseProgressBar.nUN < 950.0f) {
            mMFalseProgressBar.nUN += mMFalseProgressBar.nUR;
            if (mMFalseProgressBar.nUN <= 950.0f) {
                f = mMFalseProgressBar.nUN;
            }
            mMFalseProgressBar.nUN = f;
            valueOf = Float.valueOf(1.0f);
        } else {
            mMFalseProgressBar.nUN += 1.0f;
            valueOf = Float.valueOf(((1000.0f - mMFalseProgressBar.nUN) * 0.01f) + 0.3f);
        }
        if (mMFalseProgressBar.mHandler != null) {
            if (mMFalseProgressBar.nUN < 1000.0f) {
                mMFalseProgressBar.mHandler.sendEmptyMessageDelayed(1002, 10);
            } else {
                mMFalseProgressBar.nUN = 1000.0f;
                mMFalseProgressBar.mHandler.removeMessages(1002);
                mMFalseProgressBar.mHandler.sendEmptyMessageDelayed(1003, 10);
            }
        }
        mMFalseProgressBar.setAlpha(valueOf.floatValue());
        mMFalseProgressBar.setProgress((int) mMFalseProgressBar.nUN);
    }

    static /* synthetic */ void d(MMFalseProgressBar mMFalseProgressBar) {
        mMFalseProgressBar.nUN = 0.0f;
        mMFalseProgressBar.nUM = false;
        mMFalseProgressBar.postInvalidateDelayed(200);
        mMFalseProgressBar.setVisibility(8);
    }

    public MMFalseProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MMFalseProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nUM = false;
        this.nUN = 0.0f;
        this.mHandler = new ac(this, Looper.getMainLooper()) {
            final /* synthetic */ MMFalseProgressBar nUS;

            public final void handleMessage(Message message) {
                switch (message.what) {
                    case BaseReportManager.MAX_READ_COUNT /*1000*/:
                        MMFalseProgressBar.a(this.nUS);
                        return;
                    case 1001:
                        MMFalseProgressBar.b(this.nUS);
                        return;
                    case 1002:
                        MMFalseProgressBar.c(this.nUS);
                        return;
                    case 1003:
                        MMFalseProgressBar.d(this.nUS);
                        return;
                    default:
                        return;
                }
            }
        };
        setMax(BaseReportManager.MAX_READ_COUNT);
    }

    public final void start() {
        v.d("MicroMsg.MMFalseProgressBar", "[cpan] start");
        if (!this.nUM) {
            this.nUM = true;
            if (ak.dR(getContext())) {
                this.nUO = 4.0f;
                this.nUP = 1.0f;
                this.nUQ = 0.3f;
                this.nUR = 50.0f;
            } else {
                this.nUO = 2.0f;
                this.nUP = 0.5f;
                this.nUQ = 0.15f;
                this.nUR = 50.0f;
            }
            if (this.mHandler != null) {
                this.mHandler.sendEmptyMessage(BaseReportManager.MAX_READ_COUNT);
                this.mHandler.sendEmptyMessage(1001);
            }
        }
    }

    public final void finish() {
        v.d("MicroMsg.MMFalseProgressBar", "[cpan] finish");
        if (this.mHandler != null) {
            this.mHandler.sendEmptyMessage(1002);
        }
    }
}
