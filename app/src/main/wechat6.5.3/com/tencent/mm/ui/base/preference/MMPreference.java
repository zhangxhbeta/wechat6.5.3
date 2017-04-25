package com.tencent.mm.ui.base.preference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference.a;

public abstract class MMPreference extends MMActivity {
    public SharedPreferences cnm;
    private boolean fKT = false;
    public ListView gMx;
    private boolean kmp = false;
    public h ocZ;

    public abstract int Oo();

    public abstract boolean a(f fVar, Preference preference);

    public int getLayoutId() {
        return 2130904055;
    }

    public boolean On() {
        return true;
    }

    public void onResume() {
        if (On()) {
            this.ocZ.notifyDataSetChanged();
        }
        super.onResume();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.cnm = getSharedPreferences(getPackageName() + "_preferences", 0);
        this.ocZ = a(this.cnm);
        this.gMx = (ListView) findViewById(16908298);
        int YA = YA();
        if (YA != -1) {
            this.gMx.addHeaderView(getLayoutInflater().inflate(YA, null));
        }
        View abc = abc();
        if (abc != null) {
            if (abc.getLayoutParams() != null) {
                abc.setLayoutParams(new LayoutParams(abc.getLayoutParams()));
            } else {
                v.e("MicroMsg.mmui.MMPreference", "[arthurdan.mmpreference] Notice!!! footer.getLayoutParams() is null!!!\n");
            }
            this.gMx.addFooterView(abc);
        }
        this.ocZ.b(new a(this) {
            final /* synthetic */ MMPreference oda;

            {
                this.oda = r1;
            }

            public final boolean a(Preference preference, Object obj) {
                if (!this.oda.kmp && preference.isEnabled() && preference.odz) {
                    boolean z;
                    this.oda.kmp = true;
                    if (preference instanceof CheckBoxPreference) {
                        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) preference;
                        checkBoxPreference.ocf = checkBoxPreference.isChecked();
                        if (checkBoxPreference.odB) {
                            this.oda.cnm.edit().putBoolean(preference.dnU, checkBoxPreference.isChecked()).commit();
                        }
                        this.oda.fKT = true;
                        z = true;
                    } else {
                        z = false;
                    }
                    if (preference.dnU != null) {
                        this.oda.a(this.oda.ocZ, preference);
                    }
                    if (z) {
                        this.oda.ocZ.notifyDataSetChanged();
                    }
                    this.oda.kmp = false;
                    if (z) {
                        return true;
                    }
                }
                return false;
            }
        });
        YA = Oo();
        if (YA != -1) {
            this.ocZ.addPreferencesFromResource(YA);
        }
        this.gMx.setAdapter(this.ocZ);
        this.gMx.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ MMPreference oda;

            {
                this.oda = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                final Preference preference = (Preference) adapterView.getAdapter().getItem(i);
                if (preference != null && preference.isEnabled() && preference.odz && !(preference instanceof CheckBoxPreference)) {
                    if (preference instanceof DialogPreference) {
                        final DialogPreference dialogPreference = (DialogPreference) preference;
                        dialogPreference.showDialog();
                        dialogPreference.ocn = new DialogPreference.a(this) {
                            final /* synthetic */ AnonymousClass2 odd;

                            public final void bDc() {
                                this.odd.oda.fKT = true;
                                if (dialogPreference.odB) {
                                    this.odd.oda.cnm.edit().putString(preference.dnU, dialogPreference.getValue()).commit();
                                }
                                this.odd.oda.ocZ.notifyDataSetChanged();
                            }
                        };
                    }
                    if (preference instanceof EditPreference) {
                        final EditPreference editPreference = (EditPreference) preference;
                        editPreference.showDialog();
                        editPreference.ocp = new EditPreference.a(this) {
                            final /* synthetic */ AnonymousClass2 odd;

                            public final void bDc() {
                                this.odd.oda.fKT = true;
                                if (editPreference.odB) {
                                    this.odd.oda.cnm.edit().putString(preference.dnU, editPreference.value).commit();
                                }
                                this.odd.oda.ocZ.notifyDataSetChanged();
                            }
                        };
                    }
                    if (preference.dnU != null) {
                        this.oda.a(this.oda.ocZ, preference);
                    }
                }
            }
        });
        this.gMx.setOnItemLongClickListener(new OnItemLongClickListener(this) {
            final /* synthetic */ MMPreference oda;

            {
                this.oda = r1;
            }

            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i >= this.oda.gMx.getHeaderViewsCount()) {
                    int headerViewsCount = i - this.oda.gMx.getHeaderViewsCount();
                    if (headerViewsCount >= this.oda.ocZ.getCount()) {
                        v.e("MicroMsg.mmui.MMPreference", "itemlongclick, outofindex, %d, %d", Integer.valueOf(headerViewsCount), Integer.valueOf(this.oda.ocZ.getCount()));
                    } else {
                        this.oda.ocZ.getItem(headerViewsCount);
                    }
                }
                return false;
            }
        });
        this.gMx.setOnScrollListener(new OnScrollListener(this) {
            final /* synthetic */ MMPreference oda;

            {
                this.oda = r1;
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
                if (1 == i) {
                    View currentFocus = this.oda.getCurrentFocus();
                    if (currentFocus != null) {
                        currentFocus.clearFocus();
                    }
                }
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return super.onContextItemSelected(menuItem);
    }

    public final void setSelection(int i) {
        this.gMx.setSelection(i);
    }

    public int YA() {
        return -1;
    }

    public View abc() {
        return null;
    }

    public h a(SharedPreferences sharedPreferences) {
        return new h(this, sharedPreferences);
    }
}
