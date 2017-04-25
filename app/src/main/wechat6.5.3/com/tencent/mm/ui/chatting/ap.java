package com.tencent.mm.ui.chatting;

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
import com.tencent.mm.ay.c;
import com.tencent.mm.e.a.cp;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.ad.b;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;

final class ap extends b {
    private a onG;

    public ap() {
        super(20);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && (view.getTag() instanceof h) && ((h) view.getTag()).type == this.eKg) {
            return view;
        }
        view = new bd(layoutInflater, 2130903312);
        view.setTag(new h(this.eKg).cH(view));
        return view;
    }

    public final void a(ad.a aVar, int i, a aVar2, at atVar, String str) {
        int indexOf;
        h hVar = (h) aVar;
        this.onG = aVar2;
        aVar2.ay(atVar);
        com.tencent.mm.q.a.a aVar3 = null;
        String str2 = atVar.field_content;
        if (aVar2.onl) {
            indexOf = atVar.field_content.indexOf(58);
            if (indexOf != -1) {
                str2 = atVar.field_content.substring(indexOf + 1);
            }
        }
        if (str2 != null) {
            aVar3 = com.tencent.mm.q.a.a.B(str2, atVar.field_reserved);
        }
        if (aVar3 != null) {
            f bA = g.bA(aVar3.appId, aVar3.bpy);
            if (bA != null && bA.bnk()) {
                ad.b(aVar2, aVar3, atVar);
            }
            str2 = (bA == null || bA.field_appName == null || bA.field_appName.trim().length() <= 0) ? aVar3.appName : bA.field_appName;
            if (aVar3.appId == null || aVar3.appId.length() <= 0 || !g.bo(str2)) {
                hVar.fSs.setVisibility(8);
            } else {
                hVar.fSs.setText(g.a(aVar2.nDR.nEl, bA, str2));
                hVar.fSs.setVisibility(0);
                if (bA == null || !bA.bnk()) {
                    ad.a(aVar2, hVar.fSs, aVar3.appId);
                } else {
                    ad.a(aVar2, hVar.fSs, atVar, aVar3, bA.field_packageName, atVar.field_msgSvrId);
                }
                ad.a(aVar2, hVar.fSs, aVar3.appId);
            }
            if (aVar3.bNm == null || aVar3.bNm.length() == 0) {
                hVar.oks.setVisibility(8);
            } else {
                hVar.oks.setVisibility(0);
                ad.b(aVar2, hVar.oks, (Object) dl.Pa(aVar3.bNm));
            }
            switch (aVar3.type) {
                case 2:
                    String str3;
                    hVar.geY.setVisibility(0);
                    com.tencent.mm.pluginsdk.model.app.b Gu = am.Wf().Gu(aVar3.aXa);
                    if (Gu != null) {
                        str3 = Gu.field_fileFullPath;
                    } else {
                        str3 = null;
                    }
                    final h hVar2;
                    if (str3 == null || str3.length() <= 0) {
                        if (!n.GH().a(hVar.geY, atVar.field_imgPath, com.tencent.mm.bd.a.getDensity(aVar2.nDR.nEl), aVar3.com, aVar3.col, 2130837919, hVar.gfd, 2130837921)) {
                            if (this.lVu) {
                                hVar.geY.setImageResource(2131165374);
                            } else {
                                hVar.geY.setImageBitmap(BitmapFactory.decodeResource(aVar2.getResources(), 2130838794));
                            }
                            hVar2 = hVar;
                            hVar.geY.post(new Runnable(this) {
                                final /* synthetic */ ap onV;

                                public final void run() {
                                    hVar2.geY.setLayoutParams(new LayoutParams(-2, -2));
                                    hVar2.gfd.setLayoutParams(new LayoutParams(hVar2.geY.getWidth(), hVar2.geY.getHeight()));
                                }
                            });
                            break;
                        }
                    }
                    Bitmap lW = j.lW(str3);
                    if (lW != null) {
                        int i2;
                        indexOf = lW.getWidth();
                        int height = lW.getHeight();
                        float density = com.tencent.mm.bd.a.getDensity(aVar2.nDR.nEl);
                        float f = 150.0f * density;
                        float f2 = 150.0f * density;
                        if (((float) indexOf) >= f || ((float) height) >= f2) {
                            if (height > indexOf) {
                                f = f2 / ((float) height);
                            } else {
                                f /= (float) indexOf;
                            }
                            indexOf = (int) (((float) indexOf) * f);
                            i2 = (int) (f * ((float) height));
                        } else {
                            i2 = height;
                        }
                        if (((float) indexOf) < 75.0f * density) {
                            v.d("MicroMsg.ChattingItemAppMsgFromImg", "pic to small width is %d ", Integer.valueOf(indexOf));
                            indexOf = (int) (75.0f * density);
                        }
                        if (((float) i2) < 75.0f * density) {
                            v.d("MicroMsg.ChattingItemAppMsgFromImg", "pic to small height is %d ", Integer.valueOf(i2));
                            i2 = (int) (75.0f * density);
                        }
                        hVar.geY.setImageBitmap(d.b(Bitmap.createScaledBitmap(j.lW(str3), indexOf, i2, true), 2130837919));
                    } else if (this.lVu) {
                        hVar.geY.setImageResource(2131165374);
                    } else {
                        hVar.geY.setImageBitmap(BitmapFactory.decodeResource(aVar2.getResources(), 2130838794));
                    }
                    hVar2 = hVar;
                    hVar.geY.post(new Runnable(this) {
                        final /* synthetic */ ap onV;

                        public final void run() {
                            hVar2.geY.setLayoutParams(new LayoutParams(-2, -2));
                            hVar2.gfd.setLayoutParams(new LayoutParams(hVar2.geY.getWidth(), hVar2.geY.getHeight()));
                        }
                    });
                    break;
                    break;
            }
            if (aVar2.nQK) {
                hVar.okt.setVisibility(8);
            } else if (g.h(bA)) {
                hVar.okt.setVisibility(0);
                hVar.oks.setVisibility(8);
                ad.c(aVar2, hVar.okt, dl.a(aVar3, atVar));
            } else {
                hVar.okt.setVisibility(8);
            }
        }
        hVar.onC.setTag(new dl(atVar, aVar2.nQK, i, null, 0, (byte) 0));
        hVar.onC.setOnClickListener(aVar2.onh.oqh);
        if (this.lVu) {
            hVar.onC.setOnLongClickListener(aVar2.onh.oqj);
        }
    }

    public final boolean a(ContextMenu contextMenu, View view, at atVar) {
        int i = ((dl) view.getTag()).position;
        int GC = l.GC(this.onG.cf(atVar.field_content, atVar.field_isSend));
        com.tencent.mm.q.a.a dV = com.tencent.mm.q.a.a.dV(this.onG.cf(atVar.field_content, atVar.field_isSend));
        if ((dV.cob <= 0 || (dV.cob > 0 && GC >= 100)) && g.i(g.aC(dV.appId, false))) {
            contextMenu.add(i, MMGIFException.D_GIF_ERR_NOT_READABLE, 0, this.onG.getString(2131234555));
        }
        if (c.EH("favorite")) {
            contextMenu.add(i, 116, 0, this.onG.getString(2131234180));
        }
        com.tencent.mm.sdk.c.b cpVar = new cp();
        cpVar.bay.bao = atVar.field_msgId;
        com.tencent.mm.sdk.c.a.nhr.z(cpVar);
        boolean l = g.l(this.onG.nDR.nEl, 2);
        if (cpVar.baz.aZW || l) {
            contextMenu.add(i, FileUtils.S_IWUSR, 0, view.getContext().getString(2131231834));
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
                    com.tencent.mm.pluginsdk.model.app.b Gu = am.Wf().Gu(dV.aXa);
                    if (Gu != null) {
                        str = Gu.field_fileFullPath;
                    }
                }
                Intent intent = new Intent(aVar.nDR.nEl, MsgRetransmitUI.class);
                intent.putExtra("Retr_File_Name", str);
                intent.putExtra("Retr_Msg_content", aVar.cf(atVar.field_content, atVar.field_isSend));
                intent.putExtra("Retr_Msg_Type", 16);
                intent.putExtra("Retr_Msg_Id", atVar.field_msgId);
                aVar.startActivity(intent);
                break;
        }
        return false;
    }

    public final boolean a(View view, a aVar, at atVar) {
        ak.yW();
        if (com.tencent.mm.model.c.isSDCardAvailable()) {
            com.tencent.mm.q.a.a aVar2 = null;
            String cf = aVar.cf(atVar.field_content, atVar.field_isSend);
            if (cf != null) {
                aVar2 = com.tencent.mm.q.a.a.dV(cf);
            }
            if (aVar2 == null) {
                v.e("MicroMsg.ChattingItemAppMsgFromImg", "content is null");
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
            f aC = g.aC(aVar2.appId, true);
            if (aC != null && aC.bnk()) {
                ad.a(aVar, aVar2, ad.c(aVar, atVar), aC, atVar.field_msgSvrId);
            }
            if (aVar2.aXa != null && aVar2.aXa.length() > 0) {
                com.tencent.mm.pluginsdk.model.app.b Gu = am.Wf().Gu(aVar2.aXa);
                if (Gu != null && Gu.bnj()) {
                    cf = Gu.field_fileFullPath;
                    Intent intent;
                    if (e.aR(cf)) {
                        long j = (long) ((int) atVar.field_msgId);
                        long j2 = atVar.field_msgSvrId;
                        String str = atVar.field_talker;
                        if (cf == null || cf.equals(SQLiteDatabase.KeyEmpty) || !e.aR(cf)) {
                            v.d("MicroMsg.ChattingItemAppMsgFromImg", "showImg : imgPath is null");
                        } else {
                            intent = new Intent(this.onG.nDR.nEl, ImageGalleryUI.class);
                            intent.putExtra("img_gallery_msg_id", j);
                            intent.putExtra("img_gallery_talker", str);
                            intent.putExtra("img_gallery_left", iArr[0]);
                            intent.putExtra("img_gallery_top", iArr[1]);
                            intent.putExtra("img_gallery_width", i);
                            intent.putExtra("img_gallery_height", height);
                            this.onG.startActivity(intent);
                        }
                    } else {
                        v.i("MicroMsg.ChattingItemAppMsgFromImg", "Img not exist, bigImgPath: %s, msgId: %d, msgSvrId: %d", cf, Long.valueOf(atVar.field_msgId), Long.valueOf(atVar.field_msgSvrId));
                        intent = new Intent(aVar.nDR.nEl, ResourcesExceedUI.class);
                        intent.putExtra("clean_view_type", 1);
                        aVar.startActivity(intent);
                        return true;
                    }
                } else if (atVar.field_isSend == 0) {
                    long j3 = atVar.field_msgId;
                    Intent intent2 = new Intent(this.onG.nDR.nEl, AppAttachDownloadUI.class);
                    intent2.putExtra("app_msg_id", j3);
                    this.onG.startActivity(intent2);
                }
            } else if (aVar2.url != null && aVar2.url.length() > 0) {
                String s = p.s(aVar2.url, "message");
                PackageInfo av = ad.av(aVar.nDR.nEl, aVar2.appId);
                a(aVar, s, s, av == null ? null : av.versionName, av == null ? 0 : av.versionCode, aVar2.appId, false, atVar.field_msgId, atVar.field_msgSvrId, atVar);
            }
            return true;
        }
        s.ey(aVar.nDR.nEl);
        return true;
    }
}
