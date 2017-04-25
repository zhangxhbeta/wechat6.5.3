package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.chatting.ad.a;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

final class g extends a {
    public static Map<String, WeakReference<g>> okq = new HashMap();
    ProgressBar ieT;
    RTChattingEmojiView okk;
    ImageView okl;
    ImageView okm;
    ProgressBar okn;
    ImageView oko;
    TextView okp;

    public g(int i) {
        super(i);
    }

    public final a o(View view, boolean z) {
        super.cM(view);
        this.eTg = (TextView) view.findViewById(2131755027);
        this.okk = (RTChattingEmojiView) view.findViewById(2131756186);
        this.gfb = (CheckBox) view.findViewById(2131755022);
        this.fIV = view.findViewById(2131755026);
        this.okn = (ProgressBar) view.findViewById(2131756187);
        this.oko = (ImageView) view.findViewById(2131756189);
        this.okp = (TextView) view.findViewById(2131756188);
        if (z) {
            this.type = 14;
        } else {
            this.ieT = (ProgressBar) view.findViewById(2131756257);
            this.oky = (ImageView) view.findViewById(2131756230);
            this.type = 15;
            this.okm = (ImageView) view.findViewById(2131756258);
        }
        if (this.okl != null) {
            ((ViewGroup) this.okl.getParent()).setBackgroundDrawable(null);
        }
        this.iJL = (TextView) view.findViewById(2131755341);
        return this;
    }

    public static void f(String str, int i, int i2) {
        if (okq.containsKey(str)) {
            g gVar = (g) ((WeakReference) okq.get(str)).get();
            if (gVar != null) {
                switch (i2) {
                    case 0:
                        gVar.okn.setVisibility(0);
                        gVar.okp.setVisibility(8);
                        gVar.oko.setVisibility(8);
                        gVar.okn.setProgress(0);
                        return;
                    case 1:
                        gVar.okn.setVisibility(8);
                        gVar.okp.setVisibility(8);
                        gVar.oko.setVisibility(8);
                        return;
                    case 2:
                        gVar.okn.setVisibility(8);
                        gVar.okp.setVisibility(8);
                        gVar.oko.setVisibility(0);
                        gVar.okn.setProgress(i);
                        gVar.oko.setImageResource(2130838152);
                        return;
                    default:
                        return;
                }
            }
            return;
        }
        v.i("AppMsgEmojiItemHolder", "no contain attchid:%s");
    }
}
