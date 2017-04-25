package com.tencent.mm.pluginsdk.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import com.tencent.mm.e.a.qc;
import com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.mm.plugin.report.kvdata.log_13905;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.k.b;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;

@a(3)
public class VoiceInputUI extends MMActivity {
    private MMEditText lIG;
    private long lII = 0;
    private boolean lIJ = true;
    private boolean lIK = false;
    private OnTouchListener lIL = new OnTouchListener(this) {
        final /* synthetic */ VoiceInputUI lIN;

        {
            this.lIN = r1;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                this.lIN.textChangeCount = this.lIN.textChangeCount + 1;
                this.lIN.lIG.requestFocus();
            }
            return false;
        }
    };
    private OnMenuItemClickListener lIM = new OnMenuItemClickListener(this) {
        final /* synthetic */ VoiceInputUI lIN;

        {
            this.lIN = r1;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            if (this.lIN.lIK) {
                this.lIN.tQ(4);
            } else {
                this.lIN.tQ(5);
            }
            return true;
        }
    };
    private String lcr;
    private int offset;
    private Button pQQ;
    private int textChangeCount = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(FileUtils.S_IWUSR);
        Intent intent = getIntent();
        if (intent != null) {
            this.lcr = intent.getStringExtra("text");
            this.offset = intent.getIntExtra("offset", -1);
        }
        this.lII = System.currentTimeMillis();
        this.textChangeCount = 0;
        this.lIK = false;
        this.lIJ = true;
        this.lIG = (MMEditText) findViewById(2131760114);
        this.pQQ = (Button) findViewById(2131760113);
        this.lIG.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ VoiceInputUI lIN;

            {
                this.lIN = r1;
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                v.d("VoiceInputUI", "afterTextChanged firstTextChange:%s,textChange:%s", Boolean.valueOf(this.lIN.lIJ), Boolean.valueOf(this.lIN.lIK));
                if (this.lIN.lIJ) {
                    this.lIN.lIJ = false;
                    return;
                }
                if (!this.lIN.lIK) {
                    this.lIN.iT(true);
                }
                this.lIN.lIK = true;
            }
        });
        this.pQQ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ VoiceInputUI lIN;

            {
                this.lIN = r1;
            }

            public final void onClick(View view) {
                this.lIN.lIG.setText(SQLiteDatabase.KeyEmpty);
                this.lIN.lIK = true;
                this.lIN.tQ(6);
            }
        });
        Fd(getString(2131235814));
        a(0, getString(2131231065), this.lIM, b.nET);
        iT(false);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ VoiceInputUI lIN;

            {
                this.lIN = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.lIN.tQ(1);
                return true;
            }
        });
        this.lIG.setOnTouchListener(this.lIL);
        this.lIG.PL(this.lcr);
        if (this.offset != -1) {
            this.lIG.setSelection(this.offset);
        }
    }

    protected void onResume() {
        super.onResume();
        this.lIG.requestFocus();
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return 2130904583;
    }

    public final void Rj() {
        tQ(3);
        super.Rj();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            tQ(2);
        }
        return super.onKeyDown(i, keyEvent);
    }

    public final void tQ(int i) {
        com.tencent.mm.ba.a com_tencent_mm_plugin_report_kvdata_log_13905 = new log_13905();
        VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
        voiceInputBehavior.textChangeCount = this.textChangeCount;
        voiceInputBehavior.textChangeReturn = i;
        if (this.lII != 0) {
            voiceInputBehavior.textChangeTime = System.currentTimeMillis() - this.lII;
        }
        com_tencent_mm_plugin_report_kvdata_log_13905.viOp_ = voiceInputBehavior;
        g.iuh.a(13905, com_tencent_mm_plugin_report_kvdata_log_13905);
        v.i("VoiceInputUI", "report cancel = " + voiceInputBehavior.cancel + " send = " + voiceInputBehavior.send + " click = " + voiceInputBehavior.click + " longClick = " + voiceInputBehavior.longClick + " longClickTime = " + voiceInputBehavior.longClickTime + " textClick = " + voiceInputBehavior.textClick + " textChangeCount = " + voiceInputBehavior.textChangeCount + " textChangeTime = " + voiceInputBehavior.textChangeTime + " textChangeReturn = " + voiceInputBehavior.textChangeReturn + " voiceInputTime = " + voiceInputBehavior.voiceInputTime + " fail = " + voiceInputBehavior.fail);
        com.tencent.mm.sdk.c.b qcVar = new qc();
        qcVar.brq.action = 2;
        if (this.lIK) {
            qcVar.brq.dYY = 1;
        } else {
            qcVar.brq.dYY = 2;
        }
        qcVar.brq.bfz = this.lIG.getText().toString();
        com.tencent.mm.sdk.c.a.nhr.z(qcVar);
        be.cw(this.lIG);
        super.finish();
    }
}
