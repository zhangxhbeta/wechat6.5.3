package com.tencent.mm.ui.account;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ay.c;
import com.tencent.mm.model.ai;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mmdb.database.SQLiteDatabase;

public class LoginVoiceUI extends LoginHistoryUI {
    private LinearLayout nIT;
    private LinearLayout nIU;
    private View nJY;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!this.nJp) {
            Intent intent = getIntent();
            if (intent != null) {
                boolean booleanExtra = intent.getBooleanExtra("login_success_need_bind_fingerprint", false);
                this.nJr = booleanExtra;
                if (booleanExtra) {
                    this.nJs = intent.getStringExtra("bind_login_fingerprint_info");
                }
            }
            this.nIT = (LinearLayout) findViewById(2131757726);
            this.nIU = (LinearLayout) findViewById(2131757727);
            this.nIT.setVisibility(8);
            this.nIU.setVisibility(0);
            this.nJY = findViewById(2131757728);
            this.nJf.setVisibility(8);
            this.nJd.setVisibility(8);
            this.nJg.setVisibility(0);
            this.nJf.setText(2131233563);
            this.nJf.setEnabled(true);
            findViewById(2131757729).setEnabled(false);
            ((TextView) findViewById(2131757730)).setTextColor(getResources().getColorStateList(2131690182));
            ((TextView) findViewById(2131757730)).setBackgroundResource(getResources().getColor(2131690078));
            this.nJY.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ LoginVoiceUI nJZ;

                {
                    this.nJZ = r1;
                }

                public final void onClick(View view) {
                    g.iuh.h(11557, Integer.valueOf(2));
                    String A = ai.cse.A("login_user_name", SQLiteDatabase.KeyEmpty);
                    Intent intent = new Intent();
                    intent.putExtra("Kusername", A);
                    intent.putExtra("kscene_type", 1);
                    c.b(this.nJZ.nDR.nEl, "voiceprint", ".ui.VoiceLoginUI", intent, 1024);
                }
            });
            this.nJf.setBackgroundResource(2130837800);
            this.nJf.setTextColor(getResources().getColor(2131690144));
            this.nJf.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ LoginVoiceUI nJZ;

                {
                    this.nJZ = r1;
                }

                public final void onClick(View view) {
                    g.iuh.h(11557, Integer.valueOf(3));
                    this.nJZ.finish();
                    this.nJZ.startActivity(new Intent(this.nJZ, LoginHistoryUI.class));
                }
            });
            this.nJg.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ LoginVoiceUI nJZ;

                {
                    this.nJZ = r1;
                }

                public final void onClick(View view) {
                    g.iuh.h(11557, Integer.valueOf(3));
                    this.nJZ.finish();
                    this.nJZ.startActivity(new Intent(this.nJZ, LoginHistoryUI.class));
                }
            });
        }
    }

    public final boolean bAQ() {
        return false;
    }
}
