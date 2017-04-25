package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import com.tencent.mm.bf.e;
import com.tencent.mm.sdk.platformtools.aa;

final class h extends com.tencent.mm.plugin.webview.ui.tools.widget.input.c {
    private static final int dYk = aa.getContext().getResources().getDimensionPixelSize(2131493169);
    private e dYj = null;

    private static final class a extends e {
        private String[] dYl;

        a() {
            super(new c(aa.getContext()));
            this.dYl = null;
            this.dYl = aa.getContext().getResources().getStringArray(2131296284);
        }

        public final void Th() {
        }

        public final int Ti() {
            return this.dYl != null ? this.dYl.length : 0;
        }

        public final Drawable hH(int i) {
            return new b(hI(i), h.dYk);
        }

        public final String hI(int i) {
            if (this.dYl == null || i < 0 || i > this.dYl.length - 1) {
                return "";
            }
            String[] split = this.dYl[i].split(" ");
            char[] toChars = Character.toChars(Integer.decode(split[0]).intValue());
            return toChars + Character.toChars(Integer.decode(split[1]).intValue());
        }

        public final String getText(int i) {
            return hI(i);
        }

        public final String hJ(int i) {
            return hI(i);
        }
    }

    private static final class b extends Drawable {
        private final String dVK;
        private final TextPaint dYm;
        private Rect dYn;
        private final int hO;

        private b(String str, int i) {
            this.dVK = str;
            this.hO = i;
            this.dYm = new TextPaint();
            this.dYm.setAntiAlias(true);
            this.dYm.setTextAlign(Align.CENTER);
            this.dYm.setTextSize((float) this.hO);
            this.dYn = new Rect();
            this.dYm.getTextBounds(this.dVK, 0, this.dVK.length(), this.dYn);
        }

        public final int getIntrinsicWidth() {
            return this.dYn.width();
        }

        public final int getIntrinsicHeight() {
            return this.dYn.height();
        }

        public final void draw(Canvas canvas) {
            canvas.drawText(this.dVK, (float) (getBounds().width() / 2), ((float) (getBounds().height() / 2)) - ((this.dYm.descent() + this.dYm.ascent()) / 2.0f), this.dYm);
        }

        public final void setAlpha(int i) {
            this.dYm.setAlpha(i);
        }

        public final void setColorFilter(ColorFilter colorFilter) {
            this.dYm.setColorFilter(colorFilter);
        }

        public final int getOpacity() {
            return -3;
        }
    }

    private static final class c extends ContextWrapper {
        private Resources BE;

        public c(Context context) {
            super(context);
        }

        public final Resources getResources() {
            if (this.BE != null && (this.BE instanceof d)) {
                return this.BE;
            }
            Resources resources = super.getResources();
            this.BE = new d(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
            return this.BE;
        }
    }

    private static final class d extends Resources {
        d(AssetManager assetManager, DisplayMetrics displayMetrics, Configuration configuration) {
            super(assetManager, displayMetrics, configuration);
        }

        public final String[] getStringArray(int i) {
            if (2131296282 == i) {
                return new String[0];
            }
            if (2131296283 == i) {
                return new String[0];
            }
            return super.getStringArray(i);
        }
    }

    h() {
    }

    protected final e Tg() {
        if (this.dYj == null) {
            this.dYj = new a();
        }
        return this.dYj;
    }
}
