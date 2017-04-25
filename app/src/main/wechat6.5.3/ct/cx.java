package ct;

import java.util.Iterator;

public final class cx {
    private final String a;

    public cx(String str) {
        if (str == null) {
            throw new NullPointerException();
        }
        this.a = str;
    }

    public final StringBuilder a(StringBuilder stringBuilder, Iterator<?> it) {
        Object next;
        if (it.hasNext()) {
            next = it.next();
            if (next != null) {
                stringBuilder.append(next.toString());
            }
        }
        while (it.hasNext()) {
            next = it.next();
            if (next != null) {
                stringBuilder.append(this.a);
                stringBuilder.append(next.toString());
            }
        }
        return stringBuilder;
    }
}
