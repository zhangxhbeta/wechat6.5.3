package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.as.k;
import com.tencent.mm.e.a.bp;
import com.tencent.mm.e.a.kw;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.a.c;
import com.tencent.mm.modelbiz.e;
import com.tencent.mm.modelbiz.u;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.protocal.b.a.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.bizchat.BizChatSelectConversationUI;
import com.tencent.mm.ui.tools.l;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.LinkedList;
import java.util.List;

public final class z {
    private static p omE = null;
    private static a omO;

    private static class a {
        bp blL;
        String bmm;
        boolean nQK;
        List<at> omM;
        d omN;
        boolean omV;

        private a() {
        }
    }

    private static class b implements com.tencent.mm.sdk.platformtools.ap.a {
        private String cBj;
        private Context context;
        private long ezh;
        private boolean lKa;
        private com.tencent.mm.ui.chatting.ChattingUI.a omW;
        private a omX;

        public b(com.tencent.mm.ui.chatting.ChattingUI.a aVar, Context context, String str, long j, a aVar2) {
            this.omW = aVar;
            this.context = context;
            this.cBj = str;
            this.ezh = j;
            this.omX = aVar2;
            this.lKa = e.hC(str);
        }

        public final boolean AZ() {
            if (this.lKa) {
                c Z = u.DA().Z(this.ezh);
                synchronized (com.tencent.mm.modelbiz.a.e.cDR) {
                    String zr = com.tencent.mm.modelbiz.a.e.zr();
                    com.tencent.mm.modelbiz.a.e.e(Z);
                    if (this.omX.omV) {
                        bEj();
                    } else {
                        bEk();
                    }
                    com.tencent.mm.modelbiz.a.e.hZ(zr);
                }
            } else if (this.omX.omV) {
                bEj();
            } else {
                bEk();
            }
            return true;
        }

        private void bEj() {
            for (at atVar : this.omX.omM) {
                Context context = this.context;
                boolean z = this.omX.nQK;
                String str = this.cBj;
                if (atVar.bwm()) {
                    x.a(context, str, atVar, z);
                } else if (atVar.bwj()) {
                    x.b(context, str, atVar);
                } else if (atVar.bwn() && !this.lKa) {
                    x.c(context, str, atVar);
                } else if (atVar.bwl()) {
                    x.c(context, str, atVar, z);
                } else if ((atVar.bwp() || atVar.bwq()) && !this.lKa) {
                    if (!x.X(atVar)) {
                        x.a(context, str, atVar);
                    }
                } else if (atVar.bvY() && !((this.lKa && !x.ac(atVar)) || x.ad(atVar) || atVar.field_type == 318767153 || x.Z(atVar))) {
                    x.b(context, str, atVar, z);
                }
            }
        }

        private void bEk() {
            z.bg(this.context, this.cBj);
            com.tencent.mm.sdk.c.b kwVar = new kw();
            kwVar.bmf.type = 5;
            kwVar.bmf.bml = this.omX.omM;
            kwVar.bmf.toUser = this.cBj;
            kwVar.bmf.bmm = this.omX.bmm;
            kwVar.bmf.context = this.context;
            kwVar.bmf.blL = this.omX.blL;
            kwVar.bmf.bmo = this.omX.omN;
            com.tencent.mm.sdk.c.a.nhr.z(kwVar);
        }

        public final boolean Ba() {
            if (z.omE != null) {
                z.omE.dismiss();
            }
            com.tencent.mm.ui.snackbar.a.b(this.context, this.omW.mView.findViewById(2131758195), this.context.getString(2131232839));
            return true;
        }
    }

    public static void a(com.tencent.mm.ui.chatting.ChattingUI.a aVar, List<at> list, boolean z, ct ctVar, com.tencent.mm.storage.u uVar) {
        if (aVar == null) {
            v.w("MicroMsg.ChattingEditModeSendToBrand", "do send to brand fail, fragment is null");
        } else if (list == null || list.isEmpty()) {
            v.w("MicroMsg.ChattingEditModeSendToBrand", "do send to brand fail, select item empty");
        } else {
            a aVar2 = new a();
            omO = aVar2;
            aVar2.omM = new LinkedList(list);
            omO.nQK = z;
            omO.bmm = uVar.field_username;
            omO.omV = true;
            final Context context = aVar.nDR.nEl;
            if (context != null) {
                l lVar = new l(context);
                lVar.oTB = new com.tencent.mm.ui.base.n.a() {
                    public final void a(ImageView imageView, MenuItem menuItem) {
                        com.tencent.mm.pluginsdk.ui.a.b.b(imageView, menuItem.getTitle(), false);
                    }
                };
                lVar.oTC = new com.tencent.mm.ui.base.n.b() {
                    public final void a(TextView textView, MenuItem menuItem) {
                        if (textView != null) {
                            ak.yW();
                            com.tencent.mm.i.a LX = com.tencent.mm.model.c.wH().LX(menuItem.getTitle());
                            if (LX == null || ((int) LX.chr) <= 0) {
                                textView.setText(menuItem.getTitle());
                            } else {
                                textView.setText(com.tencent.mm.pluginsdk.ui.d.e.a(context, LX.tT()));
                            }
                        }
                    }
                };
                lVar.jXn = new n.c() {
                    public final void a(com.tencent.mm.ui.base.l lVar) {
                        lVar.S(1193046, 2131233831, 2130837927);
                        for (CharSequence add : x.bEe()) {
                            lVar.add(add);
                        }
                    }
                };
                final List<at> list2 = list;
                final com.tencent.mm.ui.chatting.ChattingUI.a aVar3 = aVar;
                final com.tencent.mm.storage.u uVar2 = uVar;
                final ct ctVar2 = ctVar;
                lVar.jXo = new n.d() {
                    public final void c(final MenuItem menuItem, int i) {
                        if (menuItem.getItemId() == 1193046) {
                            if (x.cs(list2)) {
                                g.a(context, context.getString(2131232227), SQLiteDatabase.KeyEmpty, context.getString(2131230747), new OnClickListener(this) {
                                    final /* synthetic */ AnonymousClass4 omS;

                                    {
                                        this.omS = r1;
                                    }

                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                });
                            } else if (x.ct(list2)) {
                                g.a(context, context.getString(2131232228), SQLiteDatabase.KeyEmpty, context.getString(2131230747), new OnClickListener(this) {
                                    final /* synthetic */ AnonymousClass4 omS;

                                    {
                                        this.omS = r1;
                                    }

                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                });
                            } else if (x.cr(list2)) {
                                g.a(context, context.getString(2131232229), SQLiteDatabase.KeyEmpty, new OnClickListener(this) {
                                    final /* synthetic */ AnonymousClass4 omS;

                                    {
                                        this.omS = r1;
                                    }

                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                }, null);
                            } else if (aa.a(aVar3, list2, uVar2) && ctVar2 != null) {
                                ctVar2.bEK();
                            }
                        } else if (x.cs(list2)) {
                            g.a(context, context.getString(2131232227), SQLiteDatabase.KeyEmpty, context.getString(2131230747), new OnClickListener(this) {
                                final /* synthetic */ AnonymousClass4 omS;

                                {
                                    this.omS = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                        } else if (x.ct(list2)) {
                            g.a(context, context.getString(2131232228), SQLiteDatabase.KeyEmpty, context.getString(2131230747), new OnClickListener(this) {
                                final /* synthetic */ AnonymousClass4 omS;

                                {
                                    this.omS = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                        } else {
                            boolean z;
                            List<at> list = list2;
                            if (list != null) {
                                for (at atVar : list) {
                                    if (atVar.field_isSend == 1) {
                                        break;
                                    } else if (atVar.bwj()) {
                                        com.tencent.mm.ae.d ai;
                                        com.tencent.mm.ae.d ah;
                                        if (atVar.field_msgId > 0) {
                                            ai = com.tencent.mm.ae.n.GH().ai(atVar.field_msgId);
                                        } else {
                                            ai = null;
                                        }
                                        if ((ai == null || ai.cLu <= 0) && atVar.field_msgSvrId > 0) {
                                            ah = com.tencent.mm.ae.n.GH().ah(atVar.field_msgSvrId);
                                        } else {
                                            ah = ai;
                                        }
                                        if (ah != null && (ah.offset < ah.cyu || ah.cyu == 0)) {
                                            z = true;
                                            break;
                                        }
                                    } else if (atVar.bwn()) {
                                        r0 = k.KV().kZ(atVar.field_imgPath);
                                        if (!(r0 == null || r0.status == 199 || r0.status == 199)) {
                                            z = true;
                                            break;
                                        }
                                    } else if (atVar.bwo()) {
                                        r0 = com.tencent.mm.as.p.lp(atVar.field_imgPath);
                                        if (!(r0 == null || r0.status == 199 || r0.status == 199)) {
                                            z = true;
                                            break;
                                        }
                                    } else if (atVar.bwq()) {
                                        z = !x.Y(atVar);
                                    }
                                }
                            } else {
                                v.w("MicroMsg.ChattingEditModeLogic", "check contain undownload image or video error, select item empty");
                            }
                            z = false;
                            if (z || x.cr(list2)) {
                                g.a(context, context.getString(2131232229), SQLiteDatabase.KeyEmpty, new OnClickListener(this) {
                                    final /* synthetic */ AnonymousClass4 omS;

                                    {
                                        this.omS = r1;
                                    }

                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                }, null);
                                return;
                            }
                            final String str = (String) menuItem.getTitle();
                            if (e.hz(str)) {
                                if (list2.size() <= 1) {
                                    z.omO.omV = true;
                                    z.a(str, aVar3, list2);
                                    return;
                                }
                                new l(context).b(menuItem.getActionView(), new OnCreateContextMenuListener(this) {
                                    final /* synthetic */ AnonymousClass4 omS;

                                    {
                                        this.omS = r1;
                                    }

                                    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                                        contextMenu.add(0, 0, 0, 2131233905);
                                        contextMenu.add(0, 1, 1, 2131233906);
                                    }
                                }, new n.d(this) {
                                    final /* synthetic */ AnonymousClass4 omS;

                                    public final void c(MenuItem menuItem, int i) {
                                        if (menuItem.getItemId() == 0) {
                                            z.omO.omV = true;
                                        } else {
                                            z.omO.omV = false;
                                        }
                                        z.a(str, aVar3, list2);
                                    }
                                });
                            } else if (x.co(list2)) {
                                g.a(context, context.getString(2131233301), SQLiteDatabase.KeyEmpty, new OnClickListener(this) {
                                    final /* synthetic */ AnonymousClass4 omS;

                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        boolean z;
                                        List<at> list = list2;
                                        if (list != null && !list.isEmpty()) {
                                            for (at atVar : list) {
                                                if (!atVar.bwb() && !x.X(atVar) && !atVar.bwk() && !x.Z(atVar) && !x.aa(atVar) && atVar.field_type != -1879048186 && !x.ae(atVar) && !x.ab(atVar) && !x.ad(atVar)) {
                                                    z = false;
                                                    break;
                                                }
                                            }
                                        } else {
                                            v.w("MicroMsg.ChattingEditModeLogic", "check contain only invalid send to brand service error, select item empty");
                                        }
                                        z = true;
                                        if (z) {
                                            v.w("MicroMsg.ChattingEditModeSendToBrand", "only contain invalid msg, exit long click mode");
                                            if (ctVar2 != null) {
                                                ctVar2.bEK();
                                                return;
                                            }
                                            return;
                                        }
                                        Context context = context;
                                        context.getString(2131231164);
                                        z.omE = g.a(context, context.getString(2131234919), false, null);
                                        ct.orh.c(new b(aVar3, context, menuItem.getTitle(), -1, z.omO));
                                        if (ctVar2 != null) {
                                            ctVar2.bEK();
                                        }
                                    }
                                }, null);
                            } else {
                                Context context = context;
                                context.getString(2131231164);
                                z.omE = g.a(context, context.getString(2131234919), false, null);
                                ct.orh.c(new b(aVar3, context, menuItem.getTitle(), -1, z.omO));
                                if (ctVar2 != null) {
                                    ctVar2.bEK();
                                }
                            }
                        }
                    }
                };
                lVar.aXZ();
            }
        }
    }

    public static void a(final String str, final com.tencent.mm.ui.p pVar, List<at> list) {
        Context context = pVar.nDR.nEl;
        if (context != null) {
            BizInfo hw = e.hw(str);
            if (hw != null) {
                String string;
                boolean CB = hw.CB();
                if (omO.omV) {
                    boolean co = x.co(list);
                    if (CB) {
                        Object obj;
                        if (list == null || list.isEmpty()) {
                            v.w("MicroMsg.ChattingEditModeLogic", "check contain invalid send to bizchat msg error, selected item empty");
                            obj = 1;
                        } else {
                            for (at atVar : list) {
                                if (!atVar.bwm() && !atVar.bwb() && !atVar.bwj() && !atVar.bwl() && !x.ac(atVar)) {
                                    int i = 1;
                                    break;
                                }
                            }
                            obj = null;
                        }
                        omO.omM = new LinkedList(list);
                        if (co || r0 != null) {
                            string = context.getString(2131232467);
                            if (string != null) {
                                g.a(context, string, SQLiteDatabase.KeyEmpty, new OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        z.a(str, pVar);
                                    }
                                }, null);
                            } else {
                                a(str, pVar);
                            }
                        }
                    } else if (co) {
                        string = context.getString(2131232468);
                        if (string != null) {
                            a(str, pVar);
                        } else {
                            g.a(context, string, SQLiteDatabase.KeyEmpty, /* anonymous class already generated */, null);
                        }
                    }
                }
                string = null;
                if (string != null) {
                    g.a(context, string, SQLiteDatabase.KeyEmpty, /* anonymous class already generated */, null);
                } else {
                    a(str, pVar);
                }
            }
        }
    }

    public static void a(String str, com.tencent.mm.ui.p pVar) {
        BizInfo hw = e.hw(str);
        if (hw != null) {
            Intent intent;
            if (hw.CB()) {
                intent = new Intent(pVar.nDR.nEl, BizChatSelectConversationUI.class);
                intent.putExtra("enterprise_biz_name", str);
                intent.putExtra("biz_chat_scene", 2);
                intent.putExtra("enterprise_extra_params", omO.omV);
                pVar.startActivityForResult(intent, 225);
            } else if (hw.Cz()) {
                intent = new Intent();
                intent.putExtra("enterprise_biz_name", str);
                intent.putExtra("enterprise_scene", 1);
                com.tencent.mm.ay.c.a((Fragment) pVar, "brandservice", ".ui.EnterpriseBizContactPlainListUI", intent, 225);
            }
        }
    }

    public static kw bg(Context context, String str) {
        com.tencent.mm.sdk.c.b kwVar = new kw();
        kwVar.bmf.type = 6;
        kwVar.bmf.bml = omO.omM;
        kwVar.bmf.toUser = str;
        kwVar.bmf.bmm = omO.bmm;
        kwVar.bmf.context = context;
        com.tencent.mm.sdk.c.a.nhr.z(kwVar);
        omO.blL = kwVar.bmg.blL;
        omO.omN = kwVar.bmg.bmo;
        return kwVar;
    }

    public static void a(com.tencent.mm.ui.chatting.ChattingUI.a aVar, ct ctVar, String str, long j) {
        Context context = aVar.nDR.nEl;
        if (!t.kS(str) && str.length() > 0) {
            context.getString(2131231164);
            omE = g.a(context, context.getString(2131234919), false, null);
            ct.orh.c(new b(aVar, context, str, j, omO));
        }
        if (ctVar != null) {
            ctVar.bEK();
        }
    }
}
