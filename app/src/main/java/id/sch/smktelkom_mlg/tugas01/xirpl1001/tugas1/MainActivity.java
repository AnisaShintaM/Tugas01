package id.sch.smktelkom_mlg.tugas01.xirpl1001.tugas1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    EditText etNama;
    Button bOk;
    android.widget.CheckBox cb1;
    android.widget.CheckBox cb2;
    android.widget.CheckBox cb3;
    RadioGroup rgJK;
    TextView tvHasil, tvBisa;
    Spinner spJam;
    int nBisa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextnama);
        spJam = (Spinner) findViewById(R.id.spinner);
        bOk = (Button) findViewById(R.id.buttonOK);
        rgJK = (RadioGroup) findViewById(R.id.RadioGroupJK);
        cb1 = (android.widget.CheckBox) findViewById(R.id.checkBoxmat);
        cb2 = (android.widget.CheckBox) findViewById(R.id.checkBoxipa);
        cb3 = (android.widget.CheckBox) findViewById(R.id.checkBoxbi);
        cb1.setOnCheckedChangeListener(this);
        cb2.setOnCheckedChangeListener(this);
        cb3.setOnCheckedChangeListener(this);
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
        String hasil = null;
        String jam = spJam.getSelectedItem().toString();
        String kelas = "Kelas:\n";

        int startlen = kelas.length();
        if (cb1.isChecked()) kelas += cb1.getText() + "\n";
        if (cb2.isChecked()) kelas += cb2.getText() + "\n";
        if (cb3.isChecked()) kelas += cb3.getText() + "\n";
        if (kelas.length() == startlen) kelas += "Tidak ada pilihan";

        if (rgJK.getCheckedRadioButtonId() != -1) {
            RadioButton rb = (RadioButton)
                    findViewById(rgJK.getCheckedRadioButtonId());
            hasil = rb.getText().toString();
        }
        if (nama.isEmpty()) {
            etNama.setError("Nama Belum Diisi");
        } else if (nama.length() < 3) {
            etNama.setError("Nama Minimal 3 Karakter");
        } else {
            etNama.setError(null);
        }

        tvHasil.setText("*****GANESHA OPERATION*****" + "\nSelamat Anda terdaftar dengan nama   :" + nama + "\n\nAnda Seorang   :" + hasil + "\nSelamat Anda terdaftar di " + kelas + "\nKami beritahukan bahwa, Anda harus masuk\n" + jam);
    }


    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        if (isChecked) nBisa += 1;
        else nBisa -= 1;
        tvBisa.setText("Kelas(" + nBisa + " Terpilih");
    }
}

