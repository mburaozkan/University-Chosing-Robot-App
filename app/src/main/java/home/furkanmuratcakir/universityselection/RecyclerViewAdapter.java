package home.furkanmuratcakir.universityselection;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder> {
    private static final String TAG = "RecyclerViewAdapter";
    private List<Item> mItemList;
    private DatabaseAccess databaseAccess;
    private List<String> mIdList = new ArrayList<>();
    private List<Item> mCpyList = new ArrayList<>();

    public RecyclerViewAdapter(List<Item> itemList) {
        mItemList = itemList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // item gibi bir sayfa oluştur.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        // item iiçindeki textviewlere verileri aktarmamızı sağlıyor
        holder.uni_adı.setText(mItemList.get(position).getUni_adı());
        holder.bolum.setText(mItemList.get(position).getBolum());
        holder.puan_turu.setText(mItemList.get(position).getPuan_turu());
        holder.kont.setText(mItemList.get(position).getKont());
        holder.taban_puan.setText(mItemList.get(position).getTaban_puan());
        holder.basarı_sıra.setText(mItemList.get(position).getBasarı_sıra());
        Log.d(TAG, "onBindViewHolder: " + mItemList.get(position).getBolum());
    }

    @Override
    public int getItemCount() {
        // item saysını adaptera belirtir.
        Log.d(TAG, "getItemCount: " + (mItemList != null && mItemList.size() != 0 ? mItemList.size() : 0));
        return (mItemList != null && mItemList.size() != 0 ? mItemList.size() : 0);
    }

    public void makeLisansData(EditText editText, Context context){
        try { // bölümlerden sonra id
            mIdList.clear();
            mItemList.clear();
            DatabaseAccess databaseAccess = DatabaseAccess.getInstance(context);
            databaseAccess.open();
            mIdList = databaseAccess.getData("lisansbolum", "bolum", editText.getText().toString(), 0);
            for (String s : mIdList) {
                mCpyList = databaseAccess.getItems("lisansvt", "Kategori_", s);
                mItemList.addAll(mCpyList);
            }

            databaseAccess.close();
            notifyDataSetChanged();
        }catch (Exception e){
            Log.d(TAG, "makeLisansData: " + e.getMessage());
        }
    }

    public void makeOnLisansData(EditText editText, Context context){
        try {
            // önce idleri toplayıp ardından itemleri toplar.
            mIdList.clear();
            mItemList.clear();
            DatabaseAccess databaseAccess = DatabaseAccess.getInstance(context);
            databaseAccess.open();
            mIdList = databaseAccess.getData("onlisansbolum", "bolum", editText.getText().toString(), 0);
            for (String s : mIdList) {
                mCpyList = databaseAccess.getItems("onlisansvt", "Kategori_", s);
                mItemList.addAll(mCpyList);
            }

            databaseAccess.close();
            // verilerin değiştiğini belirtiyor.
            notifyDataSetChanged();
        }catch (Exception e){
            Log.d(TAG, "makeOnLisansData: " + e.getMessage());
        }
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        // itemler için textviewler adaptera tanıtılır.
        private TextView uni_adı;
        private TextView bolum;
        private TextView puan_turu;
        private TextView kont;
        private TextView taban_puan;
        private TextView basarı_sıra;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            uni_adı = itemView.findViewById(R.id.uni_adı);
            bolum = itemView.findViewById(R.id.bolum);
            puan_turu = itemView.findViewById(R.id.puan_turu);
            kont = itemView.findViewById(R.id.kont);
            taban_puan = itemView.findViewById(R.id.taban_puan);
            basarı_sıra = itemView.findViewById(R.id.basarı_sıra);
        }
    }
}
