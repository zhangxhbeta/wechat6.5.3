package com.tencent.mm.plugin.voip.ui;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Display;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.ref.WeakReference;

public abstract class c extends Fragment {
    protected static final int[] kxw = new int[]{-1, 2131235934, 2131235950, 2131235949};
    protected static int mScreenHeight;
    protected static int mScreenWidth;
    protected String bZy;
    protected ac ihw;
    protected boolean ktR;
    protected c kxA;
    protected b kxB = new b();
    private a kxC;
    protected WeakReference<b> kxl;
    protected long kxn = -1;
    protected RelativeLayout kxx;
    protected ImageView kxy;
    protected int kxz = 4096;
    protected int mStatus = -1;

    public class a implements Runnable {
        final /* synthetic */ c kxD;

        public a(c cVar) {
            this.kxD = cVar;
        }

        public final void run() {
            v.i("MicroMsg.VoipBaseFragment", "try load blur bitmap,timestamp: " + System.currentTimeMillis());
            Bitmap a = com.tencent.mm.u.b.a(this.kxD.bZy, false, -1);
            if (a != null && this.kxD.kxx != null) {
                int i = 0;
                while (true) {
                    if ((this.kxD.kxx.getHeight() == 0 || this.kxD.kxx.getWidth() == 0) && i < 10) {
                        try {
                            Thread.sleep(300);
                            i++;
                        } catch (InterruptedException e) {
                            v.e("MicroMsg.VoipBaseFragment", "wait voip initialize interrupted");
                            return;
                        }
                    }
                }
                if (a.getHeight() <= a.getWidth()) {
                    a = Bitmap.createBitmap(a, a.getWidth() / 5, a.getHeight() / 5, (int) (((double) a.getHeight()) * 0.6d), (int) (((double) a.getHeight()) * 0.6d), null, false);
                }
                a = d.a(a, a.getHeight(), (int) (((float) a.getHeight()) / ((1.0f * ((float) this.kxD.kxx.getHeight())) / ((float) this.kxD.kxx.getWidth()))), true, false);
                if (a == null) {
                    v.e("MicroMsg.VoipBaseFragment", "extract Thumb Nail for blur background failed");
                    return;
                }
                try {
                    a = d.c(a, 20);
                    v.i("MicroMsg.VoipBaseFragment", "blur ok, timestamp: " + System.currentTimeMillis());
                    this.kxD.ihw.post(new Runnable(this) {
                        final /* synthetic */ a kxE;

                        public final void run() {
                            if (this.kxE.kxD.kxy != null) {
                                this.kxE.kxD.kxy.setBackgroundDrawable(new BitmapDrawable(a));
                            }
                            this.kxE.kxD.kxC = null;
                        }
                    });
                } catch (Exception e2) {
                    v.e("MicroMsg.VoipBaseFragment", "fastblur failed: " + e2.getMessage());
                }
            }
        }
    }

    protected static class b {
        ah dwn = new ah(new com.tencent.mm.sdk.platformtools.ah.a(this) {
            final /* synthetic */ b kxI;

            {
                this.kxI = r1;
            }

            public final boolean oU() {
                int i = this.kxI.kxF[this.kxI.kxH % this.kxI.kxF.length];
                if (this.kxI.kG != null) {
                    if (-1 == i) {
                        this.kxI.kG.setText(null);
                    } else {
                        this.kxI.kG.setText(i);
                    }
                }
                b bVar = this.kxI;
                bVar.kxH++;
                return true;
            }
        }, true);
        TextView kG;
        int[] kxF;
        private int kxG;
        int kxH;

        protected b() {
        }

        public final void a(TextView textView, int[] iArr) {
            if (iArr == null || textView == null) {
                v.e("MicroMsg.DynamicTextWrap", "textList or tv is null");
                return;
            }
            bdp();
            this.kxH = 0;
            this.kxF = iArr;
            this.kG = textView;
            this.kxG = 500;
            if (this.dwn != null) {
                this.dwn.ea((long) this.kxG);
            }
            v.h("MicroMsg.DynamicTextWrap", "start textview:" + textView, new Object[0]);
        }

        public final void bdp() {
            if (this.dwn != null) {
                this.dwn.QI();
            }
            v.h("MicroMsg.DynamicTextWrap", "stop textview: " + this.kG, new Object[0]);
            this.kG = null;
        }
    }

    public interface c {
        void v(boolean z, boolean z2);
    }

    public abstract void a(int i, int i2, int[] iArr);

    public abstract void a(byte[] bArr, long j, int i, int i2, int i3, int i4, int i5, int i6);

    public abstract void b(CaptureView captureView);

    public abstract void bck();

    protected abstract void bdm();

    protected abstract void bdn();

    protected abstract void bf(String str, int i);

    public abstract void dJ(boolean z);

    public abstract void rQ(int i);

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle bundle2 = this.oJ;
        this.bZy = bundle2.getString("key_username");
        this.ktR = bundle2.getBoolean("key_isoutcall");
        if (-1 == this.mStatus) {
            this.mStatus = bundle2.getInt("key_status");
        }
        this.ihw = new ac();
    }

    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        if (mScreenWidth == 0) {
            Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
            mScreenWidth = defaultDisplay.getWidth();
            mScreenHeight = defaultDisplay.getHeight();
        }
    }

    public void cC(int i, int i2) {
        this.kxz = i;
        this.mStatus = i2;
    }

    public final void ds(long j) {
        this.kxn = j;
    }

    public void uninit() {
        v.d("MicroMsg.VoipBaseFragment", "uninit");
        this.kxB.bdp();
        b bVar = this.kxB;
        v.d("MicroMsg.DynamicTextWrap", "uninit");
        bVar.bdp();
        bVar.dwn = null;
        if (this.kxC != null) {
            e.remove(this.kxC);
            this.kxC = null;
        }
    }

    public void onDetach() {
        if (this.ihw != null) {
            this.ihw.removeCallbacksAndMessages(null);
        }
        this.kxA = null;
        super.onDetach();
    }

    public final void a(b bVar) {
        this.kxl = new WeakReference(bVar);
    }

    public final void a(c cVar) {
        this.kxA = cVar;
    }

    protected final void b(TextView textView, String str) {
        if (textView == null || be.kS(str)) {
            v.e("MicroMsg.VoipBaseFragment", "TextView is null or text is null");
            return;
        }
        textView.setText(str);
        textView.measure(MeasureSpec.makeMeasureSpec(getResources().getDisplayMetrics().widthPixels, Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(getResources().getDisplayMetrics().heightPixels, Integer.MIN_VALUE));
        textView.setWidth(textView.getMeasuredWidth());
    }

    public void onStop() {
        super.onStop();
    }

    protected final void bdo() {
        if (this.bZy != null && this.kxy.getVisibility() != 0) {
            this.kxy.setVisibility(0);
            this.kxC = new a(this);
            e.a(this.kxC, "VoipBaseFragment_blurbitmap");
        }
    }

    protected static String ao(long j) {
        return String.format("%02d:%02d", new Object[]{Long.valueOf(j / 60), Long.valueOf(j % 60)});
    }

    protected static void A(View view, int i) {
        if (view != null) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.topMargin += i;
            view.setLayoutParams(layoutParams);
        }
    }
}
