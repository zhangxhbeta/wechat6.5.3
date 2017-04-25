package com.tencent.mm.ui.chatting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.a.e;
import com.tencent.mm.ae.n;
import com.tencent.mm.e.a.cp;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.k;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.ad.c;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.sdk.WebView;

final class ax extends c {
    a onG;

    public ax() {
        super(21);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && (view.getTag() instanceof h) && ((h) view.getTag()).type == this.eKg) {
            return view;
        }
        view = new bd(layoutInflater, 2130903343);
        view.setTag(new h(this.eKg).cH(view));
        return view;
    }

    public final void a(ad.a aVar, int i, a aVar2, at atVar, String str) {
        int i2;
        aVar = (h) aVar;
        this.onG = aVar2;
        aVar2.ay(atVar);
        com.tencent.mm.q.a.a aVar3 = null;
        String str2 = atVar.field_content;
        if (str2 != null) {
            aVar3 = com.tencent.mm.q.a.a.B(str2, atVar.field_reserved);
        }
        if (aVar3 != null) {
            f bA = g.bA(aVar3.appId, aVar3.bpy);
            String str3 = (bA == null || bA.field_appName == null || bA.field_appName.trim().length() <= 0) ? aVar3.appName : bA.field_appName;
            if (aVar3.appId == null || aVar3.appId.length() <= 0 || !g.bo(str3)) {
                aVar.fSs.setVisibility(8);
            } else {
                aVar.fSs.setText(g.a(aVar2.nDR.nEl, bA, str3));
                aVar.fSs.setVisibility(0);
                if (bA == null || !bA.bnk()) {
                    ad.a(aVar2, aVar.fSs, aVar3.appId);
                } else {
                    ad.a(aVar2, aVar.fSs, atVar, aVar3, bA.field_packageName, atVar.field_msgSvrId);
                }
                ad.a(aVar2, aVar.fSs, aVar3.appId);
            }
            switch (aVar3.type) {
                case 2:
                    String str4;
                    aVar.geY.setVisibility(0);
                    b Gu = am.Wf().Gu(aVar3.aXa);
                    if (Gu != null) {
                        str4 = Gu.field_fileFullPath;
                    } else {
                        str4 = null;
                    }
                    if (str4 == null || str4.length() <= 0) {
                        if (!n.GH().a(aVar.geY, atVar.field_imgPath, com.tencent.mm.bd.a.getDensity(aVar2.nDR.nEl), aVar3.coo, aVar3.con, 2130837922, aVar.gfd, 2130837924)) {
                            if (this.lVu) {
                                aVar.geY.setImageResource(2131165375);
                            } else {
                                aVar.geY.setImageBitmap(BitmapFactory.decodeResource(aVar2.getResources(), 2130838794));
                            }
                            final ad.a aVar4 = aVar;
                            aVar.geY.post(new Runnable(this) {
                                final /* synthetic */ ax ood;

                                public final void run() {
                                    aVar4.geY.setLayoutParams(new LayoutParams(-2, -2));
                                    aVar4.gfd.setLayoutParams(new LayoutParams(aVar4.geY.getWidth(), aVar4.geY.getHeight()));
                                }
                            });
                            break;
                        }
                    }
                    Bitmap lW = j.lW(str4);
                    if (lW == null) {
                        if (!this.lVu) {
                            aVar.geY.setImageBitmap(BitmapFactory.decodeResource(aVar2.getResources(), 2130838794));
                            break;
                        } else {
                            aVar.geY.setImageResource(2131165375);
                            break;
                        }
                    }
                    int width = lW.getWidth();
                    int height = lW.getHeight();
                    float density = com.tencent.mm.bd.a.getDensity(aVar2.nDR.nEl);
                    float f = 150.0f * density;
                    float f2 = 150.0f * density;
                    if (((float) width) >= f || ((float) height) >= f2) {
                        if (height > width) {
                            f = f2 / ((float) height);
                        } else {
                            f /= (float) width;
                        }
                        width = (int) (((float) width) * f);
                        i2 = (int) (f * ((float) height));
                    } else {
                        i2 = height;
                    }
                    if (((float) width) < 75.0f * density) {
                        v.d("MicroMsg.ChattingItemAppMsgToImg", "pic to small width is %d ", Integer.valueOf(width));
                        width = (int) (75.0f * density);
                    }
                    if (((float) i2) < 75.0f * density) {
                        v.d("MicroMsg.ChattingItemAppMsgToImg", "pic to small height is %d ", Integer.valueOf(i2));
                        i2 = (int) (75.0f * density);
                    }
                    aVar.geY.setImageBitmap(d.b(Bitmap.createScaledBitmap(j.lW(str4), width, i2, true), 2130837922));
                    break;
                    break;
            }
        }
        aVar.onC.setTag(new dl(atVar, aVar2.nQK, i, null, 0, (byte) 0));
        aVar.onC.setOnClickListener(aVar2.onh.oqh);
        if (this.lVu) {
            aVar.onC.setOnLongClickListener(aVar2.onh.oqj);
        }
        i2 = l.GC(str2);
        if (i2 == -1 || i2 >= 100 || aVar3.cob <= 0 || atVar.field_status == 5) {
            aVar.fQI.setVisibility(8);
            aVar.geY.setAlpha(WebView.NORMAL_MODE_ALPHA);
            aVar.geY.setBackgroundDrawable(null);
        } else {
            aVar.fQI.setVisibility(0);
            aVar.okr.setText(i2 + "%");
            aVar.geY.setAlpha(64);
            aVar.geY.setBackgroundResource(2130839095);
        }
        ad.a(i, aVar, atVar, aVar2.onh.cyO, aVar2.nQK, aVar2.onh.oqh);
    }

    public final boolean a(ContextMenu contextMenu, View view, at atVar) {
        int i = ((dl) view.getTag()).position;
        com.tencent.mm.q.a.a dV = com.tencent.mm.q.a.a.dV(this.onG.cf(atVar.field_content, atVar.field_isSend));
        if (dV != null && g.i(g.aC(dV.appId, false))) {
            contextMenu.add(i, MMGIFException.D_GIF_ERR_NOT_READABLE, 0, this.onG.getString(2131234555));
        }
        if (com.tencent.mm.ay.c.EH("favorite")) {
            contextMenu.add(i, 116, 0, this.onG.getString(2131234180));
        }
        com.tencent.mm.sdk.c.b cpVar = new cp();
        cpVar.bay.bao = atVar.field_msgId;
        com.tencent.mm.sdk.c.a.nhr.z(cpVar);
        boolean l = g.l(this.onG.nDR.nEl, 2);
        if (cpVar.baz.aZW || l) {
            contextMenu.add(i, FileUtils.S_IWUSR, 0, view.getContext().getString(2131231834));
        }
        if (!atVar.bvZ() && atVar.bwr() && ((atVar.field_status == 2 || atVar.bNs == 1) && ad.bEz() && ad.OI(atVar.field_talker))) {
            contextMenu.add(i, 123, 0, view.getContext().getString(2131231836));
        }
        if (!this.onG.bFL()) {
            contextMenu.add(i, 100, 0, this.onG.getString(2131231829));
        }
        return true;
    }

    public final boolean a(MenuItem menuItem, a aVar, at atVar) {
        com.tencent.mm.q.a.a dV;
        String str = null;
        String str2 = atVar.field_content;
        if (str2 != null) {
            dV = com.tencent.mm.q.a.a.dV(str2);
        } else {
            dV = null;
        }
        switch (menuItem.getItemId()) {
            case 100:
                if (dV != null) {
                    l.GB(dV.aXa);
                }
                aw.L(atVar.field_msgId);
                f aC = g.aC(dV.appId, false);
                if (aC != null && aC.bnk()) {
                    ad.a(aVar, dV, atVar, aC);
                    break;
                }
            case MMGIFException.D_GIF_ERR_NOT_READABLE /*111*/:
                if (!(dV == null || dV.aXa == null || dV.aXa.length() <= 0)) {
                    b Gu = am.Wf().Gu(dV.aXa);
                    if (Gu != null) {
                        str = Gu.field_fileFullPath;
                    }
                }
                Intent intent = new Intent(aVar.nDR.nEl, MsgRetransmitUI.class);
                intent.putExtra("Retr_Msg_content", atVar.field_content);
                intent.putExtra("Retr_File_Name", str);
                intent.putExtra("Retr_Msg_Type", 16);
                intent.putExtra("Retr_Msg_Id", atVar.field_msgId);
                aVar.startActivity(intent);
                break;
        }
        return false;
    }

    public final boolean a(View view, a aVar, at atVar) {
        ak.yW();
        if (!com.tencent.mm.model.c.isSDCardAvailable()) {
            s.ey(aVar.nDR.nEl);
            return true;
        } else if (((dl) view.getTag()).eKg == 5 && atVar.field_isSend == 1) {
            if (atVar != null) {
                final at atVar2 = atVar;
                com.tencent.mm.ui.base.g.b(this.onG.nDR.nEl, this.onG.getString(2131231873), SQLiteDatabase.KeyEmpty, this.onG.getString(2131231143), this.onG.getString(2131231010), new OnClickListener(this) {
                    final /* synthetic */ ax ood;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        l.L(atVar2);
                        aw.L(atVar2.field_msgId);
                        this.ood.onG.bFI();
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ ax ood;

                    {
                        this.ood = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            }
            return true;
        } else {
            com.tencent.mm.q.a.a aVar2 = null;
            String str = atVar.field_content;
            if (str != null) {
                aVar2 = com.tencent.mm.q.a.a.dV(str);
            }
            if (aVar2 == null) {
                v.e("MicroMsg.ChattingItemAppMsgToImg", "content is null");
                return true;
            }
            int height;
            int i;
            int[] iArr = new int[2];
            if (view != null) {
                view.getLocationInWindow(iArr);
                int width = view.getWidth();
                height = view.getHeight();
                i = width;
            } else {
                height = 0;
                i = 0;
            }
            f aC = g.aC(aVar2.appId, false);
            if (aC != null && aC.bnk()) {
                ad.a(aVar, aVar2, k.xF(), aC, atVar.field_msgSvrId);
            }
            String str2;
            if (aVar2.aXa != null && aVar2.aXa.length() > 0) {
                b Gu = am.Wf().Gu(aVar2.aXa);
                if (Gu != null) {
                    ak.yW();
                    if (!com.tencent.mm.model.c.isSDCardAvailable()) {
                        s.ey(aVar.nDR.nEl);
                    } else if (atVar.field_isSend == 1) {
                        str = Gu.field_fileFullPath;
                        Intent intent;
                        if (e.aR(str)) {
                            int i2 = (int) atVar.field_msgId;
                            long j = atVar.field_msgSvrId;
                            str2 = atVar.field_talker;
                            if (str == null || str.equals(SQLiteDatabase.KeyEmpty) || !e.aR(str)) {
                                v.d("MicroMsg.ChattingItemAppMsgToImg", "showImg : imgPath is null");
                            } else {
                                intent = new Intent(this.onG.nDR.nEl, ImageGalleryUI.class);
                                intent.putExtra("img_gallery_msg_id", (long) i2);
                                intent.putExtra("img_gallery_talker", str2);
                                intent.putExtra("img_gallery_left", iArr[0]);
                                intent.putExtra("img_gallery_top", iArr[1]);
                                intent.putExtra("img_gallery_width", i);
                                intent.putExtra("img_gallery_height", height);
                                this.onG.startActivity(intent);
                            }
                        } else {
                            v.i("MicroMsg.ChattingItemAppMsgToImg", "onItemClick::bigImgPath: %s, msgId: %d, msgSvrId: %d", str, Long.valueOf(atVar.field_msgId), Long.valueOf(atVar.field_msgSvrId));
                            intent = new Intent(aVar.nDR.nEl, ResourcesExceedUI.class);
                            intent.putExtra("clean_view_type", 1);
                            aVar.startActivity(intent);
                            return true;
                        }
                    }
                    return true;
                }
            } else if (aVar2.url != null && aVar2.url.length() > 0) {
                str2 = p.s(aVar2.url, "message");
                PackageInfo av = ad.av(aVar.nDR.nEl, aVar2.appId);
                a(aVar, str2, str2, av == null ? null : av.versionName, av == null ? 0 : av.versionCode, aVar2.appId, false, atVar.field_msgId, atVar.field_msgSvrId, atVar);
            }
            return false;
        }
    }
}
