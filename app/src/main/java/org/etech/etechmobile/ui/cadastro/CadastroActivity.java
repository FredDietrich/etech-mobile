package org.etech.etechmobile.ui.cadastro;

import android.app.Activity;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.etech.etechmobile.databinding.ActivityCadastroBinding;
import org.etech.etechmobile.ui.login.LoginActivity;

public class CadastroActivity extends AppCompatActivity {

    private CadastroViewModel cadastroViewModel;
    private ActivityCadastroBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        getSupportActionBar().hide();

        super.onCreate(savedInstanceState);

        binding = ActivityCadastroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        cadastroViewModel = new ViewModelProvider(this, new CadastroViewModelFactory())
                .get(CadastroViewModel.class);

        final EditText usernameEditText = binding.editUsuario;
        final EditText nameEditText = binding.editNome;
        final EditText cpfEditText = binding.editCpf;
        final EditText passwordEditText = binding.editSenha;
        final EditText password2EditText = binding.editRepitasenha;
        final Button cadastroButton = binding.btCadastro;
        final Button loginButton = binding.btCadastroaux;

        cadastroViewModel.getLoginFormState().observe(this, new Observer<CadastroFormState>() {
            @Override
            public void onChanged(@Nullable CadastroFormState cadastroFormState) {
                if (cadastroFormState == null) {
                    return;
                }
                cadastroButton.setEnabled(cadastroFormState.isDataValid());
                if (cadastroFormState.getUsernameError() != null) {
                    usernameEditText.setError(getString(cadastroFormState.getUsernameError()));
                }
                if (cadastroFormState.getPasswordError() != null) {
                    passwordEditText.setError(getString(cadastroFormState.getPasswordError()));
                }
            }
        });

        cadastroViewModel.getLoginResult().observe(this, new Observer<CadastroResult>() {
            @Override
            public void onChanged(@Nullable CadastroResult loginResult) {
                if (loginResult == null) {
                    return;
                }
                if (loginResult.getError() != null) {
                    showCadastroFailed(loginResult.getError());
                }
                setResult(Activity.RESULT_OK);
                vaiProLogin();
                finish();
            }
        });

        TextWatcher afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }

            @Override
            public void afterTextChanged(Editable s) {
                cadastroViewModel.cadastroDataChanged(usernameEditText.getText().toString(),
                        nameEditText.getText().toString(),
                        cpfEditText.getText().toString(),
                        passwordEditText.getText().toString(),
                        password2EditText.getText().toString()
                        );
            }
        };
        usernameEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    cadastroViewModel.cadastro(binding.getRoot().getContext(),
                            usernameEditText.getText().toString(),
                            nameEditText.getText().toString(),
                            cpfEditText.getText().toString(),
                            passwordEditText.getText().toString());
                }
                return false;
            }
        });

        cadastroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cadastra(
                        usernameEditText.getText().toString(),
                        nameEditText.getText().toString(),
                        cpfEditText.getText().toString(),
                        passwordEditText.getText().toString()
                );
            }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vaiProLogin();
            }
        });
    }

    private void showCadastroFailed(@StringRes Integer errorString) {
        Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_SHORT).show();
    }

    private void vaiProLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    private void cadastra(String username, String name, String cpf, String password) {
        cadastroViewModel.cadastro(getApplicationContext(), username, name, cpf, password);
    }

}