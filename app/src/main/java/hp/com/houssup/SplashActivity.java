package hp.com.houssup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.github.rahatarmanahmed.cpv.CircularProgressView;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import io.fabric.sdk.android.Fabric;


public class SplashActivity extends Activity {

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "WdCouOFRrRWzM12ruKnkPsfrZ";
    private static final String TWITTER_SECRET = "uI44TXPPk7J4rnsSrLemY8Uo93lPgcsZsEdFOfZT8hsiX6z5t4";



    //timer
    private static int SPLASH_TIME_OUT = 10000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));
        setContentView(R.layout.activity_splash);
;
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                CircularProgressView progressView = (CircularProgressView) findViewById(R.id.progress_view);
                progressView.startAnimation();
                Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(i);

                // close this activity
                finish();

            }
        }, SPLASH_TIME_OUT);
    }

}


