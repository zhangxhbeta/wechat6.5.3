package com.tencent.mm.pluginsdk.ui.applet;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.pluginsdk.ui.applet.c.AnonymousClass10;
import com.tencent.mm.pluginsdk.ui.applet.c.AnonymousClass6;
import com.tencent.mm.protocal.c.ars;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.u;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.k;
import com.tencent.mm.v.e;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.LinkedList;

public final class b implements com.tencent.mm.pluginsdk.ui.applet.a.a, com.tencent.mm.u.d.a {
    private int cVh;
    String dRA;
    ProgressDialog eZg;
    u fnD;
    private a lJp;
    h lJq;
    e lJr;
    private boolean lJs;
    Context mContext;

    public interface a {
        void mH(int i);
    }

    public b(Context context, String str, int i, a aVar) {
        this(context, str, i, aVar, true);
    }

    public b(Context context, String str, int i, a aVar, boolean z) {
        this.lJr = null;
        this.lJs = true;
        this.mContext = context;
        this.dRA = str;
        this.cVh = i;
        this.lJp = aVar;
        this.lJs = z;
    }

    public final void show() {
        ak.yW();
        this.fnD = c.wH().LX(this.dRA);
        if (this.fnD != null && ((int) this.fnD.chr) <= 0) {
            v.i("MicroMsg.AddContactDialog", "dealAddContact get by username fail, try alias, %s", this.dRA);
            ak.yW();
            this.fnD = c.wH().LU(this.dRA);
        }
        if (this.fnD == null || ((int) this.fnD.chr) <= 0) {
            Context context = this.mContext;
            this.mContext.getString(2131231164);
            this.eZg = g.a(context, this.mContext.getString(2131236676), true, new OnCancelListener(this) {
                final /* synthetic */ b lJt;

                {
                    this.lJt = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    if (this.lJt.eZg != null) {
                        this.lJt.eZg.dismiss();
                        this.lJt.eZg = null;
                    }
                }
            });
            Hv(this.dRA);
            return;
        }
        v.i("MicroMsg.AddContactDialog", "The contact already exists, so go to dealAddContact.");
        if (this.fnD == null) {
            v.e("MicroMsg.AddContactDialog", "dealAddContact fail, contact is null");
            eh(-1);
            return;
        }
        String str = this.fnD.field_username;
        if (this.fnD.bvm()) {
            if (com.tencent.mm.i.a.ei(this.fnD.field_type)) {
                g.bf(this.mContext, this.mContext.getResources().getString(2131236679));
                eh(-2);
                return;
            }
            I(this.fnD);
        } else if (com.tencent.mm.modelbiz.u.Dy().ho(str).Ct()) {
            Context context2 = this.mContext;
            this.mContext.getString(2131231164);
            this.eZg = g.a(context2, this.mContext.getString(2131236676), true, null);
            Hv(str);
        } else {
            Bitmap decodeResource = BitmapFactory.decodeResource(this.mContext.getResources(), 2130838070);
            if (this.mContext instanceof MMActivity) {
                OnCancelListener onCancelListener;
                k kVar = ((MMActivity) this.mContext).nDR;
                CharSequence string = this.mContext.getResources().getString(2131236681);
                com.tencent.mm.pluginsdk.ui.applet.c.a anonymousClass5 = new com.tencent.mm.pluginsdk.ui.applet.c.a(this) {
                    final /* synthetic */ b lJt;

                    {
                        this.lJt = r1;
                    }

                    public final void a(boolean z, String str, int i) {
                        v.e("MicroMsg.AddContactDialog", "doAddContact fail, contact not biz");
                        this.lJt.eh(-1);
                    }
                };
                View J = c.J(kVar.nEl, 2130903401);
                o cp = c.cp(J);
                c.a(J, anonymousClass5, cp);
                if (be.kS(string)) {
                    v.e("MicroMsg.MMConfirmDialog", "showDialogItem7 fail, message is empty");
                    onCancelListener = null;
                } else {
                    TextView textView = (TextView) J.findViewById(2131756407);
                    textView.setText(com.tencent.mm.pluginsdk.ui.d.e.a(kVar.nEl, string, textView.getTextSize()));
                    Button button = (Button) J.findViewById(2131756399);
                    ImageView imageView = (ImageView) J.findViewById(2131756406);
                    if (imageView != null) {
                        if (decodeResource == null || decodeResource.isRecycled()) {
                            imageView.setVisibility(8);
                        } else {
                            imageView.setImageBitmap(decodeResource);
                            cp.setOnDismissListener(new AnonymousClass6(decodeResource));
                        }
                    }
                    button.setOnClickListener(new AnonymousClass10(anonymousClass5, J, cp));
                    c.a(kVar, cp);
                    Object obj = cp;
                }
                if (onCancelListener == null) {
                    v.e("MicroMsg.AddContactDialog", "dealAddContact fail, connot show dialog");
                    eh(-1);
                }
            }
        }
    }

    final void I(final u uVar) {
        if (uVar == null) {
            v.e("MicroMsg.AddContactDialog", "showContact fail, contact is null");
            eh(-1);
            return;
        }
        Bitmap bitmap;
        CharSequence string = this.mContext.getString(2131236674);
        Bitmap a = com.tencent.mm.u.b.a(uVar.field_username, false, -1);
        if (a == null) {
            n.AX().a((com.tencent.mm.u.d.a) this);
        }
        if (a == null || !uVar.bvm()) {
            bitmap = a;
        } else {
            bitmap = d.a(a, false, (float) (a.getWidth() / 2));
        }
        CharSequence charSequence = uVar.field_nickname;
        this.lJq = null;
        if (this.mContext instanceof MMActivity) {
            if (this.lJs) {
                h hVar;
                k kVar = ((MMActivity) this.mContext).nDR;
                CharSequence charSequence2 = SQLiteDatabase.KeyEmpty;
                boolean bvm = uVar.bvm();
                com.tencent.mm.pluginsdk.ui.applet.c.a anonymousClass2 = new com.tencent.mm.pluginsdk.ui.applet.c.a(this) {
                    final /* synthetic */ b lJt;

                    public final void a(boolean z, String str, int i) {
                        if (z) {
                            this.lJt.J(uVar);
                        } else {
                            this.lJt.eh(0);
                        }
                        this.lJt.lJq.dismiss();
                    }
                };
                if ((string == null || string.length() == 0) && (charSequence == null || charSequence.length() == 0)) {
                    v.e("MicroMsg.MMConfirmDialog", "showDialogItem6 fail, title message both are empty");
                    hVar = null;
                } else {
                    View J = c.J(kVar.nEl, 2130903400);
                    com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(kVar.nEl);
                    aVar.jk(false);
                    aVar.jl(false);
                    c.k(J, false);
                    c.a(kVar, aVar, anonymousClass2, J, kVar.nEl.getResources().getString(2131232002));
                    TextView textView = (TextView) J.findViewById(2131756412);
                    textView.setText(com.tencent.mm.pluginsdk.ui.d.e.a(kVar.nEl, string, textView.getTextSize()));
                    textView = (TextView) J.findViewById(2131756407);
                    textView.setText(com.tencent.mm.pluginsdk.ui.d.e.a(kVar.nEl, charSequence, textView.getTextSize()));
                    if (charSequence2.length() == 0) {
                        J.findViewById(2131756408).setVisibility(8);
                    } else {
                        ((TextView) J.findViewById(2131756408)).setText(charSequence2);
                    }
                    ImageView imageView = (ImageView) J.findViewById(2131756406);
                    if (imageView != null) {
                        if (bitmap == null || bitmap.isRecycled()) {
                            imageView.setVisibility(4);
                        } else {
                            imageView.setImageBitmap(bitmap);
                            c.a(aVar, bitmap);
                        }
                    }
                    if (bvm) {
                        ((ImageView) J.findViewById(2131756416)).setVisibility(0);
                    }
                    aVar.cC(J);
                    hVar = aVar.RX();
                    hVar.show();
                }
                this.lJq = hVar;
            } else {
                J(uVar);
                return;
            }
        }
        if (this.lJq == null) {
            v.e("MicroMsg.AddContactDialog", "showContact fail, cannot show dialog");
            eh(-1);
        }
    }

    final void J(u uVar) {
        if (this.eZg != null) {
            this.eZg.dismiss();
        }
        Context context = this.mContext;
        this.mContext.getString(2131231164);
        this.eZg = g.a(context, this.mContext.getString(2131236676), true, null);
        a aVar = new a(this.mContext, this);
        LinkedList linkedList = new LinkedList();
        linkedList.add(Integer.valueOf(this.cVh));
        aVar.c(uVar.field_username, linkedList);
    }

    public final void gM(String str) {
        Object obj = 1;
        if (this.fnD != null) {
            Object obj2 = (this.fnD.field_username == null || !this.fnD.field_username.equals(str)) ? null : 1;
            if (this.fnD.pD() == null || !this.fnD.pD().equals(str)) {
                obj = null;
            }
            if (obj2 == null && r1 == null) {
                return;
            }
        } else if (this.dRA == null || !this.dRA.equals(str)) {
            return;
        }
        if (this.lJq != null && this.lJq.isShowing()) {
            ad.o(new Runnable(this) {
                final /* synthetic */ b lJt;

                {
                    this.lJt = r1;
                }

                public final void run() {
                    ImageView imageView = (ImageView) this.lJt.lJq.nTL.findViewById(2131756406);
                    if (imageView != null) {
                        Bitmap a = com.tencent.mm.u.b.a(this.lJt.fnD.field_username, false, -1);
                        if (a != null && this.lJt.fnD.bvm()) {
                            a = d.a(a, false, (float) (a.getWidth() / 2));
                        }
                        if (a != null && !a.isRecycled()) {
                            imageView.setImageBitmap(a);
                            imageView.setVisibility(0);
                        }
                    }
                }
            });
        }
    }

    private void Hv(String str) {
        v.i("MicroMsg.AddContactDialog", "searchContact %s", str);
        if (this.lJr == null) {
            this.lJr = new e(this) {
                final /* synthetic */ b lJt;

                {
                    this.lJt = r1;
                }

                public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
                    if (this.lJt.eZg != null) {
                        this.lJt.eZg.dismiss();
                    }
                    if (this.lJt.lJr != null) {
                        ak.vy().b((int) MMGIFException.D_GIF_ERR_NO_COLOR_MAP, this.lJt.lJr);
                    }
                    if (this.lJt.eZg == null) {
                        v.e("MicroMsg.AddContactDialog", "has cancel the loading dialog");
                        this.lJt.eh(0);
                    } else if (i != 0 || i2 != 0) {
                        v.e("MicroMsg.AddContactDialog", "searchContact onSceneEnd, errType = %d, errCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
                        this.lJt.eh(-1);
                    } else if (this.lJt.mContext == null) {
                        v.e("MicroMsg.AddContactDialog", "searchContact, context is null, msghandler has already been detached!");
                        this.lJt.eh(-1);
                    } else if ((this.lJt.mContext instanceof Activity) && ((Activity) this.lJt.mContext).isFinishing()) {
                        v.e("MicroMsg.AddContactDialog", "searchContact, context isFinishing");
                        this.lJt.eh(-1);
                    } else {
                        ars Jx = ((y) kVar).Jx();
                        String a = m.a(Jx.moM);
                        if (be.kS(a)) {
                            v.e("MicroMsg.AddContactDialog", "searchContact, user is null");
                            g.bf(this.lJt.mContext, this.lJt.mContext.getResources().getString(2131236675));
                            this.lJt.eh(-1);
                            return;
                        }
                        if (this.lJt.dRA == null || !this.lJt.dRA.equals(a)) {
                            v.w("MicroMsg.AddContactDialog", "user not the same, %s, %s", this.lJt.dRA, a);
                        }
                        b bVar = this.lJt;
                        ak.yW();
                        bVar.fnD = c.wH().LX(a);
                        if (this.lJt.fnD == null || ((int) this.lJt.fnD.chr) == 0) {
                            v.i("MicroMsg.AddContactDialog", "searchContact, no contact with username = " + a + ", try get by alias");
                            bVar = this.lJt;
                            ak.yW();
                            bVar.fnD = c.wH().LU(a);
                            if (this.lJt.fnD == null || ((int) this.lJt.fnD.chr) == 0) {
                                v.i("MicroMsg.AddContactDialog", "searchContact, no contact with alias, new Contact");
                                this.lJt.fnD = new u(a);
                                this.lJt.fnD.bP(Jx.cHh);
                                this.lJt.fnD.bS(m.a(Jx.mEj));
                                this.lJt.fnD.bT(m.a(Jx.moC));
                                this.lJt.fnD.bU(m.a(Jx.moD));
                                this.lJt.fnD.cV(Jx.cHc);
                                this.lJt.fnD.cl(RegionCodeDecoder.Y(Jx.cHl, Jx.cHd, Jx.cHe));
                                this.lJt.fnD.cf(Jx.cHf);
                                this.lJt.fnD.cR(Jx.mFu);
                                this.lJt.fnD.ck(Jx.mFv);
                                this.lJt.fnD.cQ(Jx.mFy);
                                this.lJt.fnD.bV(Jx.mFx);
                                this.lJt.fnD.cj(Jx.mFw);
                            }
                        } else {
                            v.i("MicroMsg.AddContactDialog", "searchContact, contact in db, %s", a);
                        }
                        this.lJt.I(this.lJt.fnD);
                    }
                }
            };
        }
        ak.vy().a((int) MMGIFException.D_GIF_ERR_NO_COLOR_MAP, this.lJr);
        ak.vy().a(new y(str), 0);
    }

    public final void a(boolean z, boolean z2, String str, String str2) {
        if (this.eZg != null) {
            this.eZg.dismiss();
        }
        if (z) {
            this.fnD.tp();
            ak.yW();
            c.wH().a(this.fnD.field_username, this.fnD);
            g.bf(this.mContext, this.mContext.getResources().getString(2131236679));
            eh(1);
            return;
        }
        eh(-1);
    }

    final void eh(int i) {
        if (this.lJp != null) {
            this.lJp.mH(i);
        }
    }
}
