package com.tencent.mm.wallet_core.ui;

import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMVerticalTextView;
import com.tencent.mm.ui.base.o;
import java.util.ArrayList;

public final class c {
    private MMActivity eBk;
    private OnClickListener eFl = new OnClickListener(this) {
        final /* synthetic */ c pjF;

        {
            this.pjF = r1;
        }

        public final void onClick(View view) {
            if ((view.getId() == 2131755947 || view.getId() == 2131755953) && this.pjF.eLp != null && this.pjF.eLp.isShowing()) {
                this.pjF.eLp.dismiss();
            }
        }
    };
    private boolean eIt = true;
    private Bitmap eLo = null;
    o eLp = null;
    private View eLq;
    private ImageView eLr;
    private View eLu;
    private ImageView eLv;
    private MMVerticalTextView eLw;
    private ArrayList<Bitmap> eLy = new ArrayList();
    private String hJU = "";
    public Bitmap hLA = null;
    public Bitmap hLB = null;
    private String hLO = "";

    public c(MMActivity mMActivity) {
        this.eBk = mMActivity;
    }

    public final void eb(String str, String str2) {
        this.hLO = str;
        this.hJU = str2;
    }

    public final void init() {
        if (this.eLp == null) {
            View inflate = View.inflate(this.eBk, 2130904659, null);
            this.eLq = inflate.findViewById(2131755946);
            this.eLr = (ImageView) inflate.findViewById(2131755947);
            this.eLu = inflate.findViewById(2131755950);
            this.eLv = (ImageView) inflate.findViewById(2131755953);
            this.eLw = (MMVerticalTextView) inflate.findViewById(2131755952);
            inflate.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ c pjF;

                {
                    this.pjF = r1;
                }

                public final void onClick(View view) {
                    if (this.pjF.eLp != null && this.pjF.eLp.isShowing()) {
                        this.pjF.eLp.dismiss();
                    }
                }
            });
            this.eLp = new o(inflate, -1, -1, true);
            this.eLp.update();
            this.eLp.setBackgroundDrawable(new ColorDrawable(16777215));
            this.eLp.setOnDismissListener(new OnDismissListener(this) {
                final /* synthetic */ c pjF;

                {
                    this.pjF = r1;
                }

                public final void onDismiss() {
                }
            });
        }
    }

    public final void release() {
        if (this.eLp != null && this.eLp.isShowing()) {
            this.eLp.dismiss();
        }
        e.l(this.eLo);
        e.ae(this.eLy);
        this.eLy.clear();
        this.eBk = null;
    }

    public final void r(View view, boolean z) {
        this.eIt = z;
        if (this.eLp != null && !this.eLp.isShowing()) {
            this.eLp.showAtLocation(view.getRootView(), 17, 0, 0);
            this.eLp.setFocusable(true);
            this.eLp.setTouchable(true);
            this.eLp.setBackgroundDrawable(new ColorDrawable(16777215));
            this.eLp.setOutsideTouchable(true);
            bLw();
        }
    }

    public final void bLv() {
        if (this.eLp != null && this.eLp.isShowing()) {
            bLw();
        }
    }

    private void bLw() {
        if (this.eIt) {
            this.eLv.setOnClickListener(this.eFl);
            Bitmap bitmap = this.eLo;
            if (this.hLB != null) {
                this.eLo = e.k(this.hLB);
                v.i("MicroMsg.OfflinePopupWindow", "updatePopWindowContent mRoateBmp != null");
            } else {
                this.eLo = null;
                v.e("MicroMsg.OfflinePopupWindow", "updatePopWindowContent mRoateBmp == null");
            }
            this.eLv.setImageBitmap(this.eLo);
            this.eLy.add(0, bitmap);
            if (this.eLy.size() >= 2) {
                for (int size = this.eLy.size() - 1; size > 1; size--) {
                    e.l((Bitmap) this.eLy.remove(size));
                }
            }
            this.eLq.setVisibility(8);
            this.eLu.setVisibility(0);
            this.eLw.setText(e.PV(this.hJU));
        } else {
            this.eLr.setOnClickListener(this.eFl);
            this.eLr.setImageBitmap(this.hLA);
            if (this.hLA != null) {
                v.e("MicroMsg.OfflinePopupWindow", "updatePopWindowContent mQRCodeBmp != null");
            } else {
                v.i("MicroMsg.OfflinePopupWindow", "updatePopWindowContent mQRCodeBmp == null");
            }
            this.eLq.setVisibility(0);
            this.eLu.setVisibility(8);
        }
        this.eLp.update();
    }
}
