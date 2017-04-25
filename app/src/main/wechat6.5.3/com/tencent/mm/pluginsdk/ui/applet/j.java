package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.model.ak;
import com.tencent.mm.pluginsdk.model.m;
import com.tencent.mm.pluginsdk.ui.tools.i;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.LinkedList;
import junit.framework.Assert;

public final class j implements e {
    Context context;
    p dwg;
    EditText idd;
    LinkedList<Integer> ihY;
    h iji = null;
    View ijj;
    TextView ijl;
    String lJg;
    a lKL;
    LinkedList<String> lKM;
    boolean lKN = true;

    public interface a {
        void cr(boolean z);
    }

    public j(Context context, a aVar) {
        this.context = context;
        this.lKL = aVar;
    }

    final void onStart() {
        ak.vy().a(30, (e) this);
    }

    final void onStop() {
        ak.vy().b(30, (e) this);
        if (this.iji != null) {
            this.iji.dismiss();
            this.iji = null;
        }
    }

    public final void f(LinkedList<String> linkedList, LinkedList<Integer> linkedList2) {
        boolean z;
        Assert.assertTrue(linkedList.size() > 0);
        if (linkedList2.size() > 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        onStart();
        this.lKM = linkedList;
        this.ihY = linkedList2;
        this.ijj = View.inflate(this.context, 2130904345, null);
        String str = "MicroMsg.SendVerifyRequest";
        String str2 = "verifyTip is null: %b, length : %d, value : [%s]";
        Object[] objArr = new Object[3];
        if (this.lJg == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(this.lJg == null ? 0 : this.lJg.length());
        objArr[2] = this.lJg;
        v.i(str, str2, objArr);
        if (!be.kS(this.lJg)) {
            ((TextView) this.ijj.findViewById(2131759061)).setText(this.lJg);
        }
        this.idd = (EditText) this.ijj.findViewById(2131759062);
        this.ijl = (TextView) this.ijj.findViewById(2131756526);
        this.ijl.setVisibility(0);
        this.idd.setText(null);
        this.ijl.setText("50");
        this.idd.setFilters(i.lTR);
        this.idd.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ j lKO;

            {
                this.lKO = r1;
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                int length = 50 - editable.length();
                if (length < 0) {
                    length = 0;
                }
                if (this.lKO.ijl != null) {
                    this.lKO.ijl.setText(String.valueOf(length));
                }
            }
        });
        this.iji = g.a(this.context, this.context.getString(2131234925), this.ijj, new OnClickListener(this) {
            final /* synthetic */ j lKO;

            {
                this.lKO = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                if (this.lKO.iji != null) {
                    this.lKO.iji.dismiss();
                    this.lKO.iji = null;
                }
                new ah(new com.tencent.mm.sdk.platformtools.ah.a(this) {
                    final /* synthetic */ AnonymousClass2 lKP;

                    {
                        this.lKP = r1;
                    }

                    public final boolean oU() {
                        if (this.lKP.lKO.ijj != null) {
                            j jVar = this.lKP.lKO;
                            String trim = this.lKP.lKO.idd.getText().toString().trim();
                            Context context = jVar.context;
                            jVar.context.getString(2131231164);
                            jVar.dwg = g.a(context, jVar.context.getString(2131234922), true, new OnCancelListener(jVar) {
                                final /* synthetic */ j lKO;

                                {
                                    this.lKO = r1;
                                }

                                public final void onCancel(DialogInterface dialogInterface) {
                                    this.lKO.onStop();
                                    if (this.lKO.lKL != null) {
                                        this.lKO.lKL.cr(false);
                                    }
                                }
                            });
                            ak.vy().a(new m(2, jVar.lKM, jVar.ihY, trim, SQLiteDatabase.KeyEmpty), 0);
                        }
                        return false;
                    }
                }, false).ea(500);
            }
        }, new OnClickListener(this) {
            final /* synthetic */ j lKO;

            {
                this.lKO = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                if (this.lKO.iji != null) {
                    this.lKO.iji.dismiss();
                    this.lKO.iji = null;
                }
                this.lKO.onStop();
                if (this.lKO.lKL != null) {
                    this.lKO.lKL.cr(false);
                }
            }
        });
        if (this.iji == null) {
            onStop();
        }
        this.idd.post(new Runnable(this) {
            final /* synthetic */ j lKO;

            {
                this.lKO = r1;
            }

            public final void run() {
                if (this.lKO.context instanceof MMActivity) {
                    ((MMActivity) this.lKO.context).aJs();
                }
            }
        });
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() != 30) {
            v.w("MicroMsg.SendVerifyRequest", "not expected scene,  type = " + kVar.getType());
            return;
        }
        v.d("MicroMsg.SendVerifyRequest", "onSceneEnd, errType = " + i + ", errCode = " + i2);
        if (this.dwg != null) {
            this.dwg.dismiss();
            this.dwg = null;
        }
        onStop();
        if (i == 0 && i2 == 0) {
            if (this.lKN) {
                g.bf(this.context, this.context.getString(2131234921));
            }
            this.lKL.cr(true);
            return;
        }
        if (i == 4 && i2 == -34) {
            str = this.context.getString(2131232851);
        } else if (i == 4 && i2 == -94) {
            str = this.context.getString(2131232852);
        } else if (!(i == 4 && i2 == -24 && !be.kS(str))) {
            str = this.context.getString(2131234920);
        }
        if (this.lKN) {
            Toast.makeText(this.context, str, 1).show();
        }
        this.lKL.cr(false);
    }
}
