package in.bluehorse.caldroidcalendar.activity;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.roomorama.caldroid.CaldroidFragment;
import com.roomorama.caldroid.CaldroidListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;

import in.bluehorse.caldroidcalendar.R;
import in.bluehorse.caldroidcalendar.fragment.CaldroidSampleCustomFragment;
import in.bluehorse.caldroidcalendar.util.Event;

public class MainActivity extends AppCompatActivity {

    private CaldroidFragment caldroidFragment;
    private Bundle args;
    private Calendar cal;
    private Event e;
    private SimpleDateFormat formatter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
        onClick();
    }

    private void initialize() {
        e = new Event(1,"hi I am Sid");
        formatter = new SimpleDateFormat("dd MMM yyyy");
        /*caldroidFragment = new CaldroidFragment();*/
        caldroidFragment = new CaldroidSampleCustomFragment();
        args = new Bundle();
        cal = Calendar.getInstance();
        args.putInt(CaldroidFragment.MONTH, cal.get(Calendar.MONTH) + 1);
        args.putInt(CaldroidFragment.YEAR, cal.get(Calendar.YEAR));
        caldroidFragment.setArguments(args);

        FragmentTransaction t = getSupportFragmentManager().beginTransaction();
        t.replace(R.id.calendar1, caldroidFragment);
        t.commit();
    }

    private void onClick() {
      final CaldroidListener listener = new CaldroidListener() {
          @Override
          public void onSelectDate(Date date, View view) {
              Toast.makeText(getApplicationContext(),formatter.format(date),
                      Toast.LENGTH_SHORT).show();
          }
          @Override
          public void onChangeMonth(int month, int year) {
              String text = "month: " + month + " year: " + year;
              Toast.makeText(getApplicationContext(), text,
                      Toast.LENGTH_SHORT).show();
          }

          @Override
          public void onLongClickDate(Date date, View view) {
              Toast.makeText(getApplicationContext(),
                      "Long click ",
                      Toast.LENGTH_SHORT).show();
          }

          @Override
          public void onCaldroidViewCreated() {
              Toast.makeText(getApplicationContext(),
                      "Caldroid view is created",
                      Toast.LENGTH_SHORT).show();
          }
      };
        caldroidFragment.setCaldroidListener(listener);
    }
}
