package com.tencent.mm.plugin.recharge.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import android.telephony.PhoneNumberUtils;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.e.a.qp;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.recharge.a.a;
import com.tencent.mm.plugin.recharge.model.f;
import com.tencent.mm.plugin.recharge.ui.form.MallFormView;
import com.tencent.mm.plugin.recharge.ui.form.d;
import com.tencent.mm.plugin.wallet.a.g;
import com.tencent.mm.plugin.wallet.a.h;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.q;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PhoneRechargeUI extends MMActivity implements e {
    private String biS = "";
    private String desc = "";
    protected Dialog dxy = null;
    private String dzg = "";
    private int errCode = 0;
    private boolean hRZ = false;
    private c hSc = new c<qp>(this) {
        final /* synthetic */ PhoneRechargeUI inK;

        {
            this.inK = r2;
            this.nhz = qp.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            qp qpVar = (qp) bVar;
            if (qpVar instanceof qp) {
                if (qpVar.bsg.bpc != -1) {
                    v.i("MicroMsg.PhoneRechargeUI", "hy: MallRecharge pay result : cancel");
                } else if (!this.inK.hRZ) {
                    v.i("MicroMsg.PhoneRechargeUI", "hy: MallRecharge pay result : ok");
                    a.aJi().a(new com.tencent.mm.plugin.recharge.model.a(this.inK.inq.getText(), this.inK.inH.imU != null ? be.ma(this.inK.inH.imU.name) : "", 0));
                    this.inK.finish();
                    this.inK.hRZ = true;
                }
                return true;
            }
            v.f("MicroMsg.PhoneRechargeUI", "hy: mismatched event");
            return false;
        }
    };
    private ArrayList<h> imF = null;
    private ArrayList<h> imG = null;
    private com.tencent.mm.plugin.wallet.a.a imH = null;
    private com.tencent.mm.plugin.wallet.a.a imI = null;
    private com.tencent.mm.plugin.wallet.a.a imJ = null;
    private com.tencent.mm.plugin.wallet.a.a imK = null;
    private com.tencent.mm.plugin.wallet.a.a imL = null;
    private TextView inA = null;
    private b inB = null;
    private b inC = null;
    private MallFunction inD = null;
    private String inE = "";
    private String inF = "";
    private String inG = "";
    private com.tencent.mm.plugin.recharge.ui.form.c.b inH = null;
    private g inI = null;
    private boolean inJ = false;
    private View inn = null;
    private ImageView ino = null;
    private TextView inp = null;
    private MallFormView inq = null;
    private TextView inr = null;
    private TextView ins = null;
    private GridView int = null;
    private GridView inu = null;
    private TextView inv = null;
    private TextView inw = null;
    private TextView inx = null;
    private TextView iny = null;
    private TextView inz = null;

    static /* synthetic */ boolean a(PhoneRechargeUI phoneRechargeUI, final String str) {
        if (phoneRechargeUI.inq.ioB.getVisibility() == 0 && !be.kS(phoneRechargeUI.inq.ioB.getText().toString().replace(phoneRechargeUI.inE, ""))) {
            return true;
        }
        Context context = phoneRechargeUI;
        com.tencent.mm.ui.base.g.b(context, phoneRechargeUI.getString(2131233797, new Object[]{phoneRechargeUI.inq.getText().toString()}), "", phoneRechargeUI.getString(2131231183), phoneRechargeUI.getString(2131231104), new OnClickListener(phoneRechargeUI) {
            final /* synthetic */ PhoneRechargeUI inK;

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.inK.l(new com.tencent.mm.plugin.recharge.model.g(this.inK.dzg, this.inK.inD.imm, str, "mobile=" + com.tencent.mm.plugin.recharge.model.b.yt(this.inK.inq.getText())));
            }
        }, null);
        return false;
    }

    static /* synthetic */ void c(PhoneRechargeUI phoneRechargeUI, String str) {
        try {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", URLDecoder.decode(str, "UTF-8"));
            com.tencent.mm.ay.c.b(phoneRechargeUI, "webview", ".ui.tools.WebViewUI", intent);
        } catch (UnsupportedEncodingException e) {
            v.e("MicroMsg.PhoneRechargeUI", "hy: url decode failed: raw url: %s", new Object[]{str});
        }
    }

    static /* synthetic */ void f(PhoneRechargeUI phoneRechargeUI) {
        if (phoneRechargeUI.inI != null) {
            ak.yW();
            String str = (String) com.tencent.mm.model.c.vf().get(t.a.npp, "");
            Object valueOf = be.kS(str) ? String.valueOf(phoneRechargeUI.inI.id) : str + ";" + phoneRechargeUI.inI.id;
            ak.yW();
            com.tencent.mm.model.c.vf().a(t.a.npp, valueOf);
            ak.yW();
            com.tencent.mm.model.c.vf().iB(true);
        }
    }

    private void aJn() {
        this.dzg = "";
        aJo();
        this.errCode = 0;
        this.biS = "";
        this.desc = "";
    }

    public void onCreate(Bundle bundle) {
        List list;
        super.onCreate(bundle);
        ak.vy().a(1571, this);
        ak.vy().a(498, this);
        this.inD = (MallFunction) getIntent().getParcelableExtra("key_func_info");
        if (this.inD == null) {
            v.e("MicroMsg.PhoneRechargeUI", "hy: function info is null");
            s.makeText(this, "function info is null", 1).show();
            finish();
        }
        aJo();
        Fd(this.inD.bpZ);
        vE(2131236646);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ PhoneRechargeUI inK;

            {
                this.inK = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.inK.axg();
                this.inK.finish();
                return true;
            }
        });
        this.imL = new com.tencent.mm.plugin.wallet.a.a();
        this.imL.name = getString(2131236432);
        this.imL.url = getString(2131236433);
        this.inn = findViewById(2131758543);
        this.ino = (ImageView) findViewById(2131758545);
        this.inp = (TextView) findViewById(2131758544);
        this.inq = (MallFormView) findViewById(2131758547);
        com.tencent.mm.plugin.recharge.ui.form.c.b(this.inq);
        this.inH = new com.tencent.mm.plugin.recharge.ui.form.c.b(this.inq);
        com.tencent.mm.plugin.recharge.ui.form.c.b bVar = this.inH;
        v.d(com.tencent.mm.plugin.recharge.ui.form.c.TAG, "hy: setMobileEditTv");
        MallFormView mallFormView = bVar.iou;
        TextWatcher anonymousClass1 = new TextWatcher(bVar) {
            private int imX = 0;
            final /* synthetic */ b iov;

            {
                this.iov = r2;
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                String charSequence2 = charSequence.toString();
                int selectionStart = this.iov.iou.ioz.getSelectionStart();
                String str = "";
                if (charSequence2 != null) {
                    StringBuilder stringBuilder = new StringBuilder(charSequence2.replaceAll(" ", ""));
                    int length = stringBuilder.length();
                    if (length >= 4) {
                        stringBuilder.insert(3, ' ');
                    }
                    if (length >= 8) {
                        stringBuilder.insert(8, ' ');
                    }
                    str = stringBuilder.toString();
                    length = str.length();
                    if (length > this.imX) {
                        if ((selectionStart == 4 || selectionStart == 9) && i3 == 1) {
                            selectionStart++;
                        } else if ((selectionStart == 4 || selectionStart == 9) && i3 > 1) {
                            selectionStart += i3;
                        }
                    } else if (length < this.imX && (selectionStart == 4 || selectionStart == 9)) {
                        selectionStart--;
                    }
                    this.imX = length;
                }
                String str2 = str;
                int i4 = selectionStart;
                String str3 = str2;
                if (!charSequence2.equals(str3)) {
                    this.iov.iou.ioz.setText(str3);
                    if (i4 < this.imX) {
                        this.iov.iou.ioz.setSelection(i4);
                    } else {
                        this.iov.iou.ioz.setSelection(this.imX);
                    }
                }
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
            }
        };
        if (mallFormView.ioz != null) {
            mallFormView.ioz.addTextChangedListener(anonymousClass1);
        }
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) bVar.iou.ioz;
        List<com.tencent.mm.plugin.recharge.model.a> aJj = a.aJi().aJj();
        com.tencent.mm.plugin.recharge.model.a cp;
        if (aJj == null) {
            List arrayList = new ArrayList();
            cp = com.tencent.mm.plugin.recharge.ui.form.c.b.cp(autoCompleteTextView.getContext());
            if (cp != null) {
                arrayList.add(cp);
                a.aJi().a(cp);
            }
            list = arrayList;
        } else {
            ak.yW();
            String str = (String) com.tencent.mm.model.c.vf().get(6, null);
            int i = 0;
            for (com.tencent.mm.plugin.recharge.model.a cp2 : aJj) {
                int i2;
                if (be.kS(cp2.imk) || !cp2.imk.equals(str)) {
                    i2 = i;
                } else {
                    if (be.kS(cp2.name) || !cp2.name.equals(autoCompleteTextView.getContext().getString(2131236435))) {
                        cp2.name = autoCompleteTextView.getContext().getString(2131236435);
                        a.aJi().bc(aJj);
                    }
                    i2 = 1;
                }
                i = i2;
            }
            if (i == 0) {
                com.tencent.mm.plugin.recharge.model.a cp3 = com.tencent.mm.plugin.recharge.ui.form.c.b.cp(autoCompleteTextView.getContext());
                if (cp3 != null) {
                    aJj.add(cp3);
                    a.aJi().a(cp3);
                }
            }
            list = aJj;
        }
        Object dVar = new d(bVar.iou, bVar.imT);
        dVar.ipg = new d.c(bVar) {
            final /* synthetic */ b iov;

            {
                this.iov = r1;
            }

            public final void c(com.tencent.mm.plugin.recharge.model.a aVar) {
                this.iov.b(aVar);
            }
        };
        dVar.bc(list);
        if (list != null && list.size() > 0) {
            bVar.imU = (com.tencent.mm.plugin.recharge.model.a) list.get(0);
            bVar.b(bVar.imU);
        } else if (bVar.imT == null) {
            new Runnable(bVar) {
                final /* synthetic */ b iov;

                {
                    this.iov = r1;
                }

                public final void run() {
                    try {
                        this.iov.imT = com.tencent.mm.pluginsdk.a.cW(this.iov.iou.getContext());
                    } catch (Throwable e) {
                        v.a(c.TAG, e, "", new Object[0]);
                    }
                }
            }.run();
        }
        if (list != null) {
            list.size();
        }
        autoCompleteTextView.setAdapter(dVar);
        autoCompleteTextView.setOnItemClickListener(new com.tencent.mm.plugin.recharge.ui.form.c.b.AnonymousClass4(bVar, dVar, autoCompleteTextView));
        bVar.iou.setOnFocusChangeListener(new com.tencent.mm.plugin.recharge.ui.form.c.b.AnonymousClass5(bVar, autoCompleteTextView));
        autoCompleteTextView.setOnClickListener(new com.tencent.mm.plugin.recharge.ui.form.c.b.AnonymousClass6(bVar, autoCompleteTextView));
        this.int = (GridView) findViewById(2131758551);
        this.inv = (TextView) findViewById(2131758558);
        this.inw = (TextView) findViewById(2131758557);
        this.inx = (TextView) findViewById(2131758559);
        this.iny = (TextView) findViewById(2131758556);
        this.inr = (TextView) findViewById(2131758549);
        this.ins = (TextView) findViewById(2131758552);
        this.inu = (GridView) findViewById(2131758554);
        this.inz = (TextView) findViewById(2131758550);
        this.inA = (TextView) findViewById(2131758553);
        this.inq.ioC = new MallFormView.a(this) {
            final /* synthetic */ PhoneRechargeUI inK;

            {
                this.inK = r1;
            }

            public final void fc(boolean z) {
                if (z) {
                    this.inK.axg();
                    if (this.inK.inJ) {
                        this.inK.inJ = false;
                    } else {
                        this.inK.inq.ioz.clearFocus();
                        this.inK.inJ = true;
                    }
                    ak.vy().a(new f(this.inK.inq.getText()), 0);
                    return;
                }
                this.inK.inq.ioB.setText("");
                this.inK.aJn();
                this.inK.n(false, false);
            }
        };
        this.inq.ioA.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ PhoneRechargeUI inK;

            {
                this.inK = r1;
            }

            public final void onClick(View view) {
                if ((this.inK.getPackageManager().checkPermission("android.permission.READ_CONTACTS", aa.getPackageName()) == 0 ? 1 : 0) != 0) {
                    Intent intent = new Intent("android.intent.action.PICK", Contacts.CONTENT_URI);
                    if (be.m(this.inK, intent)) {
                        this.inK.startActivityForResult(intent, 1);
                        return;
                    }
                    return;
                }
                com.tencent.mm.ui.base.g.A(this.inK, this.inK.getString(2131236436), "");
            }
        });
        this.inB = new b();
        this.inB.inj = new b.a(this) {
            final /* synthetic */ PhoneRechargeUI inK;

            {
                this.inK = r1;
            }

            public final void a(h hVar) {
                if (hVar == null) {
                    v.e("MicroMsg.PhoneRechargeUI", "hy: no product item");
                } else if (PhoneRechargeUI.a(this.inK, hVar.id)) {
                    this.inK.l(new com.tencent.mm.plugin.recharge.model.g(this.inK.dzg, this.inK.inD.imm, hVar.id, "mobile=" + com.tencent.mm.plugin.recharge.model.b.yt(this.inK.inq.getText())));
                }
            }
        };
        this.inC = new b();
        this.inC.inj = new b.a(this) {
            final /* synthetic */ PhoneRechargeUI inK;

            {
                this.inK = r1;
            }

            public final void a(h hVar) {
                if (!be.kS(hVar.url)) {
                    PhoneRechargeUI.c(this.inK, hVar.url + String.format("?phone=%s", new Object[]{this.inK.inq.getText()}));
                } else if (PhoneRechargeUI.a(this.inK, hVar.id)) {
                    this.inK.l(new com.tencent.mm.plugin.recharge.model.g(this.inK.dzg, this.inK.inD.imm, hVar.id, "mobile=" + com.tencent.mm.plugin.recharge.model.b.yt(this.inK.inq.getText())));
                } else {
                    v.w("MicroMsg.PhoneRechargeUI", "error dataFlow click");
                }
            }
        };
        this.int.setAdapter(this.inB);
        this.inu.setAdapter(this.inC);
        this.ino.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ PhoneRechargeUI inK;

            {
                this.inK = r1;
            }

            public final void onClick(View view) {
                if (this.inK.inI != null) {
                    PhoneRechargeUI.f(this.inK);
                } else {
                    v.e("MicroMsg.PhoneRechargeUI", "hy: no banner but show ad. should not happen");
                }
                this.inK.inn.setVisibility(8);
            }
        });
        this.inp.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ PhoneRechargeUI inK;

            {
                this.inK = r1;
            }

            public final void onClick(View view) {
                if (this.inK.inI != null && !be.kS(this.inK.inI.url)) {
                    com.tencent.mm.protocal.g.cq(6, 1);
                    PhoneRechargeUI.c(this.inK, this.inK.inI.url);
                }
            }
        });
        this.inq.aJw();
        if (!(this.inH.imU == null || be.kS(this.inH.imU.name))) {
            this.desc = this.inH.imU.name;
        }
        this.inq.ioz.setHintTextColor(getResources().getColor(2131689949));
        if (be.kS(this.inq.getText())) {
            l(new f(""));
        } else {
            l(new f(this.inq.getText()));
        }
    }

    private void k(k kVar) {
        if (this.dxy != null && this.dxy.isShowing() && kVar.getType() != 497) {
            this.dxy.dismiss();
            this.dxy = null;
        }
    }

    private void l(final k kVar) {
        if (this.dxy == null || !(this.dxy == null || this.dxy.isShowing())) {
            this.dxy = com.tencent.mm.wallet_core.ui.g.a(this.nDR.nEl, true, new OnCancelListener(this) {
                final /* synthetic */ PhoneRechargeUI inK;

                public final void onCancel(DialogInterface dialogInterface) {
                    ak.vy().c(kVar);
                }
            });
        }
        ak.vy().a(kVar, 0);
    }

    protected void onResume() {
        super.onResume();
        n(false, true);
    }

    protected void onDestroy() {
        super.onDestroy();
        ak.vy().b(1571, this);
        ak.vy().b(498, this);
        com.tencent.mm.sdk.c.a.nhr.f(this.hSc);
    }

    private synchronized void n(boolean z, boolean z2) {
        Object obj;
        int i;
        Iterator it;
        TextView textView;
        CharSequence string;
        MallFunction mallFunction;
        final String str;
        if (this.inI != null) {
            if (this.inI != null) {
                ak.yW();
                String str2 = (String) com.tencent.mm.model.c.vf().get(t.a.npp, "");
                if (be.kS(str2)) {
                    v.i("MicroMsg.PhoneRechargeUI", "hy: no banner before, show");
                    obj = null;
                } else {
                    String[] split = str2.split(";");
                    if (split != null) {
                        for (String str3 : split) {
                            if (str3 != null && str3.equals(String.valueOf(this.inI.id))) {
                                v.i("MicroMsg.PhoneRechargeUI", "hy: found closed. ");
                                obj = 1;
                                break;
                            }
                        }
                    }
                    v.i("MicroMsg.PhoneRechargeUI", "hy: not found closed banner.");
                    obj = null;
                }
            } else {
                v.e("MicroMsg.PhoneRechargeUI", "hy: no banner");
                i = 1;
            }
            if (obj == null) {
                this.inn.setVisibility(0);
                this.inp.setText(this.inI.name);
                v.d("MicroMsg.PhoneRechargeUI", "hy: Show banner!");
                com.tencent.mm.protocal.g.cq(6, 0);
                this.inB.ini = this.imF;
                this.inB.notifyDataSetChanged();
                this.inC.ini = this.imG;
                this.inC.notifyDataSetChanged();
                if (z) {
                    this.inz.setVisibility(8);
                } else {
                    it = this.imF.iterator();
                    while (it.hasNext()) {
                        if (((h) it.next()).status != 0) {
                            obj = null;
                            break;
                        }
                    }
                    i = 1;
                    if (obj == null) {
                        this.inz.setVisibility(0);
                    } else {
                        this.inz.setVisibility(8);
                    }
                    it = this.imG.iterator();
                    while (it.hasNext()) {
                        if (((h) it.next()).status != 0) {
                            obj = null;
                            break;
                        }
                    }
                    i = 1;
                    if (obj != null) {
                        this.inA.setVisibility(0);
                        if (z2) {
                            a(0, this.imL.name, new OnMenuItemClickListener(this) {
                                final /* synthetic */ PhoneRechargeUI inK;

                                {
                                    this.inK = r1;
                                }

                                public final boolean onMenuItemClick(MenuItem menuItem) {
                                    PhoneRechargeUI.c(this.inK, this.inK.imL.url);
                                    return false;
                                }
                            });
                        }
                        textView = this.inr;
                        string = (this.imF != null || this.imF.size() <= 0 || be.kS(((h) this.imF.get(0)).kHR)) ? getString(2131236429) : ((h) this.imF.get(0)).kHR;
                        textView.setText(string);
                        textView = this.ins;
                        string = (this.imG != null || this.imG.size() <= 0 || be.kS(((h) this.imG.get(0)).kHR)) ? getString(2131236430) : ((h) this.imG.get(0)).kHR;
                        textView.setText(string);
                        if (this.imK != null || be.kS(this.imK.name) || be.kS(this.imK.url)) {
                            this.inw.setVisibility(8);
                        } else {
                            this.inw.setVisibility(0);
                            this.inw.setText(this.imK.name);
                            this.inw.setOnClickListener(new View.OnClickListener(this) {
                                final /* synthetic */ PhoneRechargeUI inK;

                                {
                                    this.inK = r1;
                                }

                                public final void onClick(View view) {
                                    v.d("MicroMsg.PhoneRechargeUI", "go to h5: %s", new Object[]{this.inK.imK.url + String.format("?phone=%s", new Object[]{this.inK.inq.getText()})});
                                    PhoneRechargeUI.c(this.inK, r0);
                                }
                            });
                        }
                        if (this.imH != null || be.kS(this.imH.name) || be.kS(this.imH.url)) {
                            this.inv.setVisibility(8);
                        } else {
                            this.inv.setVisibility(0);
                            this.inv.setText(this.imH.name);
                            this.inv.setOnClickListener(new View.OnClickListener(this) {
                                final /* synthetic */ PhoneRechargeUI inK;

                                {
                                    this.inK = r1;
                                }

                                public final void onClick(View view) {
                                    v.d("MicroMsg.PhoneRechargeUI", "go to h5: %s", new Object[]{this.inK.imH.url + String.format("?phone=%s", new Object[]{this.inK.inq.getText()})});
                                    PhoneRechargeUI.c(this.inK, r0);
                                }
                            });
                        }
                        if (this.imI != null || be.kS(this.imI.name) || be.kS(this.imI.url)) {
                            this.inx.setVisibility(8);
                        } else {
                            this.inx.setVisibility(0);
                            this.inx.setText(this.imI.name);
                            this.inx.setOnClickListener(new View.OnClickListener(this) {
                                final /* synthetic */ PhoneRechargeUI inK;

                                {
                                    this.inK = r1;
                                }

                                public final void onClick(View view) {
                                    v.d("MicroMsg.PhoneRechargeUI", "go to h5: %s", new Object[]{this.inK.imI.url + String.format("?phone=%s", new Object[]{this.inK.inq.getText()})});
                                    PhoneRechargeUI.c(this.inK, r0);
                                }
                            });
                        }
                        if (this.imJ != null || be.kS(this.imJ.name) || be.kS(this.imJ.url)) {
                            this.iny.setVisibility(8);
                        } else {
                            this.iny.setVisibility(0);
                            this.iny.setText(this.imJ.name);
                            this.iny.setOnClickListener(new View.OnClickListener(this) {
                                final /* synthetic */ PhoneRechargeUI inK;

                                {
                                    this.inK = r1;
                                }

                                public final void onClick(View view) {
                                    v.d("MicroMsg.PhoneRechargeUI", "go to h5: %s", new Object[]{this.inK.imJ.url + String.format("?phone=%s", new Object[]{this.inK.inq.getText()})});
                                    PhoneRechargeUI.c(this.inK, r0);
                                }
                            });
                        }
                        if (be.kS(this.biS)) {
                            this.inq.ioB.setText(this.biS);
                            this.inq.ioB.setTextColor(getResources().getColor(2131689944));
                        } else if (be.kS(this.desc)) {
                            this.inq.ioB.setText(this.desc);
                            this.inq.ioB.setTextColor(getResources().getColor(2131689909));
                        } else {
                            this.inq.ioB.setText("");
                        }
                        mallFunction = this.inD;
                        if (mallFunction.kRg == null && mallFunction.kRg.kPK == 1 && !be.kS(mallFunction.kRg.kRv)) {
                            ak.yW();
                            if (((Boolean) com.tencent.mm.model.c.vf().get(t.a.nsR, Boolean.valueOf(false))).booleanValue()) {
                                obj = null;
                            } else {
                                i = 1;
                            }
                        } else {
                            obj = null;
                        }
                        if (obj != null) {
                            ak.yW();
                            com.tencent.mm.model.c.vf().a(t.a.nsR, Boolean.valueOf(true));
                            v.d("MicroMsg.PhoneRechargeUI", this.inD.kRg.toString());
                            str = this.inD.kRg.kRv;
                            com.tencent.mm.ui.base.g.a(this.nDR.nEl, getString(2131236443), q.em(this).inflate(2130904254, null), getString(2131236444), getString(2131236442), new OnClickListener(this) {
                                final /* synthetic */ PhoneRechargeUI inK;

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    v.d("MicroMsg.PhoneRechargeUI", "go to h5: %s", new Object[]{str + String.format("?phone=%s", new Object[]{this.inK.inq.getText()})});
                                    PhoneRechargeUI.c(this.inK, r0);
                                }
                            }, new OnClickListener(this) {
                                final /* synthetic */ PhoneRechargeUI inK;

                                {
                                    this.inK = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                }
                            });
                        }
                    }
                }
                this.inA.setVisibility(8);
                if (z2) {
                    a(0, this.imL.name, /* anonymous class already generated */);
                }
                textView = this.inr;
                if (this.imF != null) {
                }
                textView.setText(string);
                textView = this.ins;
                if (this.imG != null) {
                }
                textView.setText(string);
                if (this.imK != null) {
                }
                this.inw.setVisibility(8);
                if (this.imH != null) {
                }
                this.inv.setVisibility(8);
                if (this.imI != null) {
                }
                this.inx.setVisibility(8);
                if (this.imJ != null) {
                }
                this.iny.setVisibility(8);
                if (be.kS(this.biS)) {
                    this.inq.ioB.setText(this.biS);
                    this.inq.ioB.setTextColor(getResources().getColor(2131689944));
                } else if (be.kS(this.desc)) {
                    this.inq.ioB.setText("");
                } else {
                    this.inq.ioB.setText(this.desc);
                    this.inq.ioB.setTextColor(getResources().getColor(2131689909));
                }
                mallFunction = this.inD;
                if (mallFunction.kRg == null) {
                }
                obj = null;
                if (obj != null) {
                    ak.yW();
                    com.tencent.mm.model.c.vf().a(t.a.nsR, Boolean.valueOf(true));
                    v.d("MicroMsg.PhoneRechargeUI", this.inD.kRg.toString());
                    str = this.inD.kRg.kRv;
                    com.tencent.mm.ui.base.g.a(this.nDR.nEl, getString(2131236443), q.em(this).inflate(2130904254, null), getString(2131236444), getString(2131236442), /* anonymous class already generated */, /* anonymous class already generated */);
                }
            }
        }
        this.inn.setVisibility(8);
        v.d("MicroMsg.PhoneRechargeUI", "hy: dismiss banner!");
        this.inB.ini = this.imF;
        this.inB.notifyDataSetChanged();
        this.inC.ini = this.imG;
        this.inC.notifyDataSetChanged();
        if (z) {
            it = this.imF.iterator();
            while (it.hasNext()) {
                if (((h) it.next()).status != 0) {
                    obj = null;
                    break;
                }
            }
            i = 1;
            if (obj == null) {
                this.inz.setVisibility(8);
            } else {
                this.inz.setVisibility(0);
            }
            it = this.imG.iterator();
            while (it.hasNext()) {
                if (((h) it.next()).status != 0) {
                    obj = null;
                    break;
                }
            }
            i = 1;
            if (obj != null) {
                this.inA.setVisibility(0);
                if (z2) {
                    a(0, this.imL.name, /* anonymous class already generated */);
                }
                textView = this.inr;
                if (this.imF != null) {
                }
                textView.setText(string);
                textView = this.ins;
                if (this.imG != null) {
                }
                textView.setText(string);
                if (this.imK != null) {
                }
                this.inw.setVisibility(8);
                if (this.imH != null) {
                }
                this.inv.setVisibility(8);
                if (this.imI != null) {
                }
                this.inx.setVisibility(8);
                if (this.imJ != null) {
                }
                this.iny.setVisibility(8);
                if (be.kS(this.biS)) {
                    this.inq.ioB.setText(this.biS);
                    this.inq.ioB.setTextColor(getResources().getColor(2131689944));
                } else if (be.kS(this.desc)) {
                    this.inq.ioB.setText(this.desc);
                    this.inq.ioB.setTextColor(getResources().getColor(2131689909));
                } else {
                    this.inq.ioB.setText("");
                }
                mallFunction = this.inD;
                if (mallFunction.kRg == null) {
                }
                obj = null;
                if (obj != null) {
                    ak.yW();
                    com.tencent.mm.model.c.vf().a(t.a.nsR, Boolean.valueOf(true));
                    v.d("MicroMsg.PhoneRechargeUI", this.inD.kRg.toString());
                    str = this.inD.kRg.kRv;
                    com.tencent.mm.ui.base.g.a(this.nDR.nEl, getString(2131236443), q.em(this).inflate(2130904254, null), getString(2131236444), getString(2131236442), /* anonymous class already generated */, /* anonymous class already generated */);
                }
            }
        } else {
            this.inz.setVisibility(8);
        }
        this.inA.setVisibility(8);
        if (z2) {
            a(0, this.imL.name, /* anonymous class already generated */);
        }
        textView = this.inr;
        if (this.imF != null) {
        }
        textView.setText(string);
        textView = this.ins;
        if (this.imG != null) {
        }
        textView.setText(string);
        if (this.imK != null) {
        }
        this.inw.setVisibility(8);
        if (this.imH != null) {
        }
        this.inv.setVisibility(8);
        if (this.imI != null) {
        }
        this.inx.setVisibility(8);
        if (this.imJ != null) {
        }
        this.iny.setVisibility(8);
        if (be.kS(this.biS)) {
            this.inq.ioB.setText(this.biS);
            this.inq.ioB.setTextColor(getResources().getColor(2131689944));
        } else if (be.kS(this.desc)) {
            this.inq.ioB.setText("");
        } else {
            this.inq.ioB.setText(this.desc);
            this.inq.ioB.setTextColor(getResources().getColor(2131689909));
        }
        mallFunction = this.inD;
        if (mallFunction.kRg == null) {
        }
        obj = null;
        if (obj != null) {
            ak.yW();
            com.tencent.mm.model.c.vf().a(t.a.nsR, Boolean.valueOf(true));
            v.d("MicroMsg.PhoneRechargeUI", this.inD.kRg.toString());
            str = this.inD.kRg.kRv;
            com.tencent.mm.ui.base.g.a(this.nDR.nEl, getString(2131236443), q.em(this).inflate(2130904254, null), getString(2131236444), getString(2131236442), /* anonymous class already generated */, /* anonymous class already generated */);
        }
    }

    private void aJo() {
        this.imF = new ArrayList();
        h hVar = new h();
        hVar.name = getString(2131236419);
        hVar.status = 0;
        h hVar2 = new h();
        hVar2.name = getString(2131236420);
        hVar2.status = 0;
        h hVar3 = new h();
        hVar3.name = getString(2131236421);
        hVar3.status = 0;
        h hVar4 = new h();
        hVar4.name = getString(2131236422);
        hVar4.status = 0;
        h hVar5 = new h();
        hVar5.name = getString(2131236423);
        hVar5.status = 0;
        h hVar6 = new h();
        hVar6.name = getString(2131236424);
        hVar6.status = 0;
        this.imF.add(hVar);
        this.imF.add(hVar2);
        this.imF.add(hVar3);
        this.imF.add(hVar4);
        this.imF.add(hVar5);
        this.imF.add(hVar6);
        this.imG = new ArrayList();
        hVar = new h();
        hVar.name = getString(2131236425);
        hVar.status = 0;
        hVar2 = new h();
        hVar2.name = getString(2131236426);
        hVar2.status = 0;
        hVar3 = new h();
        hVar3.name = getString(2131236427);
        hVar3.status = 0;
        this.imG.add(hVar);
        this.imG.add(hVar2);
        this.imG.add(hVar3);
    }

    protected final int getLayoutId() {
        return 2130904160;
    }

    private void yv(String str) {
        com.tencent.mm.ui.base.g.a(this, str, "", false, new OnClickListener(this) {
            final /* synthetic */ PhoneRechargeUI inK;

            {
                this.inK = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
    }

    public final void a(int i, int i2, String str, k kVar) {
        boolean z = false;
        if (kVar instanceof f) {
            f fVar = (f) kVar;
            if (be.kS(fVar.hUm) || fVar.hUm.equals(this.inq.getText())) {
                k(kVar);
                if (fVar.imE) {
                    v.e("MicroMsg.PhoneRechargeUI", "hy: cgi failed.");
                    yv(fVar.biS);
                    aJn();
                    return;
                }
                String str2;
                PhoneRechargeUI phoneRechargeUI;
                boolean z2;
                this.dzg = fVar.appId;
                this.imF = fVar.imF;
                this.imH = fVar.imH;
                this.imI = fVar.imI;
                this.imJ = fVar.imJ;
                this.imK = fVar.imK;
                this.errCode = fVar.errCode;
                this.biS = fVar.biS;
                this.inE = fVar.desc;
                if (be.kS(this.inE)) {
                    str2 = "";
                    phoneRechargeUI = this;
                } else if (this.inH.imU == null || be.kS(this.inH.imU.name) || !this.inH.imU.imk.trim().equals(this.inq.getText())) {
                    str2 = getString(2131236437) + getString(2131236428, new Object[]{this.inE});
                    phoneRechargeUI = this;
                } else {
                    str2 = this.inH.imU.name + getString(2131236428, new Object[]{this.inE});
                    phoneRechargeUI = this;
                }
                phoneRechargeUI.desc = str2;
                this.inI = fVar.imM;
                this.imG = fVar.imG;
                for (int size = this.imG.size() - 1; size >= 0; size--) {
                    h hVar = (h) this.imG.get(size);
                    if (hVar.name.isEmpty()) {
                        this.imG.remove(hVar);
                    }
                }
                if (fVar.imL == null || (fVar.imL.name.equals(this.imL.name) && fVar.imL.url.equals(this.imL.url))) {
                    z2 = false;
                } else {
                    v.i("MicroMsg.PhoneRechargeUI", "need to update head");
                    this.imL = fVar.imL;
                    z2 = true;
                }
                if (!this.inE.equals("")) {
                    z = true;
                }
                n(z, z2);
                return;
            }
            v.i("MicroMsg.PhoneRechargeUI", "hy: mobiel num not match.abourt");
        } else if (kVar instanceof com.tencent.mm.plugin.recharge.model.g) {
            k(kVar);
            if (i == 0 && i2 == 0) {
                PayInfo payInfo = ((com.tencent.mm.plugin.recharge.model.g) kVar).imN;
                payInfo.bkq = 6;
                payInfo.lVy = 100;
                com.tencent.mm.pluginsdk.wallet.e.a(this, payInfo, 2);
                com.tencent.mm.sdk.c.a.nhr.e(this.hSc);
                return;
            }
            yv(str);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        String str = null;
        switch (i) {
            case 1:
                if (i2 == -1) {
                    this.inJ = true;
                    final List arrayList = new ArrayList();
                    Uri data = intent.getData();
                    if (data != null) {
                        if (com.tencent.mm.pluginsdk.i.a.aP(this, "android.permission.READ_CONTACTS")) {
                            try {
                                Cursor query = getContentResolver().query(data, null, null, null, null);
                                if (query != null && query.getCount() > 0) {
                                    query.moveToFirst();
                                    int columnIndex = query.getColumnIndex("has_phone_number");
                                    if (columnIndex <= 0 || query.getInt(columnIndex) > 0) {
                                        String str2;
                                        String string = query.getString(query.getColumnIndex("_id"));
                                        Cursor query2 = getContentResolver().query(Phone.CONTENT_URI, null, "contact_id = " + string, null, null);
                                        if (query2.moveToFirst()) {
                                            str2 = null;
                                            while (!query2.isAfterLast()) {
                                                columnIndex = query2.getColumnIndex("data1");
                                                int columnIndex2 = query2.getColumnIndex(SlookAirButtonFrequentContactAdapter.DISPLAY_NAME);
                                                String string2 = query2.getString(columnIndex);
                                                str2 = query2.getString(columnIndex2);
                                                v.d("MicroMsg.PhoneRechargeUI", "hy: username : " + str2);
                                                if (string2 != null) {
                                                    v.d("MicroMsg.PhoneRechargeUI", "hy: phoneNumber : " + string2);
                                                    string = com.tencent.mm.plugin.recharge.model.b.yt(string2);
                                                    v.d("MicroMsg.PhoneRechargeUI", "hy: phoneNumber : " + string);
                                                    if (PhoneNumberUtils.isGlobalPhoneNumber(string) && string.length() == 11) {
                                                        arrayList.add(string);
                                                    }
                                                    v.d("MicroMsg.PhoneRechargeUI", "hy: phoneResult : " + string);
                                                }
                                                query2.moveToNext();
                                            }
                                        } else {
                                            str2 = null;
                                        }
                                        if (!query2.isClosed()) {
                                            query2.close();
                                        }
                                        str = str2;
                                    }
                                }
                                if (!(query == null || query.isClosed())) {
                                    query.close();
                                }
                                if (arrayList.size() <= 1) {
                                    if (arrayList.size() != 1) {
                                        com.tencent.mm.ui.base.g.A(this, getString(2131233801), "");
                                        break;
                                    } else {
                                        this.inH.b(new com.tencent.mm.plugin.recharge.model.a((String) arrayList.get(0), str, 1));
                                        break;
                                    }
                                }
                                com.tencent.mm.ui.base.g.a(this, getString(2131236438), arrayList, -1, new com.tencent.mm.ui.base.g.a(this) {
                                    final /* synthetic */ PhoneRechargeUI inK;

                                    public final void oI(int i) {
                                        v.d("MicroMsg.PhoneRechargeUI", "choose: %d", new Object[]{Integer.valueOf(i)});
                                        this.inK.inH.b(new com.tencent.mm.plugin.recharge.model.a((String) arrayList.get(i), str, 1));
                                    }
                                }).setCanceledOnTouchOutside(true);
                                break;
                            } catch (SecurityException e) {
                                v.e("MicroMsg.PhoneRechargeUI", "hy: permission denied: %s", new Object[]{e.toString()});
                                com.tencent.mm.ui.base.g.A(this, getString(2131233803), "");
                                break;
                            }
                        }
                        v.e("MicroMsg.PhoneRechargeUI", "no contact permission");
                        return;
                    }
                    v.e("MicroMsg.PhoneRechargeUI", "hy: uri == null");
                    return;
                }
                break;
            case 2:
                if (i2 == -1) {
                    if (!this.hRZ) {
                        v.i("MicroMsg.PhoneRechargeUI", "hy: MallRecharge pay result : ok");
                        a.aJi().a(new com.tencent.mm.plugin.recharge.model.a(this.inq.getText(), this.inq.ioB.getText().toString(), 0));
                        finish();
                        this.hRZ = true;
                        break;
                    }
                }
                v.i("MicroMsg.PhoneRechargeUI", "hy: MallRecharge pay result : cancel");
                break;
                break;
        }
        super.onActivityResult(i, i2, intent);
    }
}
