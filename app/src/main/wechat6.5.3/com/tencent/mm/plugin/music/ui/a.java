package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.ShapeDrawable.ShaderFactory;
import android.graphics.drawable.shapes.RectShape;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mars.comm.NetStatusUtil;
import com.tencent.mm.ae.n;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.music.a.d.b;
import com.tencent.mm.plugin.music.a.f;
import com.tencent.mm.plugin.music.a.h;
import com.tencent.mm.plugin.music.a.i;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.d;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public final class a extends d implements com.tencent.mm.plugin.music.a.d.a {
    int count;
    ac hCx;
    final int hDV;
    final int hDW;
    HashMap<Integer, View> hDX;
    com.tencent.mm.plugin.music.a.d hDY;
    int hDZ;
    boolean pRh;
    int scene;

    public class a {
        com.tencent.mm.ai.a big;
        final /* synthetic */ a hEb;
        MusicItemLayout hEc;
        View hEd;
        View hEe;
        View hEf;
        CdnImageView hEg;
        TextView hEh;
        LyricView hEi;
        boolean hEj;
        private AnimationListener hEk = new AnimationListener(this) {
            final /* synthetic */ a hEm;

            {
                this.hEm = r1;
            }

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                this.hEm.hEj = false;
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        };
        private int mode = 1;

        class AnonymousClass1 extends ShaderFactory {
            final /* synthetic */ int hEl;
            final /* synthetic */ a hEm;

            AnonymousClass1(a aVar, int i) {
                this.hEm = aVar;
                this.hEl = i;
            }

            public final Shader resize(int i, int i2) {
                return new LinearGradient(0.0f, 0.0f, 0.0f, (float) i2, new int[]{0, this.hEl}, new float[]{0.0f, 1.0f}, TileMode.REPEAT);
            }
        }

        class AnonymousClass2 extends ShaderFactory {
            final /* synthetic */ a hEm;
            final /* synthetic */ int hEn;

            AnonymousClass2(a aVar, int i) {
                this.hEm = aVar;
                this.hEn = i;
            }

            public final Shader resize(int i, int i2) {
                return new LinearGradient(0.0f, 0.0f, 0.0f, (float) i2, new int[]{this.hEn, 0}, new float[]{0.0f, 1.0f}, TileMode.REPEAT);
            }
        }

        public class a extends Animation {
            final int fQm;
            final /* synthetic */ a hEm;
            final int hEo;
            View view;

            public a(a aVar, View view, int i) {
                this.hEm = aVar;
                this.view = view;
                this.fQm = i;
                this.hEo = view.getHeight();
            }

            protected final void applyTransformation(float f, Transformation transformation) {
                this.view.getLayoutParams().height = (int) (((float) this.hEo) + (((float) (this.fQm - this.hEo)) * f));
                this.view.requestLayout();
            }

            public final void initialize(int i, int i2, int i3, int i4) {
                super.initialize(i, i2, i3, i4);
            }

            public final boolean willChangeBounds() {
                return true;
            }
        }

        public a(a aVar) {
            this.hEb = aVar;
        }

        public final void f(com.tencent.mm.ai.a aVar, boolean z) {
            if (aVar != null) {
                v.i("MicroMsg.Music.MusicMainAdapter", "updateView %s", new Object[]{aVar.field_songName});
                this.big = aVar;
                if (be.kS(aVar.field_songHAlbumUrl)) {
                    f aDd = i.aDd();
                    boolean z2 = this.hEb.pRh;
                    if (aVar != null) {
                        if (aDd.hCR != null) {
                            ak.vy().c(aDd.hCR);
                            aDd.hCR = null;
                        }
                        if (aVar.field_songId <= 0) {
                            v.e("MicroMsg.Music.MusicPlayerManager", "can't get songId ");
                            g.iuh.Y(10911, "1");
                        } else {
                            aDd.hCR = new com.tencent.mm.plugin.music.a.b.a(aVar, z2);
                            ak.vy().a(aDd.hCR, 0);
                        }
                    }
                }
                this.hEc.setTag(this);
                this.hEh.setText(aVar.field_songName);
                this.hEh.setTag(aVar.field_songName);
                LyricView lyricView = this.hEi;
                com.tencent.mm.plugin.music.a.d.a aDe = i.aDe();
                lyricView.hDF = aDe.hDE.get(aVar.field_musicId) != null ? (com.tencent.mm.plugin.music.a.a) aDe.hDE.get(aVar.field_musicId) : aDe.g(aVar, this.hEb.pRh);
                lyricView.invalidate();
                if (!h.e(aVar) || this.hEb.pRh) {
                    this.hEi.cl(1);
                }
                aDo();
                com.tencent.mm.plugin.music.a.d dVar = this.hEb.hDY;
                CdnImageView cdnImageView = this.hEg;
                Context context = this.hEb.context;
                boolean z3 = this.hEb.pRh;
                if (z) {
                    dVar.bYS.remove(aVar.field_musicId);
                }
                Bitmap bitmap = (Bitmap) dVar.bYS.get(aVar.field_musicId);
                int[] q;
                if (bitmap == null || bitmap.isRecycled()) {
                    bitmap = null;
                    v.i("MicroMsg.Music.MusicImageLoader", "no hit cache %s %s %s %s", new Object[]{aVar.field_musicId, aVar.field_songHAlbumUrl, aVar.field_songAlbumUrl, aVar.field_songAlbumLocalPath});
                    cdnImageView.setTag(aVar);
                    com.tencent.mm.ae.a.a.c.a aVar2;
                    if (aVar.Hz()) {
                        aVar2 = new com.tencent.mm.ae.a.a.c.a();
                        aVar2.cPu = h.e(aVar, true);
                        aVar2.cPs = true;
                        aVar2.cPq = true;
                        aVar2.cPH = 2130838083;
                        if (z3) {
                            aVar2.cPC = true;
                            aVar2.cPD = 10;
                        }
                        n.GL().a(aVar.field_songHAlbumUrl, cdnImageView, aVar2.GU(), dVar.hCw);
                    } else {
                        switch (aVar.field_musicType) {
                            case 0:
                            case 5:
                            case 7:
                                break;
                            case 1:
                            case 8:
                            case NetStatusUtil.MOBILE /*9*/:
                                aib com_tencent_mm_protocal_c_aib = new aib();
                                com_tencent_mm_protocal_c_aib.gID = aVar.field_songMediaId;
                                com_tencent_mm_protocal_c_aib.mHP = aVar.field_songAlbumUrl;
                                com_tencent_mm_protocal_c_aib.mHQ = aVar.field_songAlbumType;
                                com_tencent_mm_protocal_c_aib.glb = com_tencent_mm_protocal_c_aib.mHP;
                                if (j.ak.lye != null) {
                                    bitmap = j.ak.lye.r(com_tencent_mm_protocal_c_aib);
                                    if (bitmap == null) {
                                        cdnImageView.setImageResource(2130838083);
                                        if (!(aVar.Hy() || dVar.hCv == null)) {
                                            dVar.hCv.a(aVar, new int[]{-16777216, -1});
                                        }
                                        j.ak.lye.ca(cdnImageView);
                                        j.ak.lye.c(com_tencent_mm_protocal_c_aib, cdnImageView, context.hashCode(), com.tencent.mm.storage.ak.nvx);
                                        dVar.hCx.removeCallbacksAndMessages(null);
                                        dVar.hCx.postDelayed(new b(dVar, aVar), 1000);
                                        break;
                                    }
                                    bitmap = com.tencent.mm.sdk.platformtools.d.c(bitmap, 10);
                                    break;
                                }
                                break;
                            case 4:
                                aVar2 = new com.tencent.mm.ae.a.a.c.a();
                                aVar2.cPu = h.e(aVar, false);
                                aVar2.cPs = true;
                                aVar2.cPq = true;
                                if (z3) {
                                    aVar2.cPC = true;
                                    aVar2.cPD = 10;
                                }
                                n.GL().a(aVar.field_songAlbumUrl, cdnImageView, aVar2.GU(), dVar.hCw);
                                break;
                            case 6:
                                bitmap = n.GH().a(aVar.field_songAlbumLocalPath, com.tencent.mm.bd.a.getDensity(context));
                                break;
                            default:
                                break;
                        }
                        if (bitmap == null) {
                            bitmap = n.GH().a(aVar.field_songAlbumLocalPath, com.tencent.mm.bd.a.getDensity(context), false);
                        }
                        if (bitmap != null) {
                            bitmap = com.tencent.mm.sdk.platformtools.d.c(bitmap, 10);
                        } else {
                            cdnImageView.setImageResource(2130838083);
                            if (!(aVar.Hy() || dVar.hCv == null)) {
                                dVar.hCv.a(aVar, new int[]{-16777216, -1});
                            }
                        }
                    }
                    if (bitmap != null && !bitmap.isRecycled()) {
                        dVar.a(aVar, bitmap);
                        cdnImageView.setImageBitmap(bitmap);
                        q = h.q(bitmap);
                        if (!aVar.e(q)) {
                            aVar = i.aDe().B(aVar.field_musicId, q[0], q[1]);
                        }
                        if (dVar.hCv != null) {
                            dVar.hCv.a(aVar, q);
                            return;
                        }
                        return;
                    }
                    return;
                }
                v.i("MicroMsg.Music.MusicImageLoader", "hit cache %s", new Object[]{aVar.field_musicId});
                cdnImageView.setImageBitmap(bitmap);
                q = aVar.Hy() ? new int[]{aVar.field_songBgColor, aVar.field_songLyricColor} : h.q(bitmap);
                if (dVar.hCv != null) {
                    dVar.hCv.a(aVar, q);
                }
            }
        }

        public final boolean aDn() {
            return this.mode == 2;
        }

        public final void aDo() {
            if (!this.hEj && this.mode != 1) {
                com.tencent.mm.plugin.music.a.g.bZ(3, this.hEb.scene);
                if (this.hEb.hDZ == 0) {
                    this.hEb.hDZ = this.hEd.getMeasuredHeight();
                    LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, this.hEb.hDZ);
                    layoutParams.weight = 0.0f;
                    this.hEd.setLayoutParams(layoutParams);
                }
                com.tencent.mm.plugin.music.a.g.hCW = true;
                com.tencent.mm.plugin.music.a.g.aDb();
                this.mode = 1;
                this.hEj = true;
                Animation aVar = new a(this, this.hEi, this.hEb.hDV);
                aVar.setDuration(500);
                aVar.setAnimationListener(this.hEk);
                this.hEi.startAnimation(aVar);
            }
        }

        public final void aDp() {
            if (!this.hEj && this.mode != 2) {
                com.tencent.mm.plugin.music.a.g.bZ(2, this.hEb.scene);
                if (this.hEb.hDZ == 0) {
                    this.hEb.hDZ = this.hEd.getMeasuredHeight();
                    LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, this.hEb.hDZ);
                    layoutParams.weight = 0.0f;
                    this.hEd.setLayoutParams(layoutParams);
                }
                com.tencent.mm.plugin.music.a.g.hCW = true;
                com.tencent.mm.plugin.music.a.g.aDb();
                this.mode = 2;
                this.hEj = true;
                Animation aVar = new a(this, this.hEi, this.hEb.hDW);
                aVar.setDuration(500);
                aVar.setAnimationListener(this.hEk);
                this.hEi.startAnimation(aVar);
            }
        }

        public final void aDq() {
            com.tencent.mm.plugin.music.a.g.hCW = true;
            com.tencent.mm.plugin.music.a.g.aDb();
            if (this.mode == 1) {
                aDp();
            } else {
                aDo();
            }
        }
    }

    public a(Context context, int i, boolean z) {
        super(context);
        this.hDV = com.tencent.mm.bd.a.fromDPToPix(aa.getContext(), 26);
        this.hDW = com.tencent.mm.bd.a.fromDPToPix(aa.getContext(), 260);
        this.hCx = new ac(Looper.getMainLooper());
        this.hDX = new HashMap();
        this.hDY = new com.tencent.mm.plugin.music.a.d();
        this.hDY.hCv = this;
        this.scene = i;
        this.pRh = z;
    }

    public final int getCount() {
        return this.count;
    }

    public final View a(View view, ViewGroup viewGroup, int i) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(2130904104, viewGroup, false);
            aVar = new a(this);
            aVar.hEc = (MusicItemLayout) view.findViewById(2131758371);
            aVar.hEh = (TextView) view.findViewById(2131758376);
            aVar.hEi = (LyricView) view.findViewById(2131758377);
            aVar.hEd = view.findViewById(2131758372);
            aVar.hEe = view.findViewById(2131758374);
            aVar.hEf = view.findViewById(2131758375);
            aVar.hEg = (CdnImageView) view.findViewById(2131758373);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        List list = i.aDd().hCP;
        int size = (i - 100000) % list.size();
        if (size < 0) {
            size += list.size();
        }
        v.d("MicroMsg.Music.MusicMainAdapter", "play music index %d", new Object[]{Integer.valueOf(size)});
        com.tencent.mm.ai.a xe = i.aDe().xe((String) list.get(size));
        this.hDX.put(Integer.valueOf(i), view);
        aVar.f(xe, false);
        return view;
    }

    public final void nx(int i) {
        this.hDX.remove(Integer.valueOf(i));
    }

    public final int aDm() {
        return i.aDd().hCP.size();
    }

    public final void u(final int i, final long j) {
        ad.o(new Runnable(this) {
            final /* synthetic */ a hEb;

            public final void run() {
                View view = (View) this.hEb.hDX.get(Integer.valueOf(i));
                if (view != null) {
                    ((a) view.getTag()).hEi.cl(j);
                }
            }
        });
    }

    public final void a(com.tencent.mm.ai.a aVar, int[] iArr) {
        for (Entry value : this.hDX.entrySet()) {
            a aVar2 = (a) ((View) value.getValue()).getTag();
            if (aVar2.big.field_musicId.equals(aVar.field_musicId)) {
                v.i("MicroMsg.Music.MusicMainAdapter", "onColorReady: %s", new Object[]{aVar2.big.field_songName});
                int i = iArr[0];
                int i2 = iArr[1];
                aVar2.hEc.setBackgroundColor(i);
                LyricView lyricView = aVar2.hEi;
                lyricView.hDH.setColor(i2);
                lyricView.hDH.setAlpha(255);
                lyricView.hDI.setColor(i2);
                lyricView.hDI.setAlpha(127);
                aVar2.hEg.setBackgroundColor(i);
                ShaderFactory anonymousClass1 = new AnonymousClass1(aVar2, i);
                Drawable paintDrawable = new PaintDrawable();
                paintDrawable.setShape(new RectShape());
                paintDrawable.setShaderFactory(anonymousClass1);
                aVar2.hEe.setBackgroundDrawable(paintDrawable);
                anonymousClass1 = new AnonymousClass2(aVar2, (i & 16777215) | 1426063360);
                Drawable paintDrawable2 = new PaintDrawable();
                paintDrawable2.setShape(new RectShape());
                paintDrawable2.setShaderFactory(anonymousClass1);
                aVar2.hEf.setBackgroundDrawable(paintDrawable2);
                aVar2.hEh.setTextColor(i2);
                ((MusicMainUI) this.context).i(aVar);
            }
        }
    }
}
