package com.tencent.mm.plugin.emoji.ui.v2;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t.a;
import com.tencent.mm.ui.q;

public class EmojiStoreV2HotBarView extends LinearLayout {
    private View eEX;
    View foj;
    private TextView fok;
    View fol;
    private TextView fom;
    private OnClickListener fon = new OnClickListener(this) {
        final /* synthetic */ EmojiStoreV2HotBarView foo;

        {
            this.foo = r1;
        }

        public final void onClick(View view) {
            Intent intent = new Intent();
            intent.setClass(this.foo.getContext(), EmojiStoreV2RankUI.class);
            this.foo.getContext().startActivity(intent);
        }
    };

    public EmojiStoreV2HotBarView(Context context) {
        super(context);
        init();
    }

    public EmojiStoreV2HotBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        v.d("MicroMsg.emoji.EmojiStoreV2HotBarView", "onAttachedToWindow");
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        v.d("MicroMsg.emoji.EmojiStoreV2HotBarView", "onAttachedToWindow");
    }

    @TargetApi(11)
    public EmojiStoreV2HotBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.eEX = ((ViewGroup) q.em(getContext()).inflate(2130903497, this)).findViewById(2131755452);
        this.foj = this.eEX.findViewById(2131756708);
        this.fok = (TextView) this.eEX.findViewById(2131756710);
        this.fok.setText(getResources().getText(2131232388) + " ");
        this.fol = this.eEX.findViewById(2131756699);
        this.fol.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ EmojiStoreV2HotBarView foo;

            {
                this.foo = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(this.foo.getContext(), EmojiStoreV2SingleProductUI.class);
                this.foo.getContext().startActivity(intent);
            }
        });
        this.fom = (TextView) this.eEX.findViewById(2131756698);
        aic();
        OnClickListener onClickListener = this.fon;
        if (this.fok != null) {
            this.fok.setOnClickListener(onClickListener);
        }
    }

    public final void aic() {
        ak.yW();
        boolean booleanValue = ((Boolean) c.vf().get(a.noM, Boolean.valueOf(false))).booleanValue();
        if (this.fom != null) {
            this.fom.setVisibility(booleanValue ? 0 : 8);
        }
    }

    public View getRootView() {
        return this.eEX;
    }

    public void setVisibility(int i) {
        if (this.eEX != null) {
            this.eEX.setVisibility(i);
        } else {
            super.setVisibility(i);
        }
    }
}
