package com.tencent.mm.wallet_core.ui.formview;

import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.DatePicker;
import com.tencent.mm.model.k;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.g;
import com.tenpay.android.wechat.TenpaySecureEditText;
import java.text.DecimalFormat;
import java.util.Calendar;

final class b {
    private static int pjx = 0;
    private static int pjy = 0;

    static void a(TenpaySecureEditText tenpaySecureEditText, int i) {
        if (tenpaySecureEditText == null) {
            v.e("MicroMsg.FormatViewUtil", "hy: param error: no edit text view");
        } else if (i == 1) {
            tenpaySecureEditText.setIsPasswordFormat(true);
        } else if (i == 2) {
            tenpaySecureEditText.setIsSecurityAnswerFormat(true);
        } else if (i == 3) {
            tenpaySecureEditText.setIsCvvPaymentFormat(true);
        } else if (i == 4) {
            tenpaySecureEditText.setIsCvv4PaymentFormat(true);
        } else if (i == 5) {
            tenpaySecureEditText.setIsValidThru(true);
        } else if (i == 6) {
            tenpaySecureEditText.setIsBankcardFormat(true);
        } else if (i == 7) {
            tenpaySecureEditText.setIsMoneyAmountFormat(true);
        } else {
            tenpaySecureEditText.setIsCvv4PaymentFormat(false);
        }
    }

    public static void e(final MMActivity mMActivity, final WalletFormView walletFormView) {
        walletFormView.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Calendar instance = Calendar.getInstance();
                instance.setTimeInMillis(System.currentTimeMillis());
                instance.add(2, 1);
                b.pjx = instance.get(1);
                b.pjy = instance.get(2);
                DatePickerDialog datePickerDialog = (DatePickerDialog) walletFormView.getTag(2131755079);
                if (datePickerDialog == null) {
                    datePickerDialog = new g(mMActivity, new OnDateSetListener(this) {
                        final /* synthetic */ AnonymousClass1 pki;

                        {
                            this.pki = r1;
                        }

                        public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                            if (i >= b.pjx || i2 >= b.pjy) {
                                DecimalFormat decimalFormat = new DecimalFormat("00");
                                if (k.xT()) {
                                    walletFormView.setTag(decimalFormat.format((long) (i2 + 1)) + i);
                                } else {
                                    walletFormView.setTag(decimalFormat.format((long) i).substring(2) + decimalFormat.format((long) (i2 + 1)));
                                }
                                walletFormView.setText(decimalFormat.format((long) (i2 + 1)) + decimalFormat.format((long) i).substring(2));
                            } else {
                                com.tencent.mm.ui.base.g.A(mMActivity, mMActivity.getString(2131236172), null);
                            }
                            if (walletFormView.pkk != null) {
                                walletFormView.pkk.fc(walletFormView.Ou());
                            }
                        }
                    }, b.pjx, b.pjy, instance.get(5), instance.getTimeInMillis(), (byte) 0);
                    walletFormView.setTag(2131755079, datePickerDialog);
                    mMActivity.a(datePickerDialog);
                }
                datePickerDialog.show();
            }
        });
    }

    public static void b(MMActivity mMActivity, int i, int i2) {
        if (i != -1) {
            mMActivity.a(com.tencent.mm.wallet_core.ui.b.a(mMActivity, i, mMActivity.getResources().getString(i2), mMActivity.getResources().getString(2131234768), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }));
        }
    }
}
