package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.an.c;
import com.tencent.mm.an.c.a;
import com.tencent.mm.model.ak;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;

public class ContactRemarkInfoViewUI extends MMActivity {
    private String aGY;
    private String bCt;
    private String cUH;
    private u euW;
    private int hUa;
    private TextView oFA;
    private TextView oFB;
    private ImageView oFE;
    private boolean oFL = false;
    private View oGg;
    private View oGh;
    private String username;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hUa = getIntent().getIntExtra("Contact_Scene", 9);
        this.username = getIntent().getStringExtra("Contact_User");
        if (t.kS(this.username)) {
            finish();
            return;
        }
        NH();
        NI();
    }

    public void onResume() {
        super.onResume();
        NH();
        this.oFA.setText(e.a(this, t.ma(this.aGY), this.oFA.getTextSize()));
        if (t.kS(this.bCt)) {
            this.oGg.setVisibility(8);
        } else {
            this.oGg.setVisibility(0);
            this.oFB.setText(t.ma(this.bCt));
        }
        if (t.kS(this.cUH)) {
            this.oGh.setVisibility(8);
            return;
        }
        this.oGh.setVisibility(0);
        c.HV();
        if (c.jx(this.username)) {
            bHt();
        } else {
            c.HV().a(this.username, this.cUH, new a(this) {
                final /* synthetic */ ContactRemarkInfoViewUI oGi;

                {
                    this.oGi = r1;
                }

                public final void bd(final boolean z) {
                    this.oGi.oFE.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass4 oGj;

                        public final void run() {
                            if (z) {
                                this.oGj.oGi.bHt();
                            } else {
                                g.bf(this.oGj.oGi, this.oGj.oGi.getString(2131231042));
                            }
                        }
                    });
                }
            });
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return 2130903426;
    }

    private void NH() {
        ak.yW();
        this.euW = com.tencent.mm.model.c.wH().LX(this.username);
        this.aGY = this.euW.tU();
        this.bCt = this.euW.bCt;
        this.cUH = this.euW.bCu;
    }

    protected final void NI() {
        this.oFA = (TextView) findViewById(2131756516);
        this.oFB = (TextView) findViewById(2131756527);
        this.oFE = (ImageView) findViewById(2131756530);
        this.oGg = findViewById(2131756531);
        this.oGh = findViewById(2131756532);
        vD(2131232092);
        this.oFE.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ContactRemarkInfoViewUI oGi;

            {
                this.oGi = r1;
            }

            public final void onClick(View view) {
                if (this.oGi.oFL) {
                    Intent intent = new Intent(this.oGi, ContactRemarkImagePreviewUI.class);
                    intent.putExtra("Contact_User", this.oGi.username);
                    c.HV();
                    intent.putExtra("remark_image_path", c.jw(this.oGi.username));
                    intent.putExtra("view_only", true);
                    this.oGi.startActivity(intent);
                }
            }
        });
        a(0, getString(2131231030), new OnMenuItemClickListener(this) {
            final /* synthetic */ ContactRemarkInfoViewUI oGi;

            {
                this.oGi = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent();
                intent.setClass(this.oGi.nDR.nEl, ContactRemarkInfoModUI.class);
                intent.putExtra("Contact_Scene", this.oGi.hUa);
                intent.putExtra("Contact_User", this.oGi.euW.field_username);
                this.oGi.startActivity(intent);
                return false;
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ContactRemarkInfoViewUI oGi;

            {
                this.oGi = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.oGi.finish();
                return true;
            }
        });
    }

    private void bHt() {
        Bitmap jz = c.HV().jz(this.username);
        if (jz != null) {
            this.oFE.setImageBitmap(jz);
            this.oFL = true;
        }
    }
}
