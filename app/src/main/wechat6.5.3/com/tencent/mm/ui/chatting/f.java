package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ae.a.a.c;
import com.tencent.mm.ae.a.c.g;
import com.tencent.mm.ae.a.d.b;
import com.tencent.mm.ae.n;
import com.tencent.mm.app.MMApplicationLike;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.chatting.ad.a;

final class f extends a {
    public static final int okh = (((int) com.tencent.mm.bd.a.getDensity(MMApplicationLike.applicationLike.getApplication())) * 64);
    public TextView dtY;
    public TextView dtZ;
    public MMImageView okd;
    public TextView oke;
    public View okf;
    public boolean okg;

    public f(int i) {
        super(i);
    }

    public final f n(View view, boolean z) {
        super.cM(view);
        this.okg = z;
        this.eTg = (TextView) this.kad.findViewById(2131755027);
        this.gfb = (CheckBox) view.findViewById(2131755022);
        this.fIV = this.kad.findViewById(2131755026);
        this.iJL = (TextView) this.kad.findViewById(2131755341);
        this.okd = (MMImageView) this.kad.findViewById(2131756199);
        this.dtY = (TextView) this.kad.findViewById(2131756200);
        this.dtZ = (TextView) this.kad.findViewById(2131756201);
        this.oke = (TextView) this.kad.findViewById(2131756202);
        this.okf = this.kad.findViewById(2131756198);
        return this;
    }

    public final void a(final Context context, com.tencent.mm.q.a.a aVar, String str, boolean z) {
        com.tencent.mm.ae.a.a GL;
        String w;
        ImageView imageView;
        c.a aVar2;
        switch (aVar.type) {
            case 16:
                if (aVar != null) {
                    this.dtY.setText(aVar.description);
                    this.dtZ.setText(aVar.cpn);
                    this.okd.setVisibility(0);
                    if (z) {
                        GL = n.GL();
                        w = n.GH().w(str, true);
                        imageView = this.okd;
                        aVar2 = new c.a();
                        aVar2.cPx = 1;
                        aVar2 = aVar2.aI(okh, okh);
                        aVar2.cPH = 2131165247;
                        aVar2.cPP = true;
                        GL.a(w, imageView, aVar2.GU());
                        return;
                    }
                    this.okd.setImageResource(2130838790);
                    return;
                }
                return;
            case 34:
                if (aVar.title == null || aVar.title.length() <= 0) {
                    this.dtY.setVisibility(8);
                } else {
                    this.dtY.setVisibility(0);
                    this.dtY.setText(aVar.title);
                    if (be.kS(aVar.cpw)) {
                        this.dtY.setTextColor(context.getResources().getColor(2131689547));
                    } else {
                        this.dtY.setTextColor(be.am(aVar.cpw, context.getResources().getColor(2131689547)));
                    }
                }
                this.dtZ.setMaxLines(2);
                this.dtZ.setVisibility(0);
                this.dtZ.setText(aVar.description);
                if (be.kS(aVar.cpx)) {
                    this.dtZ.setTextColor(context.getResources().getColor(2131689769));
                } else {
                    this.dtZ.setTextColor(be.am(aVar.cpx, context.getResources().getColor(2131689769)));
                }
                if (be.kS(aVar.cps)) {
                    this.oke.setText(2131231814);
                } else {
                    this.oke.setText(aVar.cps);
                }
                if (z) {
                    final Bitmap a = n.GH().a(str, com.tencent.mm.bd.a.getDensity(context), false);
                    if (!(a == null || a.isRecycled())) {
                        this.okd.setImageBitmap(d.a(a, false, (float) (a.getWidth() / 2)));
                    }
                    if (be.kS(aVar.cpv)) {
                        this.okf.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener(this) {
                            final /* synthetic */ f oki;

                            public final boolean onPreDraw() {
                                this.oki.okf.getViewTreeObserver().removeOnPreDrawListener(this);
                                int fromDPToPix = com.tencent.mm.bd.a.fromDPToPix(context, 24);
                                Bitmap bitmap = a;
                                if (bitmap == null || bitmap.isRecycled()) {
                                    bitmap = d.Q(context.getResources().getColor(2131689615), fromDPToPix, fromDPToPix);
                                }
                                int height = bitmap.getHeight();
                                if (fromDPToPix <= height) {
                                    height = fromDPToPix;
                                }
                                Bitmap c = d.c(d.H(Bitmap.createScaledBitmap(bitmap, height, height, true)), 20);
                                height = this.oki.okf.getHeight();
                                int width = this.oki.okf.getWidth();
                                if (height == 0) {
                                    height = com.tencent.mm.bd.a.N(context, 2131493391);
                                }
                                if (width == 0) {
                                    width = com.tencent.mm.bd.a.N(context, 2131493392);
                                }
                                if (this.oki.okg) {
                                    bitmap = d.a(c, 2130837914, width, height);
                                } else {
                                    bitmap = d.a(c, 2130837939, width, height);
                                }
                                this.oki.okf.setBackgroundDrawable(new BitmapDrawable(bitmap));
                                return true;
                            }
                        });
                        return;
                    }
                    GL = n.GL();
                    w = aVar.cpv;
                    imageView = new ImageView(context);
                    aVar2 = new c.a();
                    aVar2.cPs = true;
                    GL.a(w, imageView, aVar2.GU(), new g(this) {
                        final /* synthetic */ f oki;

                        public final void jk(String str) {
                        }

                        public final void a(String str, View view, b bVar) {
                            if (bVar.bitmap != null) {
                                final Bitmap bitmap = bVar.bitmap;
                                this.oki.okf.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener(this) {
                                    final /* synthetic */ AnonymousClass1 okj;

                                    public final boolean onPreDraw() {
                                        Bitmap a;
                                        this.okj.oki.okf.getViewTreeObserver().removeOnPreDrawListener(this);
                                        int height = this.okj.oki.okf.getHeight();
                                        int width = this.okj.oki.okf.getWidth();
                                        if (height == 0) {
                                            height = com.tencent.mm.bd.a.N(context, 2131493391);
                                        }
                                        if (width == 0) {
                                            width = com.tencent.mm.bd.a.N(context, 2131493392);
                                        }
                                        if (this.okj.oki.okg) {
                                            a = d.a(bitmap, 2130837914, width, height);
                                        } else {
                                            a = d.a(bitmap, 2130837939, width, height);
                                        }
                                        this.okj.oki.okf.setBackgroundDrawable(new BitmapDrawable(a));
                                        return true;
                                    }
                                });
                            }
                        }
                    });
                    return;
                }
                this.okd.setImageBitmap(BitmapFactory.decodeResource(context.getResources(), 2130838790));
                return;
            default:
                if (aVar != null) {
                    this.dtY.setText(aVar.description);
                    this.dtZ.setText(aVar.cpn);
                    this.okd.setVisibility(0);
                    if (z) {
                        GL = n.GL();
                        w = n.GH().w(str, true);
                        imageView = this.okd;
                        aVar2 = new c.a();
                        aVar2.cPx = 1;
                        aVar2 = aVar2.aI(okh, okh);
                        aVar2.cPH = 2131165247;
                        aVar2.cPP = true;
                        GL.a(w, imageView, aVar2.GU());
                        return;
                    }
                    this.okd.setImageResource(2130838790);
                    return;
                }
                return;
        }
    }
}
