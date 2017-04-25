package com.tencent.mm.plugin.chatroom.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ay.c;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ab.a;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.chatroom.c.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.v.e;

public class RoomUpgradeUI extends MMActivity implements e {
    private String biB;
    private ProgressDialog dwR = null;
    private int eOQ;
    private int eOR;
    private o ePs;
    private View eRG;
    private ImageView eRH;
    private TextView eRI;
    private TextView eRJ;
    private TextView eRK;
    private TextView eRO;
    private View eRP;
    private TextView eRQ;
    private h eRR;
    private String eRS;
    private boolean eRT;
    private boolean eRU;
    private int status;

    static /* synthetic */ void a(RoomUpgradeUI roomUpgradeUI, boolean z) {
        Intent intent = new Intent(roomUpgradeUI, RoomAnnouncementUI.class);
        intent.putExtra("need_bind_mobile", z);
        intent.putExtra("RoomInfo_Id", roomUpgradeUI.biB);
        roomUpgradeUI.startActivityForResult(intent, 600);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NH();
        NI();
    }

    public void onNewIntent(Intent intent) {
        boolean booleanExtra;
        if (intent.hasExtra("upgrade_success")) {
            booleanExtra = intent.getBooleanExtra("upgrade_success", false);
        } else {
            if (intent.hasExtra("wizard_activity_result_code") && intent.getIntExtra("wizard_activity_result_code", -1) == -1) {
                adx();
            }
            if (intent.hasExtra("announce_ok")) {
                adx();
            }
            booleanExtra = false;
        }
        if (booleanExtra) {
            NH();
            int intExtra = intent.getIntExtra("left_quota", 0);
            ady();
            this.eRQ.setVisibility(8);
            this.eOR = intExtra;
            if (this.eOR > 0) {
                this.eRK.setText(getString(2131234680, new Object[]{Integer.valueOf(this.eOR)}));
            } else {
                this.eRK.setText(getString(2131234681));
            }
            if (!this.eRU) {
                this.eRO.setVisibility(0);
            }
            this.eRO.setText(2131234677);
        }
    }

    private void adx() {
        Intent intent = new Intent(this, RoomAlphaProcessUI.class);
        intent.addFlags(67108864);
        intent.addFlags(65536);
        intent.putExtra("RoomInfo_Id", this.biB);
        startActivity(intent);
    }

    private void NH() {
        boolean z = true;
        this.biB = getIntent().getStringExtra("room_name");
        v.i("MicroMsg.RoomUpgradeProductsUI", "the roomName is %s", new Object[]{this.biB});
        ak.vy().a(519, this);
        this.ePs = ak.yW().wO().LC(this.biB);
        if (this.ePs == null) {
            finish();
            return;
        }
        this.eRT = k.xF().equals(this.ePs.field_roomowner);
        if (u.bsV()) {
            z = false;
        }
        this.eRU = z;
    }

    protected final void NI() {
        vD(2131234674);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ RoomUpgradeUI eRV;

            {
                this.eRV = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.eRV.finish();
                return true;
            }
        });
        this.eRG = findViewById(2131756030);
        this.eRP = findViewById(2131756033);
        this.eRH = (ImageView) findViewById(2131756031);
        this.eRI = (TextView) findViewById(2131756032);
        this.eRJ = (TextView) findViewById(2131756034);
        this.eRK = (TextView) findViewById(2131756036);
        this.eRQ = (TextView) findViewById(2131756035);
        this.eRQ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ RoomUpgradeUI eRV;

            {
                this.eRV = r1;
            }

            public final void onClick(View view) {
                switch (this.eRV.status) {
                    case 1:
                        if (this.eRV.eRU) {
                            a.a(this.eRV, this.eRV.biB, true);
                            return;
                        } else {
                            RoomUpgradeUI.a(this.eRV, true);
                            return;
                        }
                    case 2:
                    case 5:
                        if (this.eRV.eRU) {
                            this.eRV.adx();
                            return;
                        } else {
                            RoomUpgradeUI.a(this.eRV, false);
                            return;
                        }
                    default:
                        return;
                }
            }
        });
        this.eRO = (TextView) findViewById(2131756037);
        this.eRO.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ RoomUpgradeUI eRV;

            {
                this.eRV = r1;
            }

            public final void onClick(View view) {
                if (this.eRV.eRO.getVisibility() == 0) {
                    Intent intent = new Intent();
                    this.eRV.eRS = this.eRV.getString(2131231754, new Object[]{u.bsY()});
                    intent.putExtra("rawUrl", this.eRV.eRS);
                    intent.putExtra("geta8key_username", k.xF());
                    intent.putExtra("showShare", false);
                    c.b(this.eRV, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent, 500);
                }
            }
        });
        if (this.eRT) {
            this.dwR = g.a(this, getString(2131233521), true, new OnCancelListener(this) {
                final /* synthetic */ RoomUpgradeUI eRV;

                {
                    this.eRV = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    if (this.eRV.eRR != null) {
                        ak.vy().c(this.eRV.eRR);
                        this.eRV.eRR = null;
                    }
                    this.eRV.finish();
                }
            });
            this.eRR = new h(this.biB);
            ak.vy().a(this.eRR, 0);
        } else {
            ady();
            if (!this.eRU) {
                this.eRO.setVisibility(0);
            }
            this.eRO.setText(2131234677);
            this.eRQ.setVisibility(8);
            this.eRK.setVisibility(8);
        }
        if (this.eRU) {
            this.eRO.setVisibility(8);
        }
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        ak.vy().c(this.eRR);
        ak.vy().b(519, this);
        if (this.dwR != null) {
            this.dwR.dismiss();
        }
        super.onDestroy();
    }

    private void ady() {
        final String str = this.ePs.field_roomowner;
        ak.yW();
        com.tencent.mm.storage.u LX = com.tencent.mm.model.c.wH().LX(str);
        if (LX == null || ((int) LX.chr) > 0) {
            qL(str);
        } else {
            a.crZ.a(str, this.biB, new ab.c.a(this) {
                final /* synthetic */ RoomUpgradeUI eRV;

                public final void p(String str, boolean z) {
                    if (z) {
                        this.eRV.eRG.post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass4 eRW;

                            {
                                this.eRW = r1;
                            }

                            public final void run() {
                                this.eRW.eRV.qL(str);
                            }
                        });
                    }
                }
            });
        }
        int bvg = this.ePs.bvg();
        this.eRJ.setVisibility(0);
        if (bvg <= 40) {
            this.eRJ.setText(getString(2131234682, new Object[]{getString(2131234676)}));
            return;
        }
        this.eRJ.setText(getString(2131234682, new Object[]{getString(2131234675)}));
    }

    private void qL(String str) {
        String str2;
        CharSequence charSequence = null;
        ak.yW();
        com.tencent.mm.storage.u LX = com.tencent.mm.model.c.wH().LX(str);
        if (LX == null || ((int) LX.chr) <= 0) {
            str2 = null;
        } else {
            str2 = LX.field_conRemark;
        }
        if (!be.kS(str2)) {
            Object obj = str2;
        } else if (this.ePs != null) {
            charSequence = this.ePs.er(str);
        }
        if (be.kS(charSequence) && LX != null && ((int) LX.chr) > 0) {
            charSequence = LX.tT();
        }
        if (be.kS(charSequence)) {
            charSequence = str;
        }
        b.m(this.eRH, str);
        this.eRI.setVisibility(0);
        this.eRI.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this, charSequence, (int) this.eRI.getTextSize()));
    }

    public final int getLayoutId() {
        return 2130903278;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        v.d("MicroMsg.RoomUpgradeProductsUI", "onActivityResult . requestCode:" + i + "  resultCode:" + i2);
        switch (i) {
            case 400:
                finish();
                return;
            default:
                v.e("MicroMsg.RoomUpgradeProductsUI", "onActivityResult unknow request");
                return;
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        v.d("MicroMsg.RoomUpgradeProductsUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.dwR != null) {
            this.dwR.dismiss();
        }
        if (i != 0 || i2 != 0) {
            g.a(this, getString(2131234679), getString(2131231164), false, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ RoomUpgradeUI eRV;

                {
                    this.eRV = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.eRV.finish();
                }
            });
        } else if (i == 0 && i2 == 0 && kVar.getType() == 519) {
            h hVar = (h) kVar;
            this.status = hVar.status;
            this.eOQ = hVar.eOQ;
            this.eOR = hVar.eOR;
            ady();
            this.eRK.setVisibility(0);
            this.eRQ.setText(getString(2131234673));
            if (this.eOR > 0) {
                this.eRK.setText(getString(2131234680, new Object[]{Integer.valueOf(this.eOR)}));
            } else {
                this.eRK.setText(getString(2131234681));
            }
            if (!this.eRU) {
                this.eRO.setVisibility(0);
            }
            switch (this.status) {
                case 1:
                case 2:
                case 5:
                    this.eRQ.setVisibility(0);
                    this.eRO.setText(2131234678);
                    return;
                case 3:
                case 4:
                case 6:
                    this.eRQ.setVisibility(0);
                    this.eRQ.setEnabled(false);
                    this.eRO.setText(2131234678);
                    return;
                case 7:
                    this.eRQ.setVisibility(8);
                    this.eRO.setText(2131234677);
                    this.eRQ.setEnabled(false);
                    return;
                default:
                    return;
            }
        }
    }
}
