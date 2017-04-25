package com.tencent.mm.plugin.qqmail.ui;

import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ae.d;
import com.tencent.mm.ae.j;
import com.tencent.mm.ae.n;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.v.e;
import com.tencent.mm.v.f;
import com.tencent.mm.v.k;

public class MailImageDownloadUI extends MMActivity implements e, f {
    private long bao = 0;
    private long bmL = 0;
    private int cLy;
    private ac handler = new ac(Looper.getMainLooper());
    private ProgressBar ifM;
    private TextView ifN;
    private TextView ifO;
    private TextView ifP;
    private TextView ifQ;
    private RelativeLayout ifR;
    private d ifS;
    private j ifT;
    private ImageView ifU;
    private LinearLayout ifV;
    private String username;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bao = getIntent().getLongExtra("img_msg_id", 0);
        this.bmL = getIntent().getLongExtra("img_server_id", 0);
        this.cLy = getIntent().getIntExtra("img_download_compress_type", 0);
        this.username = getIntent().getStringExtra("img_download_username");
        NI();
        if (this.bao > 0) {
            this.ifS = n.GH().ai(this.bao);
        }
        if ((this.ifS == null || this.ifS.cLu <= 0) && this.bmL > 0) {
            this.ifS = n.GH().ah(this.bmL);
        }
        if (this.ifS == null || this.ifS.cLu <= 0) {
            v.e("MicroMsg.MailImageDownloadUI", "onCreate : on such imginfo, with msgLocalId = " + this.bao + ", or msgSvrId = " + this.bmL);
            return;
        }
        if (this.bao <= 0 && this.bmL > 0) {
            ak.yW();
            this.bao = c.wJ().S(this.username, this.bmL).field_msgId;
        }
        String str = this.ifS.cLv;
        String l = n.GH().l(str, null, null);
        if (be.kS(str) || !com.tencent.mm.a.e.aR(l)) {
            this.ifT = new j(this.ifS.cLu, this.bao, this.cLy, this);
            ak.vy().a(this.ifT, 0);
            return;
        }
        v.i("MicroMsg.MailImageDownloadUI", "has big image, bigImgPath = %s, hasHDImg = %b, fullPath = %s", new Object[]{str, Boolean.valueOf(this.ifS.Gp()), l});
        if (l == null || l.equals("") || !com.tencent.mm.a.e.aR(l)) {
            v.d("MicroMsg.MailImageDownloadUI", "showImg : imgPath is null");
            return;
        }
        this.ifV.setVisibility(8);
        this.ifM.setVisibility(8);
        this.ifU.setVisibility(0);
        this.ifU.setImageBitmap(com.tencent.mm.sdk.platformtools.d.JV(l));
        this.ifR.invalidate();
    }

    protected final int getLayoutId() {
        return 2130903916;
    }

    protected void onPause() {
        super.onPause();
        ak.vy().b(109, this);
    }

    protected void onResume() {
        super.onResume();
        ak.vy().a(109, this);
    }

    protected final void NI() {
        this.ifN = (TextView) findViewById(2131757991);
        this.ifO = (TextView) findViewById(2131757991);
        this.ifP = (TextView) findViewById(2131757992);
        this.ifQ = (TextView) findViewById(2131757993);
        this.ifU = (ImageView) findViewById(2131757989);
        this.ifN.setVisibility(0);
        this.ifV = (LinearLayout) findViewById(2131757990);
        this.ifR = (RelativeLayout) findViewById(2131757987);
        this.ifO.setVisibility(8);
        this.ifP.setVisibility(8);
        this.ifQ.setVisibility(8);
        vB(8);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ MailImageDownloadUI ifW;

            {
                this.ifW = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                ak.vy().c(this.ifW.ifT);
                this.ifW.finish();
                return true;
            }
        });
        this.ifM = (ProgressBar) findViewById(2131757988);
    }

    private void oA(int i) {
        this.ifN.setText(getString(2131232891, new Object[]{Integer.valueOf(i)}));
        if (i >= this.ifM.getMax()) {
            d b = n.GH().b(Long.valueOf(this.ifT.cMQ));
            if (this.cLy == 1) {
                com.tencent.mm.ae.e.c(b);
            }
            finish();
            startActivity(getIntent());
        }
    }

    public final void a(int i, int i2, k kVar) {
        v.d("MicroMsg.MailImageDownloadUI", "offset " + i + "totaolLen  " + i2);
        if (kVar.getType() == 109) {
            oA(Math.max(0, i2 != 0 ? ((i * 100) / i2) - 1 : 0));
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 109) {
            if (i == 0 && i2 == 0) {
                oA(this.ifM.getMax());
                return;
            }
            v.e("MicroMsg.MailImageDownloadUI", "onSceneEnd : fail, errType = " + i + ", errCode = " + i2);
            Toast.makeText(this, 2131233292, 1).show();
        }
    }
}
