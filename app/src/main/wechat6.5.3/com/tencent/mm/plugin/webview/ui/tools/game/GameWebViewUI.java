package com.tencent.mm.plugin.webview.ui.tools.game;

import android.annotation.TargetApi;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.a;
import android.support.v7.app.ActionBar;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.f;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.smtt.sdk.x;
import java.net.URI;
import java.util.HashMap;

public class GameWebViewUI extends WebViewUI {
    private static String lnZ = "wx_fullscreen";
    private int lnW;
    private boolean lnX = false;
    private boolean lnY = false;
    private HashMap<String, String> loa = new HashMap();
    private Drawable lob;
    private Drawable loc;

    static /* synthetic */ void n(GameWebViewUI gameWebViewUI) {
        gameWebViewUI.lnY = false;
        gameWebViewUI.tg(255);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dOV = new x(this) {
            final /* synthetic */ GameWebViewUI lod;

            {
                this.lod = r1;
            }

            public final boolean p(MotionEvent motionEvent) {
                if (this.lod.igd == null) {
                    return false;
                }
                return this.lod.igd.z(motionEvent);
            }

            public final boolean a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
                if (this.lod.igd == null) {
                    return false;
                }
                return this.lod.igd.b(i, i2, i3, i4, i5, i6, i7, i8, z);
            }

            public final void RC() {
                if (this.lod.igd != null) {
                    this.lod.igd.bKp();
                }
            }

            @TargetApi(9)
            public final void b(int i, int i2, boolean z, boolean z2) {
                if (this.lod.igd != null) {
                    this.lod.igd.c(i, i2, z, z2);
                }
            }

            public final void onScrollChanged(int i, int i2, int i3, int i4, View view) {
                if (this.lod.igd != null) {
                    this.lod.igd.r(i, i2, i3, i4);
                    if (!this.lod.lnX) {
                        return;
                    }
                    if (i2 >= this.lod.lnW) {
                        if (this.lod.lnY) {
                            GameWebViewUI.n(this.lod);
                        }
                    } else if (i2 < this.lod.lnW) {
                        this.lod.tg((int) ((((float) i2) / ((float) this.lod.lnW)) * 255.0f));
                    }
                }
            }

            public final boolean q(MotionEvent motionEvent) {
                if (this.lod.igd == null) {
                    return false;
                }
                return this.lod.igd.A(motionEvent);
            }

            public final boolean r(MotionEvent motionEvent) {
                if (this.lod.igd == null) {
                    return false;
                }
                return this.lod.igd.B(motionEvent);
            }
        };
        if (!be.kS(this.bpX)) {
            try {
                a(new URI(this.bpX));
            } catch (Exception e) {
                v.e("MicroMsg.GameWebViewUI", "parseUrl error, %s,  rawUrl = %s", new Object[]{e.getMessage(), this.bpX});
            }
        }
        this.lnW = bjY();
        if (this.loa.containsKey(lnZ) && ((String) this.loa.get(lnZ)).equals("1")) {
            this.lnX = true;
        }
        if (this.lnX && this.igd.pdG) {
            bkb();
        }
    }

    public void onResume() {
        super.onResume();
    }

    protected final void NI() {
        super.NI();
        this.lob = new ColorDrawable(a.b(this, 2131689500));
        this.loc = new ColorDrawable(a.b(this, 2131689500));
    }

    private void a(URI uri) {
        String[] split = be.ma(uri.getQuery()).split("&");
        if (split != null && split.length != 0) {
            for (String split2 : split) {
                String[] split3 = split2.split("=");
                if (split3 != null && split3.length == 2) {
                    this.loa.put(split3[0], split3[1]);
                }
            }
        }
    }

    protected final boolean bjX() {
        return false;
    }

    protected final boolean bka() {
        return false;
    }

    protected final void bkb() {
        this.lnY = true;
        this.llu = true;
        ActionBar cV = cU().cV();
        if (cV != null) {
            cV.setBackgroundDrawable(this.lob);
            this.lob.setAlpha(0);
            if (cV.getCustomView() != null) {
                cV.getCustomView().setBackground(this.loc);
                this.loc.setAlpha(0);
                cV.getCustomView().invalidate();
            }
        }
        setStatusBarColor(0);
        if (this.dQy != null) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.dQy.getLayoutParams();
            marginLayoutParams.topMargin = 0;
            this.dQy.setLayoutParams(marginLayoutParams);
        }
        f fVar = this.llx;
        int bjY = bjY();
        if (fVar.ljI != null) {
            fVar.ljI.setPadding(fVar.ljI.getPaddingLeft(), bjY + fVar.ljI.getPaddingTop(), fVar.ljI.getPaddingRight(), fVar.ljI.getPaddingBottom());
        }
        vF(8);
    }

    private void tg(int i) {
        if (i < 10) {
            vF(8);
        } else {
            vF(0);
        }
        if (i < 255) {
            this.lnY = true;
        } else {
            this.lnY = false;
        }
        if (this.lob != null) {
            this.lob.setAlpha(i);
        }
    }
}
