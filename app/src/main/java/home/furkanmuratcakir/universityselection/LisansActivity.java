package home.furkanmuratcakir.universityselection;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class LisansActivity extends AppCompatActivity {
    private static final String TAG = "LisansActivity";
    private List<Item> mItemList = new ArrayList<>();

    private RecyclerViewAdapter mRecyclerViewAdapter;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lisans);

        EditText editText = findViewById(R.id.eTextName);
        Button btn = findViewById(R.id.btn_ara);
        mRecyclerView = findViewById(R.id.recyclerView);

        // Itemler için manager ayarlama.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        // adapter oluşturuldu.
        mRecyclerViewAdapter = new RecyclerViewAdapter(mItemList);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRecyclerViewAdapter.makeLisansData(editText, getApplicationContext());
            }
        });

        ImageButton button = findViewById(R.id.geri_lisans);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // activity i bitirir.
                finish();
            }
        });

    }
}