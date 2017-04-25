package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.ay.c;
import com.tencent.mm.bd.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.net.URI;

public class l extends k {
    RelativeLayout gUZ;
    Button jyb;

    public l(Context context, g gVar, ViewGroup viewGroup) {
        super(context, gVar, viewGroup);
    }

    protected final g aTY() {
        return (g) this.jxU;
    }

    protected final int aGY() {
        return 2130904420;
    }

    @TargetApi(17)
    protected final void aTS() {
        this.jya = 0;
        int width = ((WindowManager) this.context.getSystemService("window")).getDefaultDisplay().getWidth();
        this.gUZ.setBackgroundColor(this.backgroundColor);
        if (be.kS(((g) this.jxU).jvv)) {
            Drawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            if (((g) this.jxU).jvs == 0.0f) {
                ((g) this.jxU).jvs = (float) a.fromDPToPix(this.context, 1);
            }
            if (be.kS(((g) this.jxU).jvu)) {
                gradientDrawable.setStroke((int) ((g) this.jxU).jvs, Color.parseColor("#FFFFFF"));
            } else {
                int parseColor;
                try {
                    parseColor = Color.parseColor(((g) this.jxU).jvu);
                } catch (Throwable e) {
                    v.e("MicroMsg.Sns.AdLandingPageBtnComponent", be.e(e));
                    parseColor = 0;
                }
                gradientDrawable.setStroke((int) ((g) this.jxU).jvs, parseColor);
            }
            if (be.kS(((g) this.jxU).jvt)) {
                gradientDrawable.setColor(0);
            } else {
                int parseColor2;
                try {
                    parseColor2 = Color.parseColor(((g) this.jxU).jvt);
                } catch (Throwable e2) {
                    v.e("MicroMsg.Sns.AdLandingPageBtnComponent", be.e(e2));
                    parseColor2 = 0;
                }
                gradientDrawable.setColor(parseColor2);
            }
            this.jyb.setBackgroundDrawable(gradientDrawable);
        } else {
            d.a("adId", ((g) this.jxU).jvv, false, 0, 0, new d.a(this) {
                final /* synthetic */ l jyc;

                {
                    this.jyc = r1;
                }

                public final void aRx() {
                }

                public final void aTV() {
                }

                @TargetApi(16)
                public final void Bg(String str) {
                    try {
                        this.jyc.jyb.setBackground(Drawable.createFromPath(str));
                    } catch (Exception e) {
                        v.e("MicroMsg.Sns.AdLandingPageBtnComponent", "the backgroundCoverUrl is set error ,because " + e.toString());
                    }
                }
            });
        }
        this.jyb.setText(((g) this.jxU).title);
        d(this.jyb);
        this.jyb.setTextSize(0, ((g) this.jxU).jvr);
        if (((g) this.jxU).jvq != null && ((g) this.jxU).jvq.length() > 0) {
            this.jyb.setTextColor(Color.parseColor(((g) this.jxU).jvq));
        }
        try {
            this.jyb.setTextAlignment(4);
        } catch (Exception e3) {
            v.e("MicroMsg.Sns.AdLandingPageBtnComponent", "the device has no method btn.setTextAlignment");
        }
        this.jyb.setLayoutParams(new LayoutParams((width - ((int) ((g) this.jxU).jvK)) - ((int) ((g) this.jxU).jvL), this.jyb.getLayoutParams().height));
        this.dtW.setPadding((int) ((g) this.jxU).jvK, (int) ((g) this.jxU).jvI, (int) ((g) this.jxU).jvL, (int) ((g) this.jxU).jvJ);
    }

    protected void d(Button button) {
        button.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ l jyc;

            {
                this.jyc = r1;
            }

            public final void onClick(View view) {
                this.jyc.aTX();
                this.jyc.aTZ();
            }
        });
    }

    protected final void aTZ() {
        g gVar = (g) this.jxU;
        if (gVar.aYp == 4) {
            e eVar = (e) gVar;
            v.i("MicroMsg.Sns.AdLandingPageBtnComponent", "ext is " + eVar.eCX);
            Intent intent = new Intent();
            intent.putExtra("key_card_id", eVar.eGm);
            intent.putExtra("key_card_ext", eVar.eCX);
            intent.putExtra("key_from_scene", 21);
            intent.putExtra("key_stastic_scene", 15);
            c.b(this.context, "card", ".ui.CardDetailUI", intent);
            return;
        }
        String f;
        Intent intent2 = new Intent();
        String str = gVar.jvo;
        try {
            if (!(TextUtils.isEmpty(gVar.juo) || TextUtils.isEmpty(gVar.jup))) {
                f = f(str, "traceid=" + gVar.juo + "&aid=" + gVar.jup);
                v.i("MicroMsg.Sns.AdLandingPageBtnComponent", "open url %s", new Object[]{f});
                intent2.putExtra("rawUrl", f);
                intent2.putExtra("useJs", true);
                intent2.putExtra(Columns.TYPE, -255);
                intent2.putExtra("geta8key_scene", 2);
                com.tencent.mm.plugin.sns.b.a.drp.j(intent2, this.context);
            }
        } catch (Throwable e) {
            v.e("MicroMsg.Sns.AdLandingPageBtnComponent", be.e(e));
        }
        f = str;
        v.i("MicroMsg.Sns.AdLandingPageBtnComponent", "open url %s", new Object[]{f});
        intent2.putExtra("rawUrl", f);
        intent2.putExtra("useJs", true);
        intent2.putExtra(Columns.TYPE, -255);
        intent2.putExtra("geta8key_scene", 2);
        com.tencent.mm.plugin.sns.b.a.drp.j(intent2, this.context);
    }

    @TargetApi(17)
    public final View aTM() {
        View view = this.dtW;
        this.gUZ = (RelativeLayout) view.findViewById(2131759238);
        this.jyb = (Button) view.findViewById(2131759239);
        return view;
    }

    private static String f(String str, String... strArr) {
        URI uri = new URI(str);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <= 0; i++) {
            stringBuilder.append(strArr[0]).append("&");
        }
        if (stringBuilder.length() <= 1) {
            return str;
        }
        String stringBuilder2;
        StringBuilder deleteCharAt = stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        String query = uri.getQuery();
        if (query == null) {
            stringBuilder2 = deleteCharAt.toString();
        } else {
            stringBuilder2 = query + "&" + deleteCharAt.toString();
        }
        return new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), stringBuilder2, uri.getFragment()).toString();
    }
}
