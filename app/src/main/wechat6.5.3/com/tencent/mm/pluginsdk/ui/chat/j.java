package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Message;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.w;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;

public final class j {
    ImageView bgv = null;
    Bitmap bitmap = null;
    SharedPreferences cnm;
    Context context;
    private View dtW = null;
    View gWD;
    View lHh;
    private i lNN;
    h lNO;
    o lNP;
    boolean lNQ = true;
    com.tencent.mm.pluginsdk.ui.chat.i.a lNR;
    a lNS;

    class AnonymousClass3 implements Runnable {
        final /* synthetic */ j lNT;
        final /* synthetic */ ac lNU;

        AnonymousClass3(j jVar, ac acVar) {
            this.lNT = jVar;
            this.lNU = acVar;
        }

        public final void run() {
            boolean z = true;
            j jVar = this.lNT;
            String bqs = jVar.bqs();
            if (bqs == null) {
                z = false;
            } else {
                int ul = (int) jVar.ul(70);
                int ul2 = (int) jVar.ul(120);
                int JQ = ExifHelper.JQ(bqs);
                if (JQ == 90 || JQ == 270) {
                    int i = ul;
                    ul = ul2;
                    ul2 = i;
                }
                int ul3 = (int) jVar.ul(4);
                Bitmap a = d.a(bqs, ul2, ul, true, null, 0);
                if (a != null) {
                    jVar.bitmap = d.a(d.b(a, (float) JQ), true, (float) ul3);
                    jVar.cnm.edit().putString("chattingui_recent_shown_image_path", jVar.lNO.lNM).commit();
                    v.d("MicroMsg.RecentImageBubble", "check ok");
                } else {
                    v.e("MicroMsg.RecentImageBubble", "image hits hole.");
                    z = false;
                }
            }
            if (z) {
                this.lNU.sendEmptyMessage(0);
            } else {
                v.d("MicroMsg.RecentImageBubble", "check false");
            }
        }

        public final String toString() {
            return super.toString() + "|checkIfShow";
        }
    }

    public interface a {
        void HJ(String str);
    }

    class AnonymousClass2 extends ac {
        final /* synthetic */ j lNT;

        AnonymousClass2(j jVar, Looper looper) {
            this.lNT = jVar;
            super(looper);
        }

        public final void handleMessage(Message message) {
            j jVar = this.lNT;
            if (jVar.bgv != null && jVar.lNO != null && jVar.bitmap != null && jVar.lNP != null && jVar.lHh != null && jVar.gWD != null) {
                jVar.bgv.setImageBitmap(jVar.bitmap);
                int i = jVar.lNQ ? 83 : 85;
                int i2 = jVar.lNQ ? 0 : 10;
                int bqm = jVar.lNR != null ? jVar.lNR.bqm() : jVar.gWD.getHeight();
                if (VERSION.SDK_INT >= 21) {
                    Rect bAH = w.bAH();
                    i2 = jVar.lNQ ? 0 : i2 + bAH.right;
                    bqm += bAH.bottom;
                    v.i("MicroMsg.RecentImageBubble", "recent bubble navbar height %s %s", Integer.valueOf(bAH.right), Integer.valueOf(bAH.bottom));
                }
                jVar.lNP.showAtLocation(jVar.lHh, i, i2, bqm);
                new ah(new com.tencent.mm.sdk.platformtools.ah.a(jVar) {
                    final /* synthetic */ j lNT;

                    {
                        this.lNT = r1;
                    }

                    public final boolean oU() {
                        j jVar = this.lNT;
                        if (jVar.lNP != null) {
                            jVar.lNP.dismiss();
                        }
                        return false;
                    }
                }, false).ea(10000);
            }
        }
    }

    public j(Context context, View view, View view2, a aVar) {
        this.context = context;
        this.lHh = view;
        this.gWD = view2;
        this.lNN = new i(this.context);
        this.cnm = context.getSharedPreferences(aa.bti(), 0);
        this.lNS = aVar;
        this.dtW = View.inflate(this.context, 2130903290, null);
        this.bgv = (ImageView) this.dtW.findViewById(2131756088);
        this.lNP = new o(this.dtW, -2, -2, true);
        this.lNP.setBackgroundDrawable(new ColorDrawable(0));
        this.lNP.setOutsideTouchable(true);
        this.dtW.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ j lNT;

            {
                this.lNT = r1;
            }

            public final void onClick(View view) {
                if (!(this.lNT.lNS == null || this.lNT.lNO == null)) {
                    this.lNT.lNS.HJ(this.lNT.lNO.lNM);
                }
                this.lNT.lNP.dismiss();
            }
        });
    }

    public final synchronized String bqs() {
        String str;
        h hVar;
        if (this.lNN == null) {
            v.d("MicroMsg.RecentImageBubble", "because of imageQuery == null");
            hVar = null;
        } else {
            ArrayList bqr = this.lNN.bqr();
            if (bqr == null || bqr.size() == 0) {
                v.d("MicroMsg.RecentImageBubble", "because of items == null || items.size() == 0");
                hVar = null;
            } else {
                hVar = (h) bqr.get(0);
                if (hVar != null) {
                    if ((be.ax(hVar.geb) < 0 ? 1 : null) != null) {
                        v.e("MicroMsg.RecentImageBubble", "we found u have a future pic that lead to forbid this featur. file : %s", hVar.lNM);
                        hVar = null;
                    }
                }
                if (hVar == null || hVar.lNM == null || !hVar.lNM.contains(e.dEh)) {
                    if (hVar != null) {
                        if ((be.ax(hVar.geb) <= 30 ? 1 : null) != null) {
                            if (this.cnm.getString("chattingui_recent_shown_image_path", SQLiteDatabase.KeyEmpty).equals(hVar.lNM)) {
                                v.d("MicroMsg.RecentImageBubble", "because of recentImage.equals(imageItem.orginalPath)");
                                hVar = null;
                            }
                        }
                    }
                    String str2 = "MicroMsg.RecentImageBubble";
                    String str3 = "because of checkAddDate(addDate) == false, or imageItem == null : %s";
                    Object[] objArr = new Object[1];
                    objArr[0] = Boolean.valueOf(hVar == null);
                    v.d(str2, str3, objArr);
                    hVar = null;
                } else {
                    hVar = null;
                }
            }
        }
        this.lNO = hVar;
        if (this.lNO == null) {
            str = null;
        } else {
            str = this.lNO.bdZ;
            if (this.lNO.bdZ == null) {
                str = this.lNO.lNM;
            }
        }
        return str;
    }

    final float ul(int i) {
        return TypedValue.applyDimension(1, (float) i, this.context.getResources().getDisplayMetrics());
    }
}
