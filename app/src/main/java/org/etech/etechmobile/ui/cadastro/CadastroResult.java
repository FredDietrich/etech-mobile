package org.etech.etechmobile.ui.cadastro;

import androidx.annotation.Nullable;

/**
 * Authentication result : success (user details) or error message.
 */
class CadastroResult {
    @Nullable
    private String success;
    @Nullable
    private Integer error;

    CadastroResult(@Nullable Integer error) {
        this.error = error;
    }

    CadastroResult(@Nullable String success) {
        this.success = success;
    }

    @Nullable
    String getSuccess() {
        return success;
    }

    @Nullable
    Integer getError() {
        return error;
    }
}