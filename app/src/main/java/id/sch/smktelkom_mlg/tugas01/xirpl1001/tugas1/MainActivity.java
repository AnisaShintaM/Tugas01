package id.sch.smktelkom_mlg.tugas01.xirpl1001.tugas1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    EditText etNama;
    Button bOk;
    android.widget.CheckBox cb1;
    android.widget.CheckBox cb2;
    TextView tvHasil, tvBisa;
    int nBisa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextnama);
        bOk = (Button) findViewById(R.id.buttonOK);
        cb1 = (android.widget.CheckBox) findViewById(R.id.checkBoxmat);
        cb2 = (android.widget.CheckBox) findViewById(R.id.checkBoxipa);
        cb1.setOnCheckedChangeListener(this);
        cb1.setOnCheckedChangeListener(this);
        tvHasil = (TextView) findViewById(R.id.textViewhasil);
        tvBisa = (TextView) findViewById(R.id.textViewBisa);

        bOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                doClick();

            }
        });
    }

    private void doClick() {
        String nama = etNama.getText().toString();
        String hasil = "Kelas Anda:\n";
        int startlen = hasil.length();
        if (cb1.isChecked()) hasil += cb1.getText() + "\n";
        if (cb2.isChecked()) hasil += cb2.getText() + "\n";
        if (hasil.length() == startlen) hasil += "Tidak ada pilihan";
        tvHasil.setText("Selamat Anda terdaftar dengan nama " + nama + "Mengambil Kelas " + hasil);
    }


    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        if (isChecked) nBisa += 1;
        else nBisa -= 1;

        tvBisa.setText("Kelas " + nBisa + " Terpilih");
    }
}

