package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.bd.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view.RadarChart;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.view.RadarGrid;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public final class y extends c {
    private static final int jAl = Color.parseColor("#26eae9e2");
    private CountDownLatch fwY;
    private RadarChart jAm;
    private Bitmap jAn;
    private Bitmap jAo;

    static /* synthetic */ void a(y yVar, Bitmap bitmap, Bitmap bitmap2) {
        s sVar = (s) yVar.aTL();
        RadarChart radarChart = yVar.jAm;
        radarChart.jxb = 0;
        radarChart.jxd = null;
        radarChart.jwU = null;
        radarChart.jwS = null;
        yVar.jAm.jxc = 5;
        c cVar = new c();
        cVar.jwx = 0;
        int parseColor = Color.parseColor(sVar.jwh);
        int i = 1442840575 & parseColor;
        parseColor &= Integer.MAX_VALUE;
        cVar.backgroundColor = i;
        cVar.jwC = jAl;
        cVar.jwG = 1.0f;
        cVar.jwR = bitmap2;
        cVar.jwD = jAl;
        cVar.jwE = jAl;
        cVar.jwF = (float) a.fromDPToPix(yVar.context, 1);
        cVar.jwH = -1;
        cVar.jwJ = 30.0f;
        cVar.jwI = 40.0f;
        cVar.jwN = bitmap;
        cVar.jwO = sVar.jwg;
        cVar.jwP = Color.parseColor("#7feae9e2");
        cVar.jwQ = a.fromDPToPix(yVar.context, 1);
        RadarChart radarChart2 = yVar.jAm;
        radarChart2.jwT = cVar;
        if (radarChart2.jwV != null) {
            RadarGrid radarGrid = radarChart2.jwV;
            radarGrid.jxf = cVar;
            radarGrid.invalidate();
        }
        b bVar = new b();
        bVar.jwr = jAl;
        bVar.jws = 1.0f;
        bVar.jwt = parseColor;
        bVar.jwu = 127;
        bVar.jwv = Color.parseColor("#00fcff");
        bVar.jww = a.fromDPToPix(yVar.context, 2);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(sVar.jwi);
        ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(sVar.jwk);
        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(sVar.jwj);
        AbsoluteSizeSpan absoluteSizeSpan2 = new AbsoluteSizeSpan(sVar.jwl);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a aVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a(bVar);
        StringBuilder stringBuilder = new StringBuilder();
        for (s.a aVar2 : sVar.iBY) {
            if (aVar2 != null) {
                stringBuilder.delete(0, stringBuilder.length());
                stringBuilder.append(aVar2.label).append(":").append(aVar2.jwn);
                Spannable spannableString = new SpannableString(stringBuilder.toString());
                a(spannableString, 0, aVar2.label.length() + 1, foregroundColorSpan, absoluteSizeSpan);
                a(spannableString, aVar2.label.length() + 1, stringBuilder.length(), foregroundColorSpan2, absoluteSizeSpan2);
                aVar.put(spannableString, Float.valueOf(aVar2.value));
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(aVar);
        try {
            yVar.jAm.a((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a[]) arrayList.toArray(new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.chart.a.a[arrayList.size()]));
        } catch (Throwable e) {
            Log.getStackTraceString(e);
        }
        yVar.jAm.jxa = 2;
    }

    public y(Context context, s sVar, ViewGroup viewGroup) {
        super(context, sVar, viewGroup);
    }

    public final View aTM() {
        this.jAm = (RadarChart) this.dtW.findViewById(2131759235);
        return this.dtW;
    }

    protected final void aTS() {
        this.fwY = new CountDownLatch(2);
        e.c(new Runnable(this) {
            final /* synthetic */ y jAp;

            {
                this.jAp = r1;
            }

            public final void run() {
                try {
                    this.jAp.fwY.await();
                } catch (InterruptedException e) {
                }
                this.jAp.dtW.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 jAq;

                    {
                        this.jAq = r1;
                    }

                    public final void run() {
                        y.a(this.jAq.jAp, this.jAq.jAp.jAn, this.jAq.jAp.jAo);
                    }
                });
            }
        }, "AdlandingRadarComp").start();
        s sVar = (s) aTL();
        if (sVar != null) {
            d.a(sVar.jwf, sVar.jvH, new d.a(this) {
                final /* synthetic */ y jAp;

                {
                    this.jAp = r1;
                }

                public final void aRx() {
                }

                public final void aTV() {
                    this.jAp.jAn = null;
                    this.jAp.fwY.countDown();
                }

                public final void Bg(String str) {
                    try {
                        this.jAp.jAn = BitmapFactory.decodeFile(str);
                        this.jAp.fwY.countDown();
                    } catch (Throwable e) {
                        v.e("AdlandingRadarChartComp", "%s" + be.e(e));
                    }
                }
            });
            d.a(sVar.jwm, sVar.jvH, new d.a(this) {
                final /* synthetic */ y jAp;

                {
                    this.jAp = r1;
                }

                public final void aRx() {
                }

                public final void aTV() {
                    this.jAp.jAo = null;
                    this.jAp.fwY.countDown();
                }

                public final void Bg(String str) {
                    try {
                        this.jAp.jAo = BitmapFactory.decodeFile(str);
                        this.jAp.fwY.countDown();
                    } catch (Throwable e) {
                        v.e("AdlandingRadarChartComp", "%s" + be.e(e));
                    }
                }
            });
            return;
        }
        Log.wtf("AdlandingRadarChartComp", "null info");
    }

    protected final int aGY() {
        return 2130904418;
    }

    private static void a(Spannable spannable, int i, int i2, Object... objArr) {
        for (int i3 = 0; i3 < 2; i3++) {
            spannable.setSpan(objArr[i3], i, i2, 18);
        }
    }
}
