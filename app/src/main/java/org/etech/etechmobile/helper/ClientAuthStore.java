package org.etech.etechmobile.helper;

import android.content.Context;
import android.content.SharedPreferences;

import org.etech.etechmobile.R;

public class ClientAuthStore {

    private SharedPreferences prefs;
    private Context context;

    public ClientAuthStore(Context context) {
        this.context = context;
        this.prefs = context.getSharedPreferences(context.getString(R.string.login_prefs_key), Context.MODE_PRIVATE);
    }

    public int getCurrentUserId() {
        return prefs.getInt(context.getString(R.string.id_usuario_key), -1);
    }

}
