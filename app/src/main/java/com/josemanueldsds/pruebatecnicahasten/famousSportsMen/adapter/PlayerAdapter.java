package com.josemanueldsds.pruebatecnicahasten.famousSportsMen.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.josemanueldsds.pruebatecnicahasten.R;
import com.josemanueldsds.pruebatecnicahasten.http.models.Player;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * PlayerAdapter
 *
 * @author JoseManuel
 */
public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder> {

    private List<Player> playerList;

    public PlayerAdapter(List<Player> playerList) {
        this.playerList = playerList;
    }

    @NonNull
    @Override
    public PlayerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.player_item, parent, false);
        return new PlayerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerViewHolder holder, int position) {
        Player player = playerList.get(position);
        holder.name.setText(player.getName());
        holder.lastName.setText(player.getSurname());
        holder.birthday.setText(player.getDate());
        Picasso.get()
                .load(player.getImage())
                .placeholder(android.R.drawable.ic_menu_report_image)
                .into(holder.avatar);
    }

    @Override
    public int getItemCount() {
        return this.playerList.size();
    }

    public void updateDataSet(List<Player> players) {
        this.playerList = players;
        notifyDataSetChanged();
    }

    static class PlayerViewHolder extends RecyclerView.ViewHolder {

        AppCompatTextView name, lastName, birthday;
        AppCompatImageView avatar;

        PlayerViewHolder(View itemView) {
            super(itemView);
            avatar = itemView.findViewById(R.id.avatar);
            name = itemView.findViewById(R.id.name);
            lastName = itemView.findViewById(R.id.lastName);
            birthday = itemView.findViewById(R.id.birthday);
        }
    }
}
