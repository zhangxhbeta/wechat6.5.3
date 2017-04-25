package com.tencent.mm.plugin.chatroom.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ak.j;
import com.tencent.mm.e.a.jp;
import com.tencent.mm.model.ak;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.protocal.c.air;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.k;
import com.tencent.mm.ui.tools.a.c.a;
import com.tencent.mm.ui.widget.MMEditText;

public class ModRemarkRoomNameUI extends MMActivity implements a {
    private p ePC = null;
    private c ePD = new c<jp>(this) {
        final /* synthetic */ ModRemarkRoomNameUI eQJ;

        {
            this.eQJ = r2;
            this.nhz = jp.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            jp jpVar = (jp) bVar;
            String str = jpVar.bka.bkb;
            String str2 = jpVar.bka.bkc;
            int i = jpVar.bka.ret;
            if (i != 0 && str2 != null) {
                g.A(this.eQJ, str2, str);
                if (this.eQJ.eQI != null) {
                    ak.yW();
                    com.tencent.mm.model.c.wG().c(this.eQJ.eQI);
                }
            } else if (i == 0 && this.eQJ.ePy) {
                Intent intent = new Intent();
                intent.putExtra("room_name", this.eQJ.eQG);
                this.eQJ.setResult(-1, intent);
                this.eQJ.finish();
            }
            if (this.eQJ.ePC != null) {
                this.eQJ.ePC.dismiss();
            }
            return false;
        }
    };
    private String ePn;
    private boolean ePy = false;
    private String eQG = "";
    private MMEditText eQH;
    private j.b eQI;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ePn = getIntent().getStringExtra("RoomInfo_Id");
        com.tencent.mm.sdk.c.a.nhr.e(this.ePD);
        NI();
    }

    protected final void NI() {
        vD(2131234564);
        this.eQH = (MMEditText) findViewById(2131758330);
        this.eQH.setText(e.a(this, getIntent().getStringExtra("room_name"), this.eQH.getTextSize()));
        this.eQH.setSelection(this.eQH.getText().length());
        this.eQH.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ ModRemarkRoomNameUI eQJ;

            {
                this.eQJ = r1;
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.eQJ.iT(true);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ModRemarkRoomNameUI eQJ;

            {
                this.eQJ = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.eQJ.setResult(0);
                this.eQJ.finish();
                return true;
            }
        });
        a(0, getString(2131231146), new OnMenuItemClickListener(this) {
            final /* synthetic */ ModRemarkRoomNameUI eQJ;

            {
                this.eQJ = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.eQJ.axg();
                String str = "";
                String sL = com.tencent.mm.h.b.sL();
                if (be.kS(sL) || !str.matches(".*[" + sL + "].*")) {
                    com.tencent.mm.ui.tools.a.c.b(this.eQJ.eQH).dw(1, 32).a(this.eQJ);
                    return true;
                }
                g.A(this.eQJ.nDR.nEl, this.eQJ.getString(2131233303, new Object[]{sL}), this.eQJ.getString(2131231164));
                return false;
            }
        }, k.b.nET);
        iT(false);
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        super.onDestroy();
        com.tencent.mm.sdk.c.a.nhr.f(this.ePD);
    }

    protected final int getLayoutId() {
        return 2130904092;
    }

    public final void qK(String str) {
        this.eQG = str;
        ActionBarActivity actionBarActivity = this.nDR.nEl;
        getString(2131231164);
        this.ePC = g.a(actionBarActivity, getString(2131232013), false, null);
        air com_tencent_mm_protocal_c_air = new air();
        com_tencent_mm_protocal_c_air.mbC = new arf().JF(be.ma(this.ePn));
        com_tencent_mm_protocal_c_air.mIW = new arf().JF(be.ma(str));
        this.eQI = new j.a(27, com_tencent_mm_protocal_c_air);
        this.ePy = true;
        ak.yW();
        com.tencent.mm.model.c.wG().b(this.eQI);
    }

    public final void adq() {
        g.f(this, 2131235061, 2131235064);
    }

    public final void adr() {
        g.f(this, 2131235062, 2131235064);
    }
}
