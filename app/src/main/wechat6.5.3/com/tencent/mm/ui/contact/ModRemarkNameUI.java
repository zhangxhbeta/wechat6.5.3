package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.e.a.pw;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.modelfriend.ah;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.air;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.tools.h;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;

public class ModRemarkNameUI extends MMActivity implements e {
    private String ble;
    private u euW;
    private String gxy = SQLiteDatabase.KeyEmpty;
    private String hUS;
    private int hUa = 9;
    private ArrayList<String> hUk;
    private ba ijf;
    private TextView oFG;
    private View oFH;
    private Button oFI;
    private View oFJ;
    private MMTagPanel oFR;
    private TextView oFS;
    private EditText oHR;
    private int oHS;
    private String oHT = SQLiteDatabase.KeyEmpty;
    private TextView oHU = null;
    private EditText oHV = null;
    private TextView oHW = null;
    private String oHX = SQLiteDatabase.KeyEmpty;
    private boolean oHY = false;
    private a oHZ = new a();
    private View oIa;

    private class a implements OnClickListener {
        final /* synthetic */ ModRemarkNameUI oIb;

        private a(ModRemarkNameUI modRemarkNameUI) {
            this.oIb = modRemarkNameUI;
        }

        public final void onClick(View view) {
            ModRemarkNameUI.n(this.oIb);
        }
    }

    private class b implements TextWatcher {
        private int iJG;
        final /* synthetic */ ModRemarkNameUI oIb;

        private b(ModRemarkNameUI modRemarkNameUI) {
            this.oIb = modRemarkNameUI;
            this.iJG = 800;
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
            if (this.oIb.oHW != null) {
                this.oIb.oHW.setText(this.iJG);
            }
            ModRemarkNameUI.m(this.oIb);
        }
    }

    static /* synthetic */ void c(ModRemarkNameUI modRemarkNameUI) {
        if (!ak.uz()) {
            v.e("MiroMsg.ModRemarkName", "!MMCore.hasSetUin()");
        } else if (modRemarkNameUI.oHR == null) {
            v.e("MiroMsg.ModRemarkName", "remarkName == null in dealModNickName(), return");
        } else {
            String trim = modRemarkNameUI.oHR.getText().toString().trim();
            v.i("MiroMsg.ModRemarkName", "Set New RemarkName : " + trim + ", Report kvStat, addContactScene = " + modRemarkNameUI.hUa);
            g.iuh.h(10448, Integer.valueOf(modRemarkNameUI.hUa));
            ba baVar;
            if (modRemarkNameUI.oHY) {
                modRemarkNameUI.euW.bQ(trim);
                baVar = new ba(modRemarkNameUI.euW.field_username, trim);
                baVar.field_conDescription = modRemarkNameUI.oHV.getText().toString().trim();
                if (!t.kS(modRemarkNameUI.hUS)) {
                    baVar.field_contactLabels = modRemarkNameUI.hUS;
                }
                ak.yW();
                c.wI().c(baVar);
            } else {
                switch (modRemarkNameUI.euW.bbT) {
                    case 10:
                    case 11:
                    case 13:
                        com.tencent.mm.modelfriend.b iA = ah.FL().iA(modRemarkNameUI.euW.field_username);
                        if (!(iA == null || t.kS(iA.ED()))) {
                            if (t.kS(trim)) {
                                iA.EM();
                            } else {
                                iA.EL();
                            }
                            ah.FL().a(iA.EB(), iA);
                            break;
                        }
                }
                ak.yW();
                baVar = c.wI().Nw(modRemarkNameUI.euW.field_username);
                if ((baVar == null || t.kS(baVar.field_encryptUsername)) && !t.kS(modRemarkNameUI.euW.field_encryptUsername)) {
                    ak.yW();
                    baVar = c.wI().Nw(modRemarkNameUI.euW.field_encryptUsername);
                }
                if (!(baVar == null || t.kS(baVar.field_encryptUsername))) {
                    ak.yW();
                    c.wI().Nx(baVar.field_encryptUsername);
                }
                m.b(modRemarkNameUI.euW, trim);
                modRemarkNameUI.jX(true);
            }
            modRemarkNameUI.finish();
        }
    }

    static /* synthetic */ void d(ModRemarkNameUI modRemarkNameUI) {
        String trim = modRemarkNameUI.oHR.getText().toString().trim();
        if (trim.length() > 50) {
            com.tencent.mm.ui.base.g.a(modRemarkNameUI.nDR.nEl, modRemarkNameUI.getString(2131234572), modRemarkNameUI.getString(2131234665), modRemarkNameUI.getString(2131231010), null);
        } else if (trim.length() == 0) {
            com.tencent.mm.ui.base.g.a(modRemarkNameUI.nDR.nEl, modRemarkNameUI.getString(2131234574), modRemarkNameUI.getString(2131234665), modRemarkNameUI.getString(2131231010), null);
        } else {
            modRemarkNameUI.euW.bS(trim);
            com.tencent.mm.ba.a com_tencent_mm_protocal_c_air = new air();
            com_tencent_mm_protocal_c_air.mbC = new arf().JF(t.ma(modRemarkNameUI.ble));
            com_tencent_mm_protocal_c_air.mIW = new arf().JF(t.ma(trim));
            ak.yW();
            c.wG().b(new com.tencent.mm.ak.j.a(27, com_tencent_mm_protocal_c_air));
            modRemarkNameUI.jX(true);
            modRemarkNameUI.finish();
            com.tencent.mm.sdk.c.a.nhr.z(new pw());
        }
    }

    static /* synthetic */ void e(ModRemarkNameUI modRemarkNameUI) {
        String trim = modRemarkNameUI.oHR.getText().toString().trim();
        v.d("MiroMsg.ModRemarkName", "contact id " + modRemarkNameUI.euW.field_username + " " + modRemarkNameUI.euW.field_type + " isContact " + com.tencent.mm.i.a.ei(modRemarkNameUI.euW.field_type));
        if (trim.length() > 50) {
            v.d("MiroMsg.ModRemarkName", "newName.length" + trim.length());
            com.tencent.mm.ui.base.g.f(modRemarkNameUI, 2131234656, 2131234665);
        } else if (com.tencent.mm.i.a.ei(modRemarkNameUI.euW.field_type)) {
            com.tencent.mm.ui.base.g.f(modRemarkNameUI, 2131234658, 2131234665);
        } else {
            modRemarkNameUI.euW.bS(trim);
            com.tencent.mm.ba.a com_tencent_mm_protocal_c_air = new air();
            com_tencent_mm_protocal_c_air.mbC = new arf().JF(t.ma(modRemarkNameUI.euW.field_username));
            com_tencent_mm_protocal_c_air.mIW = new arf().JF(t.ma(trim));
            ak.yW();
            c.wG().b(new com.tencent.mm.ak.j.a(27, com_tencent_mm_protocal_c_air));
            m.o(modRemarkNameUI.euW);
            modRemarkNameUI.jX(false);
            modRemarkNameUI.finish();
        }
    }

    static /* synthetic */ void f(ModRemarkNameUI modRemarkNameUI) {
        String trim = modRemarkNameUI.oHR.getText().toString().trim();
        Intent intent = new Intent();
        intent.putExtra("k_sns_tag_name", trim);
        modRemarkNameUI.setResult(-1, intent);
        modRemarkNameUI.finish();
    }

    static /* synthetic */ void g(ModRemarkNameUI modRemarkNameUI) {
        String trim = modRemarkNameUI.oHR.getText().toString().trim();
        if (trim.length() > 50) {
            com.tencent.mm.ui.base.g.a(modRemarkNameUI.nDR.nEl, modRemarkNameUI.getString(2131234573), modRemarkNameUI.getString(2131234665), modRemarkNameUI.getString(2131231010), null);
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Contact_Nick", trim);
        modRemarkNameUI.setResult(-1, intent);
        modRemarkNameUI.finish();
        com.tencent.mm.sdk.c.a.nhr.z(new pw());
    }

    static /* synthetic */ void m(ModRemarkNameUI modRemarkNameUI) {
        String trim = modRemarkNameUI.oHV.getText().toString().trim();
        boolean z = (modRemarkNameUI.oHX == null || !modRemarkNameUI.oHX.equals(trim)) && !(t.kS(modRemarkNameUI.oHX) && t.kS(trim));
        if (!z) {
            trim = modRemarkNameUI.oHR.getText().toString().trim();
            z = (modRemarkNameUI.oHR == null || !modRemarkNameUI.oHR.equals(trim)) && !(t.kS(modRemarkNameUI.gxy) && t.kS(trim));
            if (!z) {
                modRemarkNameUI.iT(false);
                return;
            }
        }
        modRemarkNameUI.iT(true);
    }

    static /* synthetic */ void n(ModRemarkNameUI modRemarkNameUI) {
        Intent intent = new Intent();
        if (modRemarkNameUI.hUk != null) {
            intent.putStringArrayListExtra("label_str_list", modRemarkNameUI.hUk);
        }
        intent.putExtra("is_stranger", true);
        intent.putExtra("label_username", modRemarkNameUI.ble);
        com.tencent.mm.ay.c.b((Context) modRemarkNameUI, "label", ".ui.ContactLabelUI", intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hUa = getIntent().getIntExtra("Contact_Scene", 9);
        this.oHS = getIntent().getIntExtra("Contact_mode_name_type", 0);
        this.oHT = t.ma(getIntent().getStringExtra("Contact_Nick"));
        this.gxy = t.ma(getIntent().getStringExtra("Contact_RemarkName"));
        this.oHY = getIntent().getBooleanExtra("Contact_ModStrangerRemark", false);
        NI();
        this.oIa = findViewById(2131758328);
        if (this.oHS != 0) {
            this.oIa.setVisibility(8);
        } else {
            this.oIa.setVisibility(0);
        }
        this.oFR = (MMTagPanel) findViewById(2131756522);
        this.oFR.gjg = false;
        this.oFS = (TextView) findViewById(2131756521);
        this.oFS.setText(2131233872);
        this.oFR.setOnClickListener(this.oHZ);
        this.oFS.setOnClickListener(this.oHZ);
    }

    protected final int getLayoutId() {
        return 2130904091;
    }

    protected final void NI() {
        this.ble = getIntent().getStringExtra("Contact_User");
        if (this.ble != null && this.ble.length() > 0) {
            ak.yW();
            this.euW = c.wH().LX(this.ble);
            ak.yW();
            this.ijf = c.wI().Nw(this.ble);
            if (this.euW == null || t.kS(this.euW.field_username)) {
                this.euW = new u(this.ble);
                this.euW.bS(t.ma(this.oHT));
                this.euW.bQ(t.ma(this.gxy));
            }
        }
        this.oHR = (EditText) findViewById(2131756515);
        com.tencent.mm.ui.widget.MMEditText.b anonymousClass1 = new com.tencent.mm.ui.widget.MMEditText.b(this) {
            final /* synthetic */ ModRemarkNameUI oIb;

            {
                this.oIb = r1;
            }

            public final void aKK() {
                if (this.oIb.oHR.getText().toString().trim().length() > 0) {
                    this.oIb.iT(true);
                } else if (this.oIb.oHS != 0) {
                    this.oIb.iT(false);
                }
            }
        };
        TextWatcher aVar;
        if (this.oHS == 1 || this.oHS == 2 || this.oHS == 3) {
            aVar = new com.tencent.mm.pluginsdk.ui.tools.i.a();
            aVar.lTS = anonymousClass1;
            this.oHR.addTextChangedListener(aVar);
        } else {
            aVar = new com.tencent.mm.pluginsdk.ui.tools.i.a();
            aVar.lTS = anonymousClass1;
            this.oHR.addTextChangedListener(aVar);
        }
        com.tencent.mm.ui.tools.a.c.b(this.oHR).yn(100).a(null);
        if (!(this.euW == null || this.oHS == 3)) {
            if (this.oHS == 4) {
                this.oHR.setText(com.tencent.mm.pluginsdk.ui.d.e.a((Context) this, t.ma(this.oHT), this.oHR.getTextSize()));
            } else if (!t.kS(this.euW.field_conRemark)) {
                this.oHR.setText(com.tencent.mm.pluginsdk.ui.d.e.a((Context) this, t.ma(this.euW.field_conRemark), this.oHR.getTextSize()));
            } else if (!t.kS(this.gxy)) {
                this.oHR.setText(com.tencent.mm.pluginsdk.ui.d.e.a((Context) this, t.ma(this.gxy), this.oHR.getTextSize()));
            } else if (!t.kS(this.euW.field_nickname)) {
                this.oHR.setText(com.tencent.mm.pluginsdk.ui.d.e.a((Context) this, t.ma(this.euW.field_nickname), this.oHR.getTextSize()));
            } else if (t.kS(this.oHT)) {
                boolean z;
                String str = this.euW.field_nickname;
                if (t.kS(str) || str.length() > 50) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    this.oHR.setText(com.tencent.mm.pluginsdk.ui.d.e.a((Context) this, t.ma(this.euW.tU()), this.oHR.getTextSize()));
                } else {
                    this.oHR.setText(SQLiteDatabase.KeyEmpty);
                }
            } else {
                this.oHR.setText(com.tencent.mm.pluginsdk.ui.d.e.a((Context) this, t.ma(this.oHT), this.oHR.getTextSize()));
            }
            this.oHR.setSelection(this.oHR.getText().length());
        }
        if (this.oHS == 0) {
            vD(2131232093);
            final com.tencent.mm.modelfriend.b iA = ah.FL().iA(this.euW.field_username);
            if (!(iA == null || t.kS(iA.ED()) || iA.ED().equals(this.oHR.getText()))) {
                this.oFG = (TextView) findViewById(2131756518);
                this.oFH = findViewById(2131756517);
                this.oFI = (Button) findViewById(2131756519);
                this.oFH.setVisibility(0);
                this.oFG.setText(getString(2131232161, new Object[]{iA.ED()}));
                this.oFI.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ ModRemarkNameUI oIb;

                    public final void onClick(View view) {
                        this.oIb.oHR.setText(iA.ED());
                        this.oIb.oHR.setSelection(this.oIb.oHR.getText().length());
                        this.oIb.oFH.setVisibility(8);
                    }
                });
            }
        } else if (this.oHS == 1) {
            vD(2131234625);
            this.oHR.setHint(SQLiteDatabase.KeyEmpty);
            r0 = (TextView) findViewById(2131756514);
            r0.setText(SQLiteDatabase.KeyEmpty);
            r0.setVisibility(0);
        } else if (this.oHS == 2) {
            vD(2131234654);
            this.oHR.setHint(SQLiteDatabase.KeyEmpty);
        } else if (this.oHS == 3) {
            vD(2131235538);
            this.oHR.setHint(SQLiteDatabase.KeyEmpty);
            r0 = (TextView) findViewById(2131756514);
            r0.setText(2131234930);
            r0.setVisibility(0);
        } else if (this.oHS == 4) {
            vD(2131234623);
            this.oHR.setHint(SQLiteDatabase.KeyEmpty);
            r0 = (TextView) findViewById(2131756514);
            r0.setText(2131234663);
            r0.setVisibility(0);
        }
        a(0, getString(2131231146), new OnMenuItemClickListener(this) {
            final /* synthetic */ ModRemarkNameUI oIb;

            {
                this.oIb = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                switch (this.oIb.oHS) {
                    case 0:
                        ModRemarkNameUI.c(this.oIb);
                        break;
                    case 1:
                        ModRemarkNameUI.d(this.oIb);
                        break;
                    case 2:
                        ModRemarkNameUI.e(this.oIb);
                        break;
                    case 3:
                        ModRemarkNameUI.f(this.oIb);
                        break;
                    case 4:
                        break;
                }
                ModRemarkNameUI.g(this.oIb);
                return true;
            }
        });
        if (this.oHR == null || this.oHR.getText().toString().trim().length() <= 0) {
            iT(false);
        } else {
            iT(true);
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ModRemarkNameUI oIb;

            {
                this.oIb = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.oIb.finish();
                return true;
            }
        });
        this.oHU = (TextView) findViewById(2131756527);
        this.oHV = (EditText) findViewById(2131756525);
        this.oHW = (TextView) findViewById(2131756526);
        this.oFJ = findViewById(2131756524);
        com.tencent.mm.ui.tools.a.c.b(this.oHV).yn(800).a(null);
        this.oHW.setText(h.aw(800, this.oHV.getEditableText().toString()));
        this.oHV.append(com.tencent.mm.pluginsdk.ui.d.e.a((Context) this, t.ma(this.oHX), this.oHV.getTextSize()));
        this.oHU.append(com.tencent.mm.pluginsdk.ui.d.e.a((Context) this, t.ma(this.oHX), this.oHU.getTextSize()));
        if (this.ijf != null) {
            this.oHV.setText(com.tencent.mm.pluginsdk.ui.d.e.a((Context) this, t.ma(this.ijf.field_conDescription), this.oHV.getTextSize()));
            this.oHU.setText(com.tencent.mm.pluginsdk.ui.d.e.a((Context) this, t.ma(this.ijf.field_conDescription), this.oHV.getTextSize()));
        }
        this.oHV.addTextChangedListener(new b());
        this.oHU.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ModRemarkNameUI oIb;

            {
                this.oIb = r1;
            }

            public final void onClick(View view) {
                this.oIb.oFJ.setVisibility(0);
                this.oIb.oHU.setVisibility(8);
                this.oIb.oHV.requestFocus();
                this.oIb.aJs();
            }
        });
    }

    protected void onResume() {
        super.onResume();
        ak.yW();
        this.ijf = c.wI().Nw(this.ble);
        if (this.ijf != null) {
            this.hUS = this.ijf.field_contactLabels;
            this.hUk = (ArrayList) com.tencent.mm.pluginsdk.j.a.bmu().vw(this.hUS);
        }
        if (t.kS(this.hUS)) {
            this.oFR.setVisibility(8);
            this.oFS.setVisibility(0);
            return;
        }
        this.oFR.setVisibility(0);
        this.oFS.setVisibility(8);
        if (this.hUk != null && !this.hUk.isEmpty()) {
            this.oFR.a(this.hUk, this.hUk);
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MiroMsg.ModRemarkName", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (kVar.getType() == 44) {
            if (i != 0 && i2 < 0) {
                v.d("MiroMsg.ModRemarkName", "addRoomCard Error!");
                Toast.makeText(this, getString(2131234655, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            }
            finish();
        }
    }

    private void jX(boolean z) {
        if (z && this.euW != null) {
            ak.yW();
            c.wH().M(this.euW);
        }
    }
}
