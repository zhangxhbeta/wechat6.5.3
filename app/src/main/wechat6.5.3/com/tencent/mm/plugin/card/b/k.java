package com.tencent.mm.plugin.card.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ae.a.a.c.a;
import com.tencent.mm.ae.a.c.g;
import com.tencent.mm.ae.a.d.b;
import com.tencent.mm.ae.n;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.card.model.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;

public final class k {

    static class AnonymousClass1 implements g {
        final /* synthetic */ ImageView eNq;
        final /* synthetic */ int eNr;
        final /* synthetic */ int eNs = 2130837885;
        final /* synthetic */ Context val$context;

        AnonymousClass1(ImageView imageView, int i, Context context, int i2) {
            this.eNq = imageView;
            this.eNr = i;
            this.val$context = context;
        }

        public final void jk(String str) {
        }

        public final void a(String str, View view, b bVar) {
            if (bVar.bitmap != null) {
                final Bitmap bitmap = bVar.bitmap;
                ad.o(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 eNt;

                    public final void run() {
                        this.eNt.eNq.setImageBitmap(bitmap);
                        this.eNt.eNq.setColorFilter(this.eNt.eNr, Mode.SRC_IN);
                    }
                });
                return;
            }
            k.a(this.eNq, this.eNs, this.eNr);
        }
    }

    static class AnonymousClass3 implements AnimationListener {
        final /* synthetic */ View eNu;
        final /* synthetic */ ScaleAnimation eNv;

        public AnonymousClass3(View view, ScaleAnimation scaleAnimation) {
            this.eNu = view;
            this.eNv = scaleAnimation;
        }

        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationRepeat(Animation animation) {
        }

        public final void onAnimationEnd(Animation animation) {
            this.eNu.startAnimation(this.eNv);
        }
    }

    public static String qD(String str) {
        if (be.kS(str)) {
            v.e("MicroMsg.CardViewUtil", "toApply is null");
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            stringBuilder.append(str.charAt(i));
            if ((i + 1) % 4 == 0) {
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }

    public static void a(ImageView imageView, String str, int i, int i2, boolean z) {
        if (imageView != null && !TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str)) {
                imageView.setImageResource(i2);
                return;
            }
            a aVar = new a();
            aVar.cPv = e.cnj;
            n.GM();
            aVar.cPN = null;
            aVar.cPu = i.pR(str);
            aVar.cPs = true;
            aVar.cPP = z;
            aVar.cPq = true;
            aVar.cPz = i;
            aVar.cPy = i;
            aVar.cPH = i2;
            n.GL().a(str, imageView, aVar.GU());
        }
    }

    public static void a(Context context, ImageView imageView, String str, int i, int i2) {
        if (imageView != null && !TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str)) {
                a(imageView, 2130837885, i2);
                return;
            }
            a aVar = new a();
            aVar.cPv = e.cnj;
            n.GM();
            aVar.cPN = null;
            aVar.cPu = i.pR(str);
            aVar.cPs = true;
            aVar.cPP = false;
            aVar.cPq = true;
            aVar.cPz = i;
            aVar.cPy = i;
            aVar.cPH = 2130837885;
            n.GL().a(str, imageView, aVar.GU(), new AnonymousClass1(imageView, i2, context, 2130837885));
        }
    }

    public static void a(final ImageView imageView, final int i, final int i2) {
        ad.o(new Runnable() {
            public final void run() {
                imageView.setImageResource(i);
                imageView.setColorFilter(i2, Mode.SRC_IN);
            }
        });
    }

    public static void a(MMActivity mMActivity, com.tencent.mm.plugin.card.base.b bVar) {
        a(mMActivity, j.qv(bVar.Zv().coN));
    }

    public static void a(MMActivity mMActivity, int i) {
        mMActivity.cU().cV().setBackgroundDrawable(null);
        Drawable shapeDrawable = new ShapeDrawable();
        shapeDrawable.getPaint().setColor(i);
        mMActivity.cU().cV().setBackgroundDrawable(shapeDrawable);
        View customView = mMActivity.cU().cV().getCustomView();
        if (customView != null) {
            View findViewById = customView.findViewById(2131755264);
            if (findViewById != null) {
                findViewById.setBackgroundColor(mMActivity.getResources().getColor(2131689783));
            }
            findViewById = customView.findViewById(2131755285);
            if (findViewById != null) {
                ((ImageView) findViewById).setImageResource(2130837595);
            }
            findViewById = customView.findViewById(16908308);
            if (findViewById != null && (findViewById instanceof TextView)) {
                ((TextView) findViewById).setTextColor(mMActivity.getResources().getColor(2131690127));
            }
            findViewById = customView.findViewById(16908309);
            if (findViewById != null && (findViewById instanceof TextView)) {
                ((TextView) findViewById).setTextColor(mMActivity.getResources().getColor(2131690127));
            }
            customView.setBackgroundDrawable(shapeDrawable);
        }
    }

    public static void b(MMActivity mMActivity, int i) {
        mMActivity.cU().cV().setBackgroundDrawable(null);
        Drawable shapeDrawable = new ShapeDrawable();
        shapeDrawable.getPaint().setColor(i);
        mMActivity.cU().cV().setBackgroundDrawable(shapeDrawable);
        View customView = mMActivity.cU().cV().getCustomView();
        if (customView != null) {
            View findViewById = customView.findViewById(2131755264);
            if (findViewById != null) {
                findViewById.setBackgroundColor(mMActivity.getResources().getColor(2131689781));
            }
            findViewById = customView.findViewById(2131755285);
            if (findViewById != null) {
                ((ImageView) findViewById).setImageResource(2130837829);
            }
            findViewById = customView.findViewById(16908308);
            if (findViewById != null && (findViewById instanceof TextView)) {
                ((TextView) findViewById).setTextColor(mMActivity.getResources().getColor(2131689547));
            }
            findViewById = customView.findViewById(16908309);
            if (findViewById != null && (findViewById instanceof TextView)) {
                ((TextView) findViewById).setTextColor(mMActivity.getResources().getColor(2131689547));
            }
            customView.setBackgroundDrawable(shapeDrawable);
        }
    }

    public static void b(TextView textView, int i) {
        switch (i) {
            case 0:
                textView.setText(2131231707);
                return;
            case 1:
                textView.setText(2131231702);
                return;
            case 2:
                textView.setText(2131231705);
                return;
            case 3:
                textView.setText(2131231704);
                return;
            case 4:
                textView.setText(2131231708);
                return;
            case 5:
                textView.setText(2131231709);
                return;
            case 6:
                textView.setText(2131231703);
                return;
            case 7:
                textView.setText(2131231706);
                return;
            default:
                return;
        }
    }
}
