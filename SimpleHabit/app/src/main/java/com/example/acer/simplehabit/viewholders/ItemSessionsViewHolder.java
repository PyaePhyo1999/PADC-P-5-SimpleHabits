package com.example.acer.simplehabit.viewholders;

import android.view.View;
import android.widget.TextView;

import com.example.acer.simplehabit.R;
import com.example.acer.simplehabit.data.vo.SessionsVO;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Acer on 6/3/2018.
 */

public class ItemSessionsViewHolder extends BaseViewHolder<SessionsVO> {
    @BindView(R.id.tv_session_number)
    TextView tvSessionNumber;

    @BindView(R.id.tv_session_desc)
    TextView tvSessionDesc;

    @BindView(R.id.tv_session_time_taken)
    TextView tvSessionTimeTaken;

    public ItemSessionsViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    @Override
    public void setData(SessionsVO data) {
        tvSessionNumber.setText(data.getSessionId());
        tvSessionDesc.setText(data.getTitle());
        String  timeLength = data.getLengthInSecond()/60+":"+data.getLengthInSecond()%60;
        tvSessionTimeTaken.setText(timeLength);
    }



    @Override
    public void onClick(View view) {

    }
}
