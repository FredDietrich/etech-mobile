package org.etech.etechmobile.ui.cadastro;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import org.etech.etechmobile.R;
import org.etech.etechmobile.entidades.Usuario;
import org.etech.etechmobile.services.UsuarioService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CadastroViewModel extends ViewModel {

    private MutableLiveData<CadastroFormState> loginFormState = new MutableLiveData<>();
    private MutableLiveData<CadastroResult> cadastroResult = new MutableLiveData<>();

    LiveData<CadastroFormState> getLoginFormState() {
        return loginFormState;
    }

    LiveData<CadastroResult> getLoginResult() {
        return cadastroResult;
    }

    public void cadastro(Context context, String username, String name, String cpf, String password) {
        Usuario novoUsuario = new Usuario();
        novoUsuario.setLogin(username);
        novoUsuario.setNome(name);
        novoUsuario.setCpf(cpf);
        novoUsuario.setSenha(password);
        new UsuarioService(context).criaUsuario(novoUsuario, new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                if(response.body() != null) {
                    Usuario data = response.body();
                    cadastroResult.setValue(new CadastroResult(data.getNome()));
                } else {
                    cadastroResult.setValue(new CadastroResult(R.string.cadastro_failed));
                }
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                t.printStackTrace();
                cadastroResult.setValue(new CadastroResult(R.string.cadastro_failed));
            }
        });
    }

    public void cadastroDataChanged(String username, String name, String cpf, String password, String password2) {
        if (!isUserNameValid(username)) {
            loginFormState.setValue(new CadastroFormState(R.string.invalid_username, null, null, null));
        } else if (!isPasswordValid(password)) {
            loginFormState.setValue(new CadastroFormState(null, R.string.invalid_password, null, null));
        } else if (!isCpfValid(cpf)) {
            loginFormState.setValue(new CadastroFormState(null, null, null, R.string.cpf_error));
        } else if (!isUserNameValid(name)) {
            loginFormState.setValue(new CadastroFormState(null, null, R.string.name_error, null));
        } else if (!isSecondPasswordValid(password, password2)) {
            loginFormState.setValue(new CadastroFormState(null, R.string.different_passwords, null, null));
        } else {
            loginFormState.setValue(new CadastroFormState(true));
        }
    }

    private boolean isUserNameValid(String username) {
        return username != null && !username.trim().isEmpty();
    }

    private boolean isPasswordValid(String password) {
        return password != null && password.trim().length() >= 8;
    }

    private boolean isSecondPasswordValid(String password, String secondPassword) {
        if(password == null || password.trim() == "") {
            return true;
        }
        return password.trim().equals(secondPassword.trim());
    }

    private boolean isCpfValid(String cpf) {
        String cleanCpf = cpf.replaceAll("[^\\d]", "").trim();
        return cleanCpf.length() == 11;
    }
}