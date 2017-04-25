package com.tencent.mm.plugin.mmsight.segment;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.mmsight.segment.d.b;
import com.tencent.mm.plugin.mmsight.segment.e.a;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class SimpleThumbSeekBar extends RelativeLayout implements d {
    private int con;
    private int coo;
    private int duration;
    private CountDownLatch hrA;
    private a hrf = new a(3, new Callable<e>(this) {
        final /* synthetic */ SimpleThumbSeekBar hrB;

        {
            this.hrB = r1;
        }

        public final /* synthetic */ Object call() {
            e cVar = new c();
            cVar.init(this.hrB.path, 0, this.hrB.coo, this.hrB.con);
            return cVar;
        }
    });
    private l.a hri = new l.a(this) {
        final /* synthetic */ SimpleThumbSeekBar hrB;

        {
            this.hrB = r1;
        }

        public final void aAR() {
            if (this.hrB.hrz != null) {
                b i = this.hrB.hrz;
                this.hrB.hrw.aAT();
                this.hrB.getWidth();
                this.hrB.hrw.aAU();
                this.hrB.getWidth();
                i.aAL();
            }
        }

        public final void aAS() {
            if (this.hrB.hrz != null) {
                this.hrB.hrz.s(((float) this.hrB.hrw.aAT()) / ((float) this.hrB.getWidth()), ((float) this.hrB.hrw.aAU()) / ((float) this.hrB.getWidth()));
            }
        }

        public final void el(boolean z) {
            if (this.hrB.hrz != null) {
                this.hrB.hrz.t(((float) this.hrB.hrw.aAT()) / ((float) this.hrB.getWidth()), ((float) this.hrB.hrw.aAU()) / ((float) this.hrB.getWidth()));
            }
        }
    };
    private l hrw;
    private int hrx;
    private d.a hry;
    private b hrz;
    private String path;

    static /* synthetic */ boolean b(SimpleThumbSeekBar simpleThumbSeekBar, final int i) {
        if (simpleThumbSeekBar.getChildCount() <= 0 || !(simpleThumbSeekBar.getChildAt(0) instanceof LinearLayout)) {
            throw new IllegalStateException("ImageView Container not found. It means this view was not init correctly.");
        }
        ImageView imageView;
        LinearLayout linearLayout = (LinearLayout) simpleThumbSeekBar.getChildAt(0);
        if (i >= linearLayout.getChildCount() || !(linearLayout.getChildAt(i) instanceof ImageView)) {
            String str = "MicroMsg.SimpleThumbSeekBar";
            String str2 = "not found this index %d container.getChildCount() %d View %s";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(i);
            objArr[1] = Integer.valueOf(linearLayout.getChildCount());
            objArr[2] = i >= linearLayout.getChildCount() ? null : linearLayout.getChildAt(i);
            v.d(str, str2, objArr);
            imageView = null;
        } else {
            imageView = (ImageView) linearLayout.getChildAt(i);
        }
        if (imageView == null) {
            throw new IllegalStateException("Can not find ImageView index [" + i + "]");
        } else if (simpleThumbSeekBar.hrf == null) {
            v.e("MicroMsg.SimpleThumbSeekBar", "this thumb may be destroyed, the fetcher pool is null.");
            return false;
        } else {
            e.a(new Runnable(simpleThumbSeekBar) {
                final /* synthetic */ SimpleThumbSeekBar hrB;

                public final void run() {
                    try {
                        Bitmap frameAtTime;
                        e aAM = this.hrB.hrf.aAM();
                        long currentTimeMillis = System.currentTimeMillis();
                        try {
                            frameAtTime = aAM.getFrameAtTime((long) (((float) (i * this.hrB.duration)) / ((float) this.hrB.hrx)));
                        } catch (m e) {
                            frameAtTime = null;
                        }
                        v.d("MicroMsg.SimpleThumbSeekBar", "time flee, getFrameBitmap use %dms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                        this.hrB.hrf.a(aAM);
                        if (frameAtTime == null) {
                            v.d("MicroMsg.SimpleThumbSeekBar", "loadThumb get null");
                            this.hrB.hrA.countDown();
                            return;
                        }
                        ad.o(new Runnable(this) {
                            final /* synthetic */ AnonymousClass4 hrE;

                            public final void run() {
                                this.hrE.hrB.hrA.countDown();
                                imageView.setImageBitmap(frameAtTime);
                            }
                        });
                    } catch (Exception e2) {
                        v.e("MicroMsg.SimpleThumbSeekBar", "acquireFetcher error");
                        this.hrB.hrA.countDown();
                    }
                }
            }, "load_video_thumb");
            return true;
        }
    }

    public SimpleThumbSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public SimpleThumbSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.hrw = new l(getContext());
        this.hrw.hrF = this.hri;
    }

    public final void wB(final String str) {
        if (str == null || str.length() == 0 || !FileOp.aR(str)) {
            throw new IllegalArgumentException(String.format("SimpleThumbSeekBar can not handle this path[%s]", new Object[]{str}));
        } else if (getHeight() <= 0 || getWidth() <= 0) {
            throw new IllegalArgumentException(String.format(Locale.CHINA, "SimpleThumbSeekBar can not handle width = [%d], height = [%d]", new Object[]{Integer.valueOf(getWidth()), Integer.valueOf(getHeight())}));
        } else {
            this.path = str;
            this.hrx = 10;
            this.coo = (int) (((float) getWidth()) / ((float) this.hrx));
            this.con = getHeight();
            removeAllViews();
            int width = getWidth();
            int height = getHeight();
            LayoutParams layoutParams = getLayoutParams();
            if (!(width == layoutParams.width && height == layoutParams.width)) {
                layoutParams.height = height;
                layoutParams.width = width;
                setLayoutParams(layoutParams);
            }
            View linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(0);
            addView(linearLayout, -1, -1);
            addView(this.hrw, -1, -1);
            int width2 = (int) (((float) getWidth()) / ((float) this.hrx));
            for (height = 0; height < this.hrx; height++) {
                int height2 = getHeight();
                if (getChildCount() <= 0 || !(getChildAt(0) instanceof LinearLayout)) {
                    v.e("MicroMsg.SimpleThumbSeekBar", "ImageView Container not found. It means this view was not init correctly. getChildCount %d indexAt(0) %s", new Object[]{Integer.valueOf(getChildCount()), getChildAt(0)});
                    throw new IllegalStateException("ImageView Container not found. It means this view was not init correctly.");
                }
                LinearLayout linearLayout2 = (LinearLayout) getChildAt(0);
                View imageView = new ImageView(getContext());
                imageView.setScaleType(ScaleType.CENTER_CROP);
                imageView.setPadding(0, 0, 0, 0);
                linearLayout2.addView(imageView, new LinearLayout.LayoutParams(width2, height2));
            }
            e.a(new Runnable(this) {
                final /* synthetic */ SimpleThumbSeekBar hrB;

                public final void run() {
                    long currentTimeMillis = System.currentTimeMillis();
                    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                    mediaMetadataRetriever.setDataSource(str);
                    this.hrB.duration = Integer.valueOf(mediaMetadataRetriever.extractMetadata(9)).intValue();
                    v.d("MicroMsg.SimpleThumbSeekBar", "time flee : construct first fetcher, cost %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                    currentTimeMillis = System.currentTimeMillis();
                    this.hrB.hrA = new CountDownLatch(this.hrB.hrx);
                    v.d("MicroMsg.SimpleThumbSeekBar", "time flee : build thread. start task, cost %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                    for (int i = 0; i < this.hrB.hrx; i++) {
                        SimpleThumbSeekBar.b(this.hrB, i);
                    }
                    try {
                        this.hrB.hrA.await(3, TimeUnit.SECONDS);
                        ad.o(new Runnable(this) {
                            final /* synthetic */ AnonymousClass2 hrC;

                            {
                                this.hrC = r1;
                            }

                            public final void run() {
                                this.hrC.hrB.hrw.Q(-1.0f);
                                this.hrC.hrB.hrw.E(Integer.MAX_VALUE, 0, 0);
                                if (this.hrC.hrB.hry != null) {
                                    this.hrC.hrB.hry.ek(false);
                                }
                            }
                        });
                        if (this.hrB.hrf != null) {
                            this.hrB.hrf.destroy();
                        }
                    } catch (InterruptedException e) {
                        v.e("MicroMsg.SimpleThumbSeekBar", "ThumbLoadedLatch %s", new Object[]{e.getMessage()});
                    }
                }
            }, "init thumb seek bar");
        }
    }

    public final void ej(boolean z) {
        if (z) {
            this.hrw.hrH = true;
        } else {
            this.hrw.hrH = false;
        }
    }

    public final void release() {
        if (this.hrf != null) {
            this.hrf.destroy();
            this.hrf = null;
        }
    }

    public final int getDurationMs() {
        return 0;
    }

    public final void a(d.a aVar) {
        this.hry = aVar;
    }

    public final void a(b bVar) {
        this.hrz = bVar;
    }

    public final float aAJ() {
        float aAT = ((float) this.hrw.aAT()) / ((float) getWidth());
        v.d("MicroMsg.SimpleThumbSeekBar", "computeStartPercent() returned: " + aAT);
        return aAT;
    }

    public final float aAK() {
        float aAU = ((float) this.hrw.aAU()) / ((float) getWidth());
        v.d("MicroMsg.SimpleThumbSeekBar", "computeEndPercent() returned: " + aAU);
        return aAU;
    }

    public final void P(float f) {
        if (this.hrw != null) {
            this.hrw.Q(f);
        }
    }
}
