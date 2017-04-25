package com.tencent.mm.plugin.nearby.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.storage.r;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;

public class NearbyFriendsIntroUI extends MMActivity {
    private Button emR;
    private View hEY;
    private CheckBox hEZ;
    private h hFb = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vD(2131234007);
        NI();
    }

    protected final int getLayoutId() {
        return 2130904115;
    }

    protected final void NI() {
        this.hEY = View.inflate(this, 2130903854, null);
        this.hEZ = (CheckBox) this.hEY.findViewById(2131757691);
        this.hEZ.setChecked(false);
        this.emR = (Button) findViewById(2131758409);
        this.emR.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ NearbyFriendsIntroUI hFh;

            {
                this.hFh = r1;
            }

            public final void onClick(View view) {
                if (this.hFh.hFb == null) {
                    this.hFh.hFb = g.a(this.hFh.nDR.nEl, this.hFh.getString(2131231164), this.hFh.hEY, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass1 hFi;

                        {
                            this.hFi = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            boolean z = true;
                            ak.yW();
                            c.vf().set(4103, Boolean.valueOf(true));
                            ak.yW();
                            r vf = c.vf();
                            if (this.hFi.hFh.hEZ.isChecked()) {
                                z = false;
                            }
                            vf.set(4104, Boolean.valueOf(z));
                            bf zP = bf.zP();
                            if (zP == null) {
                                this.hFi.hFh.startActivity(new Intent(this.hFi.hFh, NearbyPersonalInfoUI.class));
                            } else {
                                String ma = be.ma(zP.getProvince());
                                be.ma(zP.getCity());
                                int a = be.a(Integer.valueOf(zP.bBZ), 0);
                                if (ma.equals("") || a == 0) {
                                    this.hFi.hFh.startActivity(new Intent(this.hFi.hFh, NearbyPersonalInfoUI.class));
                                } else {
                                    this.hFi.hFh.startActivity(new Intent(this.hFi.hFh, NearbyFriendsUI.class));
                                }
                            }
                            this.hFi.hFh.finish();
                        }
                    }, null);
                } else {
                    this.hFh.hFb.show();
                }
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ NearbyFriendsIntroUI hFh;

            {
                this.hFh = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.hFh.axg();
                this.hFh.finish();
                return true;
            }
        });
    }
}
