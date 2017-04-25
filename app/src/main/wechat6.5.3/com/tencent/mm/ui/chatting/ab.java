package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.k.b;
import com.tencent.mm.ui.p;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class ab {
    private u bhV;
    boolean nQK;
    a omY;
    cp omZ;
    ChatFooter ona;
    ChatFooterCustom onb;
    private boolean onc = false;
    long[] ond = null;

    public ab(a aVar, cp cpVar, ChatFooter chatFooter, ChatFooterCustom chatFooterCustom, u uVar, boolean z, long[] jArr) {
        this.omY = aVar;
        this.ona = chatFooter;
        this.onb = chatFooterCustom;
        this.omZ = cpVar;
        this.bhV = uVar;
        this.nQK = z;
        this.ond = jArr;
        this.omY.nDR.bAi();
        p pVar = this.omY;
        pVar.nDR.a(2, this.omY.getString(2131231488), new OnMenuItemClickListener(this) {
            final /* synthetic */ ab one;

            {
                this.one = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent();
                Set<Long> set = this.one.omZ.oqG;
                if (set != null) {
                    List<Long> arrayList = new ArrayList();
                    for (Long l : set) {
                        if (l != null) {
                            arrayList.add(l);
                        }
                    }
                    long[] jArr = new long[arrayList.size()];
                    int i = 0;
                    for (Long l2 : arrayList) {
                        int i2 = i + 1;
                        jArr[i] = l2.longValue();
                        i = i2;
                    }
                    intent.putExtra("k_outside_expose_proof_item_list", jArr);
                    this.one.omY.bzo().setResult(-1, intent);
                } else {
                    this.one.omY.bzo().setResult(0, intent);
                }
                intent.putExtra("k_is_group_chat", this.one.nQK);
                this.one.omY.finish();
                return false;
            }
        }, null, b.nET);
        this.omZ.oqQ = new OnClickListener(this) {
            final /* synthetic */ ab one;

            {
                this.one = r1;
            }

            public final void onClick(View view) {
                this.one.omZ.ew(((Long) view.getTag()).longValue());
            }
        };
    }
}
