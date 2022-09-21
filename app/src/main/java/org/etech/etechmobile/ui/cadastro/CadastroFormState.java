package org.etech.etechmobile.ui.cadastro;

import androidx.annotation.Nullable;

/**
 * Data validation state of the cadastro form.
 */
class CadastroFormState {
    @Nullable
    private Integer usernameError;
    @Nullable
    private Integer passwordError;
    @Nullable
    private Integer nameError;

    @Nullable
    public Integer getNameError() {
        return nameError;
    }

    public void setNameError(@Nullable Integer nameError) {
        this.nameError = nameError;
    }

    @Nullable
    public Integer getCpfError() {
        return cpfError;
    }

    public void setCpfError(@Nullable Integer cpfError) {
        this.cpfError = cpfError;
    }

    @Nullable
    private Integer cpfError;
    private boolean isDataValid;

    CadastroFormState(@Nullable Integer usernameError, @Nullable Integer passwordError, @Nullable Integer nameError, @Nullable Integer cpfError) {
        this.usernameError = usernameError;
        this.passwordError = passwordError;
        this.nameError = nameError;
        this.cpfError = cpfError;
        this.isDataValid = false;
    }

    CadastroFormState(boolean isDataValid) {
        this.usernameError = null;
        this.passwordError = null;
        this.isDataValid = isDataValid;
    }

    @Nullable
    Integer getUsernameError() {
        return usernameError;
    }

    @Nullable
    Integer getPasswordError() {
        return passwordError;
    }

    boolean isDataValid() {
        return isDataValid;
    }
}