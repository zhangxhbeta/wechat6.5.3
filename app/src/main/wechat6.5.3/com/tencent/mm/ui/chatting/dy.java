package com.tencent.mm.ui.chatting;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.a.e;
import com.tencent.mm.ae.n;
import com.tencent.mm.e.b.bx;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.modelbiz.u;
import com.tencent.mm.modelmulti.i;
import com.tencent.mm.modelvoice.f;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ag;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.transmit.MsgRetransmitUI.a;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.LinkedList;
import java.util.List;

public final class dy {

    static class AnonymousClass4 implements d {
        final /* synthetic */ at crs;
        final /* synthetic */ Context val$context;

        AnonymousClass4(at atVar, Context context) {
            this.crs = atVar;
            this.val$context = context;
        }

        public final void c(MenuItem menuItem, int i) {
            String str = menuItem.getTitle();
            if (be.kS(this.crs.field_imgPath)) {
                v.e("MicroMsg.LongClickBrandServiceHelper", "Transfer fileName erro: fileName null");
                return;
            }
            p lJ = m.Lz().lJ(this.crs.field_imgPath);
            v.i("MicroMsg.LongClickBrandServiceHelper", "connector click[voice]: to[%s] filePath[%s]", str, q.c(str, this.crs.field_imgPath, lJ == null ? 0 : lJ.djF));
            ak.vy().a(new f(r0, 1), 0);
            g.iuh.h(10424, Integer.valueOf(34), Integer.valueOf(2), str);
            com.tencent.mm.ui.base.g.bf(this.val$context, this.val$context.getString(2131231147));
        }
    }

    static class AnonymousClass7 implements d {
        final /* synthetic */ String ozc;
        final /* synthetic */ Context val$context;

        AnonymousClass7(String str, Context context) {
            this.ozc = str;
            this.val$context = context;
        }

        public final void c(MenuItem menuItem, int i) {
            v.i("MicroMsg.LongClickBrandServiceHelper", "connector click[location]: to[%s] content[%s]", menuItem.getTitle(), this.ozc);
            ak.vy().a(new i(r0, this.ozc, 48), 0);
            g.iuh.h(10424, Integer.valueOf(48), Integer.valueOf(16), r0);
            com.tencent.mm.ui.base.g.bf(this.val$context, this.val$context.getString(2131231147));
        }
    }

    static class AnonymousClass8 implements d {
        final /* synthetic */ String ozd;
        final /* synthetic */ Context val$context;

        AnonymousClass8(String str, Context context) {
            this.ozd = str;
            this.val$context = context;
        }

        public final void c(MenuItem menuItem, int i) {
            v.i("MicroMsg.LongClickBrandServiceHelper", "connector click[location]: to[%s] content[%s]", menuItem.getTitle(), this.ozd);
            ak.vy().a(new i(r0, this.ozd, 42), 0);
            g.iuh.h(10424, Integer.valueOf(42), Integer.valueOf(32), r0);
            com.tencent.mm.ui.base.g.bf(this.val$context, this.val$context.getString(2131231147));
        }
    }

    public static void k(final String str, final Context context) {
        if (context == null) {
            v.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptTextConnector: context is null");
        } else if (be.kS(str)) {
            v.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptTextConnector: content is null");
        } else {
            a(cx(u.Dy().fg(1)), context, new d() {
                public final void c(MenuItem menuItem, int i) {
                    String str = menuItem.getTitle();
                    v.i("MicroMsg.LongClickBrandServiceHelper", "connector click[text]: to[%s] text[%s]", str, str);
                    ak.vy().a(new i(str, str, com.tencent.mm.model.m.fp(str)), 0);
                    g.iuh.h(10424, Integer.valueOf(1), Integer.valueOf(1), str);
                    com.tencent.mm.ui.base.g.bf(context, context.getString(2131231147));
                }
            });
        }
    }

    public static void a(final at atVar, final Context context) {
        if (context == null) {
            v.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: context is null");
        } else if (atVar == null) {
            v.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: msg is null");
        } else {
            ak.yW();
            if (c.isSDCardAvailable()) {
                a(cx(u.Dy().fg(4)), context, new d() {
                    public final void c(MenuItem menuItem, int i) {
                        com.tencent.mm.ae.d ai;
                        com.tencent.mm.ae.d ah;
                        String str = menuItem.getTitle();
                        if (atVar.field_msgId > 0) {
                            ai = n.GH().ai(atVar.field_msgId);
                        } else {
                            ai = null;
                        }
                        if ((ai == null || ai.cLu <= 0) && atVar.field_msgSvrId > 0) {
                            ah = n.GH().ah(atVar.field_msgSvrId);
                        } else {
                            ah = ai;
                        }
                        if (ah == null) {
                            v.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: try get imgInfo fail");
                        } else if (ah.offset < ah.cyu || ah.cyu == 0) {
                            Intent intent = new Intent(context, ImageGalleryUI.class);
                            intent.putExtra("img_gallery_msg_id", atVar.field_msgId);
                            intent.putExtra("img_gallery_msg_svr_id", atVar.field_msgSvrId);
                            intent.putExtra("img_gallery_talker", atVar.field_talker);
                            intent.putExtra("img_gallery_chatroom_name", atVar.field_talker);
                            intent.putExtra("img_gallery_is_restransmit_after_download", true);
                            intent.putExtra("img_gallery_directly_send_name", str);
                            intent.putExtra("start_chatting_ui", false);
                            context.startActivity(intent);
                        } else {
                            int i2;
                            if (atVar.field_isSend == 1) {
                                boolean z;
                                if (ah.Gp()) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                i2 = z;
                            } else if (!ah.Gp()) {
                                i2 = 0;
                            } else if (e.aR(com.tencent.mm.ae.e.a(ah).cLv)) {
                                i2 = 1;
                            } else {
                                i2 = 0;
                            }
                            String xF = k.xF();
                            String l = n.GH().l(com.tencent.mm.ae.e.c(ah), SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty);
                            if (!be.kS(l)) {
                                v.i("MicroMsg.LongClickBrandServiceHelper", "connector click[img]: to[%s] fileName[%s]", str, l);
                                ak.vy().a(new com.tencent.mm.ae.k(4, xF, str, l, i2, null, 0, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, true, 2130837922), 0);
                                bl.zQ().b(bl.cvm, null);
                            }
                            g.iuh.h(10424, Integer.valueOf(3), Integer.valueOf(4), str);
                            com.tencent.mm.ui.base.g.bf(context, context.getString(2131231147));
                        }
                    }
                });
                return;
            }
            s.ey(context);
            v.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptImgConnector: sd card is not available");
        }
    }

    public static void b(final at atVar, final Context context) {
        if (context == null) {
            v.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVideoConnector: context is null");
        } else if (atVar == null) {
            v.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVideoConnector: msg is null");
        } else {
            ak.yW();
            if (c.isSDCardAvailable()) {
                a(cx(u.Dy().fg(8)), context, new d() {
                    public final void c(MenuItem menuItem, int i) {
                        String str = menuItem.getTitle();
                        com.tencent.mm.as.n lp = com.tencent.mm.as.p.lp(atVar.field_imgPath);
                        v.i("MicroMsg.LongClickBrandServiceHelper", "connector click[video]: to[%s] imgPath[%s]", str, atVar.field_imgPath);
                        final a aVar = new a();
                        Context context = context;
                        context.getResources().getString(2131231164);
                        Dialog a = com.tencent.mm.ui.base.g.a(context, context.getResources().getString(2131231151), true, new OnCancelListener(this) {
                            final /* synthetic */ AnonymousClass6 ozb;

                            public final void onCancel(DialogInterface dialogInterface) {
                                aVar.oXh = true;
                            }
                        });
                        aVar.context = context;
                        aVar.aST = atVar.field_imgPath;
                        aVar.dxy = a;
                        aVar.userName = str;
                        aVar.oWJ = lp.dhO;
                        aVar.dhK = lp.dhK;
                        aVar.execute(new Object[0]);
                        bl.zQ().b(bl.cvn, null);
                        com.tencent.mm.ui.base.g.bf(context, context.getString(2131231147));
                    }
                });
                return;
            }
            s.ey(context);
            v.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptVideoConnector: sd card is not available");
        }
    }

    public static void c(final at atVar, final Context context) {
        if (context == null) {
            v.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptEmojiConnector: context is null");
        } else if (atVar == null) {
            v.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptEmojiConnector: msg is null");
        } else {
            ak.yW();
            if (c.isSDCardAvailable()) {
                a(cx(u.Dy().fg(64)), context, new d() {
                    public final void c(MenuItem menuItem, int i) {
                        String str = menuItem.getTitle();
                        String str2 = ag.Mv(atVar.field_content).aZy;
                        if (str2 == null || str2.endsWith("-1")) {
                            str2 = atVar.field_imgPath;
                        }
                        if (str2 == null) {
                            v.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptEmojiConnector: filePath is null");
                            return;
                        }
                        v.i("MicroMsg.LongClickBrandServiceHelper", "connector click[emoji]: to[%s] filePath[%s]", str, str2);
                        if (j.a.bmr().l(context, str, str2)) {
                            g.iuh.h(10424, Integer.valueOf(47), Integer.valueOf(64), str);
                            com.tencent.mm.ui.base.g.bf(context, SQLiteDatabase.KeyEmpty);
                        }
                        g.iuh.h(10424, Integer.valueOf(47), Integer.valueOf(64), str);
                        com.tencent.mm.ui.base.g.bf(context, context.getString(2131231147));
                    }
                });
                return;
            }
            s.ey(context);
            v.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptEmojiConnector: sd card is not available");
        }
    }

    public static void a(at atVar, String str, Context context) {
        a(atVar, str, context, 512);
    }

    public static void b(at atVar, String str, Context context) {
        a(atVar, str, context, FileUtils.S_IRUSR);
    }

    public static void c(at atVar, String str, Context context) {
        a(atVar, str, context, FileUtils.S_IWUSR);
    }

    private static void a(final at atVar, final String str, final Context context, final int i) {
        if (context == null) {
            v.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptMusicConnector: context is null");
        } else if (atVar == null) {
            v.w("MicroMsg.LongClickBrandServiceHelper", "showAcceptMusicConnector: msg is null");
        } else {
            List list = null;
            switch (i) {
                case FileUtils.S_IWUSR /*128*/:
                    list = cx(com.tencent.mm.modelbiz.e.Dm());
                    break;
                case FileUtils.S_IRUSR /*256*/:
                    list = cx(u.Dy().fg(FileUtils.S_IRUSR));
                    break;
                case 512:
                    list = cx(u.Dy().fg(512));
                    break;
            }
            a(list, context, new d() {
                public final void c(MenuItem menuItem, int i) {
                    String str = menuItem.getTitle();
                    bx bxVar = atVar;
                    com.tencent.mm.q.a.a dV = com.tencent.mm.q.a.a.dV(be.KK(str));
                    if (dV == null) {
                        v.w("MicroMsg.LongClickBrandServiceHelper", "send: parse app msg content return null");
                    } else {
                        byte[] bArr = null;
                        if (!(bxVar.field_imgPath == null || bxVar.field_imgPath.equals(SQLiteDatabase.KeyEmpty))) {
                            String w = n.GH().w(bxVar.field_imgPath, true);
                            try {
                                bArr = e.c(w, 0, e.aQ(w));
                            } catch (Exception e) {
                                v.e("MicroMsg.LongClickBrandServiceHelper", "send appmsg to %s, error:%s", str, e.getLocalizedMessage());
                            }
                        }
                        b bVar = new b();
                        if (dV.aXa != null) {
                            long j = be.getLong(dV.aXa, -1);
                            if (j != -1) {
                                am.Wf().b(j, (com.tencent.mm.sdk.h.c) bVar);
                                if (bVar.nmb != j) {
                                    bVar = am.Wf().Gu(dV.aXa);
                                    if (bVar == null || !bVar.field_mediaSvrId.equals(dV.aXa)) {
                                        bVar = null;
                                    }
                                }
                            } else {
                                bVar = am.Wf().Gu(dV.aXa);
                                if (bVar == null || !bVar.field_mediaSvrId.equals(dV.aXa)) {
                                    bVar = null;
                                }
                            }
                        }
                        String str2 = SQLiteDatabase.KeyEmpty;
                        if (!(bVar == null || bVar.field_fileFullPath == null || bVar.field_fileFullPath.equals(SQLiteDatabase.KeyEmpty))) {
                            StringBuilder stringBuilder = new StringBuilder();
                            ak.yW();
                            str2 = stringBuilder.append(c.xd()).append("da_").append(be.Ni()).toString();
                            com.tencent.mm.sdk.platformtools.j.n(bVar.field_fileFullPath, str2, false);
                        }
                        com.tencent.mm.q.a.a a = com.tencent.mm.q.a.a.a(dV);
                        a.coe = 3;
                        l.a(a, dV.appId, dV.appName, str, str2, bArr, null);
                    }
                    switch (i) {
                        case FileUtils.S_IWUSR /*128*/:
                            g.iuh.h(10424, Integer.valueOf(49), Integer.valueOf(FileUtils.S_IWUSR), str);
                            break;
                        case FileUtils.S_IRUSR /*256*/:
                            g.iuh.h(10424, Integer.valueOf(49), Integer.valueOf(FileUtils.S_IRUSR), str);
                            break;
                        case 512:
                            g.iuh.h(10424, Integer.valueOf(49), Integer.valueOf(512), str);
                            break;
                    }
                    com.tencent.mm.ui.base.g.bf(context, context.getString(2131231147));
                }
            });
        }
    }

    static List<String> cx(List<String> list) {
        List<String> linkedList = new LinkedList();
        for (String str : list) {
            if (!com.tencent.mm.modelbiz.e.hz(str)) {
                linkedList.add(str);
            }
        }
        v.d("MicroMsg.LongClickBrandServiceHelper", "get selected accept list, size %d", Integer.valueOf(linkedList.size()));
        return linkedList;
    }

    static void a(final List<String> list, final Context context, d dVar) {
        if (list == null || list.isEmpty()) {
            v.w("MicroMsg.LongClickBrandServiceHelper", "tryShowConnectorDialog: careList is null or empty");
            return;
        }
        com.tencent.mm.ui.tools.l lVar = new com.tencent.mm.ui.tools.l(context);
        lVar.oTB = new com.tencent.mm.ui.base.n.a() {
            public final void a(ImageView imageView, MenuItem menuItem) {
                com.tencent.mm.pluginsdk.ui.a.b.m(imageView, menuItem.getTitle());
            }
        };
        lVar.oTC = new com.tencent.mm.ui.base.n.b() {
            public final void a(TextView textView, MenuItem menuItem) {
                if (textView != null) {
                    ak.yW();
                    com.tencent.mm.i.a LX = c.wH().LX(menuItem.getTitle());
                    if (LX == null || ((int) LX.chr) <= 0) {
                        textView.setText(menuItem.getTitle());
                    } else {
                        textView.setText(com.tencent.mm.pluginsdk.ui.d.e.a(context, LX.tT(), textView.getTextSize()));
                    }
                }
            }
        };
        lVar.jXn = new com.tencent.mm.ui.base.n.c() {
            public final void a(com.tencent.mm.ui.base.l lVar) {
                for (CharSequence add : list) {
                    lVar.add(add);
                }
            }
        };
        lVar.jXo = dVar;
        lVar.aXZ();
    }
}
