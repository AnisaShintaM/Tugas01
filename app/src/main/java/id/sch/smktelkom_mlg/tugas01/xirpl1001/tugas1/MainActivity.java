package id.sch.smktelkom_mlg.tugas01.xirpl1001.tugas1;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    EditText etNama;
    EditText etTahun;
    Button bOk;
    TextView tvHasil, tvHasil2, tvHasil3, tvHasil4, tvHasil5;
    RadioGroup rgJK;
    CheckBox mat, ipa, bin;
    int nKelas;
    Spinner spJam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        etTahun = (EditText) findViewById(R.id.editTextTahun);

        bOk = (Button) findViewById(R.id.buttonOK);
        tvHasil = (TextView) findViewById(R.id.textViewhasil);

        rgJK = (RadioGroup) findViewById(R.id.RadioGroupJK);
        tvHasil2 = (TextView) findViewById(R.id.textViewhasil2);

        mat = (CheckBox) findViewById(R.id.checkBoxmat);
        ipa = (CheckBox) findViewById(R.id.checkBoxipa);
        bin = (CheckBox) findViewById(R.id.checkBoxbi);
        tvHasil3 = (TextView) findViewById(R.id.textViewhasil3);
        tvHasil5 = (TextView) findViewById(R.id.textViewkelas);

        mat.setOnCheckedChangeListener(this);
        ipa.setOnCheckedChangeListener(this);
        bin.setOnCheckedChangeListener(this);

        spJam = (Spinner) findViewById(R.id.spinner);
        tvHasil4 = (TextView) findViewById(R.id.textViewhasil4);

        bOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doProcess();
            }
        });
    }

    private void doProcess() {
        String kelas = "Kelas   : ";
        String hasil = null;
        String jam = spJam.getSelectedItem().toString();
        int startlen = kelas.length();

        tvHasil5.setText("Pilih Kelas Anda");
        if (mat.isChecked()) kelas += mat.getText() + "\n";
        if (ipa.isChecked()) kelas += ipa.getText() + "\n";
        if (bin.isChecked()) kelas += bin.getText() + "\n";
        if (kelas.length() == startlen) kelas += "Tidak ada pada Pilihan";

        if (rgJK.getCheckedRadioButtonId() != -1) {
            RadioButton rb = (RadioButton)
                    findViewById(rgJK.getCheckedRadioButtonId());
            hasil = rb.getText().toString();
        }
        if (hasil == null) {
            tvHasil2.setText("Silahkan Pilih Jenis Kelamin");
        } else {
            tvHasil2.setError(null);
        }
        if (isValid()) {
            String nama = etNama.getText().toString();
            int tahun = Integer.parseInt(etTahun.getText().toString());
            int usia = 2016 - tahun;
            tvHasil.setText("******GANESHA OPERATION*******" + "\nSelamat Anda terdaftar sebagai siswa Ganesha Operation" + "\ndengan data diri sebagai berikut " + "\n\nNama Lengkap   : " + nama + " \nUsia       :   " + usia + " tahun" +"\nAnda Terdaftar Di " + kelas + "Jenis Kelamin    : " + hasil + "\nKami Beritahukan, kelas dimulai " + jam + " WIB" +"\n\nTerimakasih Sudah Menjadi Bagian Dari GANESHA OPERATION");
        }
    }


    private boolean isValid() {
        boolean valid = true;

        String nama = etNama.getText().toString();
        String tahun = etTahun.getText().toString();

        if (nama.isEmpty()) {
            etNama.setError("Nama Belum di isi!");
            valid = false;
        } else if (nama.length() < 3) {
            etNama.setError("Nama minimal 3 karakter!");
            valid = false;
        } else {
            etNama.setError(null);
        }


        if (tahun.isEmpty()) {
            etTahun.setError("Tahun Kelahiran belum diisi!");
            valid = false;
        } else if (tahun.length() != 4) {
            etTahun.setError("Format Tahun kelahiran harus yyyy");
            valid = false;
        } else {
            etTahun.setError(null);
        }
        return valid;
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) nKelas += 1;
        else nKelas -= 1;
        tvHasil5.setText("Kelas(" + nKelas + " terpilih)");
    }
}
