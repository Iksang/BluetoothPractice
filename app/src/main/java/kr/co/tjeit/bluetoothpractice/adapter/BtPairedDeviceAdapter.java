package kr.co.tjeit.bluetoothpractice.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import kr.co.tjeit.bluetoothpractice.R;
import kr.co.tjeit.bluetoothpractice.data.BtDevice;

/**
 * Created by tjoeun on 2017-09-13.
 */

public class BtPairedDeviceAdapter extends ArrayAdapter<BtDevice> {

    Context mContext;
    List<BtDevice> mList;
    LayoutInflater inf;

    public BtPairedDeviceAdapter(Context context, List<BtDevice> list){
        super(context, R.layout.activity_device_list, list);

        mContext = context;
        mList = list;

        inf = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if(row == null){
            row = inf.inflate(R.layout.activity_device_list, null);
        }

        BtDevice data = mList.get(position);

        TextView deviceNameTxt = (TextView)row.findViewById(R.id.deviceNameTxt);
        TextView deviceAddressTxt = (TextView)row.findViewById(R.id.deviceAddressTxt);

        deviceNameTxt.setText(data.getDeviceName());
        deviceAddressTxt.setText(data.getDeviceAddress());

        return row;
    }
}

