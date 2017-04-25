package com.tencent.mm.plugin.emoji.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.e;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.plugin.emoji.a.i;
import com.tencent.mm.protocal.c.oa;
import com.tencent.mm.protocal.c.oc;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.MMDotView;
import java.util.Iterator;
import java.util.LinkedList;

public class EmojiStoreVpHeader extends LinearLayout implements e {
    private View eEX;
    private View eYV;
    private final int fjA = 5;
    private final int fjB = 0;
    private MMDotView fjs;
    private ViewPager fjt;
    private LinkedList<com.tencent.mm.plugin.emoji.model.a> fju;
    private i fjv;
    private float fjw;
    private float fjx;
    private a fjy;
    private volatile boolean fjz;

    private class a extends ac {
        final /* synthetic */ EmojiStoreVpHeader fjC;

        private a(EmojiStoreVpHeader emojiStoreVpHeader) {
            this.fjC = emojiStoreVpHeader;
        }

        public final void handleMessage(Message message) {
            if (!this.fjC.fjz && message.what != 0) {
                return;
            }
            if (this.fjC.fju == null || this.fjC.fju.size() <= 1) {
                v.w("MicroMsg.emoji.EmojiStoreVpHeader", "list is null");
            } else if (this.fjC.fjv == null) {
                v.w("MicroMsg.emoji.EmojiStoreVpHeader", "adapter is null");
            } else {
                int i = this.fjC.fjt.xB + 1;
                if (i >= this.fjC.fjv.getCount()) {
                    i = (this.fjC.fju.size() * i.eZM) / 2;
                }
                this.fjC.fjt.Z(i);
                if (this.fjC.fjz && this.fjC.fjy != null) {
                    sendMessageDelayed(this.fjC.fjy.obtainMessage(0), 5000);
                }
            }
        }
    }

    public EmojiStoreVpHeader(Context context) {
        super(context);
        setOrientation(1);
    }

    public EmojiStoreVpHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(1);
    }

    public static int[] aG(Context context) {
        int[] iArr = new int[2];
        if (context instanceof Activity) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            iArr[0] = displayMetrics.widthPixels;
            iArr[1] = displayMetrics.heightPixels;
        } else {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            iArr[0] = defaultDisplay.getWidth();
            iArr[1] = defaultDisplay.getHeight();
        }
        return iArr;
    }

    private synchronized void ahd() {
        if (this.fju == null) {
            throw new IllegalAccessError("must has emoji baner list first");
        }
        if (this.eEX == null) {
            this.eEX = inflate(getContext(), 2130903515, null);
            this.eYV = this.eEX.findViewById(2131756746);
            this.fjs = (MMDotView) this.eEX.findViewById(2131756748);
            this.fjt = (ViewPager) this.eEX.findViewById(2131756747);
            this.fjy = new a();
            int i = ((aG(getContext())[0] * 3) / 8) + 1;
            if (this.eYV != null) {
                this.eYV.setLayoutParams(new LayoutParams(-1, i));
            }
            addView(this.eEX, new LayoutParams(-1, -2));
        }
        if (this.fjs != null) {
            this.fjs.wt(this.fju == null ? 0 : this.fju.size());
            this.fjs.wu(0);
            this.fjs.setVisibility(8);
        }
        if (!(this.fjt == null || this.fju == null)) {
            if (this.fju.size() > 0) {
                if (this.eYV != null) {
                    this.eYV.setVisibility(0);
                }
                this.fjt.yk = this;
                if (this.fjv == null) {
                    this.fjv = new i(getContext(), this.fju);
                    this.fjt.a(this.fjv);
                    ViewPager viewPager = this.fjt;
                    if (1 != viewPager.xS) {
                        viewPager.xS = 1;
                        viewPager.populate();
                    }
                    ahe();
                } else {
                    post(new Runnable(this) {
                        final /* synthetic */ EmojiStoreVpHeader fjC;

                        {
                            this.fjC = r1;
                        }

                        public final void run() {
                            if (this.fjC.fjv != null && this.fjC.fju != null) {
                                this.fjC.fjv.B(this.fjC.fju);
                            }
                        }
                    });
                }
            } else if (this.eYV != null) {
                this.eYV.setVisibility(8);
            }
        }
    }

    private void ahe() {
        if (this.fjt != null) {
            this.fjt.k((i.eZM / 2) * this.fju.size(), false);
        }
    }

    public final void ahf() {
        if (this.fjy == null) {
            this.fjy = new a();
        }
        this.fjz = true;
        this.fjy.removeMessages(0);
        this.fjy.sendEmptyMessageDelayed(0, 5000);
    }

    public final void ahg() {
        if (this.fjy != null) {
            this.fjz = false;
            this.fjy.removeMessages(0);
        }
    }

    public final void clear() {
        if (this.fjv != null) {
            i iVar = this.fjv;
            if (iVar.eZL != null) {
                iVar.eZL.clear();
            }
            if (iVar.eZP != null) {
                iVar.eZP.clear();
            }
            iVar.eZO = true;
            this.fjv = null;
        }
        this.fjy = null;
    }

    public final void b(LinkedList<oa> linkedList, LinkedList<oc> linkedList2) {
        if (linkedList != null) {
            if (this.fju == null) {
                this.fju = new LinkedList();
            } else {
                this.fju.clear();
            }
            Iterator it = linkedList2.iterator();
            while (it.hasNext()) {
                oc ocVar = (oc) it.next();
                if (!(ocVar == null || ocVar.mpS == null || be.kS(ocVar.mpS.mpT))) {
                    this.fju.add(new com.tencent.mm.plugin.emoji.model.a(null, ocVar, true));
                }
            }
            it = linkedList.iterator();
            while (it.hasNext()) {
                oa oaVar = (oa) it.next();
                if (!(oaVar == null || oaVar.mpS == null || be.kS(oaVar.mpS.mpT))) {
                    this.fju.add(new com.tencent.mm.plugin.emoji.model.a(oaVar, null, false));
                }
            }
            ahd();
        }
    }

    public final void X(int i) {
    }

    public final void a(int i, float f, int i2) {
    }

    public final void W(int i) {
        if (this.fju != null && this.fju.size() > 1) {
            if (i == 0 || i == this.fjv.getCount() - 1) {
                this.eEX.postDelayed(new Runnable(this) {
                    final /* synthetic */ EmojiStoreVpHeader fjC;

                    {
                        this.fjC = r1;
                    }

                    public final void run() {
                        this.fjC.ahe();
                    }
                }, 350);
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int action2 = motionEvent.getAction();
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        switch (action2) {
            case 0:
                this.fjw = rawX;
                this.fjx = rawY;
                break;
            case 1:
            case 3:
                this.fjw = 0.0f;
                this.fjx = 0.0f;
                cy(false);
                break;
            case 2:
                if (Math.abs((int) (rawX - this.fjw)) > Math.abs((int) (rawY - this.fjx))) {
                    cy(true);
                    break;
                }
                break;
        }
        switch (action) {
            case 0:
                ahg();
                break;
            case 1:
            case 3:
                ahf();
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    private void cy(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }
}
