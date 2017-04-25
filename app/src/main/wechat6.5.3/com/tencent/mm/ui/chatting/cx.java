package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ay.c;
import com.tencent.mm.model.l;
import com.tencent.mm.model.m;
import com.tencent.mm.sdk.platformtools.v;

public final class cx {
    private LinearLayout fqo;
    private OnClickListener iqU = new OnClickListener(this) {
        final /* synthetic */ cx osH;

        {
            this.osH = r1;
        }

        public final void onClick(View view) {
            m.eE("gh_43f2581f6fd6");
            Intent intent = new Intent();
            intent.putExtra("key_is_latest", true);
            intent.putExtra("rank_id", "#");
            intent.putExtra("key_only_show_latest_rank", true);
            intent.putExtra("app_username", l.er("gh_43f2581f6fd6"));
            intent.putExtra("device_type", 1);
            c.b(view.getContext(), "exdevice", ".ui.ExdeviceRankInfoUI", intent);
        }
    };
    private ChatFooterCustom onb;
    private FrameLayout osG;

    public cx(ChatFooterCustom chatFooterCustom) {
        this.onb = chatFooterCustom;
    }

    public final void bCh() {
        v.i("MicroMsg.Sport.ChattingSportFooterHandler", "initFooter");
        this.onb.findViewById(2131756085).setVisibility(8);
        this.onb.findViewById(2131756087).setVisibility(8);
        this.fqo = (LinearLayout) this.onb.findViewById(2131756086);
        this.fqo.setWeightSum(1.0f);
        this.osG = (FrameLayout) this.fqo.getChildAt(0);
        this.osG.setVisibility(0);
        this.osG.setOnClickListener(this.iqU);
        ((TextView) this.osG.getChildAt(0).findViewById(2131756083)).setText(2131232588);
        this.osG.getChildAt(0).findViewById(2131756082).setVisibility(8);
        this.osG.getChildAt(1).setVisibility(8);
        for (int i = 1; i < 6; i++) {
            this.fqo.getChildAt(i).setVisibility(8);
        }
    }
}
