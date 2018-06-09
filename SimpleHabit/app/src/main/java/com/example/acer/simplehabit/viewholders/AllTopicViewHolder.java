package com.example.acer.simplehabit.viewholders;

import android.view.View;
import android.widget.TextView;

import com.example.acer.simplehabit.R;
import com.example.acer.simplehabit.data.vo.TopicVO;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Acer on 5/23/2018.
 */

public class AllTopicViewHolder extends BaseViewHolder<TopicVO>
{

    @BindView(R.id.tv_header_for_topic)
    TextView tvHeaderForTopic;
    @BindView(R.id.tv_brief_for_topic)
    TextView tvBriefForTopic;


    public AllTopicViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);

    }

    @Override
    public void setData(TopicVO data) {

        tvHeaderForTopic.setText(data.getTopicName());
        tvBriefForTopic.setText(data.getTopicDesc());
    }








    @Override
    public void onClick(View view) {

    }
}
