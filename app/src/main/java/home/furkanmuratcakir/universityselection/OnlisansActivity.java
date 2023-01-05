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

public class OnlisansActivity extends AppCompatActivity {

    private List<Item> mItemList = new ArrayList<>();
    private RecyclerViewAdapter mRecyclerViewAdapter;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onlisans);

        EditText editText = findViewById(R.id.eTextNameOn);
        Button btn = findViewById(R.id.btn_ara_on);
        mRecyclerView = findViewById(R.id.recyclerView_on);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        mRecyclerViewAdapter = new RecyclerViewAdapter(mItemList);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mRecyclerViewAdapter.makeOnLisansData(editText, getApplicationContext());
            }
        });

        ImageButton button = findViewById(R.id.geri_onlisans);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}