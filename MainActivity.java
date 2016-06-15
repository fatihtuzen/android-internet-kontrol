package ce.internet_kontrol;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

// bu projede import edilen nesnelerimiz aşağıda
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;
// import edilen nesneler bitiyor

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button kontrol = (Button) findViewById(R.id.kontrol);

        kontrol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(internet_kontrol())
                    Toast.makeText(MainActivity.this, "İnternet bağlantısı var - başarılı", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "İnternet bağlantısı yok - başarısız", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean internet_kontrol() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }
}
