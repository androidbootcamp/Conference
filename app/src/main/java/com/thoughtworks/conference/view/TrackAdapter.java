package com.thoughtworks.conference.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.thoughtworks.conference.R;
import com.thoughtworks.conference.viewmodel.SessionViewModel;

import java.util.List;


public class TrackAdapter extends BaseAdapter {

  private List<SessionViewModel> sessions;
  private final LayoutInflater inflater;

  public TrackAdapter(Context context, List<SessionViewModel> sessions) {
    this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    this.sessions = sessions;
  }

  @Override
  public int getCount() {
    return sessions.size();
  }

  @Override
  public Object getItem(int i) {
    return sessions.get(i);
  }

  @Override
  public long getItemId(int i) {
    return i;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    ViewHolder viewHolder = null;
    if(convertView == null){
      convertView = inflater.inflate(R.layout.session, parent, false);
      viewHolder = new ViewHolder();
      viewHolder.date = (TextView) convertView.findViewById(R.id.date);
      convertView.setTag(viewHolder);
    }

    viewHolder = (ViewHolder) convertView.getTag();
    SessionViewModel session = sessions.get(position);
    viewHolder.date.setText(session.getDisplayTime());
    return convertView;
  }

  protected class ViewHolder {
    TextView date;
  }
}