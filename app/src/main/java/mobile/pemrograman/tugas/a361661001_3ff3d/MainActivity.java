package mobile.pemrograman.tugas.a361661001_3ff3d;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {
    private LinearLayout.LayoutParams params;
    private boolean miring = false;
    private boolean tebal = false;
    @InjectView(R.id.textViewNama)
    TextView textViewNama;
    @InjectView(R.id.radioGroup)
    RadioGroup radioGroup;
    @InjectView(R.id.checkBoxCetakTebal)
    CheckBox checkBoxCetakTebal;
    @InjectView(R.id.checkBoxCetakMiring)
    CheckBox checkBoxCetakMiring;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.inject(this);

        radioGroup.clearCheck();

        params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButtonRataKiri:
                        params.gravity = Gravity.START;
                        textViewNama.setLayoutParams(params);
                        break;
                    case R.id.radioButtonRataTengah:
                        params.gravity = Gravity.CENTER;
                        textViewNama.setLayoutParams(params);
                        break;
                    case R.id.radioButtonRataKanan:
                        params.gravity = Gravity.END;
                        textViewNama.setLayoutParams(params);
                        break;
                }


            }
        });

        checkBoxCetakTebal.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean
                            isChecked) {
                        tebal = isChecked;
                        if (miring == true && tebal == true) {
                            textViewNama.setTypeface(null, Typeface.BOLD_ITALIC);
                        } else if (miring == true && tebal == false) {
                            textViewNama.setTypeface(null, Typeface.ITALIC);
                        } else if (miring == false && tebal == true) {
                            textViewNama.setTypeface(null, Typeface.BOLD);
                        } else {
                            textViewNama.setTypeface(null, Typeface.NORMAL);
                        }
                    }
                });

        checkBoxCetakMiring.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean
                            isChecked) {
                        miring = isChecked;
                        if (miring == true && tebal == true) {
                            textViewNama.setTypeface(null, Typeface.BOLD_ITALIC);
                        } else if (miring == true && tebal == false) {
                            textViewNama.setTypeface(null, Typeface.ITALIC);
                        } else if (miring == false && tebal == true) {
                            textViewNama.setTypeface(null, Typeface.BOLD);
                        } else {
                            textViewNama.setTypeface(null, Typeface.NORMAL);
                        }
                    }
                });
    }
}
