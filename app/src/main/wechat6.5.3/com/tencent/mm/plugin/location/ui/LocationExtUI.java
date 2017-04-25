package com.tencent.mm.plugin.location.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.ay.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.k.b;
import java.util.ArrayList;

public class LocationExtUI extends MMActivity {
    private ArrayList<String> fpU = new ArrayList();
    private TextView gTO;
    private TextView gTP;
    private String gTQ;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        CharSequence stringExtra = getIntent().getStringExtra("Kwebmap_locaion");
        if (be.kS(stringExtra)) {
            findViewById(2131757708).setVisibility(8);
        } else {
            ((TextView) findViewById(2131757709)).setText(stringExtra);
        }
        this.gTO = (TextView) findViewById(2131757707);
        this.gTP = (TextView) findViewById(2131757706);
        this.gTO.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LocationExtUI gTR;

            {
                this.gTR = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("key_fav_result_list", this.gTR.fpU);
                c.b(this.gTR.nDR.nEl, "favorite", ".ui.FavTagEditUI", intent, 4098);
            }
        });
        this.gTP.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LocationExtUI gTR;

            {
                this.gTR = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent(this.gTR.nDR.nEl, RemarkUI.class);
                intent.putExtra("key_nullable", true);
                intent.putExtra("key_value", this.gTR.getIntent().getStringExtra("key_value"));
                intent.putExtra("key_hint", this.gTR.getString(2131233534));
                intent.putExtra("Kwebmap_locaion", this.gTR.getIntent().getStringExtra("Kwebmap_locaion"));
                intent.putExtra("MMActivity.OverrideExitAnimation", 2130968644);
                intent.putExtra("MMActivity.OverrideEnterAnimation", 2130968622);
                intent.putExtra("kFavInfoLocalId", this.gTR.getIntent().getLongExtra("kFavInfoLocalId", -1));
                intent.putExtra("kRemark", this.gTR.getIntent().getStringExtra("kRemark"));
                this.gTR.startActivityForResult(intent, 4097);
            }
        });
        a(0, getString(2131231065), new OnMenuItemClickListener(this) {
            final /* synthetic */ LocationExtUI gTR;

            {
                this.gTR = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent();
                intent.putExtra("key_remark_result", this.gTR.gTQ);
                intent.putExtra("key_tags_result", this.gTR.fpU);
                this.gTR.setResult(-1, intent);
                this.gTR.finish();
                return true;
            }
        }, b.nET);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ LocationExtUI gTR;

            {
                this.gTR = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.gTR.finish();
                return true;
            }
        });
    }

    protected final int getLayoutId() {
        return 2130903865;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (4097 == i) {
            if (-1 == i2 && intent != null) {
                CharSequence charSequenceExtra = intent.getCharSequenceExtra("key_result");
                this.gTQ = charSequenceExtra == null ? "" : charSequenceExtra.toString();
                this.gTP.setText(this.gTQ);
            }
        } else if (4098 != i) {
            super.onActivityResult(i, i2, intent);
        } else if (-1 == i2 && intent != null) {
            this.fpU.clear();
            String[] stringArrayExtra = intent.getStringArrayExtra("key_fav_result_array");
            if (stringArrayExtra != null && stringArrayExtra.length > 0) {
                CharSequence charSequence = stringArrayExtra[0];
                this.fpU.add(stringArrayExtra[0]);
                String string = getResources().getString(2131232743);
                for (int i3 = 1; i3 < stringArrayExtra.length; i3++) {
                    this.fpU.add(stringArrayExtra[i3]);
                    charSequence = charSequence + string + stringArrayExtra[i3];
                }
                this.gTO.setText(charSequence);
            }
        }
    }
}
