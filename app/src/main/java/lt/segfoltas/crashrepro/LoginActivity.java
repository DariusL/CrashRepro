package lt.segfoltas.crashrepro;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

public class LoginActivity extends AppCompatActivity {

    private static final String REPO = "foo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new Firebase(REPO).authAnonymously(new Firebase.AuthResultHandler() {
            @Override
            public void onAuthenticated(AuthData authData) {
                Toast.makeText(LoginActivity.this, "authenticated", Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onAuthenticationError(FirebaseError firebaseError) {
                Toast.makeText(LoginActivity.this, "authentication failed", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
