package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n;
import com.tencent.mm.sdk.platformtools.v;
import org.json.JSONArray;
import org.json.JSONObject;

public class j {
    protected int backgroundColor;
    protected Context context;
    protected View dtW = null;
    protected n jxU;
    private int jxV = 0;
    private long jxW = 0;
    private long jxX = 0;
    public boolean jxY = false;
    protected ViewGroup jxZ;

    public j(Context context, n nVar, ViewGroup viewGroup) {
        this.context = context;
        this.jxU = nVar;
        this.jxZ = viewGroup;
    }

    public final void a(n nVar) {
        n nVar2 = this.jxU;
        if (nVar2 != nVar) {
            if (nVar2 == null || !nVar2.equals(nVar)) {
                this.jxU = nVar;
                aTS();
                aTK();
            }
        }
    }

    public final void setBackgroundColor(int i) {
        this.backgroundColor = i;
    }

    public final View getView() {
        if (this.dtW != null) {
            return this.dtW;
        }
        if (this.dtW == null) {
            int aGY = aGY();
            if (aGY != Integer.MAX_VALUE) {
                this.dtW = ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(aGY, this.jxZ, false);
            } else {
                this.dtW = aTT();
                if (this.dtW.getLayoutParams() == null) {
                    this.jxZ.addView(this.dtW);
                    LayoutParams layoutParams = this.dtW.getLayoutParams();
                    this.jxZ.removeView(this.dtW);
                    this.dtW.setLayoutParams(layoutParams);
                }
            }
            if (this.dtW == null) {
                throw new IllegalStateException("implement getLayout() or customLayout() to get a valid root view");
            }
        }
        aTM();
        aTS();
        aTK();
        return this.dtW;
    }

    public final n aTW() {
        return this.jxU;
    }

    public View aTM() {
        return this.dtW;
    }

    protected void aTS() {
        v.w("MicroMsg.Sns.AdLandingPageBaseComponent", "for component reuse, subclass must implement this method");
    }

    protected int aGY() {
        return Integer.MAX_VALUE;
    }

    protected View aTT() {
        return null;
    }

    public void aTO() {
        if (!this.jxY) {
            this.jxY = true;
            this.jxW = System.currentTimeMillis();
            this.jxV++;
        }
    }

    public void aTP() {
        if (this.jxY) {
            this.jxY = false;
            if (this.jxW > 0) {
                this.jxX += System.currentTimeMillis() - this.jxW;
            }
            this.jxW = 0;
        }
    }

    public void K(int i, int i2, int i3) {
    }

    public void aTU() {
        aTP();
    }

    public boolean o(JSONArray jSONArray) {
        return false;
    }

    public boolean x(JSONObject jSONObject) {
        if (this.jxX == 0 || this.jxU.jvS) {
            return false;
        }
        try {
            jSONObject.put("cid", this.jxU.jvG);
            jSONObject.put("exposureCount", this.jxV);
            jSONObject.put("stayTime", this.jxX);
            return true;
        } catch (Throwable e) {
            v.a("MicroMsg.Sns.AdLandingPageBaseComponent", e, "", new Object[0]);
            return false;
        }
    }

    protected void aTK() {
        gl(false);
    }

    protected final void gl(boolean z) {
        if (this.dtW == null) {
            throw new IllegalStateException("set field contentView first");
        } else if (this.jxU != null) {
            LayoutParams layoutParams = this.dtW.getLayoutParams();
            if (layoutParams != null) {
                if (this.jxU.jvM != 2.14748365E9f) {
                    layoutParams.width = (int) this.jxU.jvM;
                }
                if (this.jxU.jvN != 2.14748365E9f) {
                    layoutParams.height = (int) this.jxU.jvN;
                }
                if (z && (layoutParams instanceof MarginLayoutParams)) {
                    ((MarginLayoutParams) layoutParams).setMargins((int) this.jxU.jvK, (int) this.jxU.jvI, (int) this.jxU.jvL, (int) this.jxU.jvJ);
                }
                int gravity;
                if (layoutParams instanceof LinearLayout.LayoutParams) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                    gravity = getGravity();
                    if (gravity != 0) {
                        layoutParams2.gravity = gravity;
                    } else {
                        layoutParams2.gravity = -1;
                    }
                } else if (layoutParams instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) layoutParams;
                    gravity = getGravity();
                    if (gravity != 0) {
                        layoutParams3.gravity = gravity;
                    } else {
                        layoutParams3.gravity = -1;
                    }
                }
                this.dtW.setLayoutParams(layoutParams);
                return;
            }
            v.i("MicroMsg.Sns.AdLandingPageBaseComponent", this + " has no layoutParams in container " + this.jxZ);
        }
    }

    private int getGravity() {
        int i = 0;
        switch (this.jxU.jvP) {
            case 0:
                i = 48;
                break;
            case 1:
                i = 16;
                break;
            case 2:
                i = 80;
                break;
        }
        switch (this.jxU.jvQ) {
            case 0:
                return i | 3;
            case 1:
                return i | 1;
            case 2:
                return i | 5;
            default:
                return i;
        }
    }
}
