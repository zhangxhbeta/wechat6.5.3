package com.tencent.mm.sdk.platformtools;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.lang.reflect.Field;

public final class a {
    public static void dC(Context context) {
        if (context != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
            if (inputMethodManager != null) {
                String[] strArr = new String[]{"mCurRootView", "mServedView", "mNextServedView"};
                for (int i = 0; i < 3; i++) {
                    try {
                        Field declaredField = inputMethodManager.getClass().getDeclaredField(strArr[i]);
                        if (!declaredField.isAccessible()) {
                            declaredField.setAccessible(true);
                        }
                        Object obj = declaredField.get(inputMethodManager);
                        if (obj != null && (obj instanceof View)) {
                            View view = (View) obj;
                            if (view.getContext() == context) {
                                declaredField.set(inputMethodManager, null);
                            } else {
                                v.d("MicroMsg.ActivityResourceRecycler", "fixInputMethodManagerLeak break, context is not suitable, get_context=" + view.getContext() + " dest_context=" + context);
                                return;
                            }
                        }
                    } catch (Throwable th) {
                        v.a("MicroMsg.ActivityResourceRecycler", th, SQLiteDatabase.KeyEmpty, new Object[0]);
                    }
                }
            }
        }
    }

    @TargetApi(17)
    public static void cu(View view) {
        if (view != null) {
            Drawable drawable;
            int i;
            try {
                view.setOnClickListener(null);
            } catch (Throwable e) {
                v.a("MicroMsg.Crash", e, "May cause dvmFindCatchBlock crash!", new Object[0]);
                throw ((IncompatibleClassChangeError) new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(e));
            } catch (Throwable th) {
            }
            try {
                view.setOnCreateContextMenuListener(null);
            } catch (Throwable e2) {
                v.a("MicroMsg.Crash", e2, "May cause dvmFindCatchBlock crash!", new Object[0]);
                throw ((IncompatibleClassChangeError) new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(e2));
            } catch (Throwable th2) {
            }
            try {
                view.setOnFocusChangeListener(null);
            } catch (Throwable e22) {
                v.a("MicroMsg.Crash", e22, "May cause dvmFindCatchBlock crash!", new Object[0]);
                throw ((IncompatibleClassChangeError) new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(e22));
            } catch (Throwable th3) {
            }
            try {
                view.setOnKeyListener(null);
            } catch (Throwable e222) {
                v.a("MicroMsg.Crash", e222, "May cause dvmFindCatchBlock crash!", new Object[0]);
                throw ((IncompatibleClassChangeError) new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(e222));
            } catch (Throwable th4) {
            }
            try {
                view.setOnLongClickListener(null);
            } catch (Throwable e2222) {
                v.a("MicroMsg.Crash", e2222, "May cause dvmFindCatchBlock crash!", new Object[0]);
                throw ((IncompatibleClassChangeError) new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(e2222));
            } catch (Throwable th5) {
            }
            try {
                view.setOnClickListener(null);
            } catch (Throwable e22222) {
                v.a("MicroMsg.Crash", e22222, "May cause dvmFindCatchBlock crash!", new Object[0]);
                throw ((IncompatibleClassChangeError) new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(e22222));
            } catch (Throwable th6) {
            }
            try {
                view.setOnTouchListener(null);
            } catch (Throwable e222222) {
                v.a("MicroMsg.Crash", e222222, "May cause dvmFindCatchBlock crash!", new Object[0]);
                throw ((IncompatibleClassChangeError) new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(e222222));
            } catch (Throwable th7) {
            }
            if (view.getBackground() != null) {
                view.getBackground().setCallback(null);
                view.setBackgroundDrawable(null);
            }
            if (view instanceof ImageView) {
                ImageView imageView = (ImageView) view;
                drawable = imageView.getDrawable();
                if (drawable != null) {
                    drawable.setCallback(null);
                }
                imageView.setImageDrawable(null);
                imageView.setImageBitmap(null);
            }
            if (view instanceof TextView) {
                ((TextView) view).setCompoundDrawables(null, null, null, null);
            }
            if (view instanceof TextView) {
                TextView textView = (TextView) view;
                textView.setCompoundDrawables(null, null, null, null);
                try {
                    if (VERSION.SDK_INT >= 17) {
                        textView.setCompoundDrawablesRelative(null, null, null, null);
                    }
                } catch (Exception e3) {
                } catch (Error e4) {
                }
            }
            if (view instanceof ImageButton) {
                ImageButton imageButton = (ImageButton) view;
                drawable = imageButton.getDrawable();
                if (drawable != null) {
                    drawable.setCallback(null);
                }
                imageButton.setImageDrawable(null);
                imageButton.setImageBitmap(null);
            }
            if (view instanceof ListView) {
                ListView listView = (ListView) view;
                if (view instanceof ViewGroup) {
                    int childCount = ((ViewGroup) view).getChildCount();
                    for (i = 0; i < childCount; i++) {
                        cu(((ViewGroup) view).getChildAt(i));
                    }
                }
                try {
                    listView.setAdapter(null);
                } catch (Throwable e2222222) {
                    v.a("MicroMsg.Crash", e2222222, "May cause dvmFindCatchBlock crash!", new Object[0]);
                    throw ((IncompatibleClassChangeError) new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(e2222222));
                } catch (Throwable th8) {
                }
                try {
                    listView.setOnScrollListener(null);
                } catch (Throwable e22222222) {
                    v.a("MicroMsg.Crash", e22222222, "May cause dvmFindCatchBlock crash!", new Object[0]);
                    throw ((IncompatibleClassChangeError) new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(e22222222));
                } catch (Throwable th9) {
                }
                try {
                    listView.setOnItemClickListener(null);
                } catch (Throwable e222222222) {
                    v.a("MicroMsg.Crash", e222222222, "May cause dvmFindCatchBlock crash!", new Object[0]);
                    throw ((IncompatibleClassChangeError) new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(e222222222));
                } catch (Throwable th10) {
                }
                try {
                    listView.setOnItemLongClickListener(null);
                } catch (Throwable e2222222222) {
                    v.a("MicroMsg.Crash", e2222222222, "May cause dvmFindCatchBlock crash!", new Object[0]);
                    throw ((IncompatibleClassChangeError) new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(e2222222222));
                } catch (Throwable th11) {
                }
                try {
                    listView.setOnItemSelectedListener(null);
                } catch (Throwable e22222222222) {
                    v.a("MicroMsg.Crash", e22222222222, "May cause dvmFindCatchBlock crash!", new Object[0]);
                    throw ((IncompatibleClassChangeError) new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(e22222222222));
                } catch (Throwable th12) {
                }
            }
            view.destroyDrawingCache();
            if (view instanceof ViewGroup) {
                i = ((ViewGroup) view).getChildCount();
                for (int i2 = 0; i2 < i; i2++) {
                    cu(((ViewGroup) view).getChildAt(i2));
                }
            }
        }
    }
}
