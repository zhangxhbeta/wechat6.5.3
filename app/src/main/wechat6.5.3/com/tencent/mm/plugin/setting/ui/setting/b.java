package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Bitmap;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ay.c;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.k;
import com.tencent.mm.model.l;
import com.tencent.mm.pluginsdk.j.p;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.v.e;
import java.lang.ref.WeakReference;

public final class b implements p, e {
    private Context context = null;
    Bitmap cxY = null;
    private ProgressDialog dwR = null;
    private ImageView eZn = null;
    private TextView iJZ = null;
    ImageView iJz = null;
    private TextView iKa = null;
    ViewGroup iNu = null;
    h iji = null;
    private String username = "";

    static class a implements OnDismissListener {
        WeakReference<b> iNw;

        public a(b bVar) {
            this.iNw = new WeakReference(bVar);
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            v.d("MicroMsg.SelfQRCodeNewUI", "on qrcode dialog dismiss");
            if (this.iNw == null || this.iNw.get() == null) {
                v.w("MicroMsg.SelfQRCodeNewUI", "on qrcode dialog dismiss error, ref null");
                return;
            }
            ak.vy().b(168, (e) this.iNw.get());
            ak.vy().b(158, (e) this.iNw.get());
            ((b) this.iNw.get()).cxY = null;
        }
    }

    public b(Context context, String str) {
        this.username = str;
        this.context = context;
    }

    public final void onDestroy() {
        ak.vy().b(168, this);
        ak.vy().b(158, this);
        if (!(this.cxY == null || this.cxY.isRecycled())) {
            this.cxY.recycle();
        }
        if (this.iji != null && this.iji.isShowing()) {
            this.iji.dismiss();
        }
        this.iji = null;
        this.context = null;
    }

    public final void show() {
        String str;
        ak.vy().a(158, this);
        ak.vy().a(168, this);
        this.iNu = (ViewGroup) View.inflate(this.context, 2130903085, null);
        this.iNu.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ b iNv;

            {
                this.iNv = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0 && this.iNv.iji != null && this.iNv.iji.isShowing()) {
                    this.iNv.iji.dismiss();
                }
                return false;
            }
        });
        this.iJz = (ImageView) this.iNu.findViewById(2131755310);
        this.eZn = (ImageView) this.iNu.findViewById(2131755306);
        this.iJZ = (TextView) this.iNu.findViewById(2131755308);
        this.iKa = (TextView) this.iNu.findViewById(2131755309);
        View findViewById = this.iNu.findViewById(2131755311);
        if ((k.xK() & 2) != 0) {
            findViewById.setVisibility(0);
            this.iJz.setAlpha(0.1f);
            this.iNu.findViewById(2131755312).setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ b iNv;

                {
                    this.iNv = r1;
                }

                public final void onClick(View view) {
                    c.w(this.iNv.iNu.getContext(), "setting", ".ui.setting.SettingsAddMeUI");
                    this.iNv.iji.dismiss();
                }
            });
        }
        this.cxY = com.tencent.mm.am.b.HU();
        if (this.cxY == null) {
            v.d("MicroMsg.SelfQRCodeNewUI", "%s", new Object[]{"bitmap == null"});
            str = this.username;
            ak.yW();
            final com.tencent.mm.am.a aVar = new com.tencent.mm.am.a(str, be.f((Integer) com.tencent.mm.model.c.vf().get(66561, null)));
            ak.vy().a(aVar, 0);
            Context context = this.context;
            this.context.getString(2131231164);
            this.dwR = g.a(context, this.context.getString(2131234882), true, new OnCancelListener(this) {
                final /* synthetic */ b iNv;

                public final void onCancel(DialogInterface dialogInterface) {
                    ak.vy().c(aVar);
                }
            });
        } else {
            this.iJz.setImageBitmap(this.cxY);
        }
        com.tencent.mm.pluginsdk.ui.a.b.m(this.eZn, k.xF());
        ak.yW();
        v.d("MicroMsg.SelfQRCodeNewUI", "nick name = %s", new Object[]{(String) com.tencent.mm.model.c.vf().get(4, null)});
        this.iJZ.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this.context, r0, this.iJZ.getTextSize()));
        bf zO = bf.zO();
        str = be.ma(zO.getProvince());
        v.d("MicroMsg.SelfQRCodeNewUI", "display location = %s", new Object[]{l.eu(str) + " " + be.ma(zO.getCity())});
        this.iKa.setText(r0);
        ak.yW();
        switch (be.a((Integer) com.tencent.mm.model.c.vf().get(12290, null), 0)) {
            case 1:
                this.iJZ.setCompoundDrawablesWithIntrinsicBounds(null, null, com.tencent.mm.bd.a.a(this.context, 2131165606), null);
                break;
            case 2:
                this.iJZ.setCompoundDrawablesWithIntrinsicBounds(null, null, com.tencent.mm.bd.a.a(this.context, 2131165605), null);
                break;
        }
        this.iJz.post(new Runnable(this) {
            final /* synthetic */ b iNv;

            {
                this.iNv = r1;
            }

            public final void run() {
                int width = this.iNv.iJz.getWidth();
                LayoutParams layoutParams = (LayoutParams) this.iNv.iJz.getLayoutParams();
                layoutParams.width = width;
                layoutParams.height = width;
                this.iNv.iJz.setLayoutParams(layoutParams);
            }
        });
        if (this.iji == null || !this.iji.isShowing()) {
            this.iji = g.a(this.context, this.iNu, null);
            if (this.iji != null) {
                this.iji.setCanceledOnTouchOutside(true);
                this.iji.setOnDismissListener(new a(this));
            }
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        v.i("MicroMsg.SelfQRCodeNewUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.dwR != null) {
            this.dwR.dismiss();
            this.dwR = null;
        }
        if (kVar.getType() == 168 && !com.tencent.mm.plugin.setting.a.drq.b(this.context, i, i2, str)) {
            if (i != 0 || i2 != 0) {
                Toast.makeText(this.context, this.context.getString(2131232922, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            } else if (this.iJz != null) {
                this.cxY = com.tencent.mm.am.b.HU();
                this.iJz.setImageBitmap(this.cxY);
            }
        }
    }
}
