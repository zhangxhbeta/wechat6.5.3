package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiShareAppMessage;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;

public class VoicePrintFinishUI extends MMActivity {
    private TextView eXB;
    private TextView kpT;
    private Button kpU;
    private ImageView kpV;
    private int kpW;

    public void onCreate(Bundle bundle) {
        v.i("MicroMsg.VoicePrintFinishUI", "VoicePrintFinishUI");
        super.onCreate(bundle);
        this.nDR.bAj();
        this.kpW = getIntent().getIntExtra("kscene_type", 73);
        v.d("MicroMsg.VoicePrintFinishUI", "onCreate, sceneType:%d", new Object[]{Integer.valueOf(this.kpW)});
        this.eXB = (TextView) findViewById(2131759656);
        this.kpT = (TextView) findViewById(2131759657);
        this.kpU = (Button) findViewById(2131756773);
        this.kpV = (ImageView) findViewById(2131759654);
        switch (this.kpW) {
            case j.CTRL_INDEX /*72*/:
                this.eXB.setText(2131235828);
                this.kpT.setText(2131235829);
                this.kpV.setVisibility(0);
                this.kpU.setText(2131235204);
                break;
            case JsApiShareAppMessage.CTRL_INDEX /*73*/:
                this.eXB.setVisibility(8);
                this.kpT.setText(2131235849);
                this.kpV.setVisibility(0);
                this.kpU.setText(2131235205);
                break;
        }
        this.kpU.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ VoicePrintFinishUI kpX;

            {
                this.kpX = r1;
            }

            public final void onClick(View view) {
                if (this.kpX.kpW == 72) {
                    Intent intent = new Intent();
                    intent.setClass(this.kpX, VoiceUnLockUI.class);
                    intent.putExtra("kscene_type", 73);
                    this.kpX.startActivity(intent);
                }
                this.kpX.finish();
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ VoicePrintFinishUI kpX;

            {
                this.kpX = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.kpX.finish();
                return true;
            }
        });
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return 2130904584;
    }
}
