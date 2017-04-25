package com.tencent.mm.pluginsdk.c;

import com.tencent.mm.model.ag;
import com.tencent.mm.pluginsdk.i;

public interface c {
    i createApplication();

    ag createSubCore();

    b getContactWidgetFactory();
}
