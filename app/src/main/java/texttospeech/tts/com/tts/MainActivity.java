package texttospeech.tts.com.tts;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity {

    private static TextToSpeech tts;
    private  String utterString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        Bundle extras = getIntent().getExtras();

        if (getIntent().getAction() == "myaction") {
            tts = new TextToSpeech(this, ttsInitListener);
            utterString = extras.getString("text");
            Log.d("utter", utterString);



            speaktext(utterString);
        }


         

        //startService(new Intent( MainActivity.this,ttsbackground.class));
        //finish();


    }

    private TextToSpeech.OnInitListener ttsInitListener = new TextToSpeech.OnInitListener() {

        @Override
        public void onInit(int i) {

            //tts.setLanguage(Locale.ENGLISH);
            speaktext(utterString);
        }
    };

    private void speaktext(String sms) {
        tts.speak(sms, TextToSpeech.QUEUE_FLUSH, null);
        //  tts.speak(sms,0,null);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private TextToSpeech.OnUtteranceCompletedListener onUtteranceCompletedListener = new TextToSpeech.OnUtteranceCompletedListener() {
        @Override
        public void onUtteranceCompleted(String s) {
          //  finish();
        }
    };

}
