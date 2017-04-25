package com.tencent.mm.plugin.appbrand.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.report.a;

public final class c extends a {
    public final /* bridge */ /* synthetic */ View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public final void onResume() {
        super.onResume();
        aG().setTitle(2131230936);
    }

    final void NI() {
        View linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        View imageView = new ImageView(getContext());
        imageView.setImageResource(2131165261);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(ho(50), ho(50));
        layoutParams.topMargin = ho(91);
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        imageView = new TextView(getContext());
        imageView.setTextSize(2, 14.0f);
        imageView.setTextColor(Color.parseColor("#B2B2B2"));
        imageView.setGravity(17);
        imageView.setText(2131230951);
        layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = ho(16);
        layoutParams.gravity = 1;
        linearLayout.addView(imageView, layoutParams);
        ((ViewGroup) this.Hq).addView(linearLayout, new LayoutParams(-1, -1));
        a.j(this.cVh, "", "");
    }
}
