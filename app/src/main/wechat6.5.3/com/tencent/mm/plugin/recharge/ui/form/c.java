package com.tencent.mm.plugin.recharge.ui.form;

import android.content.Context;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AutoCompleteTextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.List;

public final class c {
    private static String TAG = "MicroMsg.CommonHintViewConfig";

    public static class b {
        public List<String[]> imT;
        public com.tencent.mm.plugin.recharge.model.a imU = null;
        public MallFormView iou = null;

        class AnonymousClass4 implements OnItemClickListener {
            final /* synthetic */ b iov;
            final /* synthetic */ d iow;
            final /* synthetic */ AutoCompleteTextView iox;

            public AnonymousClass4(b bVar, d dVar, AutoCompleteTextView autoCompleteTextView) {
                this.iov = bVar;
                this.iow = dVar;
                this.iox = autoCompleteTextView;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                this.iov.imU = this.iow.oH(i);
                if (this.iov.imU != null) {
                    v.d(c.TAG, "onItemClick record.record " + this.iov.imU.imk + ", record.name " + this.iov.imU.name);
                    this.iov.b(this.iov.imU);
                }
                this.iox.dismissDropDown();
            }
        }

        class AnonymousClass5 implements OnFocusChangeListener {
            final /* synthetic */ b iov;
            final /* synthetic */ AutoCompleteTextView iox;

            public AnonymousClass5(b bVar, AutoCompleteTextView autoCompleteTextView) {
                this.iov = bVar;
                this.iox = autoCompleteTextView;
            }

            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    this.iox.setHintTextColor(view.getContext().getResources().getColor(2131689639));
                    if (this.iov.imU != null && this.iov.imU.aYX == 2) {
                        this.iov.iou.aJx();
                        this.iov.imU = null;
                    }
                    if (be.kS(this.iox.getText().toString())) {
                        this.iox.showDropDown();
                    }
                }
            }
        }

        class AnonymousClass6 implements OnClickListener {
            final /* synthetic */ b iov;
            final /* synthetic */ AutoCompleteTextView iox;

            public AnonymousClass6(b bVar, AutoCompleteTextView autoCompleteTextView) {
                this.iov = bVar;
                this.iox = autoCompleteTextView;
            }

            public final void onClick(View view) {
                this.iox.requestFocus();
            }
        }

        public b(MallFormView mallFormView) {
            this.iou = mallFormView;
        }

        public static com.tencent.mm.plugin.recharge.model.a cp(Context context) {
            ak.yW();
            String str = (String) com.tencent.mm.model.c.vf().get(6, null);
            if (be.kS(str)) {
                return null;
            }
            return new com.tencent.mm.plugin.recharge.model.a(str, context.getString(2131236435), 1);
        }

        public final void b(com.tencent.mm.plugin.recharge.model.a aVar) {
            this.imU = aVar;
            if (aVar != null) {
                this.iou.ioz.setText(aVar.imk);
                this.iou.ioz.setSelection(this.iou.ioz.getText().length());
                v.d(c.TAG, "editTv.setText " + aVar.imk + ", name " + aVar.name + ", isInputValid " + this.iou.Ou());
                if (!be.kS(aVar.name) && this.iou.Ou() && com.tencent.mm.plugin.recharge.model.a.imi.equals(aVar.iml)) {
                    this.iou.ioB.setText(aVar.name);
                    return;
                } else {
                    this.iou.ioB.setText("");
                    return;
                }
            }
            this.iou.ioz.setText("");
            v.d(c.TAG, "editTv.setText null");
            this.iou.ioB.setText("");
        }
    }

    private static class a implements b {
        private a() {
        }

        public boolean a(MallFormView mallFormView) {
            return true;
        }

        public boolean aJv() {
            return false;
        }

        public String yw(String str) {
            return null;
        }
    }

    public static void b(MallFormView mallFormView) {
        if (mallFormView == null) {
            v.e(TAG, "hy: param error");
        } else {
            mallFormView.ioG = new a() {
                public final boolean a(MallFormView mallFormView) {
                    return PhoneNumberUtils.isGlobalPhoneNumber(com.tencent.mm.plugin.recharge.model.b.yt(mallFormView.getText().toString()));
                }

                public final boolean aJv() {
                    return true;
                }

                public final String yw(String str) {
                    return str == null ? "" : str.replaceAll(" ", "");
                }
            };
        }
    }
}
