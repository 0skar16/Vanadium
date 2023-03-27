package dev.ztech.vanadium.wasm.impl;

import dev.ztech.vanadium.api.base.Base;
import dev.ztech.vanadium.wasm.api.WASMApi;

public class WASMApiImpl implements WASMApi {

    @Override
    public void mc_log(String input) {
        Base.logger.logInfo(input);
    }
}
