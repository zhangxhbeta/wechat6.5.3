package com.tencent.mm.ui.contact;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.e.a.pw;
import com.tencent.mm.e.b.ab;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.modelfriend.ah;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.ui.ProfileEditPhoneNumberView;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.protocal.c.ait;
import com.tencent.mm.protocal.c.aje;
import com.tencent.mm.protocal.c.amr;
import com.tencent.mm.protocal.c.ams;
import com.tencent.mm.sdk.h.j;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMClearEditText;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.tools.h;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ContactRemarkInfoModUI extends MMActivity implements e {
    private String aGY;
    private String bCt;
    private String cUH;
    private ProgressDialog eLA;
    private u euW;
    private String gRd;
    private int hUa;
    private String lQk;
    private TextView oFA;
    private TextView oFB;
    private TextView oFC;
    private TextView oFD;
    private ImageView oFE;
    private ImageView oFF;
    private TextView oFG;
    private View oFH;
    private Button oFI;
    private View oFJ;
    private String oFK;
    private boolean oFL = false;
    private boolean oFM = false;
    private boolean oFN = false;
    private boolean oFO = false;
    private boolean oFP = false;
    private a oFQ = new a();
    private MMTagPanel oFR;
    private TextView oFS;
    private ScrollView oFT;
    private List<String> oFU;
    private ProfileEditPhoneNumberView oFV;
    private String oFW;
    private String oFX;
    private String oFY;
    private com.tencent.mm.sdk.h.j.b oFZ = new com.tencent.mm.sdk.h.j.b(this) {
        final /* synthetic */ ContactRemarkInfoModUI oGc;

        {
            this.oGc = r1;
        }

        public final void a(int i, j jVar, Object obj) {
            v.d("MiroMsg.ContactRemarkInfoModUI", "cpan onNotifyChange");
            this.oGc.bHA();
        }
    };
    private MMClearEditText oFx;
    private TextView oFy;
    private MMEditText oFz;
    boolean oGa = false;
    private boolean oGb = false;
    private String username;

    private class a implements OnClickListener {
        final /* synthetic */ ContactRemarkInfoModUI oGc;

        private a(ContactRemarkInfoModUI contactRemarkInfoModUI) {
            this.oGc = contactRemarkInfoModUI;
        }

        public final void onClick(View view) {
            ContactRemarkInfoModUI.c(this.oGc);
        }
    }

    private class b implements TextWatcher {
        private int iJG;
        final /* synthetic */ ContactRemarkInfoModUI oGc;
        private String oGf;

        private b(ContactRemarkInfoModUI contactRemarkInfoModUI) {
            this.oGc = contactRemarkInfoModUI;
            this.iJG = 800;
            this.oGf = SQLiteDatabase.KeyEmpty;
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            this.iJG = h.aw(800, editable.toString());
            if (this.iJG < 0) {
                this.iJG = 0;
            }
            if (this.oGc.oFD != null) {
                this.oGc.oFD.setText(this.iJG);
            }
            this.oGc.adt();
        }
    }

    static /* synthetic */ void a(ContactRemarkInfoModUI contactRemarkInfoModUI, boolean z) {
        ak.yW();
        if (!c.isSDCardAvailable()) {
            s.ey(contactRemarkInfoModUI);
        }
        if (z) {
            g.a((Context) contactRemarkInfoModUI, SQLiteDatabase.KeyEmpty, new String[]{contactRemarkInfoModUI.getString(2131234874), contactRemarkInfoModUI.getString(2131231020)}, SQLiteDatabase.KeyEmpty, new g.c(contactRemarkInfoModUI) {
                final /* synthetic */ ContactRemarkInfoModUI oGc;

                {
                    this.oGc = r1;
                }

                public final void gT(int i) {
                    switch (i) {
                        case 0:
                            v.d("MiroMsg.ContactRemarkInfoModUI", "pick up an image");
                            Intent intent = new Intent();
                            intent.putExtra("max_select_count", 1);
                            intent.putExtra("query_source_type", 0);
                            intent.putExtra("send_btn_string", " ");
                            intent.addFlags(67108864);
                            com.tencent.mm.ay.c.b(this.oGc, "gallery", ".ui.GalleryEntryUI", intent, 200);
                            return;
                        case 1:
                            v.d("MiroMsg.ContactRemarkInfoModUI", "delete the remark image when download failed.");
                            this.oGc.bHz();
                            return;
                        default:
                            return;
                    }
                }
            });
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("max_select_count", 1);
        intent.putExtra("query_source_type", 0);
        intent.putExtra("send_btn_string", " ");
        intent.addFlags(67108864);
        com.tencent.mm.ay.c.b(contactRemarkInfoModUI, "gallery", ".ui.GalleryEntryUI", intent, 200);
    }

    static /* synthetic */ void c(ContactRemarkInfoModUI contactRemarkInfoModUI) {
        Intent intent = new Intent();
        intent.putExtra("label_id_list", contactRemarkInfoModUI.gRd);
        if (contactRemarkInfoModUI.oFU != null) {
            intent.putStringArrayListExtra("label_str_list", (ArrayList) contactRemarkInfoModUI.oFU);
        }
        intent.putExtra("label_username", contactRemarkInfoModUI.username);
        com.tencent.mm.ay.c.b(contactRemarkInfoModUI, "label", ".ui.ContactLabelUI", intent, 600);
    }

    static /* synthetic */ void q(ContactRemarkInfoModUI contactRemarkInfoModUI) {
        int i = 0;
        if (!contactRemarkInfoModUI.bHy()) {
            com.tencent.mm.ui.tools.a.c.b(contactRemarkInfoModUI.oFx).yn(100).a(new com.tencent.mm.ui.tools.a.c.a(contactRemarkInfoModUI) {
                final /* synthetic */ ContactRemarkInfoModUI oGc;

                {
                    this.oGc = r1;
                }

                public final void qK(String str) {
                    this.oGc.bHu();
                    this.oGc.oGa = true;
                }

                public final void adq() {
                }

                public final void adr() {
                    g.f(this.oGc, 2131235067, 2131235064);
                    this.oGc.oGa = false;
                }
            });
            com.tencent.mm.ui.tools.a.c.b(contactRemarkInfoModUI.oFz).yn(800).a(new com.tencent.mm.ui.tools.a.c.a(contactRemarkInfoModUI) {
                final /* synthetic */ ContactRemarkInfoModUI oGc;

                {
                    this.oGc = r1;
                }

                public final void qK(String str) {
                    this.oGc.bHv();
                }

                public final void adq() {
                }

                public final void adr() {
                    g.f(this.oGc, 2131235057, 2131235064);
                    this.oGc.oGa = false;
                }
            });
            contactRemarkInfoModUI.bHw();
            contactRemarkInfoModUI.ab(contactRemarkInfoModUI.aGY, contactRemarkInfoModUI.bCt, contactRemarkInfoModUI.cUH);
            if (!(!contactRemarkInfoModUI.oGb || contactRemarkInfoModUI.oFV == null || contactRemarkInfoModUI.oFV.boL() == null)) {
                int size = (t.kS(contactRemarkInfoModUI.oFW) ? 0 : 1) + contactRemarkInfoModUI.oFV.boL().size();
                com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.iuh;
                Object[] objArr = new Object[4];
                objArr[0] = contactRemarkInfoModUI.username;
                objArr[1] = Integer.valueOf(2);
                if (!t.kS(contactRemarkInfoModUI.oFW)) {
                    i = 1;
                }
                objArr[2] = Integer.valueOf(i);
                objArr[3] = Integer.valueOf(size);
                gVar.h(12040, objArr);
            }
            if (contactRemarkInfoModUI.oGa) {
                contactRemarkInfoModUI.finish();
            }
        } else if (!contactRemarkInfoModUI.bHy()) {
        } else {
            if (contactRemarkInfoModUI.oFP) {
                ak.vy().a(new com.tencent.mm.an.a(contactRemarkInfoModUI.username), 0);
                contactRemarkInfoModUI.getString(2131231164);
                contactRemarkInfoModUI.eLA = g.a((Context) contactRemarkInfoModUI, contactRemarkInfoModUI.getString(2131232013), false, new OnCancelListener(contactRemarkInfoModUI) {
                    final /* synthetic */ ContactRemarkInfoModUI oGc;

                    {
                        this.oGc = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                    }
                });
                return;
            }
            ak.vy().a(new com.tencent.mm.an.b(contactRemarkInfoModUI.username, contactRemarkInfoModUI.oFK), 0);
            contactRemarkInfoModUI.getString(2131231164);
            contactRemarkInfoModUI.eLA = g.a((Context) contactRemarkInfoModUI, contactRemarkInfoModUI.getString(2131232014), false, null);
        }
    }

    private void adt() {
        boolean z;
        ProfileEditPhoneNumberView profileEditPhoneNumberView = this.oFV;
        ArrayList boL = profileEditPhoneNumberView.boL();
        if (boL.isEmpty()) {
            if (profileEditPhoneNumberView.lHt != null) {
                z = true;
            }
            z = false;
        } else if (profileEditPhoneNumberView.lHt == null) {
            z = true;
        } else if (boL.size() != profileEditPhoneNumberView.lHt.length) {
            z = true;
        } else {
            Iterator it = boL.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (!((String) it.next()).equals(profileEditPhoneNumberView.lHt[i])) {
                    z = true;
                    break;
                }
                i++;
            }
            z = false;
        }
        this.oGb = z;
        if (bHx() || bHy() || jV(false) || this.oGb) {
            iT(true);
        } else {
            iT(false);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ak.vy().a(575, (e) this);
        ak.vy().a(576, (e) this);
        this.hUa = getIntent().getIntExtra("Contact_Scene", 9);
        this.lQk = getIntent().getStringExtra("Contact_RoomNickname");
        this.oFO = getIntent().getBooleanExtra("view_mode", false);
        this.oFY = getIntent().getStringExtra("contact_auto_app_phone_from_chatting");
        this.oFW = getIntent().getStringExtra("contact_phone_number_by_md5");
        this.oFX = getIntent().getStringExtra("contact_phone_number_list");
        this.username = getIntent().getStringExtra("Contact_User");
        if (t.kS(this.username)) {
            finish();
            return;
        }
        ak.yW();
        this.euW = c.wH().LX(this.username);
        this.aGY = this.euW.field_conRemark;
        this.bCt = this.euW.bCt;
        this.cUH = this.euW.bCu;
        this.gRd = this.euW.field_contactLabelIds;
        this.oFU = com.tencent.mm.pluginsdk.j.a.bmu().vx(this.gRd);
        NI();
        adt();
    }

    public void onResume() {
        super.onResume();
        ak.yW();
        c.wH().a(this.oFZ);
        bHA();
    }

    protected void onPause() {
        ak.yW();
        c.wH().b(this.oFZ);
        super.onPause();
    }

    public void onDestroy() {
        ak.vy().b(575, (e) this);
        ak.vy().b(576, (e) this);
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return 2130903425;
    }

    private void q(boolean z, int i) {
        if (this.oFN) {
            this.oFA.setVisibility(8);
            if (z && t.kS(this.bCt)) {
                this.oFB.setVisibility(0);
                this.oFJ.setVisibility(8);
            } else if (i == 2131756527) {
                this.oFB.setVisibility(8);
                this.oFJ.setVisibility(0);
            }
            this.oFx.setVisibility(0);
            return;
        }
        this.oFA.setVisibility(0);
        this.oFB.setVisibility(0);
        this.oFx.setVisibility(8);
        this.oFJ.setVisibility(8);
    }

    protected final void NI() {
        boolean z;
        this.oFy = (TextView) findViewById(2131756514);
        this.oFA = (TextView) findViewById(2131756516);
        this.oFB = (TextView) findViewById(2131756527);
        this.oFC = (TextView) findViewById(2131756528);
        this.oFx = (MMClearEditText) findViewById(2131756515);
        this.oFz = (MMEditText) findViewById(2131756525);
        this.oFE = (ImageView) findViewById(2131756530);
        this.oFF = (ImageView) findViewById(2131756529);
        this.oFD = (TextView) findViewById(2131756526);
        this.oFJ = findViewById(2131756524);
        this.oFV = (ProfileEditPhoneNumberView) findViewById(2131756523);
        this.oFV.fnD = this.euW;
        ProfileEditPhoneNumberView profileEditPhoneNumberView = this.oFV;
        String str = this.oFW;
        String str2 = this.oFX;
        profileEditPhoneNumberView.lHr = str;
        profileEditPhoneNumberView.lHs = str2;
        profileEditPhoneNumberView.aGZ();
        this.oFV.lHw = new com.tencent.mm.pluginsdk.ui.ProfileEditPhoneNumberView.a(this) {
            final /* synthetic */ ContactRemarkInfoModUI oGc;

            {
                this.oGc = r1;
            }

            public final void Yj() {
                this.oGc.adt();
            }

            public final void boN() {
                m.p(this.oGc.euW);
                o.Ho().fP(7);
            }
        };
        this.oFR = (MMTagPanel) findViewById(2131756522);
        this.oFR.gjg = false;
        this.oFT = (ScrollView) findViewById(2131756513);
        this.oFS = (TextView) findViewById(2131756521);
        this.oFS.setText(2131233872);
        this.oFR.setOnClickListener(this.oFQ);
        this.oFS.setOnClickListener(this.oFQ);
        vD(2131232092);
        if (t.kS(this.aGY)) {
            this.oFx.setText(com.tencent.mm.pluginsdk.ui.d.e.a((Context) this, t.ma(this.euW.tT()), this.oFx.getTextSize()));
            this.oFA.setText(com.tencent.mm.pluginsdk.ui.d.e.a((Context) this, t.ma(this.euW.tT()), this.oFx.getTextSize()));
        } else {
            this.oFx.setText(com.tencent.mm.pluginsdk.ui.d.e.a((Context) this, t.ma(this.aGY), this.oFx.getTextSize()));
            this.oFA.setText(com.tencent.mm.pluginsdk.ui.d.e.a((Context) this, t.ma(this.aGY), this.oFA.getTextSize()));
        }
        this.oFz.setText(com.tencent.mm.pluginsdk.ui.d.e.a((Context) this, t.ma(this.bCt), this.oFB.getTextSize()));
        if (!t.kS(this.bCt)) {
            this.oFB.setText(com.tencent.mm.pluginsdk.ui.d.e.a((Context) this, t.ma(this.bCt), this.oFB.getTextSize()));
            this.oFB.setTextColor(getResources().getColor(2131689909));
        }
        this.oFA.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ContactRemarkInfoModUI oGc;

            {
                this.oGc = r1;
            }

            public final void onClick(View view) {
                this.oGc.oFN = true;
                this.oGc.q(false, view.getId());
                this.oGc.oFx.performClick();
                this.oGc.oFx.requestFocus();
                this.oGc.aJs();
            }
        });
        this.oFB.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ContactRemarkInfoModUI oGc;

            {
                this.oGc = r1;
            }

            public final void onClick(View view) {
                this.oGc.oFN = true;
                this.oGc.q(false, view.getId());
                this.oGc.oFz.performClick();
                this.oGc.oFz.requestFocus();
                this.oGc.aJs();
            }
        });
        this.oFx.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ ContactRemarkInfoModUI oGc;

            {
                this.oGc = r1;
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                this.oGc.adt();
            }
        });
        this.oFD.setText(h.aw(800, this.oFz.getEditableText().toString()));
        this.oFz.setOnFocusChangeListener(new OnFocusChangeListener(this) {
            final /* synthetic */ ContactRemarkInfoModUI oGc;

            {
                this.oGc = r1;
            }

            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    this.oGc.oFJ.setBackgroundResource(2130838423);
                } else {
                    this.oGc.oFJ.setBackgroundResource(2130838424);
                }
            }
        });
        this.oFz.addTextChangedListener(new b());
        if (t.kS(this.cUH)) {
            this.oFC.setVisibility(0);
            this.oFE.setVisibility(8);
        } else {
            this.oFC.setVisibility(8);
            this.oFE.setVisibility(0);
            com.tencent.mm.an.c.HV();
            if (com.tencent.mm.an.c.jx(this.username)) {
                bHt();
            } else {
                com.tencent.mm.an.c.HV().a(this.username, this.cUH, new com.tencent.mm.an.c.a(this) {
                    final /* synthetic */ ContactRemarkInfoModUI oGc;

                    {
                        this.oGc = r1;
                    }

                    public final void bd(final boolean z) {
                        this.oGc.oFE.post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass6 oGd;

                            public final void run() {
                                if (z) {
                                    this.oGd.oGc.bHt();
                                    return;
                                }
                                g.bf(this.oGd.oGc, this.oGd.oGc.getString(2131231042));
                                this.oGd.oGc.oFF.setVisibility(0);
                                this.oGd.oGc.oFC.setVisibility(8);
                                this.oGd.oGc.oFE.setVisibility(8);
                            }
                        });
                    }
                });
            }
        }
        this.oFE.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ContactRemarkInfoModUI oGc;

            {
                this.oGc = r1;
            }

            public final void onClick(View view) {
                if (this.oGc.oFL) {
                    String o;
                    this.oGc.bHs();
                    Intent intent = new Intent(this.oGc, ContactRemarkImagePreviewUI.class);
                    intent.putExtra("Contact_User", this.oGc.username);
                    if (t.kS(this.oGc.cUH) || this.oGc.oFM) {
                        o = this.oGc.oFK;
                    } else {
                        com.tencent.mm.an.c.HV();
                        o = com.tencent.mm.an.c.jw(this.oGc.username);
                    }
                    intent.putExtra("remark_image_path", o);
                    intent.putExtra("view_temp_remark_image", this.oGc.oFM);
                    this.oGc.startActivityForResult(intent, 400);
                }
            }
        });
        this.oFC.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ContactRemarkInfoModUI oGc;

            {
                this.oGc = r1;
            }

            public final void onClick(View view) {
                if (t.kS(this.oGc.cUH) || this.oGc.oFP) {
                    ContactRemarkInfoModUI.a(this.oGc, false);
                    this.oGc.bHs();
                }
            }
        });
        final com.tencent.mm.modelfriend.b iA = ah.FL().iA(this.euW.field_username);
        if (iA == null || t.kS(iA.ED()) || iA.ED().equals(this.oFx.getText().toString())) {
            z = false;
        } else {
            this.oFG = (TextView) findViewById(2131756518);
            this.oFH = findViewById(2131756517);
            this.oFI = (Button) findViewById(2131756519);
            this.oFH.setVisibility(0);
            this.oFG.setText(getString(2131232161, new Object[]{iA.ED()}));
            this.oFI.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ ContactRemarkInfoModUI oGc;

                public final void onClick(View view) {
                    this.oGc.oFN = true;
                    this.oGc.q(true, -1);
                    this.oGc.oFx.setText(iA.ED());
                    this.oGc.oFx.setSelection(this.oGc.oFx.getText().length());
                    this.oGc.oFH.setVisibility(8);
                }
            });
            z = true;
        }
        if (!(z || this.hUa != 14 || t.kS(this.lQk) || this.lQk.equals(this.oFx.getText().toString()))) {
            this.oFG = (TextView) findViewById(2131756518);
            this.oFH = findViewById(2131756517);
            this.oFI = (Button) findViewById(2131756519);
            this.oFH.setVisibility(0);
            this.oFG.setText(com.tencent.mm.pluginsdk.ui.d.e.a((Context) this, t.ma(getString(2131232160, new Object[]{this.lQk})), this.oFG.getTextSize()));
            this.oFI.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ ContactRemarkInfoModUI oGc;

                {
                    this.oGc = r1;
                }

                public final void onClick(View view) {
                    this.oGc.oFN = true;
                    this.oGc.q(true, -1);
                    this.oGc.oFx.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this.oGc, t.ma(this.oGc.lQk), this.oGc.oFx.getTextSize()));
                    this.oGc.oFx.setSelection(this.oGc.oFx.getText().length());
                    this.oGc.oFH.setVisibility(8);
                }
            });
        }
        a(0, getString(2131231065), new OnMenuItemClickListener(this) {
            final /* synthetic */ ContactRemarkInfoModUI oGc;

            {
                this.oGc = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                ContactRemarkInfoModUI.q(this.oGc);
                this.oGc.axg();
                return false;
            }
        }, com.tencent.mm.ui.k.b.nET);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ContactRemarkInfoModUI oGc;

            {
                this.oGc = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.oGc.goBack();
                return true;
            }
        });
        if (t.kS(this.aGY)) {
            iT(true);
        } else {
            iT(false);
        }
        this.oFF.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ContactRemarkInfoModUI oGc;

            {
                this.oGc = r1;
            }

            public final void onClick(View view) {
                ContactRemarkInfoModUI.a(this.oGc, true);
                this.oGc.bHs();
            }
        });
        if (!this.oFO) {
            this.oFN = true;
            q(true, -1);
        }
        bHs();
    }

    private void bHs() {
        this.oFy.setFocusableInTouchMode(true);
        this.oFy.requestFocus();
        this.oFx.clearFocus();
        this.oFz.clearFocus();
        this.oFV.clearFocus();
        axg();
    }

    private void bHt() {
        Bitmap jz = com.tencent.mm.an.c.HV().jz(this.username);
        if (jz != null) {
            this.oFC.setVisibility(8);
            this.oFF.setVisibility(8);
            this.oFE.setVisibility(0);
            this.oFE.setImageBitmap(jz);
        }
        this.oFL = true;
    }

    private void Pf(String str) {
        if (!t.kS(str)) {
            File file = new File(str);
            if (!file.exists()) {
                return;
            }
            if (file.length() > 204800) {
                g.A(this, getString(2131232012), null);
                return;
            }
            Bitmap c = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.c(this.oFK, com.tencent.mm.bd.a.getDensity(this));
            if (c != null) {
                this.oFC.setVisibility(8);
                this.oFF.setVisibility(8);
                this.oFE.setVisibility(0);
                this.oFE.setImageBitmap(c);
                this.oFL = true;
            }
        }
    }

    private boolean bHu() {
        String obj = this.oFx.getText().toString();
        v.i("MiroMsg.ContactRemarkInfoModUI", "Set New RemarkName : " + obj + ", Report kvStat, addContactScene = " + this.hUa);
        com.tencent.mm.plugin.report.service.g.iuh.h(10448, Integer.valueOf(this.hUa));
        switch (this.euW.bbT) {
            case 10:
            case 11:
            case 13:
                com.tencent.mm.modelfriend.b iA = ah.FL().iA(this.euW.field_username);
                if (!(iA == null || t.kS(iA.ED()))) {
                    if (t.kS(obj)) {
                        iA.EM();
                    } else {
                        iA.EL();
                    }
                    ah.FL().a(iA.EB(), iA);
                    break;
                }
        }
        ak.yW();
        ba Nw = c.wI().Nw(this.euW.field_username);
        if ((Nw == null || t.kS(Nw.field_encryptUsername)) && !t.kS(this.euW.field_encryptUsername)) {
            ak.yW();
            Nw = c.wI().Nw(this.euW.field_encryptUsername);
        }
        if (!(Nw == null || t.kS(Nw.field_encryptUsername))) {
            ak.yW();
            c.wI().Nx(Nw.field_encryptUsername);
        }
        if (jV(false)) {
            this.aGY = obj;
            v.i("MiroMsg.ContactRemarkInfoModUI", "usernamne %s operationSetRemark %s", this.euW.field_username, obj);
            m.b(this.euW, obj);
            return true;
        }
        v.i("MiroMsg.ContactRemarkInfoModUI", "remarkNameChanged", Boolean.valueOf(jV(false)));
        return false;
    }

    private boolean bHv() {
        if (!bHx()) {
            return false;
        }
        String obj = this.oFz.getText().toString();
        this.bCt = obj;
        com.tencent.mm.ba.a com_tencent_mm_protocal_c_ait = new ait();
        com_tencent_mm_protocal_c_ait.mJq = this.username;
        com_tencent_mm_protocal_c_ait.gkC = obj;
        ak.yW();
        c.wG().b(new com.tencent.mm.ak.j.a(54, com_tencent_mm_protocal_c_ait));
        return true;
    }

    private void bHw() {
        if (this.oGb) {
            String str;
            com.tencent.mm.ba.a com_tencent_mm_protocal_c_aje = new aje();
            com_tencent_mm_protocal_c_aje.mJq = this.username;
            ams com_tencent_mm_protocal_c_ams = new ams();
            ArrayList boL = this.oFV.boL();
            com_tencent_mm_protocal_c_ams.eet = boL.size();
            com_tencent_mm_protocal_c_ams.mNk = new LinkedList();
            Iterator it = boL.iterator();
            while (it.hasNext()) {
                str = (String) it.next();
                amr com_tencent_mm_protocal_c_amr = new amr();
                com_tencent_mm_protocal_c_amr.mNj = str;
                com_tencent_mm_protocal_c_ams.mNk.add(com_tencent_mm_protocal_c_amr);
            }
            com_tencent_mm_protocal_c_aje.mJo = com_tencent_mm_protocal_c_ams;
            ak.yW();
            c.wG().b(new com.tencent.mm.ak.j.a(60, com_tencent_mm_protocal_c_aje));
            ak.yW();
            ab LX = c.wH().LX(this.username);
            if (LX != null && ((int) LX.chr) > 0 && com.tencent.mm.i.a.ei(LX.field_type)) {
                str = SQLiteDatabase.KeyEmpty;
                Iterator it2 = boL.iterator();
                String str2 = str;
                while (it2.hasNext()) {
                    str2 = (str2 + ((String) it2.next())) + ",";
                }
                this.euW.cs(str2);
                ak.yW();
                c.wH().M(this.euW);
            }
            finish();
        }
    }

    private boolean jV(boolean z) {
        String obj = this.oFx.getText().toString();
        if (z) {
            boolean z2;
            if ((this.aGY == null || !this.aGY.equals(obj)) && !(t.kS(this.aGY) && t.kS(obj))) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2 || (obj != null && obj.equals(this.euW.field_nickname))) {
                return false;
            }
            return true;
        } else if ((this.aGY == null || !this.aGY.equals(obj)) && (!t.kS(this.aGY) || !t.kS(obj))) {
            return true;
        } else {
            return false;
        }
    }

    private boolean bHx() {
        String obj = this.oFz.getText().toString();
        return (this.bCt == null || !this.bCt.equals(obj)) && !(t.kS(this.bCt) && t.kS(obj));
    }

    private boolean bHy() {
        return !t.kS(this.oFK) || this.oFP;
    }

    private void goBack() {
        boolean bHy = bHy();
        boolean jV = jV(true);
        boolean bHx = bHx();
        if (bHy || jV || bHx) {
            g.b((Context) this, getString(2131232139), null, getString(2131232141), getString(2131232140), new DialogInterface.OnClickListener(this) {
                final /* synthetic */ ContactRemarkInfoModUI oGc;

                {
                    this.oGc = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    ContactRemarkInfoModUI.q(this.oGc);
                }
            }, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ ContactRemarkInfoModUI oGc;

                {
                    this.oGc = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.oGc.finish();
                }
            });
            return;
        }
        axg();
        finish();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4) {
            return false;
        }
        goBack();
        return true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        v.i("MiroMsg.ContactRemarkInfoModUI", "onAcvityResult requestCode:%d, resultCode:%d", Integer.valueOf(i), Integer.valueOf(i2));
        if (intent == null) {
            v.e("MiroMsg.ContactRemarkInfoModUI", "data shouldnot be null");
            return;
        }
        Context applicationContext;
        String a;
        switch (i) {
            case 100:
                applicationContext = getApplicationContext();
                ak.yW();
                a = l.a(applicationContext, intent, c.wP());
                if (a != null) {
                    this.oFK = Pg(a);
                    Pf(this.oFK);
                    this.oFM = true;
                    this.oFP = false;
                    adt();
                    return;
                }
                return;
            case 200:
                applicationContext = getApplicationContext();
                ak.yW();
                a = com.tencent.mm.ui.tools.a.b(applicationContext, intent, c.wP());
                if (a != null) {
                    this.oFK = Pg(a);
                    Pf(this.oFK);
                    this.oFM = true;
                    this.oFP = false;
                    adt();
                    return;
                }
                return;
            case 400:
                if (intent.getBooleanExtra("response_delete", false)) {
                    bHz();
                    return;
                }
                return;
            case 600:
                if (jV(true) || bHx() || bHy() || intent.getBooleanExtra("hasLableChange", false)) {
                    iT(true);
                    return;
                } else {
                    iT(false);
                    return;
                }
            default:
                return;
        }
    }

    private void bHz() {
        this.oFP = true;
        this.oFF.setVisibility(8);
        this.oFC.setVisibility(0);
        this.oFE.setVisibility(8);
        this.oFE.setImageBitmap(null);
        adt();
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MiroMsg.ContactRemarkInfoModUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.eLA != null) {
            this.eLA.dismiss();
            this.eLA = null;
        }
        if (i == 0 && i2 == 0) {
            if (kVar.getType() == 575) {
                if (this.oFK != null) {
                    File file = new File(this.oFK);
                    if (file.exists()) {
                        com.tencent.mm.an.c.HV();
                        file.renameTo(new File(com.tencent.mm.an.c.jw(this.username)));
                    }
                }
                String str2 = ((com.tencent.mm.an.b) kVar).cUH;
                if (!t.kS(str2)) {
                    this.cUH = str2;
                }
            } else if (kVar.getType() == 576) {
                this.oFK = null;
                this.cUH = null;
                this.oFL = false;
                ak.yW();
                this.euW = c.wH().LX(this.username);
                this.euW.cn(SQLiteDatabase.KeyEmpty);
                ak.yW();
                c.wH().a(this.username, this.euW);
            }
            bHu();
            bHv();
            bHw();
            ab(this.aGY, this.bCt, this.cUH);
            finish();
            return;
        }
        g.A(this, getString(2131231041), null);
    }

    private void ab(String str, String str2, String str3) {
        ak.yW();
        ab LX = c.wH().LX(this.username);
        if (LX != null && ((int) LX.chr) > 0 && com.tencent.mm.i.a.ei(LX.field_type)) {
            this.euW.bQ(str);
            this.euW.cm(str2);
            this.euW.cn(str3);
            this.euW.tQ();
            ak.yW();
            c.wH().M(this.euW);
            com.tencent.mm.sdk.c.a.nhr.z(new pw());
        }
    }

    private String Pg(String str) {
        if (!com.tencent.mm.a.e.aR(str)) {
            return null;
        }
        int JQ = ExifHelper.JQ(str);
        StringBuilder stringBuilder = new StringBuilder();
        com.tencent.mm.an.c.HV();
        String stringBuilder2 = stringBuilder.append(com.tencent.mm.an.c.jw(this.username)).append(".tmp").toString();
        if (!d.a(str, 960, 960, CompressFormat.JPEG, 70, stringBuilder2)) {
            v.e("MiroMsg.ContactRemarkInfoModUI", "createThumbNail big pic fail");
            return null;
        } else if (JQ == 0 || d.a(stringBuilder2, JQ, CompressFormat.JPEG, 70, stringBuilder2)) {
            return stringBuilder2;
        } else {
            v.e("MiroMsg.ContactRemarkInfoModUI", "rotate big pic fail");
            return null;
        }
    }

    private void bHA() {
        ak.yW();
        this.euW = c.wH().LX(this.username);
        this.gRd = this.euW.field_contactLabelIds;
        this.oFU = com.tencent.mm.pluginsdk.j.a.bmu().vx(this.gRd);
        if (t.kS(this.gRd)) {
            this.oFR.setVisibility(8);
            this.oFS.setVisibility(0);
            return;
        }
        this.oFR.setVisibility(0);
        this.oFS.setVisibility(8);
        this.oFR.a(this.oFU, this.oFU);
    }
}
