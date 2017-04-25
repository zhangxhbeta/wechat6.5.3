package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.preference.Preference.a;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import org.xmlpull.v1.XmlPullParser;

public class h extends BaseAdapter implements f {
    private final SharedPreferences cnm;
    private final Context context;
    private a ock;
    private final j odf;
    private final LinkedList<String> odg = new LinkedList();
    private final HashMap<String, Preference> odh = new HashMap();
    private final HashSet<String> odi = new HashSet();
    private final LinkedList<String> odj = new LinkedList();
    private final HashMap<String, Integer> odk = new HashMap();
    private final HashMap<String, String> odl = new HashMap();
    private int[] odm = new int[0];
    private boolean odn = false;
    private boolean odo = false;

    public h(Context context, SharedPreferences sharedPreferences) {
        this.odf = new j(context);
        this.context = context;
        this.cnm = sharedPreferences;
    }

    private static String c(Preference preference) {
        return preference.getClass().getName() + "L" + preference.odG + "W" + preference.odH;
    }

    private static String d(Preference preference) {
        if (preference.dnU == null || preference.dnU.length() <= 0) {
            return "_anonymous_pref@" + preference.hashCode();
        }
        return preference.dnU;
    }

    public final int indexOf(String str) {
        return this.odg.indexOf(str);
    }

    public final int Oy(String str) {
        if (this.odj == null) {
            return -1;
        }
        return this.odj.indexOf(str);
    }

    public final void a(Preference preference) {
        a(preference, -1);
    }

    public final void a(Preference preference, int i) {
        b(preference, i);
        if (!this.odn) {
            notifyDataSetChanged();
        }
    }

    private void b(Preference preference, int i) {
        String d = d(preference);
        this.odh.put(d, preference);
        LinkedList linkedList = this.odg;
        if (i == -1) {
            i = this.odg.size();
        }
        linkedList.add(i, d);
        if (!(this.odk.containsKey(c(preference)) || this.odo)) {
            this.odk.put(c(preference), Integer.valueOf(this.odk.size()));
        }
        if (preference.odC != null) {
            this.odl.put(preference.odC + "|" + preference.dnU, preference.dnU);
        }
    }

    public final Preference Ow(String str) {
        return (Preference) this.odh.get(str);
    }

    public final void aO(String str, boolean z) {
        if (z) {
            if (!this.odi.contains(str)) {
                this.odi.add(str);
            } else {
                return;
            }
        } else if (!this.odi.remove(str)) {
            return;
        }
        notifyDataSetChanged();
    }

    public final boolean b(Preference preference) {
        if (preference == null) {
            return false;
        }
        String d = d(preference);
        this.odg.remove(d);
        this.odh.remove(d);
        this.odi.remove(preference.dnU);
        notifyDataSetChanged();
        return true;
    }

    public final boolean Ox(String str) {
        return b(Ow(str));
    }

    public final void removeAll() {
        this.odj.clear();
        this.odh.clear();
        this.odg.clear();
        this.odi.clear();
        notifyDataSetChanged();
    }

    public final void addPreferencesFromResource(int i) {
        InflateException inflateException;
        this.odn = true;
        j jVar = this.odf;
        XmlPullParser xml = jVar.mContext.getResources().getXml(i);
        try {
            synchronized (jVar.GM) {
                AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                jVar.GM[0] = jVar.mContext;
                try {
                    int next = xml.next();
                    while (next != 2 && next != 1) {
                        next = xml.next();
                    }
                    if (next != 2) {
                        throw new InflateException(xml.getPositionDescription() + ": No start tag found!");
                    }
                    jVar.a(xml.getName(), asAttributeSet);
                    jVar.a(xml, (f) this, asAttributeSet);
                } catch (InflateException e) {
                    throw e;
                } catch (Throwable e2) {
                    inflateException = new InflateException(e2.getMessage());
                    inflateException.initCause(e2);
                    throw inflateException;
                } catch (Throwable e22) {
                    inflateException = new InflateException(xml.getPositionDescription() + ": " + e22.getMessage());
                    inflateException.initCause(e22);
                    throw inflateException;
                }
            }
            this.odn = false;
            notifyDataSetChanged();
        } finally {
            xml.close();
        }
    }

    public final void b(a aVar) {
        this.ock = aVar;
        notifyDataSetChanged();
    }

    private void bDe() {
        Collection hashSet = new HashSet();
        int i = 0;
        while (i < this.odj.size()) {
            Preference preference = (Preference) this.odh.get(this.odj.get(i));
            if ((preference instanceof PreferenceCategory) && be.kS(preference.dnU) && i != 0) {
                Preference preference2 = (Preference) this.odh.get(this.odj.get(i - 1));
                if (preference2 instanceof PreferenceCategory) {
                    if (be.kS(preference2.dnU) && (preference2.getTitle() == null || preference2.getTitle().toString().trim().length() <= 0)) {
                        hashSet.add(d(preference2));
                    } else if (be.kS(preference.dnU) && (preference.getTitle() == null || preference.getTitle().toString().trim().length() <= 0)) {
                        hashSet.add(d(preference));
                    }
                }
            }
            i++;
        }
        this.odj.removeAll(hashSet);
    }

    private static boolean wO(int i) {
        return i == 2130903996 || i == 2130904066 || i == 2130904067;
    }

    public void notifyDataSetChanged() {
        int i = 0;
        this.odj.clear();
        Iterator it = this.odg.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!this.odi.contains(str)) {
                if (this.odh.get(str) == null) {
                    v.e("MicroMsg.MMPreferenceAdapter", "not found pref by key " + str);
                } else {
                    this.odj.add(str);
                }
            }
        }
        if (!this.odj.isEmpty() && wO(((Preference) this.odh.get(this.odj.get(0))).odG)) {
            b(new PreferenceSmallCategory(this.context), 0);
        }
        bDe();
        this.odm = new int[this.odj.size()];
        if (this.odm.length > 0) {
            Preference preference;
            int[] iArr;
            if (this.odm.length == 1) {
                preference = (Preference) this.odh.get(this.odj.get(0));
                if (!wO(((Preference) this.odh.get(this.odj.get(0))).odG)) {
                    this.odm[0] = 4;
                } else if (preference instanceof CheckBoxPreference) {
                    iArr = this.odm;
                    iArr[0] = iArr[0] | 8;
                } else {
                    this.odm[0] = 3;
                }
                a((Preference) this.odh.get(this.odj.get(0)), this.cnm);
                super.notifyDataSetChanged();
                return;
            }
            while (i < this.odj.size()) {
                a((Preference) this.odh.get(this.odj.get(i)), this.cnm);
                preference = (Preference) this.odh.get(this.odj.get(i));
                int i2 = preference.odG;
                int i3;
                if (wO(i2)) {
                    if (preference instanceof CheckBoxPreference) {
                        iArr = this.odm;
                        iArr[i] = iArr[i] | 8;
                    } else if (i == 0) {
                        iArr = this.odm;
                        iArr[i] = iArr[i] | 1;
                    } else {
                        if (i == this.odj.size() - 1) {
                            iArr = this.odm;
                            iArr[i] = iArr[i] | 2;
                        }
                        i3 = ((Preference) this.odh.get(this.odj.get(i - 1))).odG;
                        if (i3 != 2130903996 || i3 == 2130904066 || i3 == 2130904067) {
                            iArr = this.odm;
                            iArr[i] = iArr[i] | 1;
                        }
                    }
                } else if (i2 != 2130904048) {
                    iArr = this.odm;
                    iArr[i] = iArr[i] | 4;
                    if (i != 0) {
                        i3 = ((Preference) this.odh.get(this.odj.get(i - 1))).odG;
                        if (wO(i3) || i3 == 2130904048) {
                            iArr = this.odm;
                            i2 = i - 1;
                            iArr[i2] = iArr[i2] | 2;
                        }
                    }
                } else if (i == 0) {
                    iArr = this.odm;
                    iArr[i] = iArr[i] | 4;
                } else {
                    iArr = this.odm;
                    iArr[i] = iArr[i] | 16;
                    i3 = ((Preference) this.odh.get(this.odj.get(i - 1))).odG;
                    if (i3 == 2130903996 || i3 == 2130904066 || i3 == 2130904067) {
                        iArr = this.odm;
                        i2 = i - 1;
                        iArr[i2] = iArr[i2] | 2;
                    }
                }
                i++;
            }
            super.notifyDataSetChanged();
        }
    }

    private static void a(Preference preference, SharedPreferences sharedPreferences) {
        if (preference instanceof CheckBoxPreference) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) preference;
            if (checkBoxPreference.odB) {
                checkBoxPreference.ocf = sharedPreferences.getBoolean(preference.dnU, ((CheckBoxPreference) preference).isChecked());
            }
        }
        if (preference instanceof DialogPreference) {
            DialogPreference dialogPreference = (DialogPreference) preference;
            if (dialogPreference.odB) {
                dialogPreference.setValue(sharedPreferences.getString(preference.dnU, null));
            }
        }
        if (preference instanceof EditPreference) {
            EditPreference editPreference = (EditPreference) preference;
            if (editPreference.odB) {
                editPreference.value = sharedPreferences.getString(preference.dnU, null);
                editPreference.setSummary(editPreference.value);
            }
        }
    }

    public int getCount() {
        return this.odj.size();
    }

    public Object getItem(int i) {
        return this.odh.get(this.odj.get(i));
    }

    public long getItemId(int i) {
        return 0;
    }

    public int getViewTypeCount() {
        if (!this.odo) {
            this.odo = true;
        }
        return Math.max(1, this.odk.size());
    }

    public int getItemViewType(int i) {
        Integer num = (Integer) this.odk.get(c((Preference) this.odh.get(this.odj.get(i))));
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        Preference preference = (Preference) this.odh.get(this.odj.get(i));
        if (preference instanceof CheckBoxPreference) {
            preference.a(this.ock);
        }
        if (!this.odk.containsKey(c(preference))) {
            view = null;
        }
        View view2 = preference.getView(view, viewGroup);
        int i2 = this.odm[i];
        View findViewById = view2.findViewById(2131755329);
        if (findViewById == null) {
            v.d("MicroMsg.MMPreferenceAdapter", "find content view error");
            return view2;
        }
        View findViewById2 = view2.findViewById(16908312);
        if ((i2 & 4) == 0) {
            int i3 = 0;
            int paddingLeft = findViewById.getPaddingLeft();
            int paddingRight = findViewById.getPaddingRight();
            int paddingTop = findViewById.getPaddingTop();
            int paddingBottom = findViewById.getPaddingBottom();
            int i4 = 2130839100;
            int paddingLeft2 = view2.getPaddingLeft();
            int paddingRight2 = view2.getPaddingRight();
            int paddingTop2 = view2.getPaddingTop();
            int paddingBottom2 = view2.getPaddingBottom();
            if ((i2 & 8) != 0) {
                if (i == this.odj.size() - 1 || (i == this.odj.size() - 2 && (getItem(this.odj.size() - 1) instanceof PreferenceCategory))) {
                    i4 = 2130838689;
                } else if ((i2 & 2) != 0) {
                    i4 = 2130838689;
                } else {
                    i4 = 2130838468;
                }
                i3 = i4;
                i4 = 2131690127;
            } else if ((i2 & 16) != 0 || (i2 & 2) == 0) {
                i3 = 2130838468;
            }
            findViewById.setBackgroundResource(i3);
            findViewById.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            if (findViewById2 != null) {
                findViewById2.setBackgroundResource(i3);
            }
            view2.setBackgroundResource(i4);
            view2.setPadding(paddingLeft2, paddingTop2, paddingRight2, paddingBottom2);
        }
        return view2;
    }
}
