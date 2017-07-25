package joshua.e_book;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import java.util.concurrent.CountDownLatch;

public class SplashActivity extends Activity {
    private final static String LOG_TAG = SplashActivity.class.getSimpleName();
    private final CountDownLatch timeoutLatch = new CountDownLatch(1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread myThread = new Thread (){
            @Override
            public void run() {
                try {
                    sleep(3000);
                    Intent intent = new Intent (getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        myThread.start();
    }
}
