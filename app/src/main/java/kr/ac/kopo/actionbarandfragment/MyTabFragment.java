package kr.ac.kopo.actionbarandfragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

        if (tabName.equals("Spring"))
        {
            baseLayout.setBackgroundColor(Color.GREEN);
        }
        if (tabName.equals("Summer"))
        {
            baseLayout.setBackgroundColor(Color.CYAN);
        }
        if (tabName.equals("Fall"))
        {
            baseLayout.setBackgroundColor(Color.rgb(204,153,102));
        }

        return baseLayout; // 레이아웃을 리턴(출력)
    }
}
