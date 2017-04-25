package com.tencent.mm.plugin.emoji.ui.v2;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.emoji.e.g;
import com.tencent.mm.plugin.emoji.model.f.b;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI;
import com.tencent.mm.protocal.c.ol;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.a.a;
import com.tencent.mm.ui.q;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public class EmojiStoreV2SingleRecommendView extends LinearLayout implements OnClickListener, b {
    public String fdK;
    protected final int ffN = 131074;
    private final int ffO = 131075;
    private final int ffP = 131076;
    private final String ffQ = "product_id";
    private final String ffR = "progress";
    private final String ffS = DownloadInfo.STATUS;
    private g ffr;
    private String fiN;
    public ImageView fiu;
    private ac fnw = new ac(this) {
        final /* synthetic */ EmojiStoreV2SingleRecommendView fqk;

        {
            this.fqk = r1;
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 131075:
                    int i = message.getData().getInt("progress");
                    if (be.kS(message.getData().getString("product_id"))) {
                        v.w("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "product id is null");
                        return;
                    }
                    if (this.fqk.fqf != null) {
                        this.fqk.fqf.setVisibility(8);
                    }
                    if (this.fqk.fqg != null) {
                        this.fqk.fqg.setVisibility(0);
                        this.fqk.fqg.setProgress(i);
                        return;
                    }
                    return;
                case 131076:
                    message.getData().getInt(DownloadInfo.STATUS);
                    if (be.kS(message.getData().getString("product_id"))) {
                        v.w("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "product id is null");
                        return;
                    }
                    if (this.fqk.fqf != null) {
                        this.fqk.fqf.setVisibility(0);
                    }
                    if (this.fqk.fqg != null) {
                        this.fqk.fqg.setVisibility(8);
                        this.fqk.fqg.setProgress(0);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    public ViewGroup fqb;
    public ImageView fqc;
    public TextView fqd;
    public TextView fqe;
    public Button fqf;
    public ProgressBar fqg;
    public a fqh;
    private boolean fqi = true;
    private c fqj = new c<cb>(this) {
        final /* synthetic */ EmojiStoreV2SingleRecommendView fqk;

        {
            this.fqk = r2;
            this.nhz = cb.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            cb cbVar = (cb) bVar;
            if (cbVar instanceof cb) {
                this.fqk.fiN = cbVar.aZC.aZE;
                if (!be.kS(cbVar.aZC.aZD) && cbVar.aZC.aZD.equalsIgnoreCase(this.fqk.fdK)) {
                    EmojiStoreV2SingleRecommendView emojiStoreV2SingleRecommendView = this.fqk;
                    String str = cbVar.aZC.aZD;
                    int i = cbVar.aZC.status;
                    int i2 = cbVar.aZC.progress;
                    String str2 = cbVar.aZC.aZE;
                    v.d("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "[onExchange] productId:[%s] status:[%d] progress:[%d] cdnClientId:[%s]", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), str2});
                    if (i == 6) {
                        Message obtain = Message.obtain();
                        obtain.getData().putString("product_id", str);
                        obtain.getData().putInt("progress", i2);
                        obtain.what = 131075;
                        emojiStoreV2SingleRecommendView.h(obtain);
                    } else {
                        v.i("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "product status:%d", new Object[]{Integer.valueOf(i)});
                        Message obtain2 = Message.obtain();
                        obtain2.getData().putString("product_id", str);
                        obtain2.getData().putInt(DownloadInfo.STATUS, i);
                        obtain2.what = 131076;
                        emojiStoreV2SingleRecommendView.h(obtain2);
                    }
                }
            }
            return false;
        }
    };

    public EmojiStoreV2SingleRecommendView(Context context, boolean z) {
        super(context);
        this.fqi = z;
        init();
    }

    public EmojiStoreV2SingleRecommendView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    @TargetApi(11)
    public EmojiStoreV2SingleRecommendView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        v.d("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "onAttachedToWindow");
        com.tencent.mm.sdk.c.a.nhr.e(this.fqj);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        v.d("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "onDetachedFromWindow");
        com.tencent.mm.sdk.c.a.nhr.f(this.fqj);
    }

    private void init() {
        if (this.fqi) {
            this.fqb = (ViewGroup) q.em(getContext()).inflate(2130903512, this);
        } else {
            this.fqb = (ViewGroup) q.em(getContext()).inflate(2130903513, this);
        }
        this.fiu = (ImageView) this.fqb.findViewById(2131756671);
        this.fqc = (ImageView) this.fqb.findViewById(2131756741);
        this.fqd = (TextView) this.fqb.findViewById(2131756665);
        this.fqe = (TextView) this.fqb.findViewById(2131756742);
        this.fqf = (Button) this.fqb.findViewById(2131756743);
        this.fqg = (ProgressBar) this.fqb.findViewById(2131756670);
    }

    public final void B(String str, String str2, String str3) {
        ak.vy().a(new g(str, str2, str3), 0);
    }

    public final void afo() {
    }

    public final void h(Message message) {
        if (this.fnw != null) {
            this.fnw.sendMessage(message);
        }
    }

    private void c(ol olVar) {
        Intent intent = new Intent();
        intent.setClass(getContext(), EmojiStoreDetailUI.class);
        intent.putExtra("extra_id", olVar.mdM);
        intent.putExtra("extra_name", olVar.mqd);
        intent.putExtra("extra_copyright", olVar.mqn);
        intent.putExtra("extra_coverurl", olVar.mql);
        intent.putExtra("extra_description", olVar.mqe);
        intent.putExtra("extra_price", olVar.mqg);
        intent.putExtra("extra_type", olVar.mqh);
        intent.putExtra("extra_flag", olVar.mqi);
        intent.putExtra("extra_price_num", olVar.mqo);
        intent.putExtra("extra_price_type", olVar.mqp);
        intent.putExtra("preceding_scence", ba.CTRL_INDEX);
        intent.putExtra("call_by", 1);
        intent.putExtra("download_entrance_scene", 8);
        intent.putExtra("check_clickflag", false);
        getContext().startActivity(intent);
    }

    public void onClick(View view) {
        if (view == this.fiu) {
            com.tencent.mm.plugin.emoji.model.g.afx().fci.NA(this.fdK);
            com.tencent.mm.plugin.report.service.g.iuh.h(12068, new Object[]{Integer.valueOf(2), this.fdK, Integer.valueOf(this.fqh.field_recommandType)});
        } else if (view == this.fqb) {
            c(this.fqh.bxk());
            com.tencent.mm.plugin.report.service.g.iuh.h(12068, new Object[]{Integer.valueOf(4), this.fdK, Integer.valueOf(this.fqh.field_recommandType)});
        } else if (view != this.fqf) {
            v.d("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "do nothing");
        } else if (this.fqh.field_buttonType == 1) {
            this.ffr = new g(this.fdK);
            ak.vy().a(this.ffr, 0);
            com.tencent.mm.plugin.report.service.g.iuh.h(12068, new Object[]{Integer.valueOf(3), this.fdK, Integer.valueOf(this.fqh.field_recommandType)});
            com.tencent.mm.plugin.report.service.g.iuh.h(12066, new Object[]{Integer.valueOf(0), Integer.valueOf(8), "", this.fdK});
        } else if (this.fqh.field_buttonType == 2) {
            c(this.fqh.bxk());
            com.tencent.mm.plugin.report.service.g.iuh.h(12068, new Object[]{Integer.valueOf(4), this.fdK, Integer.valueOf(this.fqh.field_recommandType)});
        } else {
            v.i("MicroMsg.emoji.EmojiStoreV2SingleRecommendView", "unknown buttonType do nothing.");
        }
    }
}
