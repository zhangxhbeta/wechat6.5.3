package com.tencent.mm.plugin.qqmail.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.qqmail.b.n;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.k;
import com.tencent.mm.v.e;

public class RoomInfoShareQrUI extends ComposeUI implements e {
    private Bitmap cxY = null;
    private ProgressDialog dwR = null;
    private EditText icX = null;
    private ImageView ihj;
    private LinearLayout ihk;
    private LinearLayout ihl;
    private LinearLayout ihm;
    private String userName = "";

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ak.vy().a(340, this);
        this.userName = getIntent().getStringExtra("from_userName");
        this.cxY = d.JV(getIntent().getStringExtra("qrcode_file_path"));
        v.d("MicroMsg.RoomInfoShareQrUI", "userName %s", new Object[]{this.userName});
        vD(2131234640);
        findViewById(2131758706).setVisibility(8);
        findViewById(2131758716).setVisibility(8);
        findViewById(2131758722).setVisibility(8);
        findViewById(2131758723).setVisibility(0);
        ((TextView) findViewById(2131758702)).setText(" " + getString(2131234214));
        this.icX = (EditText) findViewById(2131758714);
        this.icX.setText(2131234611);
        this.icX.setEnabled(false);
        this.icX.setVisibility(8);
        this.ihk = (LinearLayout) findViewById(2131758280);
        this.ihk.setBackgroundResource(2131689938);
        this.ihl = (LinearLayout) findViewById(2131758713);
        this.ihl.setVisibility(8);
        this.ihm = (LinearLayout) findViewById(2131758701);
        this.ihm.setBackgroundResource(2130838136);
        String string = getString(2131231879);
        ak.yW();
        u LX = c.wH().LX(this.userName);
        if (!(LX == null || be.kS(LX.field_nickname))) {
            string = LX.field_nickname;
        }
        ((TextView) findViewById(2131758724)).setText(getString(2131234639, new Object[]{string}));
        this.nDR.nDX.setBackgroundResource(2131689938);
        float a = (float) b.a(this, 15.0f);
        this.ihk.setPadding((int) a, ((int) a) * 2, (int) a, 0);
        this.icX.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ RoomInfoShareQrUI ihn;

            {
                this.ihn = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (this.ihn.icO != null) {
                    this.ihn.icO.clearFocus();
                }
                return false;
            }
        });
        findViewById(2131758723).setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ RoomInfoShareQrUI ihn;

            {
                this.ihn = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (this.ihn.icO != null) {
                    this.ihn.icO.clearFocus();
                }
                return false;
            }
        });
        findViewById(2131758723).setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ RoomInfoShareQrUI ihn;

            {
                this.ihn = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                this.ihn.axg();
                return false;
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ RoomInfoShareQrUI ihn;

            {
                this.ihn = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.ihn.aIC();
                return true;
            }
        });
        a(0, getString(2131231149), new OnMenuItemClickListener(this) {
            final /* synthetic */ RoomInfoShareQrUI ihn;

            {
                this.ihn = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                v.d("MicroMsg.RoomInfoShareQrUI", "addr: %s", new Object[]{this.ihn.icO.aIl()});
                this.ihn.axg();
                String obj = this.ihn.icX.getText().toString();
                String charSequence = ((TextView) this.ihn.findViewById(2131758724)).getText().toString();
                if (this.ihn.aHV()) {
                    String aIl = this.ihn.icO.aIl();
                    v.d("MicroMsg.RoomInfoShareQrUI", "toMail" + aIl + " " + charSequence);
                    final n nVar = new n(this.ihn.userName, obj, "", be.g(aIl.split(",")));
                    RoomInfoShareQrUI roomInfoShareQrUI = this.ihn;
                    RoomInfoShareQrUI roomInfoShareQrUI2 = this.ihn;
                    this.ihn.getString(2131231164);
                    roomInfoShareQrUI.dwR = g.a(roomInfoShareQrUI2, "", true, new OnCancelListener(this) {
                        final /* synthetic */ AnonymousClass6 ihp;

                        public final void onCancel(DialogInterface dialogInterface) {
                            ak.vy().c(nVar);
                        }
                    });
                    ak.vy().a(nVar, 0);
                }
                return false;
            }
        }, k.b.nET);
        this.ihj = (ImageView) findViewById(2131758725);
        this.ihj.setImageBitmap(this.cxY);
        this.idl = false;
        this.idm = false;
        this.idn = true;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        aIC();
        return true;
    }

    private void aIC() {
        if (be.kS(this.icO.aIl())) {
            finish();
        }
        g.a(this, 2131235128, 2131231164, new OnClickListener(this) {
            final /* synthetic */ RoomInfoShareQrUI ihn;

            {
                this.ihn = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.ihn.finish();
            }
        }, null);
    }

    public void onDestroy() {
        if (!(this.cxY == null || this.cxY.isRecycled())) {
            this.cxY.recycle();
        }
        ak.vy().b(340, this);
        super.onDestroy();
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        v.i("MicroMsg.RoomInfoShareQrUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str + " scenetype " + kVar.getType());
        if (this.dwR != null) {
            this.dwR.dismiss();
        }
        if (kVar.getType() == 340) {
            if (i == 0 && i2 == 0) {
                g.A(this, getString(2131234610), getString(2131231164));
                finish();
                return;
            }
            Toast.makeText(this, "err :" + i + " ," + i2, 0).show();
        }
    }
}
