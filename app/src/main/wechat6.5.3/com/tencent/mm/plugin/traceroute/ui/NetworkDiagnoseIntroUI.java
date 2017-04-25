package com.tencent.mm.plugin.traceroute.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.traceroute.a.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;

public class NetworkDiagnoseIntroUI extends MMActivity {
    private Button knk;
    private TextView knl;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
    }

    protected final void NI() {
        this.knk = (Button) findViewById(2131758434);
        this.knk.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ NetworkDiagnoseIntroUI knm;

            {
                this.knm = r1;
            }

            public final void onClick(View view) {
                ak.yW();
                if (!c.isSDCardAvailable()) {
                    s.ey(this.knm);
                } else if (ak.vy().BJ() == 0) {
                    Toast.makeText(this.knm, this.knm.getString(2131232875), 0).show();
                } else {
                    this.knm.startActivity(new Intent(this.knm, NetworkDiagnoseUI.class));
                    this.knm.finish();
                }
            }
        });
        this.knl = (TextView) findViewById(2131758435);
        this.knl.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ NetworkDiagnoseIntroUI knm;

            {
                this.knm = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra(FFmpegMetadataRetriever.METADATA_KEY_TITLE, this.knm.getString(2131234246));
                intent.putExtra("rawUrl", this.knm.getString(2131235735));
                intent.putExtra("showShare", false);
                a.drp.j(intent, this.knm.nDR.nEl);
            }
        });
        Fd("");
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ NetworkDiagnoseIntroUI knm;

            {
                this.knm = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.knm.finish();
                return true;
            }
        });
    }

    protected final int getLayoutId() {
        return 2130904123;
    }
}
