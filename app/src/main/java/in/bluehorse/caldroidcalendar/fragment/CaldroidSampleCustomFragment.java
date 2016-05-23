package in.bluehorse.caldroidcalendar.fragment;

import com.roomorama.caldroid.CaldroidFragment;
import com.roomorama.caldroid.CaldroidGridAdapter;

import in.bluehorse.caldroidcalendar.adapter.CaldroidSampleCustomAdapter;


/**
 * Created by BLUEHORSE 123 on 5/23/2016.
 */
public class CaldroidSampleCustomFragment extends CaldroidFragment  {
    @Override
    public CaldroidGridAdapter getNewDatesGridAdapter(int month, int year) {
        // TODO Auto-generated method stub
        return new CaldroidSampleCustomAdapter(getActivity(), month, year, getCaldroidData(), extraData);
    }
}
