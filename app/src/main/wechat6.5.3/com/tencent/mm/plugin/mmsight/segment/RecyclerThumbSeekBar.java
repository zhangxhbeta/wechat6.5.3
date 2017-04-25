package com.tencent.mm.plugin.mmsight.segment;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.HandlerThread;
import android.support.v4.view.y;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.j;
import android.support.v7.widget.RecyclerView.s;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.gmtrace.Constants;
import com.tencent.mm.memory.o;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.ref.WeakReference;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingDeque;

public class RecyclerThumbSeekBar extends RelativeLayout implements d {
    private int con;
    private int coo;
    private int gee = -1;
    private int hqY;
    private com.tencent.mm.plugin.mmsight.segment.d.a hqZ;
    private com.tencent.mm.plugin.mmsight.segment.d.b hra;
    private RecyclerView hrb;
    private c hrc;
    private l hrd;
    private int hre;
    private com.tencent.mm.plugin.mmsight.segment.e.a hrf = new com.tencent.mm.plugin.mmsight.segment.e.a(4, new Callable<e>(this) {
        final /* synthetic */ RecyclerThumbSeekBar hrj;

        {
            this.hrj = r1;
        }

        public final /* synthetic */ Object call() {
            e fFmpegSightJNIThumbFetcher = new FFmpegSightJNIThumbFetcher();
            fFmpegSightJNIThumbFetcher.init(this.hrj.path, this.hrj.hqY, this.hrj.coo, this.hrj.con);
            return fFmpegSightJNIThumbFetcher;
        }
    });
    private Runnable hrg = new Runnable(this) {
        final /* synthetic */ RecyclerThumbSeekBar hrj;

        {
            this.hrj = r1;
        }

        public final void run() {
            if (this.hrj.getHeight() == 0 || this.hrj.getWidth() == 0) {
                this.hrj.post(this.hrj.hrg);
                return;
            }
            this.hrj.hqY = 1000;
            this.hrj.con = this.hrj.getHeight();
            this.hrj.coo = (this.hrj.getWidth() - (this.hrj.hre * 2)) / 10;
            com.tencent.mm.sdk.i.e.a(new Runnable(this) {
                final /* synthetic */ AnonymousClass2 hrk;

                {
                    this.hrk = r1;
                }

                public final void run() {
                    int i;
                    try {
                        e aAM = this.hrk.hrj.hrf.aAM();
                        this.hrk.hrj.gee = aAM.getDurationMs();
                        this.hrk.hrj.hrf.a(aAM);
                        i = 1;
                    } catch (Throwable e) {
                        v.a("RecyclerThumbSeekBar", e, "Try to init fetcher error : %s", new Object[]{e.getMessage()});
                        i = 0;
                    }
                    if (i == 0) {
                        this.hrk.hrj.aAQ();
                        return;
                    }
                    if (this.hrk.hrj.gee >= Constants.THREAD_BITSET_SIZE) {
                        this.hrk.hrj.hqY = 1000;
                    } else if (this.hrk.hrj.gee > 0) {
                        this.hrk.hrj.hqY = this.hrk.hrj.gee / 10;
                    } else {
                        v.e("RecyclerThumbSeekBar", "RecyclerThumbSeekBar duration invalid %d", new Object[]{Integer.valueOf(this.hrk.hrj.gee)});
                        this.hrk.hrj.aAQ();
                        return;
                    }
                    v.d("RecyclerThumbSeekBar", "duration %d interval %d", new Object[]{Integer.valueOf(this.hrk.hrj.gee), Integer.valueOf(this.hrk.hrj.hqY)});
                    ad.o(new Runnable(this.hrk.hrj) {
                        final /* synthetic */ RecyclerThumbSeekBar hrj;

                        {
                            this.hrj = r1;
                        }

                        public final void run() {
                            try {
                                this.hrj.hrd.Q(-1.0f);
                                this.hrj.hrc = new c();
                                int e = RecyclerThumbSeekBar.e(this.hrj, Constants.THREAD_BITSET_SIZE);
                                int e2 = RecyclerThumbSeekBar.e(this.hrj, 1000);
                                this.hrj.hre = (this.hrj.getWidth() - e) / 2;
                                this.hrj.hrd.E(e, e2, this.hrj.hre);
                                v.i("RecyclerThumbSeekBar", "RecyclerThumbSeekBar.run(212) width %d", new Object[]{Integer.valueOf(this.hrj.getWidth())});
                                this.hrj.hrc.hrq = (this.hrj.getWidth() - this.hrj.hre) - e;
                                this.hrj.hrc.hrp = this.hrj.hre;
                                this.hrj.hrb.a(this.hrj.hrc);
                                v.d("RecyclerThumbSeekBar", "init segment thumb fetcher end, adapter.getItemCount() %d", new Object[]{Integer.valueOf(this.hrj.hrc.getItemCount())});
                                if (this.hrj.hqZ != null) {
                                    this.hrj.hqZ.ek(false);
                                }
                            } catch (Throwable e3) {
                                v.a("RecyclerThumbSeekBar", e3, "RecyclerThumbSeekBar notifySuccess error : %s", new Object[]{e3.getMessage()});
                                if (this.hrj.hqZ != null) {
                                    this.hrj.hqZ.ek(true);
                                }
                            }
                        }
                    });
                }
            }, "check duration of ");
        }
    };
    private j hrh = new j(this) {
        final /* synthetic */ RecyclerThumbSeekBar hrj;

        {
            this.hrj = r1;
        }

        public final void e(RecyclerView recyclerView, int i) {
            if (i == 0 && this.hrj.hra != null) {
                this.hrj.hra.r(this.hrj.aAJ(), this.hrj.aAK());
            }
        }
    };
    private com.tencent.mm.plugin.mmsight.segment.l.a hri = new com.tencent.mm.plugin.mmsight.segment.l.a(this) {
        final /* synthetic */ RecyclerThumbSeekBar hrj;

        {
            this.hrj = r1;
        }

        public final void aAR() {
            if (this.hrj.hra != null && this.hrj.hrc != null) {
                com.tencent.mm.plugin.mmsight.segment.d.b o = this.hrj.hra;
                this.hrj.aAJ();
                this.hrj.aAK();
                o.aAL();
            }
        }

        public final void aAS() {
            if (this.hrj.hra != null && this.hrj.hrc != null) {
                this.hrj.hra.s(this.hrj.aAJ(), this.hrj.aAK());
            }
        }

        public final void el(boolean z) {
            if (!(this.hrj.hra == null || this.hrj.hrc == null)) {
                this.hrj.hra.t(this.hrj.aAJ(), this.hrj.aAK());
            }
            if (z) {
                this.hrj.hrc.l(true, this.hrj.hrd.aAT());
            } else {
                this.hrj.hrc.l(false, this.hrj.hrd.getWidth() - this.hrj.hrd.aAU());
            }
        }
    };
    private String path;

    private class a implements Runnable {
        private ImageView bdF;
        private Bitmap bitmap;
        final /* synthetic */ RecyclerThumbSeekBar hrj;
        private b hrl;

        a(RecyclerThumbSeekBar recyclerThumbSeekBar, Bitmap bitmap, ImageView imageView, b bVar) {
            this.hrj = recyclerThumbSeekBar;
            this.bitmap = bitmap;
            this.bdF = imageView;
            this.hrl = bVar;
        }

        public final void run() {
            boolean z = true;
            if (this.bitmap == null || this.bitmap.isRecycled()) {
                String str = "RecyclerThumbSeekBar";
                String str2 = "bitmap is null %b in DrawBitmapOnViewTask";
                Object[] objArr = new Object[1];
                if (this.bitmap != null) {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                v.i(str, str2, objArr);
            } else if (this.hrl == null || this.hrl.cRi || this.bdF == null) {
                v.i("RecyclerThumbSeekBar", "bitmap in DrawBitmapOnViewTask");
            } else {
                ImageView imageView = this.bdF;
                imageView.setTag(null);
                ObjectAnimator.ofInt(imageView, "imageAlpha", new int[]{50, 255}).setDuration(200).start();
                imageView.setImageBitmap(this.bitmap);
            }
        }
    }

    private class b implements Runnable {
        boolean cRi = false;
        private WeakReference<ImageView> cxw;
        private ac handler;
        final /* synthetic */ RecyclerThumbSeekBar hrj;
        private int hrm;
        private Bitmap hrn;

        b(RecyclerThumbSeekBar recyclerThumbSeekBar, int i, ImageView imageView, Bitmap bitmap, ac acVar) {
            this.hrj = recyclerThumbSeekBar;
            this.hrm = i;
            this.cxw = new WeakReference(imageView);
            this.handler = acVar;
            this.hrn = bitmap;
        }

        public final void run() {
            if (this.cRi) {
                o.cnL.d(this.hrn);
            } else if (((ImageView) this.cxw.get()) == null) {
                o.cnL.d(this.hrn);
            } else {
                try {
                    e aAM = this.hrj.hrf.aAM();
                    if (this.hrn == null) {
                        this.hrn = o.cnL.a(new com.tencent.mm.memory.o.b(aAM.getScaledWidth(), aAM.getScaledHeight()));
                    }
                    aAM.reuseBitmap(this.hrn);
                    if (!this.cRi) {
                        this.hrn = aAM.getFrameAtTime((long) this.hrm);
                    }
                    this.hrj.hrf.a(aAM);
                    if (this.hrn == null || this.cRi || this.cxw.get() == null) {
                        o.cnL.d(this.hrn);
                    } else {
                        this.handler.post(new a(this.hrj, this.hrn, (ImageView) this.cxw.get(), this));
                    }
                } catch (Exception e) {
                    v.e("RecyclerThumbSeekBar", "get bitmap error " + e.getMessage());
                    o.cnL.d(this.hrn);
                }
            }
        }
    }

    private class c extends android.support.v7.widget.RecyclerView.a<e> {
        final /* synthetic */ RecyclerThumbSeekBar hrj;
        d hro;
        int hrp;
        int hrq;
        private View hrr;
        private View hrs;

        private c(RecyclerThumbSeekBar recyclerThumbSeekBar) {
            this.hrj = recyclerThumbSeekBar;
            this.hro = new d(this.hrj);
            this.hrp = this.hrj.hre;
            this.hrq = this.hrj.hre;
        }

        public final /* synthetic */ s a(ViewGroup viewGroup, int i) {
            View view;
            if (i == 1 || i == 2) {
                view = new View(this.hrj.getContext());
                if (i == 1) {
                    this.hrr = view;
                } else {
                    this.hrs = view;
                }
                return new e(this.hrj, view, 1);
            }
            View imageView = new ImageView(this.hrj.getContext());
            imageView.setScaleType(ScaleType.CENTER_CROP);
            imageView.setMinimumWidth(this.hrj.coo);
            imageView.setMinimumHeight(this.hrj.con);
            view = new LinearLayout(this.hrj.getContext());
            view.addView(imageView, this.hrj.coo, this.hrj.con);
            return new e(this.hrj, view, 0);
        }

        public final /* synthetic */ void a(s sVar, int i) {
            e eVar = (e) sVar;
            if (getItemViewType(i) == 1 || getItemViewType(i) == 2) {
                if (i == 0) {
                    eVar.aal.setMinimumWidth(this.hrp);
                } else {
                    eVar.aal.setMinimumWidth(this.hrq);
                }
                eVar.aal.setBackgroundColor(-16777216);
                eVar.aal.setMinimumHeight(this.hrj.con);
            } else if (this.hro != null) {
                d dVar = this.hro;
                int b = this.hrj.hqY * (i - 1);
                ImageView imageView = eVar.bdF;
                if (imageView != null && b >= 0) {
                    v.i("RecyclerThumbSeekBar", "loadImageAsync() called with: time = [" + b + "], view = [" + imageView + "]");
                    Object tag = imageView.getTag();
                    b bVar = (tag == null || !(tag instanceof b)) ? null : (b) tag;
                    if (bVar == null || bVar.hrm != b) {
                        if (bVar != null) {
                            bVar.cRi = true;
                        }
                        Bitmap bitmap = (imageView.getDrawable() == null || !(imageView.getDrawable() instanceof BitmapDrawable)) ? null : ((BitmapDrawable) imageView.getDrawable()).getBitmap();
                        imageView.setImageBitmap(null);
                        Runnable bVar2 = new b(dVar.hrj, b, imageView, bitmap, dVar.handler);
                        imageView.setTag(bVar2);
                        int i2 = dVar.hru % dVar.hnK;
                        dVar.hru++;
                        if (dVar.hrt[i2] != null) {
                            new ac(dVar.hrt[i2].getLooper()).post(bVar2);
                            return;
                        }
                        return;
                    }
                    v.i("RecyclerThumbSeekBar", "SimpleImageLoader.loadImageAsync time equals %d return directly", new Object[]{Integer.valueOf(b)});
                }
            } else {
                v.e("RecyclerThumbSeekBar", "onBindViewHolder ImageLoader invoked after released.");
            }
        }

        public final int getItemViewType(int i) {
            if (i == 0) {
                return 1;
            }
            if (i == getItemCount() - 1) {
                return 2;
            }
            return 0;
        }

        public final void l(boolean z, int i) {
            if (z) {
                if (this.hrr != null) {
                    this.hrr.setMinimumWidth(i);
                }
                if (((LinearLayoutManager) this.hrj.hrb.Ym).fe() == 0) {
                    this.hrj.hrb.scrollBy(i - this.hrp, 0);
                }
                this.hrp = i;
                return;
            }
            this.hrq = i;
            if (this.hrs != null) {
                this.hrs.setMinimumWidth(this.hrq);
            }
        }

        public final int getItemCount() {
            return this.hrj.gee <= 0 ? 0 : Math.max(0, (int) Math.floor((double) (((float) this.hrj.gee) / ((float) this.hrj.hqY)))) + 2;
        }
    }

    private class d {
        ac handler = new ac();
        int hnK = 4;
        final /* synthetic */ RecyclerThumbSeekBar hrj;
        HandlerThread[] hrt = new HandlerThread[this.hnK];
        int hru = 0;
        private BlockingDeque<b> hrv = new LinkedBlockingDeque();

        public d(RecyclerThumbSeekBar recyclerThumbSeekBar) {
            this.hrj = recyclerThumbSeekBar;
            for (int i = 0; i < this.hrt.length; i++) {
                this.hrt[i] = com.tencent.mm.sdk.i.e.bJ("RecyclerThumbSeekBar_SimpleImageLoader_" + i, -1);
                this.hrt[i].start();
            }
            this.hru = 0;
        }
    }

    private class e extends s {
        ImageView bdF;
        final /* synthetic */ RecyclerThumbSeekBar hrj;

        e(RecyclerThumbSeekBar recyclerThumbSeekBar, View view, int i) {
            this.hrj = recyclerThumbSeekBar;
            super(view);
            if (i == 0) {
                this.bdF = (ImageView) ((LinearLayout) view).getChildAt(0);
            }
        }
    }

    static /* synthetic */ int e(RecyclerThumbSeekBar recyclerThumbSeekBar, int i) {
        if (recyclerThumbSeekBar.hrc == null) {
            throw new IllegalStateException("recyclerAdapter is null");
        } else if (recyclerThumbSeekBar.gee <= 0) {
            throw new IllegalStateException("durationMs <= 0");
        } else {
            recyclerThumbSeekBar.hrc.getItemCount();
            return (int) ((Math.min(Math.max(0.0f, ((float) i) / ((float) recyclerThumbSeekBar.gee)), 1.0f) * ((float) recyclerThumbSeekBar.coo)) * ((float) (recyclerThumbSeekBar.hrc.getItemCount() - 2)));
        }
    }

    public RecyclerThumbSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public RecyclerThumbSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.hrb = new RecyclerView(getContext());
        getContext();
        this.hrb.a(new LinearLayoutManager(0, false));
        this.hrb.Ys = true;
        int N = com.tencent.mm.bd.a.N(getContext(), 2131493589);
        this.hre = com.tencent.mm.bd.a.N(getContext(), 2131493588);
        addView(this.hrb, new LayoutParams(-1, N));
        this.hrd = new l(getContext());
        addView(this.hrd, new LayoutParams(-1, -1));
        this.hrd.hrF = this.hri;
        this.hrb.a(this.hrh);
    }

    public final void P(float f) {
        float f2 = 0.0f;
        l lVar = this.hrd;
        if (!(this.hrc == null || this.hrb == null)) {
            s aY;
            float itemCount = ((float) (this.hrc.getItemCount() - 2)) * f;
            int floor = (int) Math.floor((double) itemCount);
            float f3 = itemCount - ((float) floor);
            RecyclerView recyclerView = this.hrb;
            int i = floor + 1;
            if (!recyclerView.YC) {
                int eK = recyclerView.Yh.eK();
                for (floor = 0; floor < eK; floor++) {
                    aY = RecyclerView.aY(recyclerView.Yh.aL(floor));
                    if (aY != null && !aY.isRemoved() && recyclerView.h(aY) == i) {
                        break;
                    }
                }
            }
            aY = null;
            if (aY != null) {
                View view = aY.aal;
                f2 = ((((float) view.getWidth()) * f3) + ((float) view.getLeft())) / ((float) getWidth());
            }
        }
        lVar.Q(f2);
    }

    public final void wB(String str) {
        if (be.kS(str) || !FileOp.aR(str)) {
            aAQ();
            return;
        }
        this.path = str;
        post(this.hrg);
    }

    public final int getDurationMs() {
        return this.gee;
    }

    public final void ej(boolean z) {
        if (z) {
            this.hrd.hrH = true;
        } else {
            this.hrd.hrH = false;
        }
    }

    private void aAQ() {
        ad.o(new Runnable(this) {
            final /* synthetic */ RecyclerThumbSeekBar hrj;

            {
                this.hrj = r1;
            }

            public final void run() {
                if (this.hrj.hqZ != null) {
                    this.hrj.hqZ.ek(true);
                }
            }
        });
    }

    public final void release() {
        this.gee = -1;
        this.path = null;
        if (this.hrf != null) {
            this.hrf.destroy();
        }
        if (this.hrc != null && this.hrc.hro != null) {
            d dVar = this.hrc.hro;
            if (!(dVar.hrt == null || dVar.hrt.length == 0)) {
                for (int i = 0; i < dVar.hrt.length; i++) {
                    if (dVar.hrt[i] != null) {
                        dVar.hrt[i].quit();
                        dVar.hrt[i] = null;
                    }
                }
            }
            this.hrc.hro = null;
        }
    }

    public final void a(com.tencent.mm.plugin.mmsight.segment.d.a aVar) {
        this.hqZ = aVar;
    }

    public final void a(com.tencent.mm.plugin.mmsight.segment.d.b bVar) {
        this.hra = bVar;
    }

    public final float aAJ() {
        if (this.hrd == null) {
            return 0.0f;
        }
        return nd(this.hrd.aAT());
    }

    public final float aAK() {
        if (this.hrd == null) {
            return 0.0f;
        }
        return nd(this.hrd.aAU());
    }

    private float nd(int i) {
        if (this.hrc == null || this.hrb == null) {
            return 0.0f;
        }
        int childCount;
        View childAt;
        RecyclerView recyclerView = this.hrb;
        float f = (float) i;
        for (childCount = recyclerView.Yh.getChildCount() - 1; childCount >= 0; childCount--) {
            childAt = recyclerView.Yh.getChildAt(childCount);
            float Q = y.Q(childAt);
            float R = y.R(childAt);
            if (f >= ((float) childAt.getLeft()) + Q && f <= Q + ((float) childAt.getRight()) && 0.0f >= ((float) childAt.getTop()) + R && 0.0f <= ((float) childAt.getBottom()) + R) {
                break;
            }
        }
        childAt = null;
        childCount = RecyclerView.aZ(childAt);
        int itemCount = this.hrc.getItemCount();
        if (childCount <= 0) {
            return 0.0f;
        }
        if (childCount >= itemCount - 1) {
            return 1.0f;
        }
        return ((((float) (i - childAt.getLeft())) / ((float) childAt.getWidth())) + ((float) (childCount - 1))) / ((float) (itemCount - 2));
    }
}
