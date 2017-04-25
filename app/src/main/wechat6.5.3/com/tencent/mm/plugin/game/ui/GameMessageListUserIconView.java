package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import com.tencent.mm.a.f;
import com.tencent.mm.plugin.game.c.n;
import com.tencent.mm.plugin.game.c.n.g;
import com.tencent.mm.plugin.game.c.o;
import com.tencent.mm.plugin.game.c.o.a;
import com.tencent.mm.plugin.game.e.e;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.be;
import java.util.LinkedList;

public class GameMessageListUserIconView extends LinearLayout {
    o gvC;
    private f<String, Bitmap> gvD;
    Context mContext;

    public GameMessageListUserIconView(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public GameMessageListUserIconView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        init();
    }

    private void init() {
        if (this.gvC == null) {
            this.gvC = new o(this.mContext);
        }
    }

    public final void a(n nVar, LinkedList<g> linkedList, f<String, Bitmap> fVar) {
        if (nVar == null || be.bP(linkedList)) {
            setVisibility(8);
            return;
        }
        this.gvD = fVar;
        setVisibility(0);
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(2131493125);
        int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(2131492962);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
        layoutParams.rightMargin = dimensionPixelSize2;
        while (getChildCount() < linkedList.size()) {
            View imageView = new ImageView(this.mContext);
            imageView.setLayoutParams(layoutParams);
            imageView.setScaleType(ScaleType.FIT_XY);
            imageView.setOnClickListener(this.gvC);
            addView(imageView);
        }
        for (int i = 0; i < getChildCount(); i++) {
            ImageView imageView2 = (ImageView) getChildAt(i);
            if (i < linkedList.size()) {
                imageView2.setVisibility(0);
                g gVar = (g) linkedList.get(i);
                String str;
                Bitmap bitmap;
                if (be.kS(gVar.gjh)) {
                    str = gVar.userName;
                    if (be.kS(str)) {
                        b.m(imageView2, str);
                    } else if (this.gvD.aI(str)) {
                        bitmap = (Bitmap) this.gvD.get(str);
                        if (bitmap == null || bitmap.isRecycled()) {
                            b(imageView2, str);
                        } else {
                            imageView2.setImageBitmap(bitmap);
                        }
                    } else {
                        b(imageView2, str);
                    }
                } else {
                    str = gVar.gjh;
                    if (this.gvD.aI(str)) {
                        bitmap = (Bitmap) this.gvD.get(str);
                        if (bitmap == null || bitmap.isRecycled()) {
                            d(imageView2, str);
                        } else {
                            imageView2.setImageBitmap(bitmap);
                        }
                    } else {
                        d(imageView2, str);
                    }
                }
                if (be.kS(gVar.gjk)) {
                    imageView2.setEnabled(false);
                } else {
                    imageView2.setTag(new a(nVar, gVar.gjk, 6));
                    imageView2.setEnabled(true);
                }
            } else {
                imageView2.setVisibility(8);
            }
        }
    }

    private void d(ImageView imageView, final String str) {
        e.a.a aVar = new e.a.a();
        aVar.cPq = false;
        e.asK().a(imageView, str, aVar.asL(), new e.b(this) {
            final /* synthetic */ GameMessageListUserIconView gvZ;

            public final void m(Bitmap bitmap) {
                if (bitmap != null && !bitmap.isRecycled()) {
                    this.gvZ.gvD.put(str, bitmap);
                }
            }
        });
    }

    private void b(ImageView imageView, String str) {
        Bitmap f = e.asK().f(imageView, str);
        if (f != null) {
            this.gvD.put(str, f);
        }
    }
}
