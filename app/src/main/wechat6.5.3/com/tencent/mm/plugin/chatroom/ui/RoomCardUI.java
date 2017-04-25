package com.tencent.mm.plugin.chatroom.ui;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ak.j;
import com.tencent.mm.e.a.jp;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.chatroom.c.m;
import com.tencent.mm.pluginsdk.j.o;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.k;
import com.tencent.mm.ui.tools.h;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.v.e;

public class RoomCardUI extends MMActivity implements e {
    private p dFI;
    private c ePD = new c<jp>(this) {
        final /* synthetic */ RoomCardUI eRi;

        {
            this.eRi = r2;
            this.nhz = jp.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            jp jpVar = (jp) bVar;
            String str = jpVar.bka.bkb;
            String str2 = jpVar.bka.bkc;
            int i = jpVar.bka.ret;
            if (i != 0 && str2 != null) {
                g.A(this.eRi, str2, str);
                if (this.eRi.eQI != null) {
                    ak.yW();
                    com.tencent.mm.model.c.wG().c(this.eRi.eQI);
                }
            } else if (i == 0) {
                if (this.eRi.eRh) {
                    RoomCardUI.a(this.eRi, this.eRi.eQZ.getText().toString());
                } else {
                    this.eRi.adu();
                }
            }
            if (!(this.eRi.eRh || this.eRi.dFI == null || !this.eRi.dFI.isShowing())) {
                this.eRi.dFI.dismiss();
            }
            return false;
        }
    };
    private String eQD;
    private j.b eQI;
    private String eQR;
    private int eQS;
    private String eQT;
    private boolean eQU;
    private String eQV;
    private String eQW;
    private long eQX;
    private TextView eQY;
    private MMEditText eQZ;
    private TextView eRa;
    private TextView eRb;
    private ImageView eRc;
    private LinearLayout eRd;
    private LinearLayout eRe;
    private LinearLayout eRf;
    private LinearLayout eRg;
    private boolean eRh = false;

    private class a implements TextWatcher {
        final /* synthetic */ RoomCardUI eRi;
        private int eRk;
        private String eRl;
        private boolean eRm;

        private a(RoomCardUI roomCardUI) {
            this.eRi = roomCardUI;
            this.eRk = 280;
            this.eRl = "";
            this.eRm = false;
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.eRi.adt();
        }

        public final void afterTextChanged(Editable editable) {
        }
    }

    static /* synthetic */ void a(RoomCardUI roomCardUI) {
        if (roomCardUI.ads()) {
            String str = roomCardUI.eQZ.getText().toString();
            String sL = com.tencent.mm.h.b.sL();
            if (be.kS(sL) || !str.matches(".*[" + sL + "].*")) {
                int i;
                int i2;
                roomCardUI.aJs();
                if (be.kS(roomCardUI.eQZ.getText().toString())) {
                    i = 2131235599;
                    i2 = 2131235598;
                } else {
                    i = 2131234064;
                    i2 = 2131234066;
                }
                g.a(roomCardUI, i, 0, i2, 2131234065, new OnClickListener(roomCardUI) {
                    final /* synthetic */ RoomCardUI eRi;

                    {
                        this.eRi = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        RoomCardUI roomCardUI = this.eRi;
                        ActionBarActivity actionBarActivity = this.eRi.nDR.nEl;
                        this.eRi.getString(2131231164);
                        roomCardUI.dFI = g.a(actionBarActivity, this.eRi.getString(2131234659), false, null);
                        if (this.eRi.ads()) {
                            this.eRi.eRh = false;
                            RoomCardUI.a(this.eRi, this.eRi.eQZ.getText().toString());
                        }
                    }
                }, new OnClickListener(roomCardUI) {
                    final /* synthetic */ RoomCardUI eRi;

                    {
                        this.eRi = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.eRi.adt();
                    }
                });
                return;
            }
            g.A(roomCardUI.nDR.nEl, roomCardUI.getString(2131233303, new Object[]{sL}), roomCardUI.getString(2131231164));
            return;
        }
        roomCardUI.adu();
    }

    static /* synthetic */ void a(RoomCardUI roomCardUI, final TextView textView) {
        l lVar = new l(roomCardUI);
        lVar.jXn = new n.c(roomCardUI) {
            final /* synthetic */ RoomCardUI eRi;

            {
                this.eRi = r1;
            }

            public final void a(com.tencent.mm.ui.base.l lVar) {
                lVar.add(2131231015);
            }
        };
        lVar.jXo = new d(roomCardUI) {
            final /* synthetic */ RoomCardUI eRi;

            public final void c(MenuItem menuItem, int i) {
                if (i == 0) {
                    ((ClipboardManager) textView.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, textView.getText().toString()));
                }
            }
        };
        lVar.aXZ();
    }

    static /* synthetic */ void a(RoomCardUI roomCardUI, String str) {
        if (roomCardUI.ads()) {
            ak.vy().a(new m(roomCardUI.eQD, str), 0);
        }
    }

    protected final int getLayoutId() {
        return 2130904282;
    }

    protected final void NI() {
        vD(2131234631);
        a(0, getString(2131231030), new OnMenuItemClickListener(this) {
            final /* synthetic */ RoomCardUI eRi;

            {
                this.eRi = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (menuItem.getTitle().equals(this.eRi.getString(2131231065))) {
                    RoomCardUI.a(this.eRi);
                }
                this.eRi.eQZ.setEnabled(true);
                this.eRi.eQZ.setFocusableInTouchMode(true);
                this.eRi.eQZ.setFocusable(true);
                this.eRi.eQZ.setCursorVisible(true);
                this.eRi.aq(0, this.eRi.getString(2131231065));
                this.eRi.iT(false);
                this.eRi.aJs();
                this.eRi.eQZ.setSelection(this.eRi.eQZ.getText().toString().length());
                return true;
            }
        }, k.b.nET);
        iT(true);
        this.eRf = (LinearLayout) findViewById(2131758925);
        this.eRg = (LinearLayout) findViewById(2131758931);
        this.eQZ = (MMEditText) findViewById(2131758929);
        this.eRa = (TextView) findViewById(2131758928);
        this.eRb = (TextView) findViewById(2131758927);
        this.eRd = (LinearLayout) findViewById(2131758932);
        this.eRc = (ImageView) findViewById(2131758926);
        this.eRe = (LinearLayout) findViewById(2131758934);
        this.eQZ.setText(this.eQV);
        WindowManager windowManager = (WindowManager) getSystemService("window");
        this.eQZ.setMinHeight(((windowManager.getDefaultDisplay().getHeight() * 2) / 3) - 100);
        com.tencent.mm.pluginsdk.ui.d.e.a(this.eQZ, Integer.valueOf(31), null);
        this.eQY = (TextView) findViewById(2131758930);
        this.eQY.setText(Integer.toString(h.aw(280, this.eQV)));
        this.eRe.setVisibility(8);
        this.eQZ.setCursorVisible(false);
        this.eQZ.setFocusable(false);
        if (this.eQU) {
            this.eRg.setVisibility(8);
        } else {
            vH(0);
            this.eRg.setVisibility(0);
            this.eQZ.setFocusable(false);
            this.eQZ.setCursorVisible(false);
            this.eQZ.setOnLongClickListener(new OnLongClickListener(this) {
                final /* synthetic */ RoomCardUI eRi;

                {
                    this.eRi = r1;
                }

                public final boolean onLongClick(View view) {
                    RoomCardUI.a(this.eRi, this.eRi.eQZ);
                    return true;
                }
            });
        }
        if (this.eQX != 0) {
            this.eRa.setVisibility(0);
            this.eRa.setText(o.F("yyyy-MM-dd HH:mm", this.eQX));
        } else {
            this.eRa.setVisibility(8);
        }
        if (be.kS(this.eQV)) {
            this.eQZ.setEnabled(true);
            this.eQZ.setFocusableInTouchMode(true);
            this.eQZ.setFocusable(true);
            this.eRf.setVisibility(8);
            this.eQZ.setMinHeight(((windowManager.getDefaultDisplay().getHeight() * 2) / 3) + 100);
            this.eQZ.requestFocus();
            this.eQZ.setCursorVisible(true);
            aq(0, this.nDR.nEl.getString(2131231065));
            adt();
            this.eQZ.performClick();
            aJs();
        } else {
            this.eRf.setVisibility(0);
        }
        this.eRb.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this, com.tencent.mm.model.l.er(this.eQW), this.eRb.getTextSize()));
        ImageView imageView = this.eRc;
        String str = this.eQW;
        if (be.kS(str)) {
            imageView.setImageResource(2130838080);
        } else {
            com.tencent.mm.pluginsdk.ui.a.b.m(imageView, str);
        }
        this.eQZ.addTextChangedListener(new a());
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.plugin.report.service.g.iuh.a(219, 0, 1, true);
        ak.vy().a(993, this);
        com.tencent.mm.sdk.c.a.nhr.e(this.ePD);
        this.eQD = getIntent().getStringExtra("RoomInfo_Id");
        this.eQV = getIntent().getStringExtra("room_notice");
        this.eQW = getIntent().getStringExtra("room_notice_editor");
        this.eQX = getIntent().getLongExtra("room_notice_publish_time", 0);
        this.eQR = getIntent().getStringExtra("room_name");
        this.eQS = getIntent().getIntExtra("room_member_count", 0);
        this.eQT = getIntent().getStringExtra("room_owner_name");
        this.eQU = getIntent().getBooleanExtra("Is_RoomOwner", false);
        NI();
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ RoomCardUI eRi;

            {
                this.eRi = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.eRi.goBack();
                return true;
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
        ak.vy().b(993, this);
        com.tencent.mm.sdk.c.a.nhr.f(this.ePD);
        if (this.dFI != null && this.dFI.isShowing()) {
            this.dFI.dismiss();
        }
    }

    private void goBack() {
        if (!this.eQU) {
            setResult(0);
            finish();
        } else if (ads()) {
            g.b(this, getString(2131234565), null, getString(2131234567), getString(2131234566), new OnClickListener(this) {
                final /* synthetic */ RoomCardUI eRi;

                {
                    this.eRi = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            }, new OnClickListener(this) {
                final /* synthetic */ RoomCardUI eRi;

                {
                    this.eRi = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.eRi.setResult(0);
                    this.eRi.finish();
                }
            });
        } else {
            setResult(0);
            finish();
        }
    }

    private boolean ads() {
        String obj = this.eQZ.getText().toString();
        if (be.kS(obj)) {
            if (be.kS(this.eQV)) {
                return false;
            }
            return true;
        } else if (this.eQV == null || !this.eQV.equals(obj)) {
            return true;
        } else {
            return false;
        }
    }

    private void adt() {
        if (ads()) {
            iT(true);
        } else {
            iT(false);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4) {
            return false;
        }
        goBack();
        return true;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 1) {
            this.eQU = false;
            if (!this.eQU) {
                this.eRe.setVisibility(8);
                this.eQZ.setFocusableInTouchMode(false);
                this.eQZ.setFocusable(false);
                this.eRe.setVisibility(8);
            }
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        if (this.dFI != null && this.dFI.isShowing()) {
            this.dFI.dismiss();
        }
        if (kVar.getType() == 993) {
            if (this.dFI != null && this.dFI.isShowing()) {
                this.dFI.dismiss();
            }
            if (i == 0 && i2 == 0) {
                v.i("MicroMsg.RoomInfoUI", "dz[onSceneEnd : set announcement successfully!]");
                this.eQV = this.eQZ.getText().toString();
                com.tencent.mm.plugin.report.service.g.iuh.a(219, 15, 1, true);
                adu();
                return;
            }
            v.w("MicroMsg.RoomInfoUI", "dz[handleSetNoticeFailed:%s]", new Object[]{str});
            s.makeText(this, 2131234653, 1).show();
            v.i("MicroMsg.RoomInfoUI", "dz[onSceneEnd : set announcement failed:%d %d %s]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            return;
        }
        v.w("MicroMsg.RoomInfoUI", "error cgi type callback:[%d]", new Object[]{Integer.valueOf(kVar.getType())});
    }

    private void adu() {
        Intent intent = new Intent();
        intent.putExtra("room_name", this.eQR);
        intent.putExtra("room_notice", this.eQV);
        setResult(-1, intent);
        finish();
    }
}
