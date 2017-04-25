package com.tencent.mm.plugin.wallet_core.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.d;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class b {

    static class a implements com.tencent.mm.platformtools.j.a {
        public TextView kGA = null;
        public TextView kGs = null;
        public TextView kGt = null;
        public TextView kGu = null;
        public RelativeLayout kGv = null;
        public ImageView kGw = null;
        public ImageView kGx = null;
        public TextView kGy = null;
        public TextView kGz = null;
        public d kWx;

        a() {
        }

        public final void k(String str, final Bitmap bitmap) {
            v.d("MicroMsg.BankcardListAdapter", str + ", bitmap = " + (bitmap == null));
            if (this.kWx != null) {
                if (str.equals(this.kWx.hGg)) {
                    this.kGx.post(new Runnable(this) {
                        final /* synthetic */ a kWy;

                        public final void run() {
                            this.kWy.kGx.setImageBitmap(bitmap);
                            this.kWy.kGv.invalidate();
                        }
                    });
                }
                if (str.equals(this.kWx.kNG) && this.kGw != null) {
                    this.kGw.post(new Runnable(this) {
                        final /* synthetic */ a kWy;

                        public final void run() {
                            this.kWy.kGw.setImageBitmap(bitmap);
                        }
                    });
                }
            }
        }
    }

    public static View a(Context context, View view, Bankcard bankcard, int i, com.tencent.mm.plugin.wallet_core.d.a aVar) {
        a aVar2;
        if (view == null || view.getTag() == null) {
            view = View.inflate(context, i, null);
            a aVar3 = new a();
            aVar3.kGx = (ImageView) view.findViewById(2131759803);
            aVar3.kGt = (TextView) view.findViewById(2131759804);
            aVar3.kGu = (TextView) view.findViewById(2131759805);
            aVar3.kGs = (TextView) view.findViewById(2131759806);
            aVar3.kGy = (TextView) view.findViewById(2131759810);
            aVar3.kGv = (RelativeLayout) view.findViewById(2131759801);
            aVar3.kGw = (ImageView) view.findViewById(2131759802);
            aVar3.kGz = (TextView) view.findViewById(2131759811);
            view.setTag(aVar3);
            aVar2 = aVar3;
        } else {
            aVar2 = (a) view.getTag();
        }
        if (bankcard.field_bankcardState == 1) {
            aVar2.kGy.setVisibility(0);
        } else {
            aVar2.kGy.setVisibility(8);
        }
        aVar2.kGt.setText(bankcard.field_bankName);
        if (k.xT()) {
            aVar2.kGu.setVisibility(8);
        } else if (!be.kS(bankcard.field_bankcardTypeName)) {
            aVar2.kGu.setText(bankcard.field_bankcardTypeName);
        } else if (bankcard.bfF()) {
            aVar2.kGu.setText(2131236550);
        } else if (bankcard.bfH()) {
            aVar2.kGu.setText(2131236153);
        } else {
            aVar2.kGu.setText(2131236167);
        }
        if (aVar2.kGs != null) {
            aVar2.kGs.setText(bankcard.field_bankcardTail);
        }
        aVar.a(context, bankcard, aVar2.kGx, aVar2.kGv, aVar2.kGw);
        if (aVar2.kGz != null) {
            com.tencent.mm.plugin.wallet_core.model.k.bga();
            String str = bankcard.field_bindSerial;
            aVar2.kGz.setVisibility(8);
        }
        return view;
    }

    public static Drawable e(Context context, Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        try {
            byte[] ninePatchChunk = bitmap.getNinePatchChunk();
            if (!NinePatch.isNinePatchChunk(ninePatchChunk)) {
                return new BitmapDrawable(bitmap);
            }
            Drawable ninePatchDrawable = new NinePatchDrawable(context.getResources(), bitmap, ninePatchChunk, new Rect(), null);
            ninePatchDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
            return ninePatchDrawable;
        } catch (Throwable e) {
            v.f("MicroMsg.BankcardListAdapter", e.getMessage());
            v.a("MicroMsg.BankcardListAdapter", e, "", new Object[0]);
            return null;
        }
    }
}
