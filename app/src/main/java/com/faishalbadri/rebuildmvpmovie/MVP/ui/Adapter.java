package com.faishalbadri.rebuildmvpmovie.MVP.ui;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.faishalbadri.rebuildmvpmovie.MVP.data.Pojo;
import com.faishalbadri.rebuildmvpmovie.MVP.ui.Adapter.ViewHolder;
import com.faishalbadri.rebuildmvpmovie.MVP.util.Server;
import com.faishalbadri.rebuildmvpmovie.R;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<ViewHolder> {

  Context context;
  List<Pojo.KategoriBean> data;
  ImageView img;


  public Adapter( Context context, List<Pojo.KategoriBean> data) {
    this.data = data;
    this.context = context;
  }

  @Override
  public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_item, null);
//    return new ViewHolder(view);
    View view = LayoutInflater.from(context).inflate(R.layout.data_item,parent,false);
    final ViewHolder viewHolder = new ViewHolder(view);
    return viewHolder;
  }

  @Override
  public void onBindViewHolder(ViewHolder holder, final int position) {
    final Pojo.KategoriBean listitem = data.get(position);
    holder.txtJudul.setText(listitem.getKategori_nama());
    holder.txtReview.setText(listitem.getId_kategori());
    Glide.with(context)
        .load(Server.BASE_IMG+listitem.getKategori_gambar())
        .apply(RequestOptions.circleCropTransform())
        .into(img);
    holder.cv.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        Toast.makeText(context, listitem.getKategori_nama(), Toast.LENGTH_SHORT).show();
      }
    });
  }

  @Override
  public int getItemCount() {
    return data.size();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.txtJudul)
    TextView txtJudul;
    @BindView(R.id.txtReview)
    TextView txtReview;
    @BindView(R.id.cv)
    CardView cv;

    public ViewHolder(View itemView) {
      super(itemView);
      ButterKnife.bind(this,itemView);
      img = (ImageView)itemView.findViewById(R.id.img);
    }
  }
}
