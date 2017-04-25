package com.tencent.mm.plugin.ipcall.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;

@a(3)
public class IPCallAcitivityUI extends MMActivity {
    private FrameLayout gJt;
    private TextView gJu;
    private TextView gJv;
    private Button gJw;
    private CdnImageView gJx;
    private boolean gJy = false;
    private com.tencent.mm.plugin.ipcall.a.g.a gJz;

    protected final int NO() {
        return 1;
    }

    protected final int getLayoutId() {
        return 2130903826;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(131072);
        getWindow().setFlags(1024, 1024);
        this.nDR.bAj();
        NI();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected final void NI() {
        this.gJt = (FrameLayout) findViewById(2131757583);
        this.gJu = (TextView) findViewById(2131757585);
        this.gJv = (TextView) findViewById(2131757587);
        this.gJw = (Button) findViewById(2131757589);
        this.gJx = (CdnImageView) findViewById(2131757588);
        this.gJt.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ IPCallAcitivityUI gJA;

            {
                this.gJA = r1;
            }

            public final void onClick(View view) {
                this.gJA.finish();
            }
        });
        this.gJw.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ IPCallAcitivityUI gJA;

            {
                this.gJA = r1;
            }

            public final void onClick(View view) {
                this.gJA.gJy = true;
                this.gJA.finish();
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ IPCallAcitivityUI gJA;

            {
                this.gJA = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.gJA.finish();
                return true;
            }
        });
        ak.yW();
        String str = (String) c.vf().get(t.a.nqX, "");
        if (be.kS(str)) {
            v.e("MicroMsg.IPCallAcitivityUI", "xml is empty");
            finish();
            return;
        }
        this.gJz = com.tencent.mm.plugin.ipcall.a.g.a.uI(str);
        this.gJu.setText(this.gJz.aXz);
        this.gJv.setText(this.gJz.gkC);
        this.gJw.setText(this.gJz.gIz);
        this.gJx.G(this.gJz.gmz, 0, 0);
    }

    public void finish() {
        super.finish();
        overridePendingTransition(2130968589, 2130968642);
        if (this.gJy) {
            com.tencent.mm.plugin.ipcall.a.e.c.lZ(1);
        } else {
            com.tencent.mm.plugin.ipcall.a.e.c.lZ(0);
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
    }
}
