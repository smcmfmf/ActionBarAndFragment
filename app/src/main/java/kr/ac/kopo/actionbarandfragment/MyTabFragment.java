package kr.ac.kopo.actionbarandfragment;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MyTabFragment extends Fragment {
    String tabName;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle data = getArguments(); // Fragment의 참조값을 반환함
        tabName = data.getString("tabName");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        LinearLayout baseLayout = new LinearLayout(super.getActivity()); // 메인 엑티비티의 참조값을 사용하여 리니어 레이아웃 객체를 생성
        baseLayout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT); // width, height
        baseLayout.setLayoutParams(params); // 정의한 레이아웃 설정을 사용함

        ImageView img1 = new ImageView(super.getActivity());
        img1.setImageResource(R.drawable.spring);
        img1.setAdjustViewBounds(true);

        baseLayout.addView(img1);

        if (tabName.equals("Spring"))
        {
            baseLayout.setBackgroundColor(Color.GREEN);
            img1.setImageResource(R.drawable.spring);
        }
        if (tabName.equals("Summer"))
        {
            baseLayout.setBackgroundColor(Color.CYAN);
            img1.setImageResource(R.drawable.summer);
        }
        if (tabName.equals("Fall"))
        {
            baseLayout.setBackgroundColor(Color.rgb(204,153,102));
            img1.setImageResource(R.drawable.fall);
        }

        return baseLayout; // 레이아웃을 리턴(출력)
    }
}
