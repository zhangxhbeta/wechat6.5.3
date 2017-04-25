package com.tencent.mm.plugin.appbrand.jsapi;

import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.model.o;
import com.tencent.mm.model.o.b;
import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.plugin.appbrand.page.h;
import com.tencent.mm.plugin.appbrand.widget.input.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import org.json.JSONObject;

public final class bp extends a {
    private static final int CTRL_INDEX = 105;
    private static final String NAME = "showToast";
    static View dIN;
    ah dIO;

    public final void a(f fVar, JSONObject jSONObject, int i) {
        final h a = d.a(fVar);
        if (a == null) {
            v.w("MicroMsg.JsApiShowToast", "invoke JsApi JsApiShowToast failed, current page view is null.");
            fVar.y(i, c("fail", null));
            return;
        }
        e.m(a);
        final int optInt = jSONObject.optInt("duration", 1500);
        final String optString = jSONObject.optString("title");
        final String optString2 = jSONObject.optString("icon", "success");
        final String optString3 = jSONObject.optString(SlookAirButtonRecentMediaAdapter.IMAGE_TYPE);
        final boolean optBoolean = jSONObject.optBoolean("mask");
        final b n = o.yx().n(fVar.hashCode() + "toast_name", true);
        final f fVar2 = fVar;
        final int i2 = i;
        ad.o(new Runnable(this) {
            final /* synthetic */ bp dIU;

            public final void run() {
                synchronized (this) {
                    if (bp.dIN != null) {
                        bp.dIN.setVisibility(8);
                        a.dMW.removeView(bp.dIN);
                        bp.dIN = null;
                        if (this.dIU.dIO != null) {
                            this.dIU.dIO.QI();
                        }
                    }
                    bp.dIN = LayoutInflater.from(d.nt(fVar2.dzg)).inflate(2130903116, null);
                    n.l("toast_view", bp.dIN);
                    if (optBoolean) {
                        bp.dIN.setLayoutParams(new LayoutParams(-1, -1));
                        ((LinearLayout) bp.dIN.findViewById(2131755401)).setBackgroundColor(fVar2.mContext.getResources().getColor(2131690078));
                        bp.dIN.setOnTouchListener(new OnTouchListener(this) {
                            final /* synthetic */ AnonymousClass1 dIV;

                            {
                                this.dIV = r1;
                            }

                            public final boolean onTouch(View view, MotionEvent motionEvent) {
                                return true;
                            }
                        });
                    }
                    TextView textView = (TextView) bp.dIN.findViewById(2131755226);
                    if (!be.kS(optString)) {
                        textView.setText(optString);
                        textView.setVisibility(0);
                    }
                    ImageView imageView = (ImageView) bp.dIN.findViewById(2131755402);
                    if (!be.kS(optString3)) {
                        WebResourceResponse ar = com.tencent.mm.plugin.appbrand.appcache.b.ar(fVar2.dzg, optString3);
                        if (ar != null) {
                            imageView.setImageBitmap(BitmapFactory.decodeStream(ar.getData()));
                        }
                    } else if (optString2.equals("loading")) {
                        imageView.setImageResource(2130838933);
                        Animation rotateAnimation = new RotateAnimation(0.0f, 359.0f, 1, 0.5f, 1, 0.5f);
                        rotateAnimation.setDuration(1000);
                        rotateAnimation.setRepeatCount(-1);
                        rotateAnimation.setInterpolator(new LinearInterpolator());
                        imageView.startAnimation(rotateAnimation);
                    } else {
                        imageView.setImageResource(2131165277);
                    }
                    a.dMW.addView(bp.dIN);
                    this.dIU.dIO = new ah(new a(this) {
                        final /* synthetic */ AnonymousClass1 dIV;

                        {
                            this.dIV = r1;
                        }

                        public final boolean oU() {
                            bp.dIN.setVisibility(8);
                            o.yx().fy(fVar2.hashCode() + "toast_name");
                            v.d("MicroMsg.JsApiShowToast", "on timer expired!");
                            return true;
                        }
                    }, false);
                    this.dIU.dIO.ea((long) optInt);
                    fVar2.y(i2, this.dIU.c("ok", null));
                }
            }
        });
    }
}
