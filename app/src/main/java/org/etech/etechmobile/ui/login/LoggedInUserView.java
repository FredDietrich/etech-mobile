package org.etech.etechmobile.ui.login;

import org.etech.etechmobile.entidades.Usuario;

/**
 * Class exposing authenticated user details to the UI.
 */
class LoggedInUserView {
    private Usuario usuarioLogado;
    LoggedInUserView(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    Usuario getUsuarioLogado() {
        return usuarioLogado;
    }
}