package home.furkanmuratcakir.universityselection;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class PuanActivity extends AppCompatActivity {
    private static final String TAG = "PuanActivity";
    private static final double tr = 3.3;
    private static final double mat = 3.3;
    private static final double sos = 3.4;
    private static final double fen = 3.4;
    private static final double obp_k = 0.6;

    private static final double amat = 3.0;
    private static final double afizik = 2.85;
    private static final double akimya = 3.07;
    private static final double abio = 3.07;

    private static final double aede = 3.0;
    private static final double atar1 = 2.88;
    private static final double acog1 = 3.33;
    private static final double atar2 = 2.91;
    private static final double acog2 = 2.91;

    private static final double afel = 3;
    private static final double adin = 3.33;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puan);

        try {

            EditText tr_doru = findViewById(R.id.tr_doru);
            EditText tr_yanlıs = findViewById(R.id.tr_yanlıs);
            EditText tr_net = findViewById(R.id.tr_net);

            EditText mat_doru = findViewById(R.id.mat_doru);
            EditText mat_yanlıs = findViewById(R.id.mat_yanlıs);
            EditText mat_net = findViewById(R.id.mat_net);

            EditText sosyal_doru = findViewById(R.id.sosyal_doru);
            EditText sosyal_yanlıs = findViewById(R.id.sosyal_yanlıs);
            EditText sosyal_net = findViewById(R.id.sosyal_net);

            EditText fen_doru = findViewById(R.id.fen_doru);
            EditText fen_yanlıs = findViewById(R.id.fen_yanlıs);
            EditText fen_net = findViewById(R.id.fen_net);

            setListeners(tr_doru);
            setListeners(tr_yanlıs);

            setListeners(mat_doru);
            setListeners(mat_yanlıs);

            setListeners(sosyal_doru);
            setListeners(sosyal_yanlıs);

            setListeners(fen_doru);
            setListeners(fen_yanlıs);


            EditText obp = findViewById(R.id.obp);
            TextView tyt_puan = findViewById(R.id.tyt_puan);

            Button btn_tyt = findViewById(R.id.tyt_hesapla);
            btn_tyt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Double.parseDouble(tr_doru.getText().toString()) > 40) {
                        tr_doru.setText(String.valueOf(40));
                    }
                    if (Double.parseDouble(tr_yanlıs.getText().toString()) > 40) {
                        tr_yanlıs.setText(String.valueOf(40));
                    }
                    if (Double.parseDouble(mat_doru.getText().toString()) > 40) {
                        mat_doru.setText(String.valueOf(40));
                    }
                    if (Double.parseDouble(mat_yanlıs.getText().toString()) > 40) {
                        mat_yanlıs.setText(String.valueOf(40));
                    }
                    if (Double.parseDouble(fen_doru.getText().toString()) > 20) {
                        fen_doru.setText(String.valueOf(20));
                    }
                    if (Double.parseDouble(fen_yanlıs.getText().toString()) > 20) {
                        fen_yanlıs.setText(String.valueOf(20));
                    }
                    if (Double.parseDouble(sosyal_doru.getText().toString()) > 20) {
                        sosyal_doru.setText(String.valueOf(20));
                    }
                    if (Double.parseDouble(sosyal_yanlıs.getText().toString()) > 20) {
                        sosyal_yanlıs.setText(String.valueOf(20));
                    }
                    tr_net.setText(String.valueOf(Integer.parseInt(tr_doru.getText().toString()) - Double.parseDouble(tr_yanlıs.getText().toString()) * 1 / 4));
                    mat_net.setText(String.valueOf(Integer.parseInt(mat_doru.getText().toString()) - Double.parseDouble(mat_yanlıs.getText().toString()) * 1 / 4));
                    sosyal_net.setText(String.valueOf(Integer.parseInt(sosyal_doru.getText().toString()) - Double.parseDouble(sosyal_yanlıs.getText().toString()) * 1 / 4));
                    fen_net.setText(String.valueOf(Integer.parseInt(fen_doru.getText().toString()) - Double.parseDouble(fen_yanlıs.getText().toString()) * 1 / 4));
                    // 1 int 1.0 double .8324
                    tyt_puan.setText(String.valueOf(Double.parseDouble(tr_net.getText().toString()) * tr
                            + Double.parseDouble(mat_net.getText().toString()) * mat
                            + Double.parseDouble(sosyal_net.getText().toString()) * sos
                            + Double.parseDouble(fen_net.getText().toString()) * fen
                            + 100
                            + Double.parseDouble(obp.getText().toString()) * obp_k + "00000000").substring(0, 6));
                }
            });

            TextView sıra1 = findViewById(R.id.sıra1);
            TextView sıra2 = findViewById(R.id.sıra2);
            TextView sıra3 = findViewById(R.id.sıra3);
            TextView sıra4 = findViewById(R.id.sıra4);
            TextView sıra5 = findViewById(R.id.sıra5);
            TextView sıra6 = findViewById(R.id.sıra6);
            TextView sıra7 = findViewById(R.id.sıra7);
            sıra5.setVisibility(View.INVISIBLE);
            sıra6.setVisibility(View.INVISIBLE);
            sıra7.setVisibility(View.INVISIBLE);

            EditText sıra1_doru = findViewById(R.id.sıra1_doru);
            EditText sıra1_yanlıs = findViewById(R.id.sıra1_yanlıs);
            EditText sıra1_net = findViewById(R.id.sıra1_net);

            EditText sıra2_doru = findViewById(R.id.sıra2_doru);
            EditText sıra2_yanlıs = findViewById(R.id.sıra2_yanlıs);
            EditText sıra2_net = findViewById(R.id.sıra2_net);

            EditText sıra3_doru = findViewById(R.id.sıra3_doru);
            EditText sıra3_yanlıs = findViewById(R.id.sıra3_yanlıs);
            EditText sıra3_net = findViewById(R.id.sıra3_net);

            EditText sıra4_doru = findViewById(R.id.sıra4_doru);
            EditText sıra4_yanlıs = findViewById(R.id.sıra4_yanlıs);
            EditText sıra4_net = findViewById(R.id.sıra4_net);

            EditText sıra5_doru = findViewById(R.id.sıra5_doru);
            EditText sıra5_yanlıs = findViewById(R.id.sıra5_yanlıs);
            EditText sıra5_net = findViewById(R.id.sıra5_net);

            EditText sıra6_doru = findViewById(R.id.sıra6_doru);
            EditText sıra6_yanlıs = findViewById(R.id.sıra6_yanlıs);
            EditText sıra6_net = findViewById(R.id.sıra6_net);

            EditText sıra7_doru = findViewById(R.id.sıra7_doru);
            EditText sıra7_yanlıs = findViewById(R.id.sıra7_yanlıs);
            EditText sıra7_net = findViewById(R.id.sıra7_net);

            setListeners(sıra1_doru);
            setListeners(sıra1_yanlıs);

            setListeners(sıra2_doru);
            setListeners(sıra2_yanlıs);

            setListeners(sıra3_doru);
            setListeners(sıra3_yanlıs);

            setListeners(sıra4_doru);
            setListeners(sıra4_yanlıs);

            setListeners(sıra5_doru);
            setListeners(sıra5_yanlıs);

            setListeners(sıra6_doru);
            setListeners(sıra6_yanlıs);

            setListeners(sıra7_doru);
            setListeners(sıra7_yanlıs);

            Button btn_ayt = findViewById(R.id.btn_ayt);
            TextView ayt_puan = findViewById(R.id.ayt_puan);
            Spinner spinner = findViewById(R.id.spinner);

            // spinnera çevirebilmesi için veriler verilir.
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.array, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);

            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    Log.d(TAG, "onItemSelected: " + position);
                    if (position == 0) {
                        sıra5.setVisibility(View.INVISIBLE);
                        sıra6.setVisibility(View.INVISIBLE);
                        sıra7.setVisibility(View.INVISIBLE);

                        sıra5_doru.setVisibility(View.INVISIBLE);
                        sıra5_yanlıs.setVisibility(View.INVISIBLE);
                        sıra5_net.setVisibility(View.INVISIBLE);

                        sıra6_doru.setVisibility(View.INVISIBLE);
                        sıra6_yanlıs.setVisibility(View.INVISIBLE);
                        sıra6_net.setVisibility(View.INVISIBLE);

                        sıra7_doru.setVisibility(View.INVISIBLE);
                        sıra7_yanlıs.setVisibility(View.INVISIBLE);
                        sıra7_net.setVisibility(View.INVISIBLE);

                        sıra1.setText("Matematik");
                        sıra2.setText("Fizik");
                        sıra3.setText("Kimya");
                        sıra4.setText("Biyoloji");

                        sıra1_doru.setText("0");
                        sıra2_doru.setText("0");
                        sıra3_doru.setText("0");
                        sıra4_doru.setText("0");

                        sıra1_yanlıs.setText("0");
                        sıra2_yanlıs.setText("0");
                        sıra3_yanlıs.setText("0");
                        sıra4_yanlıs.setText("0");

                        sıra1_net.setText("0");
                        sıra2_net.setText("0");
                        sıra3_net.setText("0");
                        sıra4_net.setText("0");
                    } else if (position == 1) {
                        sıra5.setVisibility(View.INVISIBLE);
                        sıra6.setVisibility(View.INVISIBLE);
                        sıra7.setVisibility(View.INVISIBLE);

                        sıra5_doru.setVisibility(View.INVISIBLE);
                        sıra5_yanlıs.setVisibility(View.INVISIBLE);
                        sıra5_net.setVisibility(View.INVISIBLE);

                        sıra6_doru.setVisibility(View.INVISIBLE);
                        sıra6_yanlıs.setVisibility(View.INVISIBLE);
                        sıra6_net.setVisibility(View.INVISIBLE);

                        sıra7_doru.setVisibility(View.INVISIBLE);
                        sıra7_yanlıs.setVisibility(View.INVISIBLE);
                        sıra7_net.setVisibility(View.INVISIBLE);

                        sıra1.setText("Edebiyat");
                        sıra2.setText("Matematik");
                        sıra3.setText("Tarih1");
                        sıra4.setText("Coğrafya1");

                        sıra1_doru.setText("0");
                        sıra2_doru.setText("0");
                        sıra3_doru.setText("0");
                        sıra4_doru.setText("0");

                        sıra1_yanlıs.setText("0");
                        sıra2_yanlıs.setText("0");
                        sıra3_yanlıs.setText("0");
                        sıra4_yanlıs.setText("0");

                        sıra1_net.setText("0");
                        sıra2_net.setText("0");
                        sıra3_net.setText("0");
                        sıra4_net.setText("0");
                    } else if (position == 2) {
                        sıra5.setVisibility(View.VISIBLE);
                        sıra6.setVisibility(View.VISIBLE);
                        sıra7.setVisibility(View.VISIBLE);

                        sıra5_doru.setVisibility(View.VISIBLE);
                        sıra5_yanlıs.setVisibility(View.VISIBLE);
                        sıra5_net.setVisibility(View.VISIBLE);

                        sıra6_doru.setVisibility(View.VISIBLE);
                        sıra6_yanlıs.setVisibility(View.VISIBLE);
                        sıra6_net.setVisibility(View.VISIBLE);

                        sıra7_doru.setVisibility(View.VISIBLE);
                        sıra7_yanlıs.setVisibility(View.VISIBLE);
                        sıra7_net.setVisibility(View.VISIBLE);

                        sıra1.setText("Edebiyat");
                        sıra2.setText("Tarih1");
                        sıra3.setText("Coğrafya1");
                        sıra4.setText("Tarih2");
                        sıra5.setText("Coğrafya2");
                        sıra6.setText("Felsefe");
                        sıra7.setText("Din K. ve Ahlak B.");

                        sıra1_doru.setText("0");
                        sıra2_doru.setText("0");
                        sıra3_doru.setText("0");
                        sıra4_doru.setText("0");
                        sıra5_doru.setText("0");
                        sıra6_doru.setText("0");
                        sıra7_doru.setText("0");

                        sıra1_yanlıs.setText("0");
                        sıra2_yanlıs.setText("0");
                        sıra3_yanlıs.setText("0");
                        sıra4_yanlıs.setText("0");
                        sıra5_yanlıs.setText("0");
                        sıra6_yanlıs.setText("0");
                        sıra7_yanlıs.setText("0");

                        sıra1_net.setText("0");
                        sıra2_net.setText("0");
                        sıra3_net.setText("0");
                        sıra4_net.setText("0");
                        sıra5_net.setText("0");
                        sıra6_net.setText("0");
                        sıra7_net.setText("0");
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            btn_ayt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    {
                        if (Double.parseDouble(tr_doru.getText().toString()) > 40) {
                            tr_doru.setText(String.valueOf(40));
                        }
                        if (Double.parseDouble(tr_yanlıs.getText().toString()) > 40) {
                            tr_yanlıs.setText(String.valueOf(40));
                        }
                        if (Double.parseDouble(mat_doru.getText().toString()) > 40) {
                            mat_doru.setText(String.valueOf(40));
                        }
                        if (Double.parseDouble(mat_yanlıs.getText().toString()) > 40) {
                            mat_yanlıs.setText(String.valueOf(40));
                        }
                        if (Double.parseDouble(fen_doru.getText().toString()) > 20) {
                            fen_doru.setText(String.valueOf(20));
                        }
                        if (Double.parseDouble(fen_yanlıs.getText().toString()) > 20) {
                            fen_yanlıs.setText(String.valueOf(20));
                        }
                        if (Double.parseDouble(sosyal_doru.getText().toString()) > 20) {
                            sosyal_doru.setText(String.valueOf(20));
                        }
                        if (Double.parseDouble(sosyal_yanlıs.getText().toString()) > 20) {
                            sosyal_yanlıs.setText(String.valueOf(20));
                        }
                        tr_net.setText(String.valueOf(Integer.parseInt(tr_doru.getText().toString()) - Double.parseDouble(tr_yanlıs.getText().toString()) * 1 / 4));
                        mat_net.setText(String.valueOf(Integer.parseInt(mat_doru.getText().toString()) - Double.parseDouble(mat_yanlıs.getText().toString()) * 1 / 4));
                        sosyal_net.setText(String.valueOf(Integer.parseInt(sosyal_doru.getText().toString()) - Double.parseDouble(sosyal_yanlıs.getText().toString()) * 1 / 4));
                        fen_net.setText(String.valueOf(Integer.parseInt(fen_doru.getText().toString()) - Double.parseDouble(fen_yanlıs.getText().toString()) * 1 / 4));

                        tyt_puan.setText(String.valueOf(Double.parseDouble(tr_net.getText().toString()) * tr
                                + Double.parseDouble(mat_net.getText().toString()) * mat
                                + Double.parseDouble(sosyal_net.getText().toString()) * sos
                                + Double.parseDouble(fen_net.getText().toString()) * fen
                                + 100
                                + Double.parseDouble(obp.getText().toString()) * obp_k + "00000000").substring(0, 6));
                    }

                    if (spinner.getSelectedItemId() == 0) {
                        if (Double.parseDouble(sıra1_doru.getText().toString()) > 40) {
                            sıra1_doru.setText(String.valueOf(40));
                        }
                        if (Double.parseDouble(sıra1_yanlıs.getText().toString()) > 40) {
                            sıra1_yanlıs.setText(String.valueOf(40));
                        }
                        if (Double.parseDouble(sıra2_doru.getText().toString()) > 14) {
                            sıra2_doru.setText(String.valueOf(14));
                        }
                        if (Double.parseDouble(sıra2_yanlıs.getText().toString()) > 14) {
                            sıra2_yanlıs.setText(String.valueOf(14));
                        }
                        if (Double.parseDouble(sıra3_doru.getText().toString()) > 13) {
                            sıra3_doru.setText(String.valueOf(13));
                        }
                        if (Double.parseDouble(sıra3_yanlıs.getText().toString()) > 13) {
                            sıra3_yanlıs.setText(String.valueOf(13));
                        }
                        if (Double.parseDouble(sıra4_doru.getText().toString()) > 13) {
                            sıra4_doru.setText(String.valueOf(13));
                        }
                        if (Double.parseDouble(sıra4_yanlıs.getText().toString()) > 13) {
                            sıra4_yanlıs.setText(String.valueOf(13));
                        }
                        sıra1_net.setText(String.valueOf(Integer.parseInt(sıra1_doru.getText().toString()) - Double.parseDouble(sıra1_yanlıs.getText().toString()) * 1 / 4));
                        sıra2_net.setText(String.valueOf(Integer.parseInt(sıra2_doru.getText().toString()) - Double.parseDouble(sıra2_yanlıs.getText().toString()) * 1 / 4));
                        sıra3_net.setText(String.valueOf(Integer.parseInt(sıra3_doru.getText().toString()) - Double.parseDouble(sıra3_yanlıs.getText().toString()) * 1 / 4));
                        sıra4_net.setText(String.valueOf(Integer.parseInt(sıra4_doru.getText().toString()) - Double.parseDouble(sıra4_yanlıs.getText().toString()) * 1 / 4));

                        String tyt = String.valueOf((Double.parseDouble(tr_net.getText().toString()) * tr
                                + Double.parseDouble(mat_net.getText().toString()) * mat
                                + Double.parseDouble(sosyal_net.getText().toString()) * sos
                                + Double.parseDouble(fen_net.getText().toString()) * fen));

                        ayt_puan.setText(String.valueOf(Double.parseDouble(tyt) * 4 / 10
                                + Double.parseDouble(sıra1_net.getText().toString()) * amat
                                + Double.parseDouble(sıra2_net.getText().toString()) * afizik
                                + Double.parseDouble(sıra3_net.getText().toString()) * akimya
                                + Double.parseDouble(sıra4_net.getText().toString()) * abio
                                + 100
                                + Double.parseDouble(obp.getText().toString()) * obp_k + "00000000").substring(0, 6));
                    } else if (spinner.getSelectedItemId() == 1) {
                        if (Double.parseDouble(sıra1_doru.getText().toString()) > 24) {
                            sıra1_doru.setText(String.valueOf(24));
                        }
                        if (Double.parseDouble(sıra1_yanlıs.getText().toString()) > 24) {
                            sıra1_yanlıs.setText(String.valueOf(24));
                        }
                        if (Double.parseDouble(sıra2_doru.getText().toString()) > 40) {
                            sıra2_doru.setText(String.valueOf(40));
                        }
                        if (Double.parseDouble(sıra2_yanlıs.getText().toString()) > 40) {
                            sıra2_yanlıs.setText(String.valueOf(40));
                        }
                        if (Double.parseDouble(sıra3_doru.getText().toString()) > 10) {
                            sıra3_doru.setText(String.valueOf(10));
                        }
                        if (Double.parseDouble(sıra3_yanlıs.getText().toString()) > 10) {
                            sıra3_yanlıs.setText(String.valueOf(10));
                        }
                        if (Double.parseDouble(sıra4_doru.getText().toString()) > 6) {
                            sıra4_doru.setText(String.valueOf(6));
                        }
                        if (Double.parseDouble(sıra4_yanlıs.getText().toString()) > 6) {
                            sıra4_yanlıs.setText(String.valueOf(6));
                        }

                        sıra1_net.setText(String.valueOf(Integer.parseInt(sıra1_doru.getText().toString()) - Double.parseDouble(sıra1_yanlıs.getText().toString()) * 1 / 4));
                        sıra2_net.setText(String.valueOf(Integer.parseInt(sıra2_doru.getText().toString()) - Double.parseDouble(sıra2_yanlıs.getText().toString()) * 1 / 4));
                        sıra3_net.setText(String.valueOf(Integer.parseInt(sıra3_doru.getText().toString()) - Double.parseDouble(sıra3_yanlıs.getText().toString()) * 1 / 4));
                        sıra4_net.setText(String.valueOf(Integer.parseInt(sıra4_doru.getText().toString()) - Double.parseDouble(sıra4_yanlıs.getText().toString()) * 1 / 4));

                        ayt_puan.setText(String.valueOf((Double.parseDouble(tr_net.getText().toString()) * tr
                                + Double.parseDouble(mat_net.getText().toString()) * mat
                                + Double.parseDouble(sosyal_net.getText().toString()) * sos
                                + Double.parseDouble(fen_net.getText().toString()) * fen) * 4 / 10
                                + Double.parseDouble(sıra1_net.getText().toString()) * aede
                                + Double.parseDouble(sıra2_net.getText().toString()) * amat
                                + Double.parseDouble(sıra3_net.getText().toString()) * atar1
                                + Double.parseDouble(sıra4_net.getText().toString()) * atar2
                                + 100
                                + Double.parseDouble(obp.getText().toString()) * obp_k + "00000000").substring(0, 6));
                    } else if (spinner.getSelectedItemId() == 2) {
                        if (Double.parseDouble(sıra1_doru.getText().toString()) > 24) {
                            sıra1_doru.setText(String.valueOf(24));
                        }
                        if (Double.parseDouble(sıra1_yanlıs.getText().toString()) > 24) {
                            sıra1_yanlıs.setText(String.valueOf(24));
                        }
                        if (Double.parseDouble(sıra2_doru.getText().toString()) > 10) {
                            sıra2_doru.setText(String.valueOf(10));
                        }
                        if (Double.parseDouble(sıra2_yanlıs.getText().toString()) > 10) {
                            sıra2_yanlıs.setText(String.valueOf(10));
                        }
                        if (Double.parseDouble(sıra3_doru.getText().toString()) > 6) {
                            sıra3_doru.setText(String.valueOf(6));
                        }
                        if (Double.parseDouble(sıra3_yanlıs.getText().toString()) > 6) {
                            sıra3_yanlıs.setText(String.valueOf(6));
                        }
                        if (Double.parseDouble(sıra4_doru.getText().toString()) > 11) {
                            sıra4_doru.setText(String.valueOf(11));
                        }
                        if (Double.parseDouble(sıra4_yanlıs.getText().toString()) > 11) {
                            sıra4_yanlıs.setText(String.valueOf(11));
                        }
                        if (Double.parseDouble(sıra5_doru.getText().toString()) > 11) {
                            sıra5_doru.setText(String.valueOf(11));
                        }
                        if (Double.parseDouble(sıra5_yanlıs.getText().toString()) > 11) {
                            sıra5_yanlıs.setText(String.valueOf(11));
                        }
                        if (Double.parseDouble(sıra6_doru.getText().toString()) > 12) {
                            sıra6_doru.setText(String.valueOf(12));
                        }
                        if (Double.parseDouble(sıra6_yanlıs.getText().toString()) > 12) {
                            sıra6_yanlıs.setText(String.valueOf(12));
                        }
                        if (Double.parseDouble(sıra7_doru.getText().toString()) > 6) {
                            sıra7_doru.setText(String.valueOf(6));
                        }
                        if (Double.parseDouble(sıra7_yanlıs.getText().toString()) > 6) {
                            sıra7_yanlıs.setText(String.valueOf(6));
                        }
                        sıra1_net.setText(String.valueOf(Integer.parseInt(sıra1_doru.getText().toString()) - Double.parseDouble(sıra1_yanlıs.getText().toString()) * 1 / 4));
                        sıra2_net.setText(String.valueOf(Integer.parseInt(sıra2_doru.getText().toString()) - Double.parseDouble(sıra2_yanlıs.getText().toString()) * 1 / 4));
                        sıra3_net.setText(String.valueOf(Integer.parseInt(sıra3_doru.getText().toString()) - Double.parseDouble(sıra3_yanlıs.getText().toString()) * 1 / 4));
                        sıra4_net.setText(String.valueOf(Integer.parseInt(sıra4_doru.getText().toString()) - Double.parseDouble(sıra4_yanlıs.getText().toString()) * 1 / 4));
                        sıra5_net.setText(String.valueOf(Integer.parseInt(sıra5_doru.getText().toString()) - Double.parseDouble(sıra5_yanlıs.getText().toString()) * 1 / 4));
                        sıra6_net.setText(String.valueOf(Integer.parseInt(sıra6_doru.getText().toString()) - Double.parseDouble(sıra6_yanlıs.getText().toString()) * 1 / 4));
                        sıra7_net.setText(String.valueOf(Integer.parseInt(sıra7_doru.getText().toString()) - Double.parseDouble(sıra7_yanlıs.getText().toString()) * 1 / 4));

                        ayt_puan.setText(String.valueOf((Double.parseDouble(tr_net.getText().toString()) * tr
                                + Double.parseDouble(mat_net.getText().toString()) * mat
                                + Double.parseDouble(sosyal_net.getText().toString()) * sos
                                + Double.parseDouble(fen_net.getText().toString()) * fen) * 4 / 10
                                + Double.parseDouble(sıra1_net.getText().toString()) * aede
                                + Double.parseDouble(sıra2_net.getText().toString()) * atar1
                                + Double.parseDouble(sıra3_net.getText().toString()) * acog1
                                + Double.parseDouble(sıra4_net.getText().toString()) * atar2
                                + Double.parseDouble(sıra5_net.getText().toString()) * acog2
                                + Double.parseDouble(sıra6_net.getText().toString()) * afel
                                + Double.parseDouble(sıra7_net.getText().toString()) * adin
                                + 100
                                + Double.parseDouble(obp.getText().toString()) * obp_k + "00000000").substring(0, 6));

                    }
                }
            });
        }catch (Exception e){
            Toast.makeText(this, "Doğru veya Yanlış sayısı boş bırakılamaz!", Toast.LENGTH_SHORT).show();
        }

        ConstraintLayout layout = findViewById(R.id.layout);
        layout.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                return true;
            }
        });

        ImageButton button = findViewById(R.id.geri_puan);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    void setListeners(EditText editText){

        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                // yazıyı silip yeniden yazmakla uğraşmamak için.
                if (editText.hasFocus()){
                    editText.setText("");
                }else if (!editText.hasFocus() && editText.getText().toString().equals("")){
                    editText.setText("0");
                }
            }
        });
    }
}