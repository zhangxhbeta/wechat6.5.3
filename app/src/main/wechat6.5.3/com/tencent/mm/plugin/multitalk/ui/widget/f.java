package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.AnimationDrawable;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.multitalk.a.d;
import com.tencent.mm.plugin.multitalk.a.e;
import com.tencent.mm.plugin.multitalk.a.i;
import com.tencent.mm.plugin.multitalk.a.j;
import com.tencent.mm.plugin.multitalk.a.o;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkAddMembersUI;
import com.tencent.mm.plugin.multitalk.ui.MultiTalkMainUI;
import com.tencent.mm.plugin.video.ObservableTextureView;
import com.tencent.mm.plugin.voip.ui.MMCheckBox;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.base.h;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import com.tencent.pb.talkroom.sdk.g;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class f implements OnClickListener, com.tencent.mm.plugin.voip.video.f, com.tencent.mm.u.d.a {
    h dyF = null;
    public TextView eTg;
    private FrameLayout hBE;
    public View hBF;
    private View hBG;
    private View hBH;
    public MMCheckBox hBI;
    public MMCheckBox hBJ;
    public MMCheckBox hBK;
    private int hBL;
    private int hBM;
    public ArrayList<RelativeLayout> hBN = new ArrayList(9);
    private com.tencent.mm.plugin.voip.video.a hBO;
    private j hBP;
    private ObservableTextureView hBQ;
    private int hBR;
    public long hBS;
    c hBT = new c();
    private MultiTalkMainUI hBh;
    private ImageButton hBn;

    public static class a {
        View fIV;
        public MultiTalkVideoView hBV;
        public ImageView hBW;
        public ImageView hBX;
        public TextView hBY;
        ImageView hBZ;
    }

    private class b implements Runnable {
        final /* synthetic */ f hBU;
        a hCa;

        public b(f fVar, a aVar) {
            this.hBU = fVar;
            this.hCa = aVar;
        }

        public final void run() {
            this.hCa.hBY.setVisibility(8);
        }
    }

    private class c {
        int h;
        final /* synthetic */ f hBU;
        int[] hzY;
        int w;

        private c(f fVar) {
            this.hBU = fVar;
        }
    }

    public f(MultiTalkMainUI multiTalkMainUI) {
        this.hBh = multiTalkMainUI;
        this.eTg = (TextView) multiTalkMainUI.findViewById(2131755923);
        this.hBF = multiTalkMainUI.findViewById(2131758345);
        this.hBn = (ImageButton) multiTalkMainUI.findViewById(2131758353);
        this.hBE = (FrameLayout) multiTalkMainUI.findViewById(2131758346);
        this.hBG = multiTalkMainUI.findViewById(2131758347);
        this.hBH = multiTalkMainUI.findViewById(2131758348);
        this.hBI = (MMCheckBox) multiTalkMainUI.findViewById(2131758351);
        this.hBJ = (MMCheckBox) multiTalkMainUI.findViewById(2131758350);
        this.hBK = (MMCheckBox) multiTalkMainUI.findViewById(2131758352);
        this.hBJ.setChecked(o.aCG().eJx);
        this.hBK.setChecked(o.aCG().hzl);
        this.hBI.setChecked(o.aCG().aCa());
        this.hBL = com.tencent.mm.bd.a.dv(multiTalkMainUI.nDR.nEl);
        this.hBM = b.cj(multiTalkMainUI.nDR.nEl);
        v.i("MicroMsg.MT.MultiTalkTalkingUILogic", "talkingAvatarContainerHeight %d", new Object[]{Integer.valueOf(this.hBM)});
        this.hBn.setOnClickListener(this);
        this.hBG.setOnClickListener(this);
        this.hBI.setOnClickListener(this);
        this.hBJ.setOnClickListener(this);
        this.hBK.setOnClickListener(this);
        this.hBH.setOnClickListener(this);
        n.AX().a(this);
        for (int i = 8; i >= 0; i--) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(multiTalkMainUI).inflate(2130903922, null);
            a aVar = new a();
            aVar.hBV = (MultiTalkVideoView) relativeLayout.findViewById(2131758017);
            aVar.hBV.index = i;
            aVar.hBV.setOnClickListener(this);
            aVar.fIV = relativeLayout.findViewById(2131758018);
            aVar.hBW = (ImageView) relativeLayout.findViewById(2131758021);
            aVar.hBX = (ImageView) relativeLayout.findViewById(2131758022);
            aVar.hBY = (TextView) relativeLayout.findViewById(2131758020);
            aVar.hBZ = (ImageView) relativeLayout.findViewById(2131758019);
            relativeLayout.setTag(aVar);
            relativeLayout.setVisibility(8);
            this.hBN.add(relativeLayout);
            this.hBE.addView(relativeLayout);
        }
        o.aCG().eC(o.aCG().hzl);
    }

    public final void o(MultiTalkGroup multiTalkGroup) {
        this.hBF.setVisibility(0);
        LinkedList linkedList = new LinkedList();
        for (MultiTalkGroupMember multiTalkGroupMember : multiTalkGroup.pte) {
            if (multiTalkGroupMember.status == 10 || multiTalkGroupMember.status == 1) {
                linkedList.add(multiTalkGroupMember);
            }
        }
        P(linkedList);
    }

    private void P(LinkedList<MultiTalkGroupMember> linkedList) {
        int i;
        int i2;
        int i3;
        int i4;
        float[] fArr;
        this.hBR = linkedList.size();
        LayoutParams layoutParams = this.hBE.getLayoutParams();
        if (this.hBR <= 4) {
            i = this.hBL / 2;
            i2 = this.hBM / 2 > i ? i : this.hBM / 2;
            layoutParams.height = i2 * 2;
            i3 = i2;
            i4 = i;
        } else if (this.hBR <= 9) {
            i = this.hBL / 3;
            i2 = this.hBM / 3 > i ? i : this.hBM / 3;
            layoutParams.height = i2 * 3;
            i3 = i2;
            i4 = i;
        } else {
            v.e("MicroMsg.MT.MultiTalkTalkingUILogic", "onlineUserSize larger than 9, %s", new Object[]{Integer.valueOf(this.hBR)});
            return;
        }
        this.hBE.setLayoutParams(layoutParams);
        v.i("MicroMsg.MT.MultiTalkTalkingUILogic", "talkingAvatarWidth: %d | talkingAvatarHeight: %d | size %d", new Object[]{Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(this.hBR)});
        Object obj = (ak.is2G(this.hBh) || ak.is3G(this.hBh)) ? 1 : null;
        HashSet hashSet = new HashSet();
        hashSet.addAll(o.aCG().hzo);
        if (o.aCG().aCa()) {
            hashSet.add(k.xF());
        }
        if (this.hBR <= 4) {
            fArr = i.hzN[this.hBR];
        } else {
            fArr = i.hzN[5];
        }
        if (fArr != null) {
            for (int i5 = 0; i5 < fArr.length; i5 += 2) {
                MultiTalkGroupMember multiTalkGroupMember = this.hBR > i5 / 2 ? (MultiTalkGroupMember) linkedList.get(i5 / 2) : null;
                i2 = (int) (fArr[i5] * ((float) i4));
                int i6 = (int) (fArr[i5 + 1] * ((float) i3));
                if (this.hBR == 2 && i2 == 0) {
                    i2 = 1;
                }
                if (this.hBR == 4 && i2 == 0) {
                    i = 1;
                } else {
                    i = i2;
                }
                RelativeLayout relativeLayout = (RelativeLayout) this.hBN.get(i5 / 2);
                LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
                layoutParams2.width = i4;
                layoutParams2.height = i3;
                layoutParams2.leftMargin = i;
                layoutParams2.topMargin = i6;
                relativeLayout.setLayoutParams(layoutParams2);
                a aVar = (a) relativeLayout.getTag();
                if (multiTalkGroupMember != null) {
                    v.i("MicroMsg.MT.MultiTalkVideoView", "changeUser from %s to %s", new Object[]{aVar.hBV.username, multiTalkGroupMember.ptf});
                    r3.username = r11;
                    aVar.hBV.position = aVar.hBV.index;
                    if (multiTalkGroupMember.status != 10) {
                        aVar.fIV.setVisibility(0);
                        if (aVar.hBZ.getBackground() != null) {
                            aVar.hBZ.setVisibility(0);
                            ((AnimationDrawable) aVar.hBZ.getBackground()).stop();
                            ((AnimationDrawable) aVar.hBZ.getBackground()).start();
                        }
                    } else {
                        aVar.fIV.setVisibility(8);
                        a(aVar);
                    }
                    if (hashSet.contains(multiTalkGroupMember.ptf) && obj == null) {
                        aVar.hBV.aCQ();
                    } else {
                        aVar.hBV.aCP();
                    }
                } else {
                    aVar.fIV.setVisibility(8);
                    a(aVar);
                    MultiTalkVideoView multiTalkVideoView = aVar.hBV;
                    v.i("MicroMsg.MT.MultiTalkVideoView", "changeToNone %s from %s", new Object[]{multiTalkVideoView.username, multiTalkVideoView.hCe.name()});
                    multiTalkVideoView.hCe = com.tencent.mm.plugin.multitalk.ui.widget.MultiTalkVideoView.a.None;
                    multiTalkVideoView.username = null;
                    multiTalkVideoView.aCR();
                }
                relativeLayout.setVisibility(0);
            }
        }
        if (this.hBR <= 4) {
            for (i = this.hBR; i < 9; i++) {
                ((RelativeLayout) this.hBN.get(i)).setVisibility(8);
            }
        }
        if (o.aCG().aCd() && this.hBI != null && !this.hBI.isChecked()) {
            o.aCG().nn(1);
        }
    }

    public final RelativeLayout wW(String str) {
        Iterator it = this.hBN.iterator();
        while (it.hasNext()) {
            RelativeLayout relativeLayout = (RelativeLayout) it.next();
            if (str.equals(((a) relativeLayout.getTag()).hBV.username)) {
                return relativeLayout;
            }
        }
        return null;
    }

    public final void onClick(View view) {
        if (view instanceof MultiTalkVideoView) {
            MultiTalkVideoView multiTalkVideoView = (MultiTalkVideoView) view;
            if (k.xF().equals(multiTalkVideoView.username) && multiTalkVideoView.aCT() && this.hBO != null) {
                this.hBO.bdD();
            }
        } else if (view.getId() == 2131758353) {
            o.aCG().c(true, false, false);
        } else if (view.getId() == 2131758347) {
            d.hzf++;
            o.aCG().eB(true);
        } else if (view.getId() == 2131758352) {
            d.hzh++;
            o.aCG().eC(this.hBK.isChecked());
        } else if (view.getId() == 2131758350) {
            d.hzg++;
            e aCG = o.aCG();
            boolean isChecked = this.hBJ.isChecked();
            o.aCF().hyY.kv(isChecked);
            aCG.ew(isChecked);
        } else if (view.getId() == 2131758351) {
            d.hzi++;
            if (!com.tencent.mm.compatible.e.b.sf()) {
                com.tencent.mm.ah.a.a(this.hBh, 2131235929, null);
                this.hBI.setChecked(false);
            } else if (!o.aCG().aCd()) {
                this.hBI.setChecked(false);
            } else if (ak.is2G(this.hBh) || ak.is3G(this.hBh)) {
                com.tencent.mm.plugin.multitalk.a.h aCE = o.aCE();
                com.tencent.mm.ah.a.a(this.hBh, 2131233945, null);
                aCE.hzL = true;
                this.hBI.setChecked(false);
            } else if (ak.isNetworkConnected(this.hBh)) {
                if (this.hBI.isChecked()) {
                    a(null, false);
                } else {
                    b(null, false);
                    o.aCG().nn(1);
                }
                this.hBI.setChecked(o.aCG().aCa());
            } else {
                com.tencent.mm.ah.a.a(this.hBh, 2131235928, null);
                this.hBI.setChecked(false);
            }
        } else if (view.getId() == 2131758348) {
            d.hzj++;
            MultiTalkMainUI multiTalkMainUI = this.hBh;
            multiTalkMainUI.hAL = true;
            Intent intent = new Intent(multiTalkMainUI, MultiTalkAddMembersUI.class);
            List arrayList = new ArrayList();
            for (MultiTalkGroupMember multiTalkGroupMember : o.aCG().hzq.pte) {
                if (multiTalkGroupMember.status == 10 || multiTalkGroupMember.status == 1) {
                    arrayList.add(multiTalkGroupMember.ptf);
                }
            }
            intent.putExtra("titile", multiTalkMainUI.getString(2131233909));
            intent.putExtra("chatroomName", o.aCG().hzq.ptc);
            intent.putExtra("always_select_contact", be.b(arrayList, ","));
            intent.putExtra("key_need_gallery", false);
            multiTalkMainUI.startActivityForResult(intent, 1);
        }
    }

    public final void b(HashSet<String> hashSet) {
        Iterator it = this.hBN.iterator();
        while (it.hasNext()) {
            a aVar = (a) ((RelativeLayout) it.next()).getTag();
            if (!k.xF().equals(aVar.hBV.username)) {
                if (hashSet.contains(aVar.hBV.username)) {
                    if (!aVar.hBV.aCT()) {
                        aVar.hBV.aCQ();
                    }
                } else if (aVar.hBV.aCT()) {
                    aVar.hBV.aCP();
                }
            }
        }
    }

    public final void aCM() {
        Iterator it = this.hBN.iterator();
        while (it.hasNext()) {
            a aVar = (a) ((RelativeLayout) it.next()).getTag();
            if (!k.xF().equals(aVar.hBV.username) && aVar.hBV.aCT()) {
                aVar.hBV.aCP();
            }
        }
    }

    public final void a(RelativeLayout relativeLayout, boolean z) {
        if (!z) {
            this.hBS = System.currentTimeMillis();
        }
        v.i("MicroMsg.MT.MultiTalkTalkingUILogic", "start capture render");
        RelativeLayout wW = wW(k.xF());
        if (wW != null) {
            if (this.hBQ == null) {
                v.i("MicroMsg.MT.MultiTalkTalkingUILogic", "create capture View");
                this.hBQ = new ObservableTextureView(this.hBh);
                this.hBQ.setLayoutParams(new RelativeLayout.LayoutParams(1, 1));
                wW.addView(this.hBQ);
                this.hBQ.setVisibility(0);
            }
            if (this.hBO == null) {
                v.i("MicroMsg.MT.MultiTalkTalkingUILogic", "create capture Render");
                this.hBO = new com.tencent.mm.plugin.voip.video.a(240, 240);
                this.hBO.a((com.tencent.mm.plugin.voip.video.f) this, true);
                this.hBO.a(this.hBQ);
                this.hBO.bdE();
                if (!o.aCG().hzn) {
                    this.hBO.bdD();
                }
                v.i("MicroMsg.MT.MultiTalkTalkingUILogic", "captureRender.mIsCurrentFaceCamera=%b captureRender.mIsCameraRemote180=%b", new Object[]{Boolean.valueOf(this.hBO.bdH()), Boolean.valueOf(this.hBO.bdI())});
            }
            if (this.hBP == null) {
                this.hBP = new j(this.hBh);
                com.tencent.mm.sdk.i.e.d(new Runnable(this.hBP) {
                    final /* synthetic */ j hzV;

                    {
                        this.hzV = r1;
                    }

                    public final void run() {
                        Looper.prepare();
                        v.i("MicroMsg.MT.MultiTalkVideoNativeReceiver", "start native drawer handler");
                        this.hzV.hzT = new ac();
                        Looper.loop();
                    }
                }, "MultiTalkVideoTaskManager_native_drawer_handler", 1).start();
            }
        }
    }

    public final void b(RelativeLayout relativeLayout, boolean z) {
        if (!z && this.hBS != 0 && System.currentTimeMillis() - this.hBS > 0 && o.aCG().aCe()) {
            d.i(System.currentTimeMillis() - this.hBS, i.aCw());
            this.hBS = 0;
        }
        v.i("MicroMsg.MT.MultiTalkTalkingUILogic", "stop capture render");
        if (relativeLayout == null) {
            relativeLayout = wW(k.xF());
        }
        if (relativeLayout != null) {
            if (this.hBQ != null) {
                relativeLayout.removeView(this.hBQ);
                this.hBQ = null;
            }
            if (this.hBO != null) {
                this.hBO.bdF();
                this.hBO.bdG();
                this.hBO = null;
            }
            if (this.hBP != null) {
                j jVar = this.hBP;
                jVar.hzt = null;
                jVar.hzU.fHM = false;
                jVar.hzU.hzY = null;
                if (jVar.hzT != null) {
                    jVar.hzT.removeCallbacksAndMessages(null);
                    jVar.hzT.getLooper().quit();
                    jVar.hzT = null;
                }
                this.hBP = null;
            }
        }
    }

    public final void eE(boolean z) {
        v.i("MicroMsg.MT.MultiTalkTalkingUILogic", "onFinish");
        this.hBR = 0;
        if (!z) {
            ad.o(new Runnable(this) {
                final /* synthetic */ f hBU;

                {
                    this.hBU = r1;
                }

                public final void run() {
                    this.hBU.eTg.setText(2131233911);
                }
            });
        }
        b(null, false);
        Iterator it = this.hBN.iterator();
        while (it.hasNext()) {
            ((a) ((RelativeLayout) it.next()).getTag()).hBV.setSurfaceTextureListener(null);
        }
        n.AX().b(this);
    }

    public final void a(byte[] bArr, long j, int i, int i2, int i3) {
        if (o.aCG().aCd()) {
            if (this.hBT.hzY == null) {
                this.hBT.w = i;
                this.hBT.h = i2;
                this.hBT.hzY = new int[(this.hBT.w * this.hBT.h)];
            }
            if (!o.aCG().aCa()) {
                o.aCG().nn(3);
            }
            long currentTimeMillis = System.currentTimeMillis();
            o.aCG().hzn = this.hBO.bdH();
            int i4 = this.hBO.bdH() ? OpenGlRender.kBy : 0;
            int i5 = this.hBO.bdI() ? OpenGlRender.kBx : OpenGlRender.kBw;
            g b = o.aCF().hyY.b(bArr, (int) j, this.hBT.w, this.hBT.h, i3 & 31, this.hBT.hzY);
            if (b.ret < 0 || this.hBT.hzY == null || b.ptn == 0 || b.pto == 0) {
                v.e("MicroMsg.MT.MultiTalkTalkingUILogic", "ret: %d", new Object[]{Integer.valueOf(b.ret)});
                return;
            }
            int i6;
            long currentTimeMillis2 = System.currentTimeMillis();
            int i7 = i4 == OpenGlRender.kBy ? 258 : 2;
            if (o.aCG().hzo.size() >= 4) {
                i6 = i4 == OpenGlRender.kBy ? 257 : 1;
            } else {
                i6 = i7;
            }
            i7 = o.aCF().hyY.a(bArr, (short) ((int) j), i, i2, i3, i6);
            if (System.currentTimeMillis() - currentTimeMillis > 30) {
                v.d("MicroMsg.MT.MultiTalkTalkingUILogic", "steve: trans size:%dx%d, total: %d, trans: %d, enc: %d", new Object[]{Integer.valueOf(b.ptn), Integer.valueOf(b.pto), Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Long.valueOf(currentTimeMillis2 - currentTimeMillis), Long.valueOf(System.currentTimeMillis() - currentTimeMillis2)});
            }
            if (i7 <= 0) {
                v.v("MicroMsg.MT.MultiTalkTalkingUILogic", "send ret = %d", new Object[]{Integer.valueOf(i7)});
            }
            if (this.hBP != null && this.hBT.hzY != null) {
                j jVar = this.hBP;
                int[] iArr = this.hBT.hzY;
                i7 = b.ptn;
                int i8 = b.pto;
                if (iArr == null) {
                    v.e("MicroMsg.MT.MultiTalkVideoNativeReceiver", "onDrawerReady pBuffer is null");
                    return;
                } else if (jVar.hzU.fHM) {
                    v.d("MicroMsg.MT.MultiTalkVideoNativeReceiver", "onDrawerReady busy!!!!");
                    return;
                } else {
                    if (jVar.hzU.hzY == null) {
                        jVar.hzU.hzY = new int[iArr.length];
                    }
                    jVar.hzU.w = i7;
                    jVar.hzU.h = i8;
                    jVar.hzU.hzW = i3;
                    jVar.hzU.hzX = i4;
                    jVar.hzU.angle = i5;
                    long currentTimeMillis3 = System.currentTimeMillis();
                    i6 = jVar.hzU.h;
                    if (jVar.hzU.h > jVar.hzU.w) {
                        i6 = jVar.hzU.w;
                    }
                    if (jVar.hzU.ggw == null) {
                        jVar.hzU.ggw = Bitmap.createBitmap(i6, i6, Config.RGB_565);
                    }
                    if (jVar.hzU.ggw != null) {
                        jVar.hzU.ggw.setPixels(iArr, jVar.hzU.w - jVar.hzU.h, jVar.hzU.w, 0, 0, i6, i6);
                    }
                    if (System.currentTimeMillis() - currentTimeMillis3 > 30) {
                        v.d("MicroMsg.MT.MultiTalkVideoNativeReceiver", "steve: createBitmap: %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis3)});
                    }
                    if (jVar.hzT != null) {
                        jVar.hzT.post(new com.tencent.mm.plugin.multitalk.a.j.b(jVar));
                        return;
                    }
                    return;
                }
            }
            return;
        }
        b(null, false);
    }

    public final synchronized void a(String str, int[] iArr, int i, int i2, int i3, int i4) {
        RelativeLayout wW = wW(str);
        if (wW != null) {
            ((a) wW.getTag()).hBV.a(iArr, i, i2, 0, i4);
        }
    }

    public final synchronized void a(String str, Bitmap bitmap, int i, int i2) {
        RelativeLayout wW = wW(str);
        if (wW != null) {
            ((a) wW.getTag()).hBV.a(bitmap, i2, i);
        }
    }

    public final void aCN() {
        v.e("MicroMsg.MT.MultiTalkTalkingUILogic", "onCameraError");
        if (this.dyF == null) {
            this.dyF = com.tencent.mm.ah.a.a(this.hBh, 2131235929, new Runnable(this) {
                final /* synthetic */ f hBU;

                {
                    this.hBU = r1;
                }

                public final void run() {
                    this.hBU.b(null, false);
                }
            });
        }
        if (!this.dyF.isShowing()) {
            this.dyF.show();
        }
        o.aCG().nn(1);
    }

    public final void gM(String str) {
        v.i("MicroMsg.MT.MultiTalkTalkingUILogic", "notifyChanged %s", new Object[]{str});
        RelativeLayout wW = wW(str);
        if (wW != null) {
            ((a) wW.getTag()).hBV.aCO();
        }
    }

    private static void a(a aVar) {
        if (aVar.hBZ.getBackground() != null) {
            ((AnimationDrawable) aVar.hBZ.getBackground()).stop();
        }
        aVar.hBZ.setVisibility(8);
    }
}
