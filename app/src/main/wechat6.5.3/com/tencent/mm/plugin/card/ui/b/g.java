package com.tencent.mm.plugin.card.ui.b;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.bb.a.a;
import com.tencent.mm.plugin.card.b.j;
import com.tencent.mm.plugin.card.b.k;
import com.tencent.mm.plugin.card.b.n;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.ui.i;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;

public final class g extends f {
    b eBg;
    MMActivity eBk;
    private View eEY;
    private View eEZ;
    private View eFa;
    private Bitmap eFb;
    private Bitmap eFc;
    private OnLongClickListener eFm = new OnLongClickListener(this) {
        final /* synthetic */ g eMH;

        {
            this.eMH = r1;
        }

        public final boolean onLongClick(View view) {
            if (view.getId() == 2131755756) {
                n.O(this.eMH.eBk, this.eMH.eBg.Zw().code);
                com.tencent.mm.ui.base.g.bf(this.eMH.eBk, this.eMH.getString(2131231016));
            }
            return false;
        }
    };
    private i eIs;
    private View eMG;

    public final void destroy() {
        super.destroy();
        this.eBk = null;
        this.eIs = null;
        this.eBg = null;
        j.l(this.eFb);
        j.l(this.eFc);
    }

    public final void NI() {
        this.eBk = this.eMF.abt();
        this.eIs = this.eMF.abz();
    }

    public final void acF() {
        if (this.eEY != null) {
            this.eEY.setVisibility(8);
        }
        if (this.eEZ != null) {
            this.eEZ.setVisibility(8);
        }
        if (this.eFa != null) {
            this.eFa.setVisibility(8);
        }
        if (this.eMG != null) {
            this.eMG.setVisibility(8);
        }
    }

    public final void update() {
        this.eBg = this.eMF.abq();
        String str = this.eBg.Zw().code;
        View view;
        ImageView imageView;
        TextView textView;
        switch (this.eBg.Zw().mkn) {
            case 0:
                if (this.eFa == null) {
                    this.eFa = ((ViewStub) findViewById(2131755816)).inflate();
                }
                TextView textView2 = (TextView) this.eFa.findViewById(2131755756);
                textView2.setText(k.qD(str));
                textView2.setOnLongClickListener(this.eFm);
                if (str.length() > 12) {
                    if (str.length() <= 12 || str.length() > 16) {
                        if (str.length() <= 16 || str.length() > 20) {
                            if (str.length() <= 20 || str.length() > 40) {
                                if (str.length() > 40) {
                                    textView2.setVisibility(8);
                                    break;
                                }
                            }
                            textView2.setTextSize(1, 18.0f);
                            break;
                        }
                        textView2.setTextSize(1, 24.0f);
                        break;
                    }
                    textView2.setTextSize(1, 30.0f);
                    break;
                }
                textView2.setTextSize(1, 33.0f);
                break;
                break;
            case 1:
                if (this.eEZ == null) {
                    this.eEZ = ((ViewStub) findViewById(2131755815)).inflate();
                }
                view = this.eEZ;
                imageView = (ImageView) view.findViewById(2131755754);
                textView = (TextView) view.findViewById(2131755756);
                if (TextUtils.isEmpty(str) || str.length() > 40) {
                    textView.setVisibility(8);
                } else {
                    textView.setText(k.qD(str));
                    if (this.eBg.Zk()) {
                        textView.setVisibility(0);
                        textView.setOnLongClickListener(this.eFm);
                    } else {
                        textView.setVisibility(8);
                    }
                }
                try {
                    j.l(this.eFc);
                    if (str != null && str.length() > 0) {
                        this.eFc = a.b(this.eBk, str, 5, 0);
                    }
                    a(imageView, this.eFc);
                    imageView.setOnClickListener(this.eMF.abu());
                    this.eIs.eFc = this.eFc;
                } catch (Throwable e) {
                    v.a("MicroMsg.CardCodeView", e, "", new Object[0]);
                }
                this.eIs.abQ();
                break;
            case 2:
                if (this.eEY == null) {
                    this.eEY = ((ViewStub) findViewById(2131755814)).inflate();
                }
                view = this.eEY;
                imageView = (ImageView) view.findViewById(2131755758);
                textView = (TextView) view.findViewById(2131755756);
                if (str.length() <= 40) {
                    textView.setText(k.qD(str));
                    if (this.eBg.Zk()) {
                        textView.setVisibility(0);
                        textView.setOnLongClickListener(this.eFm);
                    } else {
                        textView.setVisibility(8);
                    }
                } else {
                    textView.setVisibility(8);
                }
                try {
                    j.l(this.eFb);
                    this.eFb = a.b(this.eBk, str, 0, 3);
                    a(imageView, this.eFb);
                    imageView.setOnClickListener(this.eMF.abu());
                    this.eIs.eFb = this.eFb;
                } catch (Throwable e2) {
                    v.a("MicroMsg.CardCodeView", e2, "", new Object[0]);
                }
                this.eIs.abQ();
                break;
        }
        if (this.eMG == null) {
            this.eMG = findViewById(2131755817);
            this.eMG.setVisibility(0);
        }
    }

    private static void a(ImageView imageView, Bitmap bitmap) {
        if (imageView != null && bitmap != null) {
            imageView.setImageBitmap(bitmap);
        }
    }
}
