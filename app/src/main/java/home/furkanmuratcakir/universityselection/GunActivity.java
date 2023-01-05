package home.furkanmuratcakir.universityselection;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class GunActivity extends AppCompatActivity {
    private static final String TAG = "GunActivity";
    private String time;
    private TextView text;
    private String yearE = "2021";
    private String monthE = "06";
    private String dayE = "26";
    private String hourE = "10";
    private String minuteE = "15";
    private String secondE = "00";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gun);
        Timer timer = new Timer("Display Timer");

        text = findViewById(R.id.timer);
        Activity activity = GunActivity.this;

        // texti 1er saniye aralıklarla değiştir
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            @SuppressLint("SimpleDateFormat")
                            DateFormat yearF = new SimpleDateFormat("yyyy");
                            DateFormat monthF = new SimpleDateFormat("MM");
                            DateFormat dayF = new SimpleDateFormat("dd");
                            DateFormat hourF = new SimpleDateFormat("HH");
                            DateFormat minuteF = new SimpleDateFormat("mm");
                            DateFormat secondF = new SimpleDateFormat("ss");
                            Calendar cali = Calendar.getInstance();
                            cali.getTime();
                            String year = yearF.format(cali.getTimeInMillis());
                            String month = monthF.format(cali.getTimeInMillis());
                            String day = dayF.format(cali.getTimeInMillis());
                            String hour = hourF.format(cali.getTimeInMillis());
                            String minute = minuteF.format(cali.getTimeInMillis());
                            String second = secondF.format(cali.getTimeInMillis());

                            time = timeCalculator(year, month, day, hour, minute, second);
                            text.setText(time);
                        }
                    });
            }
        };

        timer.scheduleAtFixedRate(timerTask, 1000,1000);

        ImageButton button = findViewById(R.id.geri_gun);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private String timeCalculator(String year, String month, String day, String hour, String minute, String second){
        String result;
        int restYear = Integer.parseInt(yearE) - Integer.parseInt(year);
        int restMonth = Integer.parseInt(monthE) - Integer.parseInt(month);
        int restDay = Integer.parseInt(dayE) - Integer.parseInt(day);
        int restHour = Integer.parseInt(hourE) - Integer.parseInt(hour);
        int restMinute = Integer.parseInt(minuteE) - Integer.parseInt(minute);
        int restSecond = Integer.parseInt(secondE) - Integer.parseInt(second);
        // 26 06   05 31
        long allInSecond = restYear*31556926 + restMonth*2629743 + restDay*86400 + restHour*3600 + restMinute*60 + restSecond;

        long allInDay = allInSecond/86400;
        allInSecond -= allInDay*86400;
        long allInHour = allInSecond/3600;
        allInSecond -= allInHour*3600;
        long allInMinute = allInSecond/60;
        allInSecond -= allInMinute*60;

        result = allInDay + "GÜN   " + allInHour + "SAAT   " + allInMinute + "DAKİKA   " + allInSecond + "SANİYE";
        return result;
    }
}