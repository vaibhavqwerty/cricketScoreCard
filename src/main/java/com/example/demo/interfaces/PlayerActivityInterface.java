package com.example.demo.interfaces;

import com.example.demo.dto.Player;

public interface PlayerActivityInterface {

    public Player addRun(int runs, Player player, boolean isExtra);

    public Player changeStatus(String newStatus,Player player);



}
