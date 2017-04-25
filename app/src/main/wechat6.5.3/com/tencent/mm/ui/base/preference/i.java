package com.tencent.mm.ui.base.preference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.mm.ui.base.preference.Preference.a;
import com.tencent.mm.ui.p;

public abstract class i extends p {
    private SharedPreferences cnm;
    private boolean fKT = false;
    public ListView gMx;
    private boolean kmp = false;
    public h ocZ;

    public abstract int Oo();

    public abstract boolean a(f fVar, Preference preference);

    protected final int getLayoutId() {
        return 2130904041;
    }

    public void onResume() {
        super.onResume();
        this.ocZ.notifyDataSetChanged();
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.cnm = NV(bzo().getPackageName() + "_preferences");
        this.ocZ = new h(this.nDR.nEl, this.cnm);
        this.gMx = (ListView) findViewById(16908298);
        this.ocZ.b(new a(this) {
            final /* synthetic */ i odp;

            {
                this.odp = r1;
            }

            public final boolean a(Preference preference, Object obj) {
                if (!this.odp.kmp && preference.isEnabled() && preference.odz) {
                    boolean z;
                    this.odp.kmp = true;
                    if (preference instanceof CheckBoxPreference) {
                        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) preference;
                        checkBoxPreference.ocf = checkBoxPreference.isChecked();
                        if (checkBoxPreference.odB) {
                            this.odp.cnm.edit().putBoolean(preference.dnU, checkBoxPreference.isChecked()).commit();
                        }
                        this.odp.fKT = true;
                        z = true;
                    } else {
                        z = false;
                    }
                    if (preference.dnU != null) {
                        this.odp.a(this.odp.ocZ, preference);
                    }
                    if (z) {
                        this.odp.ocZ.notifyDataSetChanged();
                    }
                    this.odp.kmp = false;
                    if (z) {
                        return true;
                    }
                }
                return false;
            }
        });
        int Oo = Oo();
        if (Oo != -1) {
            this.ocZ.addPreferencesFromResource(Oo);
        }
        this.gMx.setAdapter(this.ocZ);
        this.gMx.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ i odp;

            {
                this.odp = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= this.odp.gMx.getHeaderViewsCount()) {
                    final Preference preference = (Preference) this.odp.ocZ.getItem(i - this.odp.gMx.getHeaderViewsCount());
                    if (preference.isEnabled() && preference.odz && !(preference instanceof CheckBoxPreference)) {
                        if (preference instanceof DialogPreference) {
                            final DialogPreference dialogPreference = (DialogPreference) preference;
                            dialogPreference.showDialog();
                            dialogPreference.ocn = new DialogPreference.a(this) {
                                final /* synthetic */ AnonymousClass2 odq;

                                public final void bDc() {
                                    this.odq.odp.fKT = true;
                                    if (dialogPreference.odB) {
                                        this.odq.odp.cnm.edit().putString(preference.dnU, dialogPreference.getValue()).commit();
                                    }
                                    this.odq.odp.ocZ.notifyDataSetChanged();
                                }
                            };
                        }
                        if (preference instanceof EditPreference) {
                            final EditPreference editPreference = (EditPreference) preference;
                            editPreference.showDialog();
                            editPreference.ocp = new EditPreference.a(this) {
                                final /* synthetic */ AnonymousClass2 odq;

                                public final void bDc() {
                                    this.odq.odp.fKT = true;
                                    if (editPreference.odB) {
                                        this.odq.odp.cnm.edit().putString(preference.dnU, editPreference.value).commit();
                                    }
                                    this.odq.odp.ocZ.notifyDataSetChanged();
                                }
                            };
                        }
                        if (preference.dnU != null) {
                            this.odp.a(this.odp.ocZ, preference);
                        }
                    }
                }
            }
        });
        this.gMx.setOnItemLongClickListener(new OnItemLongClickListener(this) {
            final /* synthetic */ i odp;

            {
                this.odp = r1;
            }

            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i < this.odp.gMx.getHeaderViewsCount()) {
                    return false;
                }
                this.odp.ocZ.getItem(i - this.odp.gMx.getHeaderViewsCount());
                this.odp.ocZ;
                this.odp.gMx;
                return i.bDf();
            }
        });
    }

    public final boolean onContextItemSelected(MenuItem menuItem) {
        return super.onContextItemSelected(menuItem);
    }

    public static boolean bDf() {
        return false;
    }
}
