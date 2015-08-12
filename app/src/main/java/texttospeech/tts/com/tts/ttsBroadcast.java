package texttospeech.tts.com.tts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.widget.Toast;

/**
 * Created by roshni on 8/10/2015.
 */
public class ttsBroadcast extends BroadcastReceiver {


    SmsManager mng = SmsManager.getDefault();

    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "sms recived", Toast.LENGTH_LONG).show();

        Bundle bnd = intent.getExtras();

        if (bnd != null) {

            Object[] smsOb = (Object[]) bnd.get("pdus");

            for (int i = 0; i < smsOb.length; i++) {

                SmsMessage msg = SmsMessage.createFromPdu((byte[]) smsOb[i]);
                String phnNo = msg.getOriginatingAddress();
                String senderNum = phnNo;
                String message = msg.getMessageBody();
                Toast.makeText(context, "senderNum: " + senderNum, Toast.LENGTH_LONG).show();

               Intent in = new Intent(context, MainActivity.class);
                in.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
               in.putExtra("text", String.valueOf(message));
                in.setAction("myaction");
               context.startActivity(in);

            }


        }
    }
}

