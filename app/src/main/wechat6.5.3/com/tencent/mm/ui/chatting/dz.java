package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.ae.d;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.n;
import com.tencent.mm.as.k;
import com.tencent.mm.as.o;
import com.tencent.mm.as.p;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.i;
import com.tencent.mm.model.l;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.q.a.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.at.b;
import com.tencent.mm.storage.u;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.wework.api.IWWAPI;
import com.tencent.wework.api.WWAPIFactory;
import com.tencent.wework.api.model.BaseMessage;
import com.tencent.wework.api.model.WWMediaConversation;
import com.tencent.wework.api.model.WWMediaFile;
import com.tencent.wework.api.model.WWMediaImage;
import com.tencent.wework.api.model.WWMediaLink;
import com.tencent.wework.api.model.WWMediaLocation;
import com.tencent.wework.api.model.WWMediaMergedConvs;
import com.tencent.wework.api.model.WWMediaMessage;
import com.tencent.wework.api.model.WWMediaMessage.WWMediaObject;
import com.tencent.wework.api.model.WWMediaText;
import com.tencent.wework.api.model.WWMediaVideo;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.List;

public final class dz {

    static class AnonymousClass2 implements OnClickListener {
        final /* synthetic */ u ihT;
        final /* synthetic */ List oze;
        final /* synthetic */ boolean ozf;
        final /* synthetic */ Context val$context;

        AnonymousClass2(Context context, u uVar, List list, boolean z) {
            this.val$context = context;
            this.ihT = uVar;
            this.oze = list;
            this.ozf = z;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            dz.a(this.val$context, this.ihT, this.oze, this.ozf);
        }
    }

    static void a(Context context, u uVar, List<at> list, boolean z) {
        BaseMessage a;
        IWWAPI gC = WWAPIFactory.gC(context);
        if (list.size() != 1 || ((at) list.get(0)).field_type == 48) {
            a = a(uVar, list, z);
        } else {
            a = c((at) list.get(0), z);
        }
        gC.a(a);
    }

    private static WWMediaObject c(at atVar, boolean z) {
        int i = atVar.field_type;
        if (i == 1) {
            return new WWMediaText(x.m(atVar.field_content, atVar.field_isSend, z));
        }
        String l;
        WWMediaObject wWMediaImage;
        if (i == 3) {
            d ai;
            if (atVar.field_msgId > 0) {
                ai = n.GH().ai(atVar.field_msgId);
            } else {
                ai = null;
            }
            if ((ai == null || ai.cLu <= 0) && atVar.field_msgSvrId > 0) {
                ai = n.GH().ah(atVar.field_msgSvrId);
            }
            if (ai == null) {
                return null;
            }
            l = n.GH().l(e.c(ai), SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty);
            wWMediaImage = new WWMediaImage();
            wWMediaImage.filePath = l;
            v.i("MicroMsg.SendToWeWorkHelper", "send img2, path:%s", wWMediaImage.filePath);
            return wWMediaImage;
        } else if (i == 43) {
            wWMediaImage = new WWMediaVideo();
            com.tencent.mm.as.n lp = p.lp(atVar.field_imgPath);
            k.KV();
            wWMediaImage.filePath = o.lc(lp.getFileName());
            v.i("MicroMsg.SendToWeWorkHelper", "send video2, path:%s", wWMediaImage.filePath);
            return wWMediaImage;
        } else if (i == 48) {
            wWMediaImage = new WWMediaLocation();
            l = x.m(atVar.field_content, atVar.field_isSend, z);
            ak.yW();
            b MV = c.wJ().MV(l);
            wWMediaImage.title = MV.gUr;
            wWMediaImage.cJf = MV.label;
            wWMediaImage.longitude = MV.gRL;
            wWMediaImage.latitude = MV.gRK;
            wWMediaImage.pKa = (double) MV.bhu;
            return wWMediaImage;
        } else if (i == 49 || i == 268435505) {
            return d(atVar, z);
        } else {
            v.e("MicroMsg.SendToWeWorkHelper", "unsupport msg type: %d", Integer.valueOf(i));
            return null;
        }
    }

    private static WWMediaObject a(u uVar, List<at> list, boolean z) {
        WWMediaObject wWMediaMergedConvs = new WWMediaMergedConvs();
        String str = uVar.field_username;
        Context context = aa.getContext();
        if (z) {
            com.tencent.mm.storage.p wO = ak.yW().wO();
            String[] split = i.b(i.ej(str), 3).split(context.getString(2131231758));
            if (!wO.er(str).equals(l.er(str)) || split.length <= 2) {
                str = context.getString(2131232710, new Object[]{l.er(str)});
            } else {
                str = i.el(str) == 3 ? context.getString(2131232716, new Object[]{split[0], split[1], split[2].substring(0, split[2].lastIndexOf("..."))}) : aa.getContext().getString(2131232714, new Object[]{split[0], split[1], split[2].substring(0, split[2].lastIndexOf("...")), Integer.valueOf(i.el(str))});
            }
        } else {
            str = com.tencent.mm.model.k.xH().equals(l.eq(str)) ? context.getString(2131232710, new Object[]{com.tencent.mm.model.k.xH()}) : context.getString(2131232709, new Object[]{com.tencent.mm.model.k.xH(), l.eq(str)});
        }
        wWMediaMergedConvs.title = str;
        for (at atVar : list) {
            WWMediaConversation wWMediaConversation = new WWMediaConversation();
            String xF = atVar.field_isSend == 1 ? com.tencent.mm.model.k.xF() : !z ? atVar.field_talker : aw.fL(atVar.field_content);
            wWMediaConversation.name = l.eq(xF);
            try {
                Bitmap a = com.tencent.mm.u.b.a(xF, false, -1);
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                a.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
                wWMediaConversation.pJY = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
            } catch (Exception e) {
            }
            wWMediaConversation.date = atVar.field_createTime;
            wWMediaConversation.pJZ = c(atVar, z);
            if (wWMediaConversation.checkArgs()) {
                wWMediaMergedConvs.pKb.add(wWMediaConversation);
            }
        }
        return wWMediaMergedConvs;
    }

    private static WWMediaObject d(at atVar, boolean z) {
        a B;
        String str = atVar.field_content;
        if (z) {
            int indexOf = atVar.field_content.indexOf(58);
            if (indexOf != -1) {
                str = atVar.field_content.substring(indexOf + 1);
            }
        }
        if (str != null) {
            B = a.B(str, atVar.field_reserved);
        } else {
            B = null;
        }
        if (B == null) {
            return null;
        }
        switch (B.type) {
            case 2:
                if (B.aXa == null || B.aXa.length() <= 0) {
                    return null;
                }
                com.tencent.mm.pluginsdk.model.app.b Gu = am.Wf().Gu(B.aXa);
                if (Gu == null || !Gu.bnj()) {
                    return null;
                }
                str = Gu.field_fileFullPath;
                if (com.tencent.mm.a.e.aR(str)) {
                    WWMediaObject wWMediaImage = new WWMediaImage();
                    wWMediaImage.filePath = str;
                    v.i("MicroMsg.SendToWeWorkHelper", "send img2, path:%s", wWMediaImage.filePath);
                    return wWMediaImage;
                }
                v.i("MicroMsg.SendToWeWorkHelper", "Img not exist, bigImgPath: %s, msgId: %d, msgSvrId: %d", str, Long.valueOf(atVar.field_msgId), Long.valueOf(atVar.field_msgSvrId));
                return null;
            case 5:
                OutputStream byteArrayOutputStream;
                WWMediaMessage wWMediaLink = new WWMediaLink();
                wWMediaLink.webpageUrl = B.url;
                wWMediaLink.title = B.title;
                wWMediaLink.description = B.description;
                Bitmap a = n.GH().a(atVar.field_imgPath, com.tencent.mm.bd.a.getDensity(null), false);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    a.compress(CompressFormat.JPEG, 85, byteArrayOutputStream);
                    wWMediaLink.thumbData = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                } catch (Exception e) {
                }
                try {
                    a = n.GH().a(atVar.field_imgPath, com.tencent.mm.bd.a.getDensity(null), false);
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    a.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
                    wWMediaLink.thumbData = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                } catch (Exception e2) {
                }
                return wWMediaLink;
            case 6:
                com.tencent.mm.pluginsdk.model.app.b GD = com.tencent.mm.pluginsdk.model.app.l.GD(B.aXa);
                if (GD == null) {
                    GD = am.Wf().dy(atVar.field_msgId);
                }
                WWMediaObject wWMediaFile = new WWMediaFile();
                wWMediaFile.aST = B.title;
                wWMediaFile.filePath = GD.field_fileFullPath;
                return wWMediaFile;
            default:
                return null;
        }
    }
}
