package com.tencent.mm.plugin.search.ui.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ay.c;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.l;
import com.tencent.mm.model.m;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelsearch.p.h;
import com.tencent.mm.plugin.search.ui.FTSTalkerUI;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.storage.at;
import java.util.List;

public final class e extends com.tencent.mm.ui.f.a.a {
    public CharSequence dtS;
    public CharSequence dtT;
    public h eAt;
    public List<String> ezU;
    public int iIU;
    public CharSequence iIV;
    private b iIW = new b(this);
    a iIX = new a(this);
    public String username;

    public class a extends com.tencent.mm.ui.f.a.a.a {
        public View dtW;
        public ImageView dtX;
        public TextView eTf;
        public TextView eTg;
        public TextView euh;
        final /* synthetic */ e iIY;

        public a(e eVar) {
            this.iIY = eVar;
            super(eVar);
        }
    }

    public class b extends com.tencent.mm.ui.f.a.a.b {
        final /* synthetic */ e iIY;

        public b(e eVar) {
            this.iIY = eVar;
            super(eVar);
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate(2130903687, viewGroup, false);
            inflate.measure(ViewGroup.getChildMeasureSpec(MeasureSpec.makeMeasureSpec(viewGroup.getWidth(), 1073741824), viewGroup.getPaddingLeft() + viewGroup.getPaddingRight(), -1), MeasureSpec.makeMeasureSpec(-2, 1073741824));
            a aVar = this.iIY.iIX;
            aVar.dtX = (ImageView) inflate.findViewById(2131755508);
            aVar.euh = (TextView) inflate.findViewById(2131756539);
            aVar.eTf = (TextView) inflate.findViewById(2131757187);
            aVar.eTg = (TextView) inflate.findViewById(2131756540);
            aVar.dtW = inflate.findViewById(2131757157);
            inflate.setTag(aVar);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.ui.f.a.a.a aVar, com.tencent.mm.ui.f.a.a aVar2) {
            e eVar = (e) aVar2;
            a aVar3 = (a) aVar;
            cY(aVar3.dtW);
            com.tencent.mm.pluginsdk.ui.a.b.m(aVar3.dtX, eVar.username);
            com.tencent.mm.modelsearch.h.b(eVar.dtS, aVar3.euh);
            com.tencent.mm.modelsearch.h.b(eVar.dtT, aVar3.eTf);
            com.tencent.mm.modelsearch.h.b(eVar.iIV, aVar3.eTg);
        }

        public final boolean a(Context context, com.tencent.mm.ui.f.a.a aVar) {
            String str = null;
            e eVar = (e) aVar;
            Intent intent;
            BizInfo hw;
            Intent intent2;
            if (this.iIY.iIU < 2) {
                if (com.tencent.mm.modelbiz.e.hB(eVar.username)) {
                    com.tencent.mm.plugin.search.a.drp.d(new Intent().putExtra("Contact_User", eVar.username), context);
                } else if (com.tencent.mm.modelbiz.e.hC(eVar.username)) {
                    intent = new Intent();
                    intent.putExtra("Contact_User", eVar.username);
                    intent.addFlags(67108864);
                    intent.putExtra("biz_chat_from_scene", 5);
                    c.a(context, ".ui.bizchat.BizChatConversationUI", intent);
                } else if (com.tencent.mm.modelbiz.e.hD(eVar.username)) {
                    hw = com.tencent.mm.modelbiz.e.hw(eVar.username);
                    if (hw != null) {
                        str = hw.CD();
                    }
                    if (str == null) {
                        str = "";
                    }
                    intent2 = new Intent();
                    intent2.putExtra("rawUrl", str);
                    intent2.putExtra("useJs", true);
                    intent2.putExtra("srcUsername", eVar.username);
                    intent2.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
                    intent2.addFlags(67108864);
                    c.b(context, "webview", ".ui.tools.WebViewUI", intent2);
                } else {
                    com.tencent.mm.plugin.search.a.drp.e(new Intent().putExtra("Chat_User", eVar.username).putExtra("finish_direct", true).putExtra("from_global_search", true).putExtra("msg_local_id", eVar.eAt.cWu), context);
                }
            } else if (com.tencent.mm.modelbiz.e.hC(eVar.username)) {
                intent = new Intent();
                intent.putExtra("Contact_User", eVar.username);
                intent.addFlags(67108864);
                intent.putExtra("biz_chat_from_scene", 5);
                c.a(context, ".ui.bizchat.BizChatConversationUI", intent);
            } else if (com.tencent.mm.modelbiz.e.hD(eVar.username)) {
                hw = com.tencent.mm.modelbiz.e.hw(eVar.username);
                if (hw != null) {
                    str = hw.CD();
                }
                if (str == null) {
                    str = "";
                }
                intent2 = new Intent();
                intent2.putExtra("rawUrl", str);
                intent2.putExtra("useJs", true);
                intent2.putExtra("srcUsername", eVar.username);
                intent2.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
                intent2.addFlags(67108864);
                c.b(context, "webview", ".ui.tools.WebViewUI", intent2);
            } else {
                context.startActivity(new Intent(context, FTSTalkerUI.class).putExtra("key_talker", eVar.username).putExtra("key_query", eVar.bkC).putExtra("key_count", eVar.iIU));
            }
            return true;
        }
    }

    public e(int i) {
        super(6, i);
    }

    public final void a(Context context, com.tencent.mm.ui.f.a.a.a aVar) {
        a aVar2 = (a) aVar;
        this.username = this.eAt.cWv;
        this.dtS = com.tencent.mm.pluginsdk.ui.d.e.a(context, l.er(this.username), aVar2.euh.getTextSize());
        if (this.eAt.userData instanceof Integer) {
            this.iIU = ((Integer) this.eAt.userData).intValue();
        }
        if (this.iIU < 2) {
            CharSequence charSequence;
            int i;
            CharSequence charSequence2 = "";
            String str = "";
            ak.yW();
            at ek = com.tencent.mm.model.c.wJ().ek(this.eAt.cWu);
            com.tencent.mm.q.a.a dV;
            switch (this.eAt.cWt) {
                case 41:
                    str = ek.field_content;
                    if (str == null) {
                        str = this.eAt.content == null ? "" : this.eAt.content;
                    }
                    if (m.dE(this.username)) {
                        str = aw.fM(str);
                        break;
                    }
                    break;
                case 42:
                    dV = com.tencent.mm.q.a.a.dV(ek.field_content);
                    if (dV != null) {
                        str = dV.title;
                    }
                    charSequence2 = context.getString(2131233003);
                    break;
                case 43:
                    dV = com.tencent.mm.q.a.a.dV(ek.field_content);
                    if (dV != null) {
                        str = dV.title;
                    }
                    charSequence2 = context.getString(2131233004);
                    break;
                case 44:
                    com.tencent.mm.q.a.a dV2 = com.tencent.mm.q.a.a.dV(ek.field_content);
                    if (dV2 != null) {
                        charSequence2 = dV2.title + ": ";
                        str = dV2.description;
                        break;
                    }
                    break;
            }
            int measuredWidth = aVar2.eTf.getMeasuredWidth();
            if (be.D(charSequence2)) {
                charSequence = charSequence2;
                i = measuredWidth;
            } else {
                float measureText = com.tencent.mm.modelsearch.h.cVQ.measureText(charSequence2, 0, charSequence2.length());
                if (measureText > ((float) measuredWidth) * 0.6f) {
                    measureText = ((float) measuredWidth) * 0.6f;
                }
                measuredWidth = (int) (((float) measuredWidth) - measureText);
                charSequence = TextUtils.ellipsize(charSequence2, com.tencent.mm.modelsearch.h.cVQ, measureText, TruncateAt.MIDDLE);
                i = measuredWidth;
            }
            this.dtT = com.tencent.mm.pluginsdk.ui.d.e.a(context, str.replace('\n', ' '), com.tencent.mm.modelsearch.h.cVP);
            this.dtT = com.tencent.mm.modelsearch.h.a(context, this.dtT, this.ezU, com.tencent.mm.modelsearch.h.cVQ, (float) i);
            if (!be.D(charSequence)) {
                this.dtT = TextUtils.concat(new CharSequence[]{charSequence, this.dtT});
            }
            this.iIV = "";
            return;
        }
        this.dtT = context.getResources().getString(2131234855, new Object[]{Integer.valueOf(this.iIU)});
        this.iIV = "";
    }

    public final com.tencent.mm.ui.f.a.a.b YL() {
        return this.iIW;
    }

    public final int YM() {
        return this.eAt.cWA;
    }
}
