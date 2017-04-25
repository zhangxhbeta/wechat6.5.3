package com.tencent.mm.plugin.emoji.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.emoji.model.e;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.vt;
import com.tencent.mm.sdk.h.i;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.a.a;
import com.tencent.mm.storage.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmojiMineUI extends BaseEmojiStoreUI implements OnClickListener {
    private final String TAG = "MicroMsg.emoji.EmojiMineUI";
    private ViewGroup fhL;
    private ViewGroup fhM;
    private ViewGroup fhN;
    private ViewGroup fhO;
    private TextView fhP;
    private View fha;
    private TextView fhb;

    protected final int getLayoutId() {
        return 2130903489;
    }

    public void onCreate(Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        super.onCreate(bundle);
        g.iuh.Y(10931, String.valueOf(getIntent().getIntExtra("10931", 0)));
        v.i("MicroMsg.emoji.EmojiMineUI", "jacks statistics enter Emoji Setting UI:%d", new Object[]{Integer.valueOf(r0)});
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ EmojiMineUI fhQ;

            {
                this.fhQ = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.fhQ.finish();
                return true;
            }
        });
        a(0, getString(2131232360), new OnMenuItemClickListener(this) {
            final /* synthetic */ EmojiMineUI fhQ;

            {
                this.fhQ = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                ArrayList bxC = com.tencent.mm.plugin.emoji.model.g.afx().fci.bxC();
                List arrayList = new ArrayList();
                Iterator it = bxC.iterator();
                while (it.hasNext()) {
                    a aVar = (a) it.next();
                    if (aVar.field_type != a.TYPE_CUSTOM) {
                        arrayList.add(aVar);
                    }
                }
                if (arrayList.size() <= 1) {
                    com.tencent.mm.ui.base.g.f(this.fhQ.nDR.nEl, 2131232326, 2131231164);
                } else if (ak.isConnected(aa.getContext())) {
                    Intent intent = new Intent();
                    intent.setClass(this.fhQ, EmojiSortUI.class);
                    this.fhQ.startActivity(intent);
                } else {
                    com.tencent.mm.ui.base.g.a(this.fhQ, this.fhQ.getString(2131232364), "", this.fhQ.getString(2131232363), new DialogInterface.OnClickListener(this.fhQ) {
                        final /* synthetic */ EmojiMineUI fhQ;

                        {
                            this.fhQ = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                }
                return true;
            }
        });
        com.tencent.mm.model.ak.yW();
        if (!((Boolean) c.vf().get(t.a.noG, Boolean.valueOf(false))).booleanValue()) {
            com.tencent.mm.plugin.emoji.b.a.cs(true);
        }
        g.iuh.a(406, 3, 1, false);
        g.iuh.a(406, 5, System.currentTimeMillis() - currentTimeMillis, false);
    }

    protected final void NI() {
        vD(2131235007);
        super.NI();
        this.fha = findViewById(2131756634);
        this.fhb = (TextView) this.fha.findViewById(2131756635);
        this.fhb.setText(2131232436);
        if (com.tencent.mm.plugin.emoji.model.g.afu().feA.feQ) {
            com.tencent.mm.plugin.emoji.model.g.afu();
            if (com.tencent.mm.plugin.emoji.g.c.afX()) {
                this.fha.setVisibility(0);
                by(8001, 3000);
                this.Eq.setOnScrollListener(null);
            }
        }
        this.fha.setVisibility(8);
        this.Eq.setOnScrollListener(null);
    }

    public void onClick(View view) {
        Intent intent;
        if (view == this.fhM) {
            intent = new Intent();
            intent.setClass(this, EmojiCustomUI.class);
            startActivity(intent);
        } else if (view == this.fhN) {
            intent = new Intent();
            intent.setClass(this, EmojiPaidUI.class);
            startActivity(intent);
        }
    }

    protected final boolean agj() {
        return false;
    }

    protected final com.tencent.mm.plugin.emoji.a.a.a age() {
        return new com.tencent.mm.plugin.emoji.a.c(this.nDR.nEl);
    }

    protected final int agm() {
        return 8;
    }

    protected final int ago() {
        return 2;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        super.onItemClick(adapterView, view, i - 1, j);
    }

    public final void a(String str, i iVar) {
        if (str != null && str.equals("event_update_group")) {
            agG();
            by(131074, 50);
        }
    }

    public final void e(String str, int i, int i2, String str2) {
    }

    protected final boolean agx() {
        return false;
    }

    protected final void agf() {
        this.fhO = (ViewGroup) View.inflate(this.nDR.nEl, 2130903480, null);
        this.fhP = (TextView) this.fhO.findViewById(16908310);
        this.fhP.setText(2131235009);
        this.fhO.setVisibility(8);
        this.fhP.setVisibility(8);
        this.Eq.addHeaderView(this.fhO, null, false);
        this.fhL = (ViewGroup) View.inflate(this.nDR.nEl, 2130903477, null);
        this.fhM = (ViewGroup) this.fhL.findViewById(2131756654);
        ((TextView) this.fhM.findViewById(16908310)).setText(2131232334);
        this.fhN = (ViewGroup) this.fhL.findViewById(2131756655);
        ((TextView) this.fhN.findViewById(16908310)).setText(2131232351);
        this.fhN.findViewById(2131755329).setBackgroundResource(2130838048);
        this.fhM.setOnClickListener(this);
        this.fhN.setOnClickListener(this);
        this.Eq.addFooterView(this.fhL, null, false);
    }

    protected final boolean agw() {
        return true;
    }

    protected final boolean agr() {
        boolean z = true;
        if (this.fcY != null) {
            this.fcY.notifyDataSetChanged();
            this.fga = true;
            this.dZV.setVisibility(8);
        } else {
            z = false;
        }
        agy();
        return z;
    }

    protected final void c(vt vtVar) {
        super.c(vtVar);
    }

    protected final void a(boolean z, e eVar, boolean z2, boolean z3) {
    }

    protected final boolean agh() {
        return false;
    }

    public final void g(Message message) {
        if (message.what == 8001 && this.fha != null) {
            this.fha.setVisibility(8);
        }
        super.g(message);
    }

    public final void agy() {
        if (this.fhO == null) {
            return;
        }
        if (this.fcY == null || this.fcY.isEmpty()) {
            this.fhO.setVisibility(8);
            this.fhP.setVisibility(8);
            return;
        }
        this.fhO.setVisibility(0);
        this.fhP.setVisibility(0);
    }

    protected final int agc() {
        return 24;
    }

    protected final int agd() {
        return 7;
    }
}
