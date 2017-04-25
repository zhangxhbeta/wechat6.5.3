package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public final class t extends j {
    TextView eux;
    private RelativeLayout jzi;
    ImageView jzj;

    public t(Context context, o oVar, ViewGroup viewGroup) {
        super(context, oVar, viewGroup);
        this.jxU = oVar;
    }

    protected final int aGY() {
        return 2130904425;
    }

    public final void aTU() {
        super.aTU();
    }

    protected final void aTS() {
        this.eux.setText(((o) this.jxU).label);
        this.eux.setTextSize(0, ((o) this.jxU).jvr);
        if (((o) this.jxU).dCB != null && ((o) this.jxU).dCB.length() > 0) {
            this.jzi.setBackgroundColor(Color.parseColor(((o) this.jxU).dCB));
        }
        d.a(((o) this.jxU).jvT, ((o) this.jxU).jvH, new a(this) {
            final /* synthetic */ t jzk;

            {
                this.jzk = r1;
            }

            public final void aRx() {
            }

            public final void aTV() {
            }

            public final void Bg(String str) {
                try {
                    this.jzk.jzj.setImageBitmap(BitmapFactory.decodeFile(str));
                    TextView textView = this.jzk.eux;
                    Paint paint = new Paint();
                    String charSequence = textView.getText().toString();
                    paint.setTextSize(textView.getTextSize());
                    float measureText = (this.jzk.jxU.jvM - paint.measureText(charSequence, 0, charSequence.length())) - TypedValue.applyDimension(1, 3.0f, this.jzk.context.getResources().getDisplayMetrics());
                    int i = (int) (measureText - (((o) this.jzk.jxU).value * measureText));
                    LayoutParams layoutParams = (LayoutParams) this.jzk.jzj.getLayoutParams();
                    layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin, i, layoutParams.leftMargin);
                    this.jzk.jzj.setLayoutParams(layoutParams);
                } catch (Throwable e) {
                    v.e("MicroMsg.Sns.AdLandingPageProcessBarComponent", "%s" + be.e(e));
                }
            }
        });
    }

    public final View aTM() {
        View view = this.dtW;
        view.setBackgroundColor(this.backgroundColor);
        this.eux = (TextView) view.findViewById(2131759247);
        this.jzi = (RelativeLayout) view.findViewById(2131759248);
        this.jzj = (ImageView) view.findViewById(2131759249);
        return view;
    }

    public final void aTO() {
        super.aTO();
    }

    public final void aTP() {
        super.aTP();
    }
}
