package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import java.util.ArrayList;

public final class f {

    public interface a {
        void y(ArrayList<o> arrayList);
    }

    static /* synthetic */ ArrayList e(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            arrayList.add(new o(cursor.getInt(cursor.getColumnIndex("_id")), cursor.getString(cursor.getColumnIndex("product_id")), cursor.getString(cursor.getColumnIndex("full_price")), cursor.getString(cursor.getColumnIndex("price_currency")), cursor.getString(cursor.getColumnIndex("price_amount")), cursor.getInt(cursor.getColumnIndex("product_state"))));
            cursor.moveToNext();
        }
        return arrayList;
    }

    public static void a(final Context context, final String[] strArr, final a aVar) {
        if (aVar == null || strArr == null || strArr.length == 0) {
            throw new IllegalArgumentException();
        }
        new AsyncTask<Void, Void, Cursor>() {
            protected final /* synthetic */ Object doInBackground(Object[] objArr) {
                return context.getContentResolver().query(Uri.parse("content://com.tencent.mm.plugin.gwallet.queryprovider"), null, null, strArr, null);
            }

            protected final /* synthetic */ void onPostExecute(Object obj) {
                Cursor cursor = (Cursor) obj;
                if (cursor == null || cursor.getCount() <= 0) {
                    ArrayList arrayList = new ArrayList();
                    for (String oVar : strArr) {
                        arrayList.add(new o(-1, oVar, "", "", "", 10237));
                    }
                    aVar.y(arrayList);
                } else {
                    cursor.moveToFirst();
                    ArrayList e = f.e(cursor);
                    cursor.close();
                    aVar.y(e);
                }
                super.onPostExecute(cursor);
            }
        }.execute(new Void[0]);
    }
}
