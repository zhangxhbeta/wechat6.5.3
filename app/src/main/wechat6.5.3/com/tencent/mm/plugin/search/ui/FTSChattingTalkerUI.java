package com.tencent.mm.plugin.search.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ay.c;
import com.tencent.mm.model.m;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.contact.t;
import com.tencent.mm.ui.f.a.a;
import com.tencent.mm.ui.f.e;

public class FTSChattingTalkerUI extends FTSBaseUI {
    private String bdo;
    private d iHA;
    private View iHw;
    private View iHx;
    private View iHy;
    private View iHz;

    static /* synthetic */ void a(FTSChattingTalkerUI fTSChattingTalkerUI) {
        v.i("MicroMsg.FTS.FTSChattingTalkerUI", "onSearchMemberDetail");
        Intent intent = new Intent();
        intent.putExtra("frome_scene", 1);
        intent.putExtra("RoomInfo_Id", fTSChattingTalkerUI.bdo);
        intent.putExtra("title", fTSChattingTalkerUI.getResources().getString(2131234861));
        c.b(fTSChattingTalkerUI, "chatroom", ".ui.SelectMemberUI", intent);
    }

    static /* synthetic */ void b(FTSChattingTalkerUI fTSChattingTalkerUI) {
        v.i("MicroMsg.FTS.FTSChattingTalkerUI", "onSearchDateDetail");
        Intent intent = new Intent();
        intent.putExtra("detail_username", fTSChattingTalkerUI.bdo);
        c.b(fTSChattingTalkerUI, "chatroom", ".ui.SelectDateUI", intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
        e.bIM().aMI();
    }

    protected final void NI() {
        super.NI();
        this.iHz = findViewById(2131757158);
        this.iHw = this.iHz.findViewById(2131757159);
        this.iHx = this.iHz.findViewById(2131757162);
        this.iHy = this.iHz.findViewById(2131757160);
        if (!m.dE(this.bdo)) {
            this.iHw.setVisibility(8);
        }
        this.iHz.setVisibility(0);
        this.iHy.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FTSChattingTalkerUI iHB;

            {
                this.iHB = r1;
            }

            public final void onClick(View view) {
                FTSChattingTalkerUI.a(this.iHB);
            }
        });
        this.iHx.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FTSChattingTalkerUI iHB;

            {
                this.iHB = r1;
            }

            public final void onClick(View view) {
                FTSChattingTalkerUI.b(this.iHB);
            }
        });
    }

    protected final void aMr() {
        this.bdo = getIntent().getStringExtra("detail_username");
        v.i("MicroMsg.FTS.FTSChattingTalkerUI", "initSearchData talker=%s", new Object[]{this.bdo});
    }

    protected final b a(c cVar) {
        if (this.iHA == null) {
            this.iHA = new d(cVar, this.bdo);
        }
        return this.iHA;
    }

    public final void b(a aVar) {
        if (m.dE(this.bdo)) {
            t.h(this.bkC, 10, 5, aVar.position + 1);
        } else {
            t.h(this.bkC, 11, 5, aVar.position + 1);
        }
    }

    protected final void aMx() {
        super.aMx();
        this.iHz.setVisibility(0);
    }

    protected final void aMv() {
        super.aMv();
        this.iHz.setVisibility(8);
    }

    protected final void aMw() {
        super.aMw();
        this.iHz.setVisibility(8);
    }

    protected final void aMu() {
        super.aMu();
        this.iHz.setVisibility(8);
    }

    protected final int getLayoutId() {
        return 2130903678;
    }

    protected final boolean aMA() {
        return true;
    }

    protected final boolean aMn() {
        return false;
    }

    protected void onDestroy() {
        super.onDestroy();
        this.iHA.finish();
        e.bIM().aMF();
    }
}
