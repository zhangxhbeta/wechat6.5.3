package com.tencent.mm.ui.chatting;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.chatting.ad.a;

final class ek extends a {
    TextView lts;

    public ek(int i) {
        super(i);
    }

    public final a cS(View view) {
        super.cM(view);
        if (this.type == 39) {
            this.eTg = (TextView) view.findViewById(2131755027);
            this.lts = (TextView) view.findViewById(2131756232);
            this.onC = view.findViewById(2131756148);
        } else {
            this.eTg = (TextView) view.findViewById(2131755027);
        }
        if (this.type == 39) {
            this.oky = (ImageView) view.findViewById(2131756230);
        }
        this.gfb = (CheckBox) view.findViewById(2131755022);
        this.fIV = view.findViewById(2131755026);
        return this;
    }

    public static void a(ek ekVar, at atVar, int i, ChattingUI.a aVar) {
        if (ekVar != null) {
            ekVar.onC.setTag(new dl(atVar, aVar.nQK, i, null, 0, (byte) 0));
            ekVar.onC.setOnClickListener(aVar.onh.oqh);
            ekVar.onC.setOnLongClickListener(aVar.onh.oqj);
        }
    }
}
