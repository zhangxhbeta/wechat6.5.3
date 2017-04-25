package com.tencent.mm.ui.chatting;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.e.a.qi;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.chatting.ad.a;

final class ej extends a {
    TextView lts;
    View ozA = null;

    public ej(int i) {
        super(i);
    }

    public final a cS(View view) {
        super.cM(view);
        if (this.type == 24 || this.type == 43 || this.type == 27 || this.type == 28) {
            this.eTg = (TextView) view.findViewById(2131755027);
            this.lts = (TextView) view.findViewById(2131756232);
            this.onC = view.findViewById(2131756148);
            this.ozA = view.findViewById(2131756231);
        }
        if (this.type == 24) {
            this.oky = (ImageView) view.findViewById(2131756230);
        }
        this.gfb = (CheckBox) view.findViewById(2131755022);
        this.fIV = view.findViewById(2131755026);
        return this;
    }

    public static void a(ej ejVar, at atVar, boolean z, int i, ChattingUI.a aVar) {
        int i2 = 0;
        if (ejVar != null) {
            if (ejVar.oky != null) {
                ejVar.oky.setVisibility(atVar.field_status == 6 ? 8 : 0);
            }
            ejVar.onC.setTag(new dl(atVar, aVar.nQK, i, null, 0, (byte) 0));
            ejVar.onC.setOnClickListener(aVar.onh.oqh);
            ejVar.onC.setOnLongClickListener(aVar.onh.oqj);
            CharSequence charSequence = atVar.bNo;
            if (!be.kS(charSequence)) {
                ejVar.lts.setText(charSequence);
            } else if (z) {
                ejVar.lts.setText(2131235859);
            } else {
                ejVar.lts.setText(2131235860);
            }
            if (ejVar.ozA != null) {
                if (!atVar.field_content.equals(at.nvB)) {
                    int i3;
                    String str = atVar.field_content;
                    b qiVar = new qi();
                    qiVar.brC.bdn = 1;
                    qiVar.brC.content = str;
                    com.tencent.mm.sdk.c.a.nhr.z(qiVar);
                    if (qiVar.brD.type == 3) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    if (i3 == 0) {
                        if (!atVar.field_content.equals(at.nvC)) {
                            str = atVar.field_content;
                            qiVar = new qi();
                            qiVar.brC.bdn = 1;
                            qiVar.brC.content = str;
                            com.tencent.mm.sdk.c.a.nhr.z(qiVar);
                            if (qiVar.brD.type == 2) {
                                i2 = 1;
                            }
                            if (i2 == 0) {
                                return;
                            }
                        }
                        if (z) {
                            ejVar.ozA.setBackgroundResource(2131166009);
                            return;
                        } else {
                            ejVar.ozA.setBackgroundResource(2131166010);
                            return;
                        }
                    }
                }
                if (z) {
                    ejVar.ozA.setBackgroundResource(2131166012);
                } else {
                    ejVar.ozA.setBackgroundResource(2131166013);
                }
            }
        }
    }
}
