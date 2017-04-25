package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.k.j;
import java.util.Iterator;
import java.util.LinkedList;

public final class d extends FrameLayout {
    private int QW = 0;
    public LinearLayout dVA;
    public ImageView dVB;
    public String dVC;
    public int dVD;
    public int dVE;
    public LinkedList<a> dVF = new LinkedList();
    private int dVG = 0;
    public b dVH;

    private static class a {
        public Bitmap dVJ;
        public String dVK;
        public String mUrl;
        public Bitmap us;

        private a() {
        }
    }

    public interface b {
        void nW(String str);
    }

    static /* synthetic */ void b(d dVar) {
        if (dVar.dVH != null) {
            dVar.dVH.nW(((a) dVar.dVF.get(dVar.dVG)).mUrl);
        }
    }

    public d(Context context) {
        super(context);
        setLayoutParams(new LayoutParams(-1, -2));
        this.dVB = new ImageView(context);
        this.dVB.setLayoutParams(new LayoutParams(-1, -1));
        addView(this.dVB);
        this.dVA = new LinearLayout(context);
        this.dVA.setOrientation(0);
        this.dVA.setGravity(16);
        this.dVA.setLayoutParams(new LayoutParams(-1, -2));
        addView(this.dVA);
    }

    public static Bitmap oG(String str) {
        byte[] decode = Base64.decode(str, 0);
        return BitmapFactory.decodeByteArray(decode, 0, decode.length);
    }

    public final void hA(int i) {
        a(this.dVA.getChildAt(this.dVG), (a) this.dVF.get(this.dVG), false);
        if (i <= 0 || i >= this.dVF.size()) {
            this.dVG = 0;
        } else {
            this.dVG = i;
        }
        a(this.dVA.getChildAt(this.dVG), (a) this.dVF.get(this.dVG), true);
    }

    public final void a(View view, a aVar, boolean z) {
        ImageView imageView = (ImageView) view.findViewById(2131755225);
        TextView textView = (TextView) view.findViewById(2131755098);
        View findViewById = view.findViewById(2131755410);
        View findViewById2 = view.findViewById(2131755409);
        if ("top".equals(this.dVC)) {
            view.setLayoutParams(new LinearLayout.LayoutParams(0, com.tencent.mm.bd.a.fromDPToPix(getContext(), 40), 1.0f));
            imageView.setVisibility(8);
            textView.setTextSize(1, 14.0f);
            findViewById2.setVisibility(0);
        } else {
            if (aVar.us != null && aVar.dVK != null) {
                view.setLayoutParams(new LinearLayout.LayoutParams(0, com.tencent.mm.bd.a.fromDPToPix(getContext(), 54), 1.0f));
                imageView.setVisibility(0);
                imageView.getLayoutParams().width = com.tencent.mm.bd.a.fromDPToPix(getContext(), 32);
                imageView.getLayoutParams().height = com.tencent.mm.bd.a.fromDPToPix(getContext(), 28);
                textView.setVisibility(0);
                textView.setTextSize(1, 12.0f);
            } else if (aVar.us != null && aVar.dVK == null) {
                view.setLayoutParams(new LinearLayout.LayoutParams(0, com.tencent.mm.bd.a.fromDPToPix(getContext(), 48), 1.0f));
                imageView.setVisibility(0);
                imageView.getLayoutParams().width = com.tencent.mm.bd.a.fromDPToPix(getContext(), 36);
                imageView.getLayoutParams().height = com.tencent.mm.bd.a.fromDPToPix(getContext(), 36);
                textView.setVisibility(8);
            } else if (aVar.us == null && aVar.dVK != null) {
                view.setLayoutParams(new LinearLayout.LayoutParams(0, com.tencent.mm.bd.a.fromDPToPix(getContext(), 49), 1.0f));
                imageView.setVisibility(8);
                textView.setVisibility(0);
                textView.setTextSize(1, 16.0f);
            }
            findViewById2.setVisibility(8);
        }
        if (!z || aVar.dVJ == null) {
            imageView.setImageBitmap(aVar.us);
        } else {
            imageView.setImageBitmap(aVar.dVJ);
        }
        textView.setText(aVar.dVK);
        if (z) {
            textView.setTextColor(this.dVE);
        } else {
            textView.setTextColor(this.dVD);
        }
        if (z) {
            findViewById.setBackgroundColor(this.dVE);
            findViewById.setVisibility(0);
            return;
        }
        findViewById.setVisibility(4);
    }

    public final int oH(String str) {
        Object obj;
        LinkedList linkedList = this.dVF;
        String ov = j.ov(str);
        Iterator it = this.dVF.iterator();
        while (it.hasNext()) {
            obj = (a) it.next();
            if (j.ov(obj.mUrl).equals(ov)) {
                break;
            }
        }
        obj = null;
        return linkedList.indexOf(obj);
    }
}
