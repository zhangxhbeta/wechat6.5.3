package com.tencent.mm.ui.tools;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.k.b;

public class MMTextInputUI extends MMActivity {
    private int caG;
    private int ewj;
    private TextView oTJ;
    private int oTK;
    private boolean oTL;
    private EditText ocq;

    static /* synthetic */ int a(MMTextInputUI mMTextInputUI, int i) {
        int i2 = mMTextInputUI.ewj + i;
        mMTextInputUI.ewj = i2;
        return i2;
    }

    public int getLayoutId() {
        return 2130903804;
    }

    private void goBack() {
        if (getIntent().getBooleanExtra("key_show_confirm", false)) {
            g.a(this.nDR.nEl, getString(2131234286), "", new OnClickListener(this) {
                final /* synthetic */ MMTextInputUI oTM;

                {
                    this.oTM = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.oTM.axg();
                    this.oTM.setResult(0);
                    this.oTM.finish();
                }
            }, null);
            return;
        }
        axg();
        setResult(0);
        finish();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (4 != i) {
            return super.onKeyDown(i, keyEvent);
        }
        v.i("MicroMsg.MMTextInputUI", "on back key down");
        goBack();
        return true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ocq = (EditText) findViewById(2131756934);
        this.oTJ = (TextView) findViewById(2131756935);
        this.ocq.setHint(be.ah(getIntent().getStringExtra("key_hint"), ""));
        this.ocq.append(be.ah(getIntent().getStringExtra("key_value"), ""));
        this.caG = getIntent().getIntExtra("key_max_count", -1) << 1;
        this.ewj = 0;
        this.oTK = Math.max(this.caG - 120, (this.caG * 9) / 10);
        this.oTL = getIntent().getBooleanExtra("key_nullable", false);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ MMTextInputUI oTM;

            {
                this.oTM = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.oTM.goBack();
                return false;
            }
        });
        a(0, getString(2131231065), new OnMenuItemClickListener(this) {
            final /* synthetic */ MMTextInputUI oTM;

            {
                this.oTM = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.oTM.s(this.oTM.ocq.getText());
                Intent intent = new Intent();
                intent.putExtra("key_result", this.oTM.ocq.getText());
                this.oTM.setResult(-1, intent);
                this.oTM.finish();
                return true;
            }
        }, b.nET);
        iT(this.oTL);
        if (!this.oTL || this.caG > 0) {
            this.ocq.addTextChangedListener(new TextWatcher(this) {
                final /* synthetic */ MMTextInputUI oTM;

                {
                    this.oTM = r1;
                }

                public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void afterTextChanged(Editable editable) {
                    boolean z = false;
                    String obj = editable.toString();
                    if (!this.oTM.oTL) {
                        if (obj.trim().length() > 0) {
                            this.oTM.iT(true);
                        } else {
                            this.oTM.iT(false);
                        }
                    }
                    if (this.oTM.caG > 0) {
                        this.oTM.ewj = 0;
                        for (int i = 0; i < obj.length(); i++) {
                            if (be.d(obj.charAt(i))) {
                                MMTextInputUI.a(this.oTM, 2);
                            } else {
                                MMTextInputUI.a(this.oTM, 1);
                            }
                        }
                        if (this.oTM.ewj >= this.oTM.oTK && this.oTM.ewj <= this.oTM.caG) {
                            this.oTM.iT(true);
                            this.oTM.oTJ.setVisibility(0);
                            this.oTM.oTJ.setTextColor(this.oTM.getResources().getColor(2131690070));
                            this.oTM.oTJ.setText(this.oTM.getString(2131235654, new Object[]{Integer.valueOf((this.oTM.caG - this.oTM.ewj) >> 1)}));
                        } else if (this.oTM.ewj > this.oTM.caG) {
                            this.oTM.iT(false);
                            this.oTM.oTJ.setVisibility(0);
                            this.oTM.oTJ.setTextColor(this.oTM.getResources().getColor(2131690071));
                            this.oTM.oTJ.setText(this.oTM.getString(2131235655, new Object[]{Integer.valueOf(((this.oTM.ewj - this.oTM.caG) >> 1) + 1)}));
                        } else {
                            MMTextInputUI mMTextInputUI = this.oTM;
                            if (this.oTM.oTL) {
                                z = true;
                            } else if (this.oTM.ewj > 0) {
                                z = true;
                            }
                            mMTextInputUI.iT(z);
                            this.oTM.oTJ.setVisibility(8);
                        }
                    }
                }
            });
        }
    }

    public void s(CharSequence charSequence) {
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }
}
