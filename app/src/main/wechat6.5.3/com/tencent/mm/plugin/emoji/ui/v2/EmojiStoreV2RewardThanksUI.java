package com.tencent.mm.plugin.emoji.ui.v2;

import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.mm.a.e;
import com.tencent.mm.ae.a.c.i;
import com.tencent.mm.ae.n;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.g;
import com.tencent.mm.plugin.emoji.ui.widget.MMCopiableTextView;
import com.tencent.mm.protocal.c.vv;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;

public class EmojiStoreV2RewardThanksUI extends MMActivity {
    private String fdK;
    private vv fii;
    private EmojiStoreV2RewardBannerView foG;
    private View foH;
    private MMCopiableTextView foI;
    private TextView foJ;
    private TextView foK;
    private AnimationDrawable foL;
    private ac mHandler = new ac(this) {
        final /* synthetic */ EmojiStoreV2RewardThanksUI foM;

        {
            this.foM = r1;
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1001:
                    String str = (String) message.obj;
                    if (be.kS(str) || !e.aR(str)) {
                        v.i("MicroMsg.emoji.EmojiStoreV2RewardThanksUI", "path is null or file no exists");
                        return;
                    }
                    this.foM.foG.bN(str, null);
                    this.foM.foG.setScaleType(ScaleType.FIT_XY);
                    if (this.foM.foL != null && this.foM.foL.isRunning()) {
                        this.foM.foL.stop();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };

    protected final int getLayoutId() {
        return 2130903507;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fdK = getIntent().getStringExtra("extra_id");
        NI();
        this.fii = g.afx().fcm.NL(this.fdK);
        if (this.fii == null) {
            this.foG.setBackgroundDrawable(getResources().getDrawable(2130839570));
            this.foG.setImageDrawable(this.foL);
            this.foG.setScaleType(ScaleType.CENTER);
            this.foL.start();
        } else if (this.fii.myv == null || be.kS(this.fii.myv.mqD)) {
            this.foG.setBackgroundDrawable(getResources().getDrawable(2130839570));
            this.foG.setImageDrawable(this.foL);
            this.foG.setScaleType(ScaleType.CENTER);
            this.foL.start();
        } else {
            final String str = this.fii.myv.mqE;
            ak.yW();
            final String z = EmojiLogic.z(c.wY(), this.fdK, str);
            if (e.aR(z)) {
                this.foG.bN(z, null);
                this.foG.setScaleType(ScaleType.FIT_XY);
                if (this.foL != null && this.foL.isRunning()) {
                    this.foL.stop();
                }
            } else {
                n.GL().a(str, this.foG, com.tencent.mm.plugin.emoji.d.g.c(this.fdK, str, new Object[0]), new i(this) {
                    final /* synthetic */ EmojiStoreV2RewardThanksUI foM;

                    public final void a(String str, Bitmap bitmap, Object... objArr) {
                        if (!be.kS(str) && str.equalsIgnoreCase(str)) {
                            Message message = new Message();
                            message.what = 1001;
                            message.obj = z;
                            this.foM.mHandler.sendMessage(message);
                        }
                    }
                });
                this.foG.setBackgroundDrawable(getResources().getDrawable(2130839570));
                this.foG.setImageDrawable(this.foL);
                this.foG.setScaleType(ScaleType.CENTER);
                this.foL.start();
            }
        }
        if (this.fii == null || this.fii.myv == null) {
            this.foH.setVisibility(8);
            return;
        }
        this.foH.setVisibility(0);
        be.kS(this.fii.myv.mqG);
        this.foI.setVisibility(0);
        this.foI.setText(2131232408);
        this.foJ.setVisibility(8);
        this.foK.setVisibility(8);
    }

    protected void onDestroy() {
        if (this.foL != null && this.foL.isRunning()) {
            this.foL.stop();
        }
        super.onDestroy();
    }

    protected final void NI() {
        vD(2131232407);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ EmojiStoreV2RewardThanksUI foM;

            {
                this.foM = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.foM.finish();
                return false;
            }
        });
        this.foG = (EmojiStoreV2RewardBannerView) findViewById(2131756723);
        this.foG.gi = 1.0f;
        this.foH = findViewById(2131756724);
        this.foI = (MMCopiableTextView) findViewById(2131756726);
        this.foJ = (TextView) findViewById(2131756727);
        this.foK = (TextView) findViewById(2131756725);
        this.foL = (AnimationDrawable) getResources().getDrawable(2130838147);
    }

    protected final int NO() {
        return 1;
    }
}
