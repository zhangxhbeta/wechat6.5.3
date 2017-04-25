package android.support.v4.content;

import android.content.Context;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class c<D> {
    public int dW;
    Context mContext;
    public boolean rm = false;
    public b<D> tj;
    public a<D> tk;
    public boolean tl = false;
    public boolean tm = true;
    public boolean tn = false;
    public boolean to = false;

    public interface a<D> {
    }

    public interface b<D> {
        void b(c<D> cVar, D d);
    }

    public c(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public final void deliverResult(D d) {
        if (this.tj != null) {
            this.tj.b(this, d);
        }
    }

    public final void a(b<D> bVar) {
        if (this.tj == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.tj != bVar) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.tj = null;
        }
    }

    public final void a(a<D> aVar) {
        if (this.tk == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.tk != aVar) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.tk = null;
        }
    }

    public void onStartLoading() {
    }

    public void onStopLoading() {
    }

    public void onReset() {
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        android.support.v4.e.c.a(this, stringBuilder);
        stringBuilder.append(" id=");
        stringBuilder.append(this.dW);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.dW);
        printWriter.print(" mListener=");
        printWriter.println(this.tj);
        if (this.rm || this.tn || this.to) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.rm);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.tn);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.to);
        }
        if (this.tl || this.tm) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.tl);
            printWriter.print(" mReset=");
            printWriter.println(this.tm);
        }
    }
}
