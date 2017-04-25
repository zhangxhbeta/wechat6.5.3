package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.q;

public final class b {
    private final String TAG = "MicroMsg.emoji.BaseEmojiStoreItemViewHolder";
    public TextView eJL;
    public View eYV;
    public String eZd;
    public ImageView eZe;
    public ImageView eZf;
    public Context mContext;

    public b(Context context) {
        this.mContext = context;
        this.eYV = q.em(this.mContext).inflate(2130903501, null);
        aeG();
    }

    public b(Context context, View view) {
        this.mContext = context;
        this.eYV = view;
        aeG();
    }

    private void aeG() {
        if (this.eYV == null) {
            v.w("MicroMsg.emoji.BaseEmojiStoreItemViewHolder", "initView failed. root is null.");
            return;
        }
        this.eZe = (ImageView) this.eYV.findViewById(2131756640);
        this.eJL = (TextView) this.eYV.findViewById(2131756713);
        this.eZf = (ImageView) this.eYV.findViewById(2131756707);
    }
}
