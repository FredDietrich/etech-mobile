package org.etech.etechmobile;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavAction;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import org.etech.etechmobile.databinding.ActivityLojaBinding;

public class ProdutosActivity extends AppCompatActivity {

    private ActivityLojaBinding binding;
    private static final String ARG_ID_PRODUTO = "argidproduto";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getSupportActionBar().hide();

        super.onCreate(savedInstanceState);

        binding = ActivityLojaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_produtos, R.id.navigation_carrinho, R.id.navigation_cliente)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_produtos);
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_ID_PRODUTO, 198);
        navController.navigate(R.id.action_navigation_produtos_to_produtoFragment, bundle);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

}