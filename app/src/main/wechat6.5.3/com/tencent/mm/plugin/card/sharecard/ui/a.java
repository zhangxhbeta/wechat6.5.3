package com.tencent.mm.plugin.card.sharecard.ui;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.b.j;
import com.tencent.mm.plugin.card.b.k;
import com.tencent.mm.plugin.card.b.n;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import java.util.LinkedList;

public final class a {
    private final String TAG = "MicroMsg.CardConsumeCodeController";
    b eBg;
    MMActivity eBk;
    View eEX;
    private View eEY;
    private View eEZ;
    private View eFa;
    Bitmap eFb;
    Bitmap eFc;
    TextView eFd;
    TextView eFe;
    CheckBox eFf;
    String eFg;
    int eFh = 1;
    boolean eFi = false;
    a eFj;
    float eFk = 0.0f;
    OnClickListener eFl = new OnClickListener(this) {
        final /* synthetic */ a eFn;

        {
            this.eFn = r1;
        }

        public final void onClick(View view) {
            if (view.getId() != 2131755777) {
                return;
            }
            if (this.eFn.eFf.isChecked()) {
                if (this.eFn.eFj != null) {
                    this.eFn.eFj.ja(1);
                }
            } else if (this.eFn.eFj != null) {
                this.eFn.eFj.ja(0);
            }
        }
    };
    private OnLongClickListener eFm = new OnLongClickListener(this) {
        final /* synthetic */ a eFn;

        {
            this.eFn = r1;
        }

        public final boolean onLongClick(View view) {
            if (view.getId() == 2131755756) {
                n.O(this.eFn.eBk, this.eFn.eBg.Zw().code);
                g.bf(this.eFn.eBk, this.eFn.eBk.getString(2131231016));
            }
            return false;
        }
    };

    public interface a {
        void ja(int i);
    }

    public a(MMActivity mMActivity, View view) {
        this.eBk = mMActivity;
        this.eEX = view;
    }

    final void K(float f) {
        LayoutParams attributes = this.eBk.getWindow().getAttributes();
        attributes.screenBrightness = f;
        this.eBk.getWindow().setAttributes(attributes);
    }

    public final void aaI() {
        v.i("MicroMsg.CardConsumeCodeController", "doUpdate()");
        if (this.eFi) {
            String str;
            ImageView imageView;
            String str2;
            if (!be.kS(this.eBg.Zw().mkA)) {
                v.i("MicroMsg.CardConsumeCodeController", "code:%s from sign_number", new Object[]{this.eBg.Zw().mkA});
                str = str2;
            } else if (this.eBg.Zp()) {
                c aax = af.aax();
                if (aax.eAT == null || aax.eAT.size() == 0) {
                    v.e("MicroMsg.CardCodeMgr", "getCode, codes is empty");
                    str2 = "";
                } else if (aax.eAU >= aax.eAT.size()) {
                    v.e("MicroMsg.CardCodeMgr", "getCode, all codes has show! ");
                    aax.pG(aax.eAS);
                    str2 = "";
                } else {
                    if (aax.eAW >= aax.eAT.size() - aax.eAU) {
                        v.i("MicroMsg.CardCodeMgr", "do request code, because the request_count >= than (codes.size() - show_count)");
                        aax.pG(aax.eAS);
                    }
                    v.i("MicroMsg.CardCodeMgr", "getCode, show_count:" + aax.eAU + " request_count:" + aax.eAW + " codes size:" + aax.eAT.size());
                    LinkedList linkedList = aax.eAT;
                    int i = aax.eAU;
                    aax.eAU = i + 1;
                    str2 = (String) linkedList.get(i);
                }
                v.i("MicroMsg.CardConsumeCodeController", "code:%s from dynamic code", new Object[]{str2});
                str = str2;
            } else {
                v.i("MicroMsg.CardConsumeCodeController", "code:%s from dataInfo", new Object[]{this.eBg.Zw().code});
                str = str2;
            }
            View view;
            TextView textView;
            switch (this.eBg.Zw().mkn) {
                case 0:
                    if (this.eFa == null) {
                        this.eFa = ((ViewStub) this.eEX.findViewById(2131755771)).inflate();
                    }
                    TextView textView2 = (TextView) this.eFa.findViewById(2131755756);
                    textView2.setText(k.qD(str));
                    textView2.setOnLongClickListener(this.eFm);
                    if (!this.eBg.Zc()) {
                        textView2.setTextColor(j.qv(this.eBg.Zv().coN));
                    }
                    if (str.length() <= 12) {
                        textView2.setTextSize(1, 33.0f);
                    } else if (str.length() > 12 && str.length() <= 16) {
                        textView2.setTextSize(1, 30.0f);
                    } else if (str.length() > 16 && str.length() <= 20) {
                        textView2.setTextSize(1, 24.0f);
                    } else if (str.length() > 20 && str.length() <= 40) {
                        textView2.setTextSize(1, 18.0f);
                    } else if (str.length() > 40) {
                        textView2.setVisibility(8);
                    }
                    bO(this.eFa);
                    break;
                case 1:
                    if (this.eEZ == null) {
                        this.eEZ = ((ViewStub) this.eEX.findViewById(2131755769)).inflate();
                    }
                    view = this.eEZ;
                    imageView = (ImageView) view.findViewById(2131755754);
                    textView = (TextView) view.findViewById(2131755756);
                    if (!this.eBg.Zc()) {
                        textView.setTextColor(j.qv(this.eBg.Zv().coN));
                    }
                    if (TextUtils.isEmpty(str) || str.length() > 40) {
                        textView.setVisibility(8);
                    } else {
                        textView.setText(k.qD(str));
                        if (this.eBg.Zl()) {
                            textView.setVisibility(0);
                            textView.setOnLongClickListener(this.eFm);
                        } else {
                            textView.setVisibility(8);
                        }
                    }
                    if (this.eFh != 1) {
                        textView.setVisibility(4);
                    }
                    try {
                        j.l(this.eFc);
                        if (TextUtils.isEmpty(str)) {
                            this.eFc = null;
                            imageView.setImageBitmap(this.eFc);
                        } else {
                            this.eFc = com.tencent.mm.bb.a.a.b(this.eBk, str, 5, 0);
                            a(imageView, this.eFc);
                        }
                    } catch (Throwable e) {
                        v.a("MicroMsg.CardConsumeCodeController", e, "", new Object[0]);
                    }
                    bO(this.eEZ);
                    break;
                case 2:
                    if (this.eEY == null) {
                        this.eEY = ((ViewStub) this.eEX.findViewById(2131755767)).inflate();
                    }
                    view = this.eEY;
                    imageView = (ImageView) view.findViewById(2131755758);
                    textView = (TextView) view.findViewById(2131755756);
                    if (!this.eBg.Zc()) {
                        textView.setTextColor(j.qv(this.eBg.Zv().coN));
                    }
                    if (str.length() <= 40) {
                        textView.setText(k.qD(str));
                        if (this.eBg.Zl()) {
                            textView.setVisibility(0);
                            textView.setOnLongClickListener(this.eFm);
                        } else {
                            textView.setVisibility(8);
                        }
                    } else {
                        textView.setVisibility(8);
                    }
                    if (this.eFh != 1) {
                        textView.setVisibility(4);
                    }
                    try {
                        j.l(this.eFb);
                        if (TextUtils.isEmpty(str)) {
                            this.eFb = null;
                            imageView.setImageBitmap(this.eFb);
                        } else {
                            this.eFb = com.tencent.mm.bb.a.a.b(this.eBk, str, 0, 3);
                            a(imageView, this.eFb);
                        }
                    } catch (Throwable e2) {
                        v.a("MicroMsg.CardConsumeCodeController", e2, "", new Object[0]);
                    }
                    bO(this.eEY);
                    break;
            }
            if (be.kS(this.eBg.Zv().hbX)) {
                this.eFd.setVisibility(8);
                this.eFe.setVisibility(8);
            } else if (this.eBg.Zv().mlr != null) {
                this.eFe.setText(this.eBg.Zv().hbX);
                this.eFe.setVisibility(0);
                this.eFd.setVisibility(8);
                if (this.eEY != null) {
                    imageView = (ImageView) this.eEY.findViewById(2131755758);
                    ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                    layoutParams.height = com.tencent.mm.bd.a.fromDPToPix(this.eBk, 180);
                    layoutParams.width = com.tencent.mm.bd.a.fromDPToPix(this.eBk, 180);
                    imageView.setLayoutParams(layoutParams);
                }
            } else {
                this.eFd.setText(this.eBg.Zv().hbX);
                this.eFd.setVisibility(0);
            }
            if (!this.eBg.Zb() || TextUtils.isEmpty(this.eBg.ZB()) || this.eBg.ZB().equals(com.tencent.mm.model.k.xF())) {
                this.eFf.setChecked(false);
                this.eFf.setVisibility(8);
                return;
            }
            this.eFf.setVisibility(0);
            this.eFf.setText(e.d(this.eBk, " " + this.eBk.getString(2131231599, new Object[]{j.qy(this.eBg.ZB())}), this.eBk.getResources().getDimensionPixelOffset(2131493202)));
            return;
        }
        v.i("MicroMsg.CardConsumeCodeController", "doUpdate() not ready show!");
    }

    private void a(ImageView imageView, Bitmap bitmap) {
        if (imageView != null && bitmap != null && !bitmap.isRecycled()) {
            imageView.setImageBitmap(bitmap);
            if (this.eFh != 1) {
                imageView.setAlpha(10);
            } else {
                imageView.setAlpha(255);
            }
        }
    }

    private void bO(View view) {
        Button button = (Button) view.findViewById(2131755755);
        if (this.eFh == 1) {
            button.setVisibility(8);
        } else {
            button.setVisibility(0);
        }
        if (this.eFh == -1) {
            button.setText(2131231644);
        }
    }
}
