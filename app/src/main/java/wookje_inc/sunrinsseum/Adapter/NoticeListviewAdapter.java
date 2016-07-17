package wookje_inc.sunrinsseum.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import wookje_inc.sunrinsseum.Item.NoticeListviewitem;
import wookje_inc.sunrinsseum.R;

public class NoticeListviewAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private ArrayList<NoticeListviewitem> data;
    private int layout;

    public NoticeListviewAdapter(Context context, int layout, ArrayList<NoticeListviewitem> data) {
        this.inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.data=data;
        this.layout=layout;
    }

    @Override
    public int getCount() { return data.size(); }

    @Override
    public String getItem(int position) { return data.get(position).getName(); }

    @Override
    public long getItemId(int position) { return position; }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null) {
            convertView=inflater.inflate(layout,parent,false);
        }

        NoticeListviewitem noticeListviewitem = data.get(position);

        ImageView image = (ImageView)convertView.findViewById(R.id.notice_image);
        image.setImageResource(noticeListviewitem.getImage());

        TextView name = (TextView)convertView.findViewById(R.id.notice_name);
        name.setText(noticeListviewitem.getName());

        //TextView time = (TextView)convertView.findViewById(R.id.notice_time);
        //time.setText(noticeListviewitem.getTime());

        TextView msg = (TextView)convertView.findViewById(R.id.notice_msg);
        msg.setText(noticeListviewitem.getMsg());

        return convertView;
    }
}