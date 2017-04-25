package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.e.a.ae;
import com.tencent.mm.e.a.bl;
import com.tencent.mm.e.a.bp;
import com.tencent.mm.e.a.cp;
import com.tencent.mm.e.a.ir;
import com.tencent.mm.e.a.kt;
import com.tencent.mm.e.a.kv;
import com.tencent.mm.e.a.nk;
import com.tencent.mm.e.a.oh;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.e.al;
import com.tencent.mm.plugin.sns.e.b.b;
import com.tencent.mm.plugin.sns.storage.k;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ak;
import com.tencent.mm.ui.base.f;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.l;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public abstract class FlipView extends LinearLayout implements OnTouchListener, b {
    private int aYV;
    private int aYW;
    private Context context;
    private long cvj = 0;
    private l eIV;
    float gsW = 0.0f;
    float gsX = 0.0f;
    boolean gsY = false;
    float gsZ = 1.0f;
    protected ac handler;
    protected int infoType = -1;
    private double jFj = 0.0d;
    private double jFk = 0.0d;
    protected t jFl;
    protected com.tencent.mm.plugin.sns.ui.r.a jFm;
    protected int jFn;
    protected int jFo;
    private boolean jFp = false;
    private long jFq = 0;
    boolean jFr = false;
    private String jFs;
    private String jFt;
    private String jFu;
    private String jFv;
    private a jFw = new a(this);
    private c jFx = new c<kv>(this) {
        final /* synthetic */ FlipView jFz;

        {
            this.jFz = r2;
            this.nhz = kv.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            kv kvVar = (kv) bVar;
            if (!this.jFz.jFr) {
                v.i("MicroMsg.FlipView", "no need to scan image");
            } else if (this.jFz.eIV == null || this.jFz.jFs == null) {
                v.e("MicroMsg.FlipView", "not in recoging");
            } else if (kvVar == null || !(kvVar instanceof kv)) {
                v.e("MicroMsg.FlipView", "receive invalid callbak");
            } else if (kvVar.bme.filePath.equals(this.jFz.jFs)) {
                v.i("MicroMsg.FlipView", "recog result: " + kvVar.bme.bfz);
                if (!be.kS(kvVar.bme.bfz)) {
                    this.jFz.jFv = kvVar.bme.bfz;
                    this.jFz.aYV = kvVar.bme.aYV;
                    this.jFz.aYW = kvVar.bme.aYW;
                    this.jFz.d(this.jFz.jFs, this.jFz.jFt, this.jFz.jFu, false);
                }
                this.jFz.jFs = null;
            } else {
                v.e("MicroMsg.FlipView", "not same filepath");
            }
            return false;
        }
    };
    private c jFy = new c<ir>(this) {
        final /* synthetic */ FlipView jFz;

        {
            this.jFz = r2;
            this.nhz = ir.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            ir irVar = (ir) bVar;
            if (this.jFz.jFr) {
                if (irVar != null && (irVar instanceof ir)) {
                    v.i("MicroMsg.FlipView", "notify Event: %d", new Object[]{Integer.valueOf(irVar.bjg.bje)});
                    if (irVar.bjg.aXH == ((Activity) this.jFz.context) && irVar.bjg.aXG.equals(this.jFz.jFv)) {
                        switch (irVar.bjg.bje) {
                            case 0:
                            case 1:
                            case 2:
                                break;
                            case 3:
                                ((Activity) this.jFz.context).finish();
                                break;
                            default:
                                break;
                        }
                    }
                    v.e("MicroMsg.FlipView", "not the same");
                } else {
                    v.e("MicroMsg.FlipView", "event is null or not a instant of NotifyDealQBarStrResultEvent");
                }
            } else {
                v.i("MicroMsg.FlipView", "no need to scan image");
            }
            return false;
        }
    };

    class a implements Runnable {
        final /* synthetic */ FlipView jFz;
        float x;
        float y;

        a(FlipView flipView) {
            this.jFz = flipView;
        }

        public final void run() {
        }
    }

    public abstract long aVB();

    public abstract boolean aVC();

    public abstract int getPosition();

    static /* synthetic */ void BQ(String str) {
        oh ohVar = new oh();
        ohVar.bpj.bdn = 3;
        ohVar.bpj.bde = str;
        com.tencent.mm.sdk.c.a.nhr.z(ohVar);
    }

    static /* synthetic */ void BR(String str) {
        oh ohVar = new oh();
        ohVar.bpj.bdn = 1;
        ohVar.bpj.bpm = 2;
        ohVar.bpj.bde = str;
        com.tencent.mm.sdk.c.a.nhr.z(ohVar);
    }

    static /* synthetic */ void h(boolean z, String str) {
        oh ohVar = new oh();
        ohVar.bpj.bdn = 2;
        ohVar.bpj.bpk = 14;
        ohVar.bpj.bpl = z;
        ohVar.bpj.bde = str;
        com.tencent.mm.sdk.c.a.nhr.z(ohVar);
    }

    public FlipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public FlipView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
        this.handler = new ac();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) this.context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.jFn = displayMetrics.widthPixels;
        this.jFo = displayMetrics.heightPixels;
        com.tencent.mm.sdk.c.a.nhr.e(this.jFx);
        com.tencent.mm.sdk.c.a.nhr.e(this.jFy);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            v.d("MicroMsg.FlipView", "onTouchEvent down");
            this.jFj = (double) motionEvent.getX();
            this.jFk = (double) motionEvent.getY();
            this.cvj = System.currentTimeMillis();
            if (f.x(motionEvent) == 1) {
                this.jFp = false;
            }
        }
        if (f.x(motionEvent) > 1) {
            this.jFp = true;
        }
        if (motionEvent.getAction() == 1 && !this.jFp) {
            v.d("MicroMsg.FlipView", "onTouchEvent up " + (System.currentTimeMillis() - this.cvj));
            long Nj = be.Nj();
            v.d("MicroMsg.FlipView", "deltTime: " + (Nj - this.jFq));
            if (Nj - this.jFq < 300) {
                this.handler.removeCallbacks(this.jFw);
                this.handler.post(new Runnable(this) {
                    final /* synthetic */ FlipView jFz;

                    {
                        this.jFz = r1;
                    }

                    public final void run() {
                    }
                });
                return super.dispatchTouchEvent(motionEvent);
            }
            this.jFq = Nj;
            if (System.currentTimeMillis() - this.cvj < 500 && Math.abs(((double) motionEvent.getX()) - this.jFj) <= 10.0d && Math.abs(((double) motionEvent.getY()) - this.jFk) <= 10.0d && motionEvent.getY() > 110.0f && motionEvent.getY() < ((float) (this.jFo - 100))) {
                a aVar = this.jFw;
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                aVar.x = x;
                aVar.y = y;
                this.handler.postDelayed(this.jFw, 10);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        return !f.aZy() ? false : false;
    }

    public final void Aa(String str) {
    }

    public void ai(String str, boolean z) {
    }

    public final void aRc() {
    }

    public void aj(String str, boolean z) {
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    protected final void d(final String str, final String str2, final String str3, boolean z) {
        final List arrayList = new ArrayList();
        final List arrayList2 = new ArrayList();
        k Bq = ad.aSE().Bq(str2);
        if (Bq == null) {
            v.e("MicroMsg.FlipView", "error!!show long click Alert snsInfo is null!!");
            return;
        }
        if (Bq.field_type != 21) {
            if (!s.BJ(str2)) {
                arrayList.add(this.context.getString(2131235509));
                arrayList2.add(Integer.valueOf(1));
            }
            if (com.tencent.mm.ay.c.EH("favorite")) {
                arrayList.add(this.context.getString(2131234180));
                arrayList2.add(Integer.valueOf(2));
            }
            if (!s.BJ(str2)) {
                if (Bq.field_type == 15 || Bq.field_type == 5) {
                    arrayList.add(this.context.getString(2131234728));
                    arrayList2.add(Integer.valueOf(0));
                } else if (Bq.field_type == 1) {
                    arrayList.add(this.context.getString(2131234725));
                    arrayList2.add(Integer.valueOf(0));
                } else {
                    arrayList.add(this.context.getString(2131235511));
                    arrayList2.add(Integer.valueOf(0));
                }
            }
            cp cpVar = new cp();
            cpVar.bay.bap = str2;
            com.tencent.mm.sdk.c.a.nhr.z(cpVar);
            if (cpVar.baz.aZW) {
                arrayList.add(this.context.getString(2131231834));
                arrayList2.add(Integer.valueOf(5));
            }
            if (this.jFv != null) {
                arrayList.add(this.context.getString(2131235512));
                arrayList2.add(Integer.valueOf(4));
            }
        } else if (!Bq.field_userName.equals(com.tencent.mm.model.k.xF())) {
            arrayList.add(this.context.getString(2131235406));
            arrayList2.add(Integer.valueOf(3));
        }
        if (this.eIV == null) {
            this.eIV = new l(this.context);
        }
        this.eIV.jXn = new n.c(this) {
            final /* synthetic */ FlipView jFz;

            public final void a(com.tencent.mm.ui.base.l lVar) {
                for (int i = 0; i < arrayList.size(); i++) {
                    lVar.d(((Integer) arrayList2.get(i)).intValue(), (CharSequence) arrayList.get(i));
                }
            }
        };
        this.eIV.d(new OnCancelListener(this) {
            final /* synthetic */ FlipView jFz;

            {
                this.jFz = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                ae aeVar = new ae();
                aeVar.aXI.filePath = this.jFz.jFs;
                com.tencent.mm.sdk.c.a.nhr.z(aeVar);
                this.jFz.eIV = null;
                this.jFz.jFs = null;
                this.jFz.jFt = "";
                this.jFz.jFu = null;
                this.jFz.jFv = null;
                this.jFz.aYV = this.jFz.aYW = 0;
            }
        });
        this.eIV.jXo = new d(this) {
            final /* synthetic */ FlipView jFz;

            public final void c(MenuItem menuItem, int i) {
                k Bq = ad.aSE().Bq(str2);
                if (Bq == null) {
                    v.i("MicroMsg.FlipView", "error beacause info null");
                    return;
                }
                switch (menuItem.getItemId()) {
                    case 0:
                        if (Bq.field_type != 15) {
                            com.tencent.mm.pluginsdk.ui.tools.l.h(str, this.jFz.context);
                            return;
                        } else {
                            FlipView.BQ(str2);
                            return;
                        }
                    case 1:
                        if (Bq.field_type != 15) {
                            Intent intent = new Intent();
                            intent.putExtra("Retr_File_Name", str);
                            intent.putExtra("Retr_Compress_Type", 0);
                            intent.putExtra("Retr_Msg_Type", 0);
                            if (Bq != null) {
                                intent.putExtra("Retr_FromMainTimeline", this.jFz.aVC());
                                intent.putExtra("Retr_KSnsId", i.g(Bq));
                            }
                            com.tencent.mm.plugin.sns.b.a.drp.l(intent, this.jFz.context);
                            return;
                        }
                        new StringBuilder().append(al.cA(ad.xh(), str3)).append(i.c((aib) Bq.aUp().mWq.mom.get(0)));
                        FlipView.BR(str2);
                        return;
                    case 2:
                        bp bpVar;
                        nk nkVar;
                        if (Bq.field_type != 15) {
                            bpVar = new bp();
                            com.tencent.mm.plugin.sns.j.a.b(bpVar, str2, str3);
                            bpVar.aZd.aZl = 13;
                            bpVar.aZd.aXH = (Activity) this.jFz.context;
                            com.tencent.mm.sdk.c.a.nhr.z(bpVar);
                            if (this.jFz.aVC()) {
                                nkVar = new nk();
                                nkVar.boD.boC = i.g(Bq);
                                nkVar.boD.bap = Bq.aUL();
                                com.tencent.mm.sdk.c.a.nhr.z(nkVar);
                                return;
                            }
                            return;
                        } else if (Bq != null) {
                            if (Bq.qC(32)) {
                                bpVar = new bp();
                                com.tencent.mm.plugin.sns.j.a.a(bpVar, Bq);
                                bpVar.aZd.aZl = 14;
                                bpVar.aZd.aXH = (Activity) this.jFz.context;
                                com.tencent.mm.sdk.c.a.nhr.z(bpVar);
                            } else {
                                FlipView.h(this.jFz.aVC(), Bq.aUL());
                            }
                            if (this.jFz.aVC()) {
                                nkVar = new nk();
                                nkVar.boD.boC = i.g(Bq);
                                nkVar.boD.bap = Bq.aUL();
                                com.tencent.mm.sdk.c.a.nhr.z(nkVar);
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    case 3:
                        Intent intent2 = new Intent();
                        intent2.putExtra("k_expose_msg_id", this.jFz.aVB());
                        k dd = ad.aSE().dd(this.jFz.aVB());
                        intent2.putExtra("k_username", dd == null ? "" : dd.field_userName);
                        intent2.putExtra("showShare", false);
                        intent2.putExtra("rawUrl", "https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect33");
                        intent2.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(33)}));
                        com.tencent.mm.ay.c.b(this.jFz.context, "webview", ".ui.tools.WebViewUI", intent2);
                        return;
                    case 4:
                        v.i("MicroMsg.FlipView", "request deal QBAR string");
                        bl blVar = new bl();
                        blVar.aYU.aXH = (Activity) this.jFz.context;
                        blVar.aYU.aXG = this.jFz.jFv;
                        blVar.aYU.aYV = this.jFz.aYV;
                        blVar.aYU.aYW = this.jFz.aYW;
                        if (this.jFz instanceof SnsInfoFlip) {
                            SnsInfoFlip snsInfoFlip = (SnsInfoFlip) this.jFz;
                            ak akVar = snsInfoFlip.jdP;
                            v.d("MicroMsg.FlipView", "from Scene: %s", new Object[]{akVar.tag});
                            if (akVar.tag.equals(ak.nvq.tag) || akVar.tag.equals(ak.nvr.tag) || akVar.tag.equals(ak.nvs.tag)) {
                                blVar.aYU.aYX = 5;
                                if (be.kS(snsInfoFlip.username)) {
                                    v.i("MicroMsg.FlipView", "empty username");
                                    snsInfoFlip.username = "";
                                }
                                blVar.aYU.aHM = snsInfoFlip.username;
                            } else if (akVar.tag.equals(ak.nvp.tag)) {
                                blVar.aYU.aYX = 3;
                            } else {
                                v.i("MicroMsg.FlipView", "other scene_from: %s", new Object[]{akVar.tag});
                            }
                        }
                        com.tencent.mm.sdk.c.a.nhr.z(blVar);
                        return;
                    case 5:
                        if (Bq.aUp().mWq.mom.size() != 0) {
                            Intent intent3 = new Intent();
                            if (Bq.field_type == 1) {
                                int position = this.jFz.getPosition();
                                int size = Bq.aUp().mWq.mom.size();
                                if (size <= 1 || position <= 1 || position > size) {
                                    position = 0;
                                } else {
                                    position--;
                                }
                                String f = FlipView.f(str, this.jFz.context);
                                if (f != null) {
                                    intent3.putExtra("sns_send_data_ui_image_path", f);
                                    intent3.putExtra("sns_send_data_ui_image_position", position);
                                } else {
                                    return;
                                }
                            }
                            intent3.putExtra("sns_send_data_ui_activity", true);
                            intent3.putExtra("sns_local_id", str2);
                            com.tencent.mm.ay.c.a(this.jFz.context, ".ui.chatting.ChattingSendDataToDeviceUI", intent3);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        g.a(this.context, this.eIV.aXZ());
        if (this.jFr && true == z && com.tencent.mm.model.ak.vy().BJ() != 0) {
            this.jFs = str;
            this.jFt = str2;
            this.jFu = str3;
            kt ktVar = new kt();
            ktVar.bmc.filePath = str;
            com.tencent.mm.sdk.c.a.nhr.z(ktVar);
        }
    }

    public static String f(String str, Context context) {
        Throwable e;
        Throwable th;
        int i = 1;
        if (str == null || str.equals("")) {
            return null;
        }
        String str2 = e.cgg + String.format("%s%d.%s", new Object[]{SlookAirButtonRecentMediaAdapter.IMAGE_TYPE, Integer.valueOf(str.hashCode()), "jpg"});
        String absolutePath = new File(aa.getContext().getCacheDir(), "tmp" + System.currentTimeMillis()).getAbsolutePath();
        if (FileOp.p(str, absolutePath) < 0) {
            return null;
        }
        if (MMNativeJpeg.isProgressive(absolutePath)) {
            FileOutputStream fileOutputStream;
            try {
                Bitmap decodeAsBitmap = MMNativeJpeg.decodeAsBitmap(absolutePath);
                if (decodeAsBitmap != null) {
                    CompressFormat compressFormat = CompressFormat.JPEG;
                    fileOutputStream = new FileOutputStream(str2);
                    try {
                        decodeAsBitmap.compress(compressFormat, 80, fileOutputStream);
                    } catch (FileNotFoundException e2) {
                        e = e2;
                        try {
                            v.a("MicroMsg.FlipView", e, "", new Object[0]);
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Exception e3) {
                                }
                            }
                            FileOp.deleteFile(absolutePath);
                            i = 0;
                            if (i != 0) {
                            }
                            context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(str2))));
                            return str2;
                        } catch (Throwable th2) {
                            th = th2;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Exception e4) {
                                }
                            }
                            FileOp.deleteFile(absolutePath);
                            throw th;
                        }
                    } catch (OutOfMemoryError e5) {
                        e = e5;
                        v.a("MicroMsg.FlipView", e, "", new Object[0]);
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e6) {
                            }
                        }
                        FileOp.deleteFile(absolutePath);
                        i = 0;
                        if (i != 0) {
                        }
                        context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(str2))));
                        return str2;
                    }
                }
                fileOutputStream = null;
                i = 0;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Exception e7) {
                    }
                }
                FileOp.deleteFile(absolutePath);
            } catch (FileNotFoundException e8) {
                e = e8;
                fileOutputStream = null;
                v.a("MicroMsg.FlipView", e, "", new Object[0]);
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                FileOp.deleteFile(absolutePath);
                i = 0;
                if (i != 0) {
                }
                context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(str2))));
                return str2;
            } catch (OutOfMemoryError e9) {
                e = e9;
                fileOutputStream = null;
                v.a("MicroMsg.FlipView", e, "", new Object[0]);
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                FileOp.deleteFile(absolutePath);
                i = 0;
                if (i != 0) {
                }
                context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(str2))));
                return str2;
            } catch (Throwable th3) {
                fileOutputStream = null;
                th = th3;
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                FileOp.deleteFile(absolutePath);
                throw th;
            }
        }
        i = 0;
        if (i != 0 && FileOp.p(str, str2) < 0) {
            return null;
        }
        context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(str2))));
        return str2;
    }

    protected void onPause() {
        this.jFs = null;
        this.jFt = "";
        this.jFu = null;
        if (this.jFv != null) {
            com.tencent.mm.e.a.ad adVar = new com.tencent.mm.e.a.ad();
            adVar.aXF.aXH = (Activity) this.context;
            adVar.aXF.aXG = this.jFv;
            com.tencent.mm.sdk.c.a.nhr.z(adVar);
            this.jFv = null;
            this.aYW = 0;
            this.aYV = 0;
        }
    }

    protected final void onDestroy() {
        com.tencent.mm.sdk.c.a.nhr.f(this.jFx);
        com.tencent.mm.sdk.c.a.nhr.f(this.jFy);
    }

    public aib aVD() {
        return null;
    }
}
